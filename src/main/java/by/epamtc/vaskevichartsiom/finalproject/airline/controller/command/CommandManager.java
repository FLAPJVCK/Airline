package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page.*;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user.*;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private static final String MAIN_PAGE = "/index.jsp";

    private static volatile CommandManager instance;

    private final Map<String, Command> commands = new HashMap<>();

    private CommandManager() {
        commands.put("change_locale", new ChangeLocaleCommand());
        commands.put("mainPage", new MainPageCommand());
        commands.put("registerPage", new RegisterPageCommand());
        commands.put("register", new RegisterCommand());
        commands.put("logInPage", new LogInPageCommand());
        commands.put("logIn", new LogInCommand());
        commands.put("logOut", new LogOutCommand());
        commands.put("employeePage", new EmployeePageCommand());
        commands.put("employee", new EmployeeCommand());
        commands.put("editUserPage", new UserEditPageCommand());
        commands.put("editUser", new EditUserCommand());
        commands.put("deleteUser", new DeleteUserCommand());
        commands.put("flightPage", new FlightPageCommand());
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
        return commands.getOrDefault(path, (r) -> new CommandResponse(MAIN_PAGE, CommandResponse.CommandResponseType.REDIRECT));
    }

//    public Command getCommand(String path) {
//        path = path.replaceAll(".*/Airline/Controller", "");
//        return commands.getOrDefault(path, (r) -> "/Airline/mainPage");
//    }
}
