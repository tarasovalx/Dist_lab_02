import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class StatisticCounter extends Reducer<AirportWritableComparable, FloatWritable, IntWritable, Text> {
    private static final String format = "Airport:%s  AVG_DELAY:%f, MIN_DELAY %f, MAX_DELAY:%f";

    @Override
    protected void reduce(AirportWritableComparable key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException {
        float averageDelay = 0;
        float maxDelay = 0;
        float minDelay = Float.MAX_VALUE;

        int cnt = 0;
        for (FloatWritable delayWritable : values){
            cnt ++;
            float delay = delayWritable.get();
            averageDelay += delay;
            minDelay = Math.min(minDelay, delay);
            maxDelay = Math.max(maxDelay, delay);
        }

        if (cnt > 0) {
            averageDelay /= cnt;
            context.write(new IntWritable(key.getId()),
                          new Text(String.format(format, averageDelay, minDelay, maxDelay)));
        }
    }
}
