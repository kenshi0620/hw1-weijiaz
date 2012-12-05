package GeneNER;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import type.RawSentence;
import type.geneName;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;

/**
 * This class contains methods to annotate gene name from sentence.
 * Use Lingpipe en-en-bio-genetag.Hmm model to tag the sentence.
 */
public class GeneNameAnnotator extends JCasAnnotator_ImplBase {

  private ConfidenceChunker chunker = null;
  private String sentenceText= null;
  private String sentenceID = null;
  
  /**
   *  tag gene names using lingpipe model
   */
  public void process(JCas aJCas) {
    if (chunker == null) {
      File modelFile = new File("data/ne-en-bio-genetag.HmmChunker");
      try {
        chunker = (ConfidenceChunker) AbstractExternalizable.readObject(modelFile);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    }
    
    FSIterator<Annotation> iterator = aJCas.getAnnotationIndex(RawSentence.type).iterator();
    if (iterator.hasNext()) {
      RawSentence sentence = (RawSentence) iterator.next();
      sentenceText = sentence.getText();
      sentenceID = sentence.getNumber();
    }
    char[] cs = sentenceText.toCharArray();
    
    
    Iterator<Chunk> it = chunker.nBestChunks(cs, 0, cs.length, 5);

    while (it.hasNext()) {

      Chunk chunk = it.next();
      double conf = Math.pow(2.0, chunk.score());
      int cstart = chunk.start();
      int cend = chunk.end();
      String phrase = sentenceText.substring(cstart, cend);

      
      geneName genetext = new geneName(aJCas);
      genetext.setSentenceID(sentenceID);
      genetext.setGeneText(phrase);
      genetext.setBegin(countNonSpace(sentenceText,cstart));
      genetext.setEnd(countNonSpace(sentenceText,cend-1));
      genetext.setConfidence(conf);
      genetext.addToIndexes();
      
    }
  }
  /**
   * count non-whitespace in text until a given position
   * @param text
   * @param pos
   * @return number of non-whitespaces
   */
  private int countNonSpace(String text, int pos) {
    int count = 0, index = 0;
    while (index < pos) {
      if (text.charAt(index) != ' ') {
        count++;
      }
      index++;
    }
    return count;
  }
}