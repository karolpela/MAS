package own;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;
import org.jetbrains.annotations.NotNull;

public class Planner {
    private final Set<Event> events = new TreeSet<>();

    public void addEvent(String name, LocalDateTime startTime, LocalDateTime endTime)
            throws Exception {
        var event = new Event(name, startTime, endTime);
        if (checkIfOverlaps(event)) {
            throw new Exception("Events can't overlap!");
        }
        this.events.add(event);
    }

    public Iterable<Event> getEvents() {
        return events;
    }

    public boolean checkIfOverlaps(Event newEvent) {
        for (Event plannedEvent : events) {
            if ((newEvent.startTime.isAfter(plannedEvent.startTime)
                    && newEvent.startTime.isBefore(plannedEvent.endTime))
                    || (newEvent.endTime.isAfter(plannedEvent.startTime)
                    && newEvent.endTime.isBefore(plannedEvent.endTime))) {
                return true;
            }
        }
        return false;
    }

    public class Event implements Comparable<Event> {
        public String name;
        public LocalDateTime startTime;
        public LocalDateTime endTime;

        private Event(String name, LocalDateTime startTime, LocalDateTime endTime)
                throws Exception {
            if (endTime.isBefore(startTime)) {
                throw new Exception("The event can't end before it starts!");
            }
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(@NotNull Event e) {
            return this.startTime.compareTo(e.startTime);
        }

        @Override
        public String toString() {
            return "Event{" + "name='" + name + '\'' + ", dateTime=" + startTime + '}';
        }
    }
}
