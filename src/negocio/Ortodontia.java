package negocio;

import java.util.Date;
import java.util.List;

import modelo.Atividade;

public class Ortodontia extends Atividade{

	public Ortodontia(float preco, Date dataAtividade, List<Produto> produtos) {
		super(preco, dataAtividade, produtos);
		// TODO Auto-generated constructor stub
	}
	
	public Ortodontia(float preco, Date dataAtividade) {
		super(preco, dataAtividade);
	}

	@Override
	public void exibir() {
		System.out.print("Ortodontia");
		System.out.print(this);
	}

	@Override
	public String toString() {
		return "[ preco()=" + getPreco() + ", dataAtividade()=" + getDataAtividade() + ", produtos()=" + getProdutos() +"] \n\n";	
	}
}
