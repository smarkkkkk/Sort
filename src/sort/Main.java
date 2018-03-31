package sort;

public class Main {
	
	public static void main(String[] args){
		
		int[] array = {6,4,5};
		Sort sort = new Sort();
		//sort.quickSort(array, 0, array.length-1);
		//sort.bubbleSort(array);
		//sort.mergeSort(array, 0, array.length-1);
		//sort.selectSort(array);
		//sort.insertSort(array);
		sort.heapSort(array);
		print(array);

		
	}
	
	public static void print(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]+" ");
		}
	}

}
