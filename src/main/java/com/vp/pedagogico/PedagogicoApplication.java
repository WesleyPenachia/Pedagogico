package com.vp.pedagogico;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vp.pedagogico.domain.Atividade;
import com.vp.pedagogico.domain.Cargo;
import com.vp.pedagogico.domain.Curso;
import com.vp.pedagogico.domain.Disciplina;
import com.vp.pedagogico.domain.Funcionario;
import com.vp.pedagogico.domain.Professor;
import com.vp.pedagogico.domain.Regiao;
import com.vp.pedagogico.domain.Usuario;
import com.vp.pedagogico.repositories.AtividadeRepository;
import com.vp.pedagogico.repositories.CargoRepository;
import com.vp.pedagogico.repositories.CursoRepository;
import com.vp.pedagogico.repositories.DisciplinaRepository;
import com.vp.pedagogico.repositories.FuncionarioRepository;
import com.vp.pedagogico.repositories.ProfessorRepository;
import com.vp.pedagogico.repositories.RegiaoRepository;
import com.vp.pedagogico.repositories.UsuarioRepository;

@SpringBootApplication
public class PedagogicoApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository; 
	
	@Autowired
	private AtividadeRepository atividadeRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(PedagogicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usu = new Usuario(null, "wesley", "123","Administrador");
		Usuario usu2 = new Usuario(null,  "deby", "123","Administrador");
		Usuario usu3 = new Usuario(null, "andre", "123", "Administrador");
		
		Atividade at1 = new Atividade(null, "Prova Final", "Fim Ano");
		Atividade at2 = new Atividade(null, "Prova Bimestral", "Fim bimestre");
		Atividade at3 = new Atividade(null, "Confirmação", "Mudança de Professor");
		
		Cargo cg1 = new Cargo(null, "Professor", 1);
		Cargo cg2 = new Cargo(null, "Diretor", 1);
		Cargo cg3 = new Cargo(null, "Aux. Administrativo", 1);
		Cargo cg4 = new Cargo(null, "Aux. Administrativo", 3);
		
		
		SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
		
		Funcionario fun1 = new Funcionario(null, "Wesley Penachia", "wesleyikiko@hotmail.com", "11838",sdfData.parse("22/11/2021 11:39"),cg1);
		Funcionario fun2 = new Funcionario(null, "Deborah Penachia", "debypenachia@hotmail.com", "10170", sdfData.parse("22/08/2019 11:39"),cg4);
		Funcionario fun3 = new Funcionario(null, "Joao Carlos Penachia", "joao@hotmail.com", "10183", sdfData.parse("22/02/2002 11:39"),cg1);
		
		Professor prof = new Professor(null, "Ativo", "", fun1);
		Professor prof1 = new Professor(null, "Ativo", "", fun3);
		
		Disciplina dis1 = new Disciplina(null,  "Corpo Humano", "CPH", "n12", sdfHora.parse("01:00"), "EAD", sdfHora.parse("10:00"), "Não", "Não", "Ativo", "");
		Disciplina dis2 = new Disciplina(null,  "Saude", "SD", "n18", sdfHora.parse("01:00"), "EAD", sdfHora.parse("08:00"), "Não", "Não", "Ativo", "");
		Disciplina dis3 = new Disciplina(null,  "Alimentação", "ALM", "n10", sdfHora.parse("01:00"), "EAD", sdfHora.parse("09:00"), "Não", "Não", "Ativo", "");
		
		Curso cur1 = new Curso(null, "Nutrição", "Ativo", "");
		Curso cur2 = new Curso(null, "Enfermagem", "Ativo", "");
		
		dis1.getCursos().addAll(Arrays.asList(cur1,cur2));
		dis2.getCursos().addAll(Arrays.asList(cur1));
		dis3.getCursos().addAll(Arrays.asList(cur1));
		
		cur1.getDisciplinas().addAll(Arrays.asList(dis1,dis2,dis3));
		cur2.getDisciplinas().addAll(Arrays.asList(dis1));
		
		prof.getDisciplinas().addAll(Arrays.asList(dis1,dis3));
		prof1.getDisciplinas().addAll(Arrays.asList(dis2));
		
		dis1.getProfessores().addAll(Arrays.asList(prof));
		dis2.getProfessores().addAll(Arrays.asList(prof1));
		dis3.getProfessores().addAll(Arrays.asList(prof));
		
		fun1.setProfessores(prof);
		fun3.setProfessores(prof1);
		
		Regiao reg1 = new Regiao(null, "SP");
		Regiao reg2 = new Regiao(null, "MG");
		Regiao reg3 = new Regiao(null, "SC");
		
		fun1.getRegioes().addAll(Arrays.asList(reg1));
		fun3.getRegioes().addAll(Arrays.asList(reg3));
		
		reg1.getFuncionarios().addAll(Arrays.asList(fun1));
		reg3.getFuncionarios().addAll(Arrays.asList(fun3));
		
		fun1.getAtividades().addAll(Arrays.asList(at1,at3));
		fun2.getAtividades().addAll(Arrays.asList(at2,at3));
		
		at1.getFuncionarios().addAll(Arrays.asList(fun1));
		at2.getFuncionarios().addAll(Arrays.asList(fun1,fun2));
		
		cg1.getFuncionarios().addAll(Arrays.asList(fun1,fun3));
		cg4.getFuncionarios().addAll(Arrays.asList(fun2));
		
		cargoRepository.saveAll(Arrays.asList(cg1,cg2,cg3,cg4));
		funcionarioRepository.saveAll(Arrays.asList(fun1,fun2,fun3));
		regiaoRepository.saveAll(Arrays.asList(reg1,reg2,reg3));
		usuarioRepository.saveAll(Arrays.asList(usu,usu2,usu3));
		atividadeRepository.saveAll(Arrays.asList(at1, at2, at3));
		professorRepository.saveAll(Arrays.asList(prof,prof1));
		disciplinaRepository.saveAll(Arrays.asList(dis1,dis2,dis3));
		cursoRepository.saveAll(Arrays.asList(cur1,cur2));
	}

}
