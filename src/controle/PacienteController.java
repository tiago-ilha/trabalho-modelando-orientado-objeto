package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacienteDao;
import negocio.Paciente;

public class PacienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PacienteController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("pacientes", PacienteDao.obterLista());

		request.getRequestDispatcher("listaPacientes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean ehCasado = request.getParameter("casado") == "Sim" ? true : false;
		long documento = Long.valueOf(request.getParameter("documento"));

		Paciente paciente = new Paciente(request.getParameter("name"), documento, ehCasado);

		if (PacienteDao.Incluir(paciente)) {
			this.doGet(request, response);
		} else {
			request.setAttribute("msg", "Problemas na inclusão!!!");

			request.getRequestDispatcher("cadastroPaciente.jsp").forward(request, response);
		}
	}

}
