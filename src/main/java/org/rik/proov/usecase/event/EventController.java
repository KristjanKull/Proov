package org.rik.proov.usecase.event;

import org.rik.proov.domain.event.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Path;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class EventController {

    private final EventService service;

    EventController(EventService service) {

        this.service = service;

    }
    @Autowired
    private EventRepository eRepo;
    @Autowired
    private EventPersonRepository repo;

    @Autowired
    private EventCompanyRepository cRepo;

    @GetMapping("/deleteEventPerson")
    public String deleteEventPerson(@RequestParam Long eventPersonId) {
        repo.deleteById(eventPersonId);
        return "event/addParticipants";
    }

    @GetMapping("/deleteEventCompany")
    public String deleteEventCompany(@RequestParam Long eventCompanyId) {
        cRepo.deleteById(eventCompanyId);
        return "event/addParticipants";
    }

    @GetMapping("/deleteEvent")
    public String deleteEvent(@RequestParam Long eventId) {
        eRepo.deleteById(eventId);
        return "event/list";
    }

    @RequestMapping("/participants")
    String addParticipants(Model model) {
        /**CreateEventPersonForm personForm = new CreateEventPersonForm();
        personForm.setEventId(@PathVariable());
        model.addAttribute("participants", personForm);
        model.addAttribute("person", new CreateEventForm());**/
        model.addAttribute("participants", new CreateEventPersonForm());
        model.addAttribute("companies", new CreateEventCompanyForm());
        model.addAttribute("personEvents", service.getAllPersonEvents());
        model.addAttribute("companyEvents", service.getAllCompanyEvents());
        return "event/addParticipants";
    }


    @PostMapping("/participants")
    String addParticipants(@ModelAttribute("participants") @Valid CreateEventPersonForm form, BindingResult result)
    {if (result.hasErrors()) {
            return "event/addParticipants";}
        service.saveEventPerson(form);
        return "event/addParticipants";}

/**@RequestMapping("/companies")
    String addCompany(Model model) {
        model.addAttribute("companies", new CreateEventCompanyForm());
        return "event/addCompanies";
    }**/

    @PostMapping("/companies")
    String addCompanies(@ModelAttribute("companies") @Valid CreateEventCompanyForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "event/addParticipants";
        }
        service.saveCompanyEvent(form);

        return "event/addParticipants";
    }



    @RequestMapping("/events")
    String listEvents(Model model) {
        model.addAttribute("events", service.getAllEvents());
        return "event/list";
    }

    @RequestMapping("/event")
    String createEvent(Model model) {
        model.addAttribute("event", new CreateEventForm());

        return "event/create";
    }
    @PostMapping("/event")
    String createEvent(@ModelAttribute("event") @Valid CreateEventForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "event/create";
        }

        service.saveEvent(form);

        return "event/create";

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"), true));
    }

}

