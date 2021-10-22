import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class FlightPartitioner extends Partitioner<AirportWritableComparable, Text> {
    @Override
    public int getPartition(AirportWritableComparable key, Text val, int i) {
        return key.getId() % i;
    }
}
