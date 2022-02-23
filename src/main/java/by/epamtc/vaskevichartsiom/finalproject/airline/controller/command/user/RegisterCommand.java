package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.AttributeName;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        String name = request.getParameter(AttributeName.NAME);
        String surname = request.getParameter(AttributeName.SURNAME);
        String username = request.getParameter(AttributeName.SURNAME);
        String password = request.getParameter(AttributeName.PASSWORD);
        String email = request.getParameter(AttributeName.EMAIL);

        User currentUser = new User();
        currentUser.setName(name);
        currentUser.setSurname(surname);
        currentUser.setUsername(username);
        currentUser.setPassword(password);
        currentUser.setEmail(email);

        FactoryService.getInstance().getUserServiceImpl().register(currentUser);
        return new CommandResponse(PagePath.MAIN_PAGE, CommandResponse.CommandResponseType.REDIRECT);
    }
}
