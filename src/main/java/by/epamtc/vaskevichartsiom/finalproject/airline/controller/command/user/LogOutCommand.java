package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command {

    private static final String MAIN_PAGE = "/index.jsp";

    @Override
    public CommandResponse execute(HttpServletRequest request) {
        request.getSession().invalidate();

        return new CommandResponse(MAIN_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
