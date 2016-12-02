package com.mygdx.game.model;

/**
 * Created by Goshan on 28.09.2016.
 */
public class Settings {

    public static final Boolean REMOTE_ANDROID_MODE = false;
    public static final Boolean ANDROID_SHOW_ACCELEROMETER_MODE = true;

    /** максимальное значение акселерометра по оси **/
    public static final int DEFAULT_ACCELEROMETER_MAX_VALUE = 20;

    /**коэфициент от максимального значения акселерометра, показывающий при каком значении счтать, что телефон движется**/
    public static final float MOVE_FACTOR = .5f;
}
