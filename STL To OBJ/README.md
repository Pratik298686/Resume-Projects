3D File Converter

Overview

The 3D File Converter is a Java-based application that allows users to convert between two popular 3D file formats: STL (Stereolithography) and OBJ (Wavefront). This tool is useful for 3D modeling, printing, and other applications where different file formats are required.

Features
* STL to OBJ Conversion:
   * Converts 3D models in STL format to OBJ format.
   * Maps vertices and faces correctly while       preserving model structure.
* OBJ to STL Conversion:
   * Converts OBJ files to STL format.
   * Triangulates faces and calculates normals for 3D rendering.
* Command-Line Interface:
   * Easy-to-use text-based interface for specifying input and output files.

How It Works

STL to OBJ Conversion

1. Reads STL file data line by line.
2. Extracts vertices and faces.
3. Writes the data into an OBJ file, formatting vertices (v) and faces (f).

OBJ to STL Conversion

1. Parses the OBJ file for vertices and faces.
2. Triangulates faces (if needed).
3. Calculates surface normals for each face.
4. Writes the data into an STL file with proper formatting.

Usage

Prerequisites
* Java Development Kit (JDK) version 8 or higher.

Steps

1. Compile the Code:
   javac Main.java STLToOBJConverter.java OBJToSTLConverter.java

2. Run the Application:
* Choose the conversion type:
   1 for STL to OBJ.
   2 for OBJ to STL.
* Provide the input and output file paths.

Example
3D File Converter
1. Convert STL to OBJ
2. Convert OBJ to STL
Enter your choice (1 or 2): 1
Enter input file path: model.stl
Enter output file path: model.obj
STL to OBJ conversion completed successfully: model.obj

Project Structure
src/
├── Main.java
├── STLToOBJConverter.java
├── OBJToSTLConverter.java

File Format Details
* STL (Stereolithography):
   * Describes 3D surfaces using triangles.
   * Includes vertex coordinates and normals.
* OBJ (Wavefront):
   * Describes 3D models using vertices (v) and faces (f).
   * Supports complex geometries with more flexibility than STL.

Methods

STLToOBJConverter
* Reads STL file and maps vertices and faces.
* Outputs the OBJ format with vertex and face definitions.

OBJToSTLConverter
* Reads OBJ file and parses vertex and face data.
* Triangulates faces and calculates normals.
* Outputs the STL format with proper structure.

Future Enhancements
* Add support for additional 3D file formats like PLY and FBX.
* Provide error handling for invalid file formats.
* Implement a GUI for enhanced usability.