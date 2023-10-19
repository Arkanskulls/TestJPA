package entidades;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa  {

     @Id
	 private String email;
     private String nome; 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
	 private List<Telefone> listaTelefone;
     private String tipo;
     @Embedded
     private Endereco endereco;
     
    
    
    public Pessoa(){
    	
    }
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Telefone> getListaContadoTelefone() {
		return listaTelefone;
	}
	public void setListaContadoTelefone(List<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}



}
