package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import modelo.Atividade;
import negocio.Limpeza;
import negocio.Ortodontia;
import negocio.Produto;

public class AtividadeDao {

	public static void incluir(Atividade atividade)
	{
		try {
			
			PreparedStatement ps = null;
			
			if(atividade instanceof Ortodontia) {
				ps = Conexao.obterConexao().prepareStatement("INSERT into Ortodontia (valor, dataAtividade, idproduto) values (?,?,?)");		
			} else if(atividade instanceof Limpeza) {
				ps = Conexao.obterConexao().prepareStatement("INSERT into Limpeza (valor, dataAtividade, idproduto) values (?,?,?)");
			} else {
				ps = Conexao.obterConexao().prepareStatement("INSERT into Implante (valor, dataAtividade, idproduto) values (?,?,?)");
			}

			ps.setFloat(1, atividade.getPreco());
			ps.setDate(2, new Date(atividade.getDataAtividade().getTime()));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
