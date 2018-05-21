import java.util.ArrayList;
/**
 * Created by Martin Willman & Amine Balta on 17-10-03.
 */
public class Neuron {


    private static final Double BIAS = 1.0;
    private ArrayList<Double> weights = new ArrayList<Double>();
    private double lr;
    private int category;
    private double error;

    /**
     * This class add weights for each pixel and add the bias weight.
     * @param lr
     * @param category
     * @param numberOfWeights
     */
    public Neuron(double lr, int category, int numberOfWeights){
        this.lr = lr;
        this.category = category;
        for (int i=0; i<numberOfWeights; i++){
                this.weights.add(Math.random());
        }
        /*Add bias weight*/
        this.weights.add(BIAS);
    }

    /**
     * This method sums the value of all pixles in an image with the corresponding weight. Put the sum
     * in an activation function, in this case sigmoid then returns the sum.
     * @param imagePixels
     * @return the activation sum.
     */
    public double guess(ArrayList<Integer> imagePixels){
        float sum = 0;
        for(int i=0; i<imagePixels.size();i++){
            sum += imagePixels.get(i) * weights.get(i);

        }
        /*Add the bias weight*/
        sum += weights.get(imagePixels.size());

        return activationFunc(sum);

    }

    /**
     * This method gets the sum from guess and computes the error. Computes the
     * and updates the weights.
     * @param pixels
     * @param facit
     */
    public void train(ArrayList<Integer> pixels, int facit) {
        double guess =  guess(pixels);

        error = facit - guess;
        for (int i = 0; i < pixels.size(); i++) {
            weights.set(i, (error * pixels.get(i) * lr) + weights.get(i));

        }

    }

    /**
     * This method is used for test the network.
     * @param image
     * @return a guess for the image.
     */
    public Double test(ArrayList<Integer> image) { return this.guess(image); }

    /**
     * This is the sigmoid activation function.
     * @param x
     * @return activation of x
     */
    public Double activationFunc(double x){
        return (1 / (1 + Math.exp(-x)));
    }

    /**
     * This method returns the number of the face as an int.
     * @return an integer of a number between 1-4, 1 = Happy, 2 = Sad, 3 = Mischievous and 4 = Mad.
     */
    public int getCategory() { return category; }
}

