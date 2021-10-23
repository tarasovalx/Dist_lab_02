package bmstu.ru;

import org.apache.hadoop.mapreduce.Partitioner;

public class FlightPartitioner extends Partitioner<AirportWritableComparable, FlightWritable> {
    @Override
    public int getPartition(AirportWritableComparable key, FlightWritable val, int i) {
        return key.getId() % i;
    }
}
