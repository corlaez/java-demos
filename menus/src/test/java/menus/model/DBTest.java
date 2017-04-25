package menus.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Local_admin on 4/22/2017.
 */
public class DBTest {
    DB db = new DB();

    @Test
    public void testMasterHasTwoChild() {
        assertEquals(2, db.masterMenu(0).getChildren().size());
    }

    @Test
    public void testEachLvl1HasTwoChild() {
        assertEquals(2, db.masterMenu(0).getChildren().get(0).getChildren().size());
        assertEquals(2, db.masterMenu(0).getChildren().get(1).getChildren().size());
    }
}
