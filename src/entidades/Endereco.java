package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Endereco implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rua;
	private String cidade;
	private String bairoo;
	private String estado;
	private String complemento;
	@Column(name = "cep", length = 8 )
	private String cep; 
	
	public Endereco(){
		
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairoo() {
		return bairoo;
	}

	public void setBairoo(String bairoo) {
		this.bairoo = bairoo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
