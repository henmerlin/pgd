package models.projetos;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.primefaces.model.UploadedFile;

import entidades.projetos.FilesProjetoUpload;
import entidades.projetos.Projeto;
import util.JSFUtil;

@Stateless
public class UpDownLoadServico {

	@PersistenceContext(unitName="vu")  
	private EntityManager entityManager;

	public void upload(UploadedFile file, Projeto projeto) {

		try {

			byte[] conteudo = file.getContents();

			String extencion = file.getFileName().substring(file.getFileName().lastIndexOf('.'), file.getFileName().length());

			String path = "C:\\UploadedFiles\\" + JSFUtil.gerarStringAleatoria(6) + extencion;

			FileOutputStream fos = new FileOutputStream(path);

			fos.write(conteudo);		
			fos.close();

			this.salvarDadosUpload(projeto, path, file.getFileName());

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}


	public void salvarDadosUpload(Projeto projeto, String path, String nome) {

		try {

			FilesProjetoUpload filesProjetoUpload = new FilesProjetoUpload();
			Date date = new Date();


			filesProjetoUpload.setNome(nome);
			filesProjetoUpload.setPath(path);
			filesProjetoUpload.setProjeto(projeto);
			filesProjetoUpload.setDataRegistro(date);

			this.entityManager.persist(filesProjetoUpload);

		} catch (Exception e) {

			JSFUtil.addErrorMessage("Erro ao cadastrar Arquivos para upload");

		}

	}


	@SuppressWarnings("unchecked")
	public List<FilesProjetoUpload> listarFilesProjetoUpload(Projeto projeto) {

		try {

			Query query = this.entityManager.createQuery("FROM FilesProjetoUpload f WHERE f.projeto =:param1");
			query.setParameter("param1", projeto);
			return query.getResultList();			

		} catch (Exception e) {

			return new ArrayList<FilesProjetoUpload>();

		}

	}

	public void removerArquivoFisico(FilesProjetoUpload filesProjetoUpload) throws Exception {

		try {

			this.removerFilesProjetoUpload(filesProjetoUpload);

			File file = new File(filesProjetoUpload.getPath());

			if (file.exists()) {

				file.delete();				

			}

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		}

	}


	public void removerFilesProjetoUpload(FilesProjetoUpload filesProjetoUpload) throws Exception {

		try {

			this.entityManager.remove(this.entityManager.contains(filesProjetoUpload) ? filesProjetoUpload : this.entityManager.merge(filesProjetoUpload));

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		}

	}	

}
