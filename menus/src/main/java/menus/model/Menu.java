package menus.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Local_admin on 4/22/2017.
 */
@Data
public class Menu {
    Integer id;
    String operationCode;
    String name;
    Menu parent;
    List<Menu> children = new ArrayList<>();

    @Override
    public String toString(){
        return name + (children.size() > 0 ? "{" + children.toString() + "}" : "");
    }
}