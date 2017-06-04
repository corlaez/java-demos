package triangulo;

/**
 * Created by Local_admin on 4/26/2017.
 */
public class TriangleService {
    public static final String ESCALENO = "ESCALENO";
    public static final String ISOCELES = "ISOCELES";
    public static final String EQUILATERO = "EQUILATERO";
    public static final String NO_EXISTE = "NO_EXISTE";

    public String tipo(int a, int b, int c) {
        if (a == b && b == c)
            return EQUILATERO;
        if (a == b || b == c || a == c)
            return ISOCELES;
        else if(existe(a,b,c))
            return ESCALENO;
        return NO_EXISTE;
    }

    private boolean existe(int a, int b, int c) {
        return a < b + c && b < a + c && c < a + b;
    }

}