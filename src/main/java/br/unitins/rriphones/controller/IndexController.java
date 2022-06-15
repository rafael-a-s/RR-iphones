package br.unitins.rriphones.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.application.Session;
import br.unitins.rriphones.application.Util;
import br.unitins.rriphones.application.VersionException;
import br.unitins.rriphones.model.Cartao;
import br.unitins.rriphones.model.Endereco;
import br.unitins.rriphones.model.Funcao;
import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.repository.UsuarioRepository;

@Named
@ViewScoped
public class IndexController extends Controller<Usuario> implements Serializable {

	private static final long serialVersionUID = 1L;
	private InputStream fotoInputStream = null;
	private Cartao cartao;
	private Endereco end;

	public IndexController() {
		super(new UsuarioRepository());
		entity = (Usuario) Session.getInstance().get("UsuarioLogado");

	}

	@Override
	public void salvar() {
		super.salvarSemLimpar();

		// caso exista uma imagem
		if (getFotoInputStream() != null) {
			// salvando a imagem
			if (!Util.saveImageUsuario(getFotoInputStream(), "png", getEntity().getId())) {
				Util.addErrorMessage("Erro ao salvar. N�o foi poss�vel salvar a imagem do usu�rio.");
				return;
			}
		}
		limpar();
	}

	public void upload(FileUploadEvent event) {
		UploadedFile uploadFile = event.getFile();
		System.out.println("nome arquivo: " + uploadFile.getFileName());
		System.out.println("tipo: " + uploadFile.getContentType());
		System.out.println("tamanho: " + uploadFile.getSize());

		if (uploadFile.getContentType().equals("image/png")) {
			try {
				fotoInputStream = uploadFile.getInputStream();
				System.out.println("inputStream: " + uploadFile.getInputStream().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Util.addInfoMessage("Upload realizado com sucesso.");
			salvar();
		} else {
			Util.addErrorMessage("O tipo da image deve ser png.");
		}

	}

	public void alterarUsuarioLogado() {
		salvar();
		Util.redirect("profile.xhtml");

	}
	//Metodos referente ao endereco
	public void adicionarEndereco() {
		
	}
	// meotodos referentes aos cartões
	public void adicionarCartao() throws RepositoryException, VersionException {
		getCartao().setUsuario(getEntity());
		getEntity().getListaCartao().add(getCartao());
		
		setEntity(getRepo().save(getEntity()));
		
		setCartao(null);
		
	}
	public Funcao[] getFuncaoCartao() {
		return Funcao.values();
	}
	public void deletarCartao(Cartao gift) throws RepositoryException, VersionException {
		
				getEntity().getListaCartao().remove(gift);
				setEntity(getRepo().save(getEntity()));
				Util.redirect("profile.xhtml");
		
		}
		
		

	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		return entity;
	}

	public InputStream getFotoInputStream() {
		return fotoInputStream;
	}

	public void setFotoInputStream(InputStream fotoInputStream) {
		this.fotoInputStream = fotoInputStream;
	}

	public Cartao getCartao() {
		if (cartao == null)
			cartao = new Cartao();
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}
	

}
