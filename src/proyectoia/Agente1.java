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
import java.io.StringWriter;
import java.io.Writer;
import jess.Rete;
//import static pruebajess.PruebaJess.archivo;


public class Agente1 extends Agent{
    public static String archivo = "clips/plantacion.clp";
    protected void setup() 
    {
	// First set-up answering behaviour
	
        addBehaviour(new CyclicBehaviour(this) 
        {
            String palabra;
            
            public void action()
            {	
                String archivo = "clips/plantacion.clp";
                Writer ou = new StringWriter();
                Writer out = new StringWriter();
                Writer out2 = new StringWriter();
                Writer out3 = new StringWriter();
                double tiR = 2.0;
                double phR = 2.0;
                double teR = 2.0;
                double huR = 2.0;
                String hechoTi=null;
                String hechoPh=null;
                String hechoTe=null;
                String hechoHu=null;
                String contenido=null;
                
                ACLMessage msjTi = receive();
                ACLMessage msjPh = receive();
                ACLMessage msjTemp = receive();
                ACLMessage msjHum = receive();
                
                if((msjTi != null) && (msjPh != null) && (msjTemp != null) && (msjHum != null)){

                    hechoTi = msjTi.getContent();
                    hechoPh = msjPh.getContent();
                    hechoTe = msjTemp.getContent();
                    hechoHu = msjHum.getContent();
                    
                    //System.out.println("Llego a Agente1: " + msjTi.getContent() + msjPh.getContent() + " " + msjTemp.getContent() 
                      //      + " " + msjHum.getContent());

                    msjTi = null;
                    msjPh = null;
                    msjTemp = null;
                    msjHum = null;
                    
                    Rete r = new Rete();
                    try{
                        r.batch(archivo);
                        r.reset();
                    }catch(Exception e){
                        System.out.println(e);
                    }

                    
                    try{
                        r.assertString(hechoTi);
                        r.addOutputRouter("varTi", ou);
                        r.run();
                        tiR = Double.parseDouble(ou.toString());
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    
                    if(hechoPh.indexOf("vacio") == -1){
                        try{
                            r.assertString(hechoPh);
                            r.addOutputRouter("varPh", out);
                            r.run();
                            phR = Double.parseDouble(out.toString());
                        }catch(Exception e){
                            System.out.println(e);
                        }                    
                    }

                    if(hechoTe.indexOf("vacio") == -1){
                        try{
                            r.assertString(hechoTe);
                            r.addOutputRouter("varTe", out2);
                            r.run();
                            teR = Double.parseDouble(out2.toString());
                        }catch(Exception e){
                            System.out.println(e);
                        }                    
                    }

                    if(hechoHu.indexOf("vacio") == -1){
                        try{
                            r.assertString(hechoHu);
                            r.addOutputRouter("varHu", out3);
                            r.run();
                            huR = Double.parseDouble(out3.toString());
                        }catch(Exception e){
                            System.out.println(e);
                        }                    
                    }

                    System.out.println(tiR + " " + phR + " " + teR + " " + huR);
                    
                    String inuTi=" ";
                    String inuPh=" ";
                    String inuTe=" ";
                    String inuHu=" ";
                    
                    double total = 0.0;
                    
                    if((tiR == 0.0) || (phR == 0.0) || (teR == 0.0) || (huR == 0.0)){
                        if(tiR == 0.0){
                            inuTi = "Tierra inutil";
                        }if(phR == 0.0){
                            inuPh = "pH inutil";
                        }if(teR == 0.0){
                            inuTe = "Temperatura inutil";
                        }if(huR == 0.0){
                            inuHu = "Humedad inutil";
                        }
                        contenido = inuPh + " " + inuTe + " " + inuHu;
                        
                    } else if (tiR == 2.0 || phR == 2.0 || teR == 2.0 || huR == 2.0){
                        if(tiR == 2.0){
                            tiR = 0.0;
                        }if(phR == 2.0){
                            phR = 0.0;
                        }if(teR == 2.0){
                            teR = 0.0;
                        }if(huR == 2.0){
                            huR = 0.0;
                        }
                        
                        total = tiR + phR + teR + huR;
                        contenido = String.valueOf(total); 
                    }else{
                        total = tiR + phR + teR + huR;
                        contenido = String.valueOf(total); 
                    }
                    
                    AID id = new AID();
                    id.setLocalName("AgenteIni");
                    ACLMessage mensaje2 = new ACLMessage(ACLMessage.INFORM);
                    mensaje2.setSender(getAID());
                    mensaje2.addReceiver(id);
                    mensaje2.setContent(contenido); 
                    send(mensaje2);
                }
                
                
                block();
            }
            });
        
        System.out.println(this.getLocalName()+ " inicio.");
    }
}
