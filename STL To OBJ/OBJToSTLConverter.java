import java.io.*;
import java.util.*;

public class OBJToSTLConverter {

    public static void convert(String objFilePath, String stlFilePath) {
        try (BufferedReader objReader = new BufferedReader(new FileReader(objFilePath));
             BufferedWriter stlWriter = new BufferedWriter(new FileWriter(stlFilePath))) {
    
            List<float[]> vertices = new ArrayList<>();
            List<int[]> faces = new ArrayList<>();
    
            String line;
            while ((line = objReader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("v ")) {
                    // Parse vertex
                    String[] parts = line.split("\\s+");
                    float x = Float.parseFloat(parts[1]);
                    float y = Float.parseFloat(parts[2]);
                    float z = Float.parseFloat(parts[3]);
                    vertices.add(new float[]{x, y, z});
                } else if (line.startsWith("f ")) {
                    // Parse face
                    String[] parts = line.split("\\s+");
                    int[] face = new int[parts.length - 1];
                    for (int i = 1; i < parts.length; i++) {
                        // Split the face component and take the first part (vertex index)
                        String[] indices = parts[i].split("/");
                        face[i - 1] = Integer.parseInt(indices[0]) - 1; // Convert to 0-based index
                    }
                    if (face.length > 3) {
                        // Triangulate face (if it's not a triangle)
                        for (int i = 1; i < face.length - 1; i++) {
                            faces.add(new int[]{face[0], face[i], face[i + 1]});
                        }
                    } else {
                        faces.add(face);
                    }
                }
            }
    
            stlWriter.write("solid obj_to_stl\n");
    
            for (int[] face : faces) {
                float[] v1 = vertices.get(face[0]);
                float[] v2 = vertices.get(face[1]);
                float[] v3 = vertices.get(face[2]);
                float[] normal = calculateNormal(v1, v2, v3);
    
                stlWriter.write("facet normal " + normal[0] + " " + normal[1] + " " + normal[2] + "\n");
                stlWriter.write("  outer loop\n");
                stlWriter.write("    vertex " + v1[0] + " " + v1[1] + " " + v1[2] + "\n");
                stlWriter.write("    vertex " + v2[0] + " " + v2[1] + " " + v2[2] + "\n");
                stlWriter.write("    vertex " + v3[0] + " " + v3[1] + " " + v3[2] + "\n");
                stlWriter.write("  endloop\n");
                stlWriter.write("endfacet\n");
            }
    
            stlWriter.write("endsolid obj_to_stl\n");
    
            System.out.println("OBJ to STL conversion completed: " + stlFilePath);
    
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    

    private static float[] calculateNormal(float[] v1, float[] v2, float[] v3) {
        float[] u = {v2[0] - v1[0], v2[1] - v1[1], v2[2] - v1[2]};
        float[] v = {v3[0] - v1[0], v3[1] - v1[1], v3[2] - v1[2]};
        float nx = u[1] * v[2] - u[2] * v[1];
        float ny = u[2] * v[0] - u[0] * v[2];
        float nz = u[0] * v[1] - u[1] * v[0];
        float length = (float) Math.sqrt(nx * nx + ny * ny + nz * nz);
        return new float[]{nx / length, ny / length, nz / length};
    }
}
