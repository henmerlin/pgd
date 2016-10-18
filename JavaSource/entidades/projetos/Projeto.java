package entidades.projetos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pgd_projetos_projeto")
public class Projeto {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	@Lob
	private String descricao;

	private Boolean evolucao;
	
	private String nomeGp;
	
	private String telefoneGp;
	
	private String nomeFocal;
	
	private String nomeEspecialista;
	
	private String areaEnvolvida;
	
	private String nomeGpVp;
	
	private String telefoneGpVp;
	
	private String justificativaStatus;
	
	private Boolean impactaCo = false;
		
	@ManyToOne
	private StatusProjeto statusProjeto;
	
	@ManyToOne
	private TipoProjeto tipoProjeto;
	
	private Double saving; 

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getEvolucao() {
		return evolucao;
	}

	public void setEvolucao(Boolean evolucao) {
		this.evolucao = evolucao;
	}

	public String getNomeGp() {
		return nomeGp;
	}

	public void setNomeGp(String nomeGp) {
		this.nomeGp = nomeGp;
	}

	public String getNomeFocal() {
		return nomeFocal;
	}

	public void setNomeFocal(String nomeFocal) {
		this.nomeFocal = nomeFocal;
	}

	public String getNomeEspecialista() {
		return nomeEspecialista;
	}

	public void setNomeEspecialista(String nomeEspecialista) {
		this.nomeEspecialista = nomeEspecialista;
	}

	public String getAreaEnvolvida() {
		return areaEnvolvida;
	}

	public void setAreaEnvolvida(String areaEnvolvida) {
		this.areaEnvolvida = areaEnvolvida;
	}

	public StatusProjeto getStatusProjeto() {
		return statusProjeto;
	}

	public void setStatusProjeto(StatusProjeto statusProjeto) {
		this.statusProjeto = statusProjeto;
	}

	public TipoProjeto getTipoProjeto() {
		return tipoProjeto;
	}

	public void setTipoProjeto(TipoProjeto tipoProjeto) {
		this.tipoProjeto = tipoProjeto;
	}

	public String getNomeGpVp() {
		return nomeGpVp;
	}

	public void setNomeGpVp(String nomeGpVp) {
		this.nomeGpVp = nomeGpVp;
	}

	public String getTelefoneGp() {
		return telefoneGp;
	}

	public void setTelefoneGp(String telefoneGp) {
		this.telefoneGp = telefoneGp;
	}

	public String getTelefoneGpVp() {
		return telefoneGpVp;
	}

	public void setTelefoneGpVp(String telefoneGpVp) {
		this.telefoneGpVp = telefoneGpVp;
	}	

	public String getJustificativaStatus() {
		return justificativaStatus;
	}

	public void setJustificativaStatus(String justificativaStatus) {
		this.justificativaStatus = justificativaStatus;
	}	

	public Boolean getImpactaCo() {
		return impactaCo;
	}

	public void setImpactaCo(Boolean impactaCo) {
		this.impactaCo = impactaCo;
	}	

	public Double getSaving() {
		return saving;
	}

	public void setSaving(Double saving) {
		this.saving = saving;
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
