package AtividadeDao;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDAO implements Persistible<Colaborador> {

    private Connection connection;
    private Conexao conexao;

    public ColaboradorDAO(Conexao conexao){
        this.conexao = conexao;
    }


    @Override
    public void save(Colaborador colaborador) {
        connection = conexao.abrir();
        String sql = "insert into Colaborador (id, cpf, nome, endereco, telefone, " +
                "email, quantidadeFilhos, idDepartamento)" + "values(?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = null;

        try {
            pstmt = connection.prepareStatement(sql);

            pstmt.setLong(1, colaborador.getId());
            pstmt.setString(2, colaborador.getCpf());
            pstmt.setString(3, colaborador.getNome());
            pstmt.setString(4, colaborador.getEndereco());
            pstmt.setString(5, colaborador.getTelefone());
            pstmt.setString(6, colaborador.getEmail());
            pstmt.setInt(7, colaborador.getQuantidadeFilhos());
            pstmt.setLong(8, colaborador.getDepartamento().getId());

            pstmt.execute();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            conexao.fechar();
        }

    }

    @Override
    public Colaborador getOne(long id) {
        connection = conexao.abrir();
        Colaborador c = null;
        try{
            Statement sta = connection.createStatement();
            ResultSet elements = sta.executeQuery("select * "
                    + "from Colaborador "
                    + "where id = " + id);

            while (elements.next()) {
                DepartamentoDAO dDAO = new DepartamentoDAO(new Conexao());
                c = new Colaborador(elements.getLong("id"),
                        elements.getString("cpf"),
                        elements.getString("nome"),
                        elements.getString("endereco"),
                        elements.getString("telefone"),
                        elements.getString("email"),
                        elements.getInt("quantidadeFilhos"),
                        dDAO.getOne(elements.getLong("idDepartamento")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            conexao.fechar();
        }
        return c;
    }

    public Colaborador getByName(String nome) {
        connection = conexao.abrir();
        Colaborador c = null;
        try{
            Statement sta = connection.createStatement();
            ResultSet elements = sta.executeQuery("select * "
                    + "from Colaborador "
                    + "where nome like '%" + nome + "%'");

            while (elements.next()) {
                DepartamentoDAO dDAO = new DepartamentoDAO(new Conexao());
                c = new Colaborador(elements.getLong("id"),
                        elements.getString("cpf"),
                        elements.getString("nome"),
                        elements.getString("endereco"),
                        elements.getString("telefone"),
                        elements.getString("email"),
                        elements.getInt("quantidadeFilhos"),
                        dDAO.getOne(elements.getLong("idDepartamento")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            conexao.fechar();
        }
        return c;
    }

    @Override
    public List<Colaborador> getAll() {
        connection = conexao.abrir();
        List<Colaborador> result = new ArrayList<>();
        try {
            Statement sta = connection.createStatement();
            ResultSet elements = sta.executeQuery("SELECT "
                    + "* from Colaborador");

            while(elements.next()){
                DepartamentoDAO dDAO = new DepartamentoDAO(new Conexao());
                Colaborador c = new Colaborador(elements.getLong("id"),
                        elements.getString("cpf"),
                        elements.getString("nome"),
                        elements.getString("endereco"),
                        elements.getString("telefone"),
                        elements.getString("email"),
                        elements.getInt("quantidadeFilhos"),
                        dDAO.getOne(elements.getLong("idDepartamento")));
                result.add(c);
            }
            conexao.fechar();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {

        }
        return result;
    }

    @Override
    public void delete(Colaborador departamento) {
        connection = conexao.abrir();
        String sql = "delete from Livro where id = ?";
        PreparedStatement pstmt;
        try{
            pstmt = connection.prepareStatement(sql);
            //setar os parametros
            pstmt.setLong(1,departamento.getId());
            pstmt.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            conexao.fechar();
        }
    }

    @Override
    public void update(Colaborador colaborador) {
        connection = conexao.abrir();
        try {
            String sql = "update Colaborador set cpf = ?, nome = ?, "
                    + " endereco = ?, telefone = ?, email = ?, quantidadeFilhos = ?, "
                    +"idDepartamento = ? where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, colaborador.getCpf());
            pstmt.setString(2, colaborador.getNome());
            pstmt.setString(3, colaborador.getEndereco());
            pstmt.setString(4, colaborador.getTelefone());
            pstmt.setString(5, colaborador.getEmail());
            pstmt.setInt(6, colaborador.getQuantidadeFilhos());
            pstmt.setLong(7, colaborador.getDepartamento().getId());
            pstmt.setLong(8, colaborador.getId());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fechar();
        }
    }

}
