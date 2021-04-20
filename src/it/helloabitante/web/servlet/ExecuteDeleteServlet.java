package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;

/**
 * Servlet implementation class ExecuteDeleteServlet
 */
@WebServlet("/ExecuteDeleteServlet")
public class ExecuteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idAbitanteParameter = request.getParameter("inputid");

		AbitanteService abitanteService = MyServiceFactory.getAbitanteServiceInstance();
		Abitante abitante;

		try {

			abitante = abitanteService.caricaSingoloAbitante(Long.parseLong(idAbitanteParameter));
			abitanteService.eliminaAbitante(abitante);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
