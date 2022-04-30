package com.vp.pedagogico.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String nomeAbreviado;
	private String codigo;
	private Date carga;
	private String formato;
	private Date horario;
	private String aulaSimu;
	private String multiProfe;
	private String status;
	private String observacao;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name="PROFESSOR_DISCIPLINA",
		joinColumns = @JoinColumn(name="disciplina_id"),
		inverseJoinColumns = @JoinColumn(name="professor_id")
	)
	private List<Professor> professores = new ArrayList<>();
	
	@JsonBackReference
	@ManyToMany(mappedBy = "disciplinas")
	private List<Curso> cursos = new ArrayList<>();
	
	public Disciplina() {
	}

	public Disciplina(Integer id, String nome, String nomeAbreviado, String codigo, Date carga, String formato,
			Date horario, String aulaSimu, String multiProfe, String status, String observacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeAbreviado = nomeAbreviado;
		this.codigo = codigo;
		this.carga = carga;
		this.formato = formato;
		this.horario = horario;
		this.aulaSimu = aulaSimu;
		this.multiProfe = multiProfe;
		this.status = status;
		this.observacao = observacao;
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

	public String getNomeAbreviado() {
		return nomeAbreviado;
	}

	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getCarga() {
		return carga;
	}

	public void setCarga(Date carga) {
		this.carga = carga;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public String getAulaSimu() {
		return aulaSimu;
	}

	public void setAulaSimu(String aulaSimu) {
		this.aulaSimu = aulaSimu;
	}

	public String getMultiProfe() {
		return multiProfe;
	}

	public void setMultiProfe(String multiProfe) {
		this.multiProfe = multiProfe;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
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
		Disciplina other = (Disciplina) obj;
		return Objects.equals(id, other.id);
	}

}
