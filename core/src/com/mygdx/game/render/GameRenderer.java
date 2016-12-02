package com.mygdx.game.render;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.Interfaces.IRenderer;
import com.mygdx.game.model.Model;
import com.mygdx.game.utils.FontsFactory;

/**
 * Created by Goshan on 18.11.2016.
 */

public class GameRenderer implements IRenderer {

    private Model model;
    private SpriteBatch batch;
    private Label label;
    private BitmapFont font;

    public GameRenderer (SpriteBatch batch, Model model){
        this.model = model;
        this.batch = batch;
        font = FontsFactory.getElectrobyteFont(16);
    }
    public void render(float delta){
        batch.begin();
        font.draw(batch, "Debug Accel!", 10, 50);
        //label = new Label("A", )

        //font.setColor(Color.RED);
        batch.end();
    }
}
