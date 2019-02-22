package io.github.jorgeviana.openchatlondon;

public class App {

    private static final int DEFAULT_PORT = 4321;

    public static void main(String[] args) {
        if (hasPort(args)) {
            new OpenChat(port(args)).start();
        } else {
            new OpenChat(DEFAULT_PORT).start();
        }
    }

    private static boolean hasPort(String[] args) {
        try {
            Integer.parseInt(args[0]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static int port(String[] args) {
        return Integer.parseInt(args[0]);
    }
}
