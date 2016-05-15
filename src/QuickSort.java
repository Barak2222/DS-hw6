
public class QuickSort implements Sorter{

	@Override
	public void sort(double[] ar) {
		rec(ar, 0, ar.length - 1);
	}
	
	private void rec(double[] arr, int low, int high){
		if(high - low <= 1)
	}
	
	private static int partition(double[] arr, int low, int high){
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
		if(left > high || right < low){
			return pivot;
		}
		double temp = arr[pivot];
		arr[pivot] = arr[right];
		arr[right] = temp;
		return right;
		
	}
	
	public static void main(String[] args){
		//double[] a = {0.33, 0.2, 0.4, 0.6, 0.5, 0.1, 0.0, 0.45, 0.77, 0.12};
		double[] a = {0.2, 0.4};
		System.out.println(partition(a, 0, a.length-1));
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
