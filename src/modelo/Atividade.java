package modelo;

import java.util.Date;
import java.util.List;

import negocio.Produto;

public abstract class Atividade {
	
	public static int qtdeProduto;
	
	private float preco;
	private Date dataAtividade;
	private List<Produto> produtos;
	
	public Atividade(float preco, List<Produto> produtos) {
	
		this.preco = preco;
		this.dataAtividade = new Date();
		this.produtos = produtos;
		
		for (Produto produto : produtos) {
			qtdeProduto++;
		}
	}
	
	public Atividade(float preco, Date dataAtividade) {
		
		this.preco = preco;
		this.dataAtividade = dataAtividade;
	}
	
	public abstract void exibir();
	
	public int oberQtdeProdutos() {
		return qtdeProduto;
	}

	@Override
	public String toString() {
		return "[preco=" + getPreco() + ", dataAtividade=" + getDataAtividade() + ", produtos=" + getProdutos() + "]";
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Date getDataAtividade() {
		return dataAtividade;
	}

	public void setDataAtividade(Date dataAtividade) {
		this.dataAtividade = dataAtividade;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
