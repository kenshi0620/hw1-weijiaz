

/* First created by JCasGen Sun Oct 14 20:42:10 EDT 2012 */
package GeneNER;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Nouns in Sentence
 * Updated by JCasGen Mon Oct 15 02:16:07 EDT 2012
 * XML source: /Users/zhangweijia/Documents/Java_workplace/hw1-weijiaz/src/main/resources/descriptors/bergmanDBChecker.xml
 * @generated */
public class GeneName extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GeneName.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected GeneName() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public GeneName(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public GeneName(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public GeneName(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: SentenceID

  /** getter for SentenceID - gets 
   * @generated */
  public String getSentenceID() {
    if (GeneName_Type.featOkTst && ((GeneName_Type)jcasType).casFeat_SentenceID == null)
      jcasType.jcas.throwFeatMissing("SentenceID", "GeneNER.GeneName");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneName_Type)jcasType).casFeatCode_SentenceID);}
    
  /** setter for SentenceID - sets  
   * @generated */
  public void setSentenceID(String v) {
    if (GeneName_Type.featOkTst && ((GeneName_Type)jcasType).casFeat_SentenceID == null)
      jcasType.jcas.throwFeatMissing("SentenceID", "GeneNER.GeneName");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneName_Type)jcasType).casFeatCode_SentenceID, v);}    
   
    
  //*--------------*
  //* Feature: GeneText

  /** getter for GeneText - gets 
   * @generated */
  public String getGeneText() {
    if (GeneName_Type.featOkTst && ((GeneName_Type)jcasType).casFeat_GeneText == null)
      jcasType.jcas.throwFeatMissing("GeneText", "GeneNER.GeneName");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneName_Type)jcasType).casFeatCode_GeneText);}
    
  /** setter for GeneText - sets  
   * @generated */
  public void setGeneText(String v) {
    if (GeneName_Type.featOkTst && ((GeneName_Type)jcasType).casFeat_GeneText == null)
      jcasType.jcas.throwFeatMissing("GeneText", "GeneNER.GeneName");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneName_Type)jcasType).casFeatCode_GeneText, v);}    
   
    
  //*--------------*
  //* Feature: Confidence

  /** getter for Confidence - gets 
   * @generated */
  public double getConfidence() {
    if (GeneName_Type.featOkTst && ((GeneName_Type)jcasType).casFeat_Confidence == null)
      jcasType.jcas.throwFeatMissing("Confidence", "GeneNER.GeneName");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((GeneName_Type)jcasType).casFeatCode_Confidence);}
    
  /** setter for Confidence - sets  
   * @generated */
  public void setConfidence(double v) {
    if (GeneName_Type.featOkTst && ((GeneName_Type)jcasType).casFeat_Confidence == null)
      jcasType.jcas.throwFeatMissing("Confidence", "GeneNER.GeneName");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((GeneName_Type)jcasType).casFeatCode_Confidence, v);}    
  }

    