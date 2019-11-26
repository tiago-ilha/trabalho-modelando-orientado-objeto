package negocio;

public class Paciente {
	private int id;
	private String nome;
	private String documento;
	private boolean casado;
	
	public Paciente(int id, String nome, String documento, boolean casado) {
		this.id = id;
		this.nome = nome;
		this.documento = documento;
		this.casado = casado;
	}
	
	public Paciente(String nome, String documento, boolean casado) {
		this.nome = nome;
		this.documento = documento;
		this.casado = casado;
	}
	
	public static Paciente CriarPacienteValoresDefault()
	{
		return new Paciente("","", false);
	}
	
	public void exibir() {
		System.out.print("Paciente");
		System.out.print(this);
	}	
	
	public String EhCasado() {
		return getCasado() ? "Sim" : "Não";
	}

	@Override
	public String toString() {
		return "[nome=" + getNome() + ", documento=" + getDocumento() + ", casado=" + getCasado() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public boolean getCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}
}
