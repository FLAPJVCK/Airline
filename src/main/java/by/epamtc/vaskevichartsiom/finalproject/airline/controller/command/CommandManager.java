package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page.*;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user.*;

import java.util.HashMap;
import java.util.Map;

import static by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandType.*;

public class CommandManager {

    private static volatile CommandManager instance;

    private final Map<String, Command> commands = new HashMap<>();

    private CommandManager() {
        commands.put(CHANGE_LOCALE, new ChangeLocaleCommand());
        commands.put(MAIN_PAGE, new MainPageCommand());
        commands.put(REGISTER_PAGE, new RegisterPageCommand());
        commands.put(REGISTER, new RegisterCommand());
        commands.put(LOG_IN_PAGE, new LogInPageCommand());
        commands.put(LOG_IN, new LogInCommand());
        commands.put(LOG_OUT, new LogOutCommand());
        commands.put(PROFILE_PAGE, new ProfilePageCommand());
        commands.put(EMPLOYEE_PAGE, new EmployeePageCommand());
        commands.put(EDIT_USER_PAGE, new UserEditPageCommand());
        commands.put(EDIT_USER, new EditUserCommand());
        commands.put(DELETE_USER, new DeleteUserCommand());
        commands.put(FLIGHT_PAGE, new FlightPageCommand());
        commands.put(CREATE_FLIGHT_PAGE, new CreateFlightPageCommand());
        commands.put(CREATE_FLIGHT, new CreateFlightCommand());
        commands.put(EDIT_FLIGHT_PAGE, new EditFlightPageCommand());
        commands.put(EDIT_FLIGHT, new EditFlightCommand());
        commands.put(DELETE_FLIGHT, new DeleteFlightCommand());
        commands.put(CREATE_BRIGADE_PAGE, new CreateBrigadePageCommand());
        commands.put(CREATE_BRIGADE, new CreateBrigadeCommand());
        commands.put(BRIGADE_PAGE, new BrigadePageCommand());
        commands.put(UPDATE_FLIGHT_STATUS, new UpdateFlightStatus());
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
        return commands.getOrDefault(path, (r) -> new CommandResponse(PagePath.MAIN_PAGE, CommandResponse.CommandResponseType.REDIRECT));
    }
}
