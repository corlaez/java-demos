package examen.beans;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interprete {
    public static final String TEST_STRING = "[{AIRBUS X5,300,Lima (PE),Aarhus (DK),C}|{BOEING T500,500,Cusco (PE),Bruselas\n" +
            "(BELG),C}|{Jet TDL 8B52,50,Paris (FR),Venecia (IT),P}|{AIRBUS Z22,100,Lima (PE),Colonia" +
            "(AL),C}|{AIRBUS X10,900,Amsterdam (HL),Los Angeles (EEUU),C}|{BOEING 670,200,Lima" +
            "(PE),Malmo (SZ),C}|{X72 JET V,30,Washington (EEUU),Londres (UK),P}]";
    public static final String TEST_STRING_ENCODED = "%5B%7BAIRBUS%20X5%2C300%2CLima%20%28PE%29%2CAarhus%20%28DK%29%2CC%7D%7C%7BBOEING%20T500%2C500%2CCusco%20%28PE%29%2CBruselas%28BELG%29%2CC%7D%7C%7BJet%20TDL%208B52%2C50%2CParis%20%28FR%29%2CVenecia%20%28IT%29%2CP%7D%7C%7BAIRBUS%20Z22%2C100%2CLima%20%28PE%29%2CColonia%28AL%29%2CC%7D%7C%7BAIRBUS%20X10%2C900%2CAmsterdam%20%28HL%29%2CLos%20Angeles%20%28EEUU%29%2CC%7D%7C%7BBOEING%20670%2C200%2CLima%28PE%29%2CMalmo%20%28SZ%29%2CC%7D%7C%7BX72%20JET%20V%2C30%2CWashington%20%28EEUU%29%2CLondres%20%28UK%29%2CP%7D%5D";

    private String input;
    @Getter
    private String vuelosConError;

    public Interprete(String input) {
        this.input = input;
    }

    public List<PlanDeVuelo> execute() {
        List<PlanDeVuelo> list = new ArrayList<>();
        try {
            String noBrackets = removeEnclosing(input, "[", "]");
            List<String> listaPlanesString = new ArrayList<>(Arrays.asList(noBrackets.split("\\|")));
            System.out.println(listaPlanesString);
            for (String plan : listaPlanesString) {
                try {
                    List<String> listaCampos = new ArrayList<>(
                            Arrays.asList(
                                    removeEnclosing(plan, "{", "}").split(",")));
                    list.add(new PlanDeVuelo(
                            listaCampos.get(0),
                            listaCampos.get(1),
                            listaCampos.get(2),
                            listaCampos.get(3),
                            listaCampos.get(4)
                    ));
                } catch (Exception e) {
                    e.printStackTrace();
                    if (vuelosConError == null)
                        vuelosConError = "";
                    vuelosConError += plan;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            list = null;
        }
        System.out.println("interprete: " + list);
        return list;
    }

    private String removeEnclosing(String obj, String first, String last) {
        String ns = obj.trim();
        String brackets = ns.substring(0,1) + ns.substring(ns.length()-1);
        if(brackets.equals(first + last))
            return ns.substring(1, ns.length() - 1);
        else
            throw new RuntimeException("invalid enclosing " + first + last);
    }

    public static void main(String ... strings){
        //test interprete
        new Interprete(Interprete.TEST_STRING).execute();
    }
}


