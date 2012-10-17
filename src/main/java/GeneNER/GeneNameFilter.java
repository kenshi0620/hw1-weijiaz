package GeneNER;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import type.geneName;

public class GeneNameFilter extends JCasAnnotator_ImplBase{

  private double confidence = 0.0;
  private String GeneName = null;
  private static double UPPERBOUND = 0.6;
  private static double LOWWERBOUND = 0.3;
  
  // Update GeneNames' confidence by query from bergmanlab database
  public void process(JCas aJCas) {
    
    FSIterator<Annotation> iterator = aJCas.getAnnotationIndex(geneName.type).iterator();
    if (iterator.hasNext()) {
      geneName gene = (geneName) iterator.next();
      confidence = gene.getConfidence();
      GeneName = gene.getGeneText();
      
      // if we are unsure whether it is a gene or not, check it on website
      if (confidence <= UPPERBOUND && confidence >= LOWWERBOUND ) {
        // if found, reset confidence to 1, else to 0 
        try {
          if (CheckfromDB(GeneName)) {
            gene.setConfidence(1);
          }else gene.setConfidence(0);
        } catch (IOException e) {
          // do nothing
        }  
      }
    }
  }
  
  // return true if the string can be found in bergmanlab database
  private boolean CheckfromDB ( String geneName ) throws IOException {
    
    String newGeneName = changeWhiteSpaceTo20percent(geneName);
    
    String requestURL = "http://bergmanlab.smith.man.ac.uk:8081/?text="+newGeneName;
    URL url = new URL(requestURL);
    
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    
    InputStream in = url.openStream();
    BufferedReader bin = new BufferedReader(new InputStreamReader(in, "GB2312"));
    
    String response = bin.readLine();
    
    if (response != null) {
      return true;
    } else return false;
  }
  
  // replace whitespaces in the string with '%20'
  private String changeWhiteSpaceTo20percent (String s) {
    String result = new String();
    String[] list = new String[20];
    
    list = s.split(" ");
    for (String w: list) {
      result = result + "%20" + w;
    }
    result = result.substring(3);
    return result;
  }
}
