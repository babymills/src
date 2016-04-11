package IO._2_stream._3_entity_reader_writer;

import IO._2_stream.EntityInput;
import IO._2_stream.EntityOutput;
import IO._2_stream.Person;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Test_person_many {
    public static void main(String[] args) throws IOException {
        // PREPARE
        StringWriter buff = new StringWriter();
        EntityOutput out = new EntityOutputWriter(buff);
        for (int index = 0; index < 10; index++) {
            out.writePerson(new Person("Mike_" + index, index));
        }
        String str = buff.toString();

        EntityInput entityInput = new EntityInputReader(new StringReader(str));
        for (int index = 0; index < 10; index++) {
            // CALL
            Person person = entityInput.readPerson();
            // CHECK
            if (!person.getName().equals("Mike_" + index)) {
                throw new AssertionError();
            }
            if (person.getAge() != index) {
                throw new AssertionError();
            }
        }

        System.out.print("OK");
    }
}
