// ROHAN MATHEW PANICKER CS610 0880 prp
// author: ROHAN MATHEW PANICKER
// NJIT ID: 31460880
// DATA STRUCTURES AND ALGORITHMS
// PAGE RANK ALGORITHM

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class pgrk0880 {

	public pgrk0880() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]) {
		
		try {
			int iterationValue = Integer.parseInt(args[0]);//iteration Value
			int initialValueIdentifier = Integer.parseInt(args[1]);//initial Value
			String inputFileLocation = args[2];
			int totalNodes = 0;
			int totalEdges = 0;
			boolean check=true;
			int adjacencyMatrix[][] = null;
			
			if(initialValueIdentifier==0 || initialValueIdentifier==1 || initialValueIdentifier==-1 || initialValueIdentifier==-2) {
				
				File fileCheck = new File(inputFileLocation);
				
				if(fileCheck.exists()){
					
					Scanner sc = new Scanner(new BufferedReader(new FileReader(inputFileLocation)));
					
					while(sc.hasNextLine()) {
						
						String[] line = sc.nextLine().trim().split(" ");
						
						if(check) {
							totalNodes = Integer.parseInt(line[0]);
							totalEdges = Integer.parseInt(line[1]);
							adjacencyMatrix = new int[totalNodes][totalNodes];
							check=false;
						}
						else if(!check) {
							
							for (int i=0; i<adjacencyMatrix.length; i++) {
					        	 
					            for (int j=0; j<line.length; j++) {
					               adjacencyMatrix[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = 1;
					            }
					         }
							
						}
						
				         
				    }					
					
				}else{
					System.out.println("file not exist.");
				}
				
				
			}
			else {
				
				System.out.println("Enter the initial Values as(0/1/-1/-2)");
				
			}
			
			//System.out.println("Iterations : " + iterationValue + " Initial Value : " + initialValueIdentifier + " Nodes : " + totalNodes + " Edges : " + totalEdges);
			//Very Large Graph
			if( totalNodes > 10  ) {
				
				iterationValue = 0;
				initialValueIdentifier = -1;
				
			}
			
			if(iterationValue == 0 || iterationValue < 0) {
				pgrk0880 pr = new pgrk0880();
			    pr.computeRank(iterationValue,initialValueIdentifier,totalNodes,adjacencyMatrix);
			}
			else {
				pgrk0880 pr = new pgrk0880();
			    pr.calculateRank(iterationValue,initialValueIdentifier,totalNodes,adjacencyMatrix);
			}
			
		    
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}
	
	
	public static void calculateRank(int iteration,int initialValue,int nodes,int aMatrix[][]) {
		
		double oldPageRank[] = new double[nodes];
		double newPageRank[] = new double[nodes];
		double dampingFactor = 0.85;
		double n = nodes;
		double remFactor = (1.0-dampingFactor)/n;
		double outGoingLinks[] = new double[nodes];
		
		//System.out.println("Nodes:" + n + " DampingFactor:" + dampingFactor + " (1-d)/n:" + remFactor);
		
		for(int i=0;i<nodes;i++) {
			
			if(initialValue==0) {
				oldPageRank[i] = 0.0;
			}
			else if(initialValue==1) {
				oldPageRank[i] = 1.0;		
			}
			else if(initialValue==-1) {
				oldPageRank[i] = 1.0/nodes;
			}
			else if(initialValue==-2) {
				oldPageRank[i] = 1.0/(Math.sqrt(nodes));
			}
		}
		
		System.out.print("Base : 0 :");
		for(int i = 0 ; i < nodes ; i++ ) {
			System.out.printf(" P[%d] = %f",i,oldPageRank[i]);
		}
		System.out.println();
		
		
		for(int i=0 ; i<nodes ; i++) {
			for(int j=0 ; j<aMatrix[i].length ; j++ ) {
				
				if( aMatrix[i][j]==1 ) {
					outGoingLinks[i]=outGoingLinks[i]+1.0;
				}
				
			}
		}

		for(int k=0; k<iteration; k++) {
			
			for(int j = 0 ; j<nodes ; j++) {
				newPageRank[j]=0.0;
				for(int i = 0 ; i<nodes; i++) {
					if(aMatrix[i][j]==1) {
						newPageRank[j]=newPageRank[j]+(dampingFactor*(oldPageRank[i]/outGoingLinks[i]));
					}
					
				}
				newPageRank[j]= newPageRank[j]+ remFactor;
			}
			
			for(int i=0 ; i<nodes ; i++) {
				oldPageRank[i] = newPageRank[i];
			}
			
			System.out.printf("Iter : %d :",k+1);
			for(int i=0 ; i<nodes ; i++) {
				System.out.printf(" P[%d]=%f",i,newPageRank[i]);
			}
			System.out.println();
		}
		
	
	}//calculateRank() ends
	
	public static void computeRank(int iteration,int initialValue,int nodes,int aMatrix[][]) {
		
		double oldPageRank[] = new double[nodes];
		double newPageRank[] = new double[nodes];
		double dampingFactor = 0.85;
		double n = nodes;
		double remFactor = (1.0-dampingFactor)/n;
		double outGoingLinks[] = new double[nodes];
		double errorRate = 0.0;
		
		//System.out.println("Nodes:" + n + " DampingFactor:" + dampingFactor + " (1-d)/n:" + remFactor);
		
		for(int i=0;i<nodes;i++) {
			
			if(initialValue==0) {
				oldPageRank[i] = 0.0;
			}
			else if(initialValue==1) {
				oldPageRank[i] = 1.0;		
			}
			else if(initialValue==-1) {
				oldPageRank[i] = 1.0/nodes;
			}
			else if(initialValue==-2) {
				oldPageRank[i] = 1.0/(Math.sqrt(nodes));
			}
		}
		
		if(iteration == 0 || iteration == -5) {
			errorRate = 1.0/100000.0;
		}
		else if(iteration == -1) {
			errorRate = 1.0/10.0;
		}
		else if(iteration == -2) {
			errorRate = 1.0/100.0;
		}
		else if(iteration == -3) {
			errorRate = 1.0/1000.0;
		}
		else if(iteration == -4) {
			errorRate = 1.0/10000.0;
		}
		else if(iteration == -6) {
			errorRate = 1.0/1000000.0;
		}
		else {
			double num = iteration;
			errorRate = 1.0/num;
		}
		
		if(nodes <= 10) {
			
			System.out.print("Base : 0 :");
			for(int i = 0 ; i < nodes ; i++ ) {
				System.out.printf(" P[%d] = %f",i,oldPageRank[i]);
			}
			System.out.println();
			
		}
		
		for(int i=0 ; i<nodes ; i++) {
			for(int j=0 ; j<aMatrix[i].length ; j++ ) {
				
				if( aMatrix[i][j]==1 ) {
					outGoingLinks[i]=outGoingLinks[i]+1.0;
				}
				
			}
		}
		
		boolean continueLoop = true;
		int r=0;

		while(continueLoop == true) {
			
			for(int j = 0 ; j<nodes ; j++) {
				newPageRank[j]=0.0;
				for(int i = 0 ; i<nodes; i++) {
					if(aMatrix[i][j]==1) {
						newPageRank[j]=newPageRank[j]+(dampingFactor*(oldPageRank[i]/outGoingLinks[i]));
					}
					
				}
				newPageRank[j]= newPageRank[j]+ remFactor;
			}
			
			//Error condition check
			for(int i = 0 ; i <nodes ; i++) {
				
				if(Math.abs(newPageRank[i] - oldPageRank[i])< errorRate) {
					continueLoop = false;
				}
				else {
					continueLoop = true;
					break;
				}
				
			}
			//Error condition ends
			
			for(int i=0 ; i<nodes ; i++) {
				oldPageRank[i] = newPageRank[i];
			}
			
			// Will print this way if the nodes is less than and equal to 10
			if(nodes <= 10 ) {
				System.out.printf("Iter : %d :",++r);
				for(int i=0 ; i<nodes ; i++) {
					System.out.printf(" P[%d]=%f",i,newPageRank[i]);
				}
				System.out.println();
			}
			
		}
		
		// if nodes are greater than 10
		if(nodes > 10) {
			System.out.println("Iter:"+r);
			
			for( int i = 0 ; i < nodes ; i++ ) {
				System.out.printf(" P[%d]=%f",i,newPageRank[i]);
				System.out.println();
			}
			
		}
		
		
	}

}
