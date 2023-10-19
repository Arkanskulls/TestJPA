package DAO;

import java.util.List;



public interface IDAO <O> {
	
	
	public Object salvar(O object);
	
	public Object remover(int id);
	
	public Object buscar(int id);
	
	public List<O>listar();

}
