
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
		//RandomArrayFactory.printArr(sorted);
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
	
	
	
	public static void main(String[] args){
		double d = 0.1230567891;
		double[] arr = {
				0.3577777777,
				0.3433333333,
				0.2444444445,
				0.2644444445,
				0.3544444445,
				0.1411111111,
				0.1522222222,
		};
		countingSort(arr, 2);
		countingSort(arr, 1);
	}

}
