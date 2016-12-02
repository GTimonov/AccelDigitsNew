package com.mygdx.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by Goshan on 02.12.2016.
 */


public abstract class FontsFactory {


    private static FreeTypeFontGenerator electrobyteGenerator;
    private static FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    public static BitmapFont getElectrobyteFont(int size)
    {

        electrobyteGenerator = new FreeTypeFontGenerator(Gdx.files.internal("electrobyte.ttf"));
        if (parameter == null) {
            parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
        }
        parameter.size = size;

        BitmapFont font = electrobyteGenerator.generateFont(parameter);
        electrobyteGenerator.dispose();
        return font;
    }


}
