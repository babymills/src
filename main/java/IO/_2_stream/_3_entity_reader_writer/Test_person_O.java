package IO._2_stream._3_entity_reader_writer;

import IO._2_stream.EntityOutput;
import IO._2_stream.Person;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Test_person_O {
    public static void main(String[] args) throws IOException {
        // PREPARE
        StringWriter buff = new StringWriter();
        EntityOutput out = new EntityOutputWriter(buff);
        out.writePerson(new Person("Mike", 45));
        String str = buff.toString();

        // CALL
        Person person = new EntityInputReader(new StringReader(str)).readPerson();

        // CHECK
        if (!person.getName().equals("Mike")) {
            throw new AssertionError();
        }
        if (person.getAge() != 45) {
            throw new AssertionError();
        }
        
        System.out.print("OK");
    }
}
