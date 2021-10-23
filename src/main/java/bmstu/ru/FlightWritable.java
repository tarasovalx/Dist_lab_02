package bmstu.ru;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritable implements Writable {
    private String name;
    private float delay;
    private Type type;

    public String getName() {
        return name;
    }

    public float getDelay() {
        return delay;
    }

    public Type getType() {
        return type;
    }

    public FlightWritable(String name, float delay, Type type){
        this.name = name;
        this.delay = delay;
        this.type = type;
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(name);
        dataOutput.writeFloat(delay);
        dataOutput.writeInt(type.ordinal());
    }

    public void readFields(DataInput dataInput) throws IOException {
        this.name = dataInput.readUTF();
        this.delay = dataInput.readFloat();
        this.type = Type.values()[dataInput.readInt()];
    }
}
