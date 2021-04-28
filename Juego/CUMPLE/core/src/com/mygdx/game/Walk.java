package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Walk {

    float x,y,w,h;
    int n;

    Animation animation;
    float tiempo;
    TextureRegion[] regionsMovimiento;
    Texture imagen;
    TextureRegion frameActual;

    Walk(){
        x = 100;
        y= 300;
        h= 100;
        w=100;
        n= 5;

        animation = Assets.getAnimation("horror_walk", 0.2f, Animation.PlayMode.LOOP);



    }


    void render(SpriteBatch batch){
        tiempo += Gdx.graphics.getDeltaTime();
        frameActual = (TextureRegion) animation.getKeyFrame(tiempo,true);


        batch.draw(frameActual, x, y, w, h);





    }

}
