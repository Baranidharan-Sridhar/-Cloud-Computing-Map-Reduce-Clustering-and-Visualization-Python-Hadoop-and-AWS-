
/*-------------------------------------------------------------------------------- 
 * Module Name:- WeatherdataMapper.java

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

public class hadooptestMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {

  private final static IntWritable one = new IntWritable(1);
  private Text word = new Text();
  int last=2015;

  
  public static int parseInteger( String string, int defaultValue ) {
	  try {
	    return Integer.parseInt(string);
	  }
	  catch (NumberFormatException e ) {
	    return defaultValue;
	  }
	}
@Override
public void map(LongWritable key, Text value,
		OutputCollector<Text, Text> out, Reporter arg3)
		throws IOException {
	// TODO Auto-generated method stub
	if(key.get()>0){
		  String[] params = value.toString().split(",");
	   
	    int year=parseInteger(params[4].substring(0,4),0);	  
	    int prec=parseInteger(params[5],0);
	    
	    
	    if(prec>0)
	    {Text prcp=new Text(""+prec);
	    Text yr=new Text(""+year);
	    out.collect(yr, prcp);
	    }
	    }
	    }
	   
}


    
