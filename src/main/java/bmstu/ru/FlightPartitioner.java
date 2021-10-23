package bmstu.ru;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class FlightPartitioner extends Partitioner<AirportWritableComparable, FloatWritable> {
    @Override
    public int getPartition(AirportWritableComparable key, FloatWritable val, int i) {
        return key.getId() % i;
    }
}
