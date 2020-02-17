/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoia;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.*;


public class AgenteInicio extends Agent{
    
    private Container c;
    private Button btnEnviar;
    private JLabel etiq_tierra; 
    private JComboBox text_tierra;
    private JLabel etiq_ph;
    private TextField text_ph;
    private JLabel etiq_temp;
    private TextField text_temp;
    private JLabel etiq_humedad;
    private TextField text_humedad;
    private JLabel etiq_altitud;
    private TextField text_altitud;
    private JLabel etiq_precip;
    private TextField text_precip;
    private JLabel etiq_sombra;
    private TextField text_sombra;
    private Frame frm;
    String cont_tierra=" ";
    String cont_ph=" ";
    String cont_temp=" ";
    String cont_humedad=" ";
    String cont_altitud=" ";
    String cont_precip=" ";
    String cont_sombra=" ";
    String msj;
    int recibido = 0,con1 = 0, con2 = 0;
    int variables = 7;
    
    
    private String tipos_tierra[] = { "arcillosa", "limosa", "arenosa", "negra", "otra"};
    
    MessageTemplate mt1 = 
       MessageTemplate.and(  
           MessageTemplate.MatchPerformative( ACLMessage.INFORM ),
           MessageTemplate.MatchSender( new AID( "Agente1", 
                                                 AID.ISLOCALNAME)));
    MessageTemplate mt2 = 
       MessageTemplate.and(  
           MessageTemplate.MatchPerformative( ACLMessage.INFORM ),
           MessageTemplate.MatchSender( new AID( "Agente2", 
                                                 AID.ISLOCALNAME)));

    public AgenteInicio()
    {
        frm = new Frame("Zonas de plantación para Cacao");
        String texto = "<html><body><center>Indique los valores de la zona de plantación según corresponda.<br>"
                + " El sistema le responderá con un porcentaje de compatibilidad de la zona de plantación "
                + " para saber si es apta para el CACAO.</center></body></html>";
        
        JLabel imagenfondo = new javax.swing.JLabel();
        imagenfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoia/img/images (2).jpeg"))); // NOI18N
        //imagenfondo.setBounds(600,400, 600, 400);
        
        JLabel lbl1 = new JLabel(texto, SwingConstants.CENTER);
        //frm.add(lbl1);
        frm.setSize(600,400);
       // frm.setResizable(false); 
        frm.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
       
        JPanel p = new JPanel();
        JPanel p1 = new JPanel();
        JPanel fondo = new JPanel();
        JPanel fondo1 = new JPanel();
        JPanel fondo2 = new JPanel();
        fondo.setSize(600,400);
        fondo1.setSize(600,400);
        fondo2.setSize(600,400);
       
        formulario form=new formulario();
        
        form.setVisible(true);
        form.btnEnviar.addActionListener(new tranfiere());
    }
    
    class tranfiere implements ActionListener 
    {      
        public void actionPerformed(ActionEvent e)
        {
            int itierra= formulario.text_tierra.getSelectedIndex();
        String vtierra="";
        switch(itierra){
            case 0: vtierra="vacio";
            break;
            case 1: vtierra="arcillosa"; 
            break;
            case 2: vtierra="limosa";
            break;
            case 3: vtierra="arenosa";
            break;
            case 4: vtierra="negra";
            break;
            case 5: vtierra="otra";
            break;
        }
            variables = 7;
            cont_tierra = "(tierra " +vtierra+ ")";
              if(vtierra =="vacio" ||formulario.text_ph.getText().equals("")|| formulario.text_temp.getText().equals("")|| formulario.text_humedad.getText().equals("")|| formulario.text_altitud.getText().equals("")||formulario.text_precip.getText().equals("")|| formulario.text_sombra.getText().equals("")){
              JOptionPane.showMessageDialog(null, "Puede que los resultados no sean tan confiables", "Hacen falta variables", JOptionPane.WARNING_MESSAGE);  
              }         
              if(vtierra=="vacio"){
                  variables--;
                  cont_tierra="vacio";
              }
            if(formulario.text_ph.getText().equals("")){
               
                cont_ph = "vacio";
                variables--;
            }else{
                cont_ph =  "(ph " + formulario.text_ph.getText() + ")";
            }
                        
            if(formulario.text_temp.getText().equals("")){
                cont_temp = "vacio";
                variables--;
            }else{
                cont_temp = "(temperatura " + formulario.text_temp.getText() + ")";
            }
            
            if(formulario.text_humedad.getText().equals("")){
                cont_humedad = "vacio";
                variables--;
            }else{
                cont_humedad = "(humedad " + formulario.text_humedad.getText()+")";
            }
            
            if(formulario.text_altitud.getText().equals("")){
                cont_altitud = "vacio";
                variables--;
            }else{
                cont_altitud = "(altitud " + formulario.text_altitud.getText() + ")";
            }
            
            if(formulario.text_precip.getText().equals("")){
                cont_precip = "vacio";
                variables--;
            }else{
                cont_precip = "(precipitacion " + formulario.text_precip.getText() + ")";
            }
            
            if(formulario.text_sombra.getText().equals("")){
                cont_sombra = "vacio";
                variables--;
            }else{
                cont_sombra = "(sombra " + formulario.text_sombra.getText() + ")";
            }
            
            recibido = 1;
            Object event =e.getSource();
            
        }
    }
    
    protected void setup() 
    {
	// First set-up answering behaviour
	
        addBehaviour(new CyclicBehaviour(this) 
        {
            String palabra;
            public void action()
            {	
                String contenidoA1="";
                String contenidoA2="";
                double sumaA1 = 0.0;
                double sumaA2 = 0.0;
                double compatibilidad = 0.0;
                do{
                    ACLMessage mensajeA1 = receive(mt1);
                    if (mensajeA1 != null){
                        contenidoA1 = mensajeA1.getContent();
                        
                    }
                    
                    ACLMessage mensajeA2 = receive(mt2);
                    if (mensajeA2 != null){
                        contenidoA2 = mensajeA2.getContent();
                        
                    }
                    
                    if(contenidoA1 != null && contenidoA2 != null){
                        
                        if(contenidoA1.contains("inutil")){
                            System.out.println(contenidoA1);
                        JOptionPane.showMessageDialog(null,"Debido a las siguientes variables es imposible sembrar cacao: \n "+ contenidoA1, "Imposible cultivar cacao", JOptionPane.WARNING_MESSAGE);    
                            contenidoA1="";
                            formulario.Resultado.setText("");

                        } else if( !contenidoA1.equals("") ){
                            sumaA1 = Double.parseDouble(contenidoA1);
                            System.out.println("SumaA1 "+sumaA1);
                            contenidoA1="";
                            con1 = 1;
                        }   
                    
                        if(contenidoA2.contains("inutil")){
                            System.out.println(contenidoA2);
                            JOptionPane.showMessageDialog(null,"Debido a las siguientes variables es imposible sembrar cacao: \n "+ contenidoA2, "Imposible cultivar cacao", JOptionPane.WARNING_MESSAGE);  
                            contenidoA2="";
                            formulario.Resultado.setText("");
                        } else if( !contenidoA2.equals("") ){
                            sumaA2 = Double.parseDouble(contenidoA2);
                            System.out.println("SumaA2 "+sumaA2);
                            contenidoA2="";
                            con2 = 1;
                        }
                        
                        if( con1 == 1 && con2 == 1 ){
                            if( sumaA1 > 0 && sumaA2 > 0 ){
                                compatibilidad = (sumaA1 + sumaA2) * 100 / variables;
                                con1 = con2 = 0;
                                System.out.println("El total es "+compatibilidad);
                                BigDecimal porcentaje = new BigDecimal(compatibilidad);
                                porcentaje = porcentaje.setScale(2, RoundingMode.DOWN);
                                formulario.Resultado.setText(porcentaje.toString()+" %");
                                //formulario.Resultado.setText(compatibilidad+"%");
                            } else {
                                JOptionPane.showMessageDialog(null,"Error de sincronización. Intente nuevamente.", "Error", JOptionPane.WARNING_MESSAGE);    
                            }
                        }
                        
                    }
                }while(recibido == 0) ;
                
                AID id1 = new AID();
                id1.setLocalName("Agente1");
                
                ACLMessage mensajeA10 = new ACLMessage(ACLMessage.INFORM);
                mensajeA10.setSender(getAID());
                mensajeA10.addReceiver(id1);
                mensajeA10.setContent(cont_tierra);
                
                ACLMessage mensajeA1 = new ACLMessage(ACLMessage.INFORM);
                mensajeA1.setSender(getAID());
                mensajeA1.addReceiver(id1);
                mensajeA1.setContent(cont_ph);

                ACLMessage mensajeA12 = new ACLMessage(ACLMessage.INFORM);
                mensajeA12.setSender(getAID());
                mensajeA12.addReceiver(id1);
                mensajeA12.setContent(cont_temp); 

                ACLMessage mensajeA13 = new ACLMessage(ACLMessage.INFORM);
                mensajeA13.setSender(getAID());
                mensajeA13.addReceiver(id1);
                mensajeA13.setContent(cont_humedad); 
                send(mensajeA10);
                send(mensajeA1);
                send(mensajeA12);
                send(mensajeA13);
                
                AID id2 = new AID();
                id2.setLocalName("Agente2");
                
                ACLMessage mensajeA2 = new ACLMessage(ACLMessage.INFORM);
                mensajeA2.setSender(getAID());
                mensajeA2.addReceiver(id2);
                mensajeA2.setContent(cont_altitud);

                ACLMessage mensajeA22 = new ACLMessage(ACLMessage.INFORM);
                mensajeA22.setSender(getAID());
                mensajeA22.addReceiver(id2);
                mensajeA22.setContent(cont_precip); 

                ACLMessage mensajeA23 = new ACLMessage(ACLMessage.INFORM);
                mensajeA23.setSender(getAID());
                mensajeA23.addReceiver(id2);
                mensajeA23.setContent(cont_sombra); 
                send(mensajeA2);
                send(mensajeA22);
                send(mensajeA23);

                formulario.text_ph.setText("");
                formulario.text_humedad.setText("");
                formulario.text_temp.setText("");
                formulario.text_altitud.setText("");
                formulario.text_precip.setText("");
                formulario.text_sombra.setText("");
                recibido = 0;
            }
        });
        
        System.out.println(this.getLocalName()+ " inicio.");
    }
}
