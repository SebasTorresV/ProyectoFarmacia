/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Clientes;


public interface crud_clientes {
    public List listarClientes();
    public Clientes list(int id);
    public boolean addClientes(Clientes cli);
    public boolean editClientes(Clientes cli);
    public boolean eliminar(int id);
}
