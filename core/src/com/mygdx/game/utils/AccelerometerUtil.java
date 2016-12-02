package com.mygdx.game.utils;

/**
 * Created by Goshan on 18.11.2016.
 */

public class AccelerometerUtil {


    /** @return фильтр низких частот */
    public static float lowPassFilter(float current, float previous, float filtrationRate){
        float result = previous + filtrationRate*(current - previous);
        return result;
    }



}
