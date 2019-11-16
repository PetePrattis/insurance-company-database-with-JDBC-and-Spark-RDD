import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;
import org.apache.spark.HashPartitioner;

public class Dataset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparkConf conf = new SparkConf().setAppName("JavaStatusAPIDemo").setMaster("local[*]"); 
		JavaSparkContext jsc = new JavaSparkContext(conf);
		
		JavaRDD<String> data = jsc.textFile(System.getProperty("user.dir")+"/src/db2_project_data.csv").mapPartitionsWithIndex((index, iter) -> {
            if (index == 0 && iter.hasNext()) {
                iter.next();
                if (iter.hasNext()) {
                    iter.next();
                }
            }
            return iter;
		}, true);;

		//a) calculate a statistic				
		//program calculates query iv, average distance traveled per customer
		JavaPairRDD<String, Float> tuple = data.mapToPair(s -> {
			String[] foo= s.split(",");
		return new Tuple2<>(foo[0], Float.parseFloat(foo[2]));
		});
				
				
		JavaPairRDD<String, Tuple2<Float, Integer>> sum = tuple.mapValues(value -> new Tuple2<Float, Integer>(value,1));

		JavaPairRDD<String, Tuple2<Float, Integer>> avg = sum.reduceByKey((tuple1,tuple2) ->  new Tuple2<Float, Integer>(tuple1._1 + tuple2._1, tuple1._2 + tuple2._2));
			    
		avg.foreach(x -> {
			System.out.println(x._1() + "," + x._2()._1()/x._2()._2());}				
		);
		
		
		//b), c) 
		//program calculates query v, average distance traveled per region
		JavaPairRDD<Integer, Float> pair = data.mapToPair(s -> {
			String[] foo= s.split(",");
			return new Tuple2<>(Integer.parseInt(foo[3]), Float.parseFloat(foo[2]));
		});
				
				
		JavaPairRDD<Integer, Tuple2<Float, Integer>> count = pair.mapValues(value -> new Tuple2<Float, Integer>(value,1));

		JavaPairRDD<Integer, Tuple2<Float, Integer>> result = count.reduceByKey((tuple1,tuple2) ->  new Tuple2<Float, Integer>(tuple1._1 + tuple2._1, tuple1._2 + tuple2._2));
			    
		result.foreach(x -> {
			System.out.println(x._1() + "," + x._2()._1()/x._2()._2());}				
		);
			    
		JavaPairRDD<Integer, Tuple2<Float, Integer>> part = pair.mapValues(value ->new Tuple2<Float, Integer>(value,1)).partitionBy(new HashPartitioner(2));
			    
		JavaPairRDD<Integer, Tuple2<Float, Integer>> hashed = part.reduceByKey((tuple1,tuple2) ->  new Tuple2<Float, Integer>(tuple1._1 + tuple2._1, tuple1._2 + tuple2._2));
			    
		hashed.foreach(x -> {
			System.out.println(x._1() + "," + x._2()._1()/x._2()._2());}				
		);
			    
		jsc.close();
	}
}


