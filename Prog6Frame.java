/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**

 @author Shane
 */
public class Prog6Frame extends javax.swing.JFrame
{
   private String token;
   private Stack tempStack;
   private Queue tempQueue;
   private RpnEvaluator rpne;
   /**
    Creates new form Prog6Frame
    */
   public Prog6Frame()
   {
      initComponents();
   }

   /**
    This method is called from within the constructor to initialize the form.
    WARNING: Do NOT modify this code. The content of this method is always
    regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents()
   {

      rawExpresLabel = new javax.swing.JLabel();
      expressionField = new javax.swing.JTextField();
      answerLabel = new javax.swing.JLabel();
      answerField = new javax.swing.JTextField();
      queueLabel = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      queueArea = new javax.swing.JTextArea();
      stackLabel = new javax.swing.JLabel();
      jScrollPane2 = new javax.swing.JScrollPane();
      stackArea = new javax.swing.JTextArea();
      stepBtn = new javax.swing.JButton();
      clearBtn = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      rawExpresLabel.setText("Raw RPN expression");

      answerLabel.setText("Answer");

      queueLabel.setText("Queue");

      queueArea.setColumns(20);
      queueArea.setRows(5);
      jScrollPane1.setViewportView(queueArea);

      stackLabel.setText("Stack");

      stackArea.setColumns(20);
      stackArea.setRows(5);
      jScrollPane2.setViewportView(stackArea);

      stepBtn.setText("Step");
      stepBtn.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            stepBtnActionPerformed(evt);
         }
      });

      clearBtn.setText("Click to clear all");
      clearBtn.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            clearBtnActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(47, 47, 47)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(answerLabel)
                  .addGap(18, 18, 18)
                  .addComponent(answerField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(queueLabel))
                  .addGap(18, 18, 18)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(stackLabel)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(stepBtn)
                           .addComponent(clearBtn)))))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(rawExpresLabel)
                  .addGap(18, 18, 18)
                  .addComponent(expressionField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(25, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(queueLabel)
               .addComponent(stackLabel))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                     .addComponent(jScrollPane2))
                  .addGap(18, 18, 18)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(rawExpresLabel)
                     .addComponent(expressionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(answerLabel)
                     .addComponent(answerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(62, 62, 62))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(stepBtn)
                  .addGap(18, 18, 18)
                  .addComponent(clearBtn)
                  .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void stepBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_stepBtnActionPerformed
   {//GEN-HEADEREND:event_stepBtnActionPerformed
      token = stackArea.toString();
      if(rpne == null)
         rpne = new RpnEvaluator(token);
      rpne.processToken();
      outputStack();
      outputQueue();
   }//GEN-LAST:event_stepBtnActionPerformed

   private void clearBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearBtnActionPerformed
   {//GEN-HEADEREND:event_clearBtnActionPerformed
      tempStack.clear();
      tempQueue.clear();
   }//GEN-LAST:event_clearBtnActionPerformed

   private void outputStack()
   {
      tempStack = rpne.getStack();
      while(!tempStack.isEmpty())
      {
         stackArea.add(tempStack.pop().toString(), this);
      }
   }
   
   private void outputQueue()
   {
      tempQueue = rpne.getQueue();
      while(!tempStack.isEmpty())
      {
         stackArea.add(tempQueue.remove().toString(), this);
      }
   }
   
   
   
   
   
   
   /**
    @param args the command line arguments
    */
   public static void main(String args[])
   {
      /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
       * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try
      {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
         {
            if ("Nimbus".equals(info.getName()))
            {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      }
      catch (ClassNotFoundException ex)
      {
         java.util.logging.Logger.getLogger(Prog6Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (InstantiationException ex)
      {
         java.util.logging.Logger.getLogger(Prog6Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (IllegalAccessException ex)
      {
         java.util.logging.Logger.getLogger(Prog6Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (javax.swing.UnsupportedLookAndFeelException ex)
      {
         java.util.logging.Logger.getLogger(Prog6Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
        //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new Prog6Frame().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField answerField;
   private javax.swing.JLabel answerLabel;
   private javax.swing.JButton clearBtn;
   private javax.swing.JTextField expressionField;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTextArea queueArea;
   private javax.swing.JLabel queueLabel;
   private javax.swing.JLabel rawExpresLabel;
   private javax.swing.JTextArea stackArea;
   private javax.swing.JLabel stackLabel;
   private javax.swing.JButton stepBtn;
   // End of variables declaration//GEN-END:variables
}
