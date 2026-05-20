public class palidrome {

        public static boolean isPalidrome(int x) {

            String intToString = Integer.toString(x);

            int i = 0;
            int j = intToString.length() - 1;

            while(i < j) {
                //cheeck first before traversing if the starting ends are equal first since if theyre not then it automatically not a plaidrome
                if(intToString.charAt(i) != intToString.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

        public static void main(String[] args) {
            
            int x = 22;
            boolean result = isPalidrome(x);
            System.out.println("Is " + x + " a palindrome? " + result);

        }
    }
