/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author JohnC. <john.crudo@edu.sait.ca>
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("logout") != null) {
            session.invalidate();
            String message = "You have successfully logged out.";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        } else if (session.getAttribute("sessusername") != null) {
            response.sendRedirect("home");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
        if (username != null && password != null) {
            AccountService account = new AccountService();
            User validUser = account.login(username, password);
            if (validUser != null) {
                session.setAttribute("sessusername", validUser);
                response.sendRedirect("home");
            } else {
                request.setAttribute("message", "Invalid login");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);
            }

        } else {
            String message = "Invalid login";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }

    }
}
