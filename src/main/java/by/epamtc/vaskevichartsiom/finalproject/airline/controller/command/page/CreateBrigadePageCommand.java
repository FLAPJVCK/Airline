package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.AirplaneHasRank;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CreateBrigadePageCommand implements Command {

    private static final String CURRENT_PAGE = "current_page";
    private static final String CREATE_FLIGHT_PAGE = "/view/createBrigade.jsp";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, CREATE_FLIGHT_PAGE);
        Long modelId = Long.valueOf(request.getParameter("modelId"));
        Long flightId = Long.valueOf(request.getParameter("flightId"));
        request.getSession().setAttribute("flightId", flightId);
        List<AirplaneHasRank> airplaneHasRanks = FactoryService.getInstance().getAirplaneHasRanksServiceImpl().findAllAirplaneHasRanksByAirplaneId(modelId);
        List<User> pilots = FactoryService.getInstance().getUserServiceImpl().findAllUsersByRank((long) airplaneHasRanks.get(0).getUserRank().getId());
        request.getSession().setAttribute("pilotsList", pilots);
        request.getSession().setAttribute("pilotsCount", airplaneHasRanks.get(0).getRankCount());
        List<User> navigators = FactoryService.getInstance().getUserServiceImpl().findAllUsersByRank((long) airplaneHasRanks.get(1).getUserRank().getId());
        request.getSession().setAttribute("navigatorsList", navigators);
        request.getSession().setAttribute("navigatorsCount", airplaneHasRanks.get(1).getRankCount());
        List<User> radioOperators = FactoryService.getInstance().getUserServiceImpl().findAllUsersByRank((long) airplaneHasRanks.get(2).getUserRank().getId());
        request.getSession().setAttribute("radioOperatorsList", radioOperators);
        request.getSession().setAttribute("radioOperatorsCount", airplaneHasRanks.get(2).getRankCount());
        List<User> stewardesses = FactoryService.getInstance().getUserServiceImpl().findAllUsersByRank((long) airplaneHasRanks.get(3).getUserRank().getId());
        request.getSession().setAttribute("stewardessesList", stewardesses);
        request.getSession().setAttribute("stewardessesCount", airplaneHasRanks.get(3).getRankCount());
        return new CommandResponse(CREATE_FLIGHT_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
