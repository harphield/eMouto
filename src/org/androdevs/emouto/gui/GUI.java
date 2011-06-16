package org.androdevs.emouto.gui;

import java.util.HashMap;

import javax.microedition.khronos.opengles.GL10;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.menu.MenuScene;
import org.anddev.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.anddev.andengine.entity.scene.menu.item.IMenuItem;
import org.anddev.andengine.entity.scene.menu.item.TextMenuItem;
import org.anddev.andengine.entity.scene.menu.item.decorator.ColorMenuItemDecorator;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.androdevs.emouto.EmoutoGame;
import org.androdevs.emouto.commands.ChangeBlockVisibility;
import org.androdevs.emouto.commands.OpenMenu;
import org.androdevs.emouto.gui.layout.Block;
import org.androdevs.emouto.gui.layout.Button;

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
	private HashMap<String, Font> fonts;
	private Scene mainscene;
	
	/**
	 * This function is just for test. It's shit thrown together.
	 * @param game
	 * @param scene
	 * @param mCamera
	 */
	public void setupGUI(EmoutoGame game, Scene scene, Camera mCamera, Engine engine)
	{
		fonts = new HashMap<String, Font>();
		mainscene = scene;
		
		// TODO magic numbers
		mainBlock = new Block(0, 0, true);
		textBlock = new Block(0, 550, false);
		menuBlock = new Block(0, 700, true);
		
		Texture mTexture = new Texture(512, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TextureRegion mTextureRegion = TextureRegionFactory.createFromAsset(mTexture, game, "gfx/imouto_bg_larger.jpg", 0, 0);
		game.loadTex(mTexture);
		
		mainBlock.attachChild(new Sprite(0, 0, mTextureRegion));
		
		// text block stuff
//		Rectangle textrect = new Rectangle(0,0, 480, 140);
//		textrect.setColor(194f / 255f, 222f / 255f, 103f / 255f);
//		textrect.setAlpha(0.7f);
		
		Texture bTexture = new Texture(512, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TextureRegion bTextureRegion = TextureRegionFactory.createFromAsset(bTexture, game, "gfx/speech_bubble.png", 0, 0);
		game.loadTex(bTexture);
		
		textBlock.attachChild(new Sprite(0, 0, bTextureRegion));
		
		// menu block stuff
		Rectangle menurect = new Rectangle(0, 0, 480, 100);
		menurect.setColor(221f / 255f, 255f / 255f, 118f / 255f);
		menuBlock.attachChild(menurect);
		
		Texture button1tex = new Texture(128, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TextureRegion button1texreg = TextureRegionFactory.createFromAsset(button1tex, game, "gfx/button_heart.png", 0, 0);
		game.loadTex(button1tex);
		Texture button2tex = new Texture(128, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TextureRegion button2texreg = TextureRegionFactory.createFromAsset(button2tex, game, "gfx/button_bubble.png", 0, 0);
		game.loadTex(button2tex);
		Texture button3tex = new Texture(128, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TextureRegion button3texreg = TextureRegionFactory.createFromAsset(button3tex, game, "gfx/button_candy.png", 0, 0);
		game.loadTex(button3tex);
		Texture button4tex = new Texture(128, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TextureRegion button4texreg = TextureRegionFactory.createFromAsset(button4tex, game, "gfx/button_alarm.png", 0, 0);
		game.loadTex(button4tex);
				
		Button b1 = new Button(scene, 30, 20, 76, 59, button1texreg);
		Button b2 = new Button(scene, 142, 20, 76, 59, button2texreg);
		Button b3 = new Button(scene, 254, 20, 76, 59, button3texreg);
		Button b4 = new Button(scene, 366, 20, 76, 59, button4texreg);
		
		// button launches this menu
		MenuScene b1menu = new MenuScene(mCamera);
		
		fonts.put("Droid", loadFont("Droid.ttf", game, engine));
		IMenuItem b1text1 = new ColorMenuItemDecorator(new TextMenuItem(MENU_ONE_TEXT_1, fonts.get("Droid"), "pat on head"), 1f, 0f, 0f, 1f, 1f, 1f );
		IMenuItem b1text2 = new ColorMenuItemDecorator(new TextMenuItem(MENU_ONE_TEXT_2, fonts.get("Droid"), "smile"), 1f, 0f, 0f, 1f, 1f, 1f );
		IMenuItem b1text3 = new ColorMenuItemDecorator(new TextMenuItem(MENU_ONE_TEXT_3, fonts.get("Droid"), "give thumbs up"), 1f, 0f, 0f, 1f, 1f, 1f );
		
//		A fade in animation of sorts
		b1text1.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		b1text2.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		b1text3.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);		
		
		Rectangle menubgrect = new Rectangle(0, 0, 480, 800);		
		menubgrect.setColor(0, 0, 0);
		menubgrect.setAlpha(0.7f);
		menubgrect.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		b1menu.getFirstChild().attachChild(menubgrect);
		b1menu.addMenuItem(b1text1);		
		b1menu.addMenuItem(b1text2);		
		b1menu.addMenuItem(b1text3);		
		
		b1menu.buildAnimations();
		b1menu.setBackgroundEnabled(false);
		b1menu.setOnMenuItemClickListener(this);
		
		b1.setCommand(new OpenMenu(b1menu), scene);
		b2.setCommand(new ChangeBlockVisibility(textBlock), null);
		
		menuBlock.attachChild(b1);
		menuBlock.attachChild(b2);
		menuBlock.attachChild(b3);
		menuBlock.attachChild(b4);
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
	private Font loadFont(String fontname, BaseGameActivity game, Engine engine)
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
		switch (pMenuItem.getID())
		{
			case MENU_ONE_TEXT_1:
				// pMenuScene.closeMenuScene(); is not enough to destroy the menu scene
//				pMenuScene.reset();
				final Text t = new Text(10, 30, fonts.get("Droid"), "tehe~");
				t.setColor(0, 0, 0);
				
				textBlock.attachChild(t);
				textBlock.show();
				mainscene.clearChildScene();
				return true;
			case MENU_ONE_TEXT_2:
//				pMenuScene.reset();
				mainscene.clearChildScene();
				return true;
			case MENU_ONE_TEXT_3:
//				pMenuScene.reset();
				mainscene.clearChildScene();
				return true;				
			default: 
				return false;
					
		}
	}
}
