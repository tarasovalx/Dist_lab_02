import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FlightComparator extends WritableComparator {
    public FlightComparator(){
        super(AirportWritableComparable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        var x = (AirportWritableComparable)a;
        var y = (AirportWritableComparable)b;
        return x.getId() - y.getId();
    }
}
