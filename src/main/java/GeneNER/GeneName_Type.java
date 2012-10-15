
/* First created by JCasGen Sun Oct 14 20:42:10 EDT 2012 */
package GeneNER;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** Nouns in Sentence
 * Updated by JCasGen Mon Oct 15 02:16:07 EDT 2012
 * @generated */
public class GeneName_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (GeneName_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = GeneName_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new GeneName(addr, GeneName_Type.this);
  			   GeneName_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new GeneName(addr, GeneName_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GeneName.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("GeneNER.GeneName");
 
  /** @generated */
  final Feature casFeat_SentenceID;
  /** @generated */
  final int     casFeatCode_SentenceID;
  /** @generated */ 
  public String getSentenceID(int addr) {
        if (featOkTst && casFeat_SentenceID == null)
      jcas.throwFeatMissing("SentenceID", "GeneNER.GeneName");
    return ll_cas.ll_getStringValue(addr, casFeatCode_SentenceID);
  }
  /** @generated */    
  public void setSentenceID(int addr, String v) {
        if (featOkTst && casFeat_SentenceID == null)
      jcas.throwFeatMissing("SentenceID", "GeneNER.GeneName");
    ll_cas.ll_setStringValue(addr, casFeatCode_SentenceID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_GeneText;
  /** @generated */
  final int     casFeatCode_GeneText;
  /** @generated */ 
  public String getGeneText(int addr) {
        if (featOkTst && casFeat_GeneText == null)
      jcas.throwFeatMissing("GeneText", "GeneNER.GeneName");
    return ll_cas.ll_getStringValue(addr, casFeatCode_GeneText);
  }
  /** @generated */    
  public void setGeneText(int addr, String v) {
        if (featOkTst && casFeat_GeneText == null)
      jcas.throwFeatMissing("GeneText", "GeneNER.GeneName");
    ll_cas.ll_setStringValue(addr, casFeatCode_GeneText, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Confidence;
  /** @generated */
  final int     casFeatCode_Confidence;
  /** @generated */ 
  public double getConfidence(int addr) {
        if (featOkTst && casFeat_Confidence == null)
      jcas.throwFeatMissing("Confidence", "GeneNER.GeneName");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_Confidence);
  }
  /** @generated */    
  public void setConfidence(int addr, double v) {
        if (featOkTst && casFeat_Confidence == null)
      jcas.throwFeatMissing("Confidence", "GeneNER.GeneName");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_Confidence, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public GeneName_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_SentenceID = jcas.getRequiredFeatureDE(casType, "SentenceID", "uima.cas.String", featOkTst);
    casFeatCode_SentenceID  = (null == casFeat_SentenceID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_SentenceID).getCode();

 
    casFeat_GeneText = jcas.getRequiredFeatureDE(casType, "GeneText", "uima.cas.String", featOkTst);
    casFeatCode_GeneText  = (null == casFeat_GeneText) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_GeneText).getCode();

 
    casFeat_Confidence = jcas.getRequiredFeatureDE(casType, "Confidence", "uima.cas.Double", featOkTst);
    casFeatCode_Confidence  = (null == casFeat_Confidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Confidence).getCode();

  }
}



    