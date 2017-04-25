package menus.algo;

import lombok.experimental.var;
import menu.algo.Filter;
import menus.model.Menu;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Local_admin on 4/22/2017.
 */
public class FilterTest {
    Filter algo = new Filter();



    @Test
    public void testOnlyOneItemIsReturned(){
        List<Menu> list = algo.permissionScopedMenus(0);
        System.out.println(list);
        int size = list.size();
        Assert.assertEquals(1, size);
        Assert.assertEquals("n101", list.get(0).getOperationCode());
    }

    @Test
    public void testOnlyThis2ItemsAreAllowed(){
        List<Menu> list = algo.permissionScopedMenus(0);
        var firstItemChildren = list.get(0).getChildren();
        var c1 = firstItemChildren.get(0);
        var c2 = firstItemChildren.get(1);
        boolean b1 = c1.getOperationCode().equals("n201");
        boolean b2 = c2.getOperationCode().equals("n202");
        Assert.assertEquals(firstItemChildren.size(), 2);
        Assert.assertEquals(b1, true);
        Assert.assertEquals(b2, true);
    }

}
