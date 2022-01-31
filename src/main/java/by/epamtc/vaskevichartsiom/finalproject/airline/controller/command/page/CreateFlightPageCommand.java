package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Airplane;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CreateFlightPageCommand implements Command {

    private static final String CURRENT_PAGE = "current_page";
    private static final String CREATE_FLIGHT_PAGE = "/view/createFlight.jsp";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, CREATE_FLIGHT_PAGE);
        List<Destination> destinations = FactoryService.getInstance().getDestinationServiceImpl().findAllDestinations();
        request.getSession().setAttribute("destinationList", destinations);
        List<Airplane> airplanes = FactoryService.getInstance().getAirplaneServiceImpl().findAllAirplanes();
        request.getSession().setAttribute("airplaneList", airplanes);
        return new CommandResponse(CREATE_FLIGHT_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
