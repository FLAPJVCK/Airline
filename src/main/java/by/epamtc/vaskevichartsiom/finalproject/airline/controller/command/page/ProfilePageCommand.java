package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

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

    private static final String CURRENT_PAGE = "current_page";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, PagePath.PROFILE_PAGE);
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        Optional<User> userProfile = FactoryService.getInstance().getUserServiceImpl().findById(userId);
        request.getSession().setAttribute("userProfile", userProfile.get());
        List<Flight> currentUserFlightList = FactoryService.getInstance().getFlightServiceImpl().findAllFlightsForUser(userId);
        request.getSession().setAttribute("currentUserFlightList", currentUserFlightList);
        return new CommandResponse(PagePath.PROFILE_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}