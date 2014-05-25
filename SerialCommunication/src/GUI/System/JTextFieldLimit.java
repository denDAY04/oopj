/**
 * Class found at StackOverflow for limiting inputs for TextFields.
 * http://stackoverflow.com/questions/3519151/how-to-limit-the-number-of
 * -characters-in-jtextfield
 */
package GUI.System;

import javax.swing.text.*;

/**
 * Class for imposing a length limit to the document of TextFields. 
 */
public class JTextFieldLimit extends PlainDocument {

    private int limit;

    /**
     * Custom constructor.
     *
     * @param limit the maximum number of characters that can be in the field.
     */
    public JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    /**
     * Insert a string into the document of the TextField; but only if the
     * complete length of the document's String is less than the limit specified
     * by the class field variable.
     *
     * @param offset of the existing string of the document at which to begin
     *               the new text.
     * @param str    the String to insert into the document.
     * @param attr   AttributeSet.
     *
     * @throws BadLocationException the given position is not valid.
     */
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws
            BadLocationException {
        if (str == null) {
            return;
        }

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}
