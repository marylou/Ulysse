package org.qualipso.factory.eventqueue.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.qualipso.factory.FactoryNamingConvention;
import org.qualipso.factory.FactoryResource;
import org.qualipso.factory.FactoryResourceIdentifier;
import org.qualipso.factory.eventqueue.EventQueueService;

/**
 * @author Jerome Blanchard (jayblanc@gmail.com)
 * @author Nicolas HENRY
 * @author Marlène HANTZ
 * @date 11 june 2009
 */
@Entity
@XmlType(name = EventQueue.RESOURCE_NAME, namespace = FactoryNamingConvention.RESOURCE_NAMESPACE + EventQueue.RESOURCE_NAME, propOrder = { "events","rules" })
public class EventQueue extends FactoryResource {

    public static final String RESOURCE_NAME = "eventqueue";

    private static final long serialVersionUID = 8866543643223847878L;

    @Id
    private String id;
    private String path;
    @ManyToMany
    private Collection<PersistentEvent> events;
    @OneToMany(mappedBy="queue")
    private Collection<Rule> rules;

    @XmlAttribute(name = "events", required = true)
    public Collection<PersistentEvent> getEvents() {
        return events;
    }

    public void setEvents(Collection<PersistentEvent> events) {
        this.events = events;
    }

    public EventQueue() {
    }

    @XmlAttribute(name = "path", required = true)
    @Transient
    @Override
    public String getResourcePath() {
        return path;
    }

    public void setResourcePath(String path) {
        this.path = path;
    }

    @Override
    @XmlTransient
    public FactoryResourceIdentifier getFactoryResourceIdentifier() {
        return new FactoryResourceIdentifier(EventQueueService.SERVICE_NAME, EventQueue.RESOURCE_NAME, getId());
    }

    @Override
    @XmlTransient
    public String getResourceName() {
        return RESOURCE_NAME;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @XmlAttribute(name = "id", required = true)
    public String getId() {
        return id;
    }
    
    @XmlAttribute(name = "rules", required = true)
	public Collection<Rule> getRules() {
		return rules;
	}

	public void setRules(Collection<Rule> rules) {
		this.rules = rules;
	}

	@XmlAttribute(name = "path", required = true)
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

}
