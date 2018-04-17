package gestionCard.cardUser.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import gestionCard.common.User;

@Entity // Refers to the sub class Card
@Table(name = "cards_user_grp1") // refers to the name of the database which should be link to this entity
public class CardUser {
	@Id	//Card sera identifiée dans la base de donée par id qui est généré automatiquement
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;
	private String family;
	private int price;
	private int hp;
	private int energy;
	private int defence;
	private int attack;
	private String imgUrl;
	@ManyToOne
	private User user; // plusieurs carte appartiennent à un seul utilisateur

	
	public CardUser() {
	}


	public CardUser(String name, String description, String family, int price, int hp, int energy, int defence,
			int attack, String imgUrl, User user) {
		super();
		this.name = name;
		this.description = description;
		this.family = family;
		this.price = price;
		this.hp = hp;
		this.energy = energy;
		this.defence = defence;
		this.attack = attack;
		this.imgUrl = imgUrl;
		this.user = user;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getFamily() {
		return family;
	}


	public void setFamily(String family) {
		this.family = family;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getEnergy() {
		return energy;
	}


	public void setEnergy(int energy) {
		this.energy = energy;
	}


	public int getDefence() {
		return defence;
	}


	public void setDefence(int defence) {
		this.defence = defence;
	}


	public int getAttack() {
		return attack;
	}


	public void setAttack(int attack) {
		this.attack = attack;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	

	


}