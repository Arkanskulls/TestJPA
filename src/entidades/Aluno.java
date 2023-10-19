package entidades;



import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Aluno")
@DiscriminatorValue("Al")
public class Aluno extends Pessoa  {
	
	 private Integer matricula;
	 
	     @ManyToMany( mappedBy = "listaAlunos")
		private List<Turma> listaTurma;

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public List<Turma> getListaTurma() {
		return listaTurma;
	}

	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}


}
