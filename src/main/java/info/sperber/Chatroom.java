package info.sperber;

import org.apache.camel.main.Main;

import java.io.PrintWriter;

/**
 * Created by fabian on 3/15/18.
 */
public class Chatroom {

    private PrintWriter writer;

    public Chatroom(PrintWriter writer) throws Exception {
        this.writer = writer;

        Main main = new Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new MyRouteBuilder(this.writer));
        main.run();
    }

    public void sendMessage(ChatMessage message){

    }



}
