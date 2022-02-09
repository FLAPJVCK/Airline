package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LogInCommand implements Command {

    private static final String MAIN_PAGE = "/index.jsp";
    private static final String LOGIN_PAGE = "/view/access/authentication.jsp";
    public static final String WRONG_DATA = "wrongData";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        Optional<User> optionalUser = FactoryService.getInstance().getUserServiceImpl().logIn(email, password);
        HttpSession session = request.getSession();
        if (optionalUser.isPresent()) {
            session.setAttribute("userId", optionalUser.get().getId());
            session.setAttribute("userRole", optionalUser.get().getUserRole());
        } else {
            request.setAttribute(WRONG_DATA, true);
            return new CommandResponse(LOGIN_PAGE, CommandResponse.CommandResponseType.FORWARD);
        }
        return new CommandResponse(MAIN_PAGE, CommandResponse.CommandResponseType.REDIRECT);
    }
}
