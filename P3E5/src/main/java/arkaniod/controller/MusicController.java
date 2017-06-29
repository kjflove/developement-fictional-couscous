package arkaniod.controller;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.IOException;
import java.io.InputStream;

/**
 * Class description ...
 * Included in arkaniod.controller
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 17. Mai 2017
 */
public class MusicController {

    private static AudioStream sound;

    public static void runMusic() {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream in = classloader.getResourceAsStream("background.wav");
            sound = new AudioStream(in);
            AudioPlayer.player.start(sound);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stopMusic() {
        AudioPlayer.player.stop(sound);
    }
}
