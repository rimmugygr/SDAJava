package patterns.behavior.interator;

public class PeymentInterator implements MyIterator<Peyment> {
    private Peyment[] peyments;
    private int position;

    public PeymentInterator(Peyment[] peyments) {
        this.peyments = peyments;
        this.position = 0;
    }

    @Override
    public Peyment next() {
        return peyments[position++];
    }

    @Override
    public Peyment current() {
        return peyments[position];
    }

    @Override
    public boolean hasNext() {
        return peyments.length>position;
    }
}
