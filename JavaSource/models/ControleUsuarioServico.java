package models;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.ControleUsuario;
import entidades.UsuarioEfika;

@Stateless
public class ControleUsuarioServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarUsuario(ControleUsuario controleUsuario, List<String> sistemas) throws Exception {
		
		try {
			
			String sis = "";

			for (String string : sistemas) {

				if (!string.isEmpty() || string != null || string != "null") {

					sis = string + ";" + sis;

				}			

			}

			controleUsuario.setSistema(sis);
			
			this.entityManager.persist(controleUsuario);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Controle do Usuário");
			
		}
		
	}
	
	public void modificaUsuario(ControleUsuario controleUsuario, List<String> sistemas) throws Exception {
		
		try {
			
			String sis = "";

			for (String string : sistemas) {

				if (!string.isEmpty() || string != null || string != "null") {

					sis = string + ";" + sis;

				}			

			}
			
			controleUsuario.setSistema(sis);
			
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
	
	public ControleUsuario buscarControleUsuarioEspecifico(UsuarioEfika usuarioEfika) throws Exception {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM ControleUsuario c WHERE c.usuarioEfika =:param1");
			query.setParameter("param1", usuarioEfika);
			
			return (ControleUsuario) query.getSingleResult();
			
		} catch (Exception e) {
			
			throw new Exception("Controle nao encontrado.");
			
		}
		
	}

}
