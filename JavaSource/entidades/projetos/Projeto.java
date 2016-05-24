package entidades.projetos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Projeto {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nomePj;
	
	private Boolean tipoPj;
	
	@Lob
	private String descricao;

	private Boolean impacto_Co;
	
	private Boolean evolucao;
	
	private String nomeGpPmo;
	
	private String nomeFocalCo;
	
	private String nomeEspecialista;
	
	private String areaEnv;
	
	private Date dataPrevImp;
	
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

	public Boolean getTipoPj() {
		return tipoPj;
	}

	public void setTipoPj(Boolean tipoPj) {
		this.tipoPj = tipoPj;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getImpacto_Co() {
		return impacto_Co;
	}

	public void setImpacto_Co(Boolean impacto_Co) {
		this.impacto_Co = impacto_Co;
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

	public Date getDataPrevImp() {
		return dataPrevImp;
	}

	public void setDataPrevImp(Date dataPrevImp) {
		this.dataPrevImp = dataPrevImp;
	}

	public Double getConclusaoPj() {
		return conclusaoPj;
	}

	public void setConclusaoPj(Double conclusaoPj) {
		this.conclusaoPj = conclusaoPj;
	}	

}
