package com.vp.pedagogico.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String status;
	private String obsercacao;
	

	@JsonBackReference
	@OneToOne
	@JoinColumn(name="funcionario_id")
	@MapsId
	private Funcionario funcionarios;
	

	@JsonManagedReference
	@ManyToMany(mappedBy = "professores")
	private List<Disciplina>disciplinas = new ArrayList<>();
	
	
	public Professor() {
	}

	public Professor(Integer id, String status, String obsercacao, Funcionario funcionarios) {
		super();
		this.id = id;
		this.status = status;
		this.obsercacao = obsercacao;
		this.funcionarios = funcionarios;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObsercacao() {
		return obsercacao;
	}

	public void setObsercacao(String obsercacao) {
		this.obsercacao = obsercacao;
	}

	public Funcionario getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionario funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
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
		Professor other = (Professor) obj;
		return Objects.equals(id, other.id);
	}

}
