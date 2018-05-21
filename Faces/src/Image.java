import java.util.ArrayList;
/**
 * Created by Martin Willman & Amine Balta on 17-10-03.
 */

public class Image {

    private String name;

    private ArrayList<Integer> pixels = new ArrayList<Integer>();

    /**
     * This class creates the image.
     * @param name
     * @param pixels
     */
    public Image(String name, ArrayList<Integer> pixels){
        this.name = name;
        this.pixels.addAll(pixels);

    }

    /**
     * This method return the image name
     * @return image name as a string.
     */
    public String getName(){ return name; }

    /**
     * Returns all pixel in an image as an array.
     * @return pixel array
     */
    public ArrayList<Integer> getPixels(){ return pixels; }

}
