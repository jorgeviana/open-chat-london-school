package integrationtest;

import io.github.jorgeviana.openchatlondon.OpenChat;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private static final int PORT = availablePort();
    public static final String BASE_URL = "http://localhost:" + PORT;

    private static final OpenChat openChat = new OpenChat(PORT);

    private static int availablePort() {
        try ( ServerSocket socket = new ServerSocket(0) ) {
            return socket.getLocalPort();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void start() {
        openChat.start();
        openChat.awaitInitialization();
    }

    public static void stop() {
        openChat.stop();
    }

}
