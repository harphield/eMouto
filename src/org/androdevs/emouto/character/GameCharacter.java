package org.androdevs.emouto.character;

import java.util.HashMap;

import org.anddev.andengine.entity.layer.Layer;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.androdevs.emouto.EmoutoGame;
import org.androdevs.emouto.utility.TextureFactory;

/**
 * The character class. Each character consists of more parts:
 * - hair
 * - face
 * - eyes
 * - nose
 * - mouth
 * - body / clothes
 * - hands
 * 
 * (some more / less?)
 * 
 * These should be designed to fit into each other seamlessly, so we can create many variations.
 * 
 * @author harph
 *
 */
public class GameCharacter extends Layer
{
	// the bodypart constants are sorted by how they should be layered
	// the lowest number on the bottom, the highest on the top
	// this is a matter of debate though.
	public static final int CHAR_BODYPART_HAIR_BACK 	= 1;
	public static final int CHAR_BODYPART_BODY 			= 2;	
	public static final int CHAR_BODYPART_FACE 			= 3;
	public static final int CHAR_BODYPART_EYES 			= 4;
	public static final int CHAR_BODYPART_NOSE 			= 5;
	public static final int CHAR_BODYPART_MOUTH 		= 6;		
	public static final int CHAR_BODYPART_HAIR_FRONT 	= 7;		
	public static final int CHAR_BODYPART_ARMS	 		= 8;
	
	private String name;
	private String surname;
	
	private HashMap<Integer, BodyPart> bodyparts;
	
	public GameCharacter(String name, String surname)
	{
		super();
		
		this.name = name;
		this.surname = surname;
		
		bodyparts = new HashMap<Integer, BodyPart>();
	}
	
	public void initialize()
	{
		this.reset();
		
		for (BodyPart b : bodyparts.values())
		{
			this.attachChild(b);
		}
	}
	
	public void fillTestChar(EmoutoGame game)
	{				
		bodyparts.put(CHAR_BODYPART_HAIR_BACK, 	new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/hair_back.png")), BodyPart.BP_TYPE_SINGLE));
		bodyparts.put(CHAR_BODYPART_BODY, 		new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/body.png")), BodyPart.BP_TYPE_SINGLE));
		bodyparts.put(CHAR_BODYPART_FACE, 		new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/head.png")), BodyPart.BP_TYPE_SINGLE));
		bodyparts.put(CHAR_BODYPART_EYES, 		new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/eyes.png")), BodyPart.BP_TYPE_SINGLE));
		bodyparts.put(CHAR_BODYPART_NOSE, 		new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/nose.png")), BodyPart.BP_TYPE_SINGLE));
		bodyparts.put(CHAR_BODYPART_MOUTH, 		new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/mouth.png")), BodyPart.BP_TYPE_SINGLE));
		bodyparts.put(CHAR_BODYPART_HAIR_FRONT, new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/hair_front.png")), BodyPart.BP_TYPE_SINGLE));
		bodyparts.put(CHAR_BODYPART_ARMS, 		new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/arms.png")), BodyPart.BP_TYPE_SINGLE));
	}
}
