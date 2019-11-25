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

			if(request.getParameter("tela").equals("listar")) {
				request.setAttribute("pacientes", PacienteDao.obterLista());
				request.getRequestDispatcher("listaPacientes.jsp").forward(request, response);
			}
			else if (request.getParameter("tela").equals("editar") && request.getParameter("idPaciente") != null) {
				int idPaciente = Integer.valueOf(request.getParameter("idPaciente"));

				request.setAttribute("titulo", "Editar");
				request.setAttribute("tela", "editar");
				request.setAttribute("paciente", PacienteDao.obterPaciente(idPaciente));
				request.getRequestDispatcher("registrarPaciente.jsp").forward(request, response);
				
			} else if(request.getParameter("tela").equals("registrar")){
				request.setAttribute("titulo", "Registrar");
				request.setAttribute("tela", "registrar");
				request.setAttribute("paciente", Paciente.CriarPacienteValoresDefault());
				request.getRequestDispatcher("registrarPaciente.jsp").forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("tela") == null && request.getParameter("idPaciente") != null) {

			int idPaciente = Integer.valueOf(request.getParameter("idPaciente"));

			PacienteDao.excluir(idPaciente);

			request.setAttribute("mensagem", "Solicitante deletado!");
			
			request.setAttribute("pacientes", PacienteDao.obterLista());
			request.getRequestDispatcher("listaPacientes.jsp").forward(request, response);
			
		} else {
			Paciente paciente = null;

			boolean ehCasado = Boolean.parseBoolean(request.getParameterValues("casado")[0]);
			String documento = request.getParameter("documento").replace(".", "").replace("-", "");
			
			String tela = request.getParameter("tela");
			boolean temIdPaciente = request.getParameter("idPaciente") != null && Integer.parseInt(request.getParameter("idPaciente")) > 0;

			if (tela.equals("editar") && temIdPaciente) {

				// Editar
				int idPaciente = Integer.valueOf(request.getParameter("idPaciente"));
				paciente = PacienteDao.obterPaciente(idPaciente);

				paciente.setNome(request.getParameter("nome"));
				paciente.setDocumento(documento);
				paciente.setCasado(ehCasado);

			} else if (tela.equals("registrar")) {

				// Registrar
				paciente = new Paciente(request.getParameter("nome"), documento, ehCasado);
				
				if(PacienteDao.existePaciente(documento)) {
//					request.setAttribute("titulo", "Operação incompleta");
					
					request.getRequestDispatcher("registrarPaciente.jsp").forward(request, response);
				}

				if (PacienteDao.Incluir(paciente)) {
//					request.setAttribute("titulo", "Sucesso");
//					request.setAttribute("operacaoValida", true);
//					request.setAttribute("mensagem", "Operação foi realizada com sucesso!");
					this.doGet(request, response);
				} else {
//					request.setAttribute("titulo", "Operação incompleta");
//					request.setAttribute("operacaoValida", false);
//					request.setAttribute("mensagem", "Não foi possível realizar operação!");

					request.getRequestDispatcher("registrarPaciente.jsp").forward(request, response);
				}
			}
		}

//		request.setAttribute("controller", "PacienteController");
//		request.getRequestDispatcher("finaliza.jsp").forward(request, response);

	}

}
