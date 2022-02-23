package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.AttributeName;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class EditFlightPageCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(AttributeName.CURRENT_PAGE, PagePath.EDIT_FLIGHT_PAGE);
        Long id = Long.valueOf(request.getParameter(AttributeName.FLIGHT_ID));
        Optional<Flight> flight = FactoryService.getInstance().getFlightServiceImpl().findById(id);
        flight.ifPresent(value -> request.setAttribute(AttributeName.FLIGHT, value));
        List<Destination> destinations = FactoryService.getInstance().getDestinationServiceImpl().findAllDestinations();
        request.setAttribute(AttributeName.DESTINATION_LIST, destinations);
        return new CommandResponse(PagePath.EDIT_FLIGHT_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
