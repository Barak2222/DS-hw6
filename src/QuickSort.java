
public class QuickSort implements Sorter{

	@Override
	public void sort(double[] ar) {
		rec(ar, 0, ar.length - 1);
	}
	
	private void rec(double[] arr, int low, int high){
		if(high - low <= 0)
			return ;
		if(high - low == 1){
			if(arr[low] > arr[high]){
				double temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
			return ;
		}
		int pivot = partition(arr, low, high);
		rec(arr, low, pivot);
		rec(arr, pivot + 1, high);
	}
	
	public static int partition(double[] arr, int low, int high){
		int pivot = low;
		int left = low+1;
		int right = high;
		while(left < right){
			while(left <= high && arr[left] < arr[pivot]){
				left++;
			}
			while(right >= low && arr[right] > arr[pivot]){
				right--;
			}
			if(left < right && right >= low && left <= high){
				double temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		if(right < low){
			return pivot;
		}
		if(left > high){
			double temp = arr[pivot];
			arr[pivot] = arr[left - 1];
			arr[left - 1] = temp;
			return left - 1;
		}
		double temp = arr[pivot];
		arr[pivot] = arr[right];
		arr[right] = temp;
		return right;
	}
	
	public static void main(String[] args){
		//double[] a = {0.33, 0.2, 0.4, 0.6, 0.5, 0.1, 0.0, 0.45, 0.77, 0.12};
		double[] a = {0.2, 0.4, 0.6};
		System.out.println(partition(a, 0, a.length-1));
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
