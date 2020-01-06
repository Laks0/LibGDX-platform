package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.Player;

import world.GameMap;
import world.TiledGameMap;

public class Test extends Game implements ApplicationListener {
	SpriteBatch batch;
	
	OrthographicCamera camera;
	GameMap gameMap;
	
	Player player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		gameMap = new TiledGameMap("map.tmx");
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
		
		player = new Player(180, 500);
	}

	@Override
	public void render () {
		gameMap.render(camera);
		
		player.update(Gdx.graphics.getDeltaTime(), gameMap);
		
		batch.begin();
		player.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.dispose();
	}
}
