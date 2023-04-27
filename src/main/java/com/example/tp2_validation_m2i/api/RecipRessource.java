package com.example.tp2_validation_m2i.api;

import com.example.tp2_validation_m2i.entities.Recipe;
import com.example.tp2_validation_m2i.service.RecipeService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/recipe")
public class RecipRessource {

    RecipeService recipeService = new RecipeService();


    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getAllPosts(){
        List<Recipe> recipes = recipeService.findAllRecipes();
        return Response
                .status(Response.Status.FOUND)
                .entity(recipes)
                .build();
    }
    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getAllPosts(@PathParam("id") int id){
        Recipe recipe = recipeService.findById(id);
        if (recipe != null) {
            return Response
                    .status(Response.Status.FOUND)
                    .entity(recipe)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

}
