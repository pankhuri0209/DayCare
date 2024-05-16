/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200;

import edu.neu.csye6200.controller.StudentController;
import edu.neu.csye6200.controller.TeacherController;
import edu.neu.csye6200.controller.VaccinationController;
import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.service.ClassroomFactory;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TeachersjPanel extends javax.swing.JPanel {

    /**
     * Creates new form StudentsjPanel
     */
    
    @Autowired
    TeacherController teacherController;
    @Autowired
    StudentController studentController;
    @Autowired
    VaccinationController vaccinationController;
    @Autowired
    ClassroomFactory classroomFactory;
    
    public TeachersjPanel() {
        initComponents();
    }

    @PostConstruct
    public void init() {
        try {
            populateBodyTeacher();
        } catch (Exception c) {
            c.printStackTrace();
            System.out.println("Something Went Wrong!");
        }
    }
    
    private void populateBodyTeacher() {
        List<Teacher> teachers = teacherController.getAllTeachers();

        if (teachers.size() == 0) {
            teacherController.addTestData();

            // Add teachers to classroom
            List<Teacher> newTeachers = teacherController.getAllTeachers();
            List<Classroom> allClassRooms = ClassroomFactory.readAllClassRooms();
            int counter = 0;
            try {
                for (Classroom classroom : allClassRooms) {
                    int tempCounter = 0;
                    while (tempCounter < classroom.getMaxGroups()) {
                        classroom.addTeacherId(newTeachers.get(counter + tempCounter).getId());
                        tempCounter++;
                    }
                    counter += tempCounter;
                }
            } catch (Exception ex) {
                System.out.println("****** Not Enough Teachers. Please Add at least 16 teachers ****");
                System.exit(1);
            }

        } else {
            DefaultTableModel model = (DefaultTableModel) tableTeachers.getModel();

            if (model.getRowCount() == 0) {
                teachers.forEach(t -> {
                    model.addRow(new Object[]{t.getId(), t.getName(), t.getAge(), t.getCredits()});
                });
//            List<Classroom> allClassRooms = ClassroomFactory.getAllClassRooms();
//                int counter = 0;
//                try {
//                    for (Classroom classroom : allClassRooms) {
//                        int tempCounter = 0;
//                        while (tempCounter < classroom.getMaxGroups()) {
//                            classroom.addTeacherId(teachers.get(counter + tempCounter).getId());
//                            tempCounter++;
//                        }
//                        counter += tempCounter;
//                    }
//                } catch (Exception ex) {
//                    System.out.println("****** Not Enough Teachers. Please Add at least 16 teachers ****");
//                    System.exit(1);
//                }
                }

            }
//                       try{
//            FileInputStream fis = 
//                    new FileInputStream("D:\\code\\swing\\Final\\OOD_Final_Project_Daycare\\DayCare\\src\\com\\ood\\ui\\teachers.bin");
//            // "C:\\Users\\Admin\\Documents\\NetBeansProjects\\Test1\\src\\main\\java\\com\\mycompany\\test1\\file.bin"
//            // getClass().getResource("/com/ood/ui/add.png"))
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            
//            Vector<Vector> tableData = (Vector<Vector>) ois.readObject();            
//            
//            ois.close();
//            fis.close();
//            
//           DefaultTableModel model = (DefaultTableModel) tableTeachers.getModel();
//            // Fill the Table
//               for (int i = 0; i < tableData.size(); i++) {
//                   Vector row = tableData.get(i);
//                   model.addRow(new Object[]{row.get(0),row.get(1),row.get(2),row.get(3)});
//               }
//                    
//              
//            
//        } catch (Exception ex){
//                   System.out.println("*********** Creating Teachers for the first time *********");
//                   
//          //  ex.printStackTrace();
//        }
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tfId1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfName1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnAdd1 = new javax.swing.JButton();
        btnClear1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTeachers = new javax.swing.JTable();
        tfAge1 = new javax.swing.JTextField();
        tfCredits = new javax.swing.JTextField();
        btnDelete1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 720));

        jLabel3.setBackground(new java.awt.Color(153, 255, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Teacher Registration");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Teacher", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel4.setForeground(java.awt.Color.gray);
        jPanel4.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(java.awt.Color.gray);
        jLabel10.setText("Id");

        tfId1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfId1.setToolTipText("");
        tfId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfId1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(java.awt.Color.gray);
        jLabel11.setText("Name");

        tfName1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfName1.setToolTipText("");
        tfName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfName1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(java.awt.Color.gray);
        jLabel12.setText("Age");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(java.awt.Color.gray);
        jLabel13.setText("Ratings");

        btnAdd1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd1.setForeground(new java.awt.Color(51, 51, 51));
        btnAdd1.setText("Add");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });

        btnClear1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear1.setForeground(new java.awt.Color(51, 51, 51));
        btnClear1.setText("Clear");
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        tableTeachers.setBackground(new java.awt.Color(204, 204, 204));
        tableTeachers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tableTeachers.setForeground(new java.awt.Color(102, 102, 102));
        tableTeachers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Age", "Credits"
            }
        ));
        jScrollPane2.setViewportView(tableTeachers);
        if (tableTeachers.getColumnModel().getColumnCount() > 0) {
            tableTeachers.getColumnModel().getColumn(0).setResizable(true);
            tableTeachers.getColumnModel().getColumn(1).setResizable(true);
            tableTeachers.getColumnModel().getColumn(2).setResizable(true);
        }

        tfAge1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfAge1.setToolTipText("");
        tfAge1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAge1ActionPerformed(evt);
            }
        });

        tfCredits.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfCredits.setToolTipText("");
        tfCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCreditsActionPerformed(evt);
            }
        });

        btnDelete1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete1.setText("Delete");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addGap(612, 612, 612))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfAge1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfName1)
                            .addComponent(tfId1)
                            .addComponent(tfCredits))))
                .addGap(269, 269, 269))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(tfAge1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAdd1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btnClear1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(277, 277, 277))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfId1ActionPerformed

    private void tfName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfName1ActionPerformed

    private void tfAge1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAge1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAge1ActionPerformed

    private void tfCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCreditsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCreditsActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:

        String id = tfId1.getText();
        String age = tfAge1.getText();
        String name = tfName1.getText();
        String credit = tfCredits.getText();

        if (id.isEmpty() || age.isEmpty() || name.isEmpty() || credit.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter All Fields", "Try Again", JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultTableModel model = (DefaultTableModel) tableTeachers.getModel();
            model.addRow(new Object[]{id, name, age, credit});
        }

        tfId1.setText("");
        tfAge1.setText("");
        tfName1.setText("");
        tfCredits.setText("");

        // add to bin file
        // TODO add your handling code here:
//       DefaultTableModel model = (DefaultTableModel) tableTeachers.getModel();
//        Vector<Vector> tableData = model.getDataVector();
//        
//        // Saving the Object in a File
//        try{
//            FileOutputStream fos = 
//                    new FileOutputStream("D:\\code\\swing\\Final\\OOD_Final_Project_Daycare\\DayCare\\src\\com\\ood\\ui\\teachers.bin");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            
//            oos.writeObject(tableData);
//            oos.close();
//            fos.close();
//        } catch (Exception ex){
//            ex.printStackTrace();
//        }
        //push to db
        String csv = id + "," + name + "," + age + "," + credit;
        System.err.println(csv + "is added to teache db");
        teacherController.addTeacher(csv);
        // Adding teacher to last classroom
        ClassroomFactory.readAllClassRooms().get(ClassroomFactory.readAllClassRooms().size()-1).addTeacherId(Integer.parseInt(id));
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        // TODO add your handling code here:
        tfId1.setText("");
        tfAge1.setText("");
        tfName1.setText("");
        tfCredits.setText("");
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int row = tableTeachers.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "No Row is Selected", "Please Select Row", JOptionPane.ERROR_MESSAGE);
        } else {
            //int pkid = (int)tableTeachers.getModel().getValueAt(row, 0);
            DefaultTableModel model = (DefaultTableModel) tableTeachers.getModel();
            //            String k = model.getValueAt(0, 0).toString();
            //            System.err.println(k + " is about to deleted : " + row);

            int pkid = Integer.parseInt(model.getValueAt(row, 0).toString());
            model.removeRow(row);

            System.err.println(pkid + " is deleted : " + row);
            //int age = teacherController.getTeacherById(pkid).get().getAge();

            teacherController.removeTeacherById(pkid);

            //            Classroom classRoom = classroomFactory.getClassRoom(age);
            //            classRoom.removeStudentId(pkid);
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableTeachers;
    private javax.swing.JTextField tfAge1;
    private javax.swing.JTextField tfCredits;
    private javax.swing.JTextField tfId1;
    private javax.swing.JTextField tfName1;
    // End of variables declaration//GEN-END:variables
}
