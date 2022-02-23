package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.AttributeName;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class DeleteFlightCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(AttributeName.CURRENT_PAGE, PagePath.FLIGHT_COMMAND);
        Long id = Long.valueOf(request.getParameter(AttributeName.FLIGHT_ID));
        FactoryService.getInstance().getFlightServiceImpl().deleteFlight(id);
        return new CommandResponse(PagePath.FLIGHT_COMMAND, CommandResponse.CommandResponseType.REDIRECT);
    }
}
