package launchcode.org.codingevents4.controllers;

import launchcode.org.codingevents4.data.EventData;
import launchcode.org.codingevents4.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String processCreateEventForm(@ModelAttribute Event newEvent){
        EventData.add(newEvent);
        return "redirect:";
}
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        //need to pass in a collection of events to delete any
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
}
    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds ){
    if(eventIds != null) {
        for (int id : eventIds) {
            EventData.remove(id);
        }
    }
        return "redirect:";
    }

}
