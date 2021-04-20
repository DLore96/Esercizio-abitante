package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {

	private AbitanteDAO abitanteDAO;

	@Override
	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) {
		// abitanteDAO.setConnection(MyConnection.getConnection());
		return abitanteDAO.findByNomeAndCognome(nome, cognome);

	}

	@Override
	public List<Abitante> listAllAbitanti() throws Exception {

		return abitanteDAO.list();
	}

	@Override
	public Abitante caricaSingoloAbitante(Long id) throws Exception {
		if (id == null || id < 1) {
			throw new Exception("valore non valido");
		}
		return abitanteDAO.get(id);
	}

	@Override
	public void inserisciNuovoAbitante(Abitante input) throws Exception {
		if (input == null) {
			throw new Exception("valore non valido");
		}
		abitanteDAO.insert(input);
	}

	@Override
	public void aggiornaAbitante(Abitante input) throws Exception {
		if (input == null) {
			throw new Exception("valore non valido");
		}
		abitanteDAO.update(input);

	}

	@Override
	public void eliminaAbitante(Abitante input) throws Exception {
		if (input == null) {
			throw new Exception("valore non valido");
		}
		abitanteDAO.update(input);
	}

}
