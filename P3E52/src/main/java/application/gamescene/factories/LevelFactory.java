package application.gamescene.factories;

import application.Bootstrap;
import application.gamescene.components.Ball;
import application.gamescene.components.Block;
import application.gamescene.components.Player;
import javafx.geometry.Point2D;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * Class description ...
 * Included in application.gamescene.factories
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 26. Mai 2017
 */
public class LevelFactory {

    private List<List<Character>> level;
    private String levelName;

    private final int constraints = 9;
    private final int spacing = 15;

    public Ball b;
    public BlocksFactory bf;
    public Player p;

    private Bootstrap bt;

    public LevelFactory(URL levelPath, Bootstrap bt) throws IOException{
        this.level = new LinkedList<>();
        this.bt = bt;
        this.bf = new BlocksFactory();
        FileReader fr = new FileReader(levelPath.getPath());
        BufferedReader br = new BufferedReader(fr);
        String str;
        while((str = br.readLine())!=null){
            List<Character> k = new LinkedList<>();
            for (char c : str.toCharArray()) {
                k.add(c);
            }
            level.add(k);
        }
        createLevel();
    }

    public void createLevel(){
        ForEach.forEach(this.level , (e, r, k) -> {
            ForEach.forEach(e, (ch, c, l) -> {
                switch (ch) {
                    case '1':
                        createBlock(r, c);
                        break;
                    case '8':
                        createPlayer(r, c);
                        break;
                    case '9':
                        createBall(r, c);
                        break;
                }
            });

        });
    }

    private void createBlock(int row, int column){
        this.bf.addBlock(new Block(
                new Point2D(
                        (bt.getWidth()/constraints) * column + spacing/2,
                        (bt.getHeight()/constraints) * row
                ),
                bt.getWidth()/constraints - spacing,
                bt.getHeight()/constraints - spacing)
        );
    }

    private void createPlayer(int row, int column){
        this.p = new Player(
                new Point2D(
                        (bt.getWidth()/constraints) * column,
                        (bt.getHeight()/constraints) * row)
                        , bt);
    }

    private void createBall(int row, int column){
        this.b = new Ball(
                new Point2D(
                        (bt.getWidth()/constraints) * column,
                        (bt.getHeight()/constraints) * row)
                , bt);
    }
}
