import groovy.csv.CsvParser

// Define the pattern to search for in the name field
def pattern = "John"

// Define the path to the CSV file
def filePath = "/path/to/file.csv"

// Define the path to the output file
def outputFile = "/path/to/output.csv"

// Open the input CSV file and create the output CSV file
def inputCsv = new File(filePath).newReader()
def outputCsv = new File(outputFile).newWriter()

// Create a CSV parser for the input file
def parser = new CsvParser()

// Read each row of the CSV file
parser.parse(inputCsv).each { row ->
  // Check if the name field contains the pattern
  if (!row.name.contains(pattern)) {
    // If the name field does not contain the pattern, write the row to the output file
    outputCsv.writeLine(row.join(','))
  }
}

// Close the input and output CSV files
inputCsv.close()
outputCsv.close()
