package patterns.behavior.method;

import org.apache.log4j.Logger;

public class EmailNewsProvider extends NewsProwider {
    private final Logger LOG = Logger.getLogger("Email");

    public void sendEmailContent(String content){

        //TODO
    }

    @Override
    public boolean authorized() {
        LOG.info("Authorization");
        return true;
    }

    @Override
    protected void endConnection() {
        LOG.info("Log of");
    }
}
