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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOProduit;
import model.DataSourceFactory;

/**
 *
 * @author Corentin
 */
@WebServlet(name = "filtrePhone", urlPatterns = {"/filtrePhone"})
public class filtrePhone extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        DAOProduit dao = new DAOProduit(DataSourceFactory.getDataSource());
        // Properties est une Map<clé, valeur> pratique pour générer du JSON
        Properties resultat = new Properties();

        ArrayList<String> phones = new ArrayList<>();

        if (request.getParameter("Apple") != null) {
            phones.add(request.getParameter("Apple"));
        }
        if (request.getParameter("Samsung") != null) {
            phones.add(request.getParameter("Samsung"));
        }
        if (request.getParameter("Huawei") != null) {
            phones.add(request.getParameter("Huawei"));
        }
        if (request.getParameter("OnePlus") != null) {
            phones.add(request.getParameter("OnePlus"));
        }
        if (request.getParameter("Xiaomi") != null) {
            phones.add(request.getParameter("Xiaomi"));
        }
        if (request.getParameter("Asus") != null) {
            phones.add(request.getParameter("Asus"));
        }
        if (request.getParameter("Sony") != null) {
            phones.add(request.getParameter("Sony"));
        }
        if (request.getParameter("Nokia") != null) {
            phones.add(request.getParameter("Nokia"));
        }
        if (request.getParameter("Oppo") != null) {
            phones.add(request.getParameter("Oppo"));
        }
        String prixMin = "";
        if (request.getParameter("prixMin") != null) {
            prixMin = request.getParameter("prixMin");
        }
        String prixMax = "";
        if (request.getParameter("prixMax") != null) {
            prixMax = request.getParameter("prixMax");
        }
        
        float prixmin = Float.parseFloat(prixMin);
        float prixmax = Float.parseFloat(prixMax);
        
        
        resultat.put("phones", phones);
        resultat.put("prixMin", prixmin);
        resultat.put("prixMax", prixmax);
        resultat.put("test", dao.rechercheParMultipleMarqueEtPrix(phones,prixmin,prixmax));
        
        

        try (PrintWriter out = response.getWriter()) {
            // On spécifie que la servlet va générer du JSON
            response.setContentType("application/json;charset=UTF-8");
            // Générer du JSON
            // Gson gson = new Gson();
            // setPrettyPrinting pour que le JSON généré soit plus lisible
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String gsonData = gson.toJson(resultat);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(filtrePhone.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(filtrePhone.class.getName()).log(Level.SEVERE, null, ex);
        }
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
