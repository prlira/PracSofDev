# PracSofDev
Practice Software Development (WS 25-26

Code explanations (ALSO FOUND IN CODE)

//PAMELA EYRE VICTORIA LIRA
//Practice Software Development
      
Using the example input, we call the IDW function.
        
Using a for-loop, we will loop through each row first, and then by column then get the known value of the array while performing IDW for the Double.Nan ones.
This will result to a matrix output separated by space per row, then moves to the next line after printing the columns of the current row
	    
 

IDW METHOD: 

We get the size of the input array and initiates a new double array for the answer.   
If the current cell already has a value (not a Double.Nan, this skips it and moves on to the next cell since we only want to perform interpolation for cells that are NaN. 
         
In the following, we will be using for loop for the array to use the known values and interpolate the NaN cell [x,y]
Here, data[xi][yi] represents each known value in the array that will contribute to the interpolation.

An if-condition make sure we will ONLY PERFORM IDW for Nan empty cells for interpolation, otherwise it skips
 
First, we performed the Euclidean distance calculation in the cell.

For this assignment, we use 2 as a power parameter and we use the Math function to raise the resulting distance to 2

For the current NaN cell, we multiply the known value by its power based on euclidian distance and add it to the sum.
Total add the influences for the current NaN cells. After looping through all known points, sum/total will give the interpolated value for the unknown cell.

After summing the weight from all known points, we divide by the total of the weights to calculate the interpolated value for the current NaN cell at data[x0, y0]
)
