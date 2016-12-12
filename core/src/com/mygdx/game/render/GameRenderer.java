package com.mygdx.game.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Logger;
import com.mygdx.game.Interfaces.IRenderer;
import com.mygdx.game.model.Model;
import com.mygdx.game.model.Settings;
import com.mygdx.game.utils.FontsFactory;

/**
 * Created by Goshan on 18.11.2016.
 */

public class GameRenderer implements IRenderer {

    private Model model;
    private SpriteBatch batch;

    private BitmapFont font;
    private GlyphLayout glyphLayout;



    public GameRenderer (SpriteBatch batch, Model model){
        this.model = model;
        this.batch = batch;
        float verticalPadding = model.STAGE_HEIGHT * Settings.FONT_VERTICAL_PADDINGS;
        float horizontalPadding = model.STAGE_WIDTH * Settings.FONT_HORIZONTAL_PADDINGS;
        int pixelHeight = Math.round(model.STAGE_HEIGHT - verticalPadding*2);
        int pixelWidth = Math.round(model.STAGE_WIDTH - horizontalPadding*2);
        int mainFontSize = FontsFactory.getElectrobyteSizeBySquare(new Vector2(pixelWidth, pixelHeight));
        font = FontsFactory.getElectrobyteFont(mainFontSize);
        font.setColor(Color.RED);

        glyphLayout = new GlyphLayout();

        Gdx.app.log("font getXHeight ", Float.toString(font.getCapHeight()));
    }
    public void render(float delta){
        batch.begin();
        drawCurrentDigit();

        batch.end();
    }
    private void drawCurrentDigit(){
        glyphLayout.setText(font, model.currentDigit);
        font.draw(batch, model.currentDigit, getDigitX() , getDigitY());

    }
    private float getDigitX(){
        return (model.STAGE_WIDTH/2 - glyphLayout.width/2);
    }
    private float getDigitY(){
        return (model.STAGE_HEIGHT/2 + glyphLayout.height/2);
    }

}
