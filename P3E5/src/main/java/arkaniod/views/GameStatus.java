package arkaniod.views;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 13. Mai 2017
 */
public enum GameStatus {
    GAME_WON(0x00),
    GAME_LOST(0x02),
    GAME_RUNNING(0x04),
    GAME_PAUSED(0x08),
    GAME_INACTIVE(0x10);

    private final int status;

    GameStatus(int status) {
        this.status = status;
    }
}
