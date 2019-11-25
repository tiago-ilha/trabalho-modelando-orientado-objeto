package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacienteDao;
import dao.ProntuarioDao;
import modelo.Atividade;
import negocio.Paciente;
import negocio.Prontuario;

public class ProntuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProntuarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(request.getParameter("tela").equals("listar")) {
			request.setAttribute("prontuario", ProntuarioDao.obterLista());
			request.getRequestDispatcher("listarProntuario.jsp").forward(request, response);
		}
		else if (request.getParameter("tela").equals("editar")) {
			
			
		} else if(request.getParameter("tela").equals("registrar")){
			request.setAttribute("titulo", "Registrar");
			request.setAttribute("prontuario", Prontuario.CriarProntuarioValoreDefault());
			request.setAttribute("pacientes", PacienteDao.obterLista());
			request.getRequestDispatcher("registrarProntuario.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("tela").equals("registrar")){
			int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
			String idAtividade = request.getParameter("idAtividade");
			
			Paciente paciente = PacienteDao.obterPaciente(idPaciente);
			Atividade atividade = ProntuarioDao.RetornarAtividade(idAtividade);
			
			List<Atividade> atividades = new ArrayList<Atividade>();
			atividades.add(atividade);
			
			Prontuario prontuario = new Prontuario(paciente, atividades);
		}
	}

}
