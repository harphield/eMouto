package org.androdevs.emouto.utility;

import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.source.AssetTextureSource;
import org.anddev.andengine.util.MathUtils;
import org.androdevs.emouto.EmoutoGame;
import org.androdevs.emouto.gui.GUI;


public class TextureFactory {
	public static String basePath = "gfx";
	
	public static TextureRegion loadRegion(String file, int offsetX, int offsetY) {
		EmoutoGame game = GUI.game;
		if (!file.contains(".")) file+=".png";
		try {
			AssetTextureSource source = new AssetTextureSource(GUI.game, basePath+"/"+file);  
			Texture texture = new Texture(MathUtils.nextPowerOfTwo(source.getWidth()), 
				MathUtils.nextPowerOfTwo(source.getHeight()), TextureOptions.NEAREST_PREMULTIPLYALPHA);

			TextureRegion region = TextureRegionFactory.createFromAsset(texture, GUI.game, basePath+"/"+file, offsetX, offsetY);
			game.loadTex(texture);
			return region;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static TextureRegion loadRegion(String file) {
		return loadRegion(file,0,0);
	}
}
