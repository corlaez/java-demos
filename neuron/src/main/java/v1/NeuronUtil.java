package v1;

import java.util.Random;

/**
 * Created by Local_admin on 4/29/2017.
 */
public class NeuronUtil {
    Random random = new Random();

    public Double nextDouble(){
        return random.nextDouble();
    }

    public Double[] random01Arr(int length) {
        Double[] arr = new Double[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextDouble();
        }
        return arr;
    }
}
