package examples;


import com.sun.xml.internal.messaging.saaj.packaging.mime.util.UUDecoderStream;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;

import static java.nio.charset.StandardCharsets.*;

        class App29_GooglePageToFile {
            public static void main(String[]args) throws IOException {
/*
            URL google = new URL("http://www.google.com/");
            URLConnection yc = google.openConnection();
            */
/*
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            BufferedInputStream bais = new BufferedInputStream(google.openStream());
            String inputLine;
            while ((inputLine = in.readLine()) != null)  {
                System.out.println(inputLine);
            }
            in.close();
            *//*

            InputStream in = new BufferedInputStream(new URL("http://vk.com/").openStream());
            OutputStream out = new BufferedOutputStream(new FileOutputStream("D:google.txt"));
            while (in.read()!=-1){
               out.write(in.read());
               System.out.println(in.read());
            }
            in.close();
            out.flush();
            out.close();
*/

                BufferedReader inputReader = new BufferedReader(new InputStreamReader(new URL("http://google.com/").openStream()));
                BufferedWriter outputWriter = new BufferedWriter(new FileWriter("D:google.doc"));
                String input;
                while ((input = inputReader.readLine())!=null){
                    outputWriter.write(input);
                    System.out.println(input);
                }
                outputWriter.flush();
                inputReader.close();
                outputWriter.close();
    }
}
