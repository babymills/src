package IO._2_stream._3_entity_reader_writer;

import IO._2_stream.EntityOutput;
import IO._2_stream.Person;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XXX {
    public static void main(String[] args) throws IOException {
/*        Integer i70 = new Integer(100);
        Integer i71 = new Integer(100);
        System.out.println(i70.intValue() == i71.intValue());
        System.out.println(i70 == i71);

        Integer ii70 = 100;
        Integer ii71 = 100;
        System.out.println(ii70.intValue() == ii71.intValue());
        System.out.println(ii70 == ii71);*/

        StringWriter buff = new StringWriter();
        EntityOutput out = new EntityOutputWriter(buff);
        out.writePerson(new Person("Mike", 45));
        String str = buff.toString();


/*        String regex = "(<person>\n)(.+)(</person>\n)";
        Pattern p = Pattern.compile(regex);
        System.out.println(str.replaceAll(regex,"ABC"));*/
        String s = str.replaceAll("\n", "");
        final Pattern pattern = Pattern.compile("<name>(.+?)</name>");
        final Matcher matcher = pattern.matcher(s);
        matcher.find();
        System.out.println(matcher.group(1));

        final Pattern namePattern = Pattern.compile("<name>(.+?)</name>");
        final Matcher nameMatcher = namePattern.matcher(s);
        nameMatcher.find();
        String name = nameMatcher.group(1);

        final Pattern agePattern = Pattern.compile("<age>(.+?)</age>");
        final Matcher ageMatcher = agePattern.matcher(s);
        ageMatcher.find();
        int age = Integer.parseInt(ageMatcher.group(1));
        // CALL
    //    Person person = new EntityInputReader(new StringReader(str)).readPerson();

    }
}
