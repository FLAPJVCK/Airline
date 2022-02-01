package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class UpdateFlightStatus implements Command {

    private static final String CURRENT_PAGE = "current_page";
    private static final String FLIGHT_PAGE = "/Controller?command=flightPage";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, FLIGHT_PAGE);
        Long flightId = Long.valueOf(request.getParameter("flightId"));
        FactoryService.getInstance().getFlightServiceImpl().updateStatus(flightId, FlightStatus.READY);
        return new CommandResponse(FLIGHT_PAGE, CommandResponse.CommandResponseType.REDIRECT);
    }
}
