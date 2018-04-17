package gestionCard.cardUser.controller;

import static org.mockito.Matchers.booleanThat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import gestionCard.card.controller.CardService;
import gestionCard.card.model.CardModel;
import gestionCard.cardUser.model.CardUser;
import gestionCard.common.User;

//classe contenant les methode utilisées par le webservice
@Service
public class CardUserService {
	
	private static final String MSRV_USER = "http://localhost:8081";
	@Autowired //lie automatiquement cardRepository à l'interface
	private CardUserRepository cardUserRepository;
	private CardService cardService;

	public List<CardUser> getAllUserCards(int idUser) {
		List<CardUser> cards = new ArrayList<>();
		cardUserRepository.findAllByUser(idUser).forEach(cards::add);
		return cards;
	}

	public CardUser getCard(Integer id) {
		return cardUserRepository.findById(id);
	}
	
	//FIXME methode httprequest
	//FIWME gestion prix pour l'achat
	public boolean addCard(Integer idCard, Integer idUser) {
		return false;
		boolean ret = false;

		CardModel card = cardService.getCard(idCard);
		
		RestTemplate restTemplate = new RestTemplate();
		String userResourceUrl
		  = MSRV_USER+"/users";
		
		boolean payer=restTemplate.postForObject(userResourceUrl,card.getPrice() ,boolean.class);
		User user  =restTemplate.getForObject(userResourceUrl, responseType)
	
		User utab=restTemplate.getForObject(userResourceUrl, User.class);
		
		/*User utemp=new User();
		restTemplate.postForObject(userResourceUrl,utemp, User.class);
		*/
		for (User user : utab) {
			uList.add(user);
		}
		
		return uList;
		CardUser cardUser = new CardUser(card, user);
		try {
		cardUserRepository.save(cardUser);
		ret = true;
		}
		catch(Exception e ) {
			System.out.println("Error : addCard : large error :" + e);
		}
		return ret;
	}

	public void updateCard(CardUser card) {
		cardUserRepository.save(card);

	}
//FIXME userService.sellcard
	//FIXME gestion prix pour la vente
	public boolean  deleteCard(Integer idCardUser, Integer idUser) {
		boolean ret = false;
		try {
		CardUser cardUser = cardUserRepository.findById(idCardUser);
		Integer idUserCard = 0;
		cardUserRepository.delete(idUserCard );
		ret = true;
		}
		catch(Exception e) {
			ret = false;
		}
	return ret;
	}

	
}
