/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author Bryan
 */
public interface CRUDUser {
    public List listar();
    public Usuario list(int id);
    public boolean add(Usuario user);
    public boolean edit(Usuario user);
    public boolean eliminar(int id);
}
