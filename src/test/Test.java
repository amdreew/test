/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author docente
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       Conexion con=new Conexion();
       Contacto c=new Contacto();
       c.setId(1);
       c.setName("Juan Andres");
       c.setLastName("Osorio B");
       Contacto c2=new Contacto();
       c2.setId(2);
       c2.setName("Alejandro");
       c2.setLastName("Osorio B");
        List<Contacto> list = con.list();
        for (Contacto contacto : list) {
            System.out.println(contacto); 
        }
    }
    
}
