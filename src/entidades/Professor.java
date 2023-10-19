package entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="email")
@DiscriminatorValue("Prof")
public class Professor extends Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private String titulo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
	private List<Turma> listaTurma;
	
	public Professor(){
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Turma> getListaTurma() {
		return listaTurma;
	}

	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
