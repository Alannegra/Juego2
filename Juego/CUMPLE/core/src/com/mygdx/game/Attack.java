package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

public class Attack {


    float x, y, w, h;
    List<Bullet> bullets;

    int f,n;

    Animation animation;
    float tiempo;
    TextureRegion[] regionsMovimiento;
    Texture imagen;
    TextureRegion frameActual;

    Attack(){


        x = 100;
        y = 200;
        w = 100;
        h = 100;
        bullets = new ArrayList<>();
        f = 1;
        n = 7;

        animation = Assets.getAnimation("horror_attack", 0.2f, Animation.PlayMode.LOOP); //new Texture("horror attack.png");

//        TextureRegion [][] tmp = TextureRegion.split(imagen, imagen.getWidth()/n, imagen.getHeight());
//
//        regionsMovimiento = new TextureRegion[n];
//        for (int i = 0; i < n; i++) regionsMovimiento[i] = tmp[0][i];
//        animation = new Animation(1/5f,regionsMovimiento);
//        tiempo = 0f;



    }

    void render(SpriteBatch batch){
        tiempo += Gdx.graphics.getDeltaTime();
        frameActual = (TextureRegion) animation.getKeyFrame(tiempo,true);
        //frameActual =  animation.getKeyFrame(tiempo,true);

        batch.draw(frameActual, x, y, w, h);





    }









}
