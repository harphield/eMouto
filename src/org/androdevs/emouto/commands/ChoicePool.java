package org.androdevs.emouto.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.scene.Scene;
import org.androdevs.emouto.character.GameCharacter;
import org.androdevs.emouto.character.Personality;
import org.androdevs.emouto.gui.TextMenu;
import org.androdevs.emouto.gui.layout.Block;

public class ChoicePool extends ArrayList<Choice> implements ICommand {
	private static final long serialVersionUID = 1L;
	private Camera camera;
	private GameCharacter character;
	
	private static ChoicePool instance = new ChoicePool();
	public static ChoicePool getInstance() {return instance;}
	private ChoicePool() {}
	
	public void init(Scene mainScene, GameCharacter character, Camera camera, Block textBlock) {
		this.character = character;
		this.camera = camera;
		add(new Choice("pat on head", new SetText("tehe~",textBlock,mainScene)));
		add(new Choice("smile", new Personality(50,60,60,50), new ClearScene(mainScene)));
		add(new Choice("give thumbs up", new Personality(50,60,60,50), new ClearScene(mainScene)));
		add(new Choice("ask how she's feeling today", new SetText("I'm doing great!",textBlock,mainScene)));
		add(new Choice("comment about the weather", new ClearScene(mainScene)));
		add(new Choice("ask what's wrong", new Personality(35,15,50,50), new ClearScene(mainScene)));
		add(new Choice("ask her to settle down", new Personality(80,50,50,50), new ClearScene(mainScene)));
		add(new Choice("play a game", new Personality(80,60,50,50), new ClearScene(mainScene)));
		add(new Choice("give a hug", new Personality(40,40,50,50), new SetText("Thanks... I needed that.",textBlock,mainScene)));
	}
	
	public List<Choice> limitOptions() {
		int offset = 15;
		List<Choice> choices = new ArrayList<Choice>(this);
		for(Choice choice : this) {
			if (choice.weight.greater(character.emotions, offset) ||
				choice.weight.lesser(character.emotions, offset))
				choices.remove(choice);
		}
		return choices;
	}
	
	public Choice[] chooseOptions(int numberOfOptions) {
		List<Choice> choices = limitOptions();
		List<Choice> selected = new ArrayList<Choice>();
		Random r = new Random();
		Choice choice;
		int originalSize = choices.size();
		for (int i=0;i<numberOfOptions;++i) {
			if (selected.size() > originalSize || choices.size()==0)
				break;
			if (choices.size()>1)
				choice = choices.get(r.nextInt(choices.size()-1));
			else
				choice = choices.get(0);
			selected.add(choice);
			choices.remove(choice);
		}
		return (Choice[]) selected.toArray(new Choice[selected.size()]);
	}
	
	public void execute(Object data) {
		Random r = new Random();
		int options = r.nextInt(4)+3;
		new OpenMenu(new TextMenu(chooseOptions(options),camera)).execute(data);
	}
}
