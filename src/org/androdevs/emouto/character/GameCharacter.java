package org.androdevs.emouto.character;

import java.util.HashMap;

import org.anddev.andengine.entity.layer.Layer;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.androdevs.emouto.EmoutoGame;

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
		bodyparts.put(CHAR_BODYPART_HAIR_BACK, 	new HairBack(new Sprite(0,0, loadTexForChar("hair_back.png", game))));
		bodyparts.put(CHAR_BODYPART_BODY, 		new Body(new Sprite(0,0, loadTexForChar("body.png", game))));
		bodyparts.put(CHAR_BODYPART_FACE, 		new Face(new Sprite(0,0, loadTexForChar("head.png", game))));
		bodyparts.put(CHAR_BODYPART_EYES, 		new Eyes(new Sprite(0,0, loadTexForChar("eyes.png", game))));
		bodyparts.put(CHAR_BODYPART_NOSE, 		new Nose(new Sprite(0,0, loadTexForChar("nose.png", game))));
		bodyparts.put(CHAR_BODYPART_MOUTH, 		new Mouth(new Sprite(0,0, loadTexForChar("mouth.png", game))));
		bodyparts.put(CHAR_BODYPART_HAIR_FRONT, new HairFront(new Sprite(0,0, loadTexForChar("hair_front.png", game))));
		bodyparts.put(CHAR_BODYPART_ARMS, 		new Arms(new Sprite(0,0, loadTexForChar("arms.png", game))));
	}
	
	/**
	 * This is just for testing, there should be a tex manager or something to do this stuff.
	 * @return
	 */
	private TextureRegion loadTexForChar(String name, EmoutoGame game)
	{
		Texture bhTexture = new Texture(512, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TextureRegion bhTextureRegion = TextureRegionFactory.createFromAsset(bhTexture, game, "gfx/character/"+name, 0, 0);
		game.loadTex(bhTexture);
		
		return bhTextureRegion;
	}
}
