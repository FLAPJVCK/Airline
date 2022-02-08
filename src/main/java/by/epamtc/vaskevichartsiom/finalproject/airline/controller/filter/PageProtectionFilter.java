//package by.epamtc.vaskevichartsiom.finalproject.airline.controller.filter;
//
//import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
//import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRole;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.List;
//
//import static by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandType.*;
//
//@WebFilter(urlPatterns = {"/*"})
//public class PageProtectionFilter implements Filter {
//
//    private static final String COMMAND_QUERY_PARAMETER = "command";
//    private List<String> notAdminCommands;
//    private List<String> notManagerCommands;
//    private List<String> notWorkerCommands;
//
//    public void init(FilterConfig config) {
//        notAdminCommands = List.of(REGISTER_PAGE, LOG_IN_PAGE);
//        notManagerCommands = List.of(REGISTER_PAGE, LOG_IN_PAGE, EMPLOYEE_PAGE, EDIT_USER_PAGE,
//                EDIT_USER, DELETE_USER, CREATE_FLIGHT_PAGE, CREATE_FLIGHT, DELETE_FLIGHT);
//        notWorkerCommands = List.of(REGISTER_PAGE, LOG_IN_PAGE, EMPLOYEE_PAGE, EDIT_USER_PAGE,
//                EDIT_USER, DELETE_USER, FLIGHT_PAGE, CREATE_FLIGHT_PAGE, CREATE_FLIGHT, EDIT_FLIGHT_PAGE,
//                EDIT_FLIGHT, DELETE_FLIGHT, CREATE_BRIGADE_PAGE, CREATE_BRIGADE, BRIGADE_PAGE, UPDATE_FLIGHT_STATUS);
//    }
//
//    public void destroy() {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        String servletPath = httpServletRequest.getParameter(COMMAND_QUERY_PARAMETER) != null ? httpServletRequest.getParameter(COMMAND_QUERY_PARAMETER) : "";
//        HttpSession session = httpServletRequest.getSession();
//        UserRole userRole = session.getAttribute("userRole") != null ? (UserRole) session.getAttribute("userRole") : null;
//        if (userRole != null) {
//            if (userRole.equals(UserRole.ADMIN) && notAdminCommands.contains(servletPath)) {
//                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + PagePath.MAIN_PAGE);
//            }
//            if (userRole.equals(UserRole.MANAGER) && notManagerCommands.contains(servletPath)) {
//                httpServletRequest.getRequestDispatcher(PagePath.MAIN_PAGE).forward(request, response);
//            }
//            if (userRole.equals(UserRole.WORKER) && notWorkerCommands.contains(servletPath)) {
//                httpServletRequest.getRequestDispatcher(PagePath.MAIN_PAGE).forward(request, response);
//            }
//        } else {
//            if (servletPath == LOG_IN || servletPath == REGISTER || servletPath == LOG_IN_PAGE
//                    || servletPath == REGISTER_PAGE || servletPath == CHANGE_LOCALE
//                    || servletPath == ""){
//
//                httpServletRequest.getRequestDispatcher(PagePath.MAIN_PAGE).forward(request, response);
//            } else {
//                chain.doFilter(request, response);
//            }
//        }
//        chain.doFilter(request, response);
//    }
//}
