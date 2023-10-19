package DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




import entidades.Aluno;


public class AlunoController implements IDAO<Aluno> {
	
	EntityManagerFactory emf;
	EntityManager em;
	private Aluno aluno = null;
	
	
	public  AlunoController (){
		emf = Persistence.createEntityManagerFactory("aluno");
		em = emf.createEntityManager();
	}
	
	public Aluno salvar(Aluno novoAluno){
		
	
		try{
			
			//realiza um crete se não setar matricula
			if(novoAluno.getMatricula() == null){
				em.persist(novoAluno);
				
			}else{
				em.merge(novoAluno); //realiza update caso set uma matricula
				
				System.out.println("aluno Atualizado");
				
				
			}
			
			
			em.getTransaction().commit();
			
		}catch(Exception e){
			
			em.getTransaction().rollback();
			
		}finally{
			emf.close();
		}
		
		return aluno;
	}
	//deleta por matricula
	public Aluno remover(int matricula){

		try{
			aluno = em.find(Aluno.class, matricula);
			
			em.getTransaction().begin();
			em.remove(aluno);
			em.getTransaction().commit();
			
		}catch(Exception e){
			System.err.println(e);
			em.getTransaction().rollback();
			
		}finally{
			emf.close();
		}
		
		return aluno;
	}
	//buscar por matricula
	public Aluno buscar(int matricula){
		
		try{
			aluno = em.find(Aluno.class, matricula);
			
		}catch(Exception e){
			System.err.println(e);
			
		}finally{
			emf.close();
		}
		
		return aluno;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Aluno>listar(){
		em.getTransaction().begin();
		List<Aluno> lista = null;
		try{
			lista = em.createQuery("from Aluno a").getResultList();
			
		}catch(Exception e){
			System.err.println(e);
			
		}finally{
			em.close();
		}
		return lista;
		
	}

}
