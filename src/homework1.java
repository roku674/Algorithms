import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class homework1 {

	static class MinMax { 		  
        int min; 
        int max; 
    } 
  
	//iterative because just for loops through O(n)
    static MinMax getMinMax(int arr[]) { 
        MinMax minMax = new  MinMax(); 
        int size = arr.length;
        
        if (size == 1 && size > 0) { 
        	//if you're an only child you're the favorite and the worst
            minMax.min = arr[0];
            minMax.max = arr[0]; 
            return minMax; 
        } 
        //establish some start comparison point
        if (arr[1] > arr[0]) { 
            minMax.min = arr[0]; 
            minMax.max = arr[1]; 

        } else { 
            minMax.min = arr[1]; 
            minMax.max = arr[0]; 
        } 
        
        //see i wasn't 100% sure if you wanted this one to be divide and conquer  so i have this linear code commented out because it seemed like the greedy thign to do if i'm going dynamic if you're trying to run it comment out the otehr 2 for loops and uncomment this
		/*
        for (int i = 0; i < size; i++) { 
        	if (arr[i] < minMax.min) { 
                minMax.min = arr[i]; 
        	}
        	else if (arr[i] > minMax.max) { 
                minMax.max = arr[i];            
            } 
        } 
		*/
        
        //top
        for (int i = 0; i < size/2; i++) { 
        	if (arr[i] < minMax.min) { 
                minMax.min = arr[i]; 
        	}
        	else if (arr[i] > minMax.max) { 
                minMax.max = arr[i];            
            } 
        }
        //bottom
        for (int i = size-1; i > size/2; i--) { 
        	if (arr[i] < minMax.min) { 
                minMax.min = arr[i]; 
        	}
        	else if (arr[i] > minMax.max) { 
                minMax.max = arr[i];            
            } 
        } 
        
        return minMax; 
    } 
    
    //idk how this is an algorithm but its just a series of logic i think loops when people say algorithm but ya...
    public static MinMax FindMinMaxRecursive(int[] arr, int left, int right, MinMax minMax)
    {

        // mid or feed
        int mid = (left + right) / 2;
        
        if (minMax.min == 0) {
        	minMax.min = arr[left];
        }
        
        if (minMax.max == 0) {
        	minMax.max = arr[mid];
        }

        if (left == right || right - left == 0) //one        
        {
            if (minMax.max < arr[left]) {    
                minMax.max = arr[left];
            }

            if (minMax.min > arr[right]) {   
                minMax.min = arr[right];
            }

            return minMax;
        }
        
        if (right - left == 1)    //two        
        {
            if (arr[left] <= arr[right])      
            {
                if (minMax.min > arr[left]) {    
                    minMax.min = arr[left];
                }

                if (minMax.max < arr[right]) {   
                    minMax.max = arr[right];
                }
            }
            else {
                if (minMax.min > arr[right]) {   
                    minMax.min = arr[right];
                }
                
                if (minMax.max < arr[left]) {  
                    minMax.max = arr[left];
                }
            }
            
            return minMax;
        }
        
        
        //cut the array like Jesus breaking bread
        
        // left bread
        //minMax = FindMinMaxRecursive(arr, left, mid, minMax);

        // right bread
        //minMax = FindMinMaxRecursive(arr, mid + 1, right, minMax);    	
        
        return FindMinMaxRecursive(arr,left,mid, FindMinMaxRecursive(arr, mid + 1, right, FindMinMaxRecursive(arr,left,mid, minMax)));
        
        //return minMax;
    }

    public static void main(String args[]) { 
        //int arr[] = {1234, 11, 332, 0, 305, 3000, 1, 5000}; //needs to be input 
        
    	System.out.println("There's no error handling so be responsible only type in numbers and don't type spaces\n");
        
    	ArrayList<String> list = new ArrayList<String>();
        Scanner stdin = new Scanner(System.in);

        do {
            System.out.println("Current list is " + list);
            System.out.println("Add more? (y/n)");
            if (stdin.next().startsWith("y")) {
                System.out.println("Enter : ");
                list.add(stdin.next());
            } else {
                break;
            }
        } while (true);
        stdin.close();
        System.out.println("\nList is " + list);
        String[] strArr = list.toArray(new String[0]);
          
        int [] arr = new int [strArr.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
         }
        System.out.println("Array is " + Arrays.toString(arr) + "\n");
        
        MinMax minMax = getMinMax(arr); 
        System.out.println("Minimum element is "+ minMax.min + " Iterative"); 
        System.out.println("Maximum element is "+ minMax.max + " Iterative"); 
        
        minMax = new  MinMax();
        
        
        int size = arr.length;
        minMax = FindMinMaxRecursive(arr, 0, size-1, minMax);
        
        
        System.out.println("\nMinimum element is "+ minMax.min + " Recursive"); 
        System.out.println("Maximum element is "+ minMax.max  + " Recursive"); 
  
    } 
}
