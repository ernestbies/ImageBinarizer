package client;

import gui.GUI;
import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.ImageBinarizer;

/**
 *
 * @author Ernest Bieś, PWSZ Tarnów 2020
 */
public class Client {

    private GUI gui;
    private ImageBinarizer stub;
    
    public Client(GUI g) {
        gui = g;
    }
    
    public ImageBinarizer getStub() {
        return stub;
    }
    
    public void connectServer() {
        try {
            Registry reg = LocateRegistry.getRegistry();
            ImageBinarizer stub = (ImageBinarizer) reg.lookup("ImageBinarizer");
            this.stub = stub;
            
            gui.getTextFieldStatus().setDisabledTextColor(new Color(0,153,0));
            gui.getTextFieldStatus().setText("Nawiązano połączenie z serwerem.");
        } catch(NotBoundException | RemoteException e) {
            gui.getTextFieldStatus().setDisabledTextColor(Color.red);
            gui.getTextFieldStatus().setText("Brak połączenia z serwerem.");
        }
    }
}
