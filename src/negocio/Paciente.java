package negocio;

public class Paciente {
	private String nome;
	private long documento;
	private Boolean casado;
	
	public Paciente(String nome, long documento, Boolean casado) {
		this.nome = nome;
		this.documento = documento;
		this.casado = casado;
	}
	
	public void exibir() {
		System.out.print("Paciente");
		System.out.print(this);
	}	

	@Override
	public String toString() {
		return "[nome=" + getNome() + ", documento=" + getDocumento() + ", casado=" + getCasado() + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public Boolean getCasado() {
		return casado;
	}

	public void setCasado(Boolean casado) {
		this.casado = casado;
	}

	public void setDocumento(long documento) {
		this.documento = documento;
	}
}
