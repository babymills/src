package IO._2_stream;

import java.io.IOException;

public interface EntityOutput {

    public void writePerson(Person person) throws IOException;

    public void writePoint(Point point) throws IOException;
}
