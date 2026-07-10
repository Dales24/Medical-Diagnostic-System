/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author patrickdaley1
 */

//To handle certain types of attributes, missing values, types of classes, etc.
import weka.core.Capabilities;
//Interface for representing an Instance.
import weka.core.Instance;
//To handle an ordered set of weighted instances.
import weka.core.Instances;
//Contains  utility functions for handling revisions.
import weka.core.RevisionUtils;
//All schemes for numeric or nominal prediction in Weka extend this class.
import weka.classifiers.AbstractClassifier;

//Declares class WekaWrapper using inheritance from AbstractClassifier.
public class WekaWrapper
        extends AbstractClassifier
{

    /**
     * Returns only the toString() method.
     *
     * @return a string describing the classifier
     */
    //Returns the javadoc comments generated from class.
    public String globalInfo()
    {
        return toString();
    }

    /**
     * Returns the capabilities of this classifier.
     *
     * @return the capabilities
     */
    
    //Returns all the classes capabilities.
    public Capabilities getCapabilities()
    {
        weka.core.Capabilities result = new weka.core.Capabilities(this);

        result.enable(weka.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
        result.enable(weka.core.Capabilities.Capability.NUMERIC_ATTRIBUTES);
        result.enable(weka.core.Capabilities.Capability.DATE_ATTRIBUTES);
        result.enable(weka.core.Capabilities.Capability.MISSING_VALUES);
        result.enable(weka.core.Capabilities.Capability.NOMINAL_CLASS);
        result.enable(weka.core.Capabilities.Capability.MISSING_CLASS_VALUES);

        result.setMinimumNumberInstances(0);

        return result;
    }

    /**
     * only checks the data against its capabilities.
     *
     * @param i the training data
     */
    
    //Generates a classifier that must initialize all the fields not being set through options. Must not change data.
    public void buildClassifier(Instances i) throws Exception
    {
        // can classifier handle the data?
        getCapabilities().testWithFail(i);
    }

    /**
     * Classifies the given instance.
     *
     * @param i the instance to classify
     * @return the classification result
     */
    
    //Classifies a given test instance. Must belong to a dataset when being classified. Needs to be implemented or distributionForInstance().
    public double classifyInstance(Instance i) throws Exception
    {
        Object[] s = new Object[i.numAttributes()];

        for (int j = 0; j < s.length; j++)
        {
            if (!i.isMissing(j))
            {
                if (i.attribute(j).isNominal())
                {
                    s[j] = new String(i.stringValue(j));
                }
                
                else if (i.attribute(j).isNumeric())
                {
                    s[j] = new Double(i.value(j));
                }
            }
        }

        // set class value to missing
        s[i.classIndex()] = null;

        return WekaClassifier.classify(s);
    }

    /**
     * Returns the revision string.
     *
     * @return the revision
     */
    
    //Returns the revision string.
    public String getRevision()
    {
        return RevisionUtils.extract("1.0");
    }

    /**
     * Returns only the classnames and what classifier it is based on.
     *
     * @return a short description
     */
    
    //Returns class name and wrapper.
    public String toString()
    {
        return "Auto-generated classifier wrapper, based on weka.classifiers.trees.J48 (generated with Weka 3.8.2).\n" + this.getClass().getName() + "/WekaClassifier";
    }

    /**
     * Runs the classfier from command line.
     *
     * @param args the command line arguments
     */
    
    //Declares main method.
    public static void main(String args[])
    {
        runClassifier(new WekaWrapper(), args);
    }
}

//Declares class WekaClassifier.
class WekaClassifier
{

    //Classifies the given instance with exception handling.
    public static double classify(Object[] i)
            throws Exception
    {

        double p = Double.NaN;
        p = WekaClassifier.N12944c170(i);
        return p;
    }

    //Classifies the instance traversing through data set attributes.
    static double N12944c170(Object[] i)
    {
        //Variable of type double for holding "Not a Number" value.
        double p = Double.NaN;
        
        if (i[2] == null)
        {
            p = 0;
        }
        
        else if (i[2].equals("True"))
        {
            p = 0;
        }
        
        else if (i[2].equals("False"))
        {
            p = WekaClassifier.Nbc13ec11(i);
        }
        return p;
    }

    static double Nbc13ec11(Object[] i)
    {
        double p = Double.NaN;
        if (i[0] == null)
        {
            p = 0;
        }
        
        else if (i[0].equals("True"))
        {
            p = 0;
        }
        
        else if (i[0].equals("False"))
        {
            p = 1;
        }
        return p;
    }
}
