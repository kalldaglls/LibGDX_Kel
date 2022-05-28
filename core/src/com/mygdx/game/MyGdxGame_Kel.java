package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame_Kel extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Triss.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1f, 0, 0, 1);
//		ScreenUtils.clear(Color.CYAN);

		Gdx.graphics.setTitle("Xo XO!");

		float x = Gdx.input.getX();
		float y = Gdx.graphics.getHeight() - Gdx.input.getY() + 1f;
//		float y = Gdx.input.getY();
//		System.out.println(x);
//		System.out.println(y);
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			ScreenUtils.clear(Color.CYAN);
			Gdx.app.exit();
		}


		batch.begin();
//		batch.draw(img, x, y, x + 1f, y + 2f, 1f, 2f,
//				1f, 2f, 1f, 2, 3, 2, 2, true, true);
//		batch.draw(img, x, y);
//		batch.draw(img, x, y, 100, 100);
//		batch.draw(img, x, y, img.getWidth(), img.getHeight());
//		batch.draw(img, x, y, 128, 128, 0, 0, 0.5f, 0.5f);
		batch.draw(img, x, y,
				0, 0,
				img.getWidth(), img.getHeight(),
				0.5f, 0.3f,
				45,
				1, 1, img.getWidth(), img.getHeight(),
				false, false);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
