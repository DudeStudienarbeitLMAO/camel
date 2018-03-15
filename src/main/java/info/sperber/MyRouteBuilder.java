package info.sperber;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import java.io.PrintWriter;
import java.util.Date;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    private PrintWriter writer;
    public MyRouteBuilder(PrintWriter writer){
        this.writer = writer;
    }

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        from("file:src/data?noop=true").to("stomp:queue:Chatroom");

        from("stomp:queue:Chatroom").process(new Processor() {
            @Override
           public void process(Exchange exchange) throws Exception {
                log.info(("received new message ") + new Date());
                log.info(" - " + exchange.getIn().getBody(String.class));
            }
        }).transform(body().convertToString()).to("file:target/messages");



    }


}
