package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FlightPageCommand implements Command {

    private static final String CURRENT_PAGE = "current_page";
    private static final String FLIGHT_PAGE = "/view/flight.jsp";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, FLIGHT_PAGE);
        List<Flight> flights = FactoryService.getInstance().getFlightServiceImpl().findAllFlights();
        request.getSession().setAttribute("flightList", flights);
        return new CommandResponse(FLIGHT_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
