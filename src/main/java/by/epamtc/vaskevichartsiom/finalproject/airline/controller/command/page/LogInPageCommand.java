package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;

import javax.servlet.http.HttpServletRequest;

public class LogInPageCommand implements Command {

    private static final String LOGIN_PAGE = "/view/access/authentication.jsp";

    @Override
    public CommandResponse execute(HttpServletRequest request) {
        return new CommandResponse(LOGIN_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
