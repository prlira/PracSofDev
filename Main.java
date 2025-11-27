//PAMELA EYRE VICTORIA LIRA
//Practice Software Development

package firstproj;
import java.util.Arrays;
public class Main {
	
	public static void main(String[] args) {

	 	double[][] exampleInput={
            {1.0, Double.NaN, 3.0},
            {Double.NaN, Double.NaN, 2.0},
            {4.0, 5.0, Double.NaN},
            {8.0, 9.0,  Double.NaN} //additional array for demo purposes
            };
      
        double[][]exampleOutput = idw(exampleInput); //This will call the IDW method function below
        
        for(int i=0; i<exampleOutput.length; i++) {
            for (int j=0; j<exampleOutput[i].length; j++) {
                double answer=exampleOutput[i][j];
                System.out.printf("%.2f ", answer);
            }
            System.out.println();
            
            /*Using a for-loop again, we will loop through each row first, and then by column
	        then get the known value of the array while performing IDW for the Double.Nan ones.
	        This will result to a matrix output separated by space per row, 
	        then moves to the next line after printing the columns of the current row
	        */
        }
    }
 
static double[][] idw(double[][] data) {
	int input_row, input_col;
	int xi, yi, x0, y0;
	//This sets the variables for the example input/output array wherein 0=known, i=unknown;
	double tempx, tempy, euclidist, power;
    
	//These variables are set for the IDW Method

	input_row = data.length;
	input_col = data[0].length;
    //This part gets the size of the input array and initiates a new double array for the answer.
    

    for(x0=0; x0<input_row; x0++){
       for(y0=0; y0<input_col; y0++){
         if(Double.isNaN(data[x0][y0])==false){
            continue;}
         /* If the current cell already has a value (not a Double.Nan, this skips it 
          * and moves on to the next cell since we only want to perform interpolation for cells that are NaN. 
     	*/
         
         /*In the following, we will be using for loop for the array to use the known values and interpolate the NaN cell [x,y]
            Here, data[xi][yi] represents each known value in the array that will contribute to the interpolation. */ 
         double sum=0, total=0;
         for(xi=0; xi<input_row; xi++){
                for(yi=0; yi<input_col; yi++){
                    if (Double.isNaN(data[xi][yi])==false){
                    	/*This condition make sure we will ONLY PERFORM
                    	IDW for Nan empty cells for interpolation, otherwise it skips*/
                    	
                    	tempx=x0-xi;
                    	tempy=y0-yi;
                    	euclidist = Math.sqrt((tempx*tempx) + (tempy*tempy));
                    	//This gets Euclidian distance between the grid cells
                        power = 1/Math.pow(euclidist, 2);
                        //For this assignment, we use 2 as a power parameter and we use the Math function to raise the resulting distance to 2
                       
                        sum=sum+(data[xi][yi]*power);
                        total=total+power;
                     //For the current NaN cell, we multiply the known value by its power based on euclidian distance and add it to the sum.
                     //Total add the influences for the current NaN cells
                     //After looping through all known points, sum/total will give the interpolated value for the unknown cell.
                        }
                }
         }
            			data[x0][y0]=sum/total; 
            			/* After summing the weight from all known points, 
            			we divide by the total of the weights to calculate the interpolated value 
            			for the current NaN cell at data[x0, y0]*/
        }}
    return data;
}
	}


