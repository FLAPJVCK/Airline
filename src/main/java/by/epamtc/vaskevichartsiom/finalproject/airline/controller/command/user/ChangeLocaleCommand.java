package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.AttributeName;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class ChangeLocaleCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        String locale = request.getParameter(AttributeName.LOCALE);
        request.getSession().setAttribute(AttributeName.LOCALE, locale);

        if (request.getSession().getAttribute(AttributeName.CURRENT_PAGE) == null) {
            return new CommandResponse(PagePath.MAIN_PAGE, CommandResponse.CommandResponseType.FORWARD);
        }
        return new CommandResponse(String.valueOf(request.getSession().getAttribute(AttributeName.CURRENT_PAGE)),
                CommandResponse.CommandResponseType.FORWARD);
    }
}
