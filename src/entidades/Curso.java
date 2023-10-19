package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	@Id
	private Integer cod_curso;
	 @Enumerated(EnumType.STRING)
	private Turno turno; 
	 
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
	private List<Disciplina> listaDisciplina;
	
	public Curso(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public List<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}

	public void setListaDisciplina(List<Disciplina> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getCod_curso() {
		return cod_curso;
	}

	public void setCod_curso(Integer cod_curso) {
		this.cod_curso = cod_curso;
	}
	

}
