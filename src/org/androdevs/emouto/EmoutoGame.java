package org.androdevs.emouto;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.androdevs.emouto.gui.GUI;

import android.util.DisplayMetrics;

public class EmoutoGame extends BaseGameActivity 
{
	// ===========================================================
	// Constants
	// ===========================================================

//	public static final int CAMERA_WIDTH = 480;
//	public static final int CAMERA_HEIGHT = 800;	
	
	// ===========================================================
	// Fields
	// ===========================================================
	
	public static int CAMERA_WIDTH;
	public static int CAMERA_HEIGHT;
	
	private Scene scene;
	private Camera mCamera;	
	
	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================	
	
	@Override
	public Engine onLoadEngine() {
		// get the screen resolution
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        CAMERA_WIDTH = dm.widthPixels;
        CAMERA_HEIGHT = dm.heightPixels;
        this.mCamera = new Camera(0, 0, dm.widthPixels, dm.heightPixels);
        return new Engine(new EngineOptions(true, ScreenOrientation.PORTRAIT,
                new RatioResolutionPolicy(dm.widthPixels, dm.heightPixels), this.mCamera));	
		
//		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
//		return new Engine(new EngineOptions(true, ScreenOrientation.PORTRAIT, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera));
	}

	@Override
	public void onLoadResources() {
		scene = new Scene(1);

		GUI.i().setupGUI(this, scene, mCamera, mEngine);
	}

	public void loadTex(Texture t)
	{
		mEngine.getTextureManager().loadTexture(t);
	}
	
	@Override
	public Scene onLoadScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());

		scene.setTouchAreaBindingEnabled(true);
		
		GUI.i().attachBlocks(scene);
		
		return scene;
	}

	@Override
	public void onLoadComplete() {
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}	
	
	// ===========================================================
	// Methods
	// ===========================================================
	
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================	
}