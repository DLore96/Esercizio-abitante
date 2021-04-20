package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;

@WebServlet("/VisualizzaDettaglioServlet")
public class VisualizzaDettaglioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualizzaDettaglioServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdDellAbitanteDiCuiVoglioIlDettaglio = request.getParameter("idDaInviareComeParametro");
		Long id = Long.parseLong(parametroIdDellAbitanteDiCuiVoglioIlDettaglio);

		AbitanteService abitanteservInstance = MyServiceFactory.getAbitanteServiceInstance();
		Abitante result = null;

		try {

			result = abitanteservInstance.caricaSingoloAbitante(id);

		} catch (Exception e) {

			e.printStackTrace();
		}

		request.setAttribute("esito_attribute", result);
		RequestDispatcher rd = request.getRequestDispatcher("dettaglio.jsp");

		rd.forward(request, response);

	}

}
