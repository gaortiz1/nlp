package com.bigeye.nlp;


import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import org.ejml.simple.SimpleMatrix;
import org.junit.Test;

import java.util.Properties;
public class TestSentiment {

    @Test
    public void testRegularizationGradientCheck() {

        String line = "I hate you";

        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        if (line != null && line.length() > 0) {
            Annotation annotation = pipeline.process(line);
            for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
                Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
                final SimpleMatrix predictions = RNNCoreAnnotations.getPredictions(tree);
                final String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
                System.out.println("sentence:  "+sentence);
                System.out.println("sentiment: "+sentiment);
                System.out.println("matrix:    "+predictions);
            }
        }
    }

}
