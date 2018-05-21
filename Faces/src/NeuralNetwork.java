import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by Martin Willman & Amine Balta on 17-10-03.
 */

public class NeuralNetwork {


    private ArrayList<Neuron> neurons = new ArrayList<>();
    private final Double lr = 0.01;
    private final int IMAGE_SIZE = 400;
    private int trainingRounds = 400;
    private int HAPPY = 1;
    private int SAD = 2;
    private int MISCHIEVOUS = 3;
    private int MAD = 4;


    /**
     * This class makes the neurons in the network. The network has 4 neurons one for each face expression.
     */
    public NeuralNetwork() {
        neurons.add(new Neuron(lr, HAPPY, IMAGE_SIZE));
        neurons.add(new Neuron(lr, SAD, IMAGE_SIZE));
        neurons.add(new Neuron(lr, MISCHIEVOUS, IMAGE_SIZE));
        neurons.add(new Neuron(lr, MAD, IMAGE_SIZE));

    }

    /**
     * This method is used for training the network.
     * @param images
     * @param facit
     */
    public void trainNetwork(ArrayList<Image> images, Map<String, Integer> facit) {
        int expectedFaceValue;
        for (int i = 0; i < trainingRounds; i++) {
            for (Image image : images) {
                for (Neuron neuron : neurons) {

                    /* Set the expected value as 1 if the faceValue of the node is the same as the images facit, else 0*/
                    expectedFaceValue = (neuron.getCategory() == facit.get(image.getName()) ? 1 : 0);
                    neuron.train(image.getPixels(), expectedFaceValue);

                }
            }
        }

    }

    /**
     * This method is used to testing the network after training it and prints the result.
     * @param images
     */
    public void testNetwork(ArrayList<Image> images) {
        for (Image image : images) {
            Map<Double, Integer> guessMap = new HashMap<>();
            for (Neuron neuron : neurons) {
                guessMap.put(neuron.test(image.getPixels()), neuron.getCategory());

            }
            Double highestGuess = Collections.max(guessMap.keySet());
            int category = guessMap.get(highestGuess);
            System.out.println(image.getName() + " " + category);
        }

    }
}