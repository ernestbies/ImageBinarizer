package server;

import gui.GUI;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmi.ImageBinarizer;

/**
 *
 * @author Ernest Bieś, PWSZ Tarnów 2020
 */
public class Server implements ImageBinarizer {
    
    private GUI gui;
    
    public Server(GUI g) {
        gui = g;
    }
                                                                                                                                                                                                                                          
    public void bindStub() {
        try {
            LocateRegistry.createRegistry(1099);
            ImageBinarizer stub = (ImageBinarizer) UnicastRemoteObject.exportObject(this, 1099);
            Registry reg = LocateRegistry.getRegistry();
            reg.bind("ImageBinarizer", stub);
        } catch(Exception e) {
            gui.getTextArea().setText(gui.getTextArea().getText() + "\n>>>>> Wystąpił błąd: " + e.toString());
        }
    }
    
    @Override
    public int[][] binarize(int[][] image, int[] points, int binarizationType) throws RemoteException {        
        int width = image.length;
        int height = image[0].length;
        int[][] imageBinarized = new int[width][height];
        
        // Progi binaryzacji:
        // points[0] - próg dolny
        // points[1] - próg górny
        
        // Rodzaj binaryzacji:
        // 0 - binaryzacja dolnoprogowa
        // 1 - binaryzacja górnoprogowa
        // 2 - binaryzacja dwuprogowa
        // 3 - binaryzacja warunkowa
        
        switch(binarizationType) {
            case 0:
                gui.getTextArea().setText(gui.getTextArea().getText() + "\n>>>>> Binaryzacja dolnoprogowa obrazu została zdalnie wywołana. Próg dolny: " + points[0]);
                System.out.println("[LOG] Binaryzacja dolnoprogowa obrazu została zdalnie wywołana. Próg dolny: " + points[0]);
        
                for(int i=0;i<width;i++) {
                    for(int j=0;j<height;j++) {
                        if(image[i][j] <= points[0]) {
                            imageBinarized[i][j] = 0;
                        } else {
                            imageBinarized[i][j] = 255;
                        }
                    }
                }
                break;
            case 1:
                gui.getTextArea().setText(gui.getTextArea().getText() + "\n>>>>> Binaryzacja górnoprogowa obrazu została zdalnie wywołana. Próg górny: " + points[1]);
                System.out.println("[LOG] Binaryzacja górnoprogowa obrazu została zdalnie wywołana. Próg górny: " + points[1]);
                
                for(int i=0;i<width;i++) {
                    for(int j=0;j<height;j++) {
                        if(image[i][j] >= points[1]) {
                            imageBinarized[i][j] = 0;
                        } else {
                            imageBinarized[i][j] = 255;
                        }
                    }
                }
                break;   
            case 2:
                gui.getTextArea().setText(gui.getTextArea().getText() + "\n>>>>> Binaryzacja dwuprogowa obrazu została zdalnie wywołana. Próg dolny: " + points[0] + ", próg górny: " + points[1]);
                System.out.println("[LOG] Binaryzacja dwuprogowa obrazu została zdalnie wywołana. Próg dolny: " + points[0] + ", próg górny: " + points[1]);
                
                for(int i=0;i<width;i++) {
                    for(int j=0;j<height;j++) {
                        if(image[i][j] > points[0] && image[i][j] <= points[1]) {
                            imageBinarized[i][j] = 255;
                        } else {
                            imageBinarized[i][j] = 0;
                        }
                    }
                }
                break;
            case 3:
                gui.getTextArea().setText(gui.getTextArea().getText() + "\n>>>>> Binaryzacja warunkowa obrazu została zdalnie wywołana. Próg dolny: " + points[0] + ", próg górny: " + points[1]);
                System.out.println("[LOG] Binaryzacja warunkowa obrazu została zdalnie wywołana. Próg dolny: " + points[0] + ", próg górny: " + points[1]);
                
                for(int i=0;i<width;i++) {
                    for(int j=0;j<height;j++) {
                        if(j == 0) {
                            int a = points[0] + Math.round((points[1] - points[0])/2);
                            if(image[i][j] < a) {
                                imageBinarized[i][j] = 0;
                            } else {
                                imageBinarized[i][j] = 255;
                            }
                        } else {
                            if(image[i][j] <= points[0]) {
                                imageBinarized[i][j] = 0;
                            } else if(image[i][j] > points[1]) {
                                imageBinarized[i][j] = 255;
                            } else if(image[i][j] > points[0] && image[i][j] <= points[1]) {
                                imageBinarized[i][j] = imageBinarized[i][j-1];
                            }
                        }
                    }
                }
                break;
            default:
                for(int i=0;i<width;i++) {
                    for(int j=0;j<height;j++) {
                        if(image[i][j] <= points[0]) {
                            imageBinarized[i][j] = 0;
                        } else {
                            imageBinarized[i][j] = 255;
                        }
                    }
                }
                break;
        }
        
        return imageBinarized;
    }
}
