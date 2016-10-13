package controllers.projetos;

import java.io.FileInputStream;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import entidades.projetos.FilesProjetoUpload;
import entidades.projetos.Projeto;
import models.projetos.UpDownLoadServico;
import util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UpDownLoadBean implements Serializable {
	
	private Projeto projeto;
	
	private FilesProjetoUpload filesProjetoUpload;
	
	private String path;
	
	private List<FilesProjetoUpload> listaFilesProjetoUpload;
	
	private StreamedContent file;
		
	@EJB
	private UpDownLoadServico upDownLoadServico;

	public UpDownLoadBean() {
		
		
	}
	
	public void upload(FileUploadEvent event) {
		
		UploadedFile file = event.getFile();
		
		try {
			
			this.upDownLoadServico.upload(file, this.projeto);
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void salvaPath(FilesProjetoUpload filesProjetoUpload) throws Exception {
		
		this.filesProjetoUpload = filesProjetoUpload;
		
		this.download();
		
	}
	
	public void download() throws Exception {
		
		String contetType;
		
		contetType = FacesContext.getCurrentInstance().getExternalContext().getMimeType(this.filesProjetoUpload.getPath());
		
		this.file = new DefaultStreamedContent(new FileInputStream(this.filesProjetoUpload.getPath()), contetType, this.filesProjetoUpload.getNome());
				
	}
	
	public void listaDeArquivosDownload(Projeto projeto) {
		
		this.projeto = projeto;
		
		this.listaFilesProjetoUpload = this.upDownLoadServico.listarFilesProjetoUpload(projeto);
		
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<FilesProjetoUpload> getListaFilesProjetoUpload() {
		return listaFilesProjetoUpload;
	}

	public void setListaFilesProjetoUpload(List<FilesProjetoUpload> listaFilesProjetoUpload) {
		this.listaFilesProjetoUpload = listaFilesProjetoUpload;
	}

	public StreamedContent getFile() {
		return file;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}	

}
