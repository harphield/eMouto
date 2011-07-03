package org.androdevs.emouto.character;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.anddev.andengine.entity.layer.Layer;
import org.anddev.andengine.entity.sprite.Sprite;
import org.androdevs.emouto.EmoutoGame;
import org.androdevs.emouto.utility.TextureFactory;

import android.content.res.AssetManager;

/**
 * The character class. Each character consists of more parts:
 * - hair
 * - face
 * - eyes
 * - nose
 * - mouth
 * - body / clothes
 * - hands
 * - eyebrows
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
	public static final int CHAR_BODYPART_NOSE 			= 4;
	public static final int CHAR_BODYPART_MOUTH 		= 5;		
	public static final int CHAR_BODYPART_HAIR_FRONT 	= 6;
	public static final int CHAR_BODYPART_EYES 			= 7;
	public static final int CHAR_BODYPART_EYEBROWS		= 8;
	public static final int CHAR_BODYPART_ARMS	 		= 9;
	
	private String name;
	private String surname;
	private Personality tendencies;
	public Personality emotions;
	
	private HashMap<Integer, BodyPart> bodyparts;
	
	public GameCharacter(String name, String surname, Personality personality)
	{
		super();
		
		this.name = name;
		this.surname = surname;
		tendencies = personality;
		emotions = new Personality(50,50,50,50);
		
		bodyparts = new HashMap<Integer, BodyPart>();
	}
	
	public void initialize()
	{
//		this.reset();
		this.detachChildren();
		
		for (BodyPart b : bodyparts.values())
		{
			this.attachChild(b);
		}
	}
	
	public void fillTestChar(EmoutoGame game)
	{				
//		bodyparts.put(CHAR_BODYPART_HAIR_BACK, 	new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/hair_back.png")), BodyPart.BP_TYPE_SINGLE));
//		bodyparts.put(CHAR_BODYPART_BODY, 		new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/body.png")), BodyPart.BP_TYPE_SINGLE));
//		bodyparts.put(CHAR_BODYPART_FACE, 		new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/head.png")), BodyPart.BP_TYPE_SINGLE));
//		bodyparts.put(CHAR_BODYPART_EYES, 		new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/eyes.png")), BodyPart.BP_TYPE_SINGLE));
//		bodyparts.put(CHAR_BODYPART_NOSE, 		new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/nose.png")), BodyPart.BP_TYPE_SINGLE));
//		bodyparts.put(CHAR_BODYPART_MOUTH, 		new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/mouth.png")), BodyPart.BP_TYPE_SINGLE));
//		bodyparts.put(CHAR_BODYPART_HAIR_FRONT, new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/hair_front.png")), BodyPart.BP_TYPE_SINGLE));
//		bodyparts.put(CHAR_BODYPART_ARMS, 		new BodyPart(new Sprite(0,0, TextureFactory.loadRegion("character/arms.png")), BodyPart.BP_TYPE_SINGLE));
	}
	
	public void randomize(EmoutoGame game)
	{
		AssetManager assetManager = game.getAssets();
		bodyparts.clear();
		try {
			final Random r = new Random();			

			String[] files = assetManager.list("gfx/character/hair_back");
			String file = files[r.nextInt(files.length)];
			
			int[] pos = getBodypartMargins(file);
			bodyparts.put(CHAR_BODYPART_HAIR_BACK, 	new BodyPart(pos[0], pos[1], new Sprite(0,0, TextureFactory.loadRegion("character/hair_back/"+file)), BodyPart.BP_TYPE_SINGLE));
			
			files = assetManager.list("gfx/character/body");
			file = files[r.nextInt(files.length)];
			
			pos = getBodypartMargins(file);
			bodyparts.put(CHAR_BODYPART_BODY, 		new BodyPart(pos[0], pos[1], new Sprite(0,0, TextureFactory.loadRegion("character/body/"+file)), BodyPart.BP_TYPE_SINGLE));
						
			files = assetManager.list("gfx/character/face");
			file = files[r.nextInt(files.length)];
			pos = getBodypartMargins(file);
			bodyparts.put(CHAR_BODYPART_FACE, 		new BodyPart(pos[0], pos[1], new Sprite(0,0, TextureFactory.loadRegion("character/face/"+file)), BodyPart.BP_TYPE_SINGLE));

			files = assetManager.list("gfx/character/mouth");
			file = files[r.nextInt(files.length)];
			pos = getBodypartMargins(file);
			bodyparts.put(CHAR_BODYPART_MOUTH, 		new BodyPart(pos[0], pos[1], new Sprite(0,0, TextureFactory.loadRegion("character/mouth/"+file)), BodyPart.BP_TYPE_SINGLE));			

			files = assetManager.list("gfx/character/nose");
			file = files[r.nextInt(files.length)];
			pos = getBodypartMargins(file);
			bodyparts.put(CHAR_BODYPART_NOSE, 		new BodyPart(pos[0], pos[1], new Sprite(0,0, TextureFactory.loadRegion("character/nose/"+file)), BodyPart.BP_TYPE_SINGLE));			
			
			files = assetManager.list("gfx/character/hair_front");
			file = files[r.nextInt(files.length)];
			pos = getBodypartMargins(file);
			bodyparts.put(CHAR_BODYPART_HAIR_FRONT, new BodyPart(pos[0], pos[1], new Sprite(0,0, TextureFactory.loadRegion("character/hair_front/"+file)), BodyPart.BP_TYPE_SINGLE));

			files = assetManager.list("gfx/character/eyes");
			file = files[r.nextInt(files.length)];
			pos = getBodypartMargins(file);
			bodyparts.put(CHAR_BODYPART_EYES, 		new BodyPart(pos[0], pos[1], new Sprite(0,0, TextureFactory.loadRegion("character/eyes/"+file)), BodyPart.BP_TYPE_SINGLE));

			files = assetManager.list("gfx/character/eyebrows");
			file = files[r.nextInt(files.length)];
			pos = getBodypartMargins(file);
			bodyparts.put(CHAR_BODYPART_EYEBROWS, 	new BodyPart(pos[0], pos[1], new Sprite(0,0, TextureFactory.loadRegion("character/eyebrows/"+file)), BodyPart.BP_TYPE_SINGLE));			
			
			files = assetManager.list("gfx/character/arms");
//			file = files[r.nextInt(files.length)];
			file = files[6];
			pos = getBodypartMargins(file);
			bodyparts.put(CHAR_BODYPART_ARMS, 		new BodyPart(pos[0], pos[1], new Sprite(0,0, TextureFactory.loadRegion("character/arms/"+file)), BodyPart.BP_TYPE_SINGLE));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the margins of a bodypart from the name.
	 * Format is:
	 * 
	 * name_X_Y.png
	 * 
	 * @param filename
	 * @return
	 * @throws IOException 
	 */
	protected int[] getBodypartMargins(String filename) throws IOException
	{
		String tmp = filename.replaceAll("bodyparts__|.png|.jpg", "");
		String[] splitted = tmp.split("_");
		
		if (splitted.length < 3)
		{
			throw new IOException("The filename doesn't contain the required margins!");
		}
		
		int[] ret = new int[2];
		ret[0] = Integer.parseInt(splitted[1]);
		ret[1] = Integer.parseInt(splitted[2]);
		
		return ret;
	}

	public Personality getTendencies() {
		return tendencies;
	}

	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
}
