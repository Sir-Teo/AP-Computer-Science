package sounds;

import java.io.*;

public class SoundFileFilter extends javax.swing.filechooser.FileFilter{
    
   private String extension, description;
       
   public SoundFileFilter(String extension, String description){
      this.extension = extension;
      this.description = description;
   }

   public boolean accept(File f){
      return f.getName().toLowerCase().endsWith(extension) ||
             f.isDirectory();
   }
   
   public String getDescription(){
      return description;
   }
}