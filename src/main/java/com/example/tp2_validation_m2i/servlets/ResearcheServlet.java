package com.example.tp2_validation_m2i.servlets;
import com.example.tp2_validation_m2i.entities.Recipe;
import com.example.tp2_validation_m2i.service.RecipeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/researched-recipes")
public class ResearcheServlet extends HttpServlet {
    RecipeService recipeService = new RecipeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String criteria = req.getParameter("search");
        List<Recipe> foundRecipes = null;
        if(criteria.equals("title")){
            String title = req.getParameter("research");
            foundRecipes = recipeService.findByTitle(title);
        }else{
            String ingredients = req.getParameter("research");
            foundRecipes = recipeService.findByIngredients(ingredients);
        }
        req.setAttribute("foundPosts",foundRecipes);
        req.getRequestDispatcher("/WEB-INF/researched-recipes.jsp").forward(req, resp);
    }
}
