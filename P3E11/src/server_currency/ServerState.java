package server_currency;

/**
 * Class description ...
 * Included in client_currency
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 29. Jun 2017
 */
public enum ServerState {

    STARTING {
        public void log(){
            System.out.println("Server is currently starting!");
            System.out.println("Type `shutdown` for stopping the server from accepting new connections!");
        }
    },
    READY {
        public void log(){
            System.out.println("Server is ready for incoming connections!");
        }
    },
    CLIENT_CONNECTED {
        public void log(){
            System.out.println("Serving a new client with information.");
        }
    },
    SHUTDOWN {
        public void log(){
            System.out.println("Server is shutting down soonish!");
        }
    },
    CLEAN {
        public void log() {}
    };

    public abstract void log();
}
