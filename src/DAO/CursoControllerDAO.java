package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Curso;



public class CursoControllerDAO implements IDAO<Curso>{
	EntityManagerFactory emf;
	EntityManager em;
	
	Curso curso = null;
	
	 public CursoControllerDAO() {
		 emf = Persistence.createEntityManagerFactory("aluno");
		 em = emf.createEntityManager();
		
	}
	 
	@Override
	public Curso salvar(Curso novo_curso) {
		try{
			em.getTransaction().begin();
			//realiza um crete se não setar matricula
			if(novo_curso.getCod_curso() == null){
				em.persist(novo_curso);
				
			}else{
				em.merge(novo_curso); //realiza update caso set uma matricula
			}
			
			
			em.getTransaction().commit();
			
		}catch(Exception e){
			
			em.getTransaction().rollback();
			
		}finally{
			emf.close();
		}
		
		return novo_curso;
	}
	

	@Override
	public Curso remover(int id) {
		try{
			curso = em.find(Curso.class, id);
			
			em.getTransaction().begin();
			em.remove(curso);
			em.getTransaction().commit();
			
		}catch(Exception e){
			System.err.println(e);
			em.getTransaction().rollback();
			
		}finally{
			emf.close();
		}
		
		return curso;
	}
	

	@Override
	public Curso buscar(int id) {
		try{
			curso = em.find(Curso.class,id);
			
		}catch(Exception e){
			System.err.println(e);
			
		}finally{
			emf.close();
		}
		
		return curso;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listar() {
		em.getTransaction().begin();
		List<Curso> lista = null;
		try{
			lista = em.createQuery("from Curso c").getResultList();
			
		}catch(Exception e){
			System.err.println(e);
			
		}finally{
			em.close();
		}
		return lista;
	}

}
