package org.androdevs.emouto.commands;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.text.Text;
import org.androdevs.emouto.gui.GUI;
import org.androdevs.emouto.gui.layout.Block;


public class SetText implements ICommand {
	private Text text;
	private Block textBlock;
	private Scene menuScene;
	
	public SetText(String message, int red, int green, int blue, Block textBlock, Scene menuScene) {
		Text text = new Text(10, 30, GUI.fonts.get("Droid"), message);
		text.setColor(red/255f, green/255f, blue/255f);
		init(text,textBlock,menuScene);
	}
	
	public SetText(String message, Block textBlock, Scene menuScene) {
		Text text = new Text(10, 30, GUI.fonts.get("Droid"), message);
		text.setColor(0,0,0);
		init(text,textBlock,menuScene);
	}
	
	public SetText(Text text, Block textBlock, Scene menuScene) {
		init(text,textBlock,menuScene);
	}
	
	public void init(Text text, Block textBlock, Scene menuScene) {
		this.text = text;
		this.textBlock = textBlock;
		this.menuScene = menuScene;
	}
	
	public void execute(Object data) {
		if (text != null || textBlock != null || menuScene != null) {
			int textCount = textBlock.getChildCount();
			if (textCount>1) {
				IEntity entity = textBlock.getFirstChild();
				textBlock.detachChildren();
				textBlock.attachChild(entity);
			}
			textBlock.attachChild(text);
			textBlock.show();
			new ClearScene(menuScene).execute(null);
		} else {
			System.out.println("Error in setting text, one of the references was null.");
		}
	}
}
