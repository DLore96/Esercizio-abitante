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

/**
 * Servlet implementation class ExecuteUpdateServlet
 */
@WebServlet("/ExecuteUpdateServlet")
public class ExecuteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// prendo parametri

		String idparameter = request.getParameter("inputid");
		String nomeParameter = request.getParameter("nomeinput");
		String cognomeParameter = request.getParameter("cognomeinput");
		String etaParameter = request.getParameter("etainput");
		String codicefParameter = request.getParameter("codicefinput");
		String motto = request.getParameter("mottoinput");

		RequestDispatcher rd = null;
		AbitanteService abitanteservInstance = MyServiceFactory.getAbitanteServiceInstance();
		// li valido
		if (nomeParameter != "" && cognomeParameter != "" && codicefParameter != "" && motto != ""
				&& etaParameter.matches("[0+9]+")) {

			try {
				abitanteservInstance.aggiornaAbitante(new Abitante(Long.parseLong(idparameter), nomeParameter,
						cognomeParameter, codicefParameter, Integer.parseInt(etaParameter), motto));
				System.out.println(abitanteservInstance.caricaSingoloAbitante(Long.parseLong(idparameter)));
				rd = request.getRequestDispatcher("searchForm.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// torna alla modifica
			boolean flag = false;
			System.out.println("inserimento fallito");
			request.setAttribute("flag_attribute", flag);
			request.setAttribute("input_item", new Abitante(nomeParameter, cognomeParameter, codicefParameter,
					Integer.parseInt(etaParameter), "motto"));
			rd = request.getRequestDispatcher("modifica.jsp");

		}
		rd.forward(request, response);
	}

}
