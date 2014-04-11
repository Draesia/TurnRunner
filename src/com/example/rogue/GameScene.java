package com.example.rogue;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.primitive.Vector2;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.opengl.util.GLState;
import org.andengine.util.HorizontalAlign;



import com.example.rogue.SceneManager.SceneType;

public class GameScene extends BaseScene {

	private Text scoreText;
	private HUD gameHUD;
	private int score = 0;

	private void createHUD()
	{
		gameHUD = new HUD();

		// CREATE SCORE TEXT
		scoreText = new Text(128, 16, resourcesManager.font, "Score: 0", new TextOptions(HorizontalAlign.LEFT), vbom);
		scoreText.setText("Score: 0");
		gameHUD.attachChild(scoreText);
		System.out.println("Test");
		camera.setHUD(gameHUD);
	}

	private void addToScore(int i)
	{
		score += i;
		scoreText.setText("Score: " + score);
	}

	private void createPhysics()
	{

	}
	
	private void createBackground()
	{
		System.out.println("Asd");
		attachChild(new Sprite(0, 0, resourcesManager.game_background_region, vbom)
		{
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) 
			{
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});
	}

	@Override
	public void createScene()
	{
		createBackground();
		createHUD();
		createPhysics();
	}

	@Override
	public void onBackKeyPressed()
	{
	    SceneManager.getInstance().loadMenuScene(engine);
	}

	@Override
	public SceneType getSceneType()
	{
		return SceneType.SCENE_GAME;
	}

	@Override
	public void disposeScene()
	{
	    camera.setHUD(null);
	    camera.setCenter(960, 520);
	}
}
