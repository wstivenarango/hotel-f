package servlets;

import datos.DBUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Usuario;
import logica.Habitacion;
import logica.Reserva;
import logica.Luxury;
import logica.Sencilla;
import logica.Doble;

@WebServlet(name = "imprimirreserva", urlPatterns = {"/imprimirreserva"})
public class imprimirreserva extends HttpServlet {

    static Habitacion a;

    public static void Liskov(Habitacion e) {
        e.darDescrip();
        a = e;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Usuario u = new Usuario();
        Reserva r = new Reserva();
        u.setNombre(request.getParameter("Nombre"));
        r.setTipo(request.getParameter("Tipo"));
        r.setDias(Integer.parseInt(request.getParameter("dias")));
        u.setId(request.getParameter("id"));
        r.setNum_habitacion(Integer.parseInt(request.getParameter("dias")));
        Doble d = new Doble();
        Luxury l = new Luxury();
        Sencilla s = new Sencilla();
        if ("Sencilla".equals(r.getTipo())) {
            s.setNum_habitacion((int) Math.floor(Math.random() * (110 - 100 + 1) + 100));
            Liskov(s);
        } else {
            if ("Doble".equals(r.getTipo())) {
                d.setNum_habitacion((int) Math.floor(Math.random() * (210 - 200 + 1) + 200));
                Liskov(d);
            } else {
                if ("Luxury".equals(r.getTipo())) {
                    l.setNum_habitacion((int) Math.floor(Math.random() * (210 - 200 + 1) + 200));
                    Liskov(l);
                }
            }
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hotel Real </title>");
            out.println("</head>");
            out.println("<body background= \"imagenes\\zr.jpg\" >");
            out.println("   <link rel= \"stylesheet\" type =\"text/css\" href=\"Estilos\\estilos.css\">");
            out.println("<table>");

            out.println("<tr>");

            out.println("<td>");
            out.println("<h1> NOMBRE:" + u.getNombre() + " </h1>");
            out.println("</td>");
            out.println("<td>");
            out.println("<h1> ID:" + u.getId() + " </h1>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");

            out.println("<td>");
            out.println("<h1> Tipo: </h1>");
            out.println("</td>");
            out.println("<td>");
            out.println("<h1>" + r.getTipo() + "</h1>");
            out.println("</td>");

            out.println("</tr>");

            if ("Luxury".equals(r.getTipo())) {

                out.println("<tr>");
                out.println("<td>");
                out.println("<h1> Habitación:Luxury " + "</h1>");
                out.println("</td>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<td>");
                out.println("<h1> Descripción: " + l.getDescripcion() + "</h1>");
                out.println("</td>");

                out.println("<tr>");
                out.println("<td>");
                out.println("<h1> Fecha de entrada " + r.getDias() + "</h1>");
                out.println("</td>");

                out.println("</tr>");

                out.println("<tr>");

                out.println("<td>");
                out.println("<h1> Numero de habitación: " + l.getNum_habitacion() + "</h1>");
                out.println("</tr>");
            } else {
                if ("Sencilla".equals(r.getTipo())) {

                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<h1> Habitación:Sencilla " + "</h1>");
                    out.println("</td>");
                    out.println("</tr>");

                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<h1> Descripción: " + s.getDescripcion() + "</h1>");
                    out.println("</td>");

                    out.println("<tr>");

                    out.println("<h1> Fecha de salida : " + r.getDias() + "</h1>");
                    out.println("</td>");
                    out.println("</tr>");

                    out.println("<tr>");

                    out.println("<td>");
                    out.println("<h1> Numero de habitación: " + s.getNum_habitacion() + "</h1>");
                    out.println("</tr>");

                } else {
                    if ("Doble".equals(r.getTipo())) {

                        out.println("<tr>");
                        out.println("<td>");
                        out.println("<h1> Habitación:Doble" + "</h1>");
                        out.println("</td>");
                        out.println("</tr>");

                        out.println("<tr>");
                        out.println("<td>");
                        out.println("<h1> Descripción: " + d.getDescripcion() + "</h1>");
                        out.println("</td>");

                        out.println("<tr>");
                        out.println("<td>");
                        out.println("<h1> Fecha de entrada " + r.getDias() + "</h1>");
                        out.println("</td>");

                        out.println("</tr>");

                        out.println("<tr>");

                        out.println("<td>");
                        out.println("<h1> Numero de habitación: " + d.getNum_habitacion() + "</h1>");
                        out.println("</tr>");

                    }
                }
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            DBUsuarios conDb = new DBUsuarios();
            conDb.insertarUsuario(r,u);
            out.println("<table>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td class="
            + "\"links\"><a href=\"Ini\">Ver base de datos</a></td>");
            out.println("<td class=\"links\"><a href=\"insertar_usuario.jsp\">Insertar otro usuario</a></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
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
