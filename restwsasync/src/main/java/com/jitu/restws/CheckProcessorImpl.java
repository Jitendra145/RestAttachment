package com.jitu.restws;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.container.AsyncResponse;

import org.springframework.stereotype.Service;

import com.jitu.restws.model.ChecksList;

@Service
public class CheckProcessorImpl implements CheckProcessor {

	/*@Override
	public void processChecks(AsyncResponse response,ChecksList checkslist) {
		response.resume("true");
	}*/
	@Override
	public void processChecks(AsyncResponse response,ChecksList checkslist) {
		new Thread() {
			public void run() {
				if(checkslist==null || checkslist.getChecks()==null||checkslist.getChecks().size()==0) {
					response.resume(new BadRequestException());
				}
				response.resume(true);
			}
		}.start();		
	}

}
