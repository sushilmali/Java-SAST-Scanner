\# 🛡️ Java-Based Static Application Security Testing (SAST) Scanner



\## 📌 Project Overview

An automated, lightweight command-line security auditing engine engineered in \*\*Java\*\*. This tool scans application source code line-by-line using regular expression engines to discover systemic security vulnerabilities, hardcoded credentials, and high-risk injection flaws before code hits production \[3.1].



\## ⚡ Core Capabilities

\* \*\*Credential Leak Detection:\*\* Scans codebase strings for hardcoded passwords, database secrets, and private API keys.

\* \*\*SQL Injection (SQLi) Identification:\*\* Flags unsafe string concatenations inside raw SQL strings to encourage developers to use secure `PreparedStatements` \[3.1].

\* \*\*Command Injection Controls:\*\* Highlights risky system-level process execution functions like `Runtime.getRuntime().exec()`.



\## 🛠️ Tech Stack \& Architecture

\* \*\*Language:\*\* Java (JDK 17+)

\* \*\*Engine:\*\* Java Regex Parsing Engine (`java.util.regex`)

\* \*\*Environment:\*\* Command-Line Interface (CLI)



\## 🚀 Future Roadmap

\* Scale analysis rules to map directly against the complete \*\*OWASP Top 10\*\* vulnerabilities \[3.1].

\* Implement JSON/HTML log parsing reports optimized for automated DevSecOps CI/CD pipelines \[4.1].

## 💻 How to Run the Scanner Local Labs

To execute a local static security audit against any target source file, open your system terminal inside the root project directory and execute these core compilation and execution commands:

### 1. Compile the Scanning Engine
```bash
javac --release 17 SecureCodeReviewer.java
```

### 2. Execute the Security Audit
```bash
java SecureCodeReviewer VulnerableApp.java
```


