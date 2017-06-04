package example.soap;

import lombok.experimental.var;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Jarmando on 6/2/2017.
 */
public class BasicService {
    static
    {
        System.setProperty(LogFactory.FACTORY_PROPERTY, LogFactory.FACTORY_DEFAULT);
    }

    public String helloWorld(){
        return "Hello World";
    }

    public String salute(String name, int age) {
        //%d int, %f decimal, %c character,...
        return String.format("Hi %s, you are %d years old", name, age);
    }

    public String filterNumbers(String numeros){
        var newString = Arrays.stream(numeros.split(","))
                .distinct()
                .collect(Collectors.joining(","));
        return newString;
    }

    public String filterNumbers2(String numeros){
        var arrNumbers = numeros.split(",");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < arrNumbers.length; i++) {
            set.add(arrNumbers[i]);
        }
        return set.stream().collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        String s =new BasicService().filterNumbers("1,2,2,2,4,5,2,1,1,1,5");
        System.out.println(s);
    }
}
