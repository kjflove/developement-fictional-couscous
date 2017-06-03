package application.gamescene.factories;

import application.gamescene.GameScene;
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

    private final int constraints = 9;
    private final int spacing = 15;

    public Ball b;
    public BlocksFactory bf;
    public Player p;

    private GameScene gameScene;

    public LevelFactory(URL levelPath, GameScene gameScene) throws IOException{
        this.level = new LinkedList<>();
        this.gameScene = gameScene;
        this.bf = new BlocksFactory(gameScene);

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
        FunctionalForEach.forEach(this.level , (e, r, k) -> {
            FunctionalForEach.forEach(e, (ch, c, l) -> {
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
                        (gameScene.getWidth()/constraints) * column + spacing/2,
                        (gameScene.getHeight()/constraints) * row
                ),
                gameScene.getWidth()/constraints - spacing,
                gameScene.getHeight()/constraints - spacing)
        );
    }

    private void createPlayer(int row, int column){
        this.p = new Player(
                new Point2D(
                        (gameScene.getWidth()/constraints) * column,
                        (gameScene.getHeight()/constraints) * row)
                        , gameScene);
    }

    private void createBall(int row, int column){
        this.b = new Ball(
                new Point2D(
                        (gameScene.getWidth()/constraints) * column,
                        (gameScene.getHeight()/constraints) * row)
                , gameScene);
    }
}
