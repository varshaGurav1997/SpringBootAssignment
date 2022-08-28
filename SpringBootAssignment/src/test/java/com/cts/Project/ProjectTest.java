package com.cts.Project;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.sql.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.Project.DAO.ProjectDao;
import com.cts.Project.Service.ProjectService;
import com.cts.Project.entity.Project;

@SpringBootTest
@DisplayName("Unit test case")
class ProjectTest {


	@Autowired
	private ProjectService ps;

	@Autowired
	private ProjectDao pd;

	

	@Test
	
	void addProjectDetailsTest() {

		Project project = new Project();
		project.setProjectId(5);
		project.setTitle("Internate browsing lab security system");
		project.setBudget(2500.00);
		project.setDuration(9);
		project.setEndDate(new Date(2022, 10, 14));
		project.setTeamsize(10);
		project.setManagerName("Varsha");

		assertEquals("Project Added Successfully", ps.addProjectDetails(project));

	}

	@Test
	void updateProjectDetails() {

		Project projectById = ps.getProjectById(3);
		projectById.setTeamsize(100);

		assertNotNull(ps.updateProjectDetails(3, projectById));

	}

	@Test
	void deleteProjectDetails() {
		
		assertEquals("Project Deleted Successfully", ps.deleteProjectDetails(4));
		
	}

	@Test
	
	void listProjectDetailsTest() {

		ps.listProjectDetails();
		Iterable<Project> findAll = pd.findAll();
		findAll.forEach(System.out::println);

	}

}

