import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;



public class AirportWritable implements Writable {
    private int id;
    private String name;

    public AirportWritable(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(id);
    }

    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readInt();
        this.name = dataInput.readLine();
    }

}
