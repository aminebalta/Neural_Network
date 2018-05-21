
/**
 * Created by Martin Willman & Amine Balta on 17-10-03.
 */

public class Faces {

    /**
     * This is the main file where the program takes in the files and call the other functions.
     * @param args
     */
    public static void main(String [] args){



        ImageAndFacitPlaceholder imageAndFacitPlaceholder = new ImageAndFacitPlaceholder(args[0], args[1], args[2]);

        /*TEST*/
        //ImageAndFacitPlaceholder imageAndFacitPlaceholder = new ImageAndFacitPlaceholder("src/training-A.txt",
                //"src/facit-A.txt", "src/test-B.txt");

        NeuralNetwork neuralNetwork = new NeuralNetwork();

        neuralNetwork.trainNetwork(imageAndFacitPlaceholder.getTrainingImages(),imageAndFacitPlaceholder.getFacitMap());

        neuralNetwork.testNetwork(imageAndFacitPlaceholder.getTestImages());
    }

}