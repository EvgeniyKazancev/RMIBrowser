package Services;

import Interface.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniMusicService implements Service {
    MyDrawPanel myPanel;
    public JPanel getGuiPanel(){
        JPanel mainPanel = new JPanel();
        myPanel = new MyDrawPanel();
        JButton playItButton = new JButton("Play it");
        playItButton.addActionListener(new PlayItListener());
        mainPanel.add(myPanel);
        mainPanel.add(playItButton);
        return mainPanel;
    }
    public class PlayItListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            try {

            }
        }
    }
}
