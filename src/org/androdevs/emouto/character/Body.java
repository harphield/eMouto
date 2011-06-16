package org.androdevs.emouto.character;

import org.anddev.andengine.entity.sprite.Sprite;

public class Body extends BodyPart 
{
	protected Body(Sprite sprite) 
	{
		super(sprite, BodyPart.BP_TYPE_SINGLE);
	}
}
