package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import negocio.Produto;

public class pacienteDao {

	public static void incluir(Produto produto)
	{
		try {
			
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("INSERT into Produto (nome, quantidade, valor) values (?,?,?)");
			ps.setString(1, produto.getName());
			ps.setInt(2, produto.getQuantidade());
			ps.setFloat(3, produto.getValor());
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
