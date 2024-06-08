/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.Customer;

import Enterprise.main.EcoSystem;
import Enterprise.Maintenance.Laundry.LaundryService;
import Enterprise.Customer.Customer;
import Enterprise.ServiceRequest.LaundryServiceRequest;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.MutableComboBoxModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vardhankaranam25
 */
public class LaundryPanel extends javax.swing.JPanel {

    /**
     * Creates new form LaundryPanel
     */
    EcoSystem system;
    Customer user;

    public LaundryPanel(EcoSystem system, Customer user) {
        initComponents();

        this.system = system;
        this.user = user;

        MutableComboBoxModel<String> model = new DefaultComboBoxModel<String>();

        for (LaundryService laundryList : system.getLaundryServiceList().getLaundryDirectory()) {
            model.addElement(laundryList.getCategory());
        }

        chooseLaundryDropdown.setModel(model);

        categoryNameTxt.setEditable(false);
        priceTxt.setEditable(false);

        populateRequestTable();
        formatRows();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        priceTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        categoryNameTxt = new javax.swing.JTextField();
        numberOfClothesTxt = new javax.swing.JTextField();
        bookLaundryBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        laundryWorkQueueTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        viewPriceBtn = new javax.swing.JButton();
        chooseLaundryDropdown = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(null);
        add(priceTxt);
        priceTxt.setBounds(730, 370, 160, 23);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Laundry Booking Status");
        add(jLabel9);
        jLabel9.setBounds(400, 530, 210, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Category Name:");
        add(jLabel3);
        jLabel3.setBounds(220, 370, 110, 20);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Enter Number of clothes:");
        add(jLabel8);
        jLabel8.setBounds(300, 450, 160, 20);
        add(categoryNameTxt);
        categoryNameTxt.setBounds(370, 370, 160, 23);
        add(numberOfClothesTxt);
        numberOfClothesTxt.setBounds(490, 440, 160, 23);

        bookLaundryBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bookLaundryBtn.setText("Book Laundry");
        bookLaundryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookLaundryBtnActionPerformed(evt);
            }
        });
        add(bookLaundryBtn);
        bookLaundryBtn.setBounds(690, 430, 150, 50);

        laundryWorkQueueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category Name", "Price per cloth", "Number of clothes", "Total price", "Request Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(laundryWorkQueueTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(110, 580, 918, 257);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Book Laundry");
        add(jLabel1);
        jLabel1.setBounds(410, 200, 260, 30);

        viewPriceBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        viewPriceBtn.setText("View Price");
        viewPriceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPriceBtnActionPerformed(evt);
            }
        });
        add(viewPriceBtn);
        viewPriceBtn.setBounds(740, 270, 110, 30);

        add(chooseLaundryDropdown);
        chooseLaundryDropdown.setBounds(570, 280, 148, 23);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price per cloth:");
        add(jLabel6);
        jLabel6.setBounds(600, 370, 100, 20);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Laundryroom300.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, -60, 1590, 1120);
    }// </editor-fold>//GEN-END:initComponents

    private void bookLaundryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookLaundryBtnActionPerformed
        // Book a vehicle after entering details
        LaundryServiceRequest bookLaundry = new LaundryServiceRequest();

        try {
            if (chooseLaundryDropdown.getSelectedItem() != null) {
                String laundryName = String.valueOf(chooseLaundryDropdown.getSelectedItem());
                LaundryService laundryDetails = system.getLaundryServiceList().getLaundryByName(laundryName);
                int numberOfClothes = Integer.parseInt(numberOfClothesTxt.getText());

                bookLaundry.setLaundryDetails(laundryDetails);
                bookLaundry.setNumberOfClothes(numberOfClothes);
                bookLaundry.setCustomerId(user.getCustomerId());
                bookLaundry.setStatus("Pending");

                system.getLaundryServiceRequestList().getLaundryServiceRequestList().add(bookLaundry);

                JOptionPane.showMessageDialog(this, "Laundry booking request sent to Manager");
                populateRequestTable();
                clearFields();
                formatRows();

            } else {
                JOptionPane.showMessageDialog(this, "Enter valid number of clothes values for booking Laundry");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Enter valid number of clothes values for booking Laundry");
        }
    }//GEN-LAST:event_bookLaundryBtnActionPerformed

    private void viewPriceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPriceBtnActionPerformed
        // View Vehicle Details on choosing

        try {
            if (chooseLaundryDropdown.getSelectedItem() != null) {

                String laundryName = String.valueOf(chooseLaundryDropdown.getSelectedItem());
                LaundryService laundryDetails = system.getLaundryServiceList().getLaundryByName(laundryName);

                categoryNameTxt.setText(laundryDetails.getCategory());
                priceTxt.setText(String.valueOf(laundryDetails.getPrice()));

            } else {
                JOptionPane.showMessageDialog(this, "Choose a valid Laundry category for booking");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Choose a valid Laundry category for booking");
        }
    }//GEN-LAST:event_viewPriceBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookLaundryBtn;
    private javax.swing.JTextField categoryNameTxt;
    private javax.swing.JComboBox<String> chooseLaundryDropdown;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable laundryWorkQueueTable;
    private javax.swing.JTextField numberOfClothesTxt;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JButton viewPriceBtn;
    // End of variables declaration//GEN-END:variables

    private void populateRequestTable() {

        try {
            DefaultTableModel model = (DefaultTableModel) laundryWorkQueueTable.getModel();
            model.setRowCount(0);

            for (LaundryServiceRequest laundryWorkRequest : system.getLaundryServiceRequestList().getLaundryServiceRequestList()) {

                if (laundryWorkRequest.getCustomerId().equals(user.getCustomerId())) {
                    Object[] newRow = new Object[5];
                    newRow[0] = laundryWorkRequest.getLaundryDetails().getCategory();
                    newRow[1] = laundryWorkRequest.getLaundryDetails().getPrice();
                    newRow[2] = laundryWorkRequest.getNumberOfClothes();
                    newRow[3] = (laundryWorkRequest.getLaundryDetails().getPrice() * laundryWorkRequest.getNumberOfClothes());
                    newRow[4] = laundryWorkRequest.getStatus();

                    model.addRow(newRow);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void clearFields() {

        categoryNameTxt.setText("");
        priceTxt.setText("");
        numberOfClothesTxt.setText("");

    }
    
    private void formatRows() {

        DefaultTableModel model = (DefaultTableModel) laundryWorkQueueTable.getModel();

        laundryWorkQueueTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                String status = String.valueOf(model.getValueAt(row, 4));
                c.setBackground(status.equals("Pending") ? Color.WHITE : status.equals("Approved") ? Color.GREEN : Color.RED);
                return c;
            }
        });

    }
}
