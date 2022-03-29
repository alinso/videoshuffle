import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PlayListCreator {

    final String FILE_PATH= System.getenv("VIDEO_PATH");
    final String VIDEO_PATH= FILE_PATH+"/videos";

    private String[] getFileList() {
        System.out.println("videos should be in the path : %VIDEO_PATH%/videos");
        File f = new File(VIDEO_PATH);
        return f.list();
    }

    public void create(){
        String[] fileList =  getFileList();
        shuffle(fileList);
    }

    private void shuffle(String[] filelist){
        Random rnd = new Random();
        StringBuilder str = new StringBuilder();

        str.append("#EXTM3U \n");

        for(int i=0;i<200;i++){
            int randVideoIndex = rnd.nextInt(filelist.length);
            int randStart = rnd.nextInt(1200)+20;
            str.append("#EXTINF:1742,"+VIDEO_PATH+"/"+filelist[randVideoIndex]+" \n"+"#EXTVLCOPT:file-caching=1000 \n#EXTVLCOPT:start-time="+randStart+" \n#EXTVLCOPT:stop-time="+randStart+60+" \n"+VIDEO_PATH+"/"+filelist[randVideoIndex]+"\n");
        }
        try {
            FileWriter writer = new FileWriter(FILE_PATH+"/videos.m3u");
            writer.write(str.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
