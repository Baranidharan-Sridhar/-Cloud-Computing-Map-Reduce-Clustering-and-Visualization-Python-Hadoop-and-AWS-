


/*-------------------------------------------------------------------------------- 

 * Module Name:- WeatherdataReducer.java
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



public class hadooptestReducer
extends MapReduceBase
implements Reducer<Text, Text, Text, Text>
{
	

@Override
public void reduce(Text key, Iterator<Text> values,
		OutputCollector<Text, Text> out, Reporter arg3) throws IOException {
	
	// TODO Auto-generated method stub
	int sum = 0;
    int numOfRecords=0;
    
   
    while(values.hasNext())
    {
      String sumStr=values.next().toString();
      sum += Integer.parseInt(sumStr);
      numOfRecords++;
      
    }
    
    int avg=sum/numOfRecords;
    Text resp = new Text(""+numOfRecords);
    
    
   out.collect(key, new Text(""+resp));
	

}

}

