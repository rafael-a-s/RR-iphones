package br.unitins.rriphones.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.file.UploadedFile;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.application.Util;
import br.unitins.rriphones.application.VersionException;
import br.unitins.rriphones.controller.listing.IphoneListing;
import br.unitins.rriphones.controller.listing.ModeloListing;
import br.unitins.rriphones.model.Cor;
import br.unitins.rriphones.model.Iphone;
import br.unitins.rriphones.model.Modelo;
import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.repository.IphoneRepository;
import br.unitins.rriphones.repository.ModeloRepository;

@Named
@ViewScoped
public class ManagerIphoneController extends Controller<Iphone> implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private List<Iphone> list;
	private String nomePesquisa;
	private InputStream imagem = null;

	
	public ManagerIphoneController() {
		super(new IphoneRepository());
	}
	public void abrirIphoneListing() { //abir a lista de usuario
		IphoneListing listing = new IphoneListing();
		listing.open();
	}
	public void obterIphoneListing(SelectEvent<Iphone> event) {
		setEntity(event.getObject());
	}
	
	@Override
	public void salvar() {
		finlizarDadosEstoque();
		super.salvarSemLimpar();
		if (getImagem() != null) {
			// salvando a imagem
			if (! Util.saveImageIphone(getImagem(), "png", getEntity().getId())) {
				Util.addErrorMessage("Erro ao salvar. N�o foi poss�vel salvar a imagem do usu�rio.");
				return;
			}
		}
		limpar();
	
	}
	@Override
	public void alterar() {
		super.salvarSemLimpar();
			
		// caso exista uma imagem
		if (getImagem() != null) {
			// salvando a imagem
			if (! Util.saveImageIphone(getImagem(), "png", getEntity().getId())) {
				Util.addErrorMessage("Erro ao salvar. N�o foi poss�vel salvar a imagem do usu�rio.");
				return;
			}
		}
		limpar();
	}
	public Cor[] getCorEnum() {
		return Cor.values();
	}
	public Integer getNumeroDeCores() {
		return Cor.values().length;
	}
	//Modelo=====================================================
	public void salvarModelo() {
		ModeloRepository repo = new ModeloRepository();
		try {
			repo.save(getEntity().getModelo());
		} catch (RepositoryException e) {
			System.out.println("Erro ao salvar o modelo");
			e.printStackTrace();
		} catch (VersionException e) {
			System.out.println("Erro na versão");
			e.printStackTrace();
		}
	}
	public void abrirModeloListing() { //abir a lista de modelos
		ModeloListing listing = new ModeloListing();
		listing.open();
	}
	public void obterModeloListing(SelectEvent<Modelo> event) {
		getEntity().setModelo(event.getObject());
		
	}
	
	//Auto complete De modelo=====================================================
	public List<Modelo> completeEstado(String fitro){
		ModeloRepository repo = new ModeloRepository();
		
		try {
			return repo.findByModelo(fitro, 4);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Modelo>();
		}
	}
	//Imagem======================================================================
	
	public void upload(FileUploadEvent event) {//evento > contem a foto
		UploadedFile uploadFile = event.getFile(); // uploadFile recebendo a imagem
		System.out.println("nome arquivo: " + uploadFile.getFileName());
		System.out.println("tipo: " + uploadFile.getContentType());
		System.out.println("tamanho: " + uploadFile.getSize());

		if (uploadFile.getContentType().equals("image/png")) {
			try {
				imagem = uploadFile.getInputStream();
				System.out.println("inputStream: " + uploadFile.getInputStream().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Util.addInfoMessage("Upload realizado com sucesso.");
			
		} else {
			Util.addErrorMessage("O tipo da image deve ser png.");
		}

	}
	//Preenchendo dados de estoque
	protected void finlizarDadosEstoque() {
		getEntity().getEstoque().setDataEntrada(new Date());
		
		if(getEntity().getEstoque().getQuantidade() > 0)
			getEntity().getEstoque().setInStok(true);
	}
	@Override
	public Iphone getEntity() {
		if(entity == null)
			entity = new Iphone();
		return entity;
	}

	public List<Iphone> getList() {
		if(list == null)
			list = new ArrayList<Iphone>();
		return list;
	}

	public void setList(List<Iphone> list) {
		this.list = list;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

	public InputStream getImagem() {
		return imagem;
	}

	public void setImagem(InputStream imagem) {
		this.imagem = imagem;
	}

	
}
