package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.AttributeName;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class CreateBrigadeCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(AttributeName.CURRENT_PAGE, PagePath.FLIGHT_COMMAND);
        Long flightId = Long.valueOf(request.getParameter(AttributeName.FLIGHT_ID));
        String[] pilotIds = request.getParameterValues(AttributeName.PILOT);
        for (String pilotId : pilotIds) {
            FactoryService.getInstance().getFlightServiceImpl().createBrigade(flightId, Long.valueOf(pilotId));
        }
        String[] navigatorIds = request.getParameterValues(AttributeName.NAVIGATOR);
        for (String navigatorId : navigatorIds) {
            FactoryService.getInstance().getFlightServiceImpl().createBrigade(flightId, Long.valueOf(navigatorId));
        }
        String[] radioOperatorIds = request.getParameterValues(AttributeName.RADIO_OPERATOR);
        for (String radioOperatorId : radioOperatorIds) {
            FactoryService.getInstance().getFlightServiceImpl().createBrigade(flightId, Long.valueOf(radioOperatorId));
        }
        String[] stewardessIds = request.getParameterValues(AttributeName.STEWARDESS);
        for (String stewardessId : stewardessIds) {
            FactoryService.getInstance().getFlightServiceImpl().createBrigade(flightId, Long.valueOf(stewardessId));
        }
        FactoryService.getInstance().getFlightServiceImpl().updateStatus(flightId, FlightStatus.NOT_READY);
        return new CommandResponse(PagePath.FLIGHT_COMMAND, CommandResponse.CommandResponseType.REDIRECT);
    }
}
