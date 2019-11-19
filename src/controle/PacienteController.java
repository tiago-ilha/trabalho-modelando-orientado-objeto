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
		if (request.getParameter("tela") == null) {
			request.setAttribute("pacientes", PacienteDao.obterLista());
			request.getRequestDispatcher("listaPacientes.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("registrarPaciente.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("idPaciente") != null) {

			int idPaciente = Integer.valueOf(request.getParameter("idPaciente"));

			PacienteDao.excluir(idPaciente);

			request.setAttribute("mensagem", "Solicitante deletado!");
		} else {
			boolean ehCasado = request.getParameter("casado") == "Sim" ? true : false;
			long documento = Long.valueOf(request.getParameter("documento"));

			Paciente paciente = new Paciente(request.getParameter("nome"), documento, ehCasado);

			if (PacienteDao.Incluir(paciente)) {
				request.setAttribute("titulo", "Sucesso");
				request.setAttribute("operacaoValida", true);
				request.setAttribute("mensagem", "Operação foi realizada com sucesso!");
				this.doGet(request, response);
			} else {
				request.setAttribute("titulo", "Operação incompleta");
				request.setAttribute("operacaoValida", false);
				request.setAttribute("mensagem", "Não foi possível realizar operação!");

				request.getRequestDispatcher("registrarPaciente.jsp").forward(request, response);
			}
		}
		
		request.setAttribute("controller", "PacienteController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);

	}

}
