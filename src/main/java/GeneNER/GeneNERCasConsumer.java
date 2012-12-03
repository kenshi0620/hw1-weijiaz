package GeneNER;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.collection.base_cpm.CasObjectProcessor;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.ProcessTrace;

import type.geneName;

/**
 * 
 * @author zhangweijia
 * 
 * This class contain methods to output geneName
 */
public class GeneNERCasConsumer extends CasConsumer_ImplBase implements CasObjectProcessor {
  
  private static double UPPERBOUND = 0.6;
  
  File outFile;
  FileWriter fileWriter;
  
  public GeneNERCasConsumer() {
  }
  
  
  public void initialize() throws ResourceInitializationException {

    // extract configuration parameter settings
    String oPath = (String) getUimaContext().getConfigParameterValue("outputFile");

    // Output file should be specified in the descriptor
    if (oPath == null) {
      throw new ResourceInitializationException(
              ResourceInitializationException.CONFIG_SETTING_ABSENT, new Object[] { "outputFile" });
    }
    // If specified output directory does not exist, try to create it
    outFile = new File(oPath.trim());
    try {
      fileWriter = new FileWriter(outFile);
    } catch (IOException e) {
      throw new ResourceInitializationException(e);
    }
  }

  public synchronized void processCas(CAS aCAS) throws ResourceProcessException {
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    
    String sentenceNumber = null;
    String nounName = null;
    int start = 0;
    int end = 0;
    double confidence = 0;
    FSIterator<Annotation> it = jcas.getAnnotationIndex(geneName.type).iterator();
    while (it.hasNext()) {
      geneName gene = (geneName) it.next();

      sentenceNumber = gene.getSentenceID();
      nounName = gene.getGeneText();
      start = gene.getBegin();
      end = gene.getEnd();
      confidence = gene.getConfidence();
      
      if (confidence >= UPPERBOUND) {
        try {
          fileWriter.flush();
          fileWriter.write(sentenceNumber + "|" + start + " " + end + "|" + nounName + "\n");
        } catch (IOException e) {
          e.printStackTrace();
        }        
      }

    }
  }


  public void batchProcessComplete(ProcessTrace aTrace) throws ResourceProcessException,
          IOException {
  }

  public void collectionProcessComplete(ProcessTrace aTrace) throws ResourceProcessException,
          IOException {
    if (fileWriter != null) {
      fileWriter.close();
    }
  }

  public void reconfigure() throws ResourceConfigurationException {
    super.reconfigure();
    // extract configuration parameter settings
    String oPath = (String) getUimaContext().getConfigParameterValue("outputFile");
    File oFile = new File(oPath.trim());
    // if output file has changed, close exiting file and open new
    if (!oFile.equals(this.outFile)) {
      this.outFile = oFile;
      try {
        fileWriter.close();

        // If specified output directory does not exist, try to create it
        if (oFile.getParentFile() != null && !oFile.getParentFile().exists()) {
          if (!oFile.getParentFile().mkdirs())
            throw new ResourceConfigurationException(
                    ResourceInitializationException.RESOURCE_DATA_NOT_VALID, new Object[] { oPath,
                        "outputFile" });
        }
        fileWriter = new FileWriter(oFile);
      } catch (IOException e) {
        throw new ResourceConfigurationException();
      }
    }
  }

  public void destroy() {
    if (fileWriter != null) {
      try {
        fileWriter.close(); 
      } catch (IOException e) {
        // ignore IOException on destroy
      }
    }
  }
}
