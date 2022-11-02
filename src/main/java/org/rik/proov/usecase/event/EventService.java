package org.rik.proov.usecase.event;

import org.rik.proov.domain.event.*;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
class EventService {

    private final EventRepository events;

    private final EventPersonRepository personEvents;

    private final EventCompanyRepository companyEvents;

    EventService(EventRepository events, EventPersonRepository personEvents, EventCompanyRepository  companyEvents) {
        this.events = events;
        this.personEvents = personEvents;
        this.companyEvents = companyEvents;
    }

    void saveEvent(@Valid CreateEventForm form) {
        Event event = new Event();


        event.setName(form.getName());
        event.setInfo(form.getInfo());
        event.setPlace(form.getPlace());
        event.setTimestamp(form.getTimestamp());

        events.save(event);
    }

    List<Event> getAllEvents() {
        return Streamable.of(events.findAll()).toList();
    }


    void saveEventPerson(@Valid CreateEventPersonForm form) {

        EventPerson eventPerson = new EventPerson();

        eventPerson.setId(form.getId());
        eventPerson.setFirstName(form.getFirstName());
        eventPerson.setLastName(form.getLastName());
        eventPerson.setSsn(form.getSsn());
        eventPerson.setPayment(form.getPayment());
        eventPerson.setInfo(form.getInfo());

        personEvents.save(eventPerson);
    }


    /**void saveEventPerson(@Valid CreateEventPersonForm form) {
        EventPerson eventPerson = new EventPerson();
        Event event = events.findById(form.getEventId()).orElseThrow();
        eventPerson.setFirstName(form.getFirstName());
        eventPerson.setLastName(form.getLastName());
        eventPerson.setSsn(form.getSsn());
        eventPerson.setPayment(form.getPayment());
        eventPerson.setInfo(form.getInfo());
        eventPerson.setEvent(event);
        personEvents.save(eventPerson);
    }**/

    List<EventPerson> getAllPersonEvents() {
        return Streamable.of(personEvents.findAll()).toList();
    }

    void saveCompanyEvent(@Valid CreateEventCompanyForm form) {
        EventCompany eventCompany = new EventCompany();

        eventCompany.setName(form.getName());
        eventCompany.setRegisterCode(form.getRegisterCode());
        eventCompany.setParticipantsSum(form.getParticipantsSum());
        eventCompany.setPayment(form.getPayment());
        eventCompany.setInfo(form.getInfo());

        companyEvents.save(eventCompany);
    }

    List<EventCompany> getAllCompanyEvents() {
        return Streamable.of(companyEvents.findAll()).toList();
    }

}


