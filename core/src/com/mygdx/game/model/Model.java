package com.mygdx.game.model;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.input.RemoteInput;
import com.mygdx.game.utils.Assets;
import com.mygdx.game.utils.KalmanFilter;

/**
 * Created by Goshan on 28.09.2016.
 */



public class Model {

    public int STAGE_WIDTH;
    public int STAGE_HEIGHT;

    public float accelX;
    public float accelY;
    public float accelZ;

    public boolean clearFlag;
    public int maxAcellerometerValue = Settings.DEFAULT_ACCELEROMETER_MAX_VALUE;

    public boolean isMoving = false;



    private KalmanFilter kalman;

    public Model(int width, int height)
    {
        STAGE_WIDTH = width;
        STAGE_HEIGHT = height;

        kalman = new KalmanFilter(1, 1, 1, 1); // задаем Q, R, F и H - подбираем Q
        kalman.setState(0, 0); // Задаем начальные значение State и Covariance

    }


    public float filterValue(float value){

        kalman.correct(value); // Применяем алгоритм
        return kalman.state; // Сохраняем текущее состояние

    }

    public void checkForMoving(){
        if (accelX > Math.abs(maxAcellerometerValue/Settings.MOVE_FACTOR))
        {
            isMoving = true;
        }
    }


}

