package it.helloabitante.dao.abitante;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;

public class AbitanteDAOImpl implements AbitanteDAO {

	private Connection connection;

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Abitante> findByNomeAndCognome(String nome, String cognome) {
		List<Abitante> result = new ArrayList<>();

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getNome().startsWith(nome) && abitanteItem.getCognome().startsWith(cognome))
				result.add(abitanteItem);
		}
		return result;
	}

	@Override
	public List<Abitante> list() throws Exception {
		List<Abitante> result = new ArrayList<>();
		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			result.add(abitanteItem);
		}

		return result;
	}

	@Override
	public Abitante get(Long id) throws Exception {
		Abitante result = null;
		if (id > 0) {
			for (Abitante appoggio : DB_Mock.LISTA_ABITANTI) {
				if (appoggio.getIdAbitante().equals(id)) {
					result = appoggio;
				}
			}
		}

		return result;
	}

	@Override
	public int update(Abitante input) throws Exception {

		if (input == null || input.getIdAbitante() < 1)
			throw new Exception("valore non valido");
		for (Abitante itemapp : DB_Mock.LISTA_ABITANTI) {
			if (itemapp.getIdAbitante() == input.getIdAbitante()) {
				itemapp.setCodiceFiscale(input.getCodiceFiscale());
				itemapp.setCognome(input.getCognome());
				itemapp.setEta(input.getEta());
				itemapp.setIdAbitante(input.getIdAbitante());
				itemapp.setNome(input.getNome());
				itemapp.setMottoDiVita(input.getMottoDiVita());
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int insert(Abitante input) throws Exception {
		int result = 0;
		if (input != null) {
			input.setIdAbitante(DB_Mock.getNexIdAvailable());
			return DB_Mock.LISTA_ABITANTI.add(input) ? 1 : 0;

		} else {
			throw new Exception("Valore di input non valido");
		}

	}

	@Override
	public int delete(Abitante input) throws Exception {
		if (DB_Mock.LISTA_ABITANTI.remove(input)) {
			return 1;
		} else {
			return 0;
		}
	}

}
