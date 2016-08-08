
/*-------------------------------------------------------------------------------- 
 

* Module Name:- Weatherdata.java
 * Course Number : CSE6331
 *Lab number : Programming Assignment 4
 *Description :- WeatherData analysis Hadoop
 *Created Date :- 04/06/2015
 * 
----------------------------------------------------------------------------------- */
import java.io.IOException;

import java.util.*;
import java.lang.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;

public class hadooptest {
	      public static void main(String[] args) throws IOException {
	 	     JobConf config = new JobConf(hadooptest.class);
	 	     config.setJobName("hadooptest");
	 	     config.setNumMapTasks(Integer.parseInt(args[2])); //Update the no. of map tasks
	 	     config.setNumReduceTasks(Integer.parseInt(args[3])); //Update the no. of reducer tasks
	 	     config.setInputFormat(TextInputFormat.class);
	 	     config.setOutputFormat(TextOutputFormat.class);
	 	     config.setOutputKeyClass(Text.class);
	 	     config.setOutputValueClass(IntWritable.class);
	 	     config.setMapOutputKeyClass(Text.class);
	 	     config.setMapOutputValueClass(Text.class);
	 	     config.setMapperClass(hadooptestMapper.class); //initialize Mapper Class
             config.setReducerClass(hadooptestReducer.class); //Initialize Reducer Class
		     FileOutputFormat.setOutputPath(config, new Path(args[1])); // path to create output file
		     FileInputFormat.addInputPath(config, new Path(args[0])); //Input directory
		try
		{
		JobClient.runJob(config);
		}
		catch (Exception e)	{
			e.printStackTrace();
				}
}
}
