package com.sapient.UseCaseBasedProblems.basic;

public class UC04_B_QuickSort {

    private int[] inputArr;

    public UC04_B_QuickSort(int[] inputArr) {
		this.inputArr = inputArr;
	}

    
    
	public int[] getInputArr() {
		return inputArr;
	}

	public void setInputArr(int[] inputArr) {
		this.inputArr = inputArr;
	}



	public void sort() {
        if (inputArr ==null || inputArr.length==0){
            return;
        }
        quicksort(0, inputArr.length - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = inputArr[low + (high-low)/2];

        while (i <= j) {
            while (inputArr[i] < pivot) {
                i++;
            }
            while (inputArr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = inputArr[i];
        inputArr[i] = inputArr[j];
        inputArr[j] = temp;
    }
    
    private void display()
    {
    	for(int n:inputArr)
    	{
    		System.out.print(n + " ");
    	}
    }
    
    public static void main(String s[])
    {
    	int[] inputArr = {5,4,6,9,3,2,1};
    	UC04_B_QuickSort qs = new UC04_B_QuickSort(inputArr);
    	qs.sort();
    	qs.display();
    }
}