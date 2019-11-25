package negocio;

import java.util.Date;
import java.util.List;

import modelo.Atividade;

public class Limpeza extends Atividade{

	public Limpeza(float preco, Date dataAtividade, List<Produto> produtos) {
		super(preco, dataAtividade, produtos);
	}
	
	public Limpeza(float preco, Date dataAtividade) {
		super(preco, dataAtividade);
	}

	@Override
	public void exibir() {
		System.out.print("Limpeza");
		System.out.print(this);
	}

	@Override
	public String toString() {
		return "[getPreco()=" + getPreco() + ", getDataAtividade()=" + getDataAtividade() + ", getProdutos()=" + getProdutos() + "] \n\n";
	}
}
