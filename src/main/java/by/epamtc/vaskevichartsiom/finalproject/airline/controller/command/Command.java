package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request);
}
