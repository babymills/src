package Exceptions._1_atomic_tx;

public class AccountManagerImpl implements AccountManager {
    public boolean transfer(Account[] accounts, int[] money) {
        try {
            for (int k = 0; k < accounts.length; k++) {
                while (true) {
                    try {
                        accounts[k].change(money[k]);
                        break;
                    } catch (TryAgainException e) {
                        // NOP
                    }
                }
            }
        } catch (BlockAccountException e) {
            return false;
        }
        return true;
    }
}
