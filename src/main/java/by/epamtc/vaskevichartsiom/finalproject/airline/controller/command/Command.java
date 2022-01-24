package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command;

import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request) throws ServiceException;
}
