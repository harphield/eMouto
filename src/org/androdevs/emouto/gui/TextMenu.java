package org.androdevs.emouto.gui;

import javax.microedition.khronos.opengles.GL10;

import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.menu.MenuScene;
import org.anddev.andengine.entity.scene.menu.item.IMenuItem;
import org.anddev.andengine.entity.scene.menu.item.TextMenuItem;
import org.anddev.andengine.entity.scene.menu.item.decorator.ColorMenuItemDecorator;
import org.anddev.andengine.engine.camera.Camera;

public class TextMenu extends MenuScene {
	public TextMenu(String[] options, Camera camera, IOnMenuItemClickListener listener) {
		super(camera);
		GUI.fonts.put("Droid", GUI.loadFont("Droid.ttf", GUI.game, GUI.game.getEngine()));
		IMenuItem[] text = new ColorMenuItemDecorator[options.length];
		for (int i=0;i<options.length;++i)  {
			text[i] = new ColorMenuItemDecorator(new TextMenuItem(i+1, 
					GUI.fonts.get("Droid"), options[i]), 1f, 0f, 0f, 1f, 1f, 1f );
//			A fade in animation of sorts
			text[i].setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		}
		Rectangle menubgrect = new Rectangle(0, 0, 480, 800);		
		menubgrect.setColor(0, 0, 0);
		menubgrect.setAlpha(0.7f);
		menubgrect.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		getFirstChild().attachChild(menubgrect);
		for (int i=0;i<options.length;++i)
			addMenuItem(text[i]);		
		
		buildAnimations();
		setBackgroundEnabled(false);
		setOnMenuItemClickListener(listener);
	}
}
