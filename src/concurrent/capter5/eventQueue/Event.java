package concurrent.capter5.eventQueue;

/**
 * @author ltw
 * on 2019-12-24.
 */

public class Event {
    private String message;

    public Event(String message){
       this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
