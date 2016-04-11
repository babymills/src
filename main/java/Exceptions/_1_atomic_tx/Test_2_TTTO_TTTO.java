package Exceptions._1_atomic_tx;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Test_2_TTTO_TTTO {

    public static void main(String[] args) {
        // PREPARE
        final List<String> actualHistory = new ArrayList<>();
        Account[] accounts = new Account[]{new Account() {
            private int count = 0;

            public void change(int delta) throws TryAgainException, BlockAccountException {
                count++;
                actualHistory.add("0:" + delta);
                if (count <= 3) {
                    throw new TryAgainException();
                }
            }
        }, new Account() {
            int count = 0;

            public void change(int delta) throws TryAgainException, BlockAccountException {
                actualHistory.add("1:" + delta);
                if (count++ < 3) {
                    throw new TryAgainException();
                }
            }
        }};

        // CALL
        boolean transferStatus = new AccountManagerImpl().transfer(accounts, new int[]{10, 20});

        // CHECK
        if (transferStatus != true) {
            throw new AssertionError();
        }
        List<String> expectedHistory = asList(
                "0:10", "0:10", "0:10", "0:10",
                "1:20", "1:20", "1:20", "1:20"
        );
        if (!actualHistory.equals(expectedHistory)) {
            throw new AssertionError("expectedHistory:" + expectedHistory + " but actualHistory:" + actualHistory);
        }

        System.out.print("OK");
    }
}
