package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class MainMenu implements Screen {
	
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonPlay, buttonOption;
	private BitmapFont white;
	
	private Label heading;
	
	@Override
	public void show() {
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		
		atlas = new TextureAtlas("ui/uiskin.pack");
		skin = new Skin(atlas);
		
		white = new BitmapFont(Gdx.files.internal("fonts/white.fnt"), false);
		
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.font = white;
		textButtonStyle.up = skin.getDrawable("default-rect");
		textButtonStyle.down = skin.getDrawable("default-rect-down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		
		buttonPlay = new TextButton("PLAY", textButtonStyle);
		buttonPlay.pad(20);
		buttonOption = new TextButton("OPTIONS", textButtonStyle);
		buttonOption.pad(20);
		table.add(buttonPlay);
		table.row();
		table.add(buttonOption);
		//table.debugActor();
		stage.addActor(table);
		
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_CLEAR_VALUE);
		stage.act(delta);
		stage.draw();
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
	public void dispose() {
		
	}

}
