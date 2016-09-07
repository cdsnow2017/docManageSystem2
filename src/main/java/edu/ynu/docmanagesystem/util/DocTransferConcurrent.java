package edu.ynu.docmanagesystem.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import edu.ynu.docmanagesystem.service.DocService;

public class DocTransferConcurrent extends Thread {
	private InputStream inputStream;
	private String extendName;
	private DocService docService;
	private static String dirTemp = "/home/cdsnow2017/JavaWorkspace/doc-main/src/main/webapp/pdfTemp/";
	private Integer resourceId;

	public DocTransferConcurrent(InputStream inputStream, String extendName, DocService docService,
	        Integer resourceId) {
		super();
		this.inputStream = inputStream;
		this.extendName = extendName;
		this.docService = docService;
		this.resourceId = resourceId;
	}

	@Override
	public void run() {
		try {
			String pdfPath = dirTemp + UUID.randomUUID() + ".pdf";
			OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(pdfPath));
			if (extendName.equals("pdf")) {
				ByteArrayOutputStream bos0 = new ByteArrayOutputStream();
				byte[] bs0 = new byte[1024];
				int len0 = -1;
				while ((len0 = inputStream.read(bs0)) != -1) {
					bos0.write(bs0, 0, len0);
				}
				byte b0[] = bos0.toByteArray();
				outputStream.write(b0);

			} else {
				docService.transferDocToPdf(inputStream, extendName, outputStream);
			}
			outputStream.flush();
			outputStream.close();
			inputStream.close();
			InputStream transferPdfToSwf = docService.transferPdfToSwf(pdfPath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] bs = new byte[1024];
			int len = -1;
			while ((len = transferPdfToSwf.read(bs)) != -1) {
				bos.write(bs, 0, len);
			}
			byte b[] = bos.toByteArray();
			bos.close();
			transferPdfToSwf.close();
			docService.insertSwfToDb(b, resourceId);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
