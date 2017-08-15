package com.bigeye.nlp;

import edu.stanford.nlp.ie.NERClassifierCombiner;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import org.junit.Test;

import java.util.List;

public class TestCRFClassifier2 {

    @Test
    public void shouldTrainig() {
        String serializedClassifier = "edu/stanford/nlp/models/ner/english.muc.7class.distsim.crf.ser.gz";
        String serializedClassifier2 = "C:/standford-ner/ner-model.ser.gz";
        try {
            NERClassifierCombiner classifier = new NERClassifierCombiner(false, false, false,serializedClassifier2, serializedClassifier);
            String ss = "Book of 49 Magazine Articles on Toyota Land Cruiser 1956-1987 Gold Portfolio http://t.co/EqxmY1VmLg http://t.co/F0Vefuoj9Q";
            System.out.println("---");
            List<List<CoreLabel>> out = classifier.classify(ss);
            for (List<CoreLabel> sentence : out) {
                for (CoreLabel word : sentence) {
                    System.out.print(word.word() + '/' + word.get(CoreAnnotations.AnswerAnnotation.class) + ' ');
                }
                System.out.println();
            }

        } catch (ClassCastException e) {
            e.printStackTrace();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
