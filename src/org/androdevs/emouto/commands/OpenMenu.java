package org.androdevs.emouto.commands;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.menu.MenuScene;

public class OpenMenu implements ICommand
{
	private MenuScene menuscene;
	
	public OpenMenu(MenuScene menuscene)
	{
		this.menuscene = menuscene;
	}
	
	@Override
	public void execute(Object data) 
	{
		// data = scene
		if (!((Scene) data).hasChildScene())
		{
			((Scene) data).setChildScene(menuscene);
		}
	}
}
