package sounds;

import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

// ***************
// NOTE: an array of bytes is obtained from the sound clip in two places,
//       the open method (after loading from a file) and the run method of
//       the RecordThread class (after recording).  This array of bytes is
//       the converted to an array of Sample objects for any futher processing,
//       such as graphical display of the waveform, in the method bytesToSamples.


/**
 * LICENSE: This is open-source software released under the terms of the<BR>
 * GPL (http://www.gnu.org/licenses/gpl.html).<BR><BR> 
 * 
 * This class supports the processing of sound clips.<BR><BR>  
 * Input files must be in WAVE format.  Output files are written in WAVE format.<BR><BR>
 * 
 * Example program, which loads a sound clip from a file,
 * increases its volume, plays it and draws its wave form:<BR><BR>
 * 
 *<pre> import sounds.APSoundClip;
 * import sounds.Sample;
 *
 * public class TestVolume{
 *
 *    public static void main(String[]args){  
 *       APSoundClip clip = new APSoundClip();
 *       for (Sample s : clip){
 *          int value = s.getValue();
 *          s.setValue(value * 2);
 *       }
 *       clip.play();
 *       clip.draw();
 *    }
 * }</pre><BR> 
 * You can reset maximum heap size when running the program if you run 
 * out of memory for large sound clips, as follows:<BR>
 *
 * <pre>java -Xmx<I>new Size</I>m <I>programFileName</I></pre>
 *
 * where <I>newSize</I> is an integer.  For example,<BR>
 *
 * <pre>java -Xmx128m TestVolume</pre>
 *
 * allows up to 128 megabytes of heap space for the TestVolume program.
*/

public class APSoundClip extends JFrame implements Iterable<Sample>{

   static public int SAMPLING_RATE = 44100;

   private Sample[] samples;
   private SoundPanel soundPanel;
   private String fileName = "";
   //private boolean startup = true;
   private File file;

   private  boolean stopped = false;
   //private  ByteArrayOutputStream byteArrayOutputStream;
   private  AudioFormat audioFormat;
   private  TargetDataLine targetDataLine;
   private  AudioInputStream audioInputStream;
   private  SourceDataLine sourceDataLine;

   private JMenuItem openMI = new JMenuItem("Open");
   private JMenuItem saveMI = new JMenuItem("Save");
   private JMenuItem saveAsMI = new JMenuItem("Save as...");

   private JButton recordBtn = new JButton("Record");
   private JButton playBtn = new JButton("Play");
   private JButton stopBtn = new JButton("Stop");

   private JTextField statusField = new JTextField("");
   
   // Note: the constructors inititialze all GUI components but do not pop up
   // the GUI.  The application must run draw() to pop up the GUI.

   // Creates a copy of the given clip, used by the clone method
   private APSoundClip(APSoundClip original){
      this("", original.getLength());
      for (int i = 0; i < original.getLength(); i++)
         this.getSample(i).setValue(original.getSample(i).getValue());
   }

   /**
    * Creates a clip whose length is 0.
    */
   public APSoundClip(){
      this("");
   }

    /**
     * Creates a clip of the given length.
     * @param length the number of samples, all set to 0
     */
   public APSoundClip(int length){
      this("", length);
   }

    /**
     * Creates a clip from a given file.
     * @param fn the name of the file
     * @throws Exception if the file does not exist or is not in WAVE format
     */
   public APSoundClip(String fn){
      this(fn, 0);
   }

    /**
     * Creates a clip from a given file.
     * @param fn the name of the file
     * @throws Exception if the file does not exist or is not in WAVE format
     */
   private APSoundClip(String fn, int length){
      audioFormat = getAudioFormat();
      setSize(800, 250);
      Container c = getContentPane();
      c.setBackground(Color.white);
      JMenu menu = new JMenu("File");
      menu.add(openMI);
      menu.add(saveMI);
      menu.add(saveAsMI);
      JMenuBar bar = new JMenuBar();
      bar.add(menu);
      setJMenuBar(bar);
      JPanel buttonPanel = new JPanel();
      buttonPanel.add(recordBtn);
      buttonPanel.add(stopBtn);
      buttonPanel.add(playBtn);
      JPanel bottomPanel = new JPanel(new BorderLayout());
      bottomPanel.add("North", buttonPanel);
      bottomPanel.add("South", statusField);
      c.add("South", bottomPanel);
      stopBtn.setEnabled(false);
      playBtn.setEnabled(true);
      recordBtn.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            fileName = "";
            setTitle(fileName);
            statusField.setText("Recording . . .");
            stopBtn.setEnabled(true);
            playBtn.setEnabled(false);
            openMI.setEnabled(false);
            saveMI.setEnabled(false);
            saveAsMI.setEnabled(false);
            recordAudio();
         }
      });
      stopBtn.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            stopped = true;
            statusField.setText("Stopped");
            playBtn.setEnabled(true);
            recordBtn. setEnabled(true);
            stopBtn.setEnabled(false);
            openMI.setEnabled(true);
            saveMI.setEnabled(true);
            saveAsMI.setEnabled(true);
         }
      });
      playBtn.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            play();         
         }
      });
      openMI.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            File tempFile = openFileDialog();
            if (tempFile == null) return;
            file = tempFile;
            fileName = file.getName();
            setTitle(fileName);
            open();
	         resetSamples();
         }
      });
      saveMI.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            statusField.setText("Saving . . .");
            save();
         }
      });
      saveAsMI.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            statusField.setText("Saving . . .");
            saveAs();
         }
      });

      if (fn.equals(""))
         initSamples(length);
      else
          try{
             file = new File(fn);
             fileName = file.getName();
             setTitle(fileName);
             open();
          }catch(Exception e){
             System.out.println(e);
             initSamples(length);
          }
      soundPanel = new SoundPanel(800, 150, samplesToInts(samples));
      c.add("Center", new JScrollPane(soundPanel, 
                                      ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
                                      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS));
      pack();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      //setVisible(true);
   }

    /**
     * Returns the number of samples.
     * @return the number of samples
     */
   public int getLength(){
      if (samples == null) return 0;
      return samples.length;
   }
 
    /**
     * Returns the sampleing rate.
     * @return the sampling rate
     */
   public int getSamplingRate(){
      return SAMPLING_RATE;
   }

   /**
     * Returns the sample at the given position.
     * @param i the position of the sample
     * @return the sample at the given position
     */
   public Sample getSample(int i){
      return samples[i];
   }

    /**
     * Resets the sample at the given position.
     * @param i the  position of the sample
     * @param s the new Sample
     */ 
   public void setSample(int i, Sample s){
      samples[i] = s;
   }

    /**
     * Returns an iterator on the sound clip.
     * @return an Iterator on the sound clip
     */
   public Iterator<Sample> iterator(){
      return new SoundIterator();
   }

    /**
     * Returns a copy of the sound clip.
     * @return an APSoundClip representing a copy of this clip
     */
   public APSoundClip clone(){
      return new APSoundClip(this);
   }

    /**
     * Returns a string representation of the clip (file name and length).
     * @return a string representation of the clip
     */
   public String toString(){
      return "Sound\n" + 
             "File name: " + fileName + "\n" +
             "Length: " + getLength();
   }

    /**
     * Plays the sound clip on the currently active output channel.
     */
   public void play(){
      statusField.setText("Playing . . .");
      playBtn.setEnabled(false);
      recordBtn.setEnabled(false);
      stopBtn.setEnabled(true);
      stopped = false;
      playAudio();
   }

    /**
     * Displays the wave form in its window.
     */ 
   public void draw(){
      setVisible(true);
      resetSamples();
   }

    /**
     * Saves the sound clip under its current file name or runs <code>saveAs</code> if no file name yet.
     */
   public boolean save(){
      if (fileName.equals("") || file == null) 
         return saveAs();
      else
         return saveFile();
   }

    /**
     * Saves the sound clip using a file dialog.
     * @return true if the save is successful, or false if the user cancels
     */
   public boolean saveAs(){
      File tempFile = saveFileDialog();
      if (tempFile == null)
            return false;
      file = tempFile;
      fileName = file.getName();
      setTitle(fileName);
      return saveFile();
   }

   private boolean saveFile(){
      statusField.setText("Saving . . .");
      try{
         //Get an input stream on the byte array containing the data
         InputStream byteArrayInputStream = new ByteArrayInputStream(
                                            samplesToBytes(samples));

         //Get an audio input stream from the ByteArrayInputStream
         audioInputStream = new AudioInputStream(byteArrayInputStream,
                                                 audioFormat,
                                                 samples.length / audioFormat.getFrameSize());
         //Disable buttons until existing data is written to the file.
         recordBtn.setEnabled(false);
         playBtn.setEnabled(false);
         stopBtn.setEnabled(false);
         AudioSystem.write(audioInputStream,
                           AudioFileFormat.Type.WAVE,
                           file);
         statusField.setText(statusField.getText() + " done");
         //Enable buttons for another operation
         recordBtn.setEnabled(true);
         playBtn.setEnabled(true);
         stopBtn.setEnabled(true);
       }catch (Exception e) {
         System.out.println(e);
         return false;
       }
       return true;
   }

   private void initSamples(int length){
      samples = new Sample[length];
      for (int i = 0; i < length; i++)
         samples[i] = new Sample(0);
   }

   private void open(){
      statusField.setText("Opening . . .");
      byte tempBuffer[] = new byte[10000];
      try{
         audioInputStream = AudioSystem.getAudioInputStream(file);
         audioFormat = audioInputStream.getFormat();
         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         int cnt = 0;
         while((cnt = audioInputStream.read(tempBuffer, 0, tempBuffer.length)) != -1)
            if (cnt > 0)
               byteArrayOutputStream.write(tempBuffer, 0, cnt);
         byteArrayOutputStream.close();
         audioInputStream.close();
         // Here is where the array of integers is retrieved from the clip's file
         samples = bytesToSamples(byteArrayOutputStream.toByteArray());
         statusField.setText(statusField.getText() + " done");
       }catch (Exception e) {
           e.printStackTrace();
       }
       playBtn.setEnabled(true);
       saveMI.setEnabled(true);
       saveAsMI.setEnabled(true);
   }

   private void recordAudio(){
      try{
         // Prepare data for recording
         audioFormat = getAudioFormat();
         DataLine.Info dataLineInfo = new DataLine.Info(
                       TargetDataLine.class,
                       audioFormat);
         targetDataLine = (TargetDataLine)
                          AudioSystem.getLine(dataLineInfo);
         targetDataLine.open(audioFormat);
         targetDataLine.start();

         // Create a thread to capture the microphone data and start it
         // running.  It will run until the Stop button is clicked.
         Thread recordThread = new Thread(new RecordThread());
         recordThread.start();
         } catch (Exception e) {
            System.out.println(e);
         }
      }

   private void playAudio() {
      try{
         // Get everything set up for playback.
         // Get the previously-saved datainto a byte array object.
         byte audioData[] = samplesToBytes(samples);
         // Get an input stream on the byte array containing the data
         InputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
         AudioFormat audioFormat = getAudioFormat();
         audioInputStream = new AudioInputStream(byteArrayInputStream,
                                                 audioFormat,
                                                 audioData.length/audioFormat.
                                                 getFrameSize());
         DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class,
                                                        audioFormat);
         sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
         sourceDataLine.open(audioFormat);
         sourceDataLine.start();

         // Create a thread to play back the data and start it
         // running.  It will run until all the data has been played back.
         Thread playThread = new Thread(new PlayThread());
         playThread.start();
      } catch (Exception e) {
         System.out.println(e);
      }
   }

   private AudioFormat getAudioFormat(){
      float sampleRate = 44100;
      //8000,11025,16000,22050,44100, 8000.0F
      int sampleSizeInBits = 16;
      //8,16
      int channels = 1;
      //1,2
      boolean signed = true;
      //true,false
      boolean bigEndian = false;
      //true,false
      return new AudioFormat(sampleRate,
                             sampleSizeInBits,
                             channels,
                             signed,
                             bigEndian);
   }

   // Inner class to capture data from the microphone
   private class RecordThread extends Thread{

      //An arbitrary-size temporary holding buffer
      byte tempBuffer[] = new byte[10000];

      public void run(){
         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         stopped = false;
         try {//Loop until stopCapture is set
            // by another thread that
            // services the Stop button.
            while(! stopped){
              //Read data from the internal
              // buffer of the data line.
              int cnt = targetDataLine.read(tempBuffer,
                                            0,
                                            tempBuffer.length);
              if(cnt > 0)
                //Save data in output stream object.
                byteArrayOutputStream.write(tempBuffer, 0, cnt);
            }
            byteArrayOutputStream.close();
            // Here is where the array of integers is retrieved from the clip's file
            samples = bytesToSamples(byteArrayOutputStream.toByteArray());
	    resetSamples();
         }catch (Exception e) {
            System.out.println(e);
         }
      }
   }

   // Inner class to play back the data.
   private class PlayThread extends Thread{
     
      byte tempBuffer[] = new byte[10000];

      public void run(){
         try{
            int cnt;
            // Keep looping until the input read method returns -1 for empty stream.
            while((cnt = audioInputStream.read(tempBuffer, 0, tempBuffer.length)) != -1){
               if(cnt > 0)
                  // Write data to the internal buffer of the data line
                  // where it will be delivered to the speaker.
                  sourceDataLine.write(tempBuffer, 0, cnt);
                  if (stopped)
                     break;
            }
            // Block and wait for internal buffer of the data line to empty.
            sourceDataLine.drain();
            sourceDataLine.close();
            if (! stopped)
               statusField.setText(statusField.getText() + " done");
         }catch (Exception e) {
            System.out.println(e);
         }
      recordBtn.setEnabled(true);
      playBtn.setEnabled(true);
      stopBtn.setEnabled(false);      
      }
   }
   
   // sdl: helper
   private void resetSamples() {
       soundPanel.setSamples(samplesToInts(samples));
   }

   // Transfers bytes from byte array to the integers in the array of samples
   private Sample[] bytesToSamples(byte[] array){
      Sample[] s = new Sample[array.length];
      for (int i = 0; i < array.length; i++)
         s[i] = new Sample(array[i]);
      return s;
   }

   private byte[] samplesToBytes(Sample[] array){
      byte[] b = new byte[array.length];
      for (int i = 0; i < array.length; i++)
         b[i] = (byte)(array[i].getValue());
      return b;
   }
   
   // sdl: XXX assumes 16-bit little-endian
   private int [] samplesToInts(Sample [] array) {
       int [] samps = new int [array.length/2];
       for (int i=0; i<array.length; i+=2) {
	   samps[i>>1] = (samples[i+1].getValue() << 8) | samples[i].getValue();
       }
       return samps;
   }


    private class SoundIterator implements Iterator<Sample>{
        private int pos = 0;
      
        public boolean hasNext(){
            return pos < samples.length;
        }

        public Sample next(){
           if (! hasNext())
               throw new NoSuchElementException();
           pos++;
           return samples[pos - 1];
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
	 
	 private File openFileDialog(){
      JFileChooser chooser = new JFileChooser();
      chooser.setFileFilter(new SoundFileFilter(".wav", "WAV sounds (*.wav)"));
      int result = chooser.showOpenDialog(null);
      if (result == JFileChooser.CANCEL_OPTION)
         return null;
      else
         try{
            File file = chooser.getSelectedFile();
            return file;
         }catch(Exception e){
            JOptionPane.showMessageDialog(null,
                                          e.toString());
         }
         return null;
   }

   private File saveFileDialog(){
      JFileChooser chooser = new JFileChooser();
      chooser.setFileFilter(new SoundFileFilter(".wav", "WAV sounds (*.wav)"));
      int result = chooser.showSaveDialog(null);
      if (result == JFileChooser.CANCEL_OPTION)
         return null;
      else
         try{
            File file = chooser.getSelectedFile();
            return file;
         }catch(Exception e){
            JOptionPane.showMessageDialog(null,
                                          e.toString());
         }
         return null;
   }



}
      