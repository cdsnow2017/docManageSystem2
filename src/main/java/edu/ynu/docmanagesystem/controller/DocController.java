package edu.ynu.docmanagesystem.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.ynu.docmanagesystem.po.Section;
import edu.ynu.docmanagesystem.poExtend.DocDetail;
import edu.ynu.docmanagesystem.poExtend.DocList;
import edu.ynu.docmanagesystem.service.DocService;
import edu.ynu.docmanagesystem.service.UserService;
import edu.ynu.docmanagesystem.util.DocTransferConcurrent;
import edu.ynu.docmanagesystem.util.LogType;

@Controller
@RequestMapping(value = "/doc")
public class DocController {
	@Autowired
	private DocService docService;

	@Autowired
	private UserService userService;

	@RequestMapping("/upload")
	public String upLoad(HttpServletRequest request, MultipartFile file) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		Integer userId = (Integer) subject.getPrincipal();
		String resourceDescribe = request.getParameter("resourceDescribe");
		String resourceTypeId = request.getParameter("resourceTypeId");
		String originalFilename = file.getOriginalFilename();
		// 将上传的文件存储到数据库中
		Integer resourceId = docService.storeFileToDB(userId, file.getBytes(), originalFilename,
		        FilenameUtils.getExtension(originalFilename), Integer.valueOf(resourceTypeId), resourceDescribe,
		        file.getSize() / 1024.0);
		// 开启多线程后台转swf
		Thread docTransferConcurrent = new DocTransferConcurrent(file.getInputStream(),
		        FilenameUtils.getExtension(originalFilename), docService, resourceId);
		docTransferConcurrent.start();
		userService.insertLog(userId, resourceId, LogType.upload);
		return "redirect:/index.html#/docList";
	}

	@RequestMapping("/findDocList")
	@ResponseBody
	public Map<Object, Object> findDocList(Integer sectionId, Integer resouceType) {
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("data", docService.findAllresouceList(sectionId, resouceType));
		return hashMap;
	}

	@RequestMapping("/viewDocDetail")
	@ResponseBody
	public DocDetail viewDocDetail(Integer resourceId) throws IOException {
		Subject subject = SecurityUtils.getSubject();
		Integer userId = (Integer) subject.getPrincipal();
		Integer resourceType = docService.findResourceTypeByResourceId(resourceId);
		if (!subject.isPermitted(resourceType + ":1")) {
			return null;
		}
		userService.insertLog(userId, resourceId, LogType.read);
		docService.updateViewCount(resourceId);
		return docService.findDocDetailById(resourceId);
	}

	@RequestMapping("/findDocListManagered")
	@ResponseBody
	public Map<Object, Object> findDocListManagered() throws IOException {
		Subject subject = SecurityUtils.getSubject();
		Integer userId = (Integer) subject.getPrincipal();
		System.out.println("哈哈哈" + subject.hasRole("2"));
		List<Integer> ids = docService.findResourceTypeByManageredUserId(userId);
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("data", docService.findAllresouceList(null, ids.get(0)));
		return hashMap;
	}

	@RequestMapping("/deleteResource")
	@ResponseBody
	public Integer deleteResource(Integer resourceId) throws IOException {
		return docService.deleteResourceById(resourceId);
	}

	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(Integer resourceId, HttpServletResponse response) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		Integer userId = (Integer) subject.getPrincipal();
		Integer resourceType = docService.findResourceTypeByResourceId(resourceId);
		if (!subject.isPermitted(resourceType + ":2")) {
			response.sendRedirect("/index.html#/unAuthority");
			return null;
		} else {
			userService.insertLog(userId, resourceId, LogType.download);
			// 获取文件路径，返回用户要下载的文件
			Map<Object, Object> doc = docService.findDocFileByResourceId(resourceId);
			String fileName = new String(((String) doc.get("fileName")).getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDispositionFormData("attachment", fileName);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return new ResponseEntity<byte[]>((byte[]) doc.get("bytes"), headers, HttpStatus.CREATED);
		}
	}

}
