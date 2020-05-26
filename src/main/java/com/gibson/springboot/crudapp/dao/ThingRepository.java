package com.gibson.springboot.crudapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.gibson.springboot.crudapp.entity.Event;

@Repository
public interface ThingRepository extends JpaRepository<Event, Integer> {

}
