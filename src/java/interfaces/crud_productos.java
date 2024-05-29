/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Empleados;
import modelo.Productos;


public interface crud_productos {
    public List listarProductos();
    public Productos list(int id);
    public boolean addProductos(Productos pro);
    public boolean editProductos(Productos pro);
    public boolean eliminar(int id);
}
