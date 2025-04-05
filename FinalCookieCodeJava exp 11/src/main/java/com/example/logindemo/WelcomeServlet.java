package com.example.logindemo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class WelcomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String sessionUser = (session != null) ? (String) session.getAttribute("username") : null;

        String cookieUser = null;
        for (Cookie c : request.getCookies()) {
            if (c.getName().equals("user")) {
                cookieUser = c.getValue();
                break;
            }
        }

        String urlUser = request.getParameter("user");

        response.setContentType("text/html");
        response.getWriter().println("<h1>Welcome " + sessionUser + "</h1>");
        response.getWriter().println("<p>Session: " + sessionUser + "</p>");
        response.getWriter().println("<p>Cookie: " + cookieUser + "</p>");
        response.getWriter().println("<p>URL Param: " + urlUser + "</p>");
        response.getWriter().println("<br><a href='logout'>Logout</a>");
    }
}