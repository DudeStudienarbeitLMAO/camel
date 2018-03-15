package info.sperber;

import org.apache.camel.main.Main;

import java.io.PrintWriter;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        PrintWriter writer = new PrintWriter(System.out);
        Chatroom room = new Chatroom(writer);
    }

}

