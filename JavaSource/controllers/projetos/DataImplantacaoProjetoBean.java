package controllers.projetos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.DataImplantacaoProjeto;
import entidades.projetos.Projeto;
import java.text.SimpleDateFormat;
import models.projetos.DataImplantacaoProjetoServico;
import util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DataImplantacaoProjetoBean implements Serializable {

    private DataImplantacaoProjeto dataImplantacaoProjeto;

    @EJB
    private DataImplantacaoProjetoServico dataImplantacaoProjetoServico;

    public DataImplantacaoProjetoBean() {

        this.dataImplantacaoProjeto = new DataImplantacaoProjeto();

    }

    public void cadastrarDataImplantacaoProjeto(Projeto projeto) {

        try {

            this.dataImplantacaoProjetoServico.cadastrarDataImplantacaoProjeto(this.dataImplantacaoProjeto, projeto);
            JSFUtil.addInfoMessage("Erro ao cadastar data nova data de implantação");
            this.dataImplantacaoProjeto = new DataImplantacaoProjeto();

        } catch (Exception e) {

            JSFUtil.addErrorMessage(e.getMessage());

        }

    }

    public List<DataImplantacaoProjeto> listarDataImplantacaoProjetoEspecificoProjeto(Projeto projeto) {

        return this.dataImplantacaoProjetoServico.listarDataImplantacaoProjetoEspecificoProjeto(projeto);

    }

    public DataImplantacaoProjeto listarDataImplantacaoProjetoEspecificoProjetoIdOrder(Projeto projeto) {

        try {

            return this.dataImplantacaoProjetoServico.listarDataImplantacaoProjetoEspecificoProjetoIdOrder(projeto);

        } catch (Exception e) {

            JSFUtil.addErrorMessage(e.getMessage());

            return null;

        }

    }

    public String semafaroDate(Date dataImplantacao) {
                
        String semafaroBoolean = "";

        if (dataImplantacao != null) {

            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);

            Date date = calendar.getTime();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fdatec = sdf.format(date);
            String fdatep = sdf.format(dataImplantacao);
            
            if (fdatep.equals(fdatec)) {
                semafaroBoolean = "No dia";
            }else if (dataImplantacao.after(date)) {
                semafaroBoolean = "Depois";
            } else if (dataImplantacao.before(date)) {
                semafaroBoolean = "Antes";
            }
        }
        return semafaroBoolean;
    }

    public DataImplantacaoProjeto getDataImplantacaoProjeto() {
        return dataImplantacaoProjeto;
    }

    public void setDataImplantacaoProjeto(DataImplantacaoProjeto dataImplantacaoProjeto) {
        this.dataImplantacaoProjeto = dataImplantacaoProjeto;
    }

}
