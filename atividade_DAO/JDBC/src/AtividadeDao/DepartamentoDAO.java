package AtividadeDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO implements Persistible<Departamento> {

    private Connection connection;
    private Conexao conexao;

    public DepartamentoDAO(Conexao conexao){
        this.conexao = conexao;
    }

    @Override
    public void save(Departamento departamento) {
        connection = conexao.abrir();
        String sql = "insert into Departamento (id, nome) values(?,?)";
        PreparedStatement pstmt = null;

        try {
            pstmt = connection.prepareStatement(sql);

            pstmt.setLong(1, departamento.getId());
            pstmt.setString(2, departamento.getNome());


            pstmt.execute();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            conexao.fechar();
        }

    }

    @Override
    public Departamento getOne(long id) {
        connection = conexao.abrir();
        Departamento d = null;
        try{
            Statement sta = connection.createStatement();
            ResultSet elements = sta.executeQuery("select * "
                    + "from Departamento "
                    + "where id = " + id);

            while (elements.next()){
                d = new Departamento(elements.getInt("id"),
                        elements.getString("nome"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            conexao.fechar();
        }
        return d;
    }

    @Override
    public List<Departamento> getAll() {
        connection = conexao.abrir();
        List<Departamento> result = new ArrayList<>();
        try {
            Statement sta = connection.createStatement();
            ResultSet elements = sta.executeQuery("SELECT "
                    + "* from Departamento");

            while(elements.next()){
                Departamento d = new Departamento(elements.getLong("id"),
                        elements.getString("nome"));
                result.add(d);
            }
            conexao.fechar();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {

        }
        return result;
    }

    @Override
    public void delete(Departamento departamento) {
        connection = conexao.abrir();
        String sql = "delete from Departamento where id = ?";
        PreparedStatement pstmt;
        try{
            pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1,departamento.getId());
            pstmt.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            conexao.fechar();
        }
    }

    @Override
    public void update(Departamento departamento) {
        connection = conexao.abrir();
        try {
            String sql = "update Departamento set nome = ? where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, departamento.getNome());
            pstmt.setLong(2, departamento.getId());

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fechar();
        }
    }
}
