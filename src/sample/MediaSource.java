package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MediaSource {

    Image image;
    ImageView iv;
    String musicFile;
    Media sound;
    MediaPlayer mediaPlayer;

    void displayImage() {
        image = new Image("file:freedom.jpg");
        iv = new ImageView();
    }

    void playMusicFile() {
        musicFile = "fanfary.mp3";
        sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ImageView getIv() {
        return iv;
    }

    public void setIv(ImageView iv) {
        this.iv = iv;
    }

    public String getMusicFile() {
        return musicFile;
    }

    public void setMusicFile(String musicFile) {
        this.musicFile = musicFile;
    }

    public Media getSound() {
        return sound;
    }

    public void setSound(Media sound) {
        this.sound = sound;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
}
