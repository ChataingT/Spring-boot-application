package gestionCard.cardUser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gestionCard.cardUser.model.CardUser;


//controller gérant la methode REST des url
@RestController
public class CardUserRestController {

	@Autowired //lie automatiquement cardService avec la classe CardService
	private CardUserService cardUserService;

/*	//renvoie toutes les Card disponibles
	@RequestMapping(method=RequestMethod.GET, value="/cards")
	private List<Card> getAllCards() {
		return cardService.getAllCards();

	}
	*/
	/**
	 * Get the card by the name or the id
	 * @param idOrName: string who is the id or the name of one card 
	 * @return the card found or null if not found
	 */
	@RequestMapping(method=RequestMethod.GET, value="/userCard/{idCard}")
	private CardUser getUserCard(@PathVariable String idCard) {
		CardUser ret = null;
		int id;
		try {
			id = Integer.valueOf(idCard);
			ret =cardUserService.getCard(id);
		}
		catch (ArithmeticException e) {
			System.out.println("Error : getCard : id not an integer :" + e);
		}
		return ret;

	}
	
	@RequestMapping(method=RequestMethod.GET, value="/userCards/{idUser}")
	private List<CardUser> getAllUserCards(@PathVariable String idUser) {
		List<CardUser> ret = null;
		int id;
		try {
			id = Integer.valueOf(idUser);
			ret = cardUserService.getAllUserCards(id);
		}
		catch (ArithmeticException e) {
			//ret = cardUserService.getCard(name);
			System.out.println("Error : getCards : id not an integer :" + e);
		}
		return ret;

	}
	
	//ajoute une Card reçu à la base de données
	@RequestMapping(method=RequestMethod.POST,value="/card/buy/{strUser}/{strCardModel}")
	public boolean buyCard(@PathVariable("strUser") String strUser, @PathVariable("strCardModel") String strCardModel) {
		boolean ret = false;
		try {
			Integer idCardModel = Integer.valueOf(strCardModel);
			Integer idUser = Integer.valueOf(strUser);
			ret = cardUserService.addCard(idCardModel,idUser );
			ret = ret && true;
		}
		catch (ArithmeticException e) {
			//ret = cardUserService.getCard(name);
			System.out.println("Error : buyCard : id not an integer :" + e);
			ret = false;
		}
		return ret;
	}
	
	//supprime de la base de données la Card correspondant à l'id 
	@RequestMapping(method=RequestMethod.DELETE,value="/card/sell/{strUser}/{strCardUser}")
	public boolean sellCard(@PathVariable("strUser") String strUser, @PathVariable("strCardUser") String strCardUser) {
		boolean ret = false;
		try {
			Integer idCardUser = Integer.valueOf(strCardUser);
			Integer idUser = Integer.valueOf(strUser);
			ret = cardUserService.deleteCard(idCardUser, idUser);
			ret  = ret && true;

		}
		catch(ArithmeticException e) {
			System.out.println("Delete methode / CardRestController : id not an integer \n Error:"+e);
			ret = false;
		}
	return ret;	
	}
	
	
}
