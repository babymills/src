package Exceptions._1_atomic_tx;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Test_1_TB {

    public static void main(String[] args) {
        // PREPARE
        final List<String> history = new ArrayList<>();
        Account[] accounts = new Account[]{new Account() {
            int count = 0;
            public void change(int delta) throws TryAgainException, BlockAccountException {
                history.add("" + delta);
                if (count++ < 1) {
                    throw new TryAgainException();
                }
                throw new BlockAccountException();
            }
        }};

        // CALL
        boolean transferStatus = new AccountManagerImpl().transfer(accounts, new int[]{1});

        // CHECK
        if (transferStatus != false) {
            throw new AssertionError();
        }
        if (!history.equals(asList("1", "1"))) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
