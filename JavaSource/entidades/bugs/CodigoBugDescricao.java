package entidades.bugs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pgd_bugs_codigo_descricao_bug")
public class CodigoBugDescricao {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	@ManyToOne
	private Bug bug;
	
	@ManyToOne
	private CodigoBug codigoBug;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public CodigoBug getCodigoBug() {
		return codigoBug;
	}

	public void setCodigoBug(CodigoBug codigoBug) {
		this.codigoBug = codigoBug;
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
		CodigoBugDescricao other = (CodigoBugDescricao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CodigoBugDescricao [id=" + id + "]";
	}	
	
}
