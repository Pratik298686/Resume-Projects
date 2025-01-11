import java.io.*;
import java.util.*;

public class STLToOBJConverter {

    public static void convert(String stlFilePath, String objFilePath) {
        try (
            BufferedReader stlReader = new BufferedReader(new FileReader(stlFilePath));
            BufferedWriter objWriter = new BufferedWriter(new FileWriter(objFilePath))
        ) {
            Map<String, Integer> vertexMap = new HashMap<>();
            List<String> vertices = new ArrayList<>();
            List<String> faces = new ArrayList<>();
            int vertexIndex = 1;

            String line;
            while ((line = stlReader.readLine()) != null) {
                line = line.trim();
                
                // Process vertex lines
                if (line.startsWith("vertex")) {
                    String vertex = line.substring(7).trim();
                    if (!vertexMap.containsKey(vertex)) {
                        vertexMap.put(vertex, vertexIndex++);
                        vertices.add(vertex);
                    }
                }
                
                // Process endfacet to form a face
                else if (line.startsWith("endfacet")) {
                    // Collect the last three vertices added to the vertexMap
                    int size = vertexMap.size();
                    String face = "f " + (size - 2) + " " + (size - 1) + " " + size;
                    faces.add(face);
                }
            }

            // Write vertices to the OBJ file
            for (String vertex : vertices) {
                objWriter.write("v " + vertex + "\n");
            }

            // Write faces to the OBJ file
            for (String face : faces) {
                objWriter.write(face + "\n");
            }

            System.out.println("STL to OBJ conversion completed successfully: " + objFilePath);

        } catch (IOException e) {
            System.err.println("Error during STL to OBJ conversion:");
            e.printStackTrace();
        }
    }
}
