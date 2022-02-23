package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

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
import java.util.List;
import java.util.Optional;

public class UserEditPageCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(AttributeName.CURRENT_PAGE, PagePath.EDIT_EMPLOYEE_PAGE);
        Long id = Long.valueOf(request.getParameter(AttributeName.USER_ID));
        Optional<User> user = FactoryService.getInstance().getUserServiceImpl().findById(id);
        user.ifPresent(value -> request.setAttribute(AttributeName.EMPLOYEE, value));
        List<UserRank> allRanks = FactoryService.getInstance().getUserServiceImpl().findAllRanks();
        List<UserRole> allRoles = FactoryService.getInstance().getUserServiceImpl().findAllRoles();
        request.setAttribute(AttributeName.ALL_RANKS, allRanks);
        request.setAttribute(AttributeName.ALL_ROLES, allRoles);
        return new CommandResponse(PagePath.EDIT_EMPLOYEE_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
