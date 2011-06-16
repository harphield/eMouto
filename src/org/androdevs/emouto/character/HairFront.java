package org.androdevs.emouto.character;

import org.anddev.andengine.entity.sprite.Sprite;

public class HairFront extends BodyPart 
{
	// TODO: tiled front hair - TiledSprite - more variations for hair
	// now for test only normal sprite	
	protected HairFront(Sprite sprite) 
	{
		super(sprite, BodyPart.BP_TYPE_SINGLE);
	}
}
