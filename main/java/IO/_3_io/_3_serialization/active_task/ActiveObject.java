package IO._3_io._3_serialization.active_task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class ActiveObject implements Serializable {
    private transient TaskThread thread;

    public ActiveObject(Task task) {
        this.thread = new TaskThread(task);
        this.thread.start();
    }

    public void pauseStart() {
        thread.pauseOn();
    }

    public void pauseStop() {
        thread.pauseOff();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        // stop my activity
        thread.pauseOn();
        // serialize internal task
        Task task = thread.getTask();
        out.writeObject(task);
        // restart my activity
        thread.pauseOff();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // deserialize internal task
        Task task = (Task) in.readObject();
        // start new activity
        this.thread = new TaskThread(task);
        this.thread.start();
    }
}

