package AtividadeDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private Connection connection; // a ser ultinizado no dao

    private final String URL ="jdbc:mysql://localhost:3306/BD2";

    private final String USER = "root";

    private final String PASSWORD = "691007";

    private final String TPCONEXAO = "com.mysql.jdbc.Driver";


    public Connection abrir(){
        try{
            Class.forName(TPCONEXAO);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        return connection;
    }


    public void fechar(){
        if (connection != null){
            try{
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


}
