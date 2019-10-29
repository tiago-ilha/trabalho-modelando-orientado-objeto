package testes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import negocio.Implante;
import negocio.Limpeza;
import negocio.Ortodontia;
import negocio.Produto;

public class AtividadeTeste {

	public static void main(String[] args) {	
	
	List<Produto> produtos = new ArrayList();
	produtos.add(new Produto("Fluor", 1, 10.0f));
	 
	Date dataAtual = new Date();
	
//	System.out.println("Limpeza: \n\n");
	new Limpeza(120.5f,dataAtual, produtos).exibir();
	
	List<Produto> produtos1 = new ArrayList();
	produtos1.add(new Produto("Broca", 1, 300.0f));
	
//	System.out.println("Implante: \n\n");
	new Implante(2520f,dataAtual, produtos1).exibir();
	
	List<Produto> produtos2 = new ArrayList();
	produtos2.add(new Produto("Brequetes", 1, 50f));
	
//	System.out.println("Ortodontia: \n\n");
	new Ortodontia(5000f,dataAtual, produtos2).exibir();	
	}

}
