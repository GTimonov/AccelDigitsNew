package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.model.Model;


/**
 * Created by Goshan on 20.10.2016.
 */
public class MainController {

    private Model model;


    public MainController(Model model){

        this.model = model;

    }

    public void update(float delta)
    {

        float noFiltered = Gdx.input.getAccelerometerX();
        model.accelY = Gdx.input.getAccelerometerY();
        model.accelZ = Gdx.input.getAccelerometerZ();
        model.accelX = noFiltered;//model.filterValue(noFiltered);
        //Gdx.app.log("Gyro avaliable", String.valueOf(Gdx.input.isPeripheralAvailable(Input.Peripheral.Gyroscope)));
        //Gdx.app.log("Accelerometer X clear", Float.toString(noFiltered));
        //Gdx.app.log("Accelerometer X filtered             ", Float.toString(model.accelX));
        if (noFiltered != model.accelX)
            Gdx.app.log("***", "**");

        /*if (!model.isMoving)
            model.checkForMoving();
        else
            model.*/




    }


}
