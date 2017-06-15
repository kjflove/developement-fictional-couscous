package application;

/**
 * Class description ...
 * Included in application
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 14. Jun 2017
 */
public enum TrafficLight {
    GREEN {
        TrafficLight eval(StateMachine sm) {
            try {
                Thread.sleep(standardTime);
            } catch (InterruptedException ignore) {
            }

            TrafficLight current = sm.getCurrentStatus();
            if (current == GREEN) return YELLOW;
            else return current;
        }
    },
    YELLOW {
        TrafficLight eval(StateMachine sm) {
            try {
                Thread.sleep(yellowTime);
            } catch (InterruptedException ignore) {
            }

            TrafficLight current = sm.getCurrentStatus();
            if (current == YELLOW) return RED;
            else return current;
        }
    },
    YELLOW_RED {
        TrafficLight eval(StateMachine sm) {
            try {
                Thread.sleep(redYellowTime);
            } catch (InterruptedException ignore) {
            }

            TrafficLight current = sm.getCurrentStatus();
            if (current == YELLOW_RED) return GREEN;
            else return current;
        }
    },
    RED {
        TrafficLight eval(StateMachine sm) {
            try {
                Thread.sleep(standardTime);
            } catch (InterruptedException ignore) {
            }

            TrafficLight current = sm.getCurrentStatus();
            if (current == RED) return YELLOW_RED;
            else return current;
        }
    },
    BLINKING {
        TrafficLight eval(StateMachine sm) {
            return BLINKING;
        }
    };

    public static final int standardTime = 5000;
    public static final int redYellowTime = 2000;
    public static final int yellowTime = 3000;

    abstract TrafficLight eval(StateMachine sm);
}