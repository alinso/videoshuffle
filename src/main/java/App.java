import java.io.IOException;

public class App {

    public static void main(String[] args ) throws IOException {
        PlayListCreator  playListCreator = new PlayListCreator();
        playListCreator.create();
        Runtime.getRuntime().exec("vlc "+playListCreator.FILE_PATH+"/videos.m3u --fullscreen");
    }
}
