package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;

public class EditFlightCommand implements Command {
    private static final String CURRENT_PAGE = "current_page";
    private static final String FLIGHT_PAGE = "/Controller?command=flightPage";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, FLIGHT_PAGE);
        Long id = Long.valueOf(request.getParameter("id"));
        String number = request.getParameter("number");
        Date departureDate = Date.valueOf(request.getParameter("departureDate"));
        Time departureTime = Time.valueOf(request.getParameter("departureTime"));
        Long destination = Long.valueOf(request.getParameter("destination"));


        Flight currentFlight = new Flight();
        Destination currentDestination = new Destination();
        currentFlight.setId(id);
        currentFlight.setFlightNumber(number);
        currentFlight.setDepartureDate(departureDate);
        currentFlight.setDepartureTime(departureTime);
        currentDestination.setId(destination);
        currentFlight.setDestination(currentDestination);

        FactoryService.getInstance().getFlightServiceImpl().updateFlight(currentFlight);
        return new CommandResponse(FLIGHT_PAGE, CommandResponse.CommandResponseType.REDIRECT);
    }
}
