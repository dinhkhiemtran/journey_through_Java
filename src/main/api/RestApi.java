package main.api;

import org.json.JSONObject;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RestApi {

    Map<String, User> data = new HashMap<>();

    public RestApi() {
    }

    public RestApi(User... users) {
        Stream.of(users).forEach(user -> this.data.put(user.name(), user));
    }

    public String post(String url, JSONObject payload) {
        switch (url) {
            case "/add":
                return addUser(payload);
            case "/iou":
                return iou(payload);
            default:
                return "";
        }
    }

    private User updateUser(User lender, String borrower, double amount) {
        String name = lender.name();
        List<Iou> owes = lender.owes().stream().filter(iou -> !iou.name.equals(borrower)).collect(toList());
        List<Iou> owedBy = lender.owedBy().stream().filter(iou -> !iou.name.equals(borrower)).collect(toList());
        double newIou =
                lender.owedBy().stream().filter(iou -> iou.name.equals(borrower)).mapToDouble(iou -> iou.amount).sum()
                        - lender.owes().stream().filter(iou -> iou.name.equals(borrower)).mapToDouble(iou -> iou.amount).sum()
                        + amount;
        if (newIou > 0) {
            owedBy.add(new Iou(borrower, newIou));
        } else if (newIou < 0) {
            owes.add(new Iou(borrower, -1 * newIou));
        }
        owedBy.sort(Comparator.comparing(i -> i.name));
        owes.sort(Comparator.comparing(i -> i.name));
        User.Builder user = User.builder();
        user.setName(name);
        owes.forEach(iou -> user.owes(iou.name, iou.amount));
        owedBy.forEach(iou -> user.owedBy(iou.name, iou.amount));
        return user.build();
    }

    private String iou(JSONObject payload) {
        String lenderName = payload.getString("lender");
        String borrowerName = payload.getString("borrower");
        User updateLender = updateUser(this.data.get(lenderName), borrowerName, payload.getDouble("amount"));
        User updateBorrower = updateUser(this.data.get(borrowerName), lenderName, -1 * payload.getDouble("amount"));
        this.data.put(borrowerName, updateBorrower);
        this.data.put(lenderName, updateLender);
        return getUsers(Arrays.asList(lenderName, borrowerName));
    }

    private String addUser(JSONObject payload) {
        String name = payload.getString("user");
        User user = new User.Builder().setName(name).build();
        this.data.put(name, user);
        return RestApiUtils.toJson(user).toString();
    }

    public String get(String url, JSONObject payload) {
        switch (url) {
            case "/users":
                return getUsers(payload);
            default:
                return "";
        }
    }

    public String get(String url) {
        switch (url) {
            case "/users":
                return getUsers();
            default:
                return "";
        }
    }

    private String getUsers() {
        List<JSONObject> users =
                this.data.values().stream().sorted().map(RestApiUtils::toJson).collect(toList());
        return new JSONObject().put("users", users).toString();
    }

    private String getUsers(JSONObject payload) {
        List<String> names = payload.getJSONArray("users").toList().stream().map(o -> (String) o).collect(Collectors.toList());
        return getUsers(names);
    }

    private String getUsers(List<String> names) {
        List<JSONObject> users = names.stream().sorted().map(this.data::get).map(RestApiUtils::toJson).collect(toList());
        return new JSONObject().put("users", users).toString();
    }
}
