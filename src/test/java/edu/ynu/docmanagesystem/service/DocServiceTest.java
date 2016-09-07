package edu.ynu.docmanagesystem.service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-service.xml", "classpath:spring/applicationContext-transaction.xml" })
public class DocServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private DocService docService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Rollback(false)
	public void testStoreFileToDB() {
		byte[] bytes = "sdfsdfsd".getBytes();


	}

	@Test
	public void testTransferDocToPdf() throws Exception {
		// File file = new File("I:\\院校选择.doc");
		InputStream inputStream = new FileInputStream("I:/院校选择.doc");
		OutputStream outputStream = new FileOutputStream("I:/院校选择.swf");
		docService.transferDocToPdf(inputStream, "doc", outputStream);
		outputStream.flush();
		outputStream.close();
		inputStream.close();
	}

	@Test
	public void testTransferPdfToSwf() throws Exception {
		// InputStream transferPdfToSwf =
		// docService.transferPdfToSwf("I:/院校选择.pdf");
	}

	@Test
	@Rollback(false)
	public void testInsertSwfToDb() throws Exception {
		InputStream fileInputStream = new FileInputStream("I:/院校选择.swf");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] bs = new byte[1024];
		int len = -1;
		while ((len = fileInputStream.read(bs)) != -1) {
			bos.write(bs, 0, len);
		}
		byte b[] = bos.toByteArray();
		bos.close();
		fileInputStream.close();
		docService.insertSwfToDb(b, 3);

	}

}
