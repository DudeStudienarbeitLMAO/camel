package info.sperber;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import java.util.Date;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        // here is a sample which processes the input files
        // (leaving them in place - see the 'noop' flag)
        // then performs content based routing on the message using XPath
//        from("file:src/data?noop=true")
//            .choice()
//                .when(xpath("/person/city = 'London'"))
//                    .log("UK message")
//                    .to("file:target/messages/uk")
//                .otherwise()
//                    .log("Other message")
//                    .to("file:target/messages/others");

        from("file:src/data?noop=true").to("stomp:queue:TEST");

//        from("stomp:queue:TEST").process(new Processor() {
//            @Override
//            public void process(Exchange exchange) throws Exception {
//                log.info(("received new message ") + new Date());
//                log.info(" - " + exchange.getIn().getBody(String.class));
//            }
//        }).transform(body().convertToString()).to("file:target/messages");
//
//        from("stomp:topic:TOPICTEST").process(new Processor() {
//            @Override
//            public void process(Exchange exchange) throws Exception {
//                log.info(("received TOPIC message ") + new Date());
//                log.info(" - " + exchange.getIn().getBody(String.class));
//            }
//        }).transform(body().convertToString()).to("file:target/messages");


    }


}
