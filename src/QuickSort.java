
public class QuickSort implements Sorter {

	@Override
	public void sort(double[] ar) {
		rec(ar, 0, ar.length - 1);
	}

	private void rec(double[] arr, int low, int high) {
		if (high - low <= 0)
			return;
		if (high - low == 1) {
			if (arr[low] > arr[high]) {
				double temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
			return;
		}
		int pivot = partition(arr, low, high);
		rec(arr, low, pivot - 1);
		rec(arr, pivot + 1, high);
	}

	public static int partition(double[] arr, int low, int high) {
		int pivot = low;
		int left = low + 1;
		int right = high;
		while (left < right) {
			while (left <= high && arr[left] < arr[pivot]) {
				left++;
			}
			while (right >= low && arr[right] > arr[pivot]) {
				right--;
			}
			if (left < right && right >= low && left <= high) {
				double temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		if (right < low) {
			return pivot;
		}
		if (left > high) {
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

}
