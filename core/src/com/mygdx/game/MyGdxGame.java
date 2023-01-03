package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture backgroundImg;
	Texture planeImg1;
	Texture bulletImg;
	Texture cloudImg[];
	Texture missileImg;
	Texture explosionImg;
	int mouseX;
	int mouseY;
	float speedX;
	float speedY;
	Plane plane;
	Background[] background;
	ArrayList<Bullet> bullets;
	ArrayList<Missile> missiles;
	int bulletFrame;
	int missileFrame;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		backgroundImg = new Texture("background.png");
		planeImg1 = new Texture("plane.png");
		bulletImg = new Texture("bullet.png");
		missileImg = new Texture("missile1.png");

		cloudImg = new Texture[4];
		cloudImg[0] = new Texture("cloud1.png");
		cloudImg[1] = new Texture("cloud2.png");
		cloudImg[2] = new Texture("cloud3.png");
		cloudImg[3] = new Texture("cloud4.png");

		plane = new Plane(planeImg1);
		background = new Background[3];
		missiles = new ArrayList<Missile>();

		for(int i = 0; i < background.length; i++) {
			background[i] = new Background(backgroundImg, i);
		}
		bullets = new ArrayList<Bullet>();
	}

	@Override
	public void render () {

		ScreenUtils.clear(Color.BLACK);
		batch.begin();

		//frames
		bulletFrame++;
		missileFrame++;


		speedX = plane.getXSpeed();
		speedY = plane.getYSpeed();

		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
//			int length = bullets.size();
//			if(length == 0){
//				bullets.add(new Bullet(bulletImg, plane));
//			}
//			length = bullets.size();

			if(bulletFrame % 3 == 0) {
				bullets.add(new Bullet(bulletImg, plane));
			}

		}

		if(missileFrame % 10 == 0){
			missiles.add(new Missile(missileImg, plane));
		}


		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			plane.increaseSpeed();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)){
			plane.decreaseSpeed();
		}

		for(int i = 0; i < background.length; i++) {
			background[i].update(speedX, speedY);
			background[i].draw(batch);
		}

		try{
			for(Bullet b : bullets) {
				if(!b.getStatus()){
					bullets.remove(b);
				}
				b.update();
				b.draw(batch);
				System.out.println(bullets.size());
			}
		}
		catch (Exception e) {
			System.out.println("bullet try catch bug detected");
		}

		try{
			for(Missile m : missiles) {
				if(!m.getStatus()){
					missiles.remove(m);
				}
				m.update();
				m.draw(batch);
				System.out.println(missiles.size());
			}
		}
		catch (Exception e) {
			System.out.println("missile try catch bug detected");
		}

		plane.update();
		plane.draw(batch);


		batch.end();
	}

}
