package nus.iss.tfip.mongodbtest.repository;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import nus.iss.tfip.mongodbtest.Constants;

@Repository
public class GameRepository implements Constants {
    @Autowired
    private MongoDatabase db;

    // Use collection
    MongoCollection<Document> games = db.getCollection(COLLECTION_GAME, Document.class);

    // db.game.find({year:3000})
    public Document getGamesFromYear(String year) {
        Document query = new Document("year", year);
        Document results = db.runCommand(query);
        return results;
    }

    // db.game.find({name: {$regex: "back", $options:"i"}})
    public Document getGamesLike(String searchTerm) {
        Document query = new Document("year", "3000");
        Document results = db.runCommand(query);
        return results;
    }

    // db.game.find({name: {$regex: "back", $options:"i"}})
    public List<String> getAllGenres(String searchTerm) {
        Document query = new Document("name", new Document("$regex", searchTerm, "$options", "i"))
        Document genres = db.runCommand(query);
        return null;
    }
}
