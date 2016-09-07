package edu.ynu.docmanagesystem.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;
import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artofsolving.jodconverter.DefaultDocumentFormatRegistry;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.DocumentFamily;
import com.artofsolving.jodconverter.DocumentFormat;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

import edu.ynu.docmanagesystem.mapper.ResourceMapper;
import edu.ynu.docmanagesystem.mapper.ResourcetypeMapper;
import edu.ynu.docmanagesystem.mapperExtend.DocExtendMapper;
import edu.ynu.docmanagesystem.po.ResourceWithBLOBs;
import edu.ynu.docmanagesystem.po.Resourcetype;
import edu.ynu.docmanagesystem.po.ResourcetypeExample;
import edu.ynu.docmanagesystem.poExtend.DocDetail;
import edu.ynu.docmanagesystem.poExtend.DocList;
import edu.ynu.docmanagesystem.service.DocService;

@Service
public class DocServiceImpl implements DocService {

	@Autowired
	private ResourceMapper resourceMapper;

	@Autowired
	private DocExtendMapper docExtendMapper;

	@Autowired
	private ResourcetypeMapper resourcetypeMapper;

	// swftools文件路径
	// private final static String exePath = "I:/swftools/pdf2swf.exe";
	private final static String exePath = "pdf2swf";

	// 存放swf文件的临时文件夹路径，用于前台显示
	private final static String swfTmp = "/home/cdsnow2017/JavaWorkspace/doc-main/src/main/webapp/tmp/";

	@Override
	public Integer storeFileToDB(Integer userId, byte[] bytes, String originalFilename, String formName,
			Integer resourceTypeId, String resourceDescribe, double size) {
		ResourceWithBLOBs resource = new ResourceWithBLOBs();
		resource.setUserid(userId);
		resource.setContain(bytes);
		resource.setOriginalfilename(originalFilename);
		resource.setResourcetypeid(resourceTypeId);
		resource.setDescription(resourceDescribe);
		resource.setSize(size);
		resource.setFormname(formName);
		resource.setTime(new Date());
		System.out.println(resource.toString());
		resourceMapper.insertSelective(resource);
		return resource.getResourceid();
	}

	@Override
	public void transferDocToPdf(InputStream inputStream, String extendName, OutputStream outputStream) {
		OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
		DefaultDocumentFormatRegistry defaultDocumentFormatRegistry = new DefaultDocumentFormatRegistry();
		final DocumentFormat docx = new DocumentFormat("Microsoft Word docx", DocumentFamily.TEXT, "application/msword",
				"docx");
		docx.setExportFilter(DocumentFamily.TEXT, "MS Word docx");
		final DocumentFormat pptx = new DocumentFormat("Microsoft PowerPoint pptx", DocumentFamily.PRESENTATION,
				"application/vnd.ms-powerpoint", "pptx");
		pptx.setExportFilter(DocumentFamily.PRESENTATION, "MS PowerPoint pptx");
		final DocumentFormat xlsx = new DocumentFormat("Microsoft Excel xlsx", DocumentFamily.SPREADSHEET,
				"application/vnd.ms-excel", "xlsx");
		xlsx.setExportFilter(DocumentFamily.SPREADSHEET, "MS Excel xlsx");
		defaultDocumentFormatRegistry.addDocumentFormat(pptx);
		defaultDocumentFormatRegistry.addDocumentFormat(docx);
		defaultDocumentFormatRegistry.addDocumentFormat(xlsx);
		DocumentFormat inputFormat = defaultDocumentFormatRegistry.getFormatByFileExtension(extendName);
		DocumentFormat outputFormat = defaultDocumentFormatRegistry.getFormatByFileExtension("pdf");
		try {
			connection.connect();
			DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
			converter.convert(inputStream, inputFormat, outputStream, outputFormat);
		} catch (ConnectException cex) {
			cex.printStackTrace();
		} finally {
			// close the connection
			if (connection != null) {
				connection.disconnect();
				connection = null;
			}
		}

	}

	@Override
	public InputStream transferPdfToSwf(String pdfPath) throws Exception {
		// 文件路径
		String filePath = pdfPath.substring(0, pdfPath.lastIndexOf("/"));
		// 文件名，不带后缀
		String fileName = pdfPath.substring((filePath.length() + 1), pdfPath.lastIndexOf("."));
		Process pro = null;
		if (isWindowsSystem()) {
			// 如果是windows系统
			// 命令行命令
			String cmd = exePath + " \"" + pdfPath + "\" -o \"" + filePath + "/" + fileName + ".swf\""
					+ " -s flashversion=9";
			// Runtime执行后返回创建的进程对象
			pro = Runtime.getRuntime().exec(cmd);
		} else {

			String[] cmd = new String[3];
			cmd[0] = exePath;
			cmd[1] = pdfPath;
			cmd[2] = filePath + "/" + fileName + ".swf";
			// Runtime执行后返回创建的进程对象
			pro = Runtime.getRuntime().exec(cmd);
		}
		pro.waitFor();
		// pro.destroy();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(
				new FileInputStream(filePath + "/" + fileName + ".swf"));
		return bufferedInputStream;
	}

	@Override
	public Integer insertSwfToDb(byte[] swf, Integer resourceId) {
		ResourceWithBLOBs resourceWithBLOBs = new ResourceWithBLOBs();
		resourceWithBLOBs.setSwf(swf);
		resourceWithBLOBs.setResourceid(resourceId);
		return resourceMapper.updateByPrimaryKeySelective(resourceWithBLOBs);

	}

	private static boolean isWindowsSystem() {
		String p = System.getProperty("os.name");
		return p.toLowerCase().indexOf("windows") >= 0 ? true : false;
	}

	@Override
	public List<DocList> findAllresouceList(Integer sectionId, Integer resouceType) {
		return docExtendMapper.findAllresouceList(sectionId, resouceType);

	}

	@Override
	public void updateViewCount(Integer resouceId) {
		docExtendMapper.updateViewCount(resouceId);
	}

	@Override
	public DocDetail findDocDetailById(Integer resouceId) throws IOException {

		DocDetail findDocDetailById = docExtendMapper.findDocDetailById(resouceId);
		byte[] findSwfFileById = (byte[]) docExtendMapper.findSwfFileById(resouceId);
		String swfFileTmpName = UUID.randomUUID() + "";
		OutputStream fileOutputStream = new FileOutputStream(swfTmp + swfFileTmpName + ".swf");
		OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		bufferedOutputStream.write(findSwfFileById);
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
		findDocDetailById.setSwfPath("tmp/" + swfFileTmpName + ".swf");
		return findDocDetailById;
	}

	@Override
	public List<Integer> findResourceTypeByManageredUserId(Integer userId) {
		ResourcetypeExample resourcetypeExample = new ResourcetypeExample();
		resourcetypeExample.or().andResourcemanageridEqualTo(userId);
		List<Resourcetype> selectByExample = resourcetypeMapper.selectByExample(resourcetypeExample);
		return selectByExample.stream().map(e -> e.getResourcetypeid()).collect(Collectors.toList());

	}

	@Override
	public Integer deleteResourceById(Integer resourceId) {
		return resourceMapper.deleteByPrimaryKey(resourceId);

	}

	@Override
	public Integer findResourceTypeByResourceId(Integer resourceId) {
		return docExtendMapper.findResourceTypeByResourceId(resourceId);
	}

	@Override
	public Map<Object, Object> findDocFileByResourceId(Integer resourceId) {
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("fileName", docExtendMapper.findDocNameById(resourceId));
		hashMap.put("bytes", docExtendMapper.findDocFileById(resourceId));
		return hashMap;
	}

}
