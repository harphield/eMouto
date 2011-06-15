package org.androdevs.emouto.gui.layout;

import org.anddev.andengine.entity.layer.Layer;

/**
 * A container for other graphic elements.
 * @author harph
 *
 */
public class Block extends Layer
{
	public Block(float x, float y, boolean visible)
	{
		super(x, y);
		this.setVisible(visible);		
	}
	
	public void show()
	{
		this.setVisible(true);
	}
	
	public void hide()
	{
		this.setVisible(false);
	}
	
}
