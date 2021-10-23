package bmstu.ru;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class StatisticCounter extends Reducer<bmstu.ru.AirportWritableComparable, FlightWritable, IntWritable, Text> {
    private static final String format = "Airport:%s  AVG_DELAY:%f, MIN_DELAY %f, MAX_DELAY:%f, NUM_FLIGHTS:%d";

    @Override
    protected void reduce(bmstu.ru.AirportWritableComparable key, Iterable<FlightWritable> values, Context context) throws IOException, InterruptedException {
        float averageDelay = 0;
        float maxDelay = 0;
        float minDelay = Float.MAX_VALUE;

        String name = " ";

        int cnt = 0;

        for (FlightWritable delayWritable : values){
            if (delayWritable.getType() == Type.AIRPORT){
                name = delayWritable.getName();
            }

            cnt ++;
            float delay = delayWritable.getDelay();
            averageDelay += delay;
            minDelay = Math.min(minDelay, delay);
            maxDelay = Math.max(maxDelay, delay);
        }

        if (cnt > 0) {
            averageDelay /= cnt;
            context.write(new IntWritable(key.getId()),
                          new Text(String.format(format, name, averageDelay, minDelay, maxDelay, cnt)));
        }
    }
}
