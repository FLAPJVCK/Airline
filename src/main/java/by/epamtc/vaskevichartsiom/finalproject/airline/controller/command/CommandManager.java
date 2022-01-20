package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page.LogInPageCommand;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page.MainPageCommand;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page.RegisterPageCommand;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user.LogInCommand;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user.LogOutCommand;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user.RegisterCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private static volatile CommandManager instance;

    private final Map<String, Command> commands = new HashMap<>();

    private CommandManager() {
        commands.put("mainPage", new MainPageCommand());
        commands.put("registerPage", new RegisterPageCommand());
        commands.put("register", new RegisterCommand());
        commands.put("logInPage", new LogInPageCommand());
        commands.put("logIn", new LogInCommand());
        commands.put("logOut", new LogOutCommand());
    }

    public static CommandManager getInstance() {
        if (instance == null) {
            synchronized (CommandManager.class) {
                if (instance == null) {
                    instance = new CommandManager();
                }
            }
        }
        return instance;
    }

    public Command getCommand(String path) {
        return commands.getOrDefault(path, (r) -> "mainPage");
    }

//    public Command getCommand(String path) {
//        path = path.replaceAll(".*/Airline/Controller", "");
//        return commands.getOrDefault(path, (r) -> "/Airline/mainPage");
//    }
}
