

package negocio;

public class Produto {
	private String name;
	private int quantidade;
	private float valor;
	
	public Produto(String name, int quantidade, float valor) {
		this.name = name;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public void exibir() {
		System.out.println("Produto");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Produto [name=" + this.getName() + ", quantidade=" + this.getQuantidade() + ", valor=" + this.getValor() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}	
}
