package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Telefone;

public class TelefoneControllerDAO implements IDAO<Telefone>{
	
	EntityManagerFactory emf;
	EntityManager em;
	
	private Telefone telefone = null;
	
	public TelefoneControllerDAO() {
		emf = Persistence.createEntityManagerFactory("aluno");
		 em = emf.createEntityManager();
	}
	
	@Override
	public Telefone salvar(Telefone nv_tel) {
		try{
			em.getTransaction().begin();
			//realiza um crete se não setar matricula
			if(nv_tel.getNumero() == null){
				em.persist(nv_tel);
				
			}else{
				em.merge(nv_tel); //realiza update caso set uma matricula
			}
			
			
			em.getTransaction().commit();
			
		}catch(Exception e){
			
			em.getTransaction().rollback();
			
		}finally{
			emf.close();
		}
		
		return telefone;
	}

	@Override
	public Telefone remover(int id) {
		try{
			telefone = em.find(Telefone.class, id);
			
			em.getTransaction().begin();
			em.remove(telefone);
			em.getTransaction().commit();
			
		}catch(Exception e){
			System.err.println(e);
			em.getTransaction().rollback();
			
		}finally{
			emf.close();
		}
		
		return telefone;
	}
	@Override
	public Telefone buscar(int id) {
		try{
			telefone = em.find(Telefone.class,id);
			
		}catch(Exception e){
			System.err.println(e);
			
		}finally{
			emf.close();
		}
		
		return telefone;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Telefone> listar() {
		em.getTransaction().begin();
		List<Telefone> lista = null;
		try{
			lista = em.createQuery("from Telefone t").getResultList();
			
		}catch(Exception e){
			System.err.println(e);
			
		}finally{
			em.close();
		}
		return lista;
	}

}
