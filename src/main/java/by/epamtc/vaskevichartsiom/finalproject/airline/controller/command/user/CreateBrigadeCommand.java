package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class CreateBrigadeCommand implements Command {

    private static final String CURRENT_PAGE = "current_page";


    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, PagePath.FLIGHT_COMMAND);
        Long flightId = Long.valueOf(request.getParameter("flightId"));
        String[] pilotIds = request.getParameterValues("pilot");
        for (String pilotId : pilotIds) {
            FactoryService.getInstance().getFlightServiceImpl().createBrigade(flightId, Long.valueOf(pilotId));
        }
        String[] navigatorIds = request.getParameterValues("navigator");
        for (String navigatorId : navigatorIds) {
            FactoryService.getInstance().getFlightServiceImpl().createBrigade(flightId, Long.valueOf(navigatorId));
        }
        String[] radioOperatorIds = request.getParameterValues("radioOperator");
        for (String radioOperatorId : radioOperatorIds) {
            FactoryService.getInstance().getFlightServiceImpl().createBrigade(flightId, Long.valueOf(radioOperatorId));
        }
        String[] stewardessIds = request.getParameterValues("stewardess");
        for (String stewardessId : stewardessIds) {
            FactoryService.getInstance().getFlightServiceImpl().createBrigade(flightId, Long.valueOf(stewardessId));
        }
        FactoryService.getInstance().getFlightServiceImpl().updateStatus(flightId, FlightStatus.NOT_READY);
        return new CommandResponse(PagePath.FLIGHT_COMMAND, CommandResponse.CommandResponseType.REDIRECT);
    }
}
