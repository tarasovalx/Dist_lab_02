import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

enum Type{
    AIRPORT,
    FLIGHT
}

public class AirportWritableComparable extends AirportWritable implements WritableComparable<AirportWritableComparable> {
    private Type type;

    public AirportWritableComparable(int id, Type type){
        super(id);
        this.type = type;
    }

    public int compareTo(AirportWritableComparable o) {
        return o.getId() - this.getId();
    }
}
