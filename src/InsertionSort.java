
public class InsertionSort implements Sorter{

	@Override
	public void sort(double[] ar) {
		for(int i = 1; i < ar.length; i++){
			int k = i;
			while ( k > 0 && ar[k - 1] > ar[k]){
				double temp = ar[k-1];
				ar[k-1] = ar[k];
				ar[k] = temp;
				k--;
			}
		}
	}
}
