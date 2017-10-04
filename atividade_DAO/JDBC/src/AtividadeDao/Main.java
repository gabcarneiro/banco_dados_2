package AtividadeDao;

public class Main {
    public static void main(String[] args) {

        Conexao conexao = new Conexao();

        DepartamentoDAO dpDAO  = new DepartamentoDAO(conexao);

        ColaboradorDAO clDAO = new ColaboradorDAO(conexao);

        Departamento dep = new Departamento(1,"Faturamento");
        Departamento dep1 = new Departamento(2,"Recursos Humanos");

        Colaborador joelma = new Colaborador(2,"111.111.000-66", "Joelma",
                "Rua XV de Novembro, 261", "55-5555-5555", "joelma@calypso.com",
                0, dep1);

        Colaborador ximbinha = new Colaborador(1,"000.000.111.01",
                "Ximbinha", "Rua XV de Novembro, 261", "66-666-666-666",
                "ximbinha@calypso.com",0,dep);

        Colaborador para = new Colaborador(3,"222.222.222-00", "Pará",
                "Rua XV de Novembro, 261", "66-6666-6666", "para@calypso.com",
                0, dep1);


        //dpDAO.save(dep1);
        //clDAO.save(para);
        //clDAO.update(para);

        System.out.println(clDAO.getByName("xim"));
        System.out.println(clDAO.getAll());


    }
}
