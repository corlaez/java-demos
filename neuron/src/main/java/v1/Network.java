package v1;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

/**
 * Created by Local_admin on 4/29/2017.
 */
public class Network {

    public Network(int ... sizes){
        //instantiate layers
        Layer[] layers = new Layer[sizes.length];
        for (int i = 0; i < layers.length; i++) {
            layers[i] = new Layer(sizes[i]);//instantiate layer neurons.
        }
        layers[0].setBias(0D);//inputs have no bias
    }

    public static void main(String ... vargs) {
        INDArray nd = Nd4j.create(new float[]{1, 2, 3, 4}, new int[]{2, 2});
        System.out.println(nd);
    }

}