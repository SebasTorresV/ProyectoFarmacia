package controlador;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Productos;
import modeloDAD.ProductosDAO;

public class ControladorProductos extends HttpServlet {

    private static final String LISTAR_PRODUCTOS = "vistas/listarProductos.jsp";
    private static final String ADD_PRODUCTOS = "vistas/addProductos.jsp";
    private static final String EDIT_PRODUCTOS = "vistas/editProductos.jsp";
    private ProductosDAO dao = new ProductosDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");

        switch (action) {
            case "listarProductos":
                List<Productos> productos = dao.listarProductos();
                request.setAttribute("productos", productos);
                RequestDispatcher dispatcher = request.getRequestDispatcher(LISTAR_PRODUCTOS);
                dispatcher.forward(request, response);
                break;
            case "addProducto":
                RequestDispatcher dispatcherAdd = request.getRequestDispatcher(ADD_PRODUCTOS);
                dispatcherAdd.forward(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("idProd", id);
                RequestDispatcher dispatcherEdit = request.getRequestDispatcher(EDIT_PRODUCTOS);
                dispatcherEdit.forward(request, response);
                break;
            case "delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(deleteId);
                response.sendRedirect("ControladorProductos?accion=listarProductos");
                break;
            default:
                response.sendRedirect("ControladorProductos?accion=listarProductos");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");

        switch (action) {
            case "saveProducto":
                String nombre = request.getParameter("txtNombre");
                double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                int stock = Integer.parseInt(request.getParameter("txtStock"));
                String descripcion = request.getParameter("txtDescripcion");

                Productos pro = new Productos();
                pro.setNombre(nombre);
                pro.setPrecio(precio);
                pro.setDescripcion(descripcion);
                pro.setStock(stock);
                dao.addProducto(pro);
                response.sendRedirect("ControladorProductos?accion=listarProductos");
                break;
            case "updateProducto":
                int id = Integer.parseInt(request.getParameter("txtid"));
                String updateNombre = request.getParameter("txtNombre");
                double updatePrecio = Double.parseDouble(request.getParameter("txtPrecio"));
                int updateStock = Integer.parseInt(request.getParameter("txtStock"));
                String updateDescripcion = request.getParameter("txtDescripcion");

                Productos updatePro = new Productos();
                updatePro.setIdproductos(id);
                updatePro.setNombre(updateNombre);
                updatePro.setPrecio(updatePrecio);
                updatePro.setStock(updateStock);
                updatePro.setDescripcion(updateDescripcion);
                dao.editProducto(updatePro);
                response.sendRedirect("ControladorProductos?accion=listarProductos");
                break;
            default:
                response.sendRedirect("ControladorProductos?accion=listarProductos");
                break;
        }
    }

    @Override
    public String getServletInfo() {
        return "Controlador de Productos";
    }
}
