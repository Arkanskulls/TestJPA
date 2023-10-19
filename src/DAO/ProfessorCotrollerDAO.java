package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Professor;

public class ProfessorCotrollerDAO implements IDAO<Professor> {
	EntityManagerFactory emf;
	EntityManager em;
	
	private Professor professor = null;
	
	
    public ProfessorCotrollerDAO() {
    	 emf = Persistence.createEntityManagerFactory("aluno");
		 em = emf.createEntityManager();
	}

	@Override
	public Professor salvar(Professor nv_prof) {
		try{
			em.getTransaction().begin();
			//realiza um crete se não setar matricula
			if(nv_prof.getTitulo() == null){
				em.persist(nv_prof);
				
			}else{
				em.merge(nv_prof); //realiza update caso set uma matricula
			}
			
			
			em.getTransaction().commit();
			
		}catch(Exception e){
			
			em.getTransaction().rollback();
			
		}finally{
			emf.close();
		}
		
		return professor;
	}

	@Override
	public Professor remover(int id) {
		try{
			professor = em.find(Professor.class, id);
			
			em.getTransaction().begin();
			em.remove(professor);
			em.getTransaction().commit();
			
		}catch(Exception e){
			System.err.println(e);
			em.getTransaction().rollback();
			
		}finally{
			emf.close();
		}
		
		return professor;
	}

	@Override
	public Professor buscar(int id) {
		try{
			professor = em.find(Professor.class,id);
			
		}catch(Exception e){
			System.err.println(e);
			
		}finally{
			emf.close();
		}
		
		return professor;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> listar() {
		em.getTransaction().begin();
		List<Professor> lista = null;
		try{
			lista = em.createQuery("from Professor c").getResultList();
			
		}catch(Exception e){
			System.err.println(e);
			
		}finally{
			em.close();
		}
		return lista;
	}

}
