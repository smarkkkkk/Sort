package sort;

public class Sort {
	
	public void swap(int[] array,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public void quickSort(int[] array,int left,int right){
		
		int i=left , j=right;
		int pivot = array[left];
		while(i<j){
			while(i<j && array[j]>=pivot){
				j--;
			}
			if(i<j){				
				swap(array, i, j);
				i++;
			}
			
			while(i<j && array[i]<=pivot){
				i++;
			}
			if(i<j){
				swap(array, i, j);
				j--;
			}
		}
		//务必加判断语句 否则会导致无限调用 栈溢出
		if(i>left){
			quickSort(array, left, j-1);
		}
		if(j<right){
			quickSort(array, j+1, right);
		}
	}
	
	public void bubbleSort(int[] array){
		
		for(int i=array.length-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if(array[j]>array[j+1]){
					swap(array, j+1, j);
				}
			}
		}
	}
	
	public void mergeSort(int[] array, int left, int right){
		
		//当数组中只有一个元素时 返回 开始归并
		if(right == left){
			return;
		}
		//切记 mid的计算方法为(左+右)/2
		int mid = (right+left)/2;
		//对左右2个子数组递归排序
		mergeSort(array, left, mid);
		mergeSort(array, mid+1, right);
		//归并两个有序的子数组
		merge(array, left, mid, right);
		
	}
	
	//归并方法
	public void merge(int[] array,int left,int mid, int right){
		
		int i=left;//左数组起始标志
		int j=mid+1;//右数组起始标志
		int[] temp = new int[right-left+1];//存放归并结果
		int index=0;//遍历有序数组的游标
		
		//左右两数据都是有序的，选择较小的放入有序数组中
		while(i<=mid && j<=right){
			//切记遍历时的自加操作
			temp[index++] = (array[i]<=array[j])?array[i++]:array[j++];
		}
		//左右数组长度可能不一致，需要再次检测
		while(i<=mid){
			temp[index++] = array[i++];
		}
		while(j<=right){
			temp[index++] = array[j++];
		}
		//将有序数组重新填入原数组left->right的范围内
		for(index = 0;left<=right;left++){
			array[left] = temp[index++];
		}	
	}
	
	public void selectSort(int[] array)
	{
		for(int i=0;i<array.length;i++){
			for(int j=i;j<array.length;j++){
				if(array[i]>array[j]){
					swap(array, i, j);
				}
			}
		}
	}
	
	public void insertSort(int[] array){
		
		for(int i=1;i<array.length;i++){
			int j=i-1;
			//切记此处需要用get保存当前值，因为i位置的数字会因有序序列的右移被覆盖
			int get = array[i];
			while(j>=0 && get<array[j]){
				array[j+1] = array[j];
				j--;
			}
			//跳出while循环的条件是j位置的数不满足条件，即比当前值小（或者j=-1），所以插入时的位置为j+1
			array[j+1] = get;
		}
	}
	
	
	public void heapSort(int[] array){
		buildHeap(array);
		int size = array.length-1;
		while(size>0){
			//大顶堆堆顶和堆尾交换，堆size--
			swap(array, 0, size--);
			//对新堆进行堆化
			heapify(array,0, size);
		}
	}
	
	public void buildHeap(int[] array){		
		//从最后一个非叶子结点开始
		for(int i=array.length/2-1;i>=0;i--){
			heapify(array, i, array.length-1);
		}
		
	}
	
	//由当前结点向下堆化
	public void heapify(int[] array, int i, int size){
		
		int left = 2*i+1;
		int right = 2*i+2;
		int maxIndex = i;
		int max = array[i];
		if(right<=size){
			maxIndex = (array[i]>array[right])?i:right;
			max = (array[i]>array[right])?array[i]:array[right];
		}
		if(left<=size){
			maxIndex = (max>array[left])?maxIndex:left;
		}
		//切记 此条件必须进行判断，否则无限调用，内存堆溢出
		if(maxIndex!=i){
			//和maxIndex交换 maxIndex继续向下堆化
			swap(array, i, maxIndex);
			heapify(array, maxIndex, size);
		}
	}
	
	
}

