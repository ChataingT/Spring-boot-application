package gestionCard.card.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionCard.card.model.CardModel;

//classe contenant les methode utilisées par le webservice
@Service
public class CardService {
	
	@Autowired //lie automatiquement cardRepository à l'interface
	private CardRepository cardRepository;

	/**
	 * Find all model cards
	 * @return list of cards
	 */
	public List<CardModel> getAllCards() {
		List<CardModel> cards = new ArrayList<>();
		cardRepository.findAll().forEach(cards::add);
		return cards;
	}

	/**
	 * Find one card by its Id
	 * @param id
	 * @return the card found
	 */
	public CardModel getCard(Integer id) {
		return cardRepository.findById(id);
	}
	
	/**
	 * Find one carte by its name
	 * @param name
	 * @return the card found
	 */
	public CardModel getCard(String name) {
		return cardRepository.findByName(name);
	}
	
	//TODO ajouter les cartes dans la BD
	public boolean addCard() {
		boolean ret = false;

		return ret;
	}



	
}
