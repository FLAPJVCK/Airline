package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class RegisterPageCommand implements Command {

    private static final String REGISTER_PAGE = "/view/access/registration.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        return REGISTER_PAGE;
    }
}
