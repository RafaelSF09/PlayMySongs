package unoeste.fipp.playmysongs.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import unoeste.fipp.playmysongs.entities.Erro;
import unoeste.fipp.playmysongs.entities.Music;
import unoeste.fipp.playmysongs.entities.Style;
import unoeste.fipp.playmysongs.repositories.MusicRepository;
import unoeste.fipp.playmysongs.services.MusicService;

import java.io.File;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("apis")
public class MusicRestController {

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private MusicService musicService;

    @PostMapping("music-upload")
    public ResponseEntity<Object> addMusic(String title, String artist,
                                            String style, MultipartFile musicFile){
        final String UPLOAD_FOLDER = "src/main/resources/static/musics";
        if (title==null||title.isEmpty()){
            return ResponseEntity.badRequest().body(new Erro("Informações incompletas",""));
        }else{
            Music musicaNova = new Music(title,artist,style);
            if(musicFile!=null){
                StringBuilder fileName = new StringBuilder(title.toLowerCase().replaceAll("\\s+", ""));
                fileName.append("_").append(style.toLowerCase().replaceAll("\\s+", "")).append("_");
                fileName.append(artist.toLowerCase().replaceAll("\\s+", ""));
                fileName.append(".mp3");
                try{
                    File uploadFolder = new File(UPLOAD_FOLDER);
                    if(!uploadFolder.exists()){
                        uploadFolder.mkdir();
                    }
                    musicFile.transferTo(new File(uploadFolder.getAbsolutePath()+ "\\" + fileName));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                musicaNova.setMusicFile(fileName.toString());
            }
            musicRepository.getMusic().add(musicaNova);
            return ResponseEntity.ok().body(musicaNova);
        }
    }

    @GetMapping("find-musics")
    public ResponseEntity<Object> findMusic(String keyword){
        List<Music> musicList = musicService.findMusicByKeyword(keyword);
        return ResponseEntity.ok(musicList);
    }

    @GetMapping("get-music-styles")
    public ResponseEntity<Object> getStyles(){
        List<Style> styleList = musicService.getStyles();
        return ResponseEntity.ok(styleList);
    }
}
