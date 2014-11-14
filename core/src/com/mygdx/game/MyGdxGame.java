package com.mygdx.game;
//
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;


public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture spriteTexture;
    Sprite sprite;
    float scrollTimer = 0.0f;
    OrthographicCamera camera;
    Texture background;
    float currentBgX;
    long lastTimeBg;

    @Override
    public void create() {

        // Init the camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

// Init the background image
        background = new Texture(Gdx.files.internal("C:\\Users\\Prashant\\Desktop\\Android Applications\\Sidescrolling\\android\\assets\\mountains.png"));

// the separator first appear at the position 800 (the edge of the screen, see
// the camera above)
        currentBgX = 800;

// set lastTimeBg to current time
        lastTimeBg = TimeUtils.nanoTime();
        //In the render() function, draw the background on both sides of the sepearator between the
        //batch.begin() and batch.end() block
        batch.begin();
// draw the first background
        batch.draw(background, currentBgX - 800, 0);
// draw the second background
        batch.draw(background, currentBgX, 0);
        batch.end();
       //Also, in the render () method, we need to move the separator
// move the separator each 1s
        if (TimeUtils.nanoTime() - lastTimeBg > 100000000) {
            // move the separator 50px
            currentBgX -= 50;
            // set the current time to lastTimeBg
            lastTimeBg = TimeUtils.nanoTime();
        }

// if the seprator reaches the screen edge, move it back to the first position
        if (currentBgX == 0) {
            currentBgX = 800;
        }
    }

    @Override
    public void render() {
        batch.begin();
// draw the first background
        batch.draw(background, currentBgX - 800, 0);
// draw the second background
        batch.draw(background, currentBgX, 0);
        batch.end();
        // move the separator each 1s
        if(TimeUtils.nanoTime() - lastTimeBg > 100000000){
            // move the separator 50px
            currentBgX -= 50;
            // set the current time to lastTimeBg
            lastTimeBg = TimeUtils.nanoTime();
        }

// if the seprator reaches the screen edge, move it back to the first position
        if(currentBgX == 0){
            currentBgX = 800;
        }
}
}