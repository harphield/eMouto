package org.androdevs.emouto.commands;

import org.anddev.andengine.entity.scene.Scene;

public class ClearScene implements ICommand {
	private Scene scene;
	
	public ClearScene(Scene scene) {
		this.scene = scene;
	}
	
	public void execute(Object data) {
		if (scene != null)
			scene.clearChildScene();
	}

}
