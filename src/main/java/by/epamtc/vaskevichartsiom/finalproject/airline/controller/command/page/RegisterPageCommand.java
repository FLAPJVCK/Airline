package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;

import javax.servlet.http.HttpServletRequest;

public class RegisterPageCommand implements Command {

    private static final String REGISTER_PAGE = "/view/access/registration.jsp";

    @Override
    public CommandResponse execute(HttpServletRequest request) {
        return new CommandResponse(REGISTER_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
