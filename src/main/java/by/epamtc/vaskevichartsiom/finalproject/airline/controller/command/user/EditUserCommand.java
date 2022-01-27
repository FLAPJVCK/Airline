package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class EditUserCommand implements Command {
    private static final String CURRENT_PAGE = "current_page";
    private static final String CURRENT_EMPLOYEE_PAGE = "/view/employee.jsp";
    private static final String EMPLOYEE_PAGE = "/Controller?command=employeePage";


    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, EMPLOYEE_PAGE);
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Long rankId = Long.valueOf(request.getParameter("rankId"));
        Long roleId = Long.valueOf(request.getParameter("roleId"));

        User currentUser = new User();
        currentUser.setId(id);
        currentUser.setName(name);
        currentUser.setSurname(surname);
        currentUser.setUsername(username);
        currentUser.setPassword(password);
        currentUser.setEmail(email);
        currentUser.setRankId(rankId);
        currentUser.setRoleId(roleId);

        FactoryService.getInstance().getUserServiceImpl().updateUser(currentUser);
        return new CommandResponse(EMPLOYEE_PAGE, CommandResponse.CommandResponseType.REDIRECT);
    }
}
