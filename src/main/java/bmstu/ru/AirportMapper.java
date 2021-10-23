package bmstu.ru;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, AirportWritableComparable, FlightWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Airport data =  new Airport(value.toString());

        context.write(new AirportWritableComparable(data.getId(), data.getName(), Type.AIRPORT),
                      new FlightWritable(data.getName(), 0, Type.AIRPORT));
    }
}
