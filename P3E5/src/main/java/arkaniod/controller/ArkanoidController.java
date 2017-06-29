package arkaniod.controller;

import arkaniod.models.GameStore;
import arkaniod.views.ApplicationView;

/**
 * Class description ...
 * Included in arkaniod.controller
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 20. Mai 2017
 */
public class ArkanoidController {

    private ApplicationView arkanoid;
    private GameStore gameStore;

    public ArkanoidController() {
        arkanoid = new ApplicationView();
        gameStore = new GameStore();
    }

}
