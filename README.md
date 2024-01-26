### Readability Score Analyzer

The Readability Score Analyzer is a Java application designed to evaluate the readability of English texts. It employs four distinct metrics: the Automated Readability Index (ARI), Flesch–Kincaid readability tests, the Simple Measure of Gobbledygook (SMOG) index, and the Coleman–Liau index. These metrics offer insights into the text's complexity, correlating with an educational grade level required for comprehension.

#### Features
- **Automated Readability Index (ARI)**
- **Flesch–Kincaid Readability Tests**
- **Simple Measure of Gobbledygook (SMOG)**
- **Coleman–Liau Index**

#### Algorithms

##### Automated Readability Index (ARI)
\forall x \in X, \quad \exists y \leq \epsilon
##### Flesch–Kincaid Readability Tests
\[ \text{FK} = 0.39 \left( \frac{\text{words}}{\text{sentences}} \right) + 11.8 \left( \frac{\text{syllables}}{\text{words}} \right) - 15.59 \]

##### Simple Measure of Gobbledygook (SMOG)
\[ \text{SMOG} = 1.043 \sqrt{\text{polysyllables} \times \frac{30}{\text{sentences}}} + 3.1291 \]

##### Coleman–Liau Index
\[ \text{CLI} = 0.0588 \times L - 0.296 \times S - 15.8 \]
where \( L \) is the average number of letters per 100 words and \( S \) is the average number of sentences per 100 words.

#### Getting Started

1. **Preparation**: Ensure you have Java installed on your system.
2. **Download**: Clone or download this repository to your local machine.
3. **Text File**: Prepare a `.txt` file with the text you want to analyze. Ensure it is placed in the same directory as the Java program.
4. **Compilation**: Open a terminal or command prompt, navigate to the project's `src` directory, and compile the Java program:
    ```bash
    javac Main.java
    ```
5. **Execution**: Run the program with the text file as a command-line argument:
    ```bash
    java Main yourTextFile.txt
    ```
   Replace `yourTextFile.txt` with the name of your actual text file.

#### Running the Program

To analyze the readability of `QuantumMechanics.txt` located in the `src` folder, execute the following command in the terminal or command prompt from the `src` directory:

```bash
java Main QuantumMechanics.txt
```

The program will output readability scores based on the implemented algorithms along with the estimated age/grade level for each score.

#### Contributing

Contributions to the Readability Score Analyzer are welcome! Feel free to fork the repository, make improvements, and submit pull requests.

#### License

This project is open-source and available under the MIT License.
