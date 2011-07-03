package org.androdevs.emouto.gui;

import java.util.HashMap;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.androdevs.emouto.EmoutoGame;
import org.androdevs.emouto.character.GameCharacter;
import org.androdevs.emouto.character.Personality;
import org.androdevs.emouto.commands.ChangeBlockVisibility;
import org.androdevs.emouto.commands.ChoicePool;
import org.androdevs.emouto.commands.ICommand;
import org.androdevs.emouto.gui.layout.Block;
import org.androdevs.emouto.utility.TextureFactory;

import android.graphics.Color;

/**
 * The GUI class. Used for managing the layout, menus, icons etc.
 * Should be static / singleton stuff - there is only 1 GUI for each game.
 * @author harph
 *
 */
public class GUI
{
	private static GUI instance;
	
	public static HashMap<String, Font> fonts;
	public static EmoutoGame game;
	public static GameCharacter mainCharacter;
	
	public static GUI i()
	{
		if (instance == null)
			instance = new GUI();
		
		return instance;
	}
	
	private Block mainBlock, textBlock, menuBlock;	
	private Scene mainscene;
	
	/**
	 * This function is just for test. It's shit thrown together.
	 * 
	 * Everything should be placed according to the dimensions 800x480
	 * It will be scaled automagically.
	 * @param game
	 * @param scene
	 * @param mCamera
	 */
	public void setupGUI(EmoutoGame game, Scene scene, Camera mCamera, Engine engine)
	{
		fonts = new HashMap<String, Font>();
		GUI.game = game;
		GUI.fonts.put("Droid", GUI.loadFont("Droid.ttf", game, game.getEngine()));
		ChoicePool choicePool = ChoicePool.getInstance();
		mainscene = scene;
		
		// TODO magic numbers
		mainBlock = new Block(0, 0, true);
		textBlock = new Block(0, 550, false);
		menuBlock = new Block(0, 700, true);
		
		// test character
		mainCharacter = new GameCharacter("Test", "Char", new Personality());
//		testchar.fillTestChar(game);
		mainCharacter.randomize(GUI.game);
		mainCharacter.initialize();		
		
		Rectangle bgrect = new Rectangle(0,0, 480, 700);
		bgrect.setColor(1, 1, 1);
		
		mainBlock.attachChild(bgrect);
		mainBlock.attachChild(mainCharacter);
		
		// menu block stuff
		Rectangle menurect = new Rectangle(0, 0, 480, 100);
		menurect.setColor(221f / 255f, 255f / 255f, 118f / 255f);
		menuBlock.attachChild(menurect);

		textBlock.attachChild(new Sprite(0, 0, TextureFactory.loadRegion("speech_bubble")));

		choicePool.init(mainscene, mainCharacter, mCamera, textBlock);
		
		ICommand[] commands = {
			choicePool,
			new ChangeBlockVisibility(textBlock),
			new ICommand() {
				public void execute(Object data) {
					mainCharacter.randomize(GUI.game);
					mainCharacter.initialize();
				} 
			}
		};
		String[] files = {"button_heart", "button_talk", "button_food", "button_alarm"};
		menuBlock.attachHoriButtons(scene, 30, 20, 76, 59, 36, files, commands);		
	}
	
	public void attachBlocks(Scene scene)
	{
		scene.getFirstChild().attachChild(mainBlock);
		scene.getFirstChild().attachChild(textBlock);
		scene.getFirstChild().attachChild(menuBlock);
	}
	
	/**
	 * TODO font should be able to change it's size, hopefully.
	 * @param fontname
	 * @param game
	 * @param engine
	 * @return
	 */
	public static Font loadFont(String fontname, BaseGameActivity game, Engine engine)
	{
		Texture mFontTexture = new Texture(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

		FontFactory.setAssetBasePath("fonts/");
		Font f = FontFactory.createFromAsset(mFontTexture, game, fontname, 32, true, Color.WHITE);
		engine.getTextureManager().loadTexture(mFontTexture);
		engine.getFontManager().loadFont(f);
		
		return f;
	}
}
