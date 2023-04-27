package com.example.tp2_validation_m2i.servlets;

import com.example.tp2_validation_m2i.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    // initialise UserService()
    UserService userService = new UserService();

    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        System.out.println("req email :"+ email);
        String password = req.getParameter("password");
        session = req.getSession();
        if(userService.validAuthentification(email,password) == null){
            String error = "Bad credentials, try again";
            req.setAttribute("error",error);
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req,resp);
        }else{
            session.setAttribute("email",email);
            resp.sendRedirect(getServletContext().getContextPath()+"/home");
        }


        // call usr service to find by username and check !
        // then store the username in session


    }
}
