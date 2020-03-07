package patterns.behavior.interator;

public class PeymentList implements MyList<Peyment> {
    private Peyment[] peyments;

    public PeymentList(Peyment[] peyments) {
        this.peyments = peyments;
    }


    @Override
    public MyIterator<Peyment> interator() {
        return new PeymentInterator(peyments);
    }
}
