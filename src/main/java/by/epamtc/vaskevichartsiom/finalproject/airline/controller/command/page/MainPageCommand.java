package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class MainPageCommand implements Command {

    private static final String MAIN_PAGE = "/index.jsp";

    @Override
    public String execute(HttpServletRequest request) {
        return MAIN_PAGE;
    }
}
