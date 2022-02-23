package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.AttributeName;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public class ProfilePageCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(AttributeName.CURRENT_PAGE, PagePath.PROFILE_PAGE);
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(AttributeName.USER_ID);
        Optional<User> userProfile = FactoryService.getInstance().getUserServiceImpl().findById(userId);
        userProfile.ifPresent(user -> request.setAttribute(AttributeName.USER_PROFILE, user));
        List<Flight> currentUserFlightList = FactoryService.getInstance().getFlightServiceImpl().findAllFlightsForUser(userId);
        if (currentUserFlightList.size() != 0){
            request.setAttribute(AttributeName.CURRENT_USER_FLIGHT_LIST, currentUserFlightList);
        } else {
            request.setAttribute(AttributeName.CURRENT_USER_FLIGHT_LIST, AttributeName.EMPTY_FLIGHT_LIST);
        }
        return new CommandResponse(PagePath.PROFILE_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}