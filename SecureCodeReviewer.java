import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class SecureCodeReviewer {

    private static final Pattern HARDCODED_SECRET = Pattern.compile("(?i)(password|secret|api_key|token)\\s*=\\s*\"[^\"]+\"");
    private static final Pattern SQL_INJECTION = Pattern.compile("(?i).*SELECT.*FROM.*\\+.*");
    private static final Pattern UNSAFE_EXECUTION = Pattern.compile("Runtime\\.getRuntime\\(\\)\\.exec\\(");

    public static void reviewFile(String filePath) {
        System.out.println("[*] Initiating Security Scan For: " + filePath);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;
            int issuesFound = 0;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (HARDCODED_SECRET.matcher(line).find()) {
                    System.out.printf("[CRITICAL] Line %d: Hardcoded credential or API key found! -> %s\n", lineNumber, line);
                    issuesFound++;
                }

                if (SQL_INJECTION.matcher(line).find()) {
                    System.out.printf("[HIGH] Line %d: SQL Injection vulnerability. Use PreparedStatements! -> %s\n", lineNumber, line);
                    issuesFound++;
                }

                if (UNSAFE_EXECUTION.matcher(line).find()) {
                    System.out.printf("[HIGH] Line %d: Dangerous runtime system command execution detected! -> %s\n", lineNumber, line);
                    issuesFound++;
                }

                lineNumber++;
            }

            System.out.println("[*] Analysis finished. Total flaws flagged: " + issuesFound);

        } catch (IOException e) {
            System.err.println("[-] Error parsing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java SecureCodeReviewer <target_file_path>");
            return;
        }
        reviewFile(args[0]);
    }
}
