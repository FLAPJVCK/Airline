package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;

import javax.servlet.http.HttpServletRequest;

public class MainPageCommand implements Command {

    private static final String CURRENT_PAGE = "current_page";
    private static final String MAIN_PAGE = "/index.jsp";

    @Override
    public CommandResponse execute(HttpServletRequest request) {
        request.getSession().setAttribute(CURRENT_PAGE, MAIN_PAGE);
        return new CommandResponse(MAIN_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
