object LearningScala2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(1479); 

 def main(args: Array[String]) {
	
	  // Flow control
	  
	  // If / else syntax
	  if (1 > 3) println("Impossible!") else println("The world makes sense.")
	  
	  if (1 > 3) {
	  	println("Impossible!")
	  } else {
	  	println("The world makes sense.")
	  }
	  
	  // Matching - like switch in other languages:
	  val number = 3
	  number match {
	  	case 1 => println("One")
	  	case 2 => println("Two")
	  	case 3 => println("Three")
	  	case _ => println("Something else")
	 	}
	 	
	 	// For loops
	 	for (x <- 1 to 4) {
	 		val squared = x * x
	 		println(squared)
	 	}
	                                                  
	  // While loops
	  var x = 10
	  while (x >= 0) {
	  	println(x)
	  	x -= 1
	  }
	                                                  
	  x = 0
	  do { println(x); x+=1 } while (x <= 10)
	                                                  
	   // Expressions
	   // "Returns" the final value in a block automatically
	   
	   {val x = 10; x + 20}
	                                                
		 println({val x = 10; x + 20})
		 
		 // EXERCISE
		 // Write some code that prints out the first 10 values of the Fibonacci sequence.
		 // This is the sequence where every number is the sum of the two numbers before it.
		 // So, the result should be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
		  var val1 = 0
		  var val2 = 1
		  for (x <- 0 to 8) {
	 		var fibo = val1 + val2
	 		val1 = val2
	 		val2 = fibo
	 		println(fibo)
	 	}
 	};System.out.println("""main: (args: Array[String])Unit""")}
	   
}
