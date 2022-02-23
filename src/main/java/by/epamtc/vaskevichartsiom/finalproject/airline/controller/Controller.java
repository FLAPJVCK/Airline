package by.epamtc.vaskevichartsiom.finalproject.airline.controller;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandManager;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {

    private static final String COMMAND_QUERY_PARAMETER = "command";
    private static final String APPLICATION_ENCODING = "utf-8";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(APPLICATION_ENCODING);
        response.setCharacterEncoding(APPLICATION_ENCODING);

        String commandName = request.getParameter(COMMAND_QUERY_PARAMETER);
        Command command = CommandManager.getInstance().getCommand(commandName);
        CommandResponse page;
        try {
            page = command.execute(request);
            if (page.getResponseContextType().equals(CommandResponse.CommandResponseType.FORWARD)) {
                request.getRequestDispatcher(page.getPagePath()).forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + page.getPagePath());
            }
        } catch (ServiceException e) {
            response.sendRedirect(request.getContextPath() + PagePath.ERROR_PAGE);
        }
    }
}
