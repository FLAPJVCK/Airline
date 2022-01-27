package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command;

public record CommandResponse(String pagePath,
        CommandResponse.CommandResponseType responseContextType) {
    public enum CommandResponseType {
        FORWARD,
        REDIRECT
    }

    public String getPagePath() {
        return pagePath;
    }

    public CommandResponseType getResponseContextType() {
        return responseContextType;
    }
}
