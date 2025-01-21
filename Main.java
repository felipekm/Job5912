import java.util.List;
import java.util.ArrayList;

public class LicenseKeyFormatting {
    public static String formatLicenseKey(String S, int K) {
        String cleaned = S.replaceAll("-", "").toUpperCase();
        List<String> parts = new ArrayList<>();

        int firstGroupLength = cleaned.length() % K == 0 ? K : cleaned.length() % K;

        parts.add(cleaned.substring(0, firstGroupLength));

        for (int i = firstGroupLength; i < cleaned.length(); i += K) {
            parts.add("-");
            parts.add(cleaned.substring(i, Math.min(i + K, cleaned.length())));
        }

        StringBuilder result = new StringBuilder();

        return result.append(String.join("", parts)).toString();
    }

    public static void main(String[] args) {
        String S = "5F3Z-2e-9-w";
        int K = 4;

        String formattedKey = formatLicenseKey(S, K);
        System.out.println("Formatted License Key: " + formattedKey);

        String S2 = "2-5g-3-J";
        int K2 = 2;

        String formattedKey2 = formatLicenseKey(S2, K2);
        System.out.println("Formatted License Key2: " + formattedKey2);
    }
}
