
public class Test {
	public static void main(String[] args){
		double[] arr = RandomArrayFactory.getRandomArray(400);
		Sorter s = new RadixSort();
		s.sort(arr);
		isSorted(arr);
	}
	
	private static void isSorted(double[] arr){
		for (int i = 1; i < arr.length; i++) {
			if(arr[i - 1] > arr[i]){
				System.out.println("Problem at index " + i);
				return ;
			}
		}
		System.out.println("Sorted properly");
	}
	
}
