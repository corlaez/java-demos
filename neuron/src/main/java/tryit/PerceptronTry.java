package tryit;

import lombok.Data;
import lombok.NonNull;

/**
 * Created by Local_admin on 4/29/2017.
 */
@Data
public class PerceptronTry {
    Double bias;
    Double[] inputs;
    Double[] weights;
    Integer size;

    public PerceptronTry(int size){
        this.size = size;
    }

    public Double variation(@NonNull Double[] inputs, @NonNull Double[] weights, @NonNull Double bias) {
        if(inputs.length != weights.length)
            throw new IllegalArgumentException("Inputs and weights should have equal number of elements.");
        Double [] zeroInputs = new Double [inputs.length];
        for (int i = 0; i < zeroInputs.length; i++) {
            zeroInputs[i] = 0D;
        }
        Double vWeight = weightedSummatory(this.inputs, this.weights) - weightedSummatory(inputs, weights);
        Double vBias = this.bias - bias;
        return vWeight + vBias;
    }
    public Double calcule(){
        Double weigthedSummatory = weightedSummatory(inputs, weights);
        return sigmoid(weigthedSummatory + bias);
    }

    public Double weightedSummatory(Double[] inputs, Double[] weights) {
        Double weigthedSummatory = 0D;
        for (int i = 0; i < inputs.length; i++) {
            weigthedSummatory = inputs[i] * weights[i];
        }
        return weigthedSummatory;
    }

    public Double sigmoid(Double input) {
        return Math.pow(Math.exp(input) + 1, -1);
    }

}
