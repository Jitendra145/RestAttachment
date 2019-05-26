package com.jitu.restws;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.stereotype.Service;

@Path("/fileService")
@Service
public class FileService {

	private static final String FILE_PATH = "C:\\Users\\jitendra\\Desktop\\My Music Shop\\uploaded\\upload.jpg";
	
	@Path("/upload")
	@POST
	public void upload(List<Attachment> attachements) throws FileNotFoundException, IOException {
		System.out.println("==========Inside upload===========");
		for(Attachment attachement : attachements) {
			copyFile(attachement.getDataHandler().getInputStream());
		}
	}

	@GET
	@Path("/download")
	public Response download() {
		File file = new File(FILE_PATH);
		ResponseBuilder builder = Response.ok(file);
		builder.header("Content-Disposition", "attachment;filename:download.jpg");
		return builder.build();
		
	}
	
	private void copyFile(InputStream inputStream) throws FileNotFoundException, IOException {
		OutputStream out = null;
		int read = 0;
		byte[] bytes = new byte[1024];

		out = new FileOutputStream(new File(FILE_PATH));
		while ((read = inputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();	
	}

}