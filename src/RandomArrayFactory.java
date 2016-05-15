
public class RandomArrayFactory {
	public static double[] getRandomArray(int size){
		double[] arr = new double[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = round(Math.random(), 10);
		}
		return arr;
	}
	
	/**
	 * utility function that rounds n digits after the point
	 * @param value to be round
	 * @param places how many digits
	 * @return
	 */
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public static void printArr(double[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void printArr(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	public static void test(Sorter obj){
		double[] arr = RandomArrayFactory.getRandomArray(10);
		RandomArrayFactory.printArr(arr);
		System.out.println();
		obj.sort(arr);
		RandomArrayFactory.printArr(arr);
	}
	
	public static void test(Selector obj){
		double[] arr = RandomArrayFactory.getRandomArray(10);
		RandomArrayFactory.printArr(arr);
		System.out.println();
		double d = obj.select(arr, 10);
		System.out.println(d);
	}	
	
	public static void main(String[] args){
		//Sorter obj = new RadixSort();
		Selector obj = new RandSelect();
		test(obj);
	}
}
