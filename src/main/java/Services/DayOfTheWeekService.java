package Services;

import Interface.Service;

import javax.swing.*;

public class DayOfTheWeekService implements Service {
    JLabel outputLabel;
    JComboBox month;
    JTextField day;
    JTextField year;
    @Override
    public JPanel getGuiPanel() {
        return null;
    }
}
