package edu.csueb.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eventid;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private String location;
	@Column
	private Date time;
	@Column
	private int totalseats;
	@Column
	private int regseats;
	
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getTotalseats() {
		return totalseats;
	}
	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}
	public int getRegseats() {
		return regseats;
	}
	public void setRegseats(int regseats) {
		this.regseats = regseats;
	}
	@Override
	public String toString() {
		return "Event [eventid=" + eventid + ", name=" + name + ", description=" + description + ", location="
				+ location + ", time=" + time + ", totalseats=" + totalseats + ", regseats=" + regseats + "]";
	}
}
