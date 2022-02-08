package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

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

    private static final String CURRENT_PAGE = "current_page";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, PagePath.FLIGHT_COMMAND);

        String number = request.getParameter("number");
        Date departureDate = Date.valueOf(request.getParameter("departureDate"));
        Time departureTime = Time.valueOf(request.getParameter("departureTime"));
        Long destination = Long.valueOf(request.getParameter("destination"));
        Long airplaneModel = Long.valueOf(request.getParameter("airplaneModel"));


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
