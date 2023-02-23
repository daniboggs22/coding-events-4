package launchcode.org.codingevents4.data;

import launchcode.org.codingevents4.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

        //TODO need a place to store events
        private static final Map<Integer, Event> events = new HashMap<>();
        //TODO add event
        public static void add (Event event){
                events.put(event.getId(), event);
        }

        //TODO should be able to get a single event
        public static Event getById(int id){
                return events.get(id);
        }
        // TODO get all events
        public static Collection<Event> getAll(){
                return events.values();
        }
        //TODO remove event
        public static void remove(int id){
                events.remove(id);
        }
}
