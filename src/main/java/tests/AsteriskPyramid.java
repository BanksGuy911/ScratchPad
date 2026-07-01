package tests;

public class AsteriskPyramid {

    public static void main(String[] args) {
        int n = (args.length>0)?Integer.parseInt(args[0]):10;
        genPyramid(n);
    }
    
	   static void genPyramid(int n){
	        int lastRowSize = (2 * n)-1;
	        char[][] pyramid = new char[n][lastRowSize];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < lastRowSize; j++) {
					pyramid[i][j] = ' ';
				}
			}
	        int initialIndex = lastRowSize/2;

	        for(int i = 1; i <= n; i++){
	            for(int j = initialIndex-i; j < (initialIndex-i) + Math.abs(((2*i)-1)) ; j++){
	                pyramid[i-1][j+1] = '*';
	            }
	        }
	        
	        //Print Pyramid
	        for(int i = 0; i < pyramid.length; i++){
	                System.out.println(new String(pyramid[i]));
	        }
       }
}
