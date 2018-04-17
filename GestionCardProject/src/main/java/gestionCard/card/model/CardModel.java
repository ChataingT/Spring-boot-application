package gestionCard.card.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name = "cards_model_grp10")
public class CardModel  {
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

	public CardModel(String name, String description, String family, int price, int hp, int energy,
			int defence, int attack, String imgUrl) {
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
	}


	public CardModel() {

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
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}