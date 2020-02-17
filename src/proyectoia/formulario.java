package proyectoia;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class formulario extends javax.swing.JFrame {

  
    public formulario() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        text_ph = new javax.swing.JTextField();
        text_temp = new javax.swing.JTextField();
        text_humedad = new javax.swing.JTextField();
        text_altitud = new javax.swing.JTextField();
        text_precip = new javax.swing.JTextField();
        text_sombra = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        text_tierra = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        Resultado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoia/img/images (2).jpeg"))); // NOI18N
        jLabel9.setPreferredSize(new java.awt.Dimension(600, 400));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.darkGray);
        setMinimumSize(new java.awt.Dimension(600, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tierra");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ph");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Temperatura");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Humedad");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Altitud");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, 20));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precipitación");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sombra");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("INTELIGENCIA ARTIFICIAL");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 102, 255));
        jLabel10.setText("TECNOLOGICO NACIONAL DE MÉXICO");
        jLabel10.setMaximumSize(new java.awt.Dimension(600, 40));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("CAMPUS TUXTLA GUTIERREZ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));
        getContentPane().add(text_ph, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 75, -1));
        getContentPane().add(text_temp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 75, -1));

        text_humedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_humedadActionPerformed(evt);
            }
        });
        getContentPane().add(text_humedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 75, -1));
        getContentPane().add(text_altitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 69, -1));
        getContentPane().add(text_precip, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 69, -1));
        getContentPane().add(text_sombra, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 69, -1));

        btnEnviar.setBackground(new java.awt.Color(204, 204, 204));
        btnEnviar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnEnviar.setText("Calcular");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, -1));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 133, -1, -1));

        text_tierra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------", "Arcillosa", "Limosa", "Arenosa", "Tierra Negra", "Otro" }));
        text_tierra.setToolTipText("");
        text_tierra.setAutoscrolls(true);
        text_tierra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        text_tierra.setName("text_tierra"); // NOI18N
        getContentPane().add(text_tierra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 90, 30));

        jTextField1.setBackground(new java.awt.Color(240, 240, 240));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setText("Porcentaje de éxito:");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 130, 50));

        Resultado.setBackground(new java.awt.Color(240, 240, 240));
        Resultado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Resultado.setToolTipText("");
        Resultado.setName("Resultado"); // NOI18N
        getContentPane().add(Resultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 80, 50));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("mm.");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 30, -1));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("°C");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("msnm.");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 40, 20));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("%");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, -1, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("%");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoia/img/images (2).jpeg"))); // NOI18N
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 600, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void text_humedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_humedadActionPerformed
     
    }//GEN-LAST:event_text_humedadActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        
        Double resta=0.0;
        //Valor de tierra
        /*
        int itierra= tierra.getSelectedIndex();
        String vtierra="";
        switch(itierra){
            case 0: vtierra="vacio"; resta=resta+1;
            break;
            case 1: vtierra="(tierra arcillosa)"; 
            break;
            case 2: vtierra="(tierra limoso)";
            break;
            case 3: vtierra="(tierra arenosa)";
            break;
            case 4: vtierra="(tierra tierra negra)";
            break;
            case 5: vtierra="(tierra otra)";
            break;
        }
        //Valor de las demás variables
        String ph = text_ph.getText();
        String temp = txt_temp.getText();
        String sombra = txt_sombra.getText();
        String prec = txt_prec.getText();
        String alt = txt_alt.getText();
        String hum = txt_hum.getText();
        
        //Comprobando si los campos no estén vacios
        if(ph.length()==0||temp.length()==0||sombra.length()==0||prec.length()==0||alt.length()==0||hum.length()==0|| vtierra=="tierra"){
           JOptionPane.showMessageDialog(null, "Puede que los resultados no sean tan confiables", "Hacen falta variables", JOptionPane.WARNING_MESSAGE);  
           if(ph.length()==0){
                resta=resta+1;
           }
           if(sombra.length()==0){
                resta=resta+1;
           }
           if(prec.length()==0){
                resta=resta+1;
           }
           if(alt.length()==0){
                resta=resta+1;
           }
           if(hum.length()==0){
                resta=resta+1;
           }
           if(temp.length()==0){
                resta=resta+1;
           }
        }
        
        Double total=0.0;
        Double suma = 6.0; //suma enviada por los otros agentes
        total=(suma*100)/(7-resta);
        BigDecimal porcentaje = new BigDecimal(total);
        porcentaje = porcentaje.setScale(2, RoundingMode.DOWN);

          Resultado.setText(porcentaje.toString()+" %");
          System.out.println("El total de la suma es "+total);
        */
    }//GEN-LAST:event_btnEnviarActionPerformed

  
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField Resultado;
    public static javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField text_altitud;
    public static javax.swing.JTextField text_humedad;
    public static javax.swing.JTextField text_ph;
    public static javax.swing.JTextField text_precip;
    public static javax.swing.JTextField text_sombra;
    public static javax.swing.JTextField text_temp;
    public static javax.swing.JComboBox<String> text_tierra;
    // End of variables declaration//GEN-END:variables
}
