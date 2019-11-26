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
	public static boolean Incluir(Prontuario prontuario) {
		try {

			PreparedStatement ps = Conexao.obterConexao().prepareStatement("INSERT into prontuario (idpaciente, dataInicioTratamento) values (?,?)");
			ps.setInt(1, prontuario.getIdProntuario());
			ps.setDate(2, (java.sql.Date) prontuario.getDataInicioTratamento());

			ps.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static List<Prontuario> obterLista() {
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
	
//	public static Atividade ObterAtividadeImplate(String idAtividade) {
//		try {
//
//			PreparedStatement ps = Conexao.obterConexao().prepareStatement("select * from ");
////			ps.setString(1, prontuario.getName());
////			ps.setInt(2, prontuario.getQuantidade());
////			ps.setFloat(3, prontuario.getValor());
//
//			ps.execute();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
