
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Clientes;
import modelo.Empleados;


public interface crud_empleados {
    public List listarEmpleados();
    public Empleados list(int id);
    public boolean addEmpleados(Empleados cli);
    public boolean editEmpleados(Empleados cli);
    public boolean eliminar(int id);
}