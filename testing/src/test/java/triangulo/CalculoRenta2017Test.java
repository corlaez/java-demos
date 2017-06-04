package triangulo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static triangulo.CalculoRenta2017.UIT;

/**
 * Created by Local_admin on 4/26/2017.
 */
public class CalculoRenta2017Test {
    CalculoRenta2017 calculoRenta2017 = new CalculoRenta2017();

    @Test
    public void testTasas(){
        assertThat(0D, is(calculoRenta2017.tasa(UIT  * 0)));
        assertThat(0D, is(calculoRenta2017.tasa(UIT  * 1)));
        assertThat(0D, is(calculoRenta2017.tasa(UIT  * 7)));

        assertThat(0.08D, is(calculoRenta2017.tasa(UIT  * 7 + 1)));
        assertThat(0.08D, is(calculoRenta2017.tasa(UIT  * 12)));

        assertThat(0.14D, is(calculoRenta2017.tasa(UIT  * 12 + 1)));
        assertThat(0.14D, is(calculoRenta2017.tasa(UIT  * 27)));

        assertThat(0.17D, is(calculoRenta2017.tasa(UIT  * 27 + 1)));
        assertThat(0.17D, is(calculoRenta2017.tasa(UIT  * 42)));

        assertThat(0.20D, is(calculoRenta2017.tasa(UIT  * 42 + 1)));
        assertThat(0.20D, is(calculoRenta2017.tasa(UIT  * 52)));

        assertThat(0.30D, is(calculoRenta2017.tasa(UIT  * 52 + 1)));
        assertThat(0.30D, is(calculoRenta2017.tasa(UIT  * 60)));
    }

    @Test
    public void tesImpuesto(){
        assertThat(3792D, is(calculoRenta2017.impuesto(UIT  * 12)));
    }

}
