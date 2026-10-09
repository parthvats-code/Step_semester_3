interface Playable {
    void play();
}
class AudioPlayer implements Playable {
    public void play() {
        System.out.println("Playing audio");
    }
}
class VideoPlayer implements Playable {
    public void play() {
        System.out.println("Playing video");
    }
}
class PresentationPlayer implements Playable {
    public void play() {
        System.out.println("Playing presentation");
    }
}
public class UniversalMediaLauncher {
    static void launchAll(Playable[] items) {
        for(Playable p:items)p.play();
    }
    public static void main(String[] args) {
        launchAll(new Playable[] {
            new AudioPlayer(), new VideoPlayer(), new PresentationPlayer()
        });
    }
}
