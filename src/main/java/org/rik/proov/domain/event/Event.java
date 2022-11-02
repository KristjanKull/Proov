package org.rik.proov.domain.event;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String info;

    private String place;

    private Date timestamp;

    /**@OneToMany
    private List<EventPerson> eventPeople;**/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

   /** public List<EventPerson> getEventPeople() {
        return eventPeople;
    }

    public void setEventPeople(List<EventPerson> eventPeople) {
        this.eventPeople = eventPeople;
    }**/
}

