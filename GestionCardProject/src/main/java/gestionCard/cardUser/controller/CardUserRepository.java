package gestionCard.cardUser.controller;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import gestionCard.cardUser.model.CardUser;

//interface permettant de faire des requète vers la table Card de la base de données
public interface CardUserRepository extends CrudRepository<CardUser, Integer> {

	//requète dans la base de données pour trouver seulement les Card de type Card et non pas avec les CardUser
	@Query(value="select * from user_cards u where u.idUser = ?1 ", nativeQuery=true)
	Iterable<CardUser> findAllByUser(int idUser);
	
	CardUser findById(Integer id);
	
	
	


	
/*	@Query("select u from User u where u.id = ?1 and u.idUser = ?2")
	CardUser findByName(String name, int idUser);
*/
}