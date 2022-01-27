package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class UserEditPageCommand implements Command {
    private static final String CURRENT_PAGE = "current_page";
    private static final String EMPLOYEE_PAGE = "/view/editEmployee.jsp";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, EMPLOYEE_PAGE);
        Long id = Long.valueOf(request.getParameter("id"));
        Optional<User> user = FactoryService.getInstance().getUserServiceImpl().findById(id);
        request.getSession().setAttribute("employee", user.get());
        return new CommandResponse(EMPLOYEE_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
