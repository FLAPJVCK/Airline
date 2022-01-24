package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.FactoryDao;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {

    private static final String MAIN_PAGE = "/index.jsp";

    @Override
    public String execute(HttpServletRequest request) throws ServiceException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User currentUser = new User();
        currentUser.setName(name);
        currentUser.setSurname(surname);
        currentUser.setUsername(username);
        currentUser.setPassword(password);
        currentUser.setEmail(email);

        FactoryService.getInstance().getUserServiceImpl().register(currentUser);
        return MAIN_PAGE;
    }
}
