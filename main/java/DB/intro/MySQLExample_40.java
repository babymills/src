package DB.intro;

import javax.sound.sampled.spi.AudioFileReader;
import java.nio.charset.spi.CharsetProvider;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.ServiceLoader;

public class MySQLExample_40 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ServiceLoader<Driver> drivers
                = ServiceLoader.load(Driver.class);
        for (Driver driver : drivers) {
            System.out.println(driver);
        }

        System.out.println();

        ServiceLoader<CharsetProvider> charsetProviders
                = ServiceLoader.load(CharsetProvider.class);
        for (CharsetProvider provider : charsetProviders) {
            System.out.println(provider);
        }

        System.out.println();

        ServiceLoader<AudioFileReader> audioReaders
                = ServiceLoader.load(AudioFileReader.class);
        for (AudioFileReader reader : audioReaders) {
            System.out.println(reader);
        }
    }
}
