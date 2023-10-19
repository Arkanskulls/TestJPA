package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Disciplina;
import entidades.Turno;


public class DisciplinaControllerDAO implements IDAO<Disciplina> {
	EntityManagerFactory emf;
	EntityManager em;
	
	Disciplina disciplina = null;
	
	public DisciplinaControllerDAO() {
		emf = Persistence.createEntityManagerFactory("aluno");
		 em = emf.createEntityManager();

	}

	@Override
	public Disciplina salvar(Disciplina nv_dis) {
		try{
			em.getTransaction().begin();
			//realiza um crete se não setar matricula
			if(nv_dis.getCodDisciplina() == null){
				em.persist(nv_dis);
				
			}else{
				em.merge(nv_dis); //realiza update caso set uma matricula
			}
			
			
			em.getTransaction().commit();
			
		}catch(Exception e){
			
			em.getTransaction().rollback();
			
		}finally{
			emf.close();
		}
		
		return nv_dis;
	}

	@Override
	public Disciplina remover(int id) {
		try{
			disciplina = em.find(Disciplina.class, id);
			
			em.getTransaction().begin();
			em.remove(disciplina);
			em.getTransaction().commit();
			
		}catch(Exception e){
			System.err.println(e);
			em.getTransaction().rollback();
			
		}finally{
			emf.close();
		}
		
		return disciplina;
	}

	@Override
	public Disciplina buscar(int id) {
		try{
			disciplina = em.find(Disciplina.class,id);
			
		}catch(Exception e){
			System.err.println(e);
			
		}finally{
			emf.close();
		}
		
		return disciplina;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Disciplina> listar() {
		em.getTransaction().begin();
		List<Disciplina> lista = null;
		try{
			lista = em.createQuery("from Disciplina d").getResultList();
			
		}catch(Exception e){
			System.err.println(e);
			
		}finally{
			em.close();
		}
		return lista;
	}
	//lista diciplina por turno
	@SuppressWarnings("unchecked")
	public List<Disciplina> listarPorTurno(Turno turno) {
		
			List<Disciplina> lista = null;
			em.getTransaction().begin();
			
				 lista = em.createQuery("SELECT d FROM Disciplina d "+ "WHERE d.curso.turno = Turno").getResultList();
				 em.close();
				 return lista;
			
		}
		
	
	

}
