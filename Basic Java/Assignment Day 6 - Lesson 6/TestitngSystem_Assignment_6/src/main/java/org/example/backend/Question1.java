package question1;

public class Question1 {
	public static void main(String[] args) {
		/*a) Trong function getMaxValue, hãy tìm xem tại vòng lặp i = 4 thì
		variable maxValue đang có giá trị bao nhiêu -> -1
		b) Tại vòng lặp i = 4, hãy thử set lại maxValue = 5
		c) Hãy tìm bug và sửa lại cho bài trên để tìm Max Value và Min
		Value cho đúng*/
		int[] numbers = { -1, 1, 3, 5, -5, -8 };
		int maxValue = getMaxValue(numbers);
		int minValue = getMinValue(numbers);

		System.out.println("Max Value: " + maxValue);
		System.out.println("Min Value: " + minValue);
	}

	public static int getMaxValue(int[] numbers) {
		int maxValue = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < maxValue) { // Bug ở đây ^^ -> numbers[i] > maxValue
				maxValue = numbers[i];
			}
		}
		return maxValue;
	}

	public static int getMinValue(int[] numbers) {
		int minValue = numbers[0];
		for (int i = 1; i < numbers.length - 1; i++) { //Bug ở numbers.length -1 -> i < numers.lengh
			if (numbers[i] < minValue) {
				minValue = numbers[i];
			}
		}
		return minValue;
	}
}
