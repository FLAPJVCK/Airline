package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EmployeePageCommand implements Command {

    private static final String CURRENT_PAGE = "current_page";
    private static final String EMPLOYEE_PAGE = "/view/employee.jsp";

    @Override
    public String execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, EMPLOYEE_PAGE);
        List<User> users = FactoryService.getInstance().getUserServiceImpl().getAllUsers();
        request.getSession().setAttribute("employeeList", users);
        return EMPLOYEE_PAGE;
    }
}
