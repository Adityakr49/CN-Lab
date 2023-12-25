import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RSACrypto {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int findCoprime(int phi) {
        int e = 2;
        while (e < phi) {
            if (gcd(e, phi) == 1) {
                return e;
            }
            e++;
        }
        return -1; // Handle the case where no coprime is found
    }

    public static int findPrivateKey(int e, int phi) {
        int d = 0;
        int k = 1;
        while (true) {
            double tempD = (1 + k * phi) / (double) e;
            if (tempD == (int) tempD) {
                d = (int) tempD;
                return d;
            }
            k++;
        }
    }

    public static int modularExp(int b, int e, int m) {
        int res = 1;
        for (int i = 0; i < e; i++) {
            res = (res * b) % m;
        }
        return res;
    }

    public static List<Integer> rsaEncrypt(String plaintext, int e, int n) {
        List<Integer> ciphertext = new ArrayList<>();
        for (char c : plaintext.toCharArray()) {
            ciphertext.add(modularExp(c, e, n));
        }
        return ciphertext;
    }

    public static String rsaDecrypt(List<Integer> ciphertext, int d, int n) {
        StringBuilder plaintext = new StringBuilder();
        for (int value : ciphertext) {
            plaintext.append((char) modularExp(value, d, n));
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int p = 17;
        int q = 23;
        int n = p * q;
        int phi = (p - 1) * (q - 1);

        int e = findCoprime(phi);
        if (e == -1) {
            System.out.println("No coprime found for the given phi.");
            return;
        }

        int d = findPrivateKey(e, phi);

        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();

        List<Integer> ct = rsaEncrypt(plaintext, e, n);
        System.out.print("Ciphertext: ");
        for (int value : ct) {
            System.out.print(value + " ");
        }
        System.out.println();

        String pt = rsaDecrypt(ct, d, n);
        System.out.println("Plaintext: " + pt);
    }
}

