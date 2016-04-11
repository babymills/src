package IO._3_io._3_serialization.active_task;

public class TaskThread extends Thread {
    private Task task;
    private volatile boolean pause;

    public TaskThread(Task task) {
        this.task = task;
    }

    public void pauseOn() {
        this.pause = true;
        this.interrupt();
    }

    public void pauseOff() {
        this.pause = false;
    }

    @Override
    public void run() {
        while (task != null) {
            try {
                Thread.sleep(task.sleepTime()); //wait for next step
            } catch (InterruptedException e) {
                if (pause) {
                    while (pause); // wait for 'pauseOff'
                } else {
                    return;
                }
            }
            task = task.next(); // make next step
        }
    }

    public Task getTask() {
        return task;
    }
}
