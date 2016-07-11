package entidades.bugs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pgd_bugs_sequencia_relatorio_bug")
public class SequenciaRelatorioBug {

	@Id
	@GeneratedValue
	private Integer id;
	
	private Boolean ativo;
	
	@ManyToOne
	private StatusBug statusBug;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public StatusBug getStatusBug() {
		return statusBug;
	}

	public void setStatusBug(StatusBug statusBug) {
		this.statusBug = statusBug;
	}

}
