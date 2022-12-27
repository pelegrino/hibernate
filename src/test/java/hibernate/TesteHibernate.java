package hibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setNome("Kátia");
		pessoa.setSobrenome("Pelegrino");
		pessoa.setIdade(44);
		pessoa.setEmail("katiapelegrino@gmail.com");
		pessoa.setLogin("katiapelegrino");
		pessoa.setSenha("123456");
		
		daoGeneric.salvar(pessoa);
	}

}
