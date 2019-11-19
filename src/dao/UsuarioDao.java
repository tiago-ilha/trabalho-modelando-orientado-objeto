package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import negocio.Paciente;
import negocio.Usuario;

public class UsuarioDao {
	
	public static boolean Incluir(Usuario usuario) {
		try {

			PreparedStatement ps = Conexao.obterConexao().prepareStatement("INSERT into Paciente (login, senha, ativo) values (?,?,?)");
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ps.setBoolean(3, usuario.isAtivo());

			ps.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	} 
	
	public static Usuario Validar(String email, String senha){
		String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ? and ativo = 1";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return new Usuario(
						rs.getInt("idusuario"), 
						rs.getString("login"), 
						rs.getString("senha"),
						rs.getBoolean("ativo")
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
