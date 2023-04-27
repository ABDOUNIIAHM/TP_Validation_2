package com.example.tp2_validation_m2i.servlets;

import com.example.tp2_validation_m2i.entities.Recipe;
import com.example.tp2_validation_m2i.service.RecipeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/recipe-detail")
public class RecipeDetailServlet extends HttpServlet {
    RecipeService recipeService = new RecipeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("detail"));
        Recipe recipe = recipeService.findById(id);
        req.setAttribute("recipe",recipe);

        req.getRequestDispatcher("WEB-INF/recipe-detail.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
