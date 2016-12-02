package com.mygdx.game.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.Interfaces.IRenderer;
import com.mygdx.game.model.Model;
import com.mygdx.game.model.Settings;
import com.mygdx.game.utils.FontsFactory;


/**
 * Created by Goshan on 30.09.2016.
 */
public class DebugRenderer implements IRenderer{

    private Model model;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private BitmapFont font;

    private OrthographicCamera camera;
    private float pointX = 0;

    private Rectangle resetBtnRect;
    private Vector2 startPoint = new Vector2(0, 0);



    public DebugRenderer(SpriteBatch batch, Model model)
    {
        this.model = model;
        this.batch = batch;
        resetBtnRect = new Rectangle(model.STAGE_WIDTH - 100, model.STAGE_HEIGHT - 50, 90, 40);
        shapeRenderer = new ShapeRenderer();
        font = FontsFactory.getElectrobyteFont(16);
        //font.

        camera = new OrthographicCamera(1, 1);
        camera.setToOrtho(true, model.STAGE_WIDTH, model.STAGE_HEIGHT);
        camera.update();

        //shapeRenderer.setProjectionMatrix(camera.combined);

    }

    public void render(float delta){

        drawAccelerometerRender();
        setupCamera();
        drawLabels();
        checkForInput();
    }

    private void checkForInput(){
        if (Gdx.input.justTouched()) {
            if (resetBtnRect.contains(Gdx.input.getX(), model.STAGE_HEIGHT - Gdx.input.getY())) {
                resetGraphic();
            }
        }
    }

    private void drawLabels(){
        batch.begin();
        font.draw(batch, "X", 10, model.STAGE_HEIGHT/4*3 + 50);
        font.draw(batch, "Y", 10, model.STAGE_HEIGHT/2 + 50);
        font.draw(batch, "Z", 10, model.STAGE_HEIGHT/4 + 50);
        font.draw(batch, "Reset", resetBtnRect.x+10, resetBtnRect.y + 30);
        batch.end();
    }
    private void drawAccelerometerRender(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Point);
        shapeRenderer.setColor(Color.PINK);
//        if (pointX > 50)
//            shapeRenderer.translate(pointX, 0, 0);

        pointX+=.4;

        //shapeRenderer.line( startPoint.x,  startPoint.y, pointX, model.accelX * 3 + model.STAGE_HEIGHT/2);



        shapeRenderer.point(pointX, model.accelX * 3 + model.STAGE_HEIGHT/4*3, 0);
        shapeRenderer.point(pointX, model.accelY * 3 + model.STAGE_HEIGHT/2, 0);
        shapeRenderer.point(pointX, model.accelZ * 3 + model.STAGE_HEIGHT/4, 0);

        startPoint.x = pointX;
        startPoint.y = model.accelX + model.STAGE_HEIGHT/2;

        shapeRenderer.end();

        shapeRenderer.setColor(Color.CORAL);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(resetBtnRect.x, resetBtnRect.y, resetBtnRect.width, resetBtnRect.height);

        shapeRenderer.end();
    }
    private void setupCamera(){
        //camera.zoom += 0.02;
        //camera.rotate(1);
        camera.update();
        camera.position.set(startPoint, 0);
    }

    private void resetGraphic(){
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        pointX = 0;
    }

}


