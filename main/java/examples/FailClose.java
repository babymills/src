package examples;

public class FailClose implements AutoCloseable {
    public FailClose(String name) {
        this.name = name;
        System.out.println("new:"+ name);
    }

    private String name;
    @Override
    public void close() throws Exception {
        System.out.println("close:"+ name);
        throw new Error();
    }
}
