package org.androdevs.emouto.commands;

import org.androdevs.emouto.character.Personality;

public class Choice implements ICommand {
	public String message="";
	public Personality weight;
	private ICommand command;
	
	public Choice(String message, Personality weight, ICommand command) {
		this.message = message;
		this.weight = weight;
		this.command = command;
	}
	
	public Choice(String message, Personality weight) {
		this.message = message;
		this.weight = weight;
	}
	
	public Choice(String message, ICommand command) {
		this.message = message;
		this.command = command;
		this.weight = new Personality();
	}
	
	public Choice(String message) {
		this.message = message;
		this.weight = new Personality();
	}
	
	public void execute(Object data) {
		if (command != null)
			command.execute(data);
	}
}
