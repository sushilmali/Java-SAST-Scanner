public class VulnerableApp {
    private String apiKey = "secret_api_key_xyz123"; // Intentional Hardcoded Secret

    public void processUser(String userInput) {
        // Intentional SQL Injection Flaw via string concatenation
        String query = "SELECT * FROM users WHERE id = " + userInput;
        System.out.println("Executing: " + query);
        
        try {
            // Intentional Command Injection Flaw via unsafe runtime execution
            Runtime.getRuntime().exec("ping " + userInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
