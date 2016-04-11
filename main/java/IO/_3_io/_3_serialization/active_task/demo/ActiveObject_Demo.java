package IO._3_io._3_serialization.active_task.demo;

import IO._3_io._3_serialization.active_task.ActiveObject;
import IO._3_io._3_serialization.active_task.HelloTask;

import java.io.*;

public class ActiveObject_Demo {
    public static void main(String[] args) throws Exception {

        ActiveObject oldActiveTask = new ActiveObject(new HelloTask("Hello", 20, 500));
        Thread.sleep(5000);

        byte[] rawData = writeActiveTask(oldActiveTask);
        System.out.println("rawData.length = " + rawData.length);
        System.out.println(new String(rawData));
        ActiveObject newActiveTask_0 = readActiveTask(rawData);
        ActiveObject newActiveTask_1 = readActiveTask(rawData);
        ActiveObject newActiveTask_2 = readActiveTask(rawData);
    }

    private static byte[] writeActiveTask(ActiveObject activeTask) throws IOException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        try (ObjectOutput out = new ObjectOutputStream(buff)) {
            out.writeObject(activeTask);
            out.flush();
            return buff.toByteArray();
        }
    }

    private static ActiveObject readActiveTask(byte[] rawData) throws IOException, ClassNotFoundException {
        try (ObjectInputStream src = new ObjectInputStream(new ByteArrayInputStream(rawData))) {
            return (ActiveObject) src.readObject();
        }
    }
}
