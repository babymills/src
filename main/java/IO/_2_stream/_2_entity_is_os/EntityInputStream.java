package IO._2_stream._2_entity_is_os;

import IO._2_stream.EntityInput;
import IO._2_stream.Person;
import IO._2_stream.Point;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EntityInputStream implements EntityInput {
    private final DataInput src;

    public EntityInputStream(InputStream src) {
        this.src = new DataInputStream(src);
    }

    @Override
    public Person readPerson() throws IOException {

        String name=null;
        int age = src.readInt();

        if(src.readBoolean()){
            name=src.readUTF();
        }
        return new Person(name,age);
    }

    @Override
    public Point readPoint() throws IOException {
        byte tmp = this.src.readByte();
    return new Point((tmp & 0b11110000) >> 4, tmp & 0b00001111);
    }
}