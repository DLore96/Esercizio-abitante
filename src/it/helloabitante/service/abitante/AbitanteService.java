package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public interface AbitanteService {
	public void setAbitanteDAO(AbitanteDAO abitanteDAO);

	public List<Abitante> cercaPerNomeECognome(String nome, String cognome);

	public List<Abitante> listAllAbitanti() throws Exception;

	public Abitante caricaSingoloAbitante(Long id) throws Exception;

	public void inserisciNuovoAbitante(Abitante input) throws Exception;

	public void aggiornaAbitante(Abitante input) throws Exception;

	public void eliminaAbitante(Abitante input) throws Exception;

	// public int Aggiorna(Abitante input) throws Exception;
}
