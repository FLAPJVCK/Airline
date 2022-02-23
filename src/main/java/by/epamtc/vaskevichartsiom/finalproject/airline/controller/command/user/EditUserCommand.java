package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.AttributeName;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRank;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRole;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class EditUserCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(AttributeName.CURRENT_PAGE, PagePath.EMPLOYEE_COMMAND);
        Long id = Long.valueOf(request.getParameter(AttributeName.USER_ID));
        String name = request.getParameter(AttributeName.NAME);
        String surname = request.getParameter(AttributeName.SURNAME);
        String username = request.getParameter(AttributeName.USERNAME);
        String password = request.getParameter(AttributeName.PASSWORD);
        String email = request.getParameter(AttributeName.EMAIL);
        String rankName = request.getParameter(AttributeName.RANK_NAME).toUpperCase();
        String roleName = request.getParameter(AttributeName.ROLE_NAME).toUpperCase();

        User currentUser = new User();
        currentUser.setId(id);
        currentUser.setName(name);
        currentUser.setSurname(surname);
        currentUser.setUsername(username);
        currentUser.setPassword(password);
        currentUser.setEmail(email);
        currentUser.setUserRank(UserRank.valueOf(rankName));
        currentUser.setUserRole(UserRole.valueOf(roleName));

        FactoryService.getInstance().getUserServiceImpl().updateUser(currentUser);
        return new CommandResponse(PagePath.EMPLOYEE_COMMAND, CommandResponse.CommandResponseType.REDIRECT);
    }
}
