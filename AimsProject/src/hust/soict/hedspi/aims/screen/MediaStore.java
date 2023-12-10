package hust.soict.hedspi.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;


public class MediaStore extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Media media;
    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        if(media instanceof Playable) {
        	JButton playButton = new JButton("Play");
        	container.add(playButton);
        	if(media instanceof DigitalVideoDisc) {
        		playButton.addActionListener(new PlayDVDListener());
        	}
        	if(media instanceof CompactDisc) {
        		playButton.addActionListener(new PlayCDListener());
        	}
        }
        
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    private class PlayDVDListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	DigitalVideoDisc dvd = (DigitalVideoDisc) media;
        	JOptionPane.showMessageDialog(null, "Title of DVD: " + dvd.getTitle() + " \nLength of DVD: " + dvd.getLength(), "Play DVD", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private class PlayCDListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	CompactDisc cd = (CompactDisc) media;
        	StringBuilder stringBuilder = new StringBuilder("Title of CD: " + cd.getTitle() + "\nLength of CD: " + cd.getLength());
        	for(Track track : cd.getTrack()) {
        		stringBuilder.append("\n" + track.getTitle() + " - length: " + track.getLength());
        	}
        	JOptionPane.showMessageDialog(null, stringBuilder, "Play CD", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
