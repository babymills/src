package IO._2_stream._2_entity_is_os;

import IO._2_stream.EntityOutput;
import IO._2_stream.Person;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Test_person_O {
    public static void main(String[] args) throws IOException {
        // PREPARE
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        EntityOutput out = new EntityOutputStream(buff);
        out.writePerson(new Person("Mike", 45));
        byte[] rawBytes = buff.toByteArray();

        // CALL
        Person person = new EntityInputStream(new ByteArrayInputStream(rawBytes)).readPerson();

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
