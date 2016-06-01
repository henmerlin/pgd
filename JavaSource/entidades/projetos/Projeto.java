package entidades.projetos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Projeto {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty
	private String nomePj;
		
	@Lob
	@NotEmpty
	private String descricao;

	private Boolean impactoCo;
	
	private Boolean evolucao;
	
	@NotEmpty
	private String nomeGpPmo;
	
	@NotEmpty
	private String nomeFocalCo;
	
	@NotEmpty
	private String nomeEspecialista;
	
	@NotEmpty
	private String areaEnv;
		
	private Double conclusaoPj;
		
	public Projeto() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomePj() {
		return nomePj;
	}

	public void setNomePj(String nomePj) {
		this.nomePj = nomePj;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	

	public Boolean getImpactoCo() {
		return impactoCo;
	}

	public void setImpactoCo(Boolean impactoCo) {
		this.impactoCo = impactoCo;
	}

	public Boolean getEvolucao() {
		return evolucao;
	}

	public void setEvolucao(Boolean evolucao) {
		this.evolucao = evolucao;
	}

	public String getNomeGpPmo() {
		return nomeGpPmo;
	}

	public void setNomeGpPmo(String nomeGpPmo) {
		this.nomeGpPmo = nomeGpPmo;
	}

	public String getNomeFocalCo() {
		return nomeFocalCo;
	}

	public void setNomeFocalCo(String nomeFocalCo) {
		this.nomeFocalCo = nomeFocalCo;
	}

	public String getNomeEspecialista() {
		return nomeEspecialista;
	}

	public void setNomeEspecialista(String nomeEspecialista) {
		this.nomeEspecialista = nomeEspecialista;
	}

	public String getAreaEnv() {
		return areaEnv;
	}

	public void setAreaEnv(String areaEnv) {
		this.areaEnv = areaEnv;
	}

	public Double getConclusaoPj() {
		return conclusaoPj;
	}

	public void setConclusaoPj(Double conclusaoPj) {
		this.conclusaoPj = conclusaoPj;
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
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Projeto [id=" + id + "]";
	}

}
