package de.yetanothercalendar.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import de.yetanothercalendar.model.dao.EventDAO;
import de.yetanothercalendar.model.database.Event;
import de.yetanothercalendar.model.database.User;

public class EventDAOMockFull implements EventDAO {

	public List<Event> getEventBetweenDates(User user, Date from, Date til) {
		List<Event> eventList = new ArrayList<Event>();
		// TODO : viele events einfuegen und im CalendarEventToEntryWrapper die
		// GESAMTE OO Strukture testen. Dabei wird vorallem die neu
		// hinzugefuegte
		// map getestet..
		// TODO es werden erst alle termine in einem Jahr gemappt
		// Calendar facts
		Calendar calendarCreated = new GregorianCalendar(Locale.GERMANY);
		calendarCreated.set(2008, 1, 1, 1, 1);
		Calendar calendar = new GregorianCalendar(Locale.GERMANY);
		calendar.set(2008, 0, 01, 10, 00);
		Calendar calendar2 = new GregorianCalendar(Locale.GERMANY);
		calendar2.set(2012, 0, 05, 10, 00);
		for (int yearcount = 0; yearcount < 4; yearcount++) {
			// 4 Jahre
			for (int i = 0; i < 10; i++) {
				// 10Monate
				for (int j = 0; j < 5; j++) {
					// 5 wochen
					Event createDummyEvent = createDummyEvent(user,
							calendarCreated, calendar, calendar2);
					calendar.add(Calendar.DAY_OF_YEAR, 1);
					calendar2.add(Calendar.DAY_OF_YEAR, 1);
					Event createDummyEvent2 = createDummyEvent(user,
							calendarCreated, calendar, calendar2);
					System.out.println(createDummyEvent.getId() + " - "
							+ createDummyEvent.getDtstart().toString() + " - "
							+ createDummyEvent.getDtend().toString());
					eventList.add(createDummyEvent);
					eventList.add(createDummyEvent2);
					calendar.add(Calendar.DAY_OF_YEAR, 6);
					calendar2.add(Calendar.DAY_OF_YEAR, 6);
					// 7 tage dazuaddiert
				}
				calendar.add(Calendar.MONTH, 1);
				calendar2.add(Calendar.MONTH, 1);
				// einen monat addiert
			}
			calendar.add(Calendar.YEAR, 1);
			calendar2.add(Calendar.YEAR, 1);
			// ein Jahr addiert
		}
		return eventList;
	}

	private Event createDummyEvent(User user, Calendar created, Calendar start,
			Calendar end) {
		return new Event(new Long((int) (Math.random() * 100000)), user,
				new Date(), "uuid", start.getTime(), created.getTime(),
				"description", new Date(), "location", "very high",
				"what a great summary", "recurrid", null, end.getTime(), 0,
				"#fff", new ArrayList<String>(), "comment", new Date(), "");
	}

	public void createEventTable() {
		// TODO Auto-generated method stub

	}

	public boolean createEvents(Event event) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Event> getEventsFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Event> getEventsFromUserRecurring(User user) {
		// TODO Auto-generated method stub
		List<Event> eventBetweenDates = getEventBetweenDates(user,
				new GregorianCalendar(2012, 0, 1).getTime(),
				new GregorianCalendar(2013, 0, 1).getTime());
		return eventBetweenDates;
	}

	public List<Event> getEventsFromUserNotRecurring(User user) {
		// TODO Auto-generated method stub
		return new ArrayList<Event>();
	}

	public void updateEvent(Event event) {
		// TODO Auto-generated method stub

	}

	public void deleteEvent(Event event) {
		// TODO Auto-generated method stub
		
	}
}
