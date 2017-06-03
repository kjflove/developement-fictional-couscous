package application.gamescene.factories;

import application.GameType;
import application.gamescene.GameScene;
import application.gamescene.components.Block;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Class description ...
 * Included in application.gamescene.components
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 24. Mai 2017
 */
public class BlocksFactory {
    public LinkedBlockingQueue<Block> blocks = new LinkedBlockingQueue<>();
    private GameScene gs;

    public BlocksFactory(GameScene gs){
        this.gs = gs;
    }

    public void addBlock(Block block) {
        this.blocks.add(block);
    }

    public void markAsDeleted(Block removable){
        removable.deletingBlock();
        this.gs.getPane().getChildren().remove(removable);
        if(this.blocks.isEmpty()) gs.getStatusProperty().set(GameType.WIN);
    }
}
