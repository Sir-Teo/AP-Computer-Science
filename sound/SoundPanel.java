package sounds;

import java.awt.*;
import javax.swing.*;

/**
 * LICENSE: This is open-source software released under the terms of the<BR>
 * GPL (http://www.gnu.org/licenses/gpl.html).<BR><BR> 
 *
* This class implements a panel for displaying sound samples.
*/
public class SoundPanel extends JPanel{
    
    // fraction of Y axis used for drawing
    private static final double YRANGE = 0.7;
    
    private int [] samples;
    private int max;
    
    public SoundPanel(int width, int height, int [] samples){
	setSamples(samples);
	setBackground(Color.black);
	setPreferredSize(new Dimension(width, height));
	setMaximumSize(new Dimension(1600, height));
    }
    
    /**
    * Draws the samples in the panel if they exist.
    */
    public void paintComponent(Graphics g){
	super.paintComponent(g);
	g.setColor(Color.white);
	int width = getWidth();
	int height = getHeight();
	int center = height / 2;
	g.drawLine(0, center, width, center);
	if (samples == null || samples.length == 0 ) return;
	// Adjusts sames to fit the height of the panel
	setMaximumSize(new Dimension(samples.length, height));
	if (samples.length == 0) return;
	
	// sdl: loop over X-axis pixels, drawing from min to max sample in
	// corresponding data window
	double yscale = height / (2.*max);
	for (int x = 0; x<width-1; ++x) {
	    int x1 = x + 1;
	    int i1 = pixToIndex(x, width);
	    int i2 = pixToIndex(x1, width);
	    int ymin = min(samples, i1, i2);
	    int ymax = max(samples, i1, i2);
	    int y  = sampToPix(ymin, center, yscale);
	    int y1 = sampToPix(ymax, center, yscale);
	    g.drawLine(x, y, x1, y1);
	}
    }
    
    /**
    * Resets the samples and redraws them in the panel.
    * @param samples the samples to be displayed
    */
    public void setSamples(int [] samples){
        this.samples = samples;
	this.max = max(samples, 0, samples.length);
        repaint();
    }
    
    // sdl: convert X-axis pixel coordinate to sample index
    private int pixToIndex(int x, int width) {
	return (int)((double)x * samples.length / width);
	
    }
    
    // sdl: convert sample to Y-axis pixel coordinate
    private static int sampToPix(int y, int center, double yscale) {
	return (int)(center + y*yscale*YRANGE);
    }
    
    // sdl: max function over integer array
    private static int max(int [] v, int beg, int end) {
	int vmax = Integer.MIN_VALUE;
	for (int i=beg; i<end; ++i) {
	    if (v[i] > vmax) {
		vmax = v[i];
	    }
	}
	return vmax;
    }
    
     // sdl: min function over integer array
    private static int min(int [] v, int beg, int end) {
	int vmin = Integer.MAX_VALUE;
	for (int i=beg; i<end; ++i) {
	    if (v[i] < vmin) {
		vmin = v[i];
	    }
	}
	return vmin;
    }
   
}
