package com.example.tp2_validation_m2i.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class Authentification extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if(req.getRequestURI().equals(req.getContextPath() + "/login")||req.getRequestURI().equals(req.getContextPath() + "/home")||req.getRequestURI().equals(req.getContextPath() + "/signup")) { // cette ligne autorise l'accès à l'URI /login
            chain.doFilter(req, res);
        }else{
            if(session.getAttribute("email") != null){ //vérification des bons crédentials
                chain.doFilter(req,res); // autorise la continuité définie dans les servlets
            }else{
                res.sendRedirect(getServletContext().getContextPath()+"/login");
            }
        }
    }
}
