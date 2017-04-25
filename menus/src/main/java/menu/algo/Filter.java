package menu.algo;

import lombok.experimental.var;
import menus.model.DB;
import menus.model.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Local_admin on 4/22/2017.
 */
public class Filter {

    public List<Menu> permissionScopedMenus(int permissionId){
        DB db = new DB();
        Menu masterMenu = db.masterMenu(permissionId);
        List<String> operationsAllowed = db.operationsAllowed(permissionId);
        List<Menu> filteredMenus = filtrar2(masterMenu, operationsAllowed);
        return filteredMenus;
    }

    private List<Menu> filtrar(List<Menu> children, List<String> operationsAllowed) {
        List<Menu> withChildren = children.stream().filter(c -> c.getChildren().size() > 0).collect(Collectors.toList());
        List<Menu> operationsMenus = children.stream().filter(c -> c.getChildren().size() == 0).collect(Collectors.toList());
        List<Menu> childrenToRemove = new ArrayList<>();

        for (Menu menuWithChildren: withChildren) {//ESCAPE RECURSIVE METHOD
            List<Menu> filteredMenus = filtrar(menuWithChildren.getChildren(), operationsAllowed);//RECURSIVE CALL
            menuWithChildren.setChildren(filteredMenus);//SET FILTERED CHILDREN
            if(menuWithChildren.getChildren().size() == 0) {
                childrenToRemove.add(menuWithChildren);//DELETE CHILDREN WITHOUT CHILDREN (THAT WAS SUPPOSED TO HAVE ONE
            }
        }
//        int size = operationsMenus.size();//sin hijos
        int size = withChildren.size();//con hijos
        List<Menu> operationsMenusAllowed = operationsMenus.stream()
                .filter(c -> operationsAllowed.contains(c.getOperationCode()))
                .collect(Collectors.toList());

        withChildren.addAll(operationsMenusAllowed);
        withChildren.removeAll(childrenToRemove);
        return withChildren;
    }


    private List<Menu> filtrar2(Menu menu, List<String> operationsAllowed) {
        List<Menu> filteredMenus = new ArrayList<>();
        for (Menu menuChild : menu.getChildren()) {
            boolean isParent = menuChild.getChildren().size() > 0;
            if(isParent) {
                var allowedChildrenOfChild = filtrar2(menuChild, operationsAllowed);
                menuChild.setChildren(allowedChildrenOfChild);
                if(!menuChild.getChildren().isEmpty())
                    filteredMenus.add(menuChild);
            }
            else {
                boolean isOperationAllowed = operationsAllowed.contains(menuChild.getOperationCode());
                if(isOperationAllowed)
                    filteredMenus.add(menuChild);
            }
        }
        return filteredMenus;
    }

    public static void main(String ... vargs) {
        Filter f = new Filter();
        System.out.println(f.permissionScopedMenus(0));
    }

}
