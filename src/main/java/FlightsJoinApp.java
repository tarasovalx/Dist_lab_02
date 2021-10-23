import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.NLineInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class FlightsJoinApp {
    private static final String usageString = "Usage: WordCountApp <input path> <input path> <output path>";
    private static final String jobName = "Flights Join";

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println(usageString);
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(FlightsJoinApp.class);
        job.setJobName(jobName);

        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightsMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, AirportMapper.class);

        FileOutputFormat.setOutputPath(job,new Path(args[2]));

        job.setMapOutputKeyClass(AirportWritableComparable.class);
        job.setMapOutputValueClass(FloatWritable.class);

        job.setGroupingComparatorClass(FlightComparator.class);
        job.setPartitionerClass(FlightPartitioner.class);
        job.setReducerClass(StatisticCounter.class);

        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}