package entidades.pps;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pdg_pps_FasePp")
public class FasePp {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	private Boolean ativo;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	private Integer porcentagem;
	
	@Lob
	private String descricao;
	
	@ManyToOne
	private Pp pp;

	@ManyToOne
	private FasePp fasePp;
	
	@ManyToOne
	private StatusFasePp statusFasePp;
	
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}	

	public Pp getPp() {
		return pp;
	}

	public void setPp(Pp pp) {
		this.pp = pp;
	}

	public FasePp getFasePp() {
		return fasePp;
	}

	public void setFasePp(FasePp fasePp) {
		this.fasePp = fasePp;
	}

	public StatusFasePp getStatusFasePp() {
		return statusFasePp;
	}

	public void setStatusFasePp(StatusFasePp statusFasePp) {
		this.statusFasePp = statusFasePp;
	}	

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Integer getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(Integer porcentagem) {
		this.porcentagem = porcentagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		FasePp other = (FasePp) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FasePp [id=" + id + "]";
	}
	
}
