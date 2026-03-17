package unoeste.fipp.playmysongs.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unoeste.fipp.playmysongs.entities.Music;
import unoeste.fipp.playmysongs.services.MusicService;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("apis")
public class MusicRestController {

    @Autowired
    private MusicService musicService;

    @PostMapping("music-upload")
    public ResponseEntity<Object> addMusic(String title, String artist,
                                            String style, String musicFile){
        //receber o arquivo de música
            //criar o novo nome da música
            //gravar o arquivo na pasta MUSICS
        //Criar um obj do tipo entities.Music
        //Enviar a camada Service para fazer a persistência
        //Retonar sucesso ou erro
        return ResponseEntity.ok("");
    }

    @GetMapping("find-musics")
    public ResponseEntity<Object> findMusic(String keyword){
        List<Music> musicList = musicService.findMusicByKeyword(keyword);
        return ResponseEntity.ok(musicList);
    }

    @GetMapping("get-musics-styles")
    public ResponseEntity<Object> getStyles(){
        //pedir à camada Service as músicas que satisfazem
        return ResponseEntity.ok("lista de estilos músicais");
    }
}
