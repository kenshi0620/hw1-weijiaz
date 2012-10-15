
/* First created by JCasGen Sun Oct 14 12:10:10 EDT 2012 */
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

/** This type defines each sentence in input file. With sentence number and raw sentence
 * Updated by JCasGen Mon Oct 15 02:16:08 EDT 2012
 * @generated */
public class RawSentence_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (RawSentence_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = RawSentence_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new RawSentence(addr, RawSentence_Type.this);
  			   RawSentence_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new RawSentence(addr, RawSentence_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = RawSentence.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("GeneNER.RawSentence");
 
  /** @generated */
  final Feature casFeat_Number;
  /** @generated */
  final int     casFeatCode_Number;
  /** @generated */ 
  public String getNumber(int addr) {
        if (featOkTst && casFeat_Number == null)
      jcas.throwFeatMissing("Number", "GeneNER.RawSentence");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Number);
  }
  /** @generated */    
  public void setNumber(int addr, String v) {
        if (featOkTst && casFeat_Number == null)
      jcas.throwFeatMissing("Number", "GeneNER.RawSentence");
    ll_cas.ll_setStringValue(addr, casFeatCode_Number, v);}
    
  
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "GeneNER.RawSentence");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "GeneNER.RawSentence");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public RawSentence_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Number = jcas.getRequiredFeatureDE(casType, "Number", "uima.cas.String", featOkTst);
    casFeatCode_Number  = (null == casFeat_Number) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Number).getCode();

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

  }
}



    