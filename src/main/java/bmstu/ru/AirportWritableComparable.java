package bmstu.ru;

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
    private String name;
    private int id;

    public AirportWritableComparable(){

    }

    public int getId(){
        return id;
    }

    public Type getType(){
        return type;
    }

    public String getName(){
        return name;
    }

    public AirportWritableComparable(int id, String name, Type type){
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public int compareTo(AirportWritableComparable o) {
        int x = this.type.ordinal() -o.getType().ordinal();
        if (x != 0){
            return x;
        } else{
            return o.id - this.id;
        }
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
