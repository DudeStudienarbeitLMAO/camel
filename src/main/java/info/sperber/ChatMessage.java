package info.sperber;

/**
 * Created by fabian on 3/15/18.
 */
public class ChatMessage {

    private enum MessageType{
        MESSAGE,
        CONNECT,
        DISCONNECT
    }

    private MessageType type;
    private String senderID;
    private String Content;

    public ChatMessage(MessageType type, String senderID, String content) {
        this.type = type;
        this.senderID = senderID;
        Content = content;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString(){
        String result  ="";
        switch (this.type){
            case CONNECT:
                result = "USER " + this.senderID + " CONNECTED";
                break;
            case DISCONNECT:
                result = "USER " + this.senderID + " DISCONNECTED";
                break;
            case MESSAGE:
                result = this.senderID + ": " + this.Content;
                break;
        }
        return result;
    }
}
