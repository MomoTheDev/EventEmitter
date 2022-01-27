package me.mohammad.eventemitter.example;

import java.util.Scanner;

import me.mohammad.eventemitter.EventController;
import me.mohammad.eventemitter.EventEmitter;
import me.mohammad.eventemitter.ParameterContainer;

public class Example {
	
	private static String prefix;
	private static Scanner scanner;
	private static EventEmitter emitter;
	private static EventController event;
	
	static {
		event = new UserInputEventController();
		emitter = EventEmitter.openInstance();
		scanner = new Scanner(System.in);
		prefix = "[EventExample] ";
	}
	
	public static void main(final String[] args) {
		emitter.registerEvent(event);
		emitter.getEvent(event).addEventHandler((parameters) -> {
			final String input = parameters.getString("input");
			if (input.equalsIgnoreCase("exit"))
				exit();
			System.out.printf("%sUser Input Detected: %s\n\n", prefix, input);
		});
		
		while (true) {
			handleInput();
		}
	}
	
	private static void exit() {
		System.out.printf("%sExiting program...", prefix);
		scanner.close();
		System.exit(0);
	}
	
	private static void handleInput() {
		System.out.printf("%sInput > ", prefix);
		emitter.emit("user-input", new ParameterContainer().add("input", scanner.nextLine()));	
	}
	
}
