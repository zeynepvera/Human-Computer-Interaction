
package com.mycompany.human_computer;


public class LibraryGUIView extends javax.swing.JFrame {

    private LibraryController controller= new LibraryController();
 
    public LibraryGUIView(LibraryController controller) {
        this.controller=controller;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addbookbutton = new javax.swing.JButton();
        listbookbutton = new javax.swing.JButton();
        searchbookbutton = new javax.swing.JButton();
        deletebookbutton = new javax.swing.JButton();
        exitbookbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Library Managment System");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Click the number 1-5 to apply");

        addbookbutton.setText("Add Book");
        addbookbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbookbuttonActionPerformed(evt);
            }
        });

        listbookbutton.setText("List Book");
        listbookbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listbookbuttonActionPerformed(evt);
            }
        });

        searchbookbutton.setText("Search Book");
        searchbookbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbookbuttonActionPerformed(evt);
            }
        });

        deletebookbutton.setText("Delete Book");
        deletebookbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebookbuttonActionPerformed(evt);
            }
        });

        exitbookbutton.setText("Exit");
        exitbookbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbookbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(addbookbutton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listbookbutton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchbookbutton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(exitbookbutton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deletebookbutton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(577, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(addbookbutton)
                .addGap(18, 18, 18)
                .addComponent(listbookbutton)
                .addGap(18, 18, 18)
                .addComponent(searchbookbutton)
                .addGap(18, 18, 18)
                .addComponent(deletebookbutton)
                .addGap(18, 18, 18)
                .addComponent(exitbookbutton)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addbookbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbookbuttonActionPerformed
        setVisible(false);
        AddBook add= new AddBook(new LibraryController());
        add.setVisible(true);

    }//GEN-LAST:event_addbookbuttonActionPerformed

    private void listbookbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listbookbuttonActionPerformed
         setVisible(false);
         ListBook list= new ListBook(new LibraryController());
         list.setVisible(true);
    }//GEN-LAST:event_listbookbuttonActionPerformed

    private void searchbookbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbookbuttonActionPerformed
        SearchBook search= new SearchBook(new LibraryController());
        search.setVisible(true);
               
    }//GEN-LAST:event_searchbookbuttonActionPerformed

    private void deletebookbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebookbuttonActionPerformed
     
        setVisible(false);
        DeleteBook delete= new DeleteBook();
        delete.setVisible(true);


    }//GEN-LAST:event_deletebookbuttonActionPerformed

    private void exitbookbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbookbuttonActionPerformed
     
        dispose();


    }//GEN-LAST:event_exitbookbuttonActionPerformed

 
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
            java.util.logging.Logger.getLogger(LibraryGUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibraryGUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibraryGUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryGUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LibraryController controller= new LibraryController();
                new LibraryGUIView(controller).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbookbutton;
    private javax.swing.JButton deletebookbutton;
    private javax.swing.JButton exitbookbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton listbookbutton;
    private javax.swing.JButton searchbookbutton;
    // End of variables declaration//GEN-END:variables
}
