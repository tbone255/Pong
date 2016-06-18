package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenu implements Screen {
	
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonPlay, buttonOption, buttonExit;
	
	private BitmapFont white;
	
	private Label heading;
	
	@Override
	public void show() {
		stage = new Stage();
		
		//stage has its own input processor, good for the button
		Gdx.input.setInputProcessor(stage);
		
		//texture atlas and skin
		atlas = new TextureAtlas("ui/uiskin.pack");
		skin = new Skin(atlas);
		
		//font
		white = new BitmapFont(Gdx.files.internal("fonts/white.fnt"), false);
		
		//making the table, saying where it will take up space
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		//button styles
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.font = white;
		textButtonStyle.up = skin.getDrawable("default-rect");
		textButtonStyle.down = skin.getDrawable("default-rect-down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		
		//making buttons with 20 padding
		buttonPlay = new TextButton("PLAY", textButtonStyle);
		buttonPlay.addListener(new ClickListener() {
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
			}
			
		});
		buttonPlay.pad(20);
		buttonOption = new TextButton("OPTIONS", textButtonStyle);
		buttonOption.pad(20);
		
		buttonExit = new TextButton("EXIT", textButtonStyle);
		buttonExit.addListener(new ClickListener() {
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				//super.clicked(event, x, y);
				Gdx.app.exit();
			}
			
		});
		buttonExit.pad(20);
		
		// style for heading
		LabelStyle headingStyle = new LabelStyle(white, Color.WHITE);
		
		heading = new Label("Pong", headingStyle);
		
		table.add(heading);
		table.row();
//		table.add(new Label(null, headingStyle));
//		table.row();
//		table.add(new Label(null, headingStyle));
//		table.row();
//		table.add(new Label(null, headingStyle));
//		table.row();
		table.add(buttonPlay);
		table.row();
		table.add(buttonOption);
 		table.row();
 
		table.add(buttonExit);
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
