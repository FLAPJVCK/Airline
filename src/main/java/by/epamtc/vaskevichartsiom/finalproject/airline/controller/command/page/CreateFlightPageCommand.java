package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.AttributeName;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Airplane;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CreateFlightPageCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(AttributeName.CURRENT_PAGE, PagePath.CREATE_FLIGHT_PAGE);
        List<Destination> destinations = FactoryService.getInstance().getDestinationServiceImpl().findAllDestinations();
        request.setAttribute(AttributeName.DESTINATION_LIST, destinations);
        List<Airplane> airplanes = FactoryService.getInstance().getAirplaneServiceImpl().findAllAirplanes();
        request.setAttribute(AttributeName.AIRPLANE_LIST, airplanes);
        return new CommandResponse(PagePath.CREATE_FLIGHT_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
