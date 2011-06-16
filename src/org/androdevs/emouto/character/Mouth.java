package org.androdevs.emouto.character;

import org.anddev.andengine.entity.sprite.Sprite;

public class Mouth extends BodyPart 
{
	// TODO: animated mouth - AnimatedSprite
	// now for test only normal sprite
	protected Mouth(Sprite sprite) 
	{
		super(sprite, BodyPart.BP_TYPE_SINGLE);
	}
}
