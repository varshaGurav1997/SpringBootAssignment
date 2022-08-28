package com.cts.Project.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.Project.entity.Project;



@Repository
public interface ProjectDao extends CrudRepository<Project,Integer>{

}
