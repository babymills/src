package IO._2_stream._1_delete_zero;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ZeroFilter {
    public static void filter(InputStream src, OutputStream dst, int buffSize) throws IOException {
        final int ZEROS_STATE = 0;
        final int NUMBERS_STATE = 1;
        byte[] buff = new byte[buffSize];
        int count;
        while ((count = src.read(buff)) != -1) {
            int state = ZEROS_STATE;
            int fromIndex = -1;

            // run loop for what we've read from buffer
            for (int index = 0; index < count; index++) {
                byte elem = buff[index];

                switch (state) {
                    case ZEROS_STATE:
                // if previous condition was zero_state - in this case we just increment it and maybe change the state
                        if (elem == 0) {
                            fromIndex++;
                            state=ZEROS_STATE;
                        } else {
                            fromIndex++;
                            state=NUMBERS_STATE;
                        }
                        break;
                    case NUMBERS_STATE:
                        if (elem == 0) {
                            // numbers ended, so lets write that row of "1"
                            dst.write(buff,fromIndex,index-fromIndex);
                            // and switch to the current index in the loop
                            fromIndex=index;
                            state=ZEROS_STATE;
                        } else {
                            // don't write it, because maybe the next one, that we will read is "1"
                            state=NUMBERS_STATE;
                        }
                        break;
                }
            }
            if (state == ZEROS_STATE) {
                // ...
             //   dst.flush();
            }
            if (state == NUMBERS_STATE) {
                // if buffer ends with 1 then we should write all till his end!!
                dst.write(buff,fromIndex,count-fromIndex);

                dst.flush();
            }
        }
        src.close();
        dst.close();
    }
}
