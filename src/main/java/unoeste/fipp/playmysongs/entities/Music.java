package unoeste.fipp.playmysongs.entities;

public class Music {
    private String title;
    private String artist;
    private String style;
    private String musicFile;

    public Music(String title, String artist, String style) {
        this.title = title;
        this.artist = artist;
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getMusicFile() {
        return musicFile;
    }

    public void setMusicFile(String musicFile) {
        this.musicFile = musicFile;
    }
}
