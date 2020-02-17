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

public class Agente2 extends Agent {

    public static String archivo = "clips/plantacion.clp";

    protected void setup() {
	// First set-up answering behaviour

        addBehaviour(new CyclicBehaviour(this) {
            String palabra;

            public void action() {
                String archivo = "clips/plantacion.clp";
                Writer out = new StringWriter();
                Writer out2 = new StringWriter();
                Writer out3 = new StringWriter();
                double altR = 2.0;
                double preR = 2.0;
                double somR = 2.0;
                String hechoAlt = null;
                String hechoPre = null;
                String hechoSom = null;
                String contenido = null;

                ACLMessage msjAlt = receive();
                ACLMessage msjPre = receive();
                ACLMessage msjSom = receive();

                if ((msjAlt != null) && (msjPre != null) && (msjSom != null)) {

                    hechoAlt = msjAlt.getContent();
                    hechoPre = msjPre.getContent();
                    hechoSom = msjSom.getContent();

                    //System.out.println("Llego a Agente2: " + hechoAlt + " " + hechoPre
                      //      + " " + hechoSom);

                    msjAlt = null;
                    msjPre = null;
                    msjSom = null;

                    Rete r = new Rete();
                    try {
                        r.batch(archivo);
                        r.reset();
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    if (hechoAlt.indexOf("vacio") == -1) {
                        try {
                            r.assertString(hechoAlt);
                            r.addOutputRouter("varAlti", out);
                            r.run();
                            altR = Double.parseDouble(out.toString());
                        } catch (Exception e) {
                            System.out.println("Problema varAl?" + e);
                        }
                    }

                    if (hechoPre.indexOf("vacio") == -1) {
                        try {
                            r.assertString(hechoPre);
                            r.addOutputRouter("varPr", out2);
                            r.run();
                            preR = Double.parseDouble(out2.toString());
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }

                    if (hechoSom.indexOf("vacio") == -1) {
                        try {
                            r.assertString(hechoSom);
                            r.addOutputRouter("varSo", out3);
                            r.run();
                            somR = Double.parseDouble(out3.toString());
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }

                    System.out.println(altR + " " + preR + " " + somR);

                    String inuAlt = " ";
                    String inuPre = " ";
                    String inuSom = " ";

                    double total = 0.0;

                    if ((altR == 0.0) || (preR == 0.0) || (somR == 0.0)) {
                        if (altR == 0.0) {
                            inuAlt = "Altitud inutil";
                        }
                        if (preR == 0.0) {
                            inuPre = "Precipitación inutil";
                        }
                        if (somR == 0.0) {
                            inuSom = "Sombra inutil";
                        }
                        contenido = inuAlt + " " + inuPre + " " + inuSom;

                    } else if (altR == 2.0 || preR == 2.0 || somR == 2.0) {
                        if (altR == 2.0) {
                            altR = 0.0;
                        }
                        if (preR == 2.0) {
                            preR = 0.0;
                        }
                        if (somR == 2.0) {
                            somR = 0.0;
                        }
                        total = altR + preR + somR;
                        contenido = String.valueOf(total);
                    } else {
                        total = altR + preR + somR;
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

        System.out.println(this.getLocalName() + " inicio.");
    }
}
