package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class LogInPageCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) {
        return new CommandResponse(PagePath.LOGIN_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
