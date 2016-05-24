
public class MergeSort implements Sorter {

	@Override
	public void sort(double[] ar) {
		rec(ar, 0, ar.length - 1);
	}

	public void rec(double[] arr, int low, int high) {
		if (high - low <= 0) {
			return;
		}
		if (high - low == 1) {
			if (arr[low] > arr[high]) {
				double temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
			return;
		}
		int mid = (high + low) / 2;
		rec(arr, low, mid);
		rec(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	public void merge(double[] arr, int low, int mid, int high) {

		double[] temp1 = new double[mid - low + 1 + 1];
		double[] temp2 = new double[high - (mid + 1) + 1 + 1];
		for (int k = 0; k < temp1.length - 1; k++) {
			temp1[k] = arr[low + k];
		}
		for (int k = 0; k < temp2.length - 1; k++) {
			temp2[k] = arr[mid + 1 + k];
		}
		temp1[temp1.length - 1] = Double.MAX_VALUE;
		temp2[temp2.length - 1] = Double.MAX_VALUE;
		int i = 0;
		int j = 0;

		for (int t = 0; t < high - low + 1; t++) {
			if (temp1[i] < temp2[j]) {
				arr[t + low] = temp1[i];
				i++;
			} else {
				arr[t + low] = temp2[j];
				j++;
			}
		}
	}

}
