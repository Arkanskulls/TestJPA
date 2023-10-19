package entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Turma {
	private String nome;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_turma;
	
	@ManyToOne(optional = false)
	private Professor professor;
	
	@ManyToMany
	private List<Aluno> listaAlunos;
	
	@ManyToOne(optional = false)
	private Disciplina disciplina;
	
	public Turma(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getListaAluno() {
		return listaAlunos;
	}

	public void setListaAluno(List<Aluno> listaAluno) {
		this.listaAlunos = listaAluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Integer getCodigo_turma() {
		return codigo_turma;
	}

	public void setCodigo_turma(Integer codigo_turma) {
		this.codigo_turma = codigo_turma;
	}

}
