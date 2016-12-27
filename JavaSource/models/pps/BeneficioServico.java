package models.pps;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.pps.Beneficio;

@Stateless
public class BeneficioServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarBeneficio(Beneficio beneficio) throws Exception {

		try {

			List<Beneficio> listaDBeneficio = this.listarBeneficios();

			Integer ultimoLista = listaDBeneficio.size() + 1;

			beneficio.setOrdem(ultimoLista);

			this.entityManager.persist(beneficio);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Benefício");

		}

	}

	public void modificarBeneficio(Beneficio beneficio) throws Exception {

		try {		

			List<Beneficio> listaDBeneficio = this.listarBeneficios();			
			
			Beneficio beneficioEspecifico = this.listarBeneficioEspecifico(beneficio.getId());

			this.ordenarListaBeneficios(beneficio, beneficioEspecifico, listaDBeneficio);

			this.entityManager.merge(beneficio);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Benefício");

		}

	}

	@SuppressWarnings("unchecked")
	public List<Beneficio> listarBeneficiosAtivos() {

		try {

			Query query = this.entityManager.createQuery("FROM Beneficio b WHERE b.ativo =:param1 ORDER BY b.ordem ASC");
			query.setParameter("param1", true);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Beneficio>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<Beneficio> listarBeneficios() {

		try {

			Query query = this.entityManager.createQuery("FROM Beneficio b ORDER BY b.ordem ASC");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Beneficio>();

		}

	}

	public Beneficio listarBeneficioEspecifico(Integer id) {

		try {

			Query query = this.entityManager.createQuery("FROM Beneficio b WHERE b.id =:param1");
			query.setParameter("param1", id);
			return (Beneficio) query.getSingleResult();

		} catch (Exception e) {

			return null;

		}		

	}

	public void ordenarListaBeneficios(Beneficio beneficioNovo, Beneficio beneficioAntigo, List<Beneficio> listaBeneficio) {

		if (beneficioNovo.getOrdem() > beneficioAntigo.getOrdem()) {

			for (Beneficio beneficio : listaBeneficio) {

				if (beneficio.getOrdem() > beneficioAntigo.getOrdem() && beneficio.getOrdem() <= beneficioNovo.getOrdem()) {

					beneficio.setOrdem(beneficio.getOrdem() - 1);

					this.entityManager.merge(beneficio);

				}

			}			

		}

		if (beneficioNovo.getOrdem() < beneficioAntigo.getOrdem()) {

			for (Beneficio beneficio : listaBeneficio) {

				if (beneficio.getOrdem() < beneficioAntigo.getOrdem() && beneficio.getOrdem() >= beneficioNovo.getOrdem()) {

					beneficio.setOrdem(beneficio.getOrdem() + 1);

					this.entityManager.merge(beneficio);

				}

			}			

		}

	}

}
