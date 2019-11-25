package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import modelo.Atividade;

public class Prontuario {

	private int idProntuario;
	private Date dataInicioTratamento;
	private Paciente paciente;
	private List<Atividade> atividades;

	public Prontuario(Paciente paciente, List<Atividade> atividades) {
		this.paciente = paciente;
		this.dataInicioTratamento = new Date();
		this.atividades = atividades;
	}
	
	public static Prontuario CriarProntuarioValoreDefault() {
		return new Prontuario(null, new ArrayList<Atividade>());
	}

	private boolean validar() {
		return this.getAtividades().size() == Atividade.qtdeProduto;
	}

	public void exibir() {

		if (!validar()) {
			System.out.println("Inválido.");
		} else {

			System.out.println("Prontuario");

			this.getPaciente().exibir();
			System.out.println("\n");

			for (Atividade item : this.getAtividades()) {
				item.exibir();
			}
		}
	}

	public int getIdProntuario() {
		return idProntuario;
	}

	public void setIdProntuario(int idProntuario) {
		this.idProntuario = idProntuario;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Date getDataInicioTratamento() {
		return dataInicioTratamento;
	}

	public void setDataInicioTratamento(Date dataInicioTratamento) {
		this.dataInicioTratamento = dataInicioTratamento;
	}
}
