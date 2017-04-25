package menus.model;

import lombok.Data;

import java.util.List;

/**
 * Created by Local_admin on 4/22/2017.
 */
@Data
public class Permission {
    Integer id;
    String name;
    List<String> operationCodes;
}