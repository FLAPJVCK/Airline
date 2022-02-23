package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return new CommandResponse(PagePath.MAIN_PAGE, CommandResponse.CommandResponseType.REDIRECT);
    }
}
