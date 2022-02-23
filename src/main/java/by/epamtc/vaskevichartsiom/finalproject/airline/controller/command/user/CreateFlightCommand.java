package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.AttributeName;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Airplane;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;

public class CreateFlightCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(AttributeName.CURRENT_PAGE, PagePath.FLIGHT_COMMAND);

        String number = request.getParameter(AttributeName.NUMBER);
        Date departureDate = Date.valueOf(request.getParameter(AttributeName.DEPARTURE_DATE));
        Time departureTime = Time.valueOf(request.getParameter(AttributeName.DEPARTURE_TIME));
        Long destination = Long.valueOf(request.getParameter(AttributeName.DESTINATION));
        Long airplaneModel = Long.valueOf(request.getParameter(AttributeName.AIRPLANE_MODEL));

        Flight currentFlight = new Flight();
        Destination currentDestination = new Destination();
        Airplane currentAirplane = new Airplane();
        currentFlight.setFlightNumber(number);
        currentFlight.setDepartureDate(departureDate);
        currentFlight.setDepartureTime(departureTime);
        currentDestination.setId(destination);
        currentFlight.setDestination(currentDestination);
        currentAirplane.setId(airplaneModel);
        currentFlight.setAirplane(currentAirplane);

        FactoryService.getInstance().getFlightServiceImpl().createFlight(currentFlight);
        return new CommandResponse(PagePath.FLIGHT_COMMAND, CommandResponse.CommandResponseType.REDIRECT);
    }
}
