package by.epamtc.vaskevichartsiom.finalproject.airline.controller;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandManager;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {

    private static final String COMMAND_QUERY_PARAMETER = "command";
    private static final String APPLICATION_ENCODING = "utf-8";

//    @Override
//    public void init() throws ServletException {
//
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding(APPLICATION_ENCODING);
        response.setCharacterEncoding(APPLICATION_ENCODING);

        String commandName = request.getParameter(COMMAND_QUERY_PARAMETER);
        Command command = CommandManager.getInstance().getCommand(commandName);
        String page = null;
        try {
            page = command.execute(request);
        } catch (ServiceException e) {
            e.printStackTrace();
        }



        response.sendRedirect(request.getContextPath() + page);

//        request.getRequestDispatcher("/WEB-INF/view/user/registration.jsp").forward(request, response);

//        String commandName = request.getParameter(COMMAND_QUERY_PARAMETER);
//        Command command = Command.of(commandName);
    }
}
