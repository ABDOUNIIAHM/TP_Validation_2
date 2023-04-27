package com.example.tp2_validation_m2i.servlets;

import com.example.tp2_validation_m2i.entities.Recipe;
import com.example.tp2_validation_m2i.entities.User;
import com.example.tp2_validation_m2i.entities.UserRecipe;
import com.example.tp2_validation_m2i.service.RecipeService;
import com.example.tp2_validation_m2i.service.UserRecipeService;
import com.example.tp2_validation_m2i.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/add-recipe")
public class AddRecipe extends HttpServlet {
    RecipeService recipeService = new RecipeService();
    UserRecipeService userRecipeService = new UserRecipeService();
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/add-recipe.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String ingredients = req.getParameter("ingredients");
        String imgUrl = req.getParameter("imgUrl");
        int rating = Integer.parseInt(req.getParameter("rating"));
        LocalDateTime time = LocalDateTime.now();
        Recipe recipe = new Recipe(title,rating,imgUrl,ingredients,time,description);

        Recipe recipCreated = recipeService.create(recipe);
        User user = userService.findByEmail(email);
        int id = user.getId();
        UserRecipe userRecipe = new UserRecipe(id,recipCreated.getId());
        userRecipeService.create(userRecipe);
        System.out.println(recipCreated);

        resp.sendRedirect(getServletContext().getContextPath()+"/home");
    }
}
