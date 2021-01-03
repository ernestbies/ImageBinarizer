package gui;

import client.Client;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ernest Bieś, PWSZ Tarnów 2020
 */
public class GUI extends javax.swing.JFrame {

    private final Client client;
    private BufferedImage imageSourceOriginal;
    private BufferedImage imageSourceGreyscale;
    private BufferedImage imageTarget;
    private int[][] imageArray;
    private boolean showOriginalImage;
    
    public GUI() {
        initComponents();
        client = new Client(this);
        client.connectServer();
    }
    
    private int[][] imageBinarize() {
        try {
            int[] points = {jSliderPoint.getValue(), jSliderPoint2.getValue()};
            int[][] imageBinarized = client.getStub().binarize(imageArray, points, jComboBoxBinarization.getSelectedIndex());
            jTextFieldStatus.setDisabledTextColor(Color.black);
            jTextFieldStatus.setText("Przeprowadzono binaryzację obrazu.");
            return imageBinarized;
        } catch (RemoteException ex) {
            jTextFieldStatus.setDisabledTextColor(Color.red);
            jTextFieldStatus.setText("Błąd połączenia z serwerem.");
        }
        return null;
    }
    
    public JTextField getTextFieldStatus() {
        return jTextFieldStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelAbout = new javax.swing.JLabel();
        jLabelAuthor = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jButtonBinarize = new javax.swing.JButton();
        jPanelImageSource = new javax.swing.JPanel();
        jLabelImageSource = new javax.swing.JLabel();
        jPanelImageTarget = new javax.swing.JPanel();
        jLabelImageTarget = new javax.swing.JLabel();
        jButtonLoadImage = new javax.swing.JButton();
        jSliderPoint = new javax.swing.JSlider();
        jTextFieldPoint = new javax.swing.JTextField();
        jLabelPoint = new javax.swing.JLabel();
        jButtonSaveImage = new javax.swing.JButton();
        jLabelSource = new javax.swing.JLabel();
        jLabelTarget = new javax.swing.JLabel();
        jButtonClear = new javax.swing.JButton();
        jLabelPoint1 = new javax.swing.JLabel();
        jComboBoxBinarization = new javax.swing.JComboBox<>();
        jTextFieldPoint2 = new javax.swing.JTextField();
        jSliderPoint2 = new javax.swing.JSlider();
        jLabelPoint2 = new javax.swing.JLabel();
        jLabelPoint3 = new javax.swing.JLabel();
        jButtonChangeSource = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ImageBinarizer");
        setResizable(false);

        jLabelAbout.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelAbout.setText("Binaryzacja obrazów");

        jLabelAuthor.setText("© Ernest Bieś, PWSZ Tarnów 2020");

        jTextFieldStatus.setEditable(false);
        jTextFieldStatus.setEnabled(false);

        jButtonBinarize.setText("Przetwórz obraz");
        jButtonBinarize.setEnabled(false);
        jButtonBinarize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBinarizeActionPerformed(evt);
            }
        });

        jPanelImageSource.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelImageSource.setText("                      ");

        javax.swing.GroupLayout jPanelImageSourceLayout = new javax.swing.GroupLayout(jPanelImageSource);
        jPanelImageSource.setLayout(jPanelImageSourceLayout);
        jPanelImageSourceLayout.setHorizontalGroup(
            jPanelImageSourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImageSource, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelImageSourceLayout.setVerticalGroup(
            jPanelImageSourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImageSource, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanelImageTarget.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelImageTargetLayout = new javax.swing.GroupLayout(jPanelImageTarget);
        jPanelImageTarget.setLayout(jPanelImageTargetLayout);
        jPanelImageTargetLayout.setHorizontalGroup(
            jPanelImageTargetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImageTarget, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelImageTargetLayout.setVerticalGroup(
            jPanelImageTargetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImageTarget, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jButtonLoadImage.setText("Wczytaj obraz wejściowy");
        jButtonLoadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadImageActionPerformed(evt);
            }
        });

        jSliderPoint.setMaximum(255);
        jSliderPoint.setToolTipText("Próg binaryzacji");
        jSliderPoint.setValue(127);
        jSliderPoint.setEnabled(false);
        jSliderPoint.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderPointStateChanged(evt);
            }
        });

        jTextFieldPoint.setEditable(false);
        jTextFieldPoint.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPoint.setEnabled(false);
        jTextFieldPoint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPointKeyReleased(evt);
            }
        });

        jLabelPoint.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelPoint.setText("Rodzaj binaryzacji");

        jButtonSaveImage.setText("Zapisz obraz wyjściowy");
        jButtonSaveImage.setEnabled(false);
        jButtonSaveImage.setMaximumSize(new java.awt.Dimension(177, 25));
        jButtonSaveImage.setMinimumSize(new java.awt.Dimension(177, 25));
        jButtonSaveImage.setPreferredSize(new java.awt.Dimension(177, 25));
        jButtonSaveImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveImageActionPerformed(evt);
            }
        });

        jLabelSource.setText("Podgląd obrazu wejściowego");

        jLabelTarget.setText("Podgląd obrazu wyjściowego");

        jButtonClear.setText("Wyczyść obrazy");
        jButtonClear.setEnabled(false);
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jLabelPoint1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelPoint1.setText("Progi binaryzacji (0-255)");

        jComboBoxBinarization.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dolnoprogowa", "górnoprogowa", "dwuprogowa", "warunkowa" }));
        jComboBoxBinarization.setEnabled(false);
        jComboBoxBinarization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBinarizationActionPerformed(evt);
            }
        });

        jTextFieldPoint2.setEditable(false);
        jTextFieldPoint2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPoint2.setEnabled(false);
        jTextFieldPoint2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPoint2KeyReleased(evt);
            }
        });

        jSliderPoint2.setMaximum(255);
        jSliderPoint2.setToolTipText("Próg binaryzacji");
        jSliderPoint2.setValue(127);
        jSliderPoint2.setEnabled(false);
        jSliderPoint2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderPoint2StateChanged(evt);
            }
        });

        jLabelPoint2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelPoint2.setForeground(new java.awt.Color(0, 51, 255));
        jLabelPoint2.setText(" Próg dolny");

        jLabelPoint3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelPoint3.setForeground(new java.awt.Color(0, 51, 255));
        jLabelPoint3.setText(" Próg górny");

        jButtonChangeSource.setText("Oryginalny");
        jButtonChangeSource.setEnabled(false);
        jButtonChangeSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangeSourceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAbout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAuthor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldStatus)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonLoadImage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonChangeSource, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanelImageSource, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabelSource)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabelPoint1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jComboBoxBinarization, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(31, 31, 31))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jSliderPoint2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                                    .addComponent(jButtonBinarize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jButtonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(73, 73, 73)
                                                    .addComponent(jTextFieldPoint2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(41, 41, 41)
                                                    .addComponent(jLabelPoint))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(61, 61, 61)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(10, 10, 10)
                                                            .addComponent(jTextFieldPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabelPoint2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(jSliderPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(61, 61, 61)
                                                    .addComponent(jLabelPoint3)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addComponent(jPanelImageTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabelTarget)
                                    .addGap(75, 75, 75)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonSaveImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAbout)
                    .addComponent(jLabelAuthor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTarget)
                    .addComponent(jLabelSource))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelImageTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelImageSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPoint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxBinarization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPoint1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPoint2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSliderPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabelPoint3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPoint2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSliderPoint2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBinarize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonClear)
                        .addGap(28, 28, 28)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLoadImage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonChangeSource))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBinarizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBinarizeActionPerformed
        try {
            if(jSliderPoint.getValue() >= jSliderPoint2.getValue() && jComboBoxBinarization.getSelectedIndex() == 2) {
                JOptionPane.showMessageDialog(this, "Próg dolny musi mieć wartość mniejszą od progu górnego!");
            } else {
                imageTarget = getImageFromArray(imageBinarize());
                ImageIcon imageIconGray = new ImageIcon(imageTarget.getScaledInstance(jLabelImageTarget.getWidth(), jLabelImageTarget.getHeight(), Image.SCALE_DEFAULT));
                jLabelImageTarget.setIcon(imageIconGray);  
                jButtonSaveImage.setEnabled(true);
                jTextFieldStatus.setDisabledTextColor(Color.black);
                jTextFieldStatus.setText("Pomyślnie przetworzono obraz wejściowy.");   
            }
        } catch (NullPointerException ex) {
            jTextFieldStatus.setDisabledTextColor(Color.red);
            jTextFieldStatus.setText("Wystąpił błąd połączenia z serwerem podczas przetwarzania obrazu.");    
        }
    }//GEN-LAST:event_jButtonBinarizeActionPerformed

    private void jButtonLoadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadImageActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        chooser.addChoosableFileFilter(imageFilter);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose image file");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);        
                                
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                imageSourceOriginal = ImageIO.read(new File(chooser.getSelectedFile().toString()));
                imageSourceGreyscale = getGrayImage(imageSourceOriginal);
                ImageIcon imageIcon = new ImageIcon(imageSourceGreyscale.getScaledInstance(jLabelImageSource.getWidth(), jLabelImageSource.getHeight(), imageSourceGreyscale.SCALE_DEFAULT));
                //ImageIcon imageIcon = new ImageIcon(imageSourceOriginal.getScaledInstance(jLabelImageSource.getWidth(), jLabelImageSource.getHeight(), imageSourceGreyscale.SCALE_DEFAULT));
                
                jLabelImageSource.setIcon(imageIcon);
                jComboBoxBinarization.setEnabled(true);
                jButtonBinarize.setEnabled(true);
                jButtonChangeSource.setEnabled(true);
                jLabelImageTarget.setIcon(null);
                jTextFieldStatus.setDisabledTextColor(Color.black);
                jComboBoxBinarization.setSelectedIndex(0);
                jTextFieldStatus.setText("Pomyślnie wczytano obraz wejściowy.");
                jButtonClear.setEnabled(true);
            } catch (IOException ex) {
                jTextFieldStatus.setDisabledTextColor(Color.red);
                jTextFieldStatus.setText("Wystąpił błąd podczas wczytywania obrazu.");
            }
        }
    }//GEN-LAST:event_jButtonLoadImageActionPerformed

    private void jSliderPointStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderPointStateChanged
        jTextFieldPoint.setText(String.valueOf(jSliderPoint.getValue()));
    }//GEN-LAST:event_jSliderPointStateChanged

    private void jButtonSaveImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveImageActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                String path = file.getAbsolutePath();
                ImageIO.write(imageTarget, "png", new File(path + ".png"));
                jTextFieldStatus.setDisabledTextColor(Color.black);
                jTextFieldStatus.setText("Pomyślnie zapisano obraz wyjściowy. Lokalizacja: " + path + ".png");
            } catch (IOException ex) {
                jTextFieldStatus.setDisabledTextColor(Color.red);
                jTextFieldStatus.setText("Wystąpił błąd podczas zapisywania obrazu.");
            }
        } else {
            jTextFieldStatus.setDisabledTextColor(Color.black);
            jTextFieldStatus.setText("Anulowano zapisywanie obrazu wyjściowego.");
        }
    }//GEN-LAST:event_jButtonSaveImageActionPerformed

    private void jTextFieldPointKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPointKeyReleased
        if(jTextFieldPoint.getText().matches("\\b(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\b")) {
            jSliderPoint.setValue(Integer.parseInt(jTextFieldPoint.getText()));
        } else if(jTextFieldPoint.getText().length() == 0) {
            jSliderPoint.setValue(0);
        } else {
            jTextFieldPoint.setText("127");
            jSliderPoint.setValue(127);
        }
    }//GEN-LAST:event_jTextFieldPointKeyReleased

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        jLabelImageSource.setIcon(null);
        jLabelImageTarget.setIcon(null);
        imageSourceOriginal = null;
        imageSourceOriginal = null;
        imageTarget = null;
        imageArray = null;
        jSliderPoint.setValue(127);
        jSliderPoint2.setValue(127);
        jComboBoxBinarization.setEnabled(false);
        jComboBoxBinarization.setSelectedIndex(0);
        jTextFieldStatus.setDisabledTextColor(Color.black);
        jTextFieldStatus.setText("Wyczyszczono obraz wejściowy i wyjściowy.");
        jButtonBinarize.setEnabled(false);
        jButtonSaveImage.setEnabled(false);
        jButtonChangeSource.setEnabled(false);
        jTextFieldPoint.setText("");
        jTextFieldPoint2.setText("");
        jTextFieldPoint.setEnabled(false);
        jTextFieldPoint2.setEnabled(false);
        jTextFieldPoint.setEditable(false);
        jTextFieldPoint2.setEditable(false);
        jSliderPoint.setEnabled(false);
        jSliderPoint2.setEnabled(false);
        jButtonClear.setEnabled(false);
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jComboBoxBinarizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBinarizationActionPerformed
        int selectedIndex = jComboBoxBinarization.getSelectedIndex();
       
        switch(selectedIndex) {
            case 0:
                jSliderPoint.setValue(127);
                jSliderPoint2.setValue(127);
                jTextFieldPoint.setText("127");
                jTextFieldPoint.setEditable(true);
                jTextFieldPoint.setEnabled(true);
                jSliderPoint.setEnabled(true);   
                jTextFieldPoint2.setText("");
                jTextFieldPoint2.setEditable(false);
                jTextFieldPoint2.setEnabled(false);
                jSliderPoint2.setEnabled(false);
                break;
            case 1:
                jSliderPoint.setValue(127);
                jSliderPoint2.setValue(127);
                jTextFieldPoint.setText("");
                jTextFieldPoint.setEditable(false);
                jTextFieldPoint.setEnabled(false);
                jSliderPoint.setEnabled(false);
                jTextFieldPoint2.setText("127");
                jTextFieldPoint2.setEditable(true);
                jTextFieldPoint2.setEnabled(true);
                jSliderPoint2.setEnabled(true);
                break;
            case 2:
            case 3:
                jSliderPoint.setValue(127);
                jSliderPoint2.setValue(127);
                jTextFieldPoint.setText("127");
                jTextFieldPoint.setEditable(true);
                jTextFieldPoint.setEnabled(true);
                jSliderPoint.setEnabled(true);
                jTextFieldPoint2.setText("127");
                jTextFieldPoint2.setEditable(true);
                jTextFieldPoint2.setEnabled(true);
                jSliderPoint2.setEnabled(true);
                break;
            default:
                jSliderPoint.setValue(127);
                jSliderPoint2.setValue(127);
                jTextFieldPoint.setText("127");
                jTextFieldPoint.setEditable(true);
                jTextFieldPoint.setEnabled(true);
                jSliderPoint.setEnabled(true);
                jTextFieldPoint2.setText("");
                jTextFieldPoint2.setEditable(false);
                jTextFieldPoint2.setEnabled(false);
                jSliderPoint.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_jComboBoxBinarizationActionPerformed

    private void jTextFieldPoint2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPoint2KeyReleased
        if(jTextFieldPoint2.getText().matches("\\b(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\b")) {
            jSliderPoint2.setValue(Integer.parseInt(jTextFieldPoint2.getText()));
        } else if(jTextFieldPoint2.getText().length() == 0) {
            jSliderPoint2.setValue(0);
        } else {
            jTextFieldPoint2.setText("127");
            jSliderPoint2.setValue(127);
        }
    }//GEN-LAST:event_jTextFieldPoint2KeyReleased

    private void jSliderPoint2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderPoint2StateChanged
        jTextFieldPoint2.setText(String.valueOf(jSliderPoint2.getValue()));
    }//GEN-LAST:event_jSliderPoint2StateChanged

    private void jButtonChangeSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeSourceActionPerformed
        ImageIcon imageIcon = null;
        if(showOriginalImage){    
           imageIcon = new ImageIcon(imageSourceGreyscale.getScaledInstance(jLabelImageSource.getWidth(), jLabelImageSource.getHeight(), BufferedImage.SCALE_DEFAULT));
           jButtonChangeSource.setText("Oryginalny");
        } else{
           imageIcon = new ImageIcon(imageSourceOriginal.getScaledInstance(jLabelImageSource.getWidth(), jLabelImageSource.getHeight(), BufferedImage.SCALE_DEFAULT));
           jButtonChangeSource.setText("Szarość");
        }
        showOriginalImage = !showOriginalImage;
        jLabelImageSource.setIcon(imageIcon);
                
    }//GEN-LAST:event_jButtonChangeSourceActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBinarize;
    private javax.swing.JButton jButtonChangeSource;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonLoadImage;
    private javax.swing.JButton jButtonSaveImage;
    private javax.swing.JComboBox<String> jComboBoxBinarization;
    private javax.swing.JLabel jLabelAbout;
    private javax.swing.JLabel jLabelAuthor;
    private javax.swing.JLabel jLabelImageSource;
    private javax.swing.JLabel jLabelImageTarget;
    private javax.swing.JLabel jLabelPoint;
    private javax.swing.JLabel jLabelPoint1;
    private javax.swing.JLabel jLabelPoint2;
    private javax.swing.JLabel jLabelPoint3;
    private javax.swing.JLabel jLabelSource;
    private javax.swing.JLabel jLabelTarget;
    private javax.swing.JPanel jPanelImageSource;
    private javax.swing.JPanel jPanelImageTarget;
    private javax.swing.JSlider jSliderPoint;
    private javax.swing.JSlider jSliderPoint2;
    private javax.swing.JTextField jTextFieldPoint;
    private javax.swing.JTextField jTextFieldPoint2;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables

    
    public BufferedImage getGrayImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        imageArray = new int[width][height];
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
       
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color c = new Color(image.getRGB(j, i));
                int red = (int) (c.getRed() * 0.299);
                int green = (int) (c.getGreen() * 0.587);
                int blue = (int) (c.getBlue() * 0.114);
                int rgb = red + green + blue;
                Color newColor = new Color(rgb, rgb, rgb);
                newImage.setRGB(j, i, newColor.getRGB());
                imageArray[j][i] = rgb;
            }
        }
        return newImage;
    }
    
    public BufferedImage getImageFromArray(int[][] arrayImage) {
        try{
            int width = arrayImage.length;
            int height = arrayImage[1].length;
    
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(arrayImage[j][i], arrayImage[j][i], arrayImage[j][i]);
                    image.setRGB(j, i, c.getRGB());
                }
            }
           return image;   
           
        } catch (NullPointerException ex) {
            jTextFieldStatus.setDisabledTextColor(Color.red);
            jTextFieldStatus.setText("Wystąpił błąd połączenia z serwerem podczas przetwarzania obrazu.");
        }
        return null;
    }    
}