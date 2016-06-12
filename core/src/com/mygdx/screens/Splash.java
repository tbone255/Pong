package com.mygdx.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.tween.SpriteAccessor;

public class Splash implements Screen 
{
	private SpriteBatch batch;
	private Sprite splash;
	private TweenManager tm;

	@Override
	public void show() {
		batch = new SpriteBatch();
		splash = new Sprite(new Texture("splash.png"));
		splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tm = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		
		Tween.set(splash, SpriteAccessor.ALPHA).target(0).start(tm) ;
		Tween.to(splash, SpriteAccessor.ALPHA, 2).target(1).repeatYoyo(1, 2).setCallback(new TweenCallback() {

			@Override
			public void onEvent(int type, BaseTween<?> source) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
			}
			
		
			}).start(tm);
	}
		
		
	

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		tm.update(delta);
		batch.begin();
		splash.draw(batch);;
		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() 
	{
		batch.dispose();
		splash.getTexture().dispose();
	}

}
