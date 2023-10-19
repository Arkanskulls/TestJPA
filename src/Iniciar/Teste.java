package Iniciar;


import DAO.AlunoController;
import entidades.Aluno;
import entidades.Disciplina;
import entidades.Endereco;
import entidades.Telefone;
import entidades.Turma;

public class Teste {

	public static void main(String[] args) {
		AlunoController con = new AlunoController();
		Turma t = new Turma();
		Endereco end = new Endereco();
		Disciplina dis = new Disciplina();
		Aluno a = new Aluno();
		Telefone tell = new Telefone();
		
		//adicionar aluno
		a.setEmail("gabriel@gmail");
		a.setNome("gabriel");
		a.setMatricula(1);
		a.setTipo("aluno");

		
		con.salvar(a);
		
		
		
		
		

		
		
		
	
		
	

	}

}
