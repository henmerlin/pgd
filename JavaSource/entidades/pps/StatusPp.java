package entidades.pps;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pdg_pps_Status_pp")
public class StatusPp {
	
	@Id
	@GeneratedValue
	private Integer id;

}
