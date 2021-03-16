
package provapoo1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPrincipal extends javax.swing.JFrame {
    private Videoteca videoteca;
    private Opiniões opinioes; 
    
    public MenuPrincipal() {
        initComponents();
    
        try{
            todosfilmes();
        }
        catch (FileNotFoundException ex){
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null,ex);
        }
        filmesdocombox();
       
    }        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        listadefilmes = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        sinopsearea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Selecione o filme : ");

        listadefilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadefilmesActionPerformed(evt);
            }
        });

        jButton1.setText("Selecionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        sinopsearea.setColumns(20);
        sinopsearea.setLineWrap(true);
        sinopsearea.setRows(5);
        sinopsearea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(sinopsearea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listadefilmes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(15, 15, 15))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(listadefilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

      private void todosfilmes() throws FileNotFoundException
    {
        List<Filme> comboxfilmes = new ArrayList<>();
        List<Avaliação> areaOpiniões = new ArrayList<>();
        String[] content = null;
        
        Scanner scanner = new Scanner(new File("..\\PROVAPOO1\\banco de dados\\listafilmes.csv")); 
        scanner.useDelimiter("\n");   
        
        while(scanner.hasNext())
        {
            content = scanner.next().trim().split(";");
            
            comboxfilmes.add(new Filme(Integer.parseInt(content[0]), content[1], content[2], content[3]));                   
        }
        
        scanner = new Scanner(new File("..\\PROVAPOO1\\banco de dados\\opinioes.csv"));       
        scanner.useDelimiter("\n");
        
        while(scanner.hasNext())
        {
            content = scanner.next().trim().split(";");
            
            areaOpiniões.add(new Avaliação(Integer.parseInt(content[0]), content[1], Integer.parseInt(content[2]), content[3]));         
        }
        scanner.close();
        
        videoteca = new Videoteca(comboxfilmes.toArray(new Filme[comboxfilmes.size()]));       
        opinioes = new Opiniões(areaOpiniões.toArray(new Avaliação[areaOpiniões.size()]));
    }
       private void filmesdocombox() 
    {
        for(String nomefilme : videoteca.getAllTodosFilmes())
        {
            listadefilmes.addItem(nomefilme);
        
        }     
    }   
      
      
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here: Movie movie = null;
        Filme filmes = null;
        Avaliação highAssessment = null;
        Avaliação lowAssessment = null;
        String selectedName = null; 
        int movieIndex = -1;
        DefaultListModel model = new DefaultListModel();
        
        selectedName = listadefilmes.getSelectedItem().toString();
        
        movieIndex = videoteca.procurafilme(selectedName);
                
        filmes = videoteca.getFilmes()[movieIndex];
        jList1.setModel(model);
        model.addElement("Nome do filme: " + filmes.getNome());
        model.addElement("Genero: " + filmes.getGenero());
        model.addElement("Média de avaliações: " + String.format("%.2f", opinioes.mediafilme(filmes.getCodigo())));
        
        highAssessment = opinioes.maiornota(filmes.getCodigo());
        
        model.addElement("Nome do Avaliador: " + highAssessment.getUsuario());
        model.addElement("Comentário do Avaliador: " + highAssessment.getComentario());
        model.addElement("Nota mais alta: " + highAssessment.getNota());
        
        lowAssessment = opinioes.piornota(filmes.getCodigo());
        model.addElement("Nome do Avaliador: " + lowAssessment.getUsuario());
        model.addElement("Comentário do Avaliador: " + lowAssessment.getComentario());
        model.addElement("Nota mais baixa: " + lowAssessment.getNota());
        
        sinopsearea.setText(filmes.getSinopse());
        
       
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listadefilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadefilmesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listadefilmesActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> listadefilmes;
    private javax.swing.JTextArea sinopsearea;
    // End of variables declaration//GEN-END:variables
}
