package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import negocio.Usuario;


public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UsuarioController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastroUsuario.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario
		(
			request.getParameter("login"), 
			request.getParameter("senha")
		);
		
		if(UsuarioDao.Incluir(usuario)) {
			this.doGet(request, response);
		} else {
			request.setAttribute("msg", "Problemas na inclusão!!!");

			request.getRequestDispatcher("cadastroUsuario.jsp").forward(request, response);
		}
	}

}
