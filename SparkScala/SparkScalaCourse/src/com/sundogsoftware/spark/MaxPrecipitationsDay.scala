package com.sundogsoftware.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import scala.math._

/** Find the minimum temperature by weather station */
object MaxPrecipitationsDay {
  
  def parseLine(line:String)= {
    val fields = line.split(",")
    val dayID = fields(1)
    val entryType = fields(2)
    val temperature = fields(3).toFloat * 0.1f * (9.0f / 5.0f) + 32.0f
    (dayID, entryType, temperature)
  }
    /** Our main function where the action happens */
  def main(args: Array[String]) {
   
    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    // Create a SparkContext using every core of the local machine
    val sc = new SparkContext("local[*]", "MaxPrecipitationsDay")
    
    // Read each line of input data
    val lines = sc.textFile("../1800.csv")
    
    // Convert to (stationID, entryType, temperature) tuples
    val parsedLines = lines.map(parseLine)
    
    // Filter out all but TMIN entries
    val maxPrecipitations = parsedLines.filter(x => x._2 == "PRCP")
    
    // Convert to (stationID, temperature)
    val dayPrecipitations = maxPrecipitations.map(x => (x._1, x._3.toFloat))
    
    // Reduce by stationID retaining the minimum temperature found
    val maxPrecipitationsByDay = dayPrecipitations.reduceByKey( (x,y) => max(x,y))
    
    // Collect, format, and print the results
    val results = maxPrecipitationsByDay.collect()
    
    for (result <- results.sorted) {
       val day = result._1
       val temp = result._2
       val formattedTemp = f"$temp%.2f °"
       println(s"$day maximum Precipitations: $formattedTemp") 
    }
      
  }
}