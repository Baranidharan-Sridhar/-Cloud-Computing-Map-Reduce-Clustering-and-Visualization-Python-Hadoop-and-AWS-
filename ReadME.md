Instructions:

	Real time Earthquake data containing more than million tuples was used 
	Useful information such as relationship between magnitude and location and other such associations are mined using Hadoop’s Map Reduce.
	
	HadoopTest.java:
		Contains config files to set no of mapper and reducer
		contains mapper class and reducer class initiation
		Input, output file configurations
	HadoopTestMapper.java, HadoopTestReducer.java:
		The input data is split into large no of chunks and calculates the year and precipitation value of the weather data greater than a specified limit,
		in a distributed fashion, which is then given as input to the reducer
		The reducer just summarizes the map data like calculation avg precipitation occured during a particular year span.
		