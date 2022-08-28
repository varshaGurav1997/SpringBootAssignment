package com.cts.Project;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootAssignmentApplication2 {
	private static final Log LOGGER = LogFactory.getLog(SpringBootAssignmentApplication2.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssignmentApplication2.class, args);
		
	}

}

	
