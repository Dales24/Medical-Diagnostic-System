# Medical Diagnostic System

A symptom-based **medical diagnosis** demo built on the [Weka](https://www.cs.waikato.ac.nz/ml/weka/)
machine-learning library. Given a set of yes/no symptoms, it classifies whether a patient likely has a
cold. A small Java Swing window walks the user through the symptom questions and shows the predicted
result.

> **Status:** Academic **team prototype** — built as a semester project for **CSC 340: Artificial
> Intelligence** at **Salem State University (Spring 2018)**. It demonstrates the Weka classifier
> workflow end to end; it is a learning exercise, **not** a validated clinical tool.

## ⚠️ Not for medical use

This is a student project trained on **randomly generated synthetic data**. It makes no real medical
claims and must not be used for any actual diagnosis.

## How it works

The model predicts the class **`cold` (yes / no)** from five boolean symptoms:

| Symptom       | Values      |
|---------------|-------------|
| Runny nose    | True / False |
| Cough         | True / False |
| Stomach aches | True / False |
| Fever         | True / False |
| Chills        | True / False |

The pipeline: generate training rows → save as an ARFF/CSV dataset → train a Weka classifier →
classify new symptom sets → present the result in the GUI.

## Project layout

```
Medical-Diagnostic-System/
└─ MedicalDiagnosticSystem/          # NetBeans (Ant) Java project
   ├─ src/
   │  ├─ medicaldiagnosticsystem/
   │  │  └─ MedicalDiagnosticSystem.java   # application entry point (main)
   │  ├─ Interface.java / Interface.form    # Swing GUI: symptom questions + YES/NO + result
   │  ├─ WekaWrapper.java                   # custom classifier extending Weka's AbstractClassifier
   │  ├─ TestClassifier.java                # loads an ARFF file and classifies each instance
   │  └─ Data.java                          # generates 100 rows of random synthetic training data
   ├─ weka.jar / weka-src.jar               # Weka library (dependency + its source)
   ├─ Classifier4J-0.6.jar                  # text-classification helper library
   ├─ build.xml / manifest.mf               # Ant build script + jar manifest
   └─ nbproject/                            # NetBeans project metadata
```

## Requirements

- **JDK 8** (the project targets the Java 8 era; Swing + Weka 3.x).
- **Apache Ant**, or **NetBeans 8.x** (this is a NetBeans Ant project), or **IntelliJ IDEA**
  (a `.idea/`/`.iml` config is also present).
- The `weka.jar` and `Classifier4J-0.6.jar` dependencies are bundled in the repo — no download needed.

## Build & run

**With NetBeans:** open the `MedicalDiagnosticSystem/` folder as a project, then *Run*.

**With Ant (command line):**
```bash
cd MedicalDiagnosticSystem
ant clean jar
java -cp "dist/MedicalDiagnosticSystem.jar:weka.jar:Classifier4J-0.6.jar" medicaldiagnosticsystem.MedicalDiagnosticSystem
```

To launch the GUI directly, run the `Interface` class. To regenerate a synthetic dataset, run
`Data.java` and redirect its output to a CSV, then convert/label it as an `.arff` for Weka.

## Known issues / rough edges

This is old prototype code; a few things need attention before it runs cleanly:

- **Missing dataset.** `TestClassifier.java` reads `medicalDiagnosticSystem.arff`, but that file is not
  in the repo. Generate one from `Data.java` (add an ARFF header) before running the classifier.
- **Hard-coded absolute path.** `TestClassifier.java` points at a specific developer's local machine.
  Replace it with a relative path to the dataset.
- **Empty entry point.** `MedicalDiagnosticSystem.main()` is a stub — the runnable pieces are the
  `Interface` (GUI) and `TestClassifier` (batch) classes.
- **`Data.java` prints to stdout** rather than writing a file; pipe it to a `.csv` to capture the data.

## Authors

Team project by **patrickdaley1** and **ejvalente17** — Salem State University, CSC 340 (Spring 2018).
