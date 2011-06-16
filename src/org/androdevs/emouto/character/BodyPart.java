package org.androdevs.emouto.character;

import org.anddev.andengine.entity.layer.Layer;
import org.anddev.andengine.entity.sprite.BaseSprite;

/**
 * Abstract class for body parts.
 * @author harph
 *
 */
public abstract class BodyPart extends Layer
{
	public static final int BP_TYPE_SINGLE 		= 1;
	public static final int BP_TYPE_TILED 		= 2;
	public static final int BP_TYPE_ANIMATED 	= 3;
	
	private BaseSprite sprite;
	/**
	 * depending on this the BaseSprite will be used either as a Sprite, a TiledSprite or an AnimatedSprite 
	 */
	private int type;	
	
	protected BodyPart(BaseSprite sprite, int type)
	{
		this.sprite = sprite;
		this.type = type;
		
		this.attachChild(this.sprite);
	}
}
