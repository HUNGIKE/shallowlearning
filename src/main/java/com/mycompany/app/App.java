package com.mycompany.app;

import java.util.Random;

import org.neuroph.core.Layer;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;

public class App {
    public static void main( String[] args ) {
    	NeuralNetwork ann =  new MultiLayerPerceptron(2,3,1);
    	
    	
    	
    	BackPropagation backPropagation = new BackPropagation();
    	backPropagation.setMaxIterations(10000);
    	
    	ann.learn(App.createDataset(), backPropagation);
    	
    	
    	ann.setInput(50/100d,35/100d);
    	ann.calculate();
    	System.out.println(ann.getOutput()[0]*110000.0d);
    	
    }
    
    private static DataSet createDataset() {
    	DataSet ds = new DataSet(2, 1);
    	Random r=new Random();
    	for(int i=0;i<30000;i++) {
    		double x1=r.nextDouble()*100, x2=r.nextDouble()*100,y=Math.pow(x1, 2)+Math.pow(x2,2.5);
    		
    		DataSetRow record = new DataSetRow(new double[] {x1/100d, x2/100d}, new double[] {y/110000.0d});
    		ds.addRow(record);
    	}
    	return ds;
    	
    }
}
