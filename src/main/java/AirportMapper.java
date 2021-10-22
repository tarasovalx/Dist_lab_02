import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, AirportWritable, AirportWritableComparable, Text> {

    @Override
    protected void map(LongWritable key, AirportWritable value, Context context) throws IOException, InterruptedException {
        context.write(new AirportWritableComparable(value.getId(), Type.AIRPORT),
                      new Text(value.getName()));
    }
}
