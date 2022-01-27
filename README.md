# EventEmitter
A lightweight Java library, for event emitting and listening

# Installation
1. Download the latest file from the releases section
2. Create a project in your favorite Java IDE
3. Add the downloaded file as a library in your project
4. Use and Enjoy!

# Usage
In order to use the library, we have to implement our own Events. We do that by creating an EventController that manages the event.
Here's an example of a plain contoller for a user input event:
```java

import me.mohammad.eventemitter.EventController;

public class UserInputEventController extends EventController {

    public UserInputEventController() {
        super("user-input");
    }
  
}

```
We specify our event key using the `super(EventKey)` call, in our constructor. In our case, the key is "user-input".
PS: Keep in mind that the EventController shouldn't hold any values of single event instances!

Now that our controller is done, we have to register it. We do that by calling the `registerEvent(EventController)` method, from an `EventEmitter` instance.
Here's a code example:
```java

final EventController userInput = new UserInputEventController();
EventEmitter.openInstance().registerEvent(userInput);

```

Now, our event is registered. We can add some handlers to it.
Here's a code example:
```java

private String prefix = "[EventEmitter] ";

EventEmitter.openInstance().getEvent(userInput).addEventHandler((parameters) -> {
    final String input = parameters.getString("input");
    if (input.equalsIgnoreCase("exit"))
       // exit...
    System.out.printf("%sUser Input Detected: %s\n\n", prefix, input);
});

```
The handler above, gets the "input" variable, that is being hold by a `ParameterContainer` instance, and casts it to a String named input.
It then checks if the input is equal to "exit", if that's the case, it exits the program.
If none of that is the case, it prints the detected user input.


Now that we have a handler added, we can call that event by "emitting" a `ParameterContainer` instance.
Here's a code example:
```java

private String prefix = "[EventEmitter] ";

public void handleInput(final Scanner scanner) {
    System.out.printf("%sInput > ", prefix);
    EventEmitter.openInstance().emit("user-input", new ParameterContainer().add("input", scanner.nextLine()));
}

```
The code above emits the "user-input" event and casts a new parameter container instance with a variable called "input" to it.
The "input" variable, holds the users next input line.

If we call the `handleInput()` method, our event should be called and the handler should accept the parameter container.
The console will print the following messages:
```log
[EventEmitter] Input > Hi!
[EventEmitter] User Input Detected: Hi!


// Following output...
```

Thanks for following the tutorial, you can get the full example here:
https://github.com/MomoTheSiM/EventEmitter/tree/main/src/me/mohammad/eventemitter/example

# Updating
I have enough time to manage this library by my own, you can suggest me some features you'd like or maybe report some bugs as well.
You can give suggestions and report bugs to me via Discord (MomoTheSiM#6478).

# Thanks
You can use this library, the way you'd like.
The only thing you're not allowed to do, is to call it yours, you could atleast give credit to Mohammad Alkhatib (MomoTheSiM) for developing it.
Thanks for using my library, consider supporting me by leaving a star!
