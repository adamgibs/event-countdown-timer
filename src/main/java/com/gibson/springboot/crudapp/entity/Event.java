package com.gibson.springboot.crudapp.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="event")
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="event_name")
	private String eventName;
	
	@Column(name="event_date_time")
	private LocalDateTime eventDateTime;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	private User user;
	
	
	public Event() {
		
	}
	
	@Autowired
	public Event(String eventName, LocalDateTime eventDateTime, User user) {
		this.eventName = eventName;
		this.eventDateTime = eventDateTime;
		this.user = user;
	
	}
	

	public LocalDateTime getEventDateTime() {
		return eventDateTime;
	}

	public void setEventDateTime(LocalDateTime eventDateTime) {
		this.eventDateTime = eventDateTime;
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
