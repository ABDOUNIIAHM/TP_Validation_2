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

@WebServlet(urlPatterns = "/edit-profile")
public class EditProfilServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/edit-profile.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        int id  = userService.findByEmail(email).getId();
        System.out.println(id);
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String password = req.getParameter("password");
        User user = new User(id,firstName,lastName,email,password,null);
        userService.update(user);
        resp.sendRedirect(getServletContext().getContextPath()+"/profil");
    }
}
