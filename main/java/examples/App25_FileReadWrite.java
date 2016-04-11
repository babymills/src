package examples;

import static java.nio.charset.StandardCharsets.US_ASCII;
//import sun.io.CharToByteCp1251;

import java.io.*;
import java.util.Scanner;

public class App25_FileReadWrite {
    public static void main(String[] args) throws IOException {
        byte[] bytesToWrite = "hello!".getBytes(US_ASCII);
        byte[] bytesReaded = new byte[10];
        String fileName = "d:\\test.txt";
        try {
            // Создать выходной поток
            FileOutputStream outFile = new FileOutputStream(fileName);
            System.out.println("Файл открыт для записи");
            // Записать массив
            outFile.write(bytesToWrite);
            System.out.println("Записано: " + bytesToWrite.length + " байт");
            // По окончании использования должен быть закрыт
            outFile.close();
            System.out.println("Выходной поток закрыт");
            // Создать входной поток
            FileInputStream inFile = new FileInputStream(fileName);
            System.out.println("Файл открыт для чтения");
            // Узнать, сколько байт готово к считыванию
            int bytesAvailable = inFile.available();
            System.out.println("Готово к считыванию: " + bytesAvailable + " байт");
            // Считать в массив
            int count = inFile.read(bytesReaded,0,bytesAvailable);
            System.out.println("Считано: " + count + " байт");
            inFile.close();
            System.out.println("Входной поток закрыт");
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно произвести запись в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.toString());
        }
         FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        while (bis.read()!=-1){
        System.out.println(bis.read());

        FileReader fr = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fr);
        while (bufferedReader.readLine().isEmpty()){
            System.out.println(bufferedReader.readLine());
        }
    }
    }
}
