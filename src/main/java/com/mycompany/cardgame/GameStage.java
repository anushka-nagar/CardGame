/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cardgame;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.*;

/**
 *
 * @author anush
 */
public class GameStage extends javax.swing.JFrame {

    private PlayersInfo playersInfo = new PlayersInfo();
    ArrayList<String> temp = new ArrayList<>();
    String[] players;
    Game game;
    ArrayList<JButton> cardButtons = new ArrayList<>();
    ArrayList<String> cardIds;
    PopUp window;
    /**
     * Creates new form GameStage
     */
    public GameStage(){}
    public GameStage(ArrayList<String> players) {
        initComponents();
        temp = players;
        this.players = temp.toArray(new String[temp.size()]);
        game = new Game(this.players);
        populateArrayList();
        game.startGame();
        setPlayersName();
        topCardButton.setIcon(new ImageIcon(GameStage.class.getResource("/com.mycompany.cardgame.images/" + game.getTopCardImage())));
        setButtonIcons();
    }
    
    public void setButtonIcons(){
        String listString = game.getPlayerHand(game.getCurrentPlayer()).stream().map(Object::toString).collect(Collectors.joining(","));
        String[] cardNames = listString.split(",");
        cardIds = new ArrayList<>(Arrays.asList(cardNames));
        for (int i = 0; i < cardIds.size(); i++){
            cardButtons.get(i).setIcon(new ImageIcon(GameStage.class.getResource("/com.mycompany.cardgame.images/" + cardIds.get(i) + ".png")));
        }
        for (int i = cardIds.size(); i < cardButtons.size(); i++){
            cardButtons.get(i).setIcon(null);
        }
    }
    
    public void populateArrayList(){
        cardButtons.add(cardButton1);
        cardButtons.add(cardButton2);
        cardButtons.add(cardButton3);
        cardButtons.add(cardButton4);
        cardButtons.add(cardButton5);
        cardButtons.add(cardButton6);
        cardButtons.add(cardButton7);
        cardButtons.add(cardButton8);
        cardButtons.add(cardButton9);
        cardButtons.add(cardButton10);
        cardButtons.add(cardButton11);
    }
    
    public void setPlayersName(){
        String currentPlayer = game.getCurrentPlayer();
        playerNameLabel.setText(currentPlayer + "'s Cards");
    }
    
    public void setPlayersName(String currentPlayer){
        playerNameLabel.setText(currentPlayer + "'s Cards");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton11 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cardButton2 = new javax.swing.JButton();
        cardButton3 = new javax.swing.JButton();
        cardButton1 = new javax.swing.JButton();
        cardButton5 = new javax.swing.JButton();
        cardButton6 = new javax.swing.JButton();
        cardButton7 = new javax.swing.JButton();
        cardButton9 = new javax.swing.JButton();
        cardButton4 = new javax.swing.JButton();
        cardButton10 = new javax.swing.JButton();
        cardButton11 = new javax.swing.JButton();
        cardButton8 = new javax.swing.JButton();
        drawCardButton = new javax.swing.JButton();
        playerNameLabel = new javax.swing.JLabel();
        topCardButton = new javax.swing.JButton();
        downCard = new javax.swing.JButton();

        jButton11.setText("jButton1");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Card Game");
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        cardButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton2ActionPerformed(evt);
            }
        });

        cardButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton3ActionPerformed(evt);
            }
        });

        cardButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton1ActionPerformed(evt);
            }
        });

        cardButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton5ActionPerformed(evt);
            }
        });

        cardButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton6ActionPerformed(evt);
            }
        });

        cardButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton7ActionPerformed(evt);
            }
        });

        cardButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton9ActionPerformed(evt);
            }
        });

        cardButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton4ActionPerformed(evt);
            }
        });

        cardButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton10ActionPerformed(evt);
            }
        });

        cardButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton11ActionPerformed(evt);
            }
        });

        cardButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton8ActionPerformed(evt);
            }
        });

        drawCardButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        drawCardButton.setText("Draw Card");
        drawCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawCardButtonActionPerformed(evt);
            }
        });

        playerNameLabel.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N

        topCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topCardButtonActionPerformed(evt);
            }
        });

        downCard.setBackground(new java.awt.Color(204, 204, 255));
        downCard.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        downCard.setText("The Card");
        downCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downCardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(downCard)
                        .addGap(28, 28, 28)
                        .addComponent(topCardButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cardButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardButton11))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(drawCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(topCardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(downCard, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(drawCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cardButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton3ActionPerformed
        // TODO add your handling code here:
        if(cardIds.get(2) != null){
            int index = 2;
            String cardId = cardIds.get(2);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_cardButton3ActionPerformed

    private void cardButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton2ActionPerformed
        // TODO add your handling code here:
        if(cardIds.get(1) != null){
            int index = 1;
            String cardId = cardIds.get(1);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_cardButton2ActionPerformed

    private void cardButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton1ActionPerformed
        // TODO add your handling code here:
        if(cardIds.get(0) != null){
            int index = 0;
            String cardId = cardIds.get(0);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_cardButton1ActionPerformed

    private void cardButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton5ActionPerformed
        // TODO add your handling code here:
        if(cardIds.get(4) != null){
            int index = 4;
            String cardId = cardIds.get(4);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_cardButton5ActionPerformed

    private void cardButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton6ActionPerformed
        // TODO add your handling code here:
        if(cardIds.get(5) != null){
            int index = 5;
            String cardId = cardIds.get(5);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_cardButton6ActionPerformed

    private void cardButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton7ActionPerformed
        // TODO add your handling code here:
        if(cardIds.get(6) != null){
            int index = 6;
            String cardId = cardIds.get(6);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_cardButton7ActionPerformed

    private void cardButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton9ActionPerformed
        // TODO add your handling code here:
        if(cardIds.get(8) != null){
            int index = 8;
            String cardId = cardIds.get(8);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_cardButton9ActionPerformed

    private void cardButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton4ActionPerformed
        // TODO add your handling code here:
        if(cardIds.get(3) != null){
            int index = 3;
            String cardId = cardIds.get(3);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_cardButton4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void cardButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton10ActionPerformed
        // TODO add your handling code here:
        if(cardIds.get(9) != null){
            int index = 9;
            String cardId = cardIds.get(9);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_cardButton10ActionPerformed

    private void cardButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton11ActionPerformed
        // TODO add your handling code here:
        if(cardIds.get(10) != null){
            int index = 10;
            String cardId = cardIds.get(10);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_cardButton11ActionPerformed

    private void cardButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton8ActionPerformed
        // TODO add your handling code here:
        if(cardIds.get(7) != null){
            int index = 7;
            String cardId = cardIds.get(7);
            window = new PopUp(cardId, game, index, cardButtons, this, topCardButton);
            window.setBounds(750,40,700,800);
            window.setVisible(true);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_cardButton8ActionPerformed

    private void drawCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawCardButtonActionPerformed
        // TODO add your handling code here:
        JLabel message = new JLabel(game.getCurrentPlayer() + " drew a card!");
        message.setFont(new Font("Ariel", Font.BOLD, 48));
        JOptionPane.showMessageDialog(null, message);
        try{
            game.submitDraws(game.getCurrentPlayer(), 1);
        }catch(InvalidPlayerTurnException exp){
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, exp);
            this.setPlayersName(game.getCurrentPlayer());
            this.setButtonIcons();
        }
    }//GEN-LAST:event_drawCardButtonActionPerformed

    private void topCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topCardButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_topCardButtonActionPerformed

    private void downCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downCardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_downCardActionPerformed

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
            java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameStage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cardButton1;
    private javax.swing.JButton cardButton10;
    private javax.swing.JButton cardButton11;
    private javax.swing.JButton cardButton2;
    private javax.swing.JButton cardButton3;
    private javax.swing.JButton cardButton4;
    private javax.swing.JButton cardButton5;
    private javax.swing.JButton cardButton6;
    private javax.swing.JButton cardButton7;
    private javax.swing.JButton cardButton8;
    private javax.swing.JButton cardButton9;
    private javax.swing.JButton downCard;
    private javax.swing.JButton drawCardButton;
    private javax.swing.JButton jButton11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel playerNameLabel;
    private javax.swing.JButton topCardButton;
    // End of variables declaration//GEN-END:variables
}