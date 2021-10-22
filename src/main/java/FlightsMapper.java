import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class FlightsMapper extends Mapper<LongWritable, FlightWritable, AirportWritableComparable, FloatWritable> {

    @Override
    protected void map(LongWritable key, FlightWritable value, Context context) throws IOException, InterruptedException {
        if (!value.isCancelled()){
            context.write(new AirportWritableComparable(value.getAirportId(), Type.FLIGHT),
                          new FloatWritable(value.getDelayTime()));
        }
    }
}
