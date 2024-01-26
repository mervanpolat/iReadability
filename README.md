# Readability Score Analyzer

The Readability Score Analyzer is a Java-based tool designed to assess the readability of English texts. It employs several well-known algorithms to provide insights into the text's complexity, correlating it with an educational grade level necessary for comprehension. This tool is invaluable for educators, writers, and content creators aiming to tailor their content to a specific audience's understanding.

## Features

This application calculates readability scores based on the following metrics:

- Automated Readability Index (ARI)
- Flesch–Kincaid Readability Tests
- Simple Measure of Gobbledygook (SMOG)
- Coleman–Liau Index

## Algorithms

### Automated Readability Index (ARI)
![ARI Formula](https://latex.codecogs.com/svg.latex?%5CLARGE%20ARI%20%3D%204.71%20%5Ctimes%20%5Cfrac%7B%5Ctext%7Bcharacters%7D%7D%7B%5Ctext%7Bwords%7D%7D%20&plus;%200.5%20%5Ctimes%20%5Cfrac%7B%5Ctext%7Bwords%7D%7D%7B%5Ctext%7Bsentences%7D%7D%20-%2021.43)

### Flesch–Kincaid Readability Tests
![FK Formula](https://latex.codecogs.com/svg.latex?%5CLARGE%20FK%20%3D%200.39%20%5Ctimes%20%5Cfrac%7B%5Ctext%7Bwords%7D%7D%7B%5Ctext%7Bsentences%7D%7D%20&plus;%2011.8%20%5Ctimes%20%5Cfrac%7B%5Ctext%7Bsyllables%7D%7D%7B%5Ctext%7Bwords%7D%7D%20-%2015.59)

### Simple Measure of Gobbledygook (SMOG)
![SMOG Formula](https://latex.codecogs.com/svg.latex?%5CLARGE%20SMOG%20%3D%201.043%20%5Csqrt%7B%5Ctext%7Bpolysyllables%7D%20%5Ctimes%20%5Cfrac%7B30%7D%7B%5Ctext%7Bsentences%7D%7D%7D%20&plus;%203.1291)

### Coleman–Liau Index
![CLI Formula](https://latex.codecogs.com/svg.latex?%5CLARGE%20CLI%20%3D%200.0588%20%5Ctimes%20L%20-%200.296%20%5Ctimes%20S%20-%2015.8)

*Note: In the Coleman–Liau Index, \( L \) represents the average number of letters per 100 words, and \( S \) represents the average number of sentences per 100 words.*

## Getting Started

To use the Readability Score Analyzer, follow these steps:

1. Ensure Java is installed on your system.
2. Clone or download this repository to your local machine.
3. Prepare a `.txt` file with the text you wish to analyze and place it in the same directory as the Java program.
4. Open a terminal or command prompt, navigate to the project's directory, and compile the Java program:
    ```
    javac Main.java
    ```
5. Run the program with the text file as an argument:
    ```
    java Main yourTextFile.txt
    ```

Replace `yourTextFile.txt` with the name of your actual text file.

## Contributing

We welcome contributions to the Readability Score Analyzer! Feel free to fork the repository, make improvements, and submit pull requests.

## License

This project is open-source and available under the MIT License.
