package com.mygdx.game.model;

/**
 * Created by Goshan on 28.09.2016.
 */
public class Settings {

    public static final Boolean REMOTE_ANDROID_MODE = false;
    public static final Boolean ANDROID_SHOW_ACCELEROMETER_MODE = false;

    /** максимальное значение акселерометра по оси **/
    public static final int DEFAULT_ACCELEROMETER_MAX_VALUE = 20;

    /**коэфициент от максимального значения акселерометра, показывающий при каком значении счтать, что телефон движется**/
    public static final float MOVE_FACTOR = .5f;

    /**указывает сколько процентов оставить для отступов по вертикали от родительсокго прямоугольника**/
    public static final float FONT_VERTICAL_PADDINGS = 0f;
    public static final float FONT_HORIZONTAL_PADDINGS = 0;

    public static final String WORD_TO_SHOW = "GANJUBAZZ";
}
