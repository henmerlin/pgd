package models.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.UsuarioEfika;
import entidades.pps.ControleUsuario;

@Stateless
public class ControleUsuarioServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarUsuario(ControleUsuario controleUsuario) throws Exception {
		
		try {
			
			this.entityManager.persist(controleUsuario);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Controle do Usuário");
			
		}
		
	}
	
	public void modificaUsuario(ControleUsuario controleUsuario) throws Exception {
		
		try {
			
			this.entityManager.merge(controleUsuario);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Controle do Usuário");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ControleUsuario> listarControleUsuario() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM ControleUsuario c");
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<ControleUsuario>();
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioEfika> listaDeUsuario() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM UsuarioEfika u");
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<UsuarioEfika>();
			
		}
		
	}

}
