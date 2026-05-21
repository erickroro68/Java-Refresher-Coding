
public class ScoreSorter {
  public static void main(String[] args) {
    int[] answer = scoreSorter(new int[]{1, 2, 3, 9999, 13}, 10000);
    for (int i = 0; i < answer.length; i++) {
      System.out.println(answer[i]);
    }
  }

  public static int[] scoreSorter(int[] array, int topScore) {
    int[] scoresCount = new int[topScore + 1];

    for (int i = 0; i < array.length; i++) {
      int score = array[i];
      scoresCount[score]++;
    }

    int[] finalCount = new int[array.length];
    int sortedIndex = 0;

    for (int score = topScore; score >= 0; score--) {
      for (int count = 0; count < scoresCount[score]; count++) {
        finalCount[sortedIndex] = score;
        sortedIndex++;
      }
    }

    return finalCount;
  }
}