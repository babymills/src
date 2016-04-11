package IO._3_io._3_serialization.active_task;

/**
 * Idiom:
 * <pre>
 * while (task != null) {
 *     Thread.sleep(task.sleepTime());
 *     task = task.next();
 * }
 * </pre>
 */
public interface Task {

    public Task next();

    public long sleepTime();
}
