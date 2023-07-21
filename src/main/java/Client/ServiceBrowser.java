package Client;

import Interface.Service;
import Interface.ServiceServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

public class ServiceBrowser {
    JPanel mainPanel;
    JComboBox serviceList; // под вопросом
    ServiceServer server;

    public void buildGUI(){
        JFrame frame = new JFrame("RMI Browser");
        mainPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER,serviceList);

        Object[] services = getServiceList();
        serviceList = new JComboBox(services);

        frame.getContentPane().add(BorderLayout.NORTH,serviceList);
        serviceList.addActionListener(new MyListListener());

        frame.setSize(500,500);
        frame.setVisible(true);
    }
    void loadService (Object serviceSelection){
        try {
            Service svc = server.getService(serviceSelection);

            mainPanel.removeAll();
            mainPanel.add(svc.getGuiPanel());
            mainPanel.validate();
            mainPanel.repaint();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    Object[] getServiceList(){
        Object obj = null;
        Object[] services = null;
        try {
            obj = Naming.lookup("rmi://127.0.0.1/ServiceServer");
        }catch (Exception e){
            e.printStackTrace();
        }
        server = (ServiceServer) obj;
        try {
            services = server.getServiceList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  services;
    }
    class MyListListener implements ActionListener {
        public void actionPerformed(ActionEvent ev){
            Object selection = serviceList.getSelectedItem();
            loadService(selection);
        }
    }

    public static void main(String[] args) {
        new ServiceBrowser().buildGUI();
    }
}








































