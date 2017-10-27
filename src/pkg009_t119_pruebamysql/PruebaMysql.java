/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg009_t119_pruebamysql;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cice
 */
public class PruebaMysql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //1º DATOS DE ACCESO A LA DB MYSQL
        String usuario="root";
        String pass="root";
        String driver="com.mysql.jdbc.Driver";
        String host="jdbc:mysql://localhost:8889/t119";
        
        try {
            Class.forName(driver);
            Connection con =(Connection) DriverManager.getConnection(host, usuario, pass);
            
            String insert ="insert into coches (modelo,color,potencia) VALUES ('kuga','blanco','130cv')";
            Statement st = con.createStatement();
            st.execute(insert);
            
            String sql ="select * from coches";
            ResultSet resultado = st.executeQuery(sql);
            while (resultado.next()){
                System.out.println("Modelo: "+ resultado.getString("modelo"));
                System.out.println("Color: "+ resultado.getString("color"));
                System.out.println("Potencia: " + resultado.getString("potencia"));
                System.out.println("**********************************************");
            }
            resultado.close();
            st.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PruebaMysql.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PruebaMysql.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
        
        
        
        
        
    }
    
}
