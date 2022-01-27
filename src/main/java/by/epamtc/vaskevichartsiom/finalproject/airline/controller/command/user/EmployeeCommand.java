package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class EmployeeCommand implements Command {
    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        return null;
    }
}
