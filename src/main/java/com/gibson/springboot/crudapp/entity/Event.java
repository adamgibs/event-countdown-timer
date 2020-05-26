package com.gibson.springboot.crudapp.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="event_name")
	private String eventName;
	
	private LocalDateTime eventDateTime;
	
	

	public Event() {
		
	}
	
	public Event(String eventName) {
		this.eventName = eventName;
	
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	@Override
	public String toString() {
		return "Thing [id=" + id + ", name=" + eventName + "]";
	}
	
	
	
	
}
