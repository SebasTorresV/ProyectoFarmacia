package modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Productos> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Productos producto) {
        productos.add(producto);
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void eliminarProducto(int index) {
        if (index >= 0 && index < productos.size()) {
            productos.remove(index);
        }
    }

    public void vaciarCarrito() {
        productos.clear();
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Productos producto : productos) {
            total += producto.getPrecio(); // Suponiendo que hay un método getPrecio() en la clase Productos
        }
        return total;
    }
}
