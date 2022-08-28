package com.cts.Project.Service;

import java.util.*;
import org.apache.commons.logging.LogFactory;
import org.hibernate.internal.build.AllowSysOut;

import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.cts.Project.Controller.ProjectController;
import com.cts.Project.DAO.ProjectDao;
import com.cts.Project.entity.*;



@Service
public class ProjectServiceImpl implements ProjectService
{
	private static final Log logger = LogFactory.getLog(ProjectServiceImpl.class);
	
	@Autowired
	private ProjectDao pd;
	
	
	@Override
	public String addProjectDetails(Project p) 
	{
		pd.save(p);
		return "Project Added Successfully";
	}

	@Override
	public Project updateProjectDetails(int projectId,Project p) 
	{

		Optional<Project> project = pd.findById(projectId);
		if(project.isPresent())
		{
			Project project2 = project.get();

			pd.save(p);
			return p;
		}
		
		return null;
		
	}
	@Override
	public Project getProjectById(int projectId) 
	{
		Optional<Project> p = pd.findById(projectId);
		if(p.isPresent())
		{
			Project project = p.get();
			return project;
		}
		return null;
				
	}
	@Override
	public String deleteProjectDetails(int projectId)
	{
		pd.deleteById(projectId);
		return "Project Deleted Successfully";
		
	}

	@Override
	public List<Project> listProjectDetails() 
	{
		List<Project> findAll = (List<Project>) pd.findAll();
		return findAll;
	}

}
