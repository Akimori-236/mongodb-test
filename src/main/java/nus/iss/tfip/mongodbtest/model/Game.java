package nus.iss.tfip.mongodbtest.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "game")
public class Game {
    private String _id;
    private String gid;
    private String name;
    private Integer year;
    private Integer ranking;
    private Integer users_rated;
    private String url;
    private String image;
}
