class ChallengeClass {
    public static int decimalToBinary(int n) {
        // Write your code here

        if (n == 0){
            return 0;
        }

        return (n % 2) + 10 * (decimalToBinary(n / 2));
    }
}