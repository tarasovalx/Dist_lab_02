import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;



public class Airport {
    private int id;
    private String name;

    public Airport(String s){
        String[] data = s.split(",");
        this.id = Integer.parseInt(data[0]);
        this.name = data[1];

    }

    public int getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

}
