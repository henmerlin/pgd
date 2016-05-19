package entidades.projetos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PGD_PROJETO")
public class Projeto {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Status status;
	
	@ManyToOne
	private Impacto impacto;
	
	private String nome;
	
	private Boolean evolucao;
	
	@Lob
	private String descricao;

	private String nomeGP;
	
	private String nomefocal;
	
	private String nomeesp;
	
	private Double percConclusao;
	
	@OneToMany
	private List<FaseProjeto> fases;
	
	@OneToMany
	private List<EnvolvimentoArea> areasEnvolvidas;
	
	public Projeto() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Impacto getImpacto() {
		return impacto;
	}

	public void setImpacto(Impacto impacto) {
		this.impacto = impacto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getEvolucao() {
		return evolucao;
	}

	public void setEvolucao(Boolean evolucao) {
		this.evolucao = evolucao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	

	public String getNomeGP() {
		return nomeGP;
	}

	public void setNomeGP(String nomeGP) {
		this.nomeGP = nomeGP;
	}

	public String getNomefocal() {
		return nomefocal;
	}

	public void setNomefocal(String nomefocal) {
		this.nomefocal = nomefocal;
	}

	public String getNomeesp() {
		return nomeesp;
	}

	public void setNomeesp(String nomeesp) {
		this.nomeesp = nomeesp;
	}

	public Double getPercConclusao() {
		return percConclusao;
	}

	public void setPercConclusao(Double percConclusao) {
		this.percConclusao = percConclusao;
	}

	public List<FaseProjeto> getFases() {
		return fases;
	}

	public void setFases(List<FaseProjeto> fases) {
		this.fases = fases;
	}

	public List<EnvolvimentoArea> getAreasEnvolvidas() {
		return areasEnvolvidas;
	}

	public void setAreasEnvolvidas(List<EnvolvimentoArea> areasEnvolvidas) {
		this.areasEnvolvidas = areasEnvolvidas;
	}

}
