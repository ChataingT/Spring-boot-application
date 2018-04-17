package gestionCard.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gestionCard.card.model.CardModel;


//controller gérant la methode REST des url
@RestController
public class CardRestController {

	@Autowired //lie automatiquement cardService avec la classe CardService
	private CardService cardService;
	
	/**
	 * Mapping -> get all cards for "/cards"
	 * @return list of cards
	 */
	@RequestMapping(method=RequestMethod.GET, value="/cards")
	private List<CardModel> getAllCards() {
		return cardService.getAllCards();

	}
	
	/**
	 * Get the card by the name or the id
	 * @param idOrName: string who is the id or the name of one card 
	 * @return the card found or null if not found
	 */
	@RequestMapping(method=RequestMethod.GET, value="/cards/{idOrName}")
	private CardModel getCard(@PathVariable String idOrName) {
		CardModel ret = null;
		int id;
		try {
			id = Integer.valueOf(idOrName);
			ret = cardService.getCard(id);
		}
		catch (ArithmeticException e) {
			System.out.println("Error : getCard : id not an integer :" + e);
		}
		try {
			ret = cardService.getCard(idOrName);
		}
		catch(Exception e) {
			System.out.println("Error : getCard : service not working :" + e);
		}
		return ret;

	}
	
	
	//TODO ajouter card
	//ajoute une Card reçu à la base de données
	@RequestMapping(method=RequestMethod.POST,value="")
	public boolean addCard() {
		boolean ret = false;
		cardService.addCard();
		return ret;
	}
	

}
