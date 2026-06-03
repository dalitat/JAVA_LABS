public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String vord = args[i];
            if (isPalindrome(vord)) {
                System.out.println(vord + " -> palindrome");
            } else {
                System.out.println(vord + " -> not palindrome");
            }

        }
    }

    public static String reverseString(String vord) {
        String reversed = "";
        for (int i = vord.length() - 1; i >= 0; i--) {
            reversed += vord.charAt(i);
        }
        return reversed;
    }

    public static boolean isPalindrome(String vord) {
        String reversed = reverseString(vord);
        return vord.equals(reversed);
    }
}
