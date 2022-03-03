package br.unitins.rriphones.model;




public class Usuario {

	private Integer id;
	private String nome;
	private String cpf;
	private Integer idade;
	private String senha;
	private String apelido;
	
//	@Column
//	private Date dataNascimento;
	
//	private Endereco endereco;
//	private Genero genero;
//	private Telefone telefone;
	
	//construtor  de usuario
	public Usuario() {
		
	}
	
	//Metodos get e set
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
//	public Date getDataNascimento() {
//		return dataNascimento;
//	}
//	public void setDataNascimento(Date dataNascimento) {
//		this.dataNascimento = dataNascimento;
//	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

//	public Endereco getEndereco() {
//		return endereco;
//	}
//
//	public void setEndereco(Endereco endereco) {
//		this.endereco = endereco;
//	}
//
//	public Genero getGenero() {
//		return genero;
//	}
//
//	public void setGenero(Genero genero) {
//		this.genero = genero;
//	}
//
//	public Telefone getTelefone() {
//		return telefone;
//	}
//
//	public void setTelefone(Telefone telefone) {
//		this.telefone = telefone;
//	}
	
	
	
	

}
