package test.t2.q4;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String[] infos = new String[]{"id pw", "nok cha"};
        String[] actions = new String[]{
                "ADD 30", "LOGIN id cha", "LOGIN nok pw", "LOGIN id pw", "LOGIN id pw",
                "LOGIN nok cha", "ADD 30", "ORDER", "ORDER", "ADD 40", "ADD 50"
        };

        Shop shop = new Shop(infos);
        List<Boolean> returns = new ArrayList<>();

        for (String action : actions) {
            String[] inputs = action.split(" ");
            switch (inputs[0]) {
                case "LOGIN":
                    returns.add(shop.login(inputs[1], inputs[2]));
                    break;

                case "ADD":
                    returns.add(shop.add(inputs[1]));
                    break;

                case "ORDER":
                    returns.add(shop.order());
                    break;
            }
        }

        System.out.println(Arrays.toString(returns.toArray()));
    }
}

class Shop {
    private Map<String, String> users;
    private Set<String> cart;
    private boolean loggedIn;

    public Shop(String[] infos) {
        users = new HashMap<>();
        cart = new HashSet<>();

        Arrays.stream(infos)
                .forEach(info -> {
                    String[] infoArr = info.split(" ");
                    users.put(infoArr[0], infoArr[1]);
                });
    }

    public boolean login(String id, String pw) {
        if (loggedIn) {
            return false;
        }

        if (users.containsKey(id) && users.get(id).equals(pw)) {
            loggedIn = true;
            return true;
        }

        return false;
    }

    public boolean add(String item) {
        if (!loggedIn) {
            return false;
        }

        cart.add(item);
        return true;
    }

    public boolean order() {
        if (!loggedIn || cart.isEmpty()) {
            return false;
        }

        cart.clear();
        return true;
    }
}