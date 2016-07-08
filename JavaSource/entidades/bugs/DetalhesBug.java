package entidades.bugs;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import util.JSFUtil;

@Entity
@Table(name="pgd_bugs_detalhes_bug")
public class DetalhesBug {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Lob
	private String descricao;

	private Date dataAbertura;
	
	private Integer volume;
	
	private Boolean reincidente;
	
	private Boolean paliativo;
	
	private Boolean priorizado;
	
	@ManyToOne
	private Bug bug;

	@ManyToOne
	private PrioridadeBug prioridadeBug;
	
	@ManyToOne
	private ImpactoBug impactoBug;
	
	@ManyToOne
	private FasesBug fasesBug;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public PrioridadeBug getPrioridadeBug() {
		return prioridadeBug;
	}

	public void setPrioridadeBug(PrioridadeBug prioridadeBug) {
		this.prioridadeBug = prioridadeBug;
	}

	public ImpactoBug getImpactoBug() {
		return impactoBug;
	}

	public void setImpactoBug(ImpactoBug impactoBug) {
		this.impactoBug = impactoBug;
	}

	public FasesBug getFasesBug() {
		return fasesBug;
	}

	public void setFasesBug(FasesBug fasesBug) {
		this.fasesBug = fasesBug;
	}	

	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public String getDataAberturaFormatada() {
		
		return JSFUtil.formatarData(this.dataAbertura);
		
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Boolean getReincidente() {
		return reincidente;
	}

	public void setReincidente(Boolean reincidente) {
		this.reincidente = reincidente;
	}

	public Boolean getPaliativo() {
		return paliativo;
	}

	public void setPaliativo(Boolean paliativo) {
		this.paliativo = paliativo;
	}

	public Boolean getPriorizado() {
		return priorizado;
	}

	public void setPriorizado(Boolean priorizado) {
		this.priorizado = priorizado;
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
		DetalhesBug other = (DetalhesBug) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetalhesBug [id=" + id + "]";
	}	
	
}
