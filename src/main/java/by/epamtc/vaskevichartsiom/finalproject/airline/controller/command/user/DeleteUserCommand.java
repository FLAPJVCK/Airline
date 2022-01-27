package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserCommand implements Command {

    private static final String CURRENT_PAGE = "current_page";
    private static final String EMPLOYEE_PAGE = "/view/employee.jsp";

    @Override
    public String execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, EMPLOYEE_PAGE);
        Long id = Long.valueOf(request.getParameter("id"));
        FactoryService.getInstance().getUserServiceImpl().deleteUser(id);
        return EMPLOYEE_PAGE;
    }
}
