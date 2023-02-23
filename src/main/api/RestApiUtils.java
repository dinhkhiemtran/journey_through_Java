package main.api;

import org.json.JSONObject;

public class RestApiUtils {

    public static JSONObject toJson(User user) {
        //add name
        JSONObject json = new JSONObject();
        json.put("name", user.name());
        //add owes list
        JSONObject owes = new JSONObject();
        user.owes().forEach(iou -> owes.put(iou.name, iou.amount));
        json.put("owes", owes);
        //add oweBy list
        JSONObject owedBy = new JSONObject();
        user.owedBy().forEach(iou -> owedBy.put(iou.name, iou.amount));
        json.put("owedBy", owedBy);
        //add balance
        double balance = user.owedBy().stream().mapToDouble(iou -> iou.amount).sum()
                - user.owes().stream().mapToDouble(iou -> iou.amount).sum();
        json.put("balance", balance);
        return json;
    }
}
