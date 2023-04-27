package com.example.tp2_validation_m2i.servlets;

import com.example.tp2_validation_m2i.entities.User;
import com.example.tp2_validation_m2i.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.taglibs.standard.lang.jstl.DivideOperator;

import java.io.IOException;
@WebServlet(urlPatterns = "/profil")
public class ProfilServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        User user = userService.findByEmail(email);
        req.setAttribute("user",user);
        req.getRequestDispatcher("WEB-INF/profil-detail.jsp").forward(req,resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
