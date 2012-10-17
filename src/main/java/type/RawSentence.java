

/* First created by JCasGen Mon Oct 15 18:29:39 EDT 2012 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** This type defines each sentence in input file. With sentence number and raw sentence
 * Updated by JCasGen Mon Oct 15 18:30:06 EDT 2012
 * XML source: /Users/zhangweijia/Documents/Java_workplace/hw1-weijiaz/src/main/resources/descriptors/Raw Sentence.xml
 * @generated */
public class RawSentence extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(RawSentence.class);
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
  protected RawSentence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public RawSentence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public RawSentence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public RawSentence(JCas jcas, int begin, int end) {
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
  //* Feature: Number

  /** getter for Number - gets Number of each sentence
   * @generated */
  public String getNumber() {
    if (RawSentence_Type.featOkTst && ((RawSentence_Type)jcasType).casFeat_Number == null)
      jcasType.jcas.throwFeatMissing("Number", "type.RawSentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((RawSentence_Type)jcasType).casFeatCode_Number);}
    
  /** setter for Number - sets Number of each sentence 
   * @generated */
  public void setNumber(String v) {
    if (RawSentence_Type.featOkTst && ((RawSentence_Type)jcasType).casFeat_Number == null)
      jcasType.jcas.throwFeatMissing("Number", "type.RawSentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((RawSentence_Type)jcasType).casFeatCode_Number, v);}    
   
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets The sentence text of Raw Sentence
   * @generated */
  public String getText() {
    if (RawSentence_Type.featOkTst && ((RawSentence_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "type.RawSentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((RawSentence_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets The sentence text of Raw Sentence 
   * @generated */
  public void setText(String v) {
    if (RawSentence_Type.featOkTst && ((RawSentence_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "type.RawSentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((RawSentence_Type)jcasType).casFeatCode_text, v);}    
  }

    