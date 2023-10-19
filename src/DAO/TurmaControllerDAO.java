package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import entidades.Turma;

public class TurmaControllerDAO implements IDAO<Turma>{
	EntityManagerFactory emf;
	EntityManager em;
	
	private Turma turma = null;
	
	public TurmaControllerDAO() {
		 emf = Persistence.createEntityManagerFactory("aluno");
		 em = emf.createEntityManager();
	}

	@Override
	public Turma  salvar(Turma nv_turma) {
		try{
			em.getTransaction().begin();
			//realiza um crete se não setar matricula
			if(nv_turma.getCodigo_turma() == null){
				em.persist(nv_turma);
				
			}else{
				em.merge(nv_turma); //realiza update caso set uma matricula
			}
			
			
			em.getTransaction().commit();
			
		}catch(Exception e){
			
			em.getTransaction().rollback();
			
		}finally{
			emf.close();
		}
		
		return turma;
	}

	@Override
	public Turma  remover(int id) {
		try{
			turma = em.find(Turma.class, id);
			
			em.getTransaction().begin();
			em.remove(turma);
			em.getTransaction().commit();
			
		}catch(Exception e){
			System.err.println(e);
			em.getTransaction().rollback();
			
		}finally{
			emf.close();
		}
		
		return turma;
	}

	@Override
	public Turma buscar(int id) {
		try{
			turma = em.find(Turma .class,id);
			
		}catch(Exception e){
			System.err.println(e);
			
		}finally{
			emf.close();
		}
		
		return turma;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> listar() {
		em.getTransaction().begin();
		List<Turma> lista = null;
		try{
			lista = em.createQuery("from Turma t").getResultList();
			
		}catch(Exception e){
			System.err.println(e);
			
		}finally{
			em.close();
		}
		return lista;
	}

}
