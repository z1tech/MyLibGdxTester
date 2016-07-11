package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.z1ontech.mylibgdxtester.GameMain;

import helpers.GameInfo;
import player.Player;

/**
 * Created by Owner on 7/4/2016.
 */
public class MainMenu implements Screen {
    private GameMain game;

    private Texture bg;
    private Player player;
    private World world;
    private OrthographicCamera box2DCamera;
    private Box2DDebugRenderer debugRenderer;

    public MainMenu(GameMain game) {
        this.game = game;

        box2DCamera = new OrthographicCamera();
        box2DCamera.setToOrtho(false, GameInfo.WIDTH/GameInfo.PPM, GameInfo.HEIGHT/GameInfo.PPM);
        box2DCamera.position.set(GameInfo.WIDTH / 2, GameInfo.HEIGHT / 2, 0);

        debugRenderer = new Box2DDebugRenderer();

        // the world constructor takes a vector2 paramater (essentially an x and y value?) which defines gravity acting on x axis, and gravity acting on y axis. doSleep is set to true
        // so that if the object has no forces applied to it, "sleep" the object (do no calculations) to save memory and processing headroom.
        world = new World(new Vector2(0, -9.8f), true);

        bg = new Texture("Game BG.png");
        player = new Player(world, "Player 1.png", GameInfo.WIDTH / 2, GameInfo.HEIGHT / 2 + 250 );

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        player.updatePlayer();

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        game.getBatch().draw(bg, 0, 0);
        game.getBatch().draw(player, player.getX(), player.getY()- player.getHeight()/2);
        game.getBatch().end();


        debugRenderer.render(world, box2DCamera.combined);

        // getDeltaTime returns the amount of real time that it takes to get from frame to frame. This adjusts the amount of time to simulate so that the game runs at the same rate,
        // regardless of processor speed or slowdowns in FPS. velocityiterations and positioniterations are used to calculate collisions through the constraint solver. Higher numbers
        // are higher precision, but more resource intensive.
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
} // main menu end
