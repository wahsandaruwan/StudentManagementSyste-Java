package Student;

import controller.StudentCon;
import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main_Window extends javax.swing.JFrame {

    Database db = new Database();

    public Main_Window() {
        initComponents();
        db.getConnection();
        show_students_in_Jtable();
        this.setLocationRelativeTo(null);
    }

    //Possition of a tuple
    int pos, count = 0;
    StudentCon sc = new StudentCon();

    //Check Input fields
    public boolean checkInputs() {
        if (txt_id.getText() == null || txt_name.getText() == null || txt_age.getText() == null || txt_address.getText() == null || txt_tele.getText() == null) {
            return false;
        } else {
            return true;
        }
    }

    //Populate default data in to table
    public void show_students_in_Jtable() {

        ArrayList<Student> list = sc.getStudentList();
        DefaultTableModel model = (DefaultTableModel) jTable_student.getModel();

        //clear tabel content
        model.setRowCount(0);

        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getAge();
            row[3] = list.get(i).getAddress();
            row[4] = list.get(i).getTele();
            
            model.addRow(row);
            count++;
        }
        lbl_count.setText("Records : "+Integer.toString(count));
    }

    //Populate search data in to table
    public void show_searchlist_in_Jtable() {
        ArrayList<Student> list = sc.getSearchList(txt_search.getText());
        DefaultTableModel model = (DefaultTableModel) jTable_student.getModel();

        //clear table content
        model.setRowCount(0);

        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getAge();
            row[3] = list.get(i).getAddress();
            row[4] = list.get(i).getTele();

            model.addRow(row);
        }
    }

    //Populate text fields
    public void showItem(int index) {
        txt_id.setText(Integer.toString(sc.getStudentList().get(index).getID()));
        txt_name.setText(sc.getStudentList().get(index).getName());
        txt_age.setText(Integer.toString(sc.getStudentList().get(index).getAge()));
        txt_address.setText(sc.getStudentList().get(index).getAddress());
        txt_tele.setText(Integer.toString(sc.getStudentList().get(index).getTele()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        txt_age = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_address = new javax.swing.JTextArea();
        txt_tele = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_student = new javax.swing.JTable();
        btn_insert = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_pre = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        lbl_count = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("ID :");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Name :");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Age :");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Address :");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Telephone :");

        txt_name.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N

        txt_id.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N

        txt_age.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N

        txt_address.setColumns(20);
        txt_address.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txt_address.setRows(5);
        jScrollPane1.setViewportView(txt_address);

        txt_tele.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N

        jTable_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Address", "Telephone"
            }
        ));
        jTable_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_studentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_student);

        btn_insert.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_insert.setText("Insert");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_next.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_next.setText(">");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_pre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_pre.setText("<");
        btn_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_preActionPerformed(evt);
            }
        });

        btn_first.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_first.setText("<<");
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        btn_last.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_last.setText(">>");
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        btn_search.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        txt_search.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(btn_insert))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_age)
                                    .addComponent(txt_id)
                                    .addComponent(txt_name)
                                    .addComponent(jScrollPane1)
                                    .addComponent(txt_tele, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_update)
                                .addGap(18, 18, 18)
                                .addComponent(btn_delete))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_first)
                        .addGap(23, 23, 23)
                        .addComponent(btn_pre)
                        .addGap(26, 26, 26)
                        .addComponent(btn_next)
                        .addGap(26, 26, 26)
                        .addComponent(btn_last))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search))
                    .addComponent(lbl_count))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_age, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_tele, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_insert)
                    .addComponent(btn_update)
                    .addComponent(btn_delete))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_first)
                    .addComponent(btn_pre)
                    .addComponent(btn_next)
                    .addComponent(btn_last))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_search)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_count)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        show_searchlist_in_Jtable();
    }//GEN-LAST:event_btn_searchActionPerformed

    //Insert Data
    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
        if (checkInputs()) {
            try {
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement("insert into students(name,age,address,telephone)" + "values(?,?,?,?)");
                ps.setString(1, txt_name.getText());
                ps.setString(2, txt_age.getText());
                ps.setString(3, txt_address.getText());
                ps.setString(4, txt_tele.getText());
                ps.executeUpdate();
                count = 0;
                show_students_in_Jtable();
                
                JOptionPane.showMessageDialog(null, "Data Inserted!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "One or more field are empty!");
        }
    }//GEN-LAST:event_btn_insertActionPerformed

    //Update Data
    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if (checkInputs() && txt_id.getText() != null) {
            try {
                String UpdateQuery = null;
                PreparedStatement ps = null;
                Connection con = db.getConnection();
                UpdateQuery = "update students set name = ?, age = ?, address = ?, telephone = ? where id = ?";
                ps = con.prepareStatement(UpdateQuery);
                ps.setString(1, txt_name.getText());
                ps.setString(2, txt_age.getText());
                ps.setString(3, txt_address.getText());
                ps.setString(4, txt_tele.getText());
                ps.setInt(5, Integer.parseInt(txt_id.getText()));
                ps.executeUpdate();
                count = 0;
                show_students_in_Jtable();

                JOptionPane.showMessageDialog(null, "Data Updated!");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "One or more field are empty!");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    //Delete Data
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if (!txt_id.getText().equals("")) {
            try {
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement("delete from students where id = ?");
                ps.setInt(1, Integer.parseInt(txt_id.getText()));
                ps.executeUpdate();
                count = 0;
                show_students_in_Jtable();

                JOptionPane.showMessageDialog(null, "Data Deleted!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter valid student id!");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void jTable_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_studentMouseClicked
        int index = jTable_student.getSelectedRow();
        showItem(index);
    }//GEN-LAST:event_jTable_studentMouseClicked

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        pos++;
        if (pos >= sc.getStudentList().size()) {
            pos = sc.getStudentList().size() - 1;
        }
        showItem(pos);
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        pos = 0;
        showItem(pos);
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        pos = sc.getStudentList().size() - 1;
        showItem(pos);
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_preActionPerformed
        pos--;
        if (pos < 0) {
            pos = 0;
        }
        showItem(pos);
    }//GEN-LAST:event_btn_preActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_pre;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_student;
    private javax.swing.JLabel lbl_count;
    private javax.swing.JTextArea txt_address;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_tele;
    // End of variables declaration//GEN-END:variables
}
