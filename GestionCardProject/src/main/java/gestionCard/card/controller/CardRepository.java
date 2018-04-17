package gestionCard.card.controller;


import org.springframework.data.repository.CrudRepository;

import gestionCard.card.model.CardModel;

//interface permettant de faire des requète vers la table Card de la base de données
public interface CardRepository extends CrudRepository<CardModel, Integer> {

	//requète dans la base de données pour trouver seulement les Card de type Card et non pas avec les CardModel
	Iterable<CardModel> findAll();
	
	CardModel findById(Integer id);
	
	CardModel findByName(String name);
	


	
/*	@Query("select u from User u where u.id = ?1 and u.idUser = ?2")
	CardModel findByName(String name, int idUser);
*/
}