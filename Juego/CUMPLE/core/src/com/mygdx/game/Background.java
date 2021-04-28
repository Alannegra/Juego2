package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background {
    TextureRegion texture;

    Background(){
        texture = Assets.getTexture("space"); //new Texture("Space.jpg");
    }

    public void render(SpriteBatch batch) {

        batch.draw(texture, 0,0, 640, 480);
    }
}