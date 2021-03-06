package org.androdevs.emouto.commands;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.menu.MenuScene;

/**
 * Opens this menu scene. Execute needs the main Scene as data.
 * @author harph
 *
 */
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
		if (data instanceof Scene)
			if (!((Scene) data).hasChildScene())
				((Scene) data).setChildScene(menuscene);
	}
}
