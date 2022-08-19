/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.Conexion;
import Interfaz.CRUDUser;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class UsuarioDAO implements CRUDUser{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario u=new Usuario(); 
    
    
    @Override
    public List listar() {
        ArrayList<Usuario>list=new ArrayList<>();
        String sql="select * from Usuario";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuario u=new Usuario();
                u.setId(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("nombreUsuario"));
                u.setApellido(rs.getString("apellidoUsuario"));
                u.setCedula(rs.getString("cedulaUsuario"));
                u.setUser(rs.getString("userUsuario"));
                u.setContrasena(rs.getString("contraseñaUsuario"));
                u.setRol(rs.getString("rolUsuario"));
                u.setEstado(rs.getString("estadoUsuario"));
                Date fnac=new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("nacimientoUsuario"));
                u.setFnacimiento(fnac);
                list.add(u);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Usuario list(int id) {
       String sql="select * from Usuario where idUsuario="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                Usuario u=new Usuario();
                u.setId(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("nombreUsuario"));
                u.setApellido(rs.getString("apellidoUsuario"));
                u.setCedula(rs.getString("cedulaUsuario"));
                u.setUser(rs.getString("userUsuario"));
                u.setContrasena(rs.getString("contraseñaUsuario"));
                u.setRol(rs.getString("rolUsuario"));
                u.setEstado(rs.getString("estadoUsuario"));
                Date fnac=new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("nacimientoUsuario"));
                u.setFnacimiento(fnac);
                
            }
        } catch (Exception e) {
        }
        return u;
    }

    @Override
    public boolean add(Usuario user) {
        int id;
        String nombre,apellido,cedula,contrasena,userlogin,estado,rol;
        Date fnacimiento;
        nombre=user.getNombre();
        apellido=user.getApellido();
        cedula=user.getCedula();
        contrasena=user.getContrasena();
        userlogin=user.getUser();
        estado=user.getEstado();
        rol=user.getRol();
        fnacimiento=user.getFnacimiento();
        String sql="insert into Usuario(nombreUsuario, apellidoUsuario, cedulaUsuario, contraseñaUsuario,"
                + "userUsuario, estadoUsuario, rolUsuario, nacimientoUsuario)values('"+nombre+"','"+apellido+"'"
                + "'"+cedula+"','"+contrasena+"','"+userlogin+"','"+estado+"','"+rol+"','"+fnacimiento+"',)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Usuario user) {
        int id;
        String nombre,apellido,cedula,contrasena,userlogin,estado,rol;
        Date fnacimiento;
        nombre=user.getNombre();
        apellido=user.getApellido();
        cedula=user.getCedula();
        contrasena=user.getContrasena();
        userlogin=user.getUser();
        estado=user.getEstado();
        rol=user.getRol();
        fnacimiento=user.getFnacimiento();
        String sql="update Usuario set nombreUsuario='"+nombre+"',apellidoUsuario='"+apellido+"',"
                + "cedulaUsuario='"+cedula+"',contraseñaUsuario='"+contrasena+"',userUsuario='"
                + ""+userlogin+"',estadoUsuario='"+estado+"',rolUsuario='"+rol+"',nacimientoUsuario='"+fnacimiento+"'where idUsuario="+user.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="update Usuario set estadoUsuario= 'E' where idUsuario="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
