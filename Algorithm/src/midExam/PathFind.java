package midExam;

public class PathFind {
	int[][] matrix;
	int[][] maxSum;
	
	public PathFind(int[][] input) {
		matrix=input;
		maxSum=new int[matrix.length][matrix.length];
	}
	
	public int findMax(int i, int j) {
	// Q 1-1) HERE !	
		if (i==0 && j==0) {
			if (maxSum[i][j]==0)
				maxSum[i][j] =  matrix[i][j];
			return maxSum[i][j] ;
		}
		if (j==0) {
			if (maxSum[i][j]==0)
				maxSum[i][j]= matrix[i][j]+findMax(i-1,j);
			return maxSum[i][j] ;
		}
		if (i==0) {
			if (maxSum[i][j]==0)
				maxSum[i][j]= matrix[i][j]+findMax(i,j-1);
			return maxSum[i][j] ;
		}
		else {
			if (maxSum[i][j]==0)
				maxSum[i][j]=  matrix[i][j]+Math.max(findMax(i,j-1), findMax(i-1,j));
			return maxSum[i][j] ;
		}

	}

			//finish
	
	public void showMaxSum(int row, int col) {
		for (int i=0; i<=row;i++) {
			System.out.println();
			for (int j=0; j<=col;j++)
				System.out.print(maxSum[i][j]+"  ");
		}
		System.out.println();
	}
	
	public void showPath(int i, int j) {
// Q 1-2) HERE !
		
		if (i==0 && j==0) {
			System.out.println("\n Start from (0,0) ");
		}
			
		else if (i==0 ) {
			System.out.println(" => "+i+","+j);
			showPath(i, j-1);
		}
			
		else if ( j==0) {
			showPath(i-1, j);
			System.out.println(" => "+i+","+j);
		}
		
		else {
			if (maxSum[i][j-1] >= maxSum[i-1][j] ) 
				showPath(i, j-1);
			else
				showPath(i-1, j);
			
			System.out.println(" => "+i+","+j);
		}
	
	
	}
	//finish
	
	public static void main(String[] args) {
		int [][] matrix = {{6,7,12,5,4},
						   {5,3,11,18,7},
						   {3,17,3,4,11},
						   {6,7,8,9,6},
						   {8,10,14,9,2}};
		int nDim = matrix.length;
		
		PathFind pf = new PathFind(matrix);

		System.out.println("\nMax Sum = "+pf.findMax(nDim-1, nDim-1));
		pf.showMaxSum(nDim-1, nDim-1);
		pf.showPath(nDim-1, nDim-1);
	}

}
