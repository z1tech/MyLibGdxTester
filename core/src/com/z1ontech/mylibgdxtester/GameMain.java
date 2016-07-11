package com.z1ontech.mylibgdxtester;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import helpers.GameInfo;
import scenes.MainMenu;

public class GameMain extends Game {

   private SpriteBatch batch;
//   1 Texture img;
//   1 Sprite player;

    @Override
    public void create() {
//     1   System.out.println("Create was called");
//      1  batch = new SpriteBatch();
//       1 img = new Texture("Game BG.png");
//        1player = new Sprite(new Texture("Player 1.png"));
//
//  1      player.setPosition((GameInfo.WIDTH/2) - player.getWidth()/2, (GameInfo.HEIGHT/2) - player.getHeight()/2 );

        batch = new SpriteBatch();
        setScreen(new MainMenu(this));
    }

    @Override
    public void render() {
//   1     Gdx.gl.glClearColor(1, 0, 0, 1);
//    1    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//1
// 1       player.setPosition(player.getX()-1, player.getY());
//  1      batch.begin();
//   1     batch.draw(img, 0, 0);
//    1    batch.draw(player, player.getX(), player.getY() );
//     1   batch.end();
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
//      1  img.dispose();
    }
    public SpriteBatch getBatch(){
        return batch;
    }
}
