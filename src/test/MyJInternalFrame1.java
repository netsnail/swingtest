/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author tiger
 */
public class MyJInternalFrame1 extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame1
     */
    public MyJInternalFrame1() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setEastPane(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setSouthPane(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setWestPane(null);
        initComponents();
    }
    
    public MyJInternalFrame1(String txt) {
        this();
        jLabel1.setText(txt);
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

        getContentPane().setLayout(new java.awt.FlowLayout());

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}