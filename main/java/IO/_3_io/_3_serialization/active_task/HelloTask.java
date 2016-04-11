package IO._3_io._3_serialization.active_task;

import java.io.*;

/**
 * Serializable WITH writeObject/readObject
 */
public class HelloTask implements Task, Serializable {
    private String msg;
    private int counter;
    private long sleepTime;

    public HelloTask(String msg, int counter, long sleepTime) {
        this.msg = msg;
        this.counter = counter;
        this.sleepTime = sleepTime;
    }

    @Override
    public Task next() {
        System.out.println(msg + ":" + counter);
        counter--;
        return (counter == 0) ? null : this;
    }

    @Override
    public long sleepTime() {
        return sleepTime;
    }

    public String getMsg() {
        return msg;
    }

    public int getCounter() {
        return counter;
    }

    public long getSleepTime() {
        return sleepTime;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(msg);
        out.writeInt(counter);
        out.writeLong(sleepTime);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.msg = in.readUTF();
        this.counter = in.readInt();
        this.sleepTime = in.readLong();
    }
}
