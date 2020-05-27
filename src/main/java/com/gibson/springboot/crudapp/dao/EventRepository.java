package com.gibson.springboot.crudapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.gibson.springboot.crudapp.entity.Event;
import com.gibson.springboot.crudapp.entity.User;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {}
