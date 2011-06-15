package org.androdevs.emouto.gui.layout;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.androdevs.emouto.commands.ICommand;

/**
 * A button for the layout
 * @author harph
 *
 */
public class Button extends Sprite 
{
	private ICommand command;
	private Object commanddata;
	
	public Button(Scene scene, float pX, float pY, float pWidth, float pHeight,
			TextureRegion pTextureRegion) 
	{
		super(pX, pY, pWidth, pHeight, pTextureRegion);

		scene.registerTouchArea(this);
	}
	
	public void setCommand(ICommand command, Object commanddata)
	{
		this.command = command;
		this.commanddata = commanddata;
	}
	
	@Override
	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) 
	{
		if (pSceneTouchEvent.getAction() == TouchEvent.ACTION_DOWN)
		{
			if (command != null)
				command.execute(commanddata);
			
			return true;
		}
		
		return false;
	}	
}
