package com.example.logindemo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null) session.invalidate();

        Cookie cookie = new Cookie("user", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        response.sendRedirect("index.jsp");
    }
}