package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

public class J2 {
    Texture texture;
    float x, y, w, h;
    List<Bullet> bullets;
    boolean xd,xd2;
    int f,n,c,n2;

    Animation animation, animationW;

    float tiempo;
    TextureRegion[] regionsMovimiento,regionsMovimientoW;
    Texture imagen,walk;
    TextureRegion frameActual,frameActualW;


    J2(){


        x = 400;
        y = 100;
        w = 50;
        h = 50;
        bullets = new ArrayList<>();
        f = 1;
        n = 6;
        n2=5;
        c= 0;

        animation = Assets.getAnimation("horror_idle", 0.2f, Animation.PlayMode.LOOP);
        animation = Assets.getAnimation("horror_walk", 0.2f, Animation.PlayMode.LOOP);


/*
        TextureRegion [][] tmp = TextureRegion.split(imagen, imagen.getWidth()/n, imagen.getHeight());

        regionsMovimiento = new TextureRegion[n];
        for (int i = 0; i < n; i++){

            regionsMovimiento[i] = tmp[0][i];
        }
        animation = new Animation(1/5f,regionsMovimiento);
        tiempo = 0f;

        TextureRegion [][] tmpW = TextureRegion.split(walk, walk.getWidth()/n2, walk.getHeight());

        regionsMovimientoW = new TextureRegion[n2];
        for (int i = 0; i < n2; i++){

            regionsMovimientoW[i] = tmpW[0][i];
        }
        animationW = new Animation(1/5f,regionsMovimientoW);
        tiempo = 0f;


*/
    }

    void render(SpriteBatch batch){
        tiempo += Gdx.graphics.getDeltaTime();

        if(f== 1){
            frameActual = (TextureRegion) animation.getKeyFrame(tiempo,true);
            batch.draw(frameActual, x, y, w, h);

        }else{

            frameActualW = (TextureRegion) animationW.getKeyFrame(tiempo,true);
            batch.draw(frameActualW, x, y, w, h);

        }






        //batch.draw(frameActual,x,y);








        for (Bullet bala: bullets) {
            bala.render(batch);
        }
    }

    void update(){
        for (Bullet bala: bullets) {
            bala.update();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x += 5;

        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x -= 5;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) y += 5;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) y -= 5;


        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            bullets.add(new Bullet(x+w/2, y+h));
        }
    }

    void animation(SpriteBatch batch){



        if (Gdx.input.isKeyPressed(Input.Keys.F )){
            f = 0;
            h+=2 ;
            w+=2;
            x-=1;
            xd = true;
            xd2 = false;

        }else if (Gdx.input.isKeyPressed(Input.Keys.G)){
            f = 1 ;
            h-=2 ;
            w-=2;
            x+=1;
            xd = false;
            xd2 = true;
            
        }


    }

/*
    void animations(SpriteBatch batch){

        batch.draw(frameActual, x, y, w, h);
        if (Gdx.input.isKeyJustPressed(Input.Keys.F )&& f == 1)  f = 0;
        else if (Gdx.input.isKeyJustPressed(Input.Keys.F) && f == 0) f = 1 ;

        if (f == 0){
            imagen = new Texture("horror idle.png");
        }else if(f == 1){
            imagen = new Texture("horror walk.png");
        }else{

        }



    }
*/

}
