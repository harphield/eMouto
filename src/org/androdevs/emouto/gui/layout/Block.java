package org.androdevs.emouto.gui.layout;

import org.anddev.andengine.entity.layer.Layer;
import org.anddev.andengine.entity.scene.Scene;
import org.androdevs.emouto.commands.ICommand;
import org.androdevs.emouto.utility.TextureFactory;

/**
 * A container for other graphic elements.
 * @author harph
 *
 */
public class Block extends Layer
{
	public Block(float x, float y, boolean visible)
	{
		super(x, y);
		this.setVisible(visible);		
	}
	
	public void show()
	{
		this.setVisible(true);
	}
	
	public void hide()
	{
		this.setVisible(false);
	}
	
	public void attachHoriButtons(Scene scene, int x, int y, int w, int h, int space, String[] files, ICommand[] commands) 
	{  
		// TODO figure out a nicer way to automate this.
		for (int i=0;i<files.length;++i) {
			Button b = new Button(scene,x+((space+w)*i),y,w,h,
				TextureFactory.loadRegion(files[i]));
			if (i<commands.length) b.setCommand(commands[i], scene);
			attachChild(b);
		}
	}
}
