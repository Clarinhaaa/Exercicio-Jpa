package br.edu.ifba.exercicio_jpa;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifba.dao.entidades.*;
import br.edu.ifba.model.*;

@SpringBootApplication
public class ExercicioJpaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ExercicioJpaApplication.class, args);
		VeiculoDao veiD = new VeiculoDao();
		FuncionarioDao funD = new FuncionarioDao();
		ServicoDao serD = new ServicoDao();
		HistoricoServicoDao hsD = new HistoricoServicoDao();

		HistoricoServico hs = new HistoricoServico();
		hs.setFkVeiculo(veiD.getById(1));
		hs.setFkServico(serD.getById(4));
		hs.setFkFuncionario(funD.getById(1));

		hsD.insert(hs);
	}
}
