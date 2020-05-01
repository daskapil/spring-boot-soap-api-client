package com.kapil.soap.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kapil.soap.ws.client.SoapClient;
import com.kapil.soap.ws.loaneligibility.Acknowledgement;
import com.kapil.soap.ws.loaneligibility.CustomerRequest;

@SpringBootApplication
@RestController
public class SpringBootSoapApiClientApplication {
	
	@Autowired
	private SoapClient client;

	@PostMapping("/getLoanStatus")
	public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest request) {
		return client.getLoanStatus(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapApiClientApplication.class, args);
	}

}
