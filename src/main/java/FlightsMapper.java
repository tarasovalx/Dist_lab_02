import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class FlightsMapper extends Mapper<LongWritable, Text, AirportWritableComparable, FloatWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Flight a = new Flight(value.toString());
        if (!a.isCancelled()){
            context.write(new AirportWritableComparable(a.getAirportId(), Type.FLIGHT),
                          new FloatWritable(a.getDelayTime()));
        }
    }
}
