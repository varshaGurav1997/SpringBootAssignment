package com.cts.Project.Controller;
import java.util.List;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.Project.Service.ProjectService;
import com.cts.Project.entity.Project;

@RestController
public class ProjectController 
{
	private static final Log logger = LogFactory.getLog(ProjectController.class);
	
	@Autowired
	private ProjectService ps;
	
	
	@PostMapping("/add")
	public ResponseEntity<String> addData(@RequestBody Project p)
	{
		return new ResponseEntity<String>(ps.addProjectDetails(p),HttpStatus.CREATED);
	}
	@PutMapping("/update/{projectId}")
	public ResponseEntity<Project> updateData(@PathVariable int projectId,@RequestBody Project p)
	{
		return new ResponseEntity<Project>(ps.updateProjectDetails(projectId, p),HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{projectId}")
	public ResponseEntity<String> deleteData(@PathVariable int projectId)
	{
		return new ResponseEntity<String>(ps.deleteProjectDetails(projectId),HttpStatus.OK);
	}
	@GetMapping("/GetAll")
	public ResponseEntity<List<Project>> getAllProjectDetails()
	{
		
		return new ResponseEntity<List<Project>>(ps.listProjectDetails(),HttpStatus.OK);
	}
	
}
