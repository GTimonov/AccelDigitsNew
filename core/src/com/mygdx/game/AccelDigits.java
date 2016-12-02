package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.RemoteInput;
import com.mygdx.game.model.Settings;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.utils.Assets;

public class AccelDigits extends Game {
	public SpriteBatch batch;
	RemoteInput remote;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		Assets.load();
		setScreen(new GameScreen(this));

		if (Settings.REMOTE_ANDROID_MODE) {
			remote = new RemoteInput();
			Gdx.input = remote;
		}
	}

	@Override
	public void render () {
	 super.render();
	}
	

}
