package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.AttributeName;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.AirplaneHasRank;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

public class CreateBrigadePageCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(AttributeName.CURRENT_PAGE, PagePath.CREATE_BRIGADE_PAGE);
        Long modelId = Long.valueOf(request.getParameter(AttributeName.MODEL_ID));
        Long flightId = Long.valueOf(request.getParameter(AttributeName.FLIGHT_ID));
        Date flightDate = Date.valueOf(request.getParameter(AttributeName.FLIGHT_DATE));
        request.setAttribute(AttributeName.FLIGHT_ID, flightId);
        List<AirplaneHasRank> airplaneHasRanks = FactoryService.getInstance().getAirplaneHasRanksServiceImpl().findAllAirplaneHasRanksByAirplaneId(modelId);
        List<User> pilots = FactoryService.getInstance().getUserServiceImpl().findAllUsersByRank((long) airplaneHasRanks.get(0).getUserRank().getId(), flightDate);
        request.setAttribute(AttributeName.PILOTS_LIST, pilots);
        request.setAttribute(AttributeName.PILOTS_COUNT, airplaneHasRanks.get(0).getRankCount());
        List<User> navigators = FactoryService.getInstance().getUserServiceImpl().findAllUsersByRank((long) airplaneHasRanks.get(1).getUserRank().getId(), flightDate);
        request.setAttribute(AttributeName.NAVIGATORS_LIST, navigators);
        request.setAttribute(AttributeName.NAVIGATORS_COUNT, airplaneHasRanks.get(1).getRankCount());
        List<User> radioOperators = FactoryService.getInstance().getUserServiceImpl().findAllUsersByRank((long) airplaneHasRanks.get(2).getUserRank().getId(), flightDate);
        request.setAttribute(AttributeName.RADIO_OPERATORS_LIST, radioOperators);
        request.setAttribute(AttributeName.RADIO_OPERATORS_COUNT, airplaneHasRanks.get(2).getRankCount());
        List<User> stewardesses = FactoryService.getInstance().getUserServiceImpl().findAllUsersByRank((long) airplaneHasRanks.get(3).getUserRank().getId(), flightDate);
        request.setAttribute(AttributeName.STEWARDESSES_LIST, stewardesses);
        request.setAttribute(AttributeName.STEWARDESSES_COUNT, airplaneHasRanks.get(3).getRankCount());
        return new CommandResponse(PagePath.CREATE_BRIGADE_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
