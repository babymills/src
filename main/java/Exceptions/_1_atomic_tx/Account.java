package Exceptions._1_atomic_tx;

public interface Account {
    public void change(int delta) throws TryAgainException, BlockAccountException;
}
