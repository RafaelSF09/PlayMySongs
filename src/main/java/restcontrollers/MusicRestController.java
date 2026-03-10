package restcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apis")
public class MusicRestController {

    @PostMapping("music-upload")
    public ResponseEntity<Object> addMusic(String title,
     String artist,
     String style,
     String musicFile){
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
        //pedir à camada Service as músicas que satisfazem
        return ResponseEntity.ok("lista de músicas");
    }

    @GetMapping("get-musics-styles")
    public ResponseEntity<Object> getStyles(){
        //pedir à camada Service as músicas que satisfazem
        return ResponseEntity.ok("lista de estilos músicais");
    }
}
