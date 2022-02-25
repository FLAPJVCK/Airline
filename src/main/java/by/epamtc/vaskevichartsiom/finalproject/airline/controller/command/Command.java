package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command;

import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

/**
 * The interface Command.
 */
public interface Command {
    /**
     * Execute specified command.
     *
     * @param request the http servlet request.
     * @return command response with specified next page and type of routing.
     * @throws ServiceException if logical errors occurs, and also it's a wrapper for lower errors.
     */
    CommandResponse execute(HttpServletRequest request) throws ServiceException;
}
