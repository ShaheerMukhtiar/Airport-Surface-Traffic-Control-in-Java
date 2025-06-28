package Task_queue;

public class Link_object {
    protected int runwayID;
    protected int taxiwayID;
    protected int gate;

    public Link_object() {
        this(0, 0, 0); // Calls the parameterized constructor with default values
    }

    public Link_object(int x, int y, int z) {
        runwayID = x;
        taxiwayID = y;
        gate = z;
    }

    public int getRunwayID() {
        return runwayID;
    }

    public int getTaxiwayID() {
        return taxiwayID;
    }

    public int getGateID() {
        return gate;
    }

    public void setRunwayID(int r) {
        runwayID = r;
    }

    public void setTaxiwayID(int t) {
        taxiwayID = t;
    }

    public void setGateID(int g) {
        gate = g;
    }
}
