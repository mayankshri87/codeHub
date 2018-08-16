package powFunction;
/*We can calculate power by using repeated addition.

For example to calculate 5^6.
1) First 5 times add 5, we get 25. (5^2)
2) Then 5 times add 25, we get 125. (5^3)
3) Then 5 time add 125, we get 625 (5^4)
4) Then 5 times add 625, we get 3125 (5^5)
5) Then 5 times add 3125, we get 15625 (5^6)*/
public class PowFunction {

	static int pow(int a, int b)
    {
        if (b == 0)
            return 1;
             
        int answer = a;
        int increment = a;
        int i, j;
         
        for (i = 1; i < b; i++) {
            for (j = 1; j < a; j++) {
                answer += increment;
            }
            increment = answer;
        }
         
        return answer;
    }
 
    // driver program to test above function
    public static void main(String[] args)
    {
        System.out.println(pow(5, 2));
    }

}
