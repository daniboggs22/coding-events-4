package launchcode.org.codingevents4.controllers;

import launchcode.org.codingevents4.data.EventData;
import launchcode.org.codingevents4.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }
    //lives at Events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model){
        model.addAttribute("title", "Create Event");
        return "events/create";
    }
    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription){
        EventData.add(new Event(eventName, eventDescription));
        return "redirect:";
}

}
