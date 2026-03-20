package unoeste.fipp.playmysongs.services;

import com.google.gson.Gson;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.stereotype.Service;
import unoeste.fipp.playmysongs.entities.Music;
import unoeste.fipp.playmysongs.entities.Style;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicService {

    private final String connectionString = "mongodb://localhost:27017";

    public Music saveMusic(Music music) {
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("my_musics");

        MongoCollection<Document> collection = mongoDatabase.getCollection("musics");

        try {
            Document doc = Document.parse(new Gson().toJson(music));

            collection.insertOne(doc);

            return music;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar música: " + e.getMessage());
        } finally {
            mongoClient.close();
        }
    }

    public List<Music> findMusicByKeyword(String keyword){
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("my_musics");

        MongoCollection<Document> collection = mongoDatabase.getCollection("musics");
        MongoCursor<Document> cursor = collection.find().iterator();

        List<Music> musicList = new ArrayList<>();
        while(cursor.hasNext()){
            Music music = new Gson().fromJson(cursor.next().toJson(),Music.class);
            if(keyword == null || music.getMusicFile().contains(keyword.toLowerCase())){
                musicList.add(music);
            }
        }
        mongoClient.close();
        return musicList;
    }
    public List<Style> getStyles(){

        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("my_musics");

        MongoCollection<Document> collection = mongoDatabase.getCollection("styles");
        MongoCursor<Document> cursor = collection.find().iterator();

        List<Style> styleList = new ArrayList<>();
        while(cursor.hasNext()){
            Style style = new Gson().fromJson(cursor.next().toJson(),Style.class);
            styleList.add(style);
        }
        mongoClient.close();
        return styleList;
    }
}
