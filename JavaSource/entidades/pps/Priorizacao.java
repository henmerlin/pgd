package entidades.pps;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pdg_pps_Priorizacao")
public class Priorizacao {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer nota;
	
	private Double saving;
	
	@ManyToOne
	private Pp pp;
	
	@ManyToOne
	private Prioridade prioridade;

	@ManyToOne
	private Beneficio beneficio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Double getSaving() {
		return saving;
	}

	public void setSaving(Double saving) {
		this.saving = saving;
	}

	public Pp getPp() {
		return pp;
	}

	public void setPp(Pp pp) {
		this.pp = pp;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Priorizacao other = (Priorizacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Priorizacao [id=" + id + "]";
	}	
	
}
