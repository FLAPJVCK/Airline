package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRank;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRole;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class UserEditPageCommand implements Command {

    private static final String CURRENT_PAGE = "current_page";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, PagePath.EDIT_EMPLOYEE_PAGE);
        Long id = Long.valueOf(request.getParameter("id"));
        Optional<User> user = FactoryService.getInstance().getUserServiceImpl().findById(id);
        request.getSession().setAttribute("employee", user.get());
        List<UserRank> allRanks = FactoryService.getInstance().getUserServiceImpl().findAllRanks();
        List<UserRole> allRoles = FactoryService.getInstance().getUserServiceImpl().findAllRoles();
        request.getSession().setAttribute("allRanks", allRanks);
        request.getSession().setAttribute("allRoles", allRoles);
        return new CommandResponse(PagePath.EDIT_EMPLOYEE_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
