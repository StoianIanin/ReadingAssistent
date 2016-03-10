/*
 * To change this license header, choose License Headers inputstream Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template inputstream the editor.
 */
package donniestaskv1.pkg1;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import sun.audio.*;
import java.io.*;

/**
 *
 * @author Stoian
 */
public class Reading extends javax.swing.JFrame {

    InputStream inputstream;
    AudioPlayer audioplayer = AudioPlayer.player;
    AudioStream audiostream;
    AudioData audiodata;
    ContinuousAudioDataStream loop = null;

    public void pause() {
        this.timer.cancel();
    }

    public void resumeBigTimer() {
        this.timer = new Timer();
        taskBigTimer = new TimerTask() {
            public void run() {
                if (timeForReading < 1800) {
                    if (secondsCounterBigTimer >= 0) {
                        txtFieldSecondsBigTimer.setText("" + secondsCounterBigTimer);
                        secondsCounterBigTimer--;
                    } else if (minutesCounterBigTimer > 0) {
                        minutesCounterBigTimer--;
                        secondsCounterBigTimer = 59;
                        txtFieldMinutesBigTimer.setText("" + minutesCounterBigTimer);
                        txtFieldSecondsBigTimer.setText("" + secondsCounterBigTimer);
                    } else if (hoursCounterBigTimer > 0) {
                        hoursCounterBigTimer--;
                        minutesCounterBigTimer = 59;
                        secondsCounterBigTimer = 59;
                        txtFieldHoursBigTimer.setText("" + hoursCounterBigTimer);
                        txtFieldMinutesBigTimer.setText("" + minutesCounterBigTimer);
                        txtFieldSecondsBigTimer.setText("" + secondsCounterBigTimer);
                    } else {
                        try {
                            inputstream = new FileInputStream(new File("C:\\Windows\\Media\tada.wav").getAbsoluteFile());
                            audiostream = new AudioStream(inputstream);
                            audiodata = audiostream.getData();
                            loop = new ContinuousAudioDataStream(audiodata);
                        } catch (IOException error) {

                        }
                        audioplayer.start(loop);
                        timer.cancel();
                        labelFinal.setVisible(true);
                    }
                    timeForReading++;
                } else {
                    startMusic.doClick();
                }
            }
        };
        this.timer.scheduleAtFixedRate(taskBigTimer, 0, 1000);
    }

    public void resumeTimerBreak() {
        this.timer = new Timer();
        taskTimerBreak = new TimerTask() {
            public void run() {
                if (secondsCounterTimerBreak > 0) {
                    txtFieldSecondsTimerBreak.setText("" + secondsCounterTimerBreak);
                    txtFieldMinutesTimerBreak.setText("" + minutesCounterTimerBreak);
                    secondsCounterTimerBreak--;
                } else if (minutesCounterTimerBreak > 0) {
                    minutesCounterTimerBreak--;
                    secondsCounterTimerBreak = 59;
                    txtFieldSecondsTimerBreak.setText("" + secondsCounterTimerBreak);
                    txtFieldMinutesTimerBreak.setText("" + minutesCounterTimerBreak);
                } else {
                    TimerBreak.doClick();
                    startMusic.doClick();

                }
            }
        };
        this.timer.scheduleAtFixedRate(taskTimerBreak, 0, 1000);
    }

    int timeForReading = 0;
    int secondsCounterBigTimer;
    int minutesCounterBigTimer;
    int hoursCounterBigTimer;
    int minutesCounterTimerBreak = 0;
    int secondsCounterTimerBreak = 5;
    Timer timer = new Timer();
    TimerTask taskBigTimer = new TimerTask() {
        public void run() {
            if (timeForReading < 1800) {
                if (secondsCounterBigTimer >= 0) {
                    txtFieldSecondsBigTimer.setText("" + secondsCounterBigTimer);
                    secondsCounterBigTimer--;
                } else if (minutesCounterBigTimer > 0) {
                    minutesCounterBigTimer--;
                    secondsCounterBigTimer = 59;
                    txtFieldMinutesBigTimer.setText("" + minutesCounterBigTimer);
                    txtFieldSecondsBigTimer.setText("" + secondsCounterBigTimer);
                } else if (hoursCounterBigTimer > 0) {
                    hoursCounterBigTimer--;
                    minutesCounterBigTimer = 59;
                    secondsCounterBigTimer = 59;
                    txtFieldHoursBigTimer.setText("" + hoursCounterBigTimer);
                    txtFieldMinutesBigTimer.setText("" + minutesCounterBigTimer);
                    txtFieldSecondsBigTimer.setText("" + secondsCounterBigTimer);
                } else {
                    try {
                        inputstream = new FileInputStream(new File("C:\\Windows\\Media\\tada.wav").getAbsoluteFile());
                        audiostream = new AudioStream(inputstream);
                        audiodata = audiostream.getData();
                        loop = new ContinuousAudioDataStream(audiodata);
                    } catch (IOException error) {

                    }
                    audioplayer.start(loop);
                    timer.cancel();
                    labelFinal.setVisible(true);
                }
                timeForReading++;
            } else {
                startMusic.doClick();
            }
        }
    };

    TimerTask taskTimerBreak = new TimerTask() {
        public void run() {
            if (secondsCounterTimerBreak > 0) {
                txtFieldSecondsTimerBreak.setText("" + secondsCounterTimerBreak);
                txtFieldMinutesTimerBreak.setText("" + minutesCounterTimerBreak);
                secondsCounterTimerBreak--;
            } else if (minutesCounterTimerBreak > 0) {
                minutesCounterTimerBreak--;
                secondsCounterTimerBreak = 59;
                txtFieldSecondsTimerBreak.setText("" + secondsCounterTimerBreak);
                txtFieldMinutesTimerBreak.setText("" + minutesCounterTimerBreak);
            } else {
                TimerBreak.doClick();
                startMusic.doClick();

            }
        }
    };

    public Reading() {
        initComponents();
        labelFinal.setVisible(false);
        jPanel1.setVisible(false);
        startMusic.setVisible(false);
        TimerBreak.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFieldHoursBigTimer = new javax.swing.JTextField();
        txtFieldMinutesBigTimer = new javax.swing.JTextField();
        txtFieldSecondsBigTimer = new javax.swing.JTextField();
        buttonMain = new javax.swing.JToggleButton();
        labelFinal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtFieldSecondsTimerBreak = new javax.swing.JTextField();
        txtFieldMinutesTimerBreak = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        startMusic = new javax.swing.JButton();
        TimerBreak = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtFieldHoursBigTimer.setEditable(false);
        txtFieldHoursBigTimer.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        txtFieldHoursBigTimer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFieldHoursBigTimer.setText("0");

        txtFieldMinutesBigTimer.setEditable(false);
        txtFieldMinutesBigTimer.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        txtFieldMinutesBigTimer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFieldMinutesBigTimer.setText("0");

        txtFieldSecondsBigTimer.setEditable(false);
        txtFieldSecondsBigTimer.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        txtFieldSecondsBigTimer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFieldSecondsBigTimer.setText("0");
        txtFieldSecondsBigTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldSecondsBigTimerActionPerformed(evt);
            }
        });

        buttonMain.setText("Старт");
        buttonMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMainActionPerformed(evt);
            }
        });

        labelFinal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFinal.setText("YOU ARE THE BEST!!!");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton1.setText("+1 минута");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtFieldSecondsTimerBreak.setEditable(false);
        txtFieldSecondsTimerBreak.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFieldSecondsTimerBreak.setText("0");
        txtFieldSecondsTimerBreak.setMaximumSize(new java.awt.Dimension(20, 22));
        txtFieldSecondsTimerBreak.setMinimumSize(new java.awt.Dimension(20, 22));
        txtFieldSecondsTimerBreak.setPreferredSize(new java.awt.Dimension(20, 22));
        txtFieldSecondsTimerBreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldSecondsTimerBreakActionPerformed(evt);
            }
        });

        txtFieldMinutesTimerBreak.setEditable(false);
        txtFieldMinutesTimerBreak.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFieldMinutesTimerBreak.setText("0");
        txtFieldMinutesTimerBreak.setMaximumSize(new java.awt.Dimension(20, 22));
        txtFieldMinutesTimerBreak.setMinimumSize(new java.awt.Dimension(20, 22));
        txtFieldMinutesTimerBreak.setPreferredSize(new java.awt.Dimension(20, 22));
        txtFieldMinutesTimerBreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldMinutesTimerBreakActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText(":");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Почивка");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFieldMinutesTimerBreak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFieldSecondsTimerBreak, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFieldSecondsTimerBreak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFieldMinutesTimerBreak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        startMusic.setText("Start Music");
        startMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startMusicActionPerformed(evt);
            }
        });

        TimerBreak.setText("Timer - Break");
        TimerBreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimerBreakActionPerformed(evt);
            }
        });

        jLabel3.setText("Seconds");

        jLabel4.setText("Minutes");

        jLabel5.setText("Hours");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(startMusic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TimerBreak))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(buttonMain, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFieldHoursBigTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFieldMinutesBigTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFieldSecondsBigTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelFinal)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startMusic)
                    .addComponent(TimerBreak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldHoursBigTimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldMinutesBigTimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldSecondsBigTimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMain))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelFinal)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldSecondsBigTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldSecondsBigTimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldSecondsBigTimerActionPerformed

    private void buttonMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMainActionPerformed
        if (buttonMain.isSelected()) {
            buttonMain.setVisible(false);
            timeForReading = 0;
            audioplayer.stop(loop);
            buttonMain.setText("Стоп");
            resumeBigTimer();
        } else {
            audioplayer.stop(loop);
            buttonMain.setText("Старт");
            buttonMain.setVisible(false);
            jPanel1.setVisible(true);
            TimerBreak.doClick();
        }
    }//GEN-LAST:event_buttonMainActionPerformed

    private void txtFieldSecondsTimerBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldSecondsTimerBreakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldSecondsTimerBreakActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        minutesCounterTimerBreak++;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void startMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startMusicActionPerformed
        buttonMain.setVisible(true);
        try {
            inputstream = new FileInputStream(new File("C:\\Windows\\Media\\tada.wav").getAbsoluteFile());
            audiostream = new AudioStream(inputstream);
            audiodata = audiostream.getData();
            loop = new ContinuousAudioDataStream(audiodata);

        } catch (IOException error) {

        }
        audioplayer.start(loop);
        pause();
    }//GEN-LAST:event_startMusicActionPerformed

    private void TimerBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimerBreakActionPerformed
        if (TimerBreak.isSelected()) {
            minutesCounterTimerBreak = 4;
            secondsCounterTimerBreak = 59;
            resumeTimerBreak();
        } else {
            jPanel1.setVisible(false);
        }
    }//GEN-LAST:event_TimerBreakActionPerformed

    private void txtFieldMinutesTimerBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldMinutesTimerBreakActionPerformed

    }//GEN-LAST:event_txtFieldMinutesTimerBreakActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced inputstream Java SE 6) is not available, stay with the default look and feel.
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
            java.util.logging.Logger.getLogger(Reading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton TimerBreak;
    public javax.swing.JToggleButton buttonMain;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelFinal;
    private javax.swing.JButton startMusic;
    public javax.swing.JTextField txtFieldHoursBigTimer;
    public javax.swing.JTextField txtFieldMinutesBigTimer;
    private javax.swing.JTextField txtFieldMinutesTimerBreak;
    public javax.swing.JTextField txtFieldSecondsBigTimer;
    private javax.swing.JTextField txtFieldSecondsTimerBreak;
    // End of variables declaration//GEN-END:variables
}
