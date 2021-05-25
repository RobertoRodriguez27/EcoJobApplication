package com.example.application;

import org.springframework.data.repository.CrudRepository;

// provides methods to interact with database
public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
