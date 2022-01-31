package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class EditFlightPageCommand implements Command {

    private static final String CURRENT_PAGE = "current_page";
    private static final String EDIT_FLIGHT_PAGE = "/view/editFlight.jsp";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, EDIT_FLIGHT_PAGE);
        Long id = Long.valueOf(request.getParameter("id"));
        Optional<Flight> flight = FactoryService.getInstance().getFlightServiceImpl().findById(id);
        request.getSession().setAttribute("flight", flight.get());
        List<Destination> destinations = FactoryService.getInstance().getDestinationServiceImpl().findAllDestinations();
        request.getSession().setAttribute("destinationList", destinations);
        return new CommandResponse(EDIT_FLIGHT_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
