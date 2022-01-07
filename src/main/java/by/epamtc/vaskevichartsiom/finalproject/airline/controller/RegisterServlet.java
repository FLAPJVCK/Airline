package by.epamtc.vaskevichartsiom.finalproject.airline.controller;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.FactoryDao;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User currentUser = new User();
        currentUser.setName(name);
        currentUser.setSurname(surname);
        currentUser.setUsername(username);
        currentUser.setPassword(password);
        currentUser.setEmail(email);

        try {
            FactoryDao.getInstance().getUserDaoImpl().register(currentUser);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }
}
