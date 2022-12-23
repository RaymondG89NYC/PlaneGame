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
	int mouseX;
	int mouseY;
	float speedX;
	float speedY;
	Plane plane;
	Background[] background;
	ArrayList<Bullet> bullets;
	int bulletFrame;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		backgroundImg = new Texture("background.png");
		planeImg1 = new Texture("plane.png");
		bulletImg = new Texture("bullet.png");

		plane = new Plane(planeImg1);
		background = new Background[3];

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

		speedX = plane.getXSpeed();
		speedY = plane.getYSpeed();

		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
//			int length = bullets.size();
//			if(length == 0){
//				bullets.add(new Bullet(bulletImg, plane));
//			}
//			length = bullets.size();

			if(bulletFrame % 10 == 0) {
				bullets.add(new Bullet(bulletImg, plane));
			}

		}

		try{
			for(Bullet b : bullets) {
				b.update();
				b.draw(batch);
				System.out.println("x: " + b.getX());
				System.out.println("y: " + b.getY());
				System.out.println("size: " + bullets.size());
			}
		}
		catch (Exception e) {
			System.out.println("bullet try catch bug detected");
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

		plane.update();
		plane.draw(batch);


		batch.end();
	}

}
