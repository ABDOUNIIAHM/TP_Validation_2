package com.example.tp2_validation_m2i.servlets;

import com.example.tp2_validation_m2i.entities.Recipe;
import com.example.tp2_validation_m2i.entities.User;
import com.example.tp2_validation_m2i.service.UserRecipeService;
import com.example.tp2_validation_m2i.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    UserService userService = new UserService();
    UserRecipeService userRecipeService = new UserRecipeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        System.out.println(email);
        User user = userService.findByEmail(email);
        List<Recipe> recipes = userRecipeService.findAllRecipesByUserId(user.getId());
        System.out.println(recipes);
        req.setAttribute("recipes",recipes);
        req.getRequestDispatcher("WEB-INF/home.jsp").forward(req,resp);
    }
}
