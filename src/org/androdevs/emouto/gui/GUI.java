package org.androdevs.emouto.gui;

import java.util.HashMap;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.menu.MenuScene;
import org.anddev.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.anddev.andengine.entity.scene.menu.item.IMenuItem;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.androdevs.emouto.EmoutoGame;
import org.androdevs.emouto.commands.ChangeBlockVisibility;
import org.androdevs.emouto.commands.ICommand;
import org.androdevs.emouto.commands.OpenMenu;
import org.androdevs.emouto.gui.layout.Block;
import org.androdevs.emouto.utility.TextureFactory;

import android.graphics.Color;

/**
 * The GUI class. Used for managing the layout, menus, icons etc.
 * Should be static / singleton stuff - there is only 1 GUI for each game.
 * @author harph
 *
 */
public class GUI implements IOnMenuItemClickListener 
{
	private static GUI instance;
	
	private static final int MENU_ONE_TEXT_1 = 1;
	private static final int MENU_ONE_TEXT_2 = 2;
	private static final int MENU_ONE_TEXT_3 = 3;
	
	public static GUI i()
	{
		if (instance == null)
			instance = new GUI();
		
		return instance;
	}
	
	private Block mainBlock, textBlock, menuBlock;
	private Scene mainscene;
	public static HashMap<String, Font> fonts;
	public static EmoutoGame game;
	
	/**
	 * This function is just for test. It's shit thrown together.
	 * @param game
	 * @param scene
	 * @param mCamera
	 */
	
	public void setupGUI(EmoutoGame game, Scene scene, Camera mCamera, Engine engine)
	{
		GUI.game = game;
		fonts = new HashMap<String, Font>();
		mainscene = scene;
		
		// TODO magic numbers
		mainBlock = new Block(0, 0, true);
		textBlock = new Block(0, 550, false);
		menuBlock = new Block(0, 700, true);
		
		mainBlock.attachChild(new Sprite(0, 0, TextureFactory.loadRegion("imouto_bg_larger.jpg")));
		
		// text block stuff
//		Rectangle textrect = new Rectangle(0,0, 480, 140);
//		textrect.setColor(194f / 255f, 222f / 255f, 103f / 255f);
//		textrect.setAlpha(0.7f);
		
		textBlock.attachChild(new Sprite(0, 0, TextureFactory.loadRegion("speech_bubble")));
		
		// menu block stuff
		Rectangle menurect = new Rectangle(0, 0, 480, 100);
		menurect.setColor(221f / 255f, 255f / 255f, 118f / 255f);
		menuBlock.attachChild(menurect);
		
		String[] options = {"pat on head", "smile", "give thumbs up"};
		String[] files = {"button_heart", "button_bubble", "button_candy", "button_alarm"};
		ICommand[] commands = {
			new OpenMenu(new TextMenu(options,mCamera,this)),
			new ChangeBlockVisibility(textBlock)
		};
		menuBlock.attachHoriButtons(scene, 30, 20, 76, 59, 36, files, commands);
	}
	
	public void attachBlocks(Scene scene)
	{
//		mainBlock.attachChildren(scene);
//		textBlock.attachChildren(scene);
//		menuBlock.attachChildren(scene);
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

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) 
	{
		mainscene.clearChildScene();
		switch (pMenuItem.getID())
		{
			case MENU_ONE_TEXT_1:
				// pMenuScene.closeMenuScene(); is not enough to destroy the menu scene
//				pMenuScene.reset();
				final Text t = new Text(10, 30, fonts.get("Droid"), "tehe~");
				t.setColor(0, 0, 0);
				
				textBlock.attachChild(t);
				textBlock.show();
				return true;
			case MENU_ONE_TEXT_2:
//				pMenuScene.reset();
				return true;
			case MENU_ONE_TEXT_3:
//				pMenuScene.reset();
				return true;				
			default: 
				return false;
					
		}
	}
}
