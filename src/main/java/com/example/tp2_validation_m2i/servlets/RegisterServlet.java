package com.example.tp2_validation_m2i.servlets;

import com.example.tp2_validation_m2i.entities.User;
import com.example.tp2_validation_m2i.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/signup")
public class RegisterServlet extends HttpServlet {
    private static UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/sign-up.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");

        if(userService.findByEmail(email)!=null){
            String error = "Email already used";
            req.setAttribute("error",error);
            req.getRequestDispatcher("WEB-INF/sign-up.jsp").forward(req,resp);
        }else{
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String imgUrl = req.getParameter("photo");
            String password = req.getParameter("password");
            User user = new User(firstName,lastName,email,password,imgUrl);
            userService.create(user);
            resp.sendRedirect(getServletContext().getContextPath()+"/login");
        }






    }
}
