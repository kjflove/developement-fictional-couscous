package application.gamescene.factories;

import application.gamescene.components.Block;

import java.util.LinkedList;

/**
 * Class description ...
 * Included in application.gamescene.components
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 24. Mai 2017
 */
public class BlocksFactory {
    public static LinkedList<Block> blocks = new LinkedList<>();

    /*public BlocksFactory(int size, int rows, int spacing, Bootstrap bt){
        int perRow = size / rows;
        double x = spacing;
        // broscience of doom...
        double blockWidth = ((bt.getWidth() - 10) / perRow) - spacing;
        double blockHeight = ((bt.getHeight() * .5) / rows) - spacing;

        for (int i = spacing; i < bt.getHeight() / 2; i += blockHeight + spacing) {
            for (int j = spacing; j < bt.getWidth() - spacing; j += blockWidth + spacing) {
                blocks.add(new Block(new Point2D(j, i), blockWidth, blockHeight));
            }
        }
    }*/

    public void addBlock(Block block) {
        BlocksFactory.blocks.add(block);
    }
}
