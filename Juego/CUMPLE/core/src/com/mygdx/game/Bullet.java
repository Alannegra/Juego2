package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Bullet {
    TextureRegion texture;

    float x, y, w, h;

    Bullet(float xNave, float yNave){
        texture = Assets.getTexture("bullet"); //new Texture("Bullet.png");
        w = 25;
        h = 50;
        x = xNave-w/2;
        y = yNave;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, w, h);
    }

    void update(){
        y += 2;
    }
}
