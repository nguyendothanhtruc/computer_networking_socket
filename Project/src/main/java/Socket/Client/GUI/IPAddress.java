package Socket.Client.GUI;

import java.awt.event.ActionEvent;

public class IPAddress extends javax.swing.JFrame {
    private javax.swing.JLabel IPAddress;
    private javax.swing.JTextField InputIP;
    private keeptoo.KGradientPanel MainPanel;
    private javax.swing.JButton Run;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel WhitePanel;
    public String IP = null;

    public IPAddress() {
        initComponents();
    }

    private void initComponents() {

        MainPanel = new keeptoo.KGradientPanel();
        Title = new javax.swing.JLabel();
        WhitePanel = new javax.swing.JPanel();
        IPAddress = new javax.swing.JLabel();
        InputIP = new javax.swing.JTextField();
        Run = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setkEndColor(new java.awt.Color(51, 102, 255));
        MainPanel.setkStartColor(new java.awt.Color(255, 102, 255));

        Title.setFont(new java.awt.Font("iCiel Panton Black", 0, 48)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("CONNECTION");

        WhitePanel.setBackground(new java.awt.Color(255, 255, 255));

        IPAddress.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        IPAddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IPAddress.setText("IP Address:");

        InputIP.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        InputIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        InputIP.setText("127.0.0.1");
        InputIP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 255)));

        javax.swing.GroupLayout WhitePanelLayout = new javax.swing.GroupLayout(WhitePanel);
        WhitePanel.setLayout(WhitePanelLayout);
        WhitePanelLayout.setHorizontalGroup(
                WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WhitePanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(IPAddress)
                                .addGap(18, 18, 18)
                                .addComponent(InputIP, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        WhitePanelLayout.setVerticalGroup(
                WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WhitePanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(InputIP, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IPAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(29, Short.MAX_VALUE))
        );

        Run.setBackground(new java.awt.Color(51, 255, 51));
        Run.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        Run.setForeground(new java.awt.Color(255, 255, 255));
        Run.setText("RUN");
        Run.setBorderPainted(false);
        Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(WhitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Run, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(61, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Run, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(WhitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    public void waitForInputs() throws InterruptedException {
        synchronized (this) {
            wait();
        }
    }

    private void RunActionPerformed(ActionEvent evt) {
        IP = InputIP.getText();
        synchronized (this) {
            notifyAll();
        }
        this.setVisible(false);
    }

    public void Run() throws InterruptedException {
        this.setVisible(true);
        this.waitForInputs();
    }


}
