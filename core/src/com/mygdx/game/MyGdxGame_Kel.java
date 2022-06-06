package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame_Kel extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TextureRegion region;
	private int x,y;
	AnimPlayer batmanAnim;
	AnimPlayer batmanAnim2;
	Label label;
	
	@Override
	public void create () {//Здесь инициализируем поля!
		batch = new SpriteBatch();
		img = new Texture("Batman.png");
		batmanAnim = new AnimPlayer("Batman.png", 8, 1, 16f, Animation.PlayMode.LOOP);
		batmanAnim2 = new AnimPlayer("runRight.png", 8, 1, 10.0f, Animation.PlayMode.LOOP);
		label = new Label(36);
		//region = new TextureRegion(img);
	}

	@Override
	public void render () {//Здесь отрисовываем!
		ScreenUtils.clear(new Color(Color.LIGHT_GRAY));
		//ScreenUtils.clear(0.5f,0.5f,0.5f,0.5f); //Черный - 0, Серый - 0.5, Белый - 1
//		Gdx.gl.glClearColor(100, 1, 1, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



		Gdx.graphics.setTitle("Xo Xo!");

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) x--;
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x++;
//		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) y--;
//		if(Gdx.input.isKeyPressed(Input.Keys.UP)) y++;

		batmanAnim.step(Gdx.graphics.getDeltaTime());

		batch.begin();
		batch.draw(batmanAnim.getFrame(), x, 50);//Почему отрисовывается только первый бэт?
//		batch.draw(batmanAnim2.getFrame(), x, 0, 50f, 50f);
//		batch.draw(label.draw(batch,));
		//batch.draw(region, 0,0, 0, 0, 500f,200f, 1f, 1f, 0);
		label.draw(batch, "Welcome to Gotham!");

		batch.end();
	}
	
	@Override
	public void dispose () {//Здесь закрываем/удаляем/освобождаем ресурсы!
		batch.dispose();
		batmanAnim.dispose();
	}
}
