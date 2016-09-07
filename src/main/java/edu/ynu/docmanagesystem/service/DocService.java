package edu.ynu.docmanagesystem.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import edu.ynu.docmanagesystem.poExtend.DocDetail;
import edu.ynu.docmanagesystem.poExtend.DocList;

public interface DocService {

	/**
	 * description: 把上传的文件存储到数据库中
	 * @param userId
	 * @param file
	 * @param resourceTypeId
	 * @param resourceDescribe
	 * @return 资源id
	 */
	Integer storeFileToDB(Integer userId, byte[] bytes, String originalFilename, String formName,
	        Integer resourceTypeId, String resourceDescribe, double size);

	/**
	 * description: 转换文档为PDF
	 * @param inputStream 源文档输入流
	 * @param extendName 源文档扩展名
	 * @return 目标PDF输出流
	 */
	void transferDocToPdf(InputStream inputStream, String extendName, OutputStream outputStream);

	/**
	 * description: 将pdf转换成swf
	 * @param pdfPath pdf文件的路径
	 * @return 目标swf的输入流
	 * @throws Exception 
	 */
	InputStream transferPdfToSwf(String pdfPath) throws Exception;

	/**
	 * description: 把生成的swf文件存入资源的字段中
	 * @param resourceId 资源id
	 * @return 
	 */
	Integer insertSwfToDb(byte[] swf, Integer resourceId);

	/**
	 * description: 返回所有符合条件的资源列表
	 * @param sectionId 部门 Id
	 * @param resouceType 资源类型
	 * @return 资源列表
	 */
	List<DocList> findAllresouceList(Integer sectionId, Integer resourceType);

	/**
	 * description: 增加阅读次数
	 * @param resouceId 
	 */
	void updateViewCount(Integer resourceId);

	/**
	 * description: 查询文档的详细信息
	 * @param resouceId
	 * @return 
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
	DocDetail findDocDetailById(Integer resourceId) throws IOException;

	List<Integer> findResourceTypeByManageredUserId(Integer userId);

	Integer deleteResourceById(Integer resourceId);

	Integer findResourceTypeByResourceId(Integer resourceId);

	Map<Object, Object> findDocFileByResourceId(Integer resourceId);

}
