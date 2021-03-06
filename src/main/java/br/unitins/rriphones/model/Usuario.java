package br.unitins.rriphones.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Usuario extends DefaultEntity implements Serializable {
	//ideia: cliente fazer primeiro um cadaastro bem basico
	private static final long serialVersionUID = 264552829892031483L;
	@Column(length = 100)
	private String nome;
	
	@Column(length = 60)
	private String email;
	
	@Column(length = 65)
	private String senha;
	
	@Column(length = 11)
	private String cpf;
	
	@Column
	private Date dataNascimento;
	
	@Column
	private String sexo;
	@Enumerated(EnumType.ORDINAL)
	private Permissao permissao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Telefone telefone;
	
	@OneToMany(targetEntity = br.unitins.rriphones.model.Cartao.class, cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true )
	private List<Cartao> listaCartao;
	
	@OneToMany(targetEntity = br.unitins.rriphones.model.Endereco.class, cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true )
	private List<Endereco> listaEndereco;
	
	//construtor  de usuario
	public Usuario() {
		
	}
	
	
		
	//contrutor para teste no pacger de teste
	public Usuario(String nome, String email, String senha, String cpf, Date dataNascimento, String sexo,
			Telefone telefone, List<Cartao> listaCartao, List<Endereco> listaEndereco) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.telefone = telefone;
		this.listaCartao = listaCartao;
		this.listaEndereco = listaEndereco;
	}
	//Metodos get e set

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Telefone getTelefone() {
		if(telefone == null)
			telefone = new Telefone();
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Cartao> getListaCartao() {
		return listaCartao;
	}

	public void setListaCartao(List<Cartao> listaCartao) {
		this.listaCartao = listaCartao;
	}

	public List<Endereco> getListaEndereco() {
		if(listaEndereco == null)
			listaEndereco = new ArrayList<Endereco>();
		return listaEndereco;
	}

	public void setListaEndereco(List<Endereco> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public Permissao getPermissao() {
		return permissao;
	}



	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	

	

	
	
}
