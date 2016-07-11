package helpers;

/**
 * Created by Owner on 7/4/2016.
 */
public class GameInfo {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    //Pixels per meter constant is set to be 100 pixels equal to 1 meter. Box2D by default assumes a 1:1 ratio ie 1 pixel is 1 meter. Because our player is smaller and will need less
    // force to move than 80*100m (for example) physical object, we will scale down to 100:1.
    public static final int PPM = 100;

}//end game info class
