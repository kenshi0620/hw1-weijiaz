package GeneNER;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;

public class SimpleSentenceNumAndTextDetection extends JCasAnnotator_ImplBase {

  private ConfidenceChunker chunker = null;

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

    // Stanford NLP
    /**
     * PosTagNamedEntityRecognizer myPosTagger = null; try { myPosTagger = new
     * PosTagNamedEntityRecognizer(); } catch (ResourceInitializationException e) {
     * e.printStackTrace(); }
     * 
     * Map<Integer, Integer> spans = myPosTagger.getGeneSpans(sentenceText); Set<Entry<Integer,
     * Integer>> entrySet = spans.entrySet(); String name;
     * 
     * for (Entry<Integer, Integer> entry : entrySet) { int begin = entry.getKey(); int end =
     * entry.getValue(); Noun noun = new Noun(aJCas); name = sentenceText.substring(begin, end);
     * 
     * noun.setSentenceID(sentenceN); noun.setNounName(name); noun.setBegin(begin);
     * noun.setEnd(end); noun.addToIndexes();
     */

    // LingPipe

    if (chunker == null) {
      File modelFile = new File("src/main/resources/data/ne-en-bio-genetag.HmmChunker");

      try {
        chunker = (ConfidenceChunker) AbstractExternalizable.readObject(modelFile);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    }
    char[] cs = sentenceText.toCharArray();
    Iterator<Chunk> it = chunker.nBestChunks(cs, 0, cs.length, 5);

    while (it.hasNext()) {

      Chunk chunk = it.next();
      double conf = Math.pow(2.0, chunk.score());
      int cstart = chunk.start();
      int cend = chunk.end();
      String phrase = sentenceText.substring(cstart, cend);

      if (conf >= 0.60) {
        GeneName geneName = new GeneName(aJCas);
        geneName.setSentenceID(sentenceN);
        geneName.setGeneText(phrase);
        geneName.setBegin(countNonSpace(sentenceText,cstart));
        geneName.setEnd(countNonSpace(sentenceText,cend-1));
        geneName.setConfidence(conf);
        geneName.addToIndexes();
      }
    }
  }
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
