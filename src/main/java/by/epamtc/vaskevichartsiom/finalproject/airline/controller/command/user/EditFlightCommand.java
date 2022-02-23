package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.AttributeName;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;

public class EditFlightCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(AttributeName.CURRENT_PAGE, PagePath.FLIGHT_COMMAND);
        Long id = Long.valueOf(request.getParameter(AttributeName.FLIGHT_ID));
        String number = request.getParameter(AttributeName.NUMBER);
        Date departureDate = Date.valueOf(request.getParameter(AttributeName.DEPARTURE_DATE));
        Time departureTime = Time.valueOf(request.getParameter(AttributeName.DEPARTURE_TIME));
        Long destination = Long.valueOf(request.getParameter(AttributeName.DESTINATION));

        Flight currentFlight = new Flight();
        Destination currentDestination = new Destination();
        currentFlight.setId(id);
        currentFlight.setFlightNumber(number);
        currentFlight.setDepartureDate(departureDate);
        currentFlight.setDepartureTime(departureTime);
        currentDestination.setId(destination);
        currentFlight.setDestination(currentDestination);

        FactoryService.getInstance().getFlightServiceImpl().updateFlight(currentFlight);
        return new CommandResponse(PagePath.FLIGHT_COMMAND, CommandResponse.CommandResponseType.REDIRECT);
    }
}
