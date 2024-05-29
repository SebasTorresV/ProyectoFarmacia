package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Productos;
import modeloDAD.ProductosDAO;

public class CarritoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accion = request.getParameter("accion");

        if (accion.equals("agregar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            ProductosDAO dao = new ProductosDAO();
            Productos producto = dao.getProductoById(id);

            List<Productos> carrito = (List<Productos>) session.getAttribute("carrito");
            if (carrito == null) {
                carrito = new ArrayList<>();
            }
            carrito.add(producto);
            session.setAttribute("carrito", carrito);

            response.sendRedirect("CarritoController?accion=verCarrito");
        } else if (accion.equals("verCarrito")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("vistas/carrito.jsp");
            dispatcher.forward(request, response);
        } else if (accion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            List<Productos> carrito = (List<Productos>) session.getAttribute("carrito");
            if (carrito != null) {
                carrito.removeIf(p -> p.getId() == id);
            }
            session.setAttribute("carrito", carrito);

            response.sendRedirect("CarritoController?accion=verCarrito");
        } else if (accion.equals("agregarProductos")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("vistas/listarProductosParaCarrito.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controlador para manejar el carrito de compras";
    }
}
