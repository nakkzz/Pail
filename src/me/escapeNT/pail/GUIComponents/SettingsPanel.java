
package me.escapeNT.pail.GUIComponents;

import java.util.HashMap;
import javax.swing.JOptionPane;
import me.escapeNT.pail.Pail;
import me.escapeNT.pail.config.ServerConfigHandler;
import me.escapeNT.pail.util.Util;

/**
 * Panel for editing server settings.
 * @author escapeNT
 */
public class SettingsPanel extends javax.swing.JPanel {

    /** Creates new form SettingsPanel */
    public SettingsPanel() {
        initComponents();

        String craftv = Util.getPlugin().getServer().getVersion();
        craftVersion.setText("Craftbukkit version:\n" + craftv);
        pailVersion.setText("Pail version: " + Pail.PLUGIN_VERSION);
        loadConfig();
    }

    /**
     * Loads the stored values from the server configuration.
     */
    private void loadConfig() {
        ServerConfigHandler.load();
        HashMap<String, String> c = ServerConfigHandler.getProperties();

        worldName.setText(c.get("level-name"));
        seed.setText(c.get("level-seed"));

        nether.setSelected(Boolean.parseBoolean(c.get("allow-nether")));
        spawnMonsters.setSelected(Boolean.parseBoolean(c.get("spawn-monsters")));
        spawnAnimals.setSelected(Boolean.parseBoolean(c.get("spawn-animals")));
        flight.setSelected(Boolean.parseBoolean(c.get("allow-flight")));
        pvp.setSelected(Boolean.parseBoolean(c.get("pvp")));
        online.setSelected(Boolean.parseBoolean(c.get("online-mode")));
        whitelist.setSelected(Boolean.parseBoolean(c.get("white-list")));

        viewDistance.setValue(Integer.parseInt(c.get("view-distance")));
        port.setValue(Integer.parseInt(c.get("server-port")));
        maxPlayers.setValue(Integer.parseInt(c.get("max-players")));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        worldName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        seed = new javax.swing.JTextField();
        nether = new javax.swing.JCheckBox();
        spawnMonsters = new javax.swing.JCheckBox();
        spawnAnimals = new javax.swing.JCheckBox();
        online = new javax.swing.JCheckBox();
        pvp = new javax.swing.JCheckBox();
        whitelist = new javax.swing.JCheckBox();
        flight = new javax.swing.JCheckBox();
        viewDistance = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        port = new javax.swing.JSpinner();
        revert = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        maxPlayers = new javax.swing.JSpinner();
        craftVersion = new javax.swing.JLabel();
        pailVersion = new javax.swing.JLabel();

        setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Server  Settings"));
        jPanel1.setLayout(null);

        jLabel1.setText("World name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(26, 48, 74, 16);

        worldName.setToolTipText("The name of the default world on the server");
        jPanel1.add(worldName);
        worldName.setBounds(110, 42, 224, 28);

        jLabel2.setText("World seed");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(26, 84, 69, 16);

        seed.setToolTipText("The seed used in generating new terrain.");
        jPanel1.add(seed);
        seed.setBounds(109, 78, 225, 28);

        nether.setText("Allow nether");
        nether.setToolTipText("Allow portal transport to the nether.");
        jPanel1.add(nether);
        nether.setBounds(26, 124, 111, 23);

        spawnMonsters.setText("Spawn monsters");
        spawnMonsters.setToolTipText("Spawn hostile monsters.");
        jPanel1.add(spawnMonsters);
        spawnMonsters.setBounds(26, 165, 135, 23);

        spawnAnimals.setText("Spawn animals");
        spawnAnimals.setToolTipText("Spawn non-hostile animals.");
        jPanel1.add(spawnAnimals);
        spawnAnimals.setBounds(26, 206, 125, 23);

        online.setText("Online mode");
        online.setToolTipText("Server checks connecting players against minecraft's account database.");
        jPanel1.add(online);
        online.setBounds(194, 165, 112, 23);

        pvp.setText("Enable PVP");
        pvp.setToolTipText("Enable player verses player damage.");
        jPanel1.add(pvp);
        pvp.setBounds(194, 124, 99, 23);

        whitelist.setText("Whitelist enabled");
        whitelist.setToolTipText("With a whitelist enabled, users not on the list will be unable to connect.");
        jPanel1.add(whitelist);
        whitelist.setBounds(194, 206, 140, 23);

        flight.setText("Allow flight");
        flight.setToolTipText("Will allow users to use flight/no-clip on the server.");
        jPanel1.add(flight);
        flight.setBounds(26, 247, 105, 23);

        viewDistance.setModel(new javax.swing.SpinnerNumberModel(3, 3, 15, 1));
        viewDistance.setToolTipText("The number of chunks sent to the client. (3-15)");
        jPanel1.add(viewDistance);
        viewDistance.setBounds(130, 290, 55, 28);

        jLabel3.setText("View distance");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 300, 86, 16);

        jLabel4.setText("Server port");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 330, 68, 16);

        port.setModel(new javax.swing.SpinnerNumberModel(25565, 1, 65535, 1));
        port.setToolTipText("Port on which the server is running.");
        jPanel1.add(port);
        port.setBounds(130, 320, 96, 28);

        revert.setText("Revert");
        revert.setFocusable(false);
        revert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revertActionPerformed(evt);
            }
        });
        jPanel1.add(revert);
        revert.setBounds(160, 400, 83, 29);

        save.setText("Save");
        save.setFocusable(false);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save);
        save.setBounds(240, 400, 75, 29);

        jLabel5.setText("Max players");
        jLabel5.setToolTipText("The maximum number of players allowed to connect.");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 360, 80, 16);

        maxPlayers.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));
        jPanel1.add(maxPlayers);
        maxPlayers.setBounds(130, 350, 60, 28);

        add(jPanel1);
        jPanel1.setBounds(20, 10, 340, 440);

        craftVersion.setText("Craftbukkit version:");
        add(craftVersion);
        craftVersion.setBounds(370, 20, 490, 20);

        pailVersion.setText("Pail version:");
        add(pailVersion);
        pailVersion.setBounds(370, 50, 410, 16);
    }// </editor-fold>//GEN-END:initComponents

    private void revertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revertActionPerformed
        loadConfig();
    }//GEN-LAST:event_revertActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        HashMap<String, String> saveData = new HashMap<String, String>();

        saveData.put("server-ip", "");
        saveData.put("level-name", worldName.getText());
        saveData.put("level-seed", seed.getText());

        saveData.put("allow-nether", Boolean.toString(nether.isSelected()));
        saveData.put("spawn-monsters", Boolean.toString(spawnMonsters.isSelected()));
        saveData.put("spawn-animals", Boolean.toString(spawnAnimals.isSelected()));
        saveData.put("allow-flight", Boolean.toString(flight.isSelected()));
        saveData.put("pvp", Boolean.toString(pvp.isSelected()));
        saveData.put("online-mode", Boolean.toString(online.isSelected()));
        saveData.put("white-list", Boolean.toString(whitelist.isSelected()));

        saveData.put("view-distance", viewDistance.getValue().toString());
        saveData.put("server-port", port.getValue().toString());
        saveData.put("max-players", maxPlayers.getValue().toString());

        ServerConfigHandler.save(saveData);

        JOptionPane.showMessageDialog(Util.getPlugin().getMainWindow(), 
                "Server config saved.", "Saved", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_saveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel craftVersion;
    private javax.swing.JCheckBox flight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner maxPlayers;
    private javax.swing.JCheckBox nether;
    private javax.swing.JCheckBox online;
    private javax.swing.JLabel pailVersion;
    private javax.swing.JSpinner port;
    private javax.swing.JCheckBox pvp;
    private javax.swing.JButton revert;
    private javax.swing.JButton save;
    private javax.swing.JTextField seed;
    private javax.swing.JCheckBox spawnAnimals;
    private javax.swing.JCheckBox spawnMonsters;
    private javax.swing.JSpinner viewDistance;
    private javax.swing.JCheckBox whitelist;
    private javax.swing.JTextField worldName;
    // End of variables declaration//GEN-END:variables

}