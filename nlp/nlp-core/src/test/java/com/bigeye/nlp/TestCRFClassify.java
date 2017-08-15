package com.bigeye.nlp;


import edu.stanford.nlp.ie.crf.CRFClassifier;
import org.junit.Test;

import java.util.List;
import java.util.Properties;

public class TestCRFClassify {

    @Test
    public void shouldClassifyToString() {

        final Properties properties = new Properties();
        properties.put("trainFile", "C:\\Users\\bisbi\\Desktop\\jane-austen-emma-ch1.tsv");
        properties.put("serializeTo", "C:\\Users\\bisbi\\Desktop\\ner-model-test.ser.gz");
        properties.put("map","word=0,answer=1");
        properties.put("maxLeft","1");
        properties.put("useClassFeature","true");
        properties.put("useWord","true");
        properties.put("useNGrams","true");
        properties.put("noMidNGrams","true");
        properties.put("maxNGramLeng","6");
        properties.put("usePrev","true");
        properties.put("useDisjunctive","true");
        properties.put("useSequences","true");
        properties.put("usePrevSequences","true");
        properties.put("useTypeSeqs","true");
        properties.put("useTypeSeqs2","true");
        properties.put("useTypeySequences","true");
        properties.put("wordShape","chris2useLC");

        final CRFClassifier crfClassifier = new CRFClassifier(properties);
        crfClassifier.train();
        List captain = crfClassifier.classify("Captain");
        for (Object o : captain) {
             System.out.printf(o.toString());
        }
        crfClassifier.serializeClassifier("C:\\Users\\bisbi\\Desktop\\ner-model-test.ser.gz");
    }
}
