package org.androdevs.emouto.character;

import org.anddev.andengine.entity.sprite.Sprite;

public class Arms extends BodyPart 
{
	// TODO: tiled arms - TiledSprite - more variations for arms
	// now for test only normal sprite	
	protected Arms(Sprite sprite) 
	{
		super(sprite, BodyPart.BP_TYPE_SINGLE);
	}
}
