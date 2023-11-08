import java.io.*;
import java.util.*;

public class Macro_Pass2 {
    public static void main(String[] args) throws IOException {
        // Read the input source code file
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        // Initialize data structures to store macro definitions and arguments
        Map<String, String> macroTable = new HashMap<>();
        Map<String, List<String>> argTable = new HashMap<>();

        // Initialize an output file for expanded source code
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_code.txt"));

        // Pass-I: Process the source code to define macros
        String line;
        while ((line = reader.readLine()) != null) {
            // Check for macro definition
            if (line.startsWith("MACRO")) {
                // Parse the macro definition and store it in the macroTable
                String[] tokens = line.split("\\s+");
                String macroName = tokens[1];
                String macroDefinition = "";

                while (!(line = reader.readLine()).equals("MEND")) {
                    macroDefinition += line + "\n";
                }

                macroTable.put(macroName, macroDefinition);
            } else {
                writer.write(line + "\n");
            }
        }

        // Close the reader and open it again to re-read the source code from the beginning
        reader.close();
        reader = new BufferedReader(new FileReader("input.txt"));

        // Pass-II: Process the source code to expand macros
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("&")) {
                // This line contains a macro call
                String macroCall = line.substring(1);

                // Extract the macro name and arguments
                String[] tokens = macroCall.split("\\s+", 2);
                String macroName = tokens[0];
                String arguments = tokens.length > 1 ? tokens[1] : "";

                // Lookup the macro definition in the macroTable
                String macroDefinition = macroTable.get(macroName);

                if (macroDefinition != null) {
                    // Parse the macro arguments
                    List<String> macroArgs = Arrays.asList(arguments.split(","));

                    // Replace formal parameters in the macro definition with actual arguments
                    for (int i = 0; i < macroArgs.size(); i++) {
                        macroDefinition = macroDefinition.replace("&" + (i + 1), macroArgs.get(i));
                    }

                    // Write the expanded macro definition to the output file
                    writer.write(macroDefinition + "\n");
                }
            } else {
                // Write non-macro lines to the output file
                writer.write(line + "\n");
            }
        }

        // Close the reader and writer
        reader.close();
        writer.close();

        System.out.println("Macro expansion completed. Output written to output_code.txt");
    }
}
