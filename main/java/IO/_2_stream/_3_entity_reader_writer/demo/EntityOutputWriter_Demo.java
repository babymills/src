package IO._2_stream._3_entity_reader_writer.demo;

import IO._2_stream.EntityOutput;
import IO._2_stream.Person;
import IO._2_stream.Point;
import IO._2_stream._3_entity_reader_writer.EntityInputReader;
import IO._2_stream._3_entity_reader_writer.EntityOutputWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;

public class EntityOutputWriter_Demo {
    public static void main(String[] args) throws IOException {
/*        EntityOutput entityOutput = new EntityOutputWriter(new OutputStreamWriter(System.out));
        entityOutput.writePoint(new Point(4, 8));
        entityOutput.writePerson(new Person("Anna", 25));
        entityOutput.writePoint(new Point(0, 0));
        entityOutput.writePerson(new Person("Mike", 45));*/

        //////////////
        StringWriter buff = new StringWriter();
        EntityOutput out = new EntityOutputWriter(buff);
        out.writePoint(new Point(14, 15));
        String str = buff.toString();

        // CALL
        Point point = new EntityInputReader(new StringReader(str)).readPoint();
        System.out.println(point);
    }
}
