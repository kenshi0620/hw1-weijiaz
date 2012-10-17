
/* First created by JCasGen Mon Oct 15 18:29:07 EDT 2012 */
package type;

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

/** 
 * Updated by JCasGen Mon Oct 15 18:29:26 EDT 2012
 * @generated */
public class geneName_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (geneName_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = geneName_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new geneName(addr, geneName_Type.this);
  			   geneName_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new geneName(addr, geneName_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = geneName.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("type.geneName");
 
  /** @generated */
  final Feature casFeat_sentenceID;
  /** @generated */
  final int     casFeatCode_sentenceID;
  /** @generated */ 
  public String getSentenceID(int addr) {
        if (featOkTst && casFeat_sentenceID == null)
      jcas.throwFeatMissing("sentenceID", "type.geneName");
    return ll_cas.ll_getStringValue(addr, casFeatCode_sentenceID);
  }
  /** @generated */    
  public void setSentenceID(int addr, String v) {
        if (featOkTst && casFeat_sentenceID == null)
      jcas.throwFeatMissing("sentenceID", "type.geneName");
    ll_cas.ll_setStringValue(addr, casFeatCode_sentenceID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_geneText;
  /** @generated */
  final int     casFeatCode_geneText;
  /** @generated */ 
  public String getGeneText(int addr) {
        if (featOkTst && casFeat_geneText == null)
      jcas.throwFeatMissing("geneText", "type.geneName");
    return ll_cas.ll_getStringValue(addr, casFeatCode_geneText);
  }
  /** @generated */    
  public void setGeneText(int addr, String v) {
        if (featOkTst && casFeat_geneText == null)
      jcas.throwFeatMissing("geneText", "type.geneName");
    ll_cas.ll_setStringValue(addr, casFeatCode_geneText, v);}
    
  
 
  /** @generated */
  final Feature casFeat_confidence;
  /** @generated */
  final int     casFeatCode_confidence;
  /** @generated */ 
  public double getConfidence(int addr) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "type.geneName");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_confidence);
  }
  /** @generated */    
  public void setConfidence(int addr, double v) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "type.geneName");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_confidence, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public geneName_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_sentenceID = jcas.getRequiredFeatureDE(casType, "sentenceID", "uima.cas.String", featOkTst);
    casFeatCode_sentenceID  = (null == casFeat_sentenceID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sentenceID).getCode();

 
    casFeat_geneText = jcas.getRequiredFeatureDE(casType, "geneText", "uima.cas.String", featOkTst);
    casFeatCode_geneText  = (null == casFeat_geneText) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_geneText).getCode();

 
    casFeat_confidence = jcas.getRequiredFeatureDE(casType, "confidence", "uima.cas.Double", featOkTst);
    casFeatCode_confidence  = (null == casFeat_confidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_confidence).getCode();

  }
}



    