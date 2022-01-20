package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command {

    private static final String MAIN_PAGE = "/index.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();

        return MAIN_PAGE;
    }
}
