package player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;

/**
 * Created by Owner on 7/4/2016.
 */
public class Player extends Sprite {

    private World world;
    private Body body;

    public Player(World world, String textureName, float x, float y) {
        super(new Texture(textureName));
        // assign a world to the player object so that it has a physics manager.
        this.world = world;
        setPosition(x - getWidth() / 2, y - getHeight() / 2 );
        this.createBody();
    }

    void createBody(){

        BodyDef bodyDef = new BodyDef();
        // a static bodyu is not affected by gravity or other physics forces.
        // a kinematic body is not affected by gravity but is affected by other forces.
        // a dynamic body is affected by gravity and other physics forces.
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        bodyDef.position.set(getX() / GameInfo.PPM, getY()/GameInfo.PPM);
        // world objects manage physical elements, including bodies. The createBody method here is SEPERATE from the void createBody() above. world.createBody assigns many definitions to
        // the body type (physics attributes). We pass into the bodyDef that we've defined in the two lines above. Presumeably, the other definitions in world.createBody are assigned
        // automatically if not manually defined through bodyDef.____ parameter assignments (such as bodyDef.type = BodyDef.BodyType.DynamicBody).
        body = world.createBody(bodyDef);
        //PolygonShape essentially defines the collider that will collide with other game objects.
        PolygonShape shape = new PolygonShape();
        //we set the shape as box so that the box surrounding the player image exactly matches the png file. Unsure why the width and height is being divided by 2.
        shape.setAsBox((getWidth()/2) /GameInfo.PPM, (getHeight()/2) / GameInfo.PPM);
        // we assign the collider shape to the body by defining a fixture definition.
        FixtureDef fixtureDef = new FixtureDef();
        //assign the fixtureDef shape to the previously defined shape
        fixtureDef.shape = shape;
        // density assigns a mass.
        fixtureDef.density = 1;

        // we attach the actual body to the fixture by instantiating a fixture object, and passing it a createFixture BELONGING to body object but PASSING a fixtureDef object (both
        // created and instantiated above)
        Fixture fixture = body.createFixture(fixtureDef);

        //since we already defined the shape of the fixture, we don't need this shape object anymore and we can dispose of it.
        shape.dispose();
    }

    public void updatePlayer(){
        // Update the position of the VISIBLE sprite to the position of the INVISIBLE body (which is able to do physics stuff, and why we needed the link in the first place).
        this.setPosition(body.getPosition().x * GameInfo.PPM ,body.getPosition().y * GameInfo.PPM);

    }

}//player class end
