package tvm_project;
public class InputValidation {
    
    /**
     * Try make string to int.
     * @param s
     * @return 
     */
    public int isInterger(String s) {
        int temp;
        try {
            temp = Integer.parseInt(s);        // Try make s to int
        } catch (NumberFormatException e) {    //catch exception - return error
            return -1;
        }
        if (temp==0){
            return -1;
        }
        
        if (temp < 0) {                     // invert negatives
            temp *= -1;
        }
        return temp;                        //if no exception, return int
    }
    
    /**
     * Try make string to double.
     * @param s
     * @return 
     */
    public double isDouble(String s) {
        double temp;
        try {
            temp = Double.parseDouble(s);      // Try make s to double
        } catch (NumberFormatException e) {    //catch exception - return error
            return -1;
        }
        if (temp < 0.0) {                     // invert negatives
            temp *= -1;
        }
        return temp;                        // if no exception, return double
    }
}
