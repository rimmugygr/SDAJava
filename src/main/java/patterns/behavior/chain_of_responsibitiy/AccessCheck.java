package patterns.behavior.chain_of_responsibitiy;

public abstract class AccessCheck {
    private AccessCheck nextCheck;

    public AccessCheck addChainElement(AccessCheck nextCheck){
        this.nextCheck = nextCheck;
        return nextCheck;
    }

    protected abstract boolean doCheck(String usrename);

    protected  boolean checkNextElement(String usrename){
        if (nextCheck==null){
            return true;
        }
        return nextCheck.doCheck(usrename);
    }
}
