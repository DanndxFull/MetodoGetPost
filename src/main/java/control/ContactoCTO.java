/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.ContactoDAO;
import modelo.dto.ContactoDTO;

/**
 *
 * @author PC
 */
public class ContactoCTO extends HttpServlet {

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
        String accion = request.getParameter("accion");
        ContactoDAO dao = new ContactoDAO();
        switch (accion) {
            case "agregar": {
                //1.
                String nombre = request.getParameter("txtnombre");
                String asunto = request.getParameter("txtasunto");
                String correo = request.getParameter("txtcorreo");
                String mensaje = request.getParameter("txtmensaje:");

                //2.
                ContactoDTO dto = new ContactoDTO(nombre, correo, asunto, mensaje);

                //3.
                boolean rest = dao.crear(dto);

                if (rest) {
                    PrintWriter out = response.getWriter();
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<tittle>Respuesta</tittle>");                    
                    out.println("</head>");
                    out.println("<body><h1>Su comentario fue enviado con exito</h1><a href='index.jsp'>Volver</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
                break;
            }
            case "listar": {
                List<ContactoDTO> lista = dao.readAll();
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("<tittle>Respuesta</tittle>");
                out.println("<style>"
                    +"table, th, td {"
                    +"    border: 1px solid black;"
                    +"    border-collapse: collapse;}"
                    +"    "
                    +"    th,td{padding: 15px;}"
                    +"</style>"); 
                out.println("</head>");
                out.println("<body><a href='index.jsp'>Volver </a>");
                out.println("<table>");
                out.println("<th>NOMBRE");
                out.println("</th>");
                out.println("<th>CORREO");
                out.println("</th>");
                out.println("<th>ASUNTO");
                out.println("</th>");
                out.println("<th>COMENTARIO");
                out.println("</th>");
                for (ContactoDTO i : lista) {
                    out.println("<label>" + i + "</label>");
                    out.println("<tr>");
                    out.println("<td>" + i.getNombre());
                    out.println("</td>");
                    out.println("<td>" + i.getCorreo());
                    out.println("</td>");
                    out.println("<td>" + i.getAsunto());
                    out.println("</td>");
                    out.println("<td>" + i.getComentario());
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("</body>");
                    out.println("</html>");
                }
                out.println("</table>");
                break;
            }
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
