import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class StatisticCounter extends Reducer<AirportWritableComparable, FloatWritable, Text, Text> {
    @Override
    protected void reduce(AirportWritableComparable key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException {
        float averageDelay = 0;
        float maxDelay = 0;
        float minDelay = Float.MAX_VALUE;

        int cnt = 0;
        for (var delayWritable : values){
            var delay = delayWritable.get();
            averageDelay += delay;
            minDelay = M
        }

    }
}
