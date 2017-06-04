package tryit;

import lombok.experimental.var;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Local_admin on 4/29/2017.
 */
public class LayerTry {
    LayerTry nextLayer;
    List<PerceptronTry> perceptronTryList;

    public void init(){
        var outputs = perceptronTryList.stream().map(PerceptronTry::calcule).collect(Collectors.toList());
        nextLayer.propagate(outputs);
    }

    private void propagate(List<Double> outputs) {
        for (PerceptronTry pt: perceptronTryList) {
            Double[] oneWeigths = new Double [outputs.size()];
            for (int i = 0; i < oneWeigths.length; i++) {
                oneWeigths[i] = 1D;
            }
            pt.setSize(outputs.size());
            pt.setBias(0.5);
            pt.setWeights(oneWeigths);
            pt.calcule();
        }
    }


}
