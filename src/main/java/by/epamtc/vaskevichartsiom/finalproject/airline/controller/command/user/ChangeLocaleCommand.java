package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class ChangeLocaleCommand implements Command {

    private static final String LOCALE = "locale";
    private static final String CURRENT_PAGE = "current_page";
    private static final String MAIN_PAGE = "/index.jsp";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        String locale = request.getParameter(LOCALE);
        request.getSession().setAttribute(LOCALE, locale);

        if (request.getSession().getAttribute(CURRENT_PAGE) == null) {
            return new CommandResponse(MAIN_PAGE, CommandResponse.CommandResponseType.FORWARD);
        }
        return new CommandResponse(String.valueOf(request.getSession().getAttribute(CURRENT_PAGE)), CommandResponse.CommandResponseType.FORWARD);
    }
}
