package IO._2_stream._3_entity_reader_writer;

import IO._2_stream.EntityInput;
import IO._2_stream.Person;
import IO._2_stream.Point;

import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.lang.Character.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityInputReader implements EntityInput {
    private final Reader src;
    public EntityInputReader(Reader src) {
        this.src = src;
    }

    public Person readPerson() throws IOException {
        int readInt = 0;
        int carriageReturnCount=0;
        String personInformation = "";
        src.reset();
        while (carriageReturnCount!=4){
            if ((char)(readInt=src.read())=='\n') carriageReturnCount++;
            personInformation+=String.valueOf((char)readInt);
        }
        src.mark(readInt);

        // any character sequence of any length
        final Pattern namePattern = Pattern.compile("<name>(.*)</name>");
        final Matcher nameMatcher = namePattern.matcher(personInformation);
        nameMatcher.find();
        String name = nameMatcher.group(1);

        // any digit of length one or more (also might add ? after +)
        final Pattern agePattern = Pattern.compile("<age>(\\d+)</age>");
        final Matcher ageMatcher = agePattern.matcher(personInformation);
        ageMatcher.find();
        int age = Integer.parseInt(ageMatcher.group(1));

        return new Person(name,age);
    }

    @Override
    public Point readPoint() throws IOException {
        int readInt;
        StringBuilder stringBuilder=new StringBuilder();
        src.reset();
        while ((char)(readInt=src.read())!='\n'){
            stringBuilder.append((char) readInt);
        }
        src.mark(readInt);
        String str = stringBuilder.toString();
        str = str.replaceAll("[^0-9]+", " ");
        String[] resultedStringValues = str.trim().split(" ");

//        List<String> strings = Arrays.asList(str.trim().split(" "));
//        int x = Integer.parseInt(strings.get(0));
//        int y = Integer.parseInt(strings.get(1));

        int x = Integer.parseInt(resultedStringValues[0]);
        int y = Integer.parseInt(resultedStringValues[1]);
        return new Point(x,y);
    }
}
