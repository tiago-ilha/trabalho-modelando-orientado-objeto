package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import conexao.Conexao;
import modelo.Atividade;
import negocio.Implante;
import negocio.Limpeza;
import negocio.Ortodontia;
import negocio.Prontuario;

public class ProntuarioDao {
	public static void Incluir(Prontuario prontuario) {
		try {

			PreparedStatement ps = Conexao.obterConexao().prepareStatement("INSERT into prontuario (idpaciente, dataInicioTratamento, idatividade) values (?,?,?)");
//			ps.setString(1, prontuario.getName());
//			ps.setInt(2, prontuario.getQuantidade());
//			ps.setFloat(3, prontuario.getValor());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Prontuario> obterLista() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Atividade RetornarAtividade(String idAtividade)
	{
		switch (idAtividade) {
		case "imp":
			return new Implante(500, new Date());
			
		case "lmp":
			return new Limpeza(120, new Date());
			
		case "ort":
			return new Ortodontia(180, new Date());
		default:
			return null;
		}
	}
}
