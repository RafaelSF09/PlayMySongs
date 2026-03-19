package unoeste.fipp.playmysongs.repositories;

import org.springframework.stereotype.Repository;
import unoeste.fipp.playmysongs.entities.Music;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepository {
    private List<Music> music = new ArrayList<>();

    public List<Music> getMusic() {
        return music;
    }
}
