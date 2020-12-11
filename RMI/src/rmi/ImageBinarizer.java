package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Ernest Bieś, PWSZ Tarnów 2020
 */
public interface ImageBinarizer extends Remote {
    public int[][] binarize(int[][] image, int[] point, int binarizationType) throws RemoteException;
}
