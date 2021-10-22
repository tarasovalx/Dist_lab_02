import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class FlightsJoinApp {
    private static final String usageString = "Usage: WordCountApp <input path> <output path>";
    private static final String jobName = "Flights Join";

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println(usageString);
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(FlightsJoinApp.class);
        job.setJobName(jobName);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
//        job.setMapperClass(WordMapper.class);
//        job.setReducerClass(WordReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}