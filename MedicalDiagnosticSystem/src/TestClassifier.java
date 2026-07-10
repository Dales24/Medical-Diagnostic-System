
import java.io.BufferedReader;
import java.io.FileReader;

import weka.core.Instances;

public class TestClassifier {
	public static void main(String[] args) {
		WekaWrapper ww = new WekaWrapper();
		try {
			Instances unlabeled = new Instances(new BufferedReader(
					new FileReader("/Users/ejvalente17/Documents/Salem State University/SSU Spring 2018/CSC 340 Artificial Intelligence/Semester Project/medicalDiagnosticSystem.arff")));

			unlabeled.setClassIndex(unlabeled.numAttributes() - 1);
			
			for (int i = 0; i < unlabeled.numInstances(); i++) {
				double clsLabel = ww.classifyInstance(unlabeled.instance(i));
				System.out.println(clsLabel + " -> " + unlabeled.classAttribute().value((int) clsLabel));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
