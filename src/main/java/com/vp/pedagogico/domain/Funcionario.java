package com.vp.pedagogico.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String	nome;
	private String	email;
	private String matricula;
	private Long dataAdmissao;
	
	@ManyToOne
	@JoinColumn(name="cargo_id")
	@JsonManagedReference
	private Cargo cargo;
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "funcionarios")
	private List<Regiao> regioes = new ArrayList<>();
	
	
	public Funcionario() {
	}

	
	public Funcionario(Integer id, String nome, String email, String matricula, Long dataAdmissao, Cargo cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
		this.dataAdmissao = dataAdmissao;
		this.cargo = cargo;
	}


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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Long getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Long dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public List<Regiao> getRegioes() {
		return regioes;
	}


	public void setRegioes(List<Regiao> regioes) {
		this.regioes = regioes;
	}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}
}
