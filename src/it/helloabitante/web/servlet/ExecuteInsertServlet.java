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

@WebServlet("/ExecuteInsertServlet")
public class ExecuteInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeParameter = request.getParameter("nomeinput");
		String cognomeParameter = request.getParameter("cognomeinput");
		String codicefisParameter = request.getParameter("codicefinput");
		String etaParameter = request.getParameter("etainput");
		String mottoParameter = request.getParameter("mottoinput");

		RequestDispatcher rd = null;

		AbitanteService abitanteServInstance = MyServiceFactory.getAbitanteServiceInstance();

		if (nomeParameter != " " && cognomeParameter != " " && codicefisParameter != "" && codicefisParameter != ""
				&& etaParameter.matches("[0+9]+")) {

			try {

				abitanteServInstance.inserisciNuovoAbitante(new Abitante(nomeParameter, cognomeParameter,
						codicefisParameter, Integer.parseInt(etaParameter), mottoParameter));

			} catch (Exception e) {

				e.printStackTrace();
			}

			rd = request.getRequestDispatcher("searchForm.jsp");

		} else {

			rd = request.getRequestDispatcher("insert.jsp");
		}
		rd.forward(request, response);

	}

}
