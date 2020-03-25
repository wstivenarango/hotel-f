/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import logica.Usuario;
import logica.Reserva;
import datos.DBUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "CargarUsuario", urlPatterns = {"/CargarUsuario"})
public class CargarUsuario extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Usuario c = new Usuario();
        Reserva r = new Reserva();
        DBUsuarios conDB = new DBUsuarios();
        try {
            int conId = Integer.parseInt(request.getParameter("item"));
            String opc = request.getParameter("op");
            out.write(opc);
            ResultSet res = conDB.getUsuarioById(conId);
            if (res.next()) {
                c.setId(("con_id"));
                c.setNombre(res.getString("con_nombre"));
                r.setDias(res.getInt("con_dias"));
                r.setNum_habitacion(res.getInt("con_numhab"));
                r.setTipo(("con_tipo"));
            }

            if (opc.equals("edit")) {
                request.getSession().setAttribute("usuario", c);
                request.getSession().setAttribute("reserva", r);
                response.sendRedirect("editarusuario.jsp");
            }
            if (opc.equals("delete")) {
                conDB.borrarUsuario(r,c);
                response.sendRedirect("Ini");
            }
        } catch (Exception e) {

        } finally {
            out.close();
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
