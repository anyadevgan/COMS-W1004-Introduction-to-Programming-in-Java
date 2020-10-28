/**
* ArrayMethods
* Manipulate Array Contents
* Anya Devgan
* UNI:ad3706
*/

import java.util.Arrays;
import java.util.ArrayList;

public class ArrayMethods {

	// private instance variables
	private int[] values;
	// this is for  resetting purposes, otherwise not needed
	private int[] originalValues; 

	//constructor
	public ArrayMethods(int[] initialValues) {
		values = initialValues;
		originalValues = Arrays.copyOf(values, values.length);
	}

	// pretty printing for testing purposes
	public void printArray() {
		for (int i : values) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	// resetting back to original values for testing purposes
	public void resetValues() {
		values = Arrays.copyOf(originalValues, originalValues.length);
	}

	// a. swap the first and last elements
	public void swapFirstAndLast() {
		int temp = values[0];
        values[0] = values[values.length-1];
        values[values.length-1] = temp;
	}

	// b. shift all element to right and wraparound
	public void shiftRight() {
		int temp = values[values.length-1];
        for(int i = values.length-1; i > 0; i--){
            values[i] = values[i-1];
        }
        values[0] = temp;
	}

	// c. replace even elements with zero
	public void replaceEven() {
		for(int i = 0; i < values.length; i++){
            if(values[i]%2 == 0){
                values[i] = 0;
            }
        }
	}

	// d. replace middle elements with larger of two neighbors
	public void replaceMiddle() {
        int[] valuesCopy = Arrays.copyOf(values, values.length);
        int first;
        int last;
        
		for(int i = 1; i < values.length-1; i++){
            
            first = valuesCopy[i-1];
            last = valuesCopy[i+1];
            
            if(first > last){ //first is largest of two
               values[i] =  first;
            }
            if(last > first){ //last is largest of two
                values[i] = last;
            }
            if(first == last){ //neighbors equal
                values[i] = first; //could also equal last
            }   
                
        }
	}

	// e. Remove middle one or two elements
	public void removeMiddle() {
		//even, so remove middle two
        if(values.length%2 == 0){
            int[] valuesNew = new int[values.length-2];
            int middle1 = values.length/2;
            int middle2 = values.length/2 - 1;
            int counter = 0;
            
            for(int i = 0; i < valuesNew.length; i++){
                if(counter != middle1 && counter != middle2){
                    valuesNew[i] = values[counter];
                    counter++;
                }
                else{
                    counter = counter + 2;
                    valuesNew[i] = values[counter];
                    counter++;
                }
            }
            values = valuesNew;
        }
        //odd, so remove middle one
        else{
            int[] valuesNew = new int[values.length-1];
            int middle = values.length/2;
            int counter = 0;
            
            for(int i = 0; i < valuesNew.length; i++){
                if(counter != middle){
                    valuesNew[i] = values[counter];
                    counter++;
                }
                else{
                    counter++;
                    valuesNew[i] = values[counter];
                    counter++;
                }
            }
            values = valuesNew;
        }
	}

	// f. Move even elements to the front
	public void moveEven() {
        int temp = 0;
        int index = 0;
        for(int i = 0; i < values.length; i++){
            if(values[i]%2 == 0){
                for(int j = i; j > index; j--){
                    temp = values[j-1];
                    values[j-1] = values[j];
                    values[j] = temp;
                }
                index++;
            }
        }
	}

	// g. Return second-largest element
	public int secondLargest() {
        int largest = values[0];
        int secondLargest = values[0];
        for(int i = 0; i < values.length; i++){
            if(values[i] > largest){
                secondLargest = largest;
                largest = values[i];
            }
            else if(values[i] > secondLargest){
                secondLargest = values[i]; 
            }
        }
        return secondLargest;
	}

	// h. Check if sorted in increasing order
	public boolean sortedIncreasing() {
        for(int i = 1; i < values.length; i++){
            if(values[i] < values[i-1]){
                return false;
            }  
        }
        return true;
	}

	// i. Check if contains two adjacent duplicate elements
	public boolean adjacentDups() {
        for(int i = 1; i < values.length; i++){
            if(values[i-1] == values[i]){
                return true;
            }
        }
        return false;
	}

	// j. Check if contains any duplicate elements
	public boolean containsDups() {
		//sorts the array using method from Array class
        Arrays.sort(values);
        //checks if any adjacent elements in the sorted array are the same.
        return adjacentDups();
	}



}
