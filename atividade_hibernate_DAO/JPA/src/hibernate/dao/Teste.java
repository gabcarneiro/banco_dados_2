package hibernate.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Teste {
	
	public static void main(String[] args) {
		
		LivroDAO lDAO = new LivroDAO();
		
		Livro liv = new Livro();
		liv.setAutor("Para");
		liv.setTitulo("Ruby for Pros");
		
		Livro liv2 = new Livro();
		liv2.setAutor("Ximbinha");
		liv2.setTitulo("Java for Dummies");
		
		lDAO.save(liv);
		lDAO.delete(new Livro(8));
		
		for (Livro l : lDAO.getAll()) {
			System.out.println(l);
		};
	
	}

}
