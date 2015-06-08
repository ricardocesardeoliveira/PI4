package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.PrePedido;
import model.Relatorio;
import model.Veiculo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class RelatorioDao {
    
    public List<PrePedido> listarPorFaixaDeIdade() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from tab_pre_pedido").list();
        t.commit();
        return lista;
    }
    
    
    public List<Relatorio> listarVeiculosMaisVendidos() {
        Connection conn = null;
        Statement stmt = null;
        String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";  
        String DB_URL = "jdbc:derby://localhost:1527/multimarcas";
        List<Relatorio> veiculosMaisVendidos = new ArrayList<>();

   //  Database credentials
        String USER = "rjs";
        String PASS = "123";
        try{
           //STEP 2: Register JDBC driver
           Class.forName(JDBC_DRIVER);

           //STEP 3: Open a connection
           System.out.println("Connecting to a selected database...");
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           System.out.println("Connected database successfully...");

           //STEP 4: Execute a query
           System.out.println("Creating statement...");
           stmt = conn.createStatement();

           String sql = "SELECT Max(V.NOME), Count(PP.ID_VEICULO) FROM TAB_PRE_PEDIDO PP INNER JOIN TAB_VEICULO V ON V.ID_VEICULO = PP.ID_VEICULO GROUP BY V.NOME ORDER BY Count(*) DESC , V.NOME";
           
            //STEP 5: Extract data from result set
            try (ResultSet rs = stmt.executeQuery(sql)) {
                //STEP 5: Extract data from result set
                while(rs.next()){
                    //Retrieve by column name
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                    String veiculo  = rs.getString(1);
                    int qtdeVendida = rs.getInt(2);
                    
                    //Display values  
                    System.out.println("veiculo: " + veiculo);
                    System.out.println("qtdeVendida: " + qtdeVendida);
                    
                    veiculosMaisVendidos.add( new Relatorio(rs.getString(1), rs.getInt(2)) );
                    
                }}
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 conn.close();
           }catch(SQLException se){
           }// do nothing
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        System.out.println("Goodbye!");
        
        return veiculosMaisVendidos;
     }
        
   
    
    
}
