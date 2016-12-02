package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.AccelDigits;
import com.mygdx.game.Interfaces.IRenderer;
import com.mygdx.game.render.DebugRenderer;
import com.mygdx.game.render.GameRenderer;
import com.mygdx.game.controller.MainController;
import com.mygdx.game.model.Model;
import com.mygdx.game.model.Settings;


/**
 * Created by Goshan on 15.11.2016.
 */

public class GameScreen extends ScreenAdapter {

    AccelDigits game;
    Model model;
    IRenderer renderer;
    MainController controller;
    FPSLogger logger;

    public GameScreen(AccelDigits game)
    {
        logger = new FPSLogger();
        this.game = game;
        model = new Model(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        controller = new MainController(model);
        if (Settings.ANDROID_SHOW_ACCELEROMETER_MODE)
            renderer = new DebugRenderer(game.batch,  model);
        else
            renderer = new GameRenderer(game.batch,  model);

    }
    @Override
    public void render(float delta) {
        super.render(delta);
        controller.update(delta);
        Gdx.gl.glClearColor(Color.DARK_GRAY.r, Color.DARK_GRAY.g, Color.DARK_GRAY.b, .4f);
        if (model.clearFlag) {
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            model.clearFlag = false;
        }

        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        renderer.render(delta);
        //logger.log();
        Gdx.gl.glDisable(GL20.GL_BLEND);
    }

}
