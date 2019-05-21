package com.nuriilengir.Model;

public class Entity implements Comparable<Entity> {
	public String Name;
	public int Position;
	public int Rating;
	public int Price;
	private double Ratio;

	/**
	 * @param name     is entity field
	 * @param position is group of entity
	 * @param rating   is evaluation
	 * @param price    is cost of entity
	 */
	public Entity(String Name, int Position, int Rating, int Price) {
		this.Name = Name;
		this.Position = Position;
		this.Rating = Rating;
		this.Price = Price;
		this.Ratio = (double) this.Price / this.Rating;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return Position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		Position = position;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return Rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		Rating = rating;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return Price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		Price = price;
	}

	/**
	 * @return the ratio
	 */
	public double getRatio() {
		return Ratio;
	}

	/**
	 * @param ratio the ratio to set
	 */
	public void setRatio(double ratio) {
		Ratio = ratio;
	}

	@Override
	public String toString() {
		return "\n" + Name + " : " + Position;
	}

	@Override
	public int compareTo(Entity o) {
		return (int) (o.getRatio() - this.getRatio());
	}
}
