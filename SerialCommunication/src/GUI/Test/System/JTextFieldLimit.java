//Class found at StackOverflow for limiting inputs for textfields
//http://stackoverflow.com/questions/3519151/how-to-limit-the-number-of-characters-in-jtextfield
package GUI.Test.System;
import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument {
  private int limit;

  public JTextFieldLimit(int limit) {
   super();
   this.limit = limit;
   }

  @Override
  public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
    if (str == null) return;

    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }
}