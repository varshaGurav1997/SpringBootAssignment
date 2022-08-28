package com.cts.Project;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.cts.Project.entity.Project;



@SpringBootTest
class SpringBootAssignmentApplicationTests {
	private static final Log LOGGER = LogFactory.getLog(SpringBootAssignmentApplicationTests.class);

	private static final String GET_URL = "http://localhost:8080/GetAll";
	private static final String ADD_URL = "http://localhost:8080/add";
	private static final String UPDATE_URL = "http://localhost:8080/update/{projectId}";
	private static final String DELETE_URL = "http://localhost:8080/delete/{projectId}";

	RestTemplate restTemplate = new RestTemplate();
	@Test
	void contextLoads() {
	}
	public static void main(String[] args) {

		SpringBootAssignmentApplicationTests test = new SpringBootAssignmentApplicationTests();

		List<Project> listOfProjects = test.getAllProjectsTest();

		listOfProjects.forEach(System.out::println);
		
		
	}

	public List<Project> getAllProjectsTest() {

		List<Project> list = new ArrayList<>();

		Project[] projects = restTemplate.getForObject(GET_URL, Project[].class);

		for (Project p : projects) {
			list.add(p);
		}

		return list;

	}

	public void addProjectDetailsTest(Project project) {

		String response = restTemplate.postForObject(ADD_URL, project, String.class);

		LOGGER.info(response);

	}

	public void updateProjectDetailsTest(long projectId, Project project) {

		restTemplate.put(UPDATE_URL, project, projectId);

		LOGGER.info("Project Updated Successfullyy...");

	}

	public void deleteProjectDetailsTest(long projectId) {

		restTemplate.delete(DELETE_URL, projectId);

		LOGGER.info("Project Deleted Successfullyy...");

	}

}

