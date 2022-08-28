package com.cts.Project.Service;

import java.util.*;

import com.cts.Project.entity.Project;


public interface ProjectService 
{
	public String addProjectDetails(Project p);

	public Project updateProjectDetails(int projectId,Project p);

	public String deleteProjectDetails(int projectId);

	public List<Project> listProjectDetails();

	Project getProjectById(int projectId);

}
