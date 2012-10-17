

/* First created by JCasGen Mon Oct 15 18:29:07 EDT 2012 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Oct 15 18:29:26 EDT 2012
 * XML source: /Users/zhangweijia/Documents/Java_workplace/hw1-weijiaz/src/main/resources/descriptors/GeneName.xml
 * @generated */
public class geneName extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(geneName.class);
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
  protected geneName() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public geneName(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public geneName(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public geneName(JCas jcas, int begin, int end) {
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
  //* Feature: sentenceID

  /** getter for sentenceID - gets 
   * @generated */
  public String getSentenceID() {
    if (geneName_Type.featOkTst && ((geneName_Type)jcasType).casFeat_sentenceID == null)
      jcasType.jcas.throwFeatMissing("sentenceID", "type.geneName");
    return jcasType.ll_cas.ll_getStringValue(addr, ((geneName_Type)jcasType).casFeatCode_sentenceID);}
    
  /** setter for sentenceID - sets  
   * @generated */
  public void setSentenceID(String v) {
    if (geneName_Type.featOkTst && ((geneName_Type)jcasType).casFeat_sentenceID == null)
      jcasType.jcas.throwFeatMissing("sentenceID", "type.geneName");
    jcasType.ll_cas.ll_setStringValue(addr, ((geneName_Type)jcasType).casFeatCode_sentenceID, v);}    
   
    
  //*--------------*
  //* Feature: geneText

  /** getter for geneText - gets 
   * @generated */
  public String getGeneText() {
    if (geneName_Type.featOkTst && ((geneName_Type)jcasType).casFeat_geneText == null)
      jcasType.jcas.throwFeatMissing("geneText", "type.geneName");
    return jcasType.ll_cas.ll_getStringValue(addr, ((geneName_Type)jcasType).casFeatCode_geneText);}
    
  /** setter for geneText - sets  
   * @generated */
  public void setGeneText(String v) {
    if (geneName_Type.featOkTst && ((geneName_Type)jcasType).casFeat_geneText == null)
      jcasType.jcas.throwFeatMissing("geneText", "type.geneName");
    jcasType.ll_cas.ll_setStringValue(addr, ((geneName_Type)jcasType).casFeatCode_geneText, v);}    
   
    
  //*--------------*
  //* Feature: confidence

  /** getter for confidence - gets 
   * @generated */
  public double getConfidence() {
    if (geneName_Type.featOkTst && ((geneName_Type)jcasType).casFeat_confidence == null)
      jcasType.jcas.throwFeatMissing("confidence", "type.geneName");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((geneName_Type)jcasType).casFeatCode_confidence);}
    
  /** setter for confidence - sets  
   * @generated */
  public void setConfidence(double v) {
    if (geneName_Type.featOkTst && ((geneName_Type)jcasType).casFeat_confidence == null)
      jcasType.jcas.throwFeatMissing("confidence", "type.geneName");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((geneName_Type)jcasType).casFeatCode_confidence, v);}    
  }

    