package patterns.behavior.method;

import org.apache.log4j.Logger;

public abstract class NewsProwider {
    private final Logger LOG = Logger.getLogger("Provider");
    private int id;
    String message;

    public abstract boolean authorized();

    public final boolean sendMessage(){
        LOG.info(message);
        return true;
    }

    protected abstract void endConnection();

    public final void providedNews(){
        authorized();
        sendMessage();
        endConnection();
    }


}
