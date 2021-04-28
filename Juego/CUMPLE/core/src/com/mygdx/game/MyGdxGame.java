package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// http://millionthvector.blogspot.com/p/free-sprites.html

public class MyGdxGame extends ApplicationAdapter {

	static Random random = new Random();
	SpriteBatch batch;
	Background background;
	J1 j1;
	J2 j2;

	static Assets assets;
	List<Alien> aliens;
	List<Bullet> balasAEliminar = new ArrayList<>();
	List<Alien> aliensAEliminar = new ArrayList<>();
	Time temporizadorNuevoAlien;

	Attack attack;
	Walk walk;
	@Override
	public void create() {
		assets = new Assets();

		assets.load();

		while(!assets.update());

		attack = new Attack();
		walk = new Walk();


		batch = new SpriteBatch();
		background = new Background();
		j1 = new J1();
		j2 = new J2();

		aliens = new ArrayList<>();

		aliens.add(new Alien());

		temporizadorNuevoAlien = new Time(120);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);






		Time.tiempoJuego += 1;

		if(temporizadorNuevoAlien.suena()){
			aliens.add(new Alien());
		}









		j1.update();
		j2.update();




		for(Alien alien:aliens) alien.update();


		balasAEliminar.clear();
		aliensAEliminar.clear();
		for(Alien alien: aliens){
			for(Bullet bala: j1.bullets){
				if (overlap(bala.x, bala.y, bala.w, bala.h, alien.x, alien.y, alien.w, alien.h)) {
					balasAEliminar.add(bala);
					aliensAEliminar.add(alien);
				}
			}
		}
		for (Bullet bullet:balasAEliminar){
			j1.bullets.remove(bullet);
		}
		for (Alien alien:aliensAEliminar) {
			aliens.remove(alien);
		}








		batch.begin();
		background.render(batch);

		attack.render(batch);
		walk.render(batch);

		j1.render(batch);
		j2.render(batch);
		j1.animation(batch);
		j2.animation(batch);



		for(Alien alien:aliens) alien.render(batch);


		batch.end();

	}

	boolean overlap(float x, float y, float w, float h, float x2, float y2, float w2, float h2){
		return !(x > x2 + w2) && !(x + w < x2) && !(y > y2 + h2) && !(y + h < y2);
	}
}