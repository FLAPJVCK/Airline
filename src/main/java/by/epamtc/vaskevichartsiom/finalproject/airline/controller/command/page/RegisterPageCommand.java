package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class RegisterPageCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) {
        return new CommandResponse(PagePath.REGISTER_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
