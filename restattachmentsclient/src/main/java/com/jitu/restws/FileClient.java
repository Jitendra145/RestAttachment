
package com.jitu.restws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

public class FileClient {

	public static void main(String[] args) throws FileNotFoundException {
		WebClient client = WebClient.create("http://localhost:8080/restattachments/services/fileService/upload");
		client.type("multipart/form-data");
		ContentDisposition cd = new ContentDisposition("attachment;filename=back1.jpg");
		Attachment attachment = new Attachment("root",
				new FileInputStream(new File("C:\\Users\\jitendra\\Desktop\\My Music Shop V 2\\images\\back1.jpg")),
				cd);
		client.post(attachment);
	}

}
