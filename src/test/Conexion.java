/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author docente
 */
public class Conexion {
    public Connection connect() throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con=  DriverManager.getConnection("jdbc:derby://localhost:1527/demo", "demo", "demo");
      return con;
    }
    
    public void save(Contacto c) throws ClassNotFoundException, SQLException{
        Connection con = this.connect();
        PreparedStatement pst = con.prepareStatement("Insert into contactos values(?,?,?)");
        pst.setInt(1,c.getId() );
        pst.setString(2,c.getName() );
        pst.setString(3,c.getLastName());
        pst.executeUpdate();
    }
    public void update(Contacto c) throws ClassNotFoundException, SQLException{
        Connection con = this.connect();
        PreparedStatement pst = con.prepareStatement("update contactos set name=?,last_name=? where id=?");
        pst.setInt(3,c.getId() );
        pst.setString(1,c.getName() );
        pst.setString(2,c.getLastName());
        pst.executeUpdate();
    }
    
    public void delete(Contacto c) throws ClassNotFoundException, SQLException{
        Connection con = this.connect();
        PreparedStatement pst = con.prepareStatement("Delete from contactos where id=?");
        pst.setInt(1,c.getId() );
       
        pst.executeUpdate();
    }
    
     public List<Contacto> list() throws ClassNotFoundException, SQLException{
         List<Contacto> lista=new ArrayList<>();
        Connection con = this.connect();
        PreparedStatement pst = con.prepareStatement("Select * from "
                + "contactos order by name");
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            Contacto c=new Contacto();
            c.setId(rs.getInt(1));
            c.setName(rs.getString(2));
            c.setLastName(rs.getString(3));
            lista.add(c);
            
        }
        return lista;
    }
    
    
}
