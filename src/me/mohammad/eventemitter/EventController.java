package me.mohammad.eventemitter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class EventController {
	
	private String key;
	private List<Consumer<ParameterContainer>> handlers;
	
	public EventController(final String key) {
		this.handlers = new ArrayList<>();
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
	public void addEventHandler(final Consumer<ParameterContainer> handler) {
		handlers.add(handler);
	}
	
	public void removeEventHandler(final Consumer<ParameterContainer> handler) {
		handlers.remove(handler);
	}
	
	public List<Consumer<ParameterContainer>> getHandlers() {
		return handlers;
	}
	
}
