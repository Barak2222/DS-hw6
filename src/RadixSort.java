
public class RadixSort implements Sorter{

	@Override
	public void sort(double[] ar) {
		for (int i = 10; i > 0; i--) {
			countingSort(ar, i);
		}
		
	}
	
	private static void countingSort(double[] arr, int digit){
		int[] c = new int[10];
		for(int i = 0; i < arr.length; i ++){
			int index = getDigit(arr[i], digit);
			c[index]++;
		}

		for (int i = 1; i < c.length; i++) {
			c[i]+=c[i-1];
		}
		double[] sorted = new double[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int index = getDigit(arr[i], digit);
			sorted[c[index] - 1] = arr[i];
			c[index]--;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sorted[i];
		}
	}
	
	
	private static int getDigit(double num, int digit){
		num = num * Math.pow(10, digit);
		num = num % 10;
		num = Math.floor(num);
		return (int) num;
	}

}
