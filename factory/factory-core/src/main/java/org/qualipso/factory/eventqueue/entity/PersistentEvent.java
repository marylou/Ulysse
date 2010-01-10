package org.qualipso.factory.eventqueue.entity;

/*
 *
 * Qualipso Factory
 * Copyright (C) 2006-2010 INRIA
 * http://www.inria.fr - molli@loria.fr
 *
 * This software is free software; you can redistribute it and/or
 * modify it under the terms of LGPL. See licenses details in LGPL.txt
 *
 * Initial authors :
 *
 * Jérôme Blanchard / INRIA
 * Pascal Molli / Nancy Université
 * Gérald Oster / Nancy Université
 *
 */

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.qualipso.factory.FactoryNamingConvention;
import org.qualipso.factory.notification.Event;

/**
 * @author Jerome Blanchard (jayblanc@gmail.com)
 * @author Nicolas HENRY
 * @author Marlène HANTZ
 * @date 20 May 2009
 */
@Entity
@XmlType(name = PersistentEvent.RESOURCE_NAME, namespace = FactoryNamingConvention.RESOURCE_NAMESPACE + EventQueue.RESOURCE_NAME, propOrder = { "fromResource", "throwedBy", "resourceType", "date", "eventType",
		"args","eventQueue" })
public class PersistentEvent implements Serializable {

    @Id
    private String id;
	private static final long serialVersionUID = 7085572305198138327L;

	public static final String RESOURCE_NAME = "PersistentEvent";
	private String fromResource;
	private String throwedBy;
	private String resourceType;
	private Date date;
	private String eventType;
	private String args;
	@ManyToMany(mappedBy="events")
	private Collection<EventQueue> eventQueue;

	public PersistentEvent() {
		date = new Date();
	}

	@XmlAttribute(name = "id", required = true)
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public PersistentEvent(String fromResource, String resourceType, String eventType, String args) {
		this();
		setFromResource(fromResource);
		setResourceType(resourceType);
		setEventType(eventType);
		setArgs(args);
	}

	public PersistentEvent(String fromResource, String throwedBy, String resourceType, String eventType, String args) {
		this(fromResource, resourceType, eventType, args);
		setThrowedBy(throwedBy);
	}

	@XmlElement(name = "from-resource")
	public String getFromResource() {
		return fromResource;
	}

	public void setFromResource(String fromResource) {
		this.fromResource = fromResource;
	}

	@XmlElement(name = "throwed-by")
	public String getThrowedBy() {
		return throwedBy;
	}

	public void setThrowedBy(String throwedBy) {
		this.throwedBy = throwedBy;
	}

	@XmlElement(name = "resource-type")
	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	@XmlElement(name = "date", required = true)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@XmlElement(name = "event-type", required = true)
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@XmlElement(name = "arguments")
	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersistentEvent other = (PersistentEvent) obj;
		if (args == null) {
			if (other.args != null)
				return false;
		} else if (!args.equals(other.args))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (fromResource == null) {
			if (other.fromResource != null)
				return false;
		} else if (!fromResource.equals(other.fromResource))
			return false;
		if (resourceType == null) {
			if (other.resourceType != null)
				return false;
		} else if (!resourceType.equals(other.resourceType))
			return false;
		if (throwedBy == null) {
			if (other.throwedBy != null)
				return false;
		} else if (!throwedBy.equals(other.throwedBy))
			return false;
		return true;
	}

	public String toString() {
		String event = "event type    : " + eventType + "\r\n" + "throwed by    : " + throwedBy + "\r\n" + "from resource : " + fromResource + "\r\n"
				+ "resource type : " + resourceType + "\r\n" + "args          : " + args + "\r\n" + "date          : " + date;
		return event;
	}

	public static String buildEventType(String service, String resource, String name) {
		return service + "." + resource + "." + name;
	}

	public static PersistentEvent fromEvent(Event event) {
		PersistentEvent pe = new PersistentEvent();
		pe.setArgs(event.getArgs());
		pe.setDate(event.getDate());
		pe.setEventType(event.getEventType());
		pe.setFromResource(event.getFromResource());
		pe.setThrowedBy(event.getThrowedBy());
		pe.setResourceType(event.getResourceType());
		return pe;
	}

	@XmlAttribute(name = "queues", required = true)
	public Collection<EventQueue> getEventQueue() {
		return eventQueue;
	}

	public void setEventQueue(Collection<EventQueue> eventQueue) {
		this.eventQueue = eventQueue;
	}
	
	

}
