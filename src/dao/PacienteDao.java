package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Paciente;

public class PacienteDao {

	public static List<Paciente> obterLista() {
		List<Paciente> lista = new ArrayList<Paciente>();

		String sql = "SELECT * FROM Paciente ORDER BY nome";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(new Paciente(rs.getInt("id"), rs.getString("nome"), rs.getString("documento"),
						rs.getBoolean("casado")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public static Paciente obterPaciente(int idPaciente) {
		Paciente paciente = null;

		String sql = "SELECT * FROM Paciente where id = ?";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, idPaciente);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				paciente = new Paciente(rs.getInt("id"), rs.getString("nome"), rs.getString("documento"),
						rs.getBoolean("casado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return paciente;
	}

	public static boolean existePaciente(String documento) {
		List<Paciente> lista = new ArrayList<Paciente>();
		String sql = "select count(*) from paciente where documento = ?";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setString(1, documento);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(new Paciente(rs.getInt("id"), rs.getString("nome"), rs.getString("documento"),
						rs.getBoolean("casado")));
			}
			
			return lista.toArray().length > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean Incluir(Paciente paciente) {
		try {

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into Paciente (nome, documento, casado) values (?,?,?)");
			ps.setString(1, paciente.getNome());
			ps.setString(2, paciente.getDocumento());
			ps.setBoolean(3, paciente.getCasado());

			ps.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public static boolean atualizar(Paciente paciente) {
		try {

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("update paciente set nome = ?, documento = ?, casado = ? where id = " + paciente.getId());
			ps.setString(1, paciente.getNome());
			ps.setString(2, paciente.getDocumento());
			ps.setBoolean(3, paciente.getCasado());

			ps.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean excluir(int idPaciente) {
		try {

			PreparedStatement ps = Conexao.obterConexao().prepareStatement("delete from paciente where id = ?");
			ps.setInt(1, idPaciente);

			ps.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
