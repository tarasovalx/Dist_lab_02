import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritable implements Writable {
    private static final int IS_CANCELLED = 19;
    private static final int DELAY_TIME = 18;
    private static final int AIRPORT_ID = 14;

    private static final String DELIMETER = ",";
    private static final String CANCELLED_FLAG = "1.00";

    private boolean isCancelled;
    private float delayTime;
    private int airportId;

    public void write(DataOutput dataOutput) throws IOException {

    }

    public void readFields(DataInput dataInput) throws IOException {
        var data = dataInput.toString().split(DELIMETER);
        this.airportId = Integer.parseInt(data[AIRPORT_ID]);
        this.isCancelled = data[IS_CANCELLED] == CANCELLED_FLAG;
        this.delayTime =  Float.parseFloat(data[DELAY_TIME]);
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public float getDelayTime() {
        return delayTime;
    }

    public int getAirportId() {
        return airportId;
    }
}
