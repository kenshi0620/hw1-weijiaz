package GeneNER;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;

import type.RawSentence;

/**
 * 
 * @author zhangweijia
 *
 * This annotater find out and annotate sentenceID and text
 */
public class SimpleSentenceNumAndTextDetection extends JCasAnnotator_ImplBase {

  public void process(JCas aJCas) {
    // get document text
    String sentence = aJCas.getDocumentText();
    // search for sentence numbers
    
    String sentenceN = sentence.substring(0, 14);
    String sentenceText = sentence.substring(15);
    

    RawSentence annotationSentence = new RawSentence(aJCas);

    annotationSentence.setNumber(sentenceN);
    annotationSentence.setText(sentenceText);
    annotationSentence.addToIndexes();    
   }
}
