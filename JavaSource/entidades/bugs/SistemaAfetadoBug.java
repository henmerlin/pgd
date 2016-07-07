package entidades.bugs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pgd_bugs_sistema_afetado_bug")
public class SistemaAfetadoBug {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Bug bug;
	
	@ManyToOne
	private SistemaAfetado sistemaAfetado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public SistemaAfetado getSistemaAfetado() {
		return sistemaAfetado;
	}

	public void setSistemaAfetado(SistemaAfetado sistemaAfetado) {
		this.sistemaAfetado = sistemaAfetado;
	}
	
}
