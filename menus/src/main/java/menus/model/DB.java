package menus.model;

import lombok.experimental.var;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Local_admin on 4/22/2017.
 */
public class DB {
    Menu dbMasterMenu;

    public List<String> operationsAllowed(int permissionId){
        var list = new ArrayList<String>();
        list.add("n201");
        list.add("n202");
        return list;
    }

    public Menu masterMenu(int permissionId){
        if(dbMasterMenu != null)
            return dbMasterMenu;
        //reusable
        List<Menu> currentChildren;
        Menu currentMenu;
        //set up basic
        Menu masterMenu = new Menu();
        masterMenu.setId(0);
        masterMenu.setName("master");
        masterMenu.setOperationCode("master");



        //set up children of master
        currentChildren = masterMenu.getChildren();
        currentMenu = new Menu();
        currentMenu.setId(1);
        currentMenu.setName("n101");
        currentMenu.setOperationCode("n101");
        currentChildren.add(currentMenu);

        currentMenu = new Menu();
        currentMenu.setId(2);
        currentMenu.setName("n102");
        currentMenu.setOperationCode("n102");
        currentChildren.add(currentMenu);




        //set up children of n101
        currentChildren = masterMenu.getChildren().get(0).getChildren();
        currentMenu = new Menu();
        currentMenu.setId(1);
        currentMenu.setName("n201");
        currentMenu.setOperationCode("n201");
        currentChildren.add(currentMenu);

        currentMenu = new Menu();
        currentMenu.setId(2);
        currentMenu.setName("n202");
        currentMenu.setOperationCode("n202");
        currentChildren.add(currentMenu);

        //set up children of n102
        currentChildren = masterMenu.getChildren().get(1).getChildren();
        currentMenu = new Menu();
        currentMenu.setId(1);
        currentMenu.setName("n203");
        currentMenu.setOperationCode("n203");
        currentChildren.add(currentMenu);

        currentMenu = new Menu();
        currentMenu.setId(2);
        currentMenu.setName("n204");
        currentMenu.setOperationCode("n204");
        currentChildren.add(currentMenu);
        //cache menu
        dbMasterMenu = masterMenu;
        //defensive copy
        Menu copyMasterMenu = new Menu();
        List<Menu> nList = new ArrayList<>();
        nList.addAll(masterMenu.getChildren());
        copyMasterMenu.setChildren(nList);
        copyMasterMenu.setParent(masterMenu.getParent());
        copyMasterMenu.setOperationCode(masterMenu.getOperationCode());
        copyMasterMenu.setId(masterMenu.getId());
        copyMasterMenu.setName(masterMenu.getName());

        return copyMasterMenu;
    }

}
