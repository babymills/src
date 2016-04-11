package IO._2_stream._2_entity_is_os;

import IO._2_stream.EntityInput;
import IO._2_stream.EntityOutput;
import IO._2_stream.Person;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Test_person_many {
    public static void main(String[] args) throws IOException {
        // PREPARE
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        EntityOutput out = new EntityOutputStream(buff);
        for (int index = 0; index < 10; index++) {
            out.writePerson(new Person("Mike_" + index, index));
        }
        byte[] rawBytes = buff.toByteArray();

        EntityInput entityInput = new EntityInputStream(new ByteArrayInputStream(rawBytes));
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
