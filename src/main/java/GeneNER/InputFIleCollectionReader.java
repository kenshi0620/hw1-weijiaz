package GeneNER;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;

/**
 * @author zhangweijia
 * 
 * This class contain methods to collect sentences in given document
 * each sentence becomes a CAS
 */
public class InputFIleCollectionReader extends CollectionReader_ImplBase {
  /**
   * Name of configuration parameter that must be set to the path of a directory containing input
   * files.
   */
  public static final String PARAM_PATH = "InputPath";
  
  private ArrayList<String> mSentences;

  private int mCurrentIndex;
  

  public void initialize() throws ResourceInitializationException {   
    File directory = new File(((String) getConfigParameterValue(PARAM_PATH)).trim());
    mCurrentIndex = 0;
    
    mSentences = new ArrayList<String>();    
    try {
      Scanner sc = new Scanner (directory);
      addSentenceFromFile(sc);
    } catch (FileNotFoundException e) {
      System.out.println ("File is not found!");
    }
  }

  private void addSentenceFromFile(Scanner sc) {
    while (sc.hasNextLine()) {
      mSentences.add(sc.nextLine());
    }
  }

  @Override
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    // TODO Auto-generated method stub
    JCas jcas;
    
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new CollectionException(e);
    }
    
    // open input stream to file
    String sentence = mSentences.get(mCurrentIndex++);
    
    // put document in CAS
    jcas.setDocumentText(sentence);
  }

  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    return mCurrentIndex < mSentences.size();
  }
}
