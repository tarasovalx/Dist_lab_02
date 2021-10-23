import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

enum Type{
    AIRPORT,
    FLIGHT
}

public class AirportWritableComparable implements WritableComparable<AirportWritableComparable> {
    private Type type;
    private int id;

    public AirportWritableComparable(){

    }

    public int getId(){
        return id;
    }

    public AirportWritableComparable(int id, Type type){
        this.id = id;
        this.type = type;
    }

    public int compareTo(AirportWritableComparable o) {
        return o.id - this.id;
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(id);
        dataOutput.writeInt(type.ordinal());

    }

    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readInt();
        this.type = Type.values()[dataInput.readInt()];
    }
}
