package by.epamtc.vaskevichartsiom.finalproject.airline.service;

import by.epamtc.vaskevichartsiom.finalproject.airline.service.impl.AirplaneServiceImpl;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.impl.DestinationServiceImpl;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.impl.FlightServiceImpl;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.impl.UserServiceImpl;

public class FactoryService {

    private static final FactoryService instance = new FactoryService();

    private UserService userServiceImpl = new UserServiceImpl();

    private FlightService flightServiceImpl = new FlightServiceImpl();

    private DestinationService destinationServiceImpl = new DestinationServiceImpl();

    private AirplaneService airplaneServiceImpl = new AirplaneServiceImpl();

    public FactoryService() {
    }

    public static FactoryService getInstance() {
        return instance;
    }

    public UserService getUserServiceImpl() {
        return userServiceImpl;
    }

    public void setUserServiceImpl(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    public FlightService getFlightServiceImpl() {
        return flightServiceImpl;
    }

    public void setFlightServiceImpl(FlightService flightServiceImpl) {
        this.flightServiceImpl = flightServiceImpl;
    }

    public DestinationService getDestinationServiceImpl() {
        return destinationServiceImpl;
    }

    public void setDestinationServiceImpl(DestinationService destinationServiceImpl) {
        this.destinationServiceImpl = destinationServiceImpl;
    }

    public AirplaneService getAirplaneServiceImpl() {
        return airplaneServiceImpl;
    }

    public void setAirplaneServiceImpl(AirplaneService airplaneServiceImpl) {
        this.airplaneServiceImpl = airplaneServiceImpl;
    }
}
