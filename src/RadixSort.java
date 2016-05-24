
import java.text.DecimalFormat;

public class RadixSort implements Sorter{

	@Override
	public void sort(double[] ar) {
		String[] strs = getStringArr(ar);
				
		for (int i = 10; i > 0; i--) {
			countingSort(strs, i);
		}
		for (int i = 0; i < strs.length; i++) {
			ar[i] = Double.parseDouble(strs[i]);
		}
		
	}
	
	private static String[] getStringArr(double[] arr){
		String[] strs = new String[arr.length];
		DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(10);
        
		for (int i = 0; i < strs.length; i++) {
	        strs[i] = df.format(arr[i]);
			while(strs[i].length() < 12){
				strs[i]+= "0";
			}
		}
		return strs;
	}
	
	private static void countingSort(String[] arr, int digit){
		int[] c = new int[10];
		for(int i = 0; i < arr.length; i ++){
			int index = getDigit(arr[i], digit);
			c[index]++;
		}

		for (int i = 1; i < c.length; i++) {
			c[i]+=c[i-1];
		}
		String[] sorted = new String[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int index = getDigit(arr[i], digit);
			sorted[c[index] - 1] = arr[i];
			c[index]--;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sorted[i];
		}
	}
	
	
	private static int getDigit(String num, int digit){
		return (int) (num.charAt(digit+1) - '0');
	}

	
}
