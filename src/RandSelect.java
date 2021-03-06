
public class RandSelect implements Selector {

	@Override
	public double select(double[] ar, int i) {
		return rec(ar, 0, ar.length - 1, i - 1);
	}

	private static double rec(double[] arr, int low, int high, int rank) {
		if (high - low == 0) {
			return arr[high];
		}
		if (high - low <= 1) {
			return (low == rank) ? Math.min(arr[low], arr[high]) : Math.max(arr[low], arr[high]);
		}

		// Same partition method as used in quicksort
		int pivot = QuickSort.partition(arr, low, high);
		if (pivot == rank) {
			return arr[pivot];
		}
		if (rank < pivot) {
			return rec(arr, low, pivot, rank);
		}
		return rec(arr, pivot + 1, high, rank);
	}
}
