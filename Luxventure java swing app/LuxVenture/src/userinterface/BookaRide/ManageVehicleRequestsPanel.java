/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.BookaRide;

import Enterprise.main.EcoSystem;
import Enterprise.EmailAddress.EmailAlert;
import Enterprise.DiningMenu.MenuSelection;
import Enterprise.Payments.CustomerPayments;
import Enterprise.Customer.Customer;
import Enterprise.ServiceRequest.DiningMenuServiceRequest;
import Enterprise.ServiceRequest.VehicleServiceRequest;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vardhankaranam25
 */
public class ManageVehicleRequestsPanel extends javax.swing.JPanel {

    EcoSystem system;

    /**
     * Creates new form ManageRequests
     */
    public ManageVehicleRequestsPanel(EcoSystem system) {
        initComponents();

        this.system = system;
        populateVehicleRequestTable();
        formatRows();

    }

    //func - get values from work-request directory, checks for status
    public void populateVehicleRequestTable() {
        ArrayList<VehicleServiceRequest> pendingVehicleRequest = new ArrayList<VehicleServiceRequest>();
        ArrayList<VehicleServiceRequest> non_pendingVehicleRequest = new ArrayList<VehicleServiceRequest>();

        for (VehicleServiceRequest vehicleWRequest : system.getVehicleServiceRequestList().getVehicleServiceRequestList()) {
            if (vehicleWRequest.getStatus().equals("Pending")) {
                pendingVehicleRequest.add(vehicleWRequest);
            } else {
                non_pendingVehicleRequest.add(vehicleWRequest);
            }
        }

        populate_based_on_status(pendingVehicleRequest, non_pendingVehicleRequest);
    }

    public void populate_based_on_status(ArrayList<VehicleServiceRequest> pendingVehicleRequest, ArrayList<VehicleServiceRequest> non_pendingVehicleRequest) {
        DefaultTableModel model = (DefaultTableModel) tblVehicleRequests.getModel();
        model.setRowCount(0);
        for (VehicleServiceRequest vehicleWRequest : pendingVehicleRequest) {

            Object[] newRow = new Object[9];
            newRow[0] = vehicleWRequest;
            newRow[1] = vehicleWRequest.getVehicleDetails().getVehicleNumber();
            newRow[2] = vehicleWRequest.getVehicleDetails().getVehicleName();
            newRow[3] = vehicleWRequest.getVehicleDetails().getVehiclecategory();
            newRow[4] = vehicleWRequest.getVehicleDetails().getVehicleseater();
            newRow[5] = vehicleWRequest.getVehicleDetails().getVehicleprice();
            newRow[6] = vehicleWRequest.getNumberOfHours();
            newRow[7] = vehicleWRequest.getBookingDate();
            newRow[8] = vehicleWRequest.getStatus();

            model.addRow(newRow);
        }

        DefaultTableModel modelNon_Pending = (DefaultTableModel) tblVehicleConfirmed.getModel();
        modelNon_Pending.setRowCount(0);
        for (VehicleServiceRequest vehicleWRequest : non_pendingVehicleRequest) {

            Object[] newRow = new Object[9];
            newRow[0] = vehicleWRequest;
            newRow[1] = vehicleWRequest.getVehicleDetails().getVehicleNumber();
            newRow[2] = vehicleWRequest.getVehicleDetails().getVehicleName();
            newRow[3] = vehicleWRequest.getVehicleDetails().getVehiclecategory();
            newRow[4] = vehicleWRequest.getVehicleDetails().getVehicleseater();
            newRow[5] = vehicleWRequest.getVehicleDetails().getVehicleprice();
            newRow[6] = vehicleWRequest.getNumberOfHours();
            newRow[7] = vehicleWRequest.getBookingDate();
            newRow[8] = vehicleWRequest.getStatus();

            modelNon_Pending.addRow(newRow);
        }

    }

    void updateWorkRequestStatus(VehicleServiceRequest selectedVehicle, String status) {
        selectedVehicle.setStatus(status);
        int index = 0;
        for (VehicleServiceRequest vehicleWRequest : system.getVehicleServiceRequestList().getVehicleServiceRequestList()) {
            if (vehicleWRequest.getCustomerId().equals(selectedVehicle.getCustomerId())) {
                system.getVehicleServiceRequestList().updateVehicleServiceRequestList(vehicleWRequest, index);
                break;
            }
            index++;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehicleRequests = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVehicleConfirmed = new javax.swing.JTable();
        btnApprove = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 233, 174));
        setForeground(new java.awt.Color(140, 82, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(140, 82, 255));
        jLabel1.setText("MANAGE REQUESTS");

        tblVehicleRequests.setBackground(new java.awt.Color(255, 222, 242));
        tblVehicleRequests.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tblVehicleRequests.setForeground(new java.awt.Color(140, 82, 255));
        tblVehicleRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "User ID", "Vehicle Number", "Vehicle Name", "Category", "Seater", "Price per hour", "No of hours", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVehicleRequests);

        tblVehicleConfirmed.setBackground(new java.awt.Color(255, 222, 242));
        tblVehicleConfirmed.setForeground(new java.awt.Color(140, 82, 255));
        tblVehicleConfirmed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "User ID", "Vehicle Number", "Vehicle Name", "Category", "Seater", "Price per hour", "No of hours", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVehicleConfirmed);

        btnApprove.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnApprove.setForeground(new java.awt.Color(140, 82, 255));
        btnApprove.setText("APPROVE");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnReject.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnReject.setForeground(new java.awt.Color(140, 82, 255));
        btnReject.setText("REJECT");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(641, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApprove)
                    .addComponent(btnReject))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        // TODO add your handling code here:
        try {
            int selectedRowIndex = tblVehicleRequests.getSelectedRow();
            if (selectedRowIndex < 0) {
                JOptionPane.showMessageDialog(this, "Please select a row to approve.");
                return;
            }
            
            DefaultTableModel model = (DefaultTableModel) tblVehicleRequests.getModel();
            VehicleServiceRequest selectedVehicleServiceRequest = (VehicleServiceRequest) model.getValueAt(selectedRowIndex, 0);
            updateWorkRequestStatus(selectedVehicleServiceRequest, "Approved");
            CustomerPayments ct = new CustomerPayments();
            //User definition for email notif
            Customer getUser = system.getCustomerList().getCustomerById(selectedVehicleServiceRequest.getCustomerId());
            
            float vehiclebooking_finalprice = selectedVehicleServiceRequest.getNumberOfHours() * selectedVehicleServiceRequest.getVehicleDetails().getVehicleprice();
            ct.setCustomerId(selectedVehicleServiceRequest.getCustomerId());
            ct.setFacilityUsed("Vehicle Booked - " + selectedVehicleServiceRequest.getVehicleDetails().getVehicleName() + " for " + selectedVehicleServiceRequest.getNumberOfHours() + " hours");
            ct.setCheckoutprice(vehiclebooking_finalprice);
            system.getCustomerPaymentsList().addCustomerPayment(ct);
            //email notification
            new EmailAlert().sendEmail(getUser, "Vehicle",true);
            
            
            JOptionPane.showMessageDialog(this, "Request approved successfully and email notification sent");
            populateVehicleRequestTable();
            formatRows();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnApproveActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        // TODO add your handling code here:
        try {
            int selectedRowIndex = tblVehicleRequests.getSelectedRow();
            if (selectedRowIndex < 0) {
                JOptionPane.showMessageDialog(this, "Please select a row to approve.");
                return;
            }
            
            DefaultTableModel model = (DefaultTableModel) tblVehicleRequests.getModel();
            VehicleServiceRequest selectedVehicleServiceRequest = (VehicleServiceRequest) model.getValueAt(selectedRowIndex, 0);
            updateWorkRequestStatus(selectedVehicleServiceRequest, "Rejected");
            CustomerPayments ct = new CustomerPayments();
            //User definition for email notif
            Customer getUser = system.getCustomerList().getCustomerById(selectedVehicleServiceRequest.getCustomerId());
            
            float vehiclebooking_finalprice = selectedVehicleServiceRequest.getNumberOfHours() * selectedVehicleServiceRequest.getVehicleDetails().getVehicleprice();
            ct.setCustomerId(selectedVehicleServiceRequest.getCustomerId());
            ct.setFacilityUsed("Vehicle Booked - " + selectedVehicleServiceRequest.getVehicleDetails().getVehicleName() + " for " + selectedVehicleServiceRequest.getNumberOfHours() + " hours");
            ct.setCheckoutprice(vehiclebooking_finalprice);
            system.getCustomerPaymentsList().addCustomerPayment(ct);
            //email notification
            new EmailAlert().sendEmail(getUser, "Vehicle",false);
            JOptionPane.showMessageDialog(this, "Request rejected successfully");
            populateVehicleRequestTable();
            formatRows();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnRejectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnReject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblVehicleConfirmed;
    private javax.swing.JTable tblVehicleRequests;
    // End of variables declaration//GEN-END:variables


    private void formatRows() {

        DefaultTableModel model = (DefaultTableModel) tblVehicleConfirmed.getModel();

        tblVehicleConfirmed.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                String status = String.valueOf(model.getValueAt(row, 8));
                c.setBackground(status.equals("Pending") ? Color.WHITE : status.equals("Approved") ? Color.GREEN : Color.RED);
                return c;
            }
        });

    }
}