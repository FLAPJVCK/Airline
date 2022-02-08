package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

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

    private static final String CURRENT_PAGE = "current_page";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, PagePath.EMPLOYEE_COMMAND);
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String rankName = request.getParameter("rankName").toUpperCase();
        String roleName = request.getParameter("roleName").toUpperCase();

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
