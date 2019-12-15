/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOcompte;
import model.DataSourceFactory;

/**
 *
 * @author Corentin
 */
@WebServlet(name = "changeInfos", urlPatterns = {"/changeInfos"})
public class changeInfos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAOcompte dao = new DAOcompte(DataSourceFactory.getDataSource());

        String nom = request.getParameter("nom");
        String societe = request.getParameter("societe");
        String password = request.getParameter("password");
        String adresse = request.getParameter("adresse");
        String ville = request.getParameter("ville");
        String region = request.getParameter("region");
        String cp = request.getParameter("cp");
        String pays = request.getParameter("pays");
        String tel = request.getParameter("tel");
        String fax = request.getParameter("fax");
        
        ArrayList<String> args = new ArrayList<>();
        args.add(societe);
        args.add(nom);
        args.add("fonction");
        args.add(adresse);
        args.add(ville);
        args.add(region);
        args.add(cp);
        args.add(pays);
        args.add(tel);
        args.add(fax);
        args.add(fax);
        args.add(password);
        
        
        
        
        Properties result = new Properties();
        

        try {
            
            dao.modifierProfil(args);
            
            HttpSession session = request.getSession();
            session.setAttribute("account", dao.rechercheCompte(nom, password));
            
            result.put("test", dao.rechercheCompte(nom, password));

        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            result.put("records", Collections.EMPTY_LIST);
            result.put("message", ex.getMessage());
        }

        try (PrintWriter out = response.getWriter()) {
            // On spécifie que la servlet va générer du JSON
            response.setContentType("application/json;charset=UTF-8");
            // Générer du JSON
            // Gson gson = new Gson();
            // setPrettyPrinting pour que le JSON généré soit plus lisible
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String gsonData = gson.toJson(result);
            out.println(gsonData);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
