/**
 * Created by Martin Willman & Amine Balta on 17-10-03.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class reads three files and put them in a suitable data
 * structures. Training file and test file are made as image list and
 * facit file as a map.
 */
public class ImageAndFacitPlaceholder {
    private ArrayList<Image> trainingImages = new ArrayList<Image>();
    private ArrayList<Image> testImages = new ArrayList<Image>();
    private Map<String, Integer> facitMap = new HashMap<String, Integer>();

    /**
     * This class takes in the three different files. The files are the training file, facit file and testing file.
     * @param trainingFile
     * @param facitFile
     * @param testFile
     */
    public ImageAndFacitPlaceholder(String trainingFile, String facitFile, String testFile){

        trainingImages = convertToImagelist(trainingFile);
        doFacitMap(facitFile);
        testImages = convertToImagelist(testFile);


    }

    /**
     * This class reads the facit file and put the values in a map where the image name is the key
     * and number of the face is the value.
     * @param file
     */
    private void doFacitMap(String file) {

        File facitFile = new File(file);
        String line;
        String key;
        Integer faceValue;

        try {
            Scanner scanner = new Scanner(facitFile);
            while(scanner.hasNextLine()){
                line = scanner.nextLine();

                if(line.startsWith("Image")){
                    String[] arr = line.trim().split(" ");
                    key = arr[0];
                    faceValue = Integer.parseInt(arr[1]);

                    facitMap.put(key, faceValue);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     * This method reads the training file, test file and put them in a list of images.
     * @param fileName
     * @return a list of images.
     */
    private ArrayList<Image> convertToImagelist(String fileName){

        File file = new File(fileName);
        String line;
        String imageName;
        ArrayList<Integer> pixels = new ArrayList<Integer>();
        ArrayList<Image> images = new ArrayList<Image>();



        try{
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                line = scanner.nextLine();
                /*This is for skipping lines that's not images*/
                if(line.startsWith("Image")){
                    imageName = line;
                    /*This if for making the list to a matrix*/
                        for(int i=0;i<20;i++) {
                            line = scanner.nextLine();

                            String[] arr = line.trim().split(" ");
                            for (int j = 0; j < arr.length; j++) {
                                pixels.add(Integer.parseInt(arr[j]));
                            }
                        }
                    images.add(new Image(imageName,pixels));
                    pixels.clear();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return images;
    }

    /**
     * This method is used for getting the training images.
     * @return the training images in a list.
     */
    public ArrayList<Image> getTrainingImages(){
        return this.trainingImages;
    }

    /**
     * This method is used for getting the test images.
     * @return the test images in a list
     */
    public ArrayList<Image> getTestImages(){
        return this.testImages;
    }

    /**
     * This method is only used for testing.
     * @param key
     * @return the number of the picture as an int.
     */
    public int getFacit(String key){
        return this.facitMap.get(key);
    }

    /**
     * This method is for getting the facit.
     * @return the facit map.
     */
    public Map<String,Integer> getFacitMap() {
        return this.facitMap;
    }
}