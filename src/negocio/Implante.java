package negocio;

import java.util.Date;
import java.util.List;

import modelo.Atividade;

public class Implante extends Atividade{

	public Implante(float preco, Date dataAtividade, List<Produto> produtos) {
		super(preco, dataAtividade, produtos);
	}
	
	public Implante(float preco, Date dataAtividade) {
		super(preco, dataAtividade);
	}

	@Override
	public void exibir() {
		System.out.print("Implante");
		System.out.print(this);
	}

	@Override
	public String toString() {
		return "[ preco()=" + getPreco() + ", dataAtividade()=" + getDataAtividade() + ", produtos()=" + getProdutos() +"] \n\n";	
	}
}
