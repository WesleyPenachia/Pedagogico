package com.vp.pedagogico;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vp.pedagogico.domain.Atividade;
import com.vp.pedagogico.domain.Cargo;
import com.vp.pedagogico.domain.Funcionario;
import com.vp.pedagogico.domain.Professor;
import com.vp.pedagogico.domain.Regiao;
import com.vp.pedagogico.domain.Usuario;
import com.vp.pedagogico.repositories.AtividadeRepository;
import com.vp.pedagogico.repositories.CargoRepository;
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
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Funcionario fun1 = new Funcionario(null, "Wesley Penachia", "wesleyikiko@hotmail.com", "11838",sdf.parse("22/11/2021 11:39"),cg1);
		Funcionario fun2 = new Funcionario(null, "Deborah Penachia", "debypenachia@hotmail.com", "10170", sdf.parse("22/08/2019 11:39"),cg4);
		
		Professor prof = new Professor(null, "Ativo", "", fun1);
		
		fun1.setProfessores(prof);
		
		Regiao reg1 = new Regiao(null, "SP");
		Regiao reg2 = new Regiao(null, "MG");
		Regiao reg3 = new Regiao(null, "SC");
		
		fun1.getRegioes().addAll(Arrays.asList(reg1));
		fun2.getRegioes().addAll(Arrays.asList(reg2,reg3));
		
		reg1.getFuncionarios().addAll(Arrays.asList(fun1));
		reg2.getFuncionarios().addAll(Arrays.asList(fun2));
		reg3.getFuncionarios().addAll(Arrays.asList(fun2));
		
		fun1.getAtividades().addAll(Arrays.asList(at1,at3));
		fun2.getAtividades().addAll(Arrays.asList(at2,at3));
		
		at1.getFuncionarios().addAll(Arrays.asList(fun1));
		at2.getFuncionarios().addAll(Arrays.asList(fun1,fun2));
		
		cg1.getFuncionarios().addAll(Arrays.asList(fun1));
		cg4.getFuncionarios().addAll(Arrays.asList(fun2));
		
		cargoRepository.saveAll(Arrays.asList(cg1,cg2,cg3,cg4));
		funcionarioRepository.saveAll(Arrays.asList(fun1,fun2));
		regiaoRepository.saveAll(Arrays.asList(reg1,reg2,reg3));
		usuarioRepository.saveAll(Arrays.asList(usu,usu2,usu3));
		atividadeRepository.saveAll(Arrays.asList(at1, at2, at3));
		professorRepository.saveAll(Arrays.asList(prof));
	}

}
