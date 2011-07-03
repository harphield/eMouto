package org.androdevs.emouto.character;

public class Personality {
	private int energy = 50;
	private int happiness = 50;
	private int affection = 50;
	private int hunger = 50;
	
	public Personality(int energy, int happiness, int affection, int hunger) {
		setEnergy(energy);
		setHappiness(happiness);
		setAffection(affection);
		setHunger(hunger);
	}
	
	public Personality() {}
	
	public void setEnergy(int energy) {
		if (energy<0) energy=0;
		if (energy>100) energy=100;
		this.energy = energy;
	}
	public int getEnergy() {return energy;}
	
	public void setHappiness(int happiness) {
		if (happiness<0) happiness=0;
		if (happiness>100) happiness=100;
		this.happiness = happiness;
	}
	public int getHappiness() {return happiness;}
	
	public void setAffection(int affection) {
		if (affection<0) affection=0;
		if (affection>100) affection=100;
		this.affection = affection;
	}
	public int getAffection() {return affection;}
	
	public void setHunger(int hunger) {
		if (hunger<0) hunger=0;
		if (hunger>100) hunger=100;
		this.hunger = hunger;
	}
	public int getHunger() {return hunger;}
	
	public boolean lesser(Personality other, int offset) {
		return (affection < other.getAffection() - offset ||
				energy < other.getEnergy() - offset ||
				happiness < other.getHappiness() - offset ||
				hunger < other.getHunger() - offset);
	}
	
	public boolean greater(Personality other, int offset) {
		return (affection > other.getAffection() + offset ||
				energy > other.getEnergy() + offset ||
				happiness > other.getHappiness() + offset ||
				hunger > other.getHunger() + offset);
	}
}
