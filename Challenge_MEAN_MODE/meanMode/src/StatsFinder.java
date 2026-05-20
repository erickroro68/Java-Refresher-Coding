

public class StatsFinder {
  public static void main(String[] args) {
    double[] ans = statsFinder(new int[]{500, 400, 400, 375, 300, 350, 325, 300});
    System.out.println(ans[0]);
    System.out.println(ans[1]);
  }

  public static double[] statsFinder(int[] array) {
    // Write your code here

    double sum = 0;

    for(int i =0; i < array.length; i++) {
      //need to add all array indexes into our double sum
        sum += array[i];
    }
    double mean = sum / array.length;


    double mode = array[0];
    int mostSeenNum = 0;
    
    for(int i = 0; i < array.length; i ++) {

        int currentCount = 0;

        for(int j = i + 1; j<array.length; j++) {

            if(array[i] == array[j]) {
                currentCount++;

            }
        }
        if(currentCount > mostSeenNum) {
            mostSeenNum = currentCount;
            mode = array[i];
        }
    }

    return new double[] {mean,mode};
    
  }
}