/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RA
 */
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;


public class HighlightMatches { 
   
    private Highlighter.HighlightPainter cyanPainter;
    
   
    public void findMatches(String txt,String regexp,javax.swing.JTextArea textArea,boolean t,javax.swing.JTextField jTextField3) throws BadLocationException{
        String reg = regexp;
        String text = txt;
        if(t == true) {
           reg = reg.toLowerCase();
           text = text.toLowerCase();
        }
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(text);
        
        
        Highlighter highlighter = textArea.getHighlighter();
        highlighter.removeAllHighlights();
        cyanPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);
        
            while(matcher.find()) {
            int start = matcher.start();
            int end   = matcher.end();
            highlighter.addHighlight(start, end, cyanPainter);
            }

        if(matcher.matches()){
                jTextField3.setText("True");
            }
        else {
            jTextField3.setText("False");
        }
    }   
 
    public String number (javax.swing.JTextArea textArea){
         Highlighter highlighter = textArea.getHighlighter();
         Highlighter.Highlight[] array = highlighter.getHighlights();
         return String.valueOf(array.length);
    }
    
    public void removeHighlights(javax.swing.JTextArea textArea){
        Highlighter highlighter = textArea.getHighlighter();
        highlighter.removeAllHighlights();

    }  
}
