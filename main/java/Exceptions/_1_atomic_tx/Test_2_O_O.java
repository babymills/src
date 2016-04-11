package Exceptions._1_atomic_tx;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Test_2_O_O {

    public static void main(String[] args) {
        // PREPARE
        final List<String> history = new ArrayList<>();
        Account[] accounts = new Account[]{new Account() {
            public void change(int delta) throws TryAgainException, BlockAccountException {
                history.add("0:" + delta);
            }
        }, new Account() {
            public void change(int delta) throws TryAgainException, BlockAccountException {
                history.add("1:" + delta);
            }
        }};

        // CALL
        boolean transferStatus = new AccountManagerImpl().transfer(accounts, new int[]{10, 20});

        // CHECK
        if (transferStatus != true) {
            throw new AssertionError();
        }
        if (!history.equals(asList("0:10", "1:20"))) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
