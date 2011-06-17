package org.androdevs.emouto.character;

import org.anddev.andengine.entity.sprite.Sprite;


public class Eyes extends BodyPart 
{
	// TODO: animated eyes - AnimatedSprite
	// now for test only normal sprite
	protected Eyes(Sprite sprite) 
	{
		super(sprite, BodyPart.BP_TYPE_SINGLE);
		
//		tiledregion		= TextureRegionFactory.createTiledFromAsset(texture, context, texpath, 0, 0, columns, rows);
		
	}
}
