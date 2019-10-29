package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import negocio.Produto;
import negocio.Prontuario;

public class prontuarioDao {
	public static void incluir(Prontuario prontuario)
	{
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
}
