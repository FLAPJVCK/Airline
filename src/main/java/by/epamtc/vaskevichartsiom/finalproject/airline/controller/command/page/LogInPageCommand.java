package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class LogInPageCommand implements Command {

    private static final String LOGIN_PAGE = "/view/user/authentication.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        return LOGIN_PAGE;
    }
}
