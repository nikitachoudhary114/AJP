package com.example.logindemo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "1234".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            Cookie cookie = new Cookie("user", username);
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);

            response.sendRedirect("welcome?user=" + username);
        } else {
            response.getWriter().println("Invalid credentials. <a href='index.jsp'>Try again</a>");
        }
    }
}