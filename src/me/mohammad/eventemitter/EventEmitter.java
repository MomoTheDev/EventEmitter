package me.mohammad.eventemitter;

import java.util.HashMap;
import java.util.Map;

public class EventEmitter extends Thread {
	
	protected static EventEmitter lastInstance;
	protected static final String prefix;
	
	protected Map<String, EventController> events;
	protected boolean isRunning;
	
	static {
		prefix = "[EventEmitter] ";
	}
	
	protected EventEmitter() {
		events = new HashMap<>();
		start();
	}
	
	public void emit(final String eventKey, final ParameterContainer parameters) {
		if (!(isRunning))
			return;
		events.get(eventKey).getHandlers().forEach((handler) -> {
			handler.accept(parameters);
		});
	}
	
	public EventController registerEvent(final EventController event) {
		return events.put(event.getKey(), event);
	}
	
	public EventController unregisterEvent(final EventController event) {
		return events.remove(event.getKey());
	}
	
	public EventController getEvent(final EventController event) {
		return events.get(event.getKey());
	}
	
	@Override
	public void run() {
		isRunning = true;
	}
	
	public static EventEmitter openInstance() {
		return lastInstance == null ? new EventEmitter() : lastInstance;
	}
	
}
