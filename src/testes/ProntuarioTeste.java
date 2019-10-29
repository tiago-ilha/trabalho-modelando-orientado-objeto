package testes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Atividade;
import negocio.Limpeza;
import negocio.Paciente;
import negocio.Produto;
import negocio.Prontuario;

public class ProntuarioTeste {

	public static void main(String[] args) {
		
		Paciente paciente = new Paciente("Tiago", 12345678901L, true);
		
		Date dataAtual = new Date();
		
		List<Produto> produtos = new ArrayList();
		produtos.add(new Produto("Fluor", 1, 10.0f));
		
		List<Atividade> atividades = new ArrayList();
		atividades.add(new Limpeza(120.5f, dataAtual, produtos));
		
		new Prontuario(paciente, dataAtual, atividades).exibir();
		
		
		List<Produto> produtos1 = new ArrayList();
		List<Atividade> atividades1 = new ArrayList();		
		atividades.add(new Limpeza(120.5f, dataAtual, produtos1));
		
		new Prontuario(paciente, dataAtual, atividades1).exibir();
	}

}
