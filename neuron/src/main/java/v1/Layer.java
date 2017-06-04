package v1;

import lombok.Data;

/**
 * Created by Local_admin on 4/29/2017.
 */
@Data
public class Layer {
    Double bias;

    public Layer(int numberOfNeurons) {
        bias = new NeuronUtil().nextDouble();
    }
}
