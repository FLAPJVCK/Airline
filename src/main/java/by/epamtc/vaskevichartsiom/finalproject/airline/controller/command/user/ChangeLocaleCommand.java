package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class ChangeLocaleCommand implements Command {

    private static final String LOCALE = "locale";
    private static final String CURRENT_PAGE = "current_page";
    private static final String MAIN_PAGE = "/index.jsp";

    @Override
    public String execute(HttpServletRequest request) throws ServiceException {
        String locale = request.getParameter(LOCALE);
        request.getSession().setAttribute(LOCALE, locale);

        if (request.getSession().getAttribute(CURRENT_PAGE) == null) {
            return MAIN_PAGE;
        }
        return (String) request.getSession().getAttribute(CURRENT_PAGE);
    }
}
