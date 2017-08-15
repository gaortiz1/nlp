package com.bigeye.nlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class TestStanfordNERExecutor {

    private StanfordNERExecutor stanfordNERExecutor;

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        this.stanfordNERExecutor = new StanfordNERExecutor("es");
    }

    @Test
    public void shouldClassify() {
        List<List<CoreLabel>> apply = stanfordNERExecutor.apply("David Bowie toma las calles del mundo.");
        for (List<CoreLabel> coreLabels : apply) {
            System.out.println(coreLabels);

            for (CoreLabel word : coreLabels) {
                System.out.println(word.word() + '/' + word.get(CoreAnnotations.AnswerAnnotation.class) + ' ');
            }
        }
    }

}
