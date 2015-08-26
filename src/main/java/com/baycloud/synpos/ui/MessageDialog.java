package com.baycloud.synpos.ui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

/**
 * <p>Title: synPOS</p>
 *
 * <p>Description: synPOS is a desktop POS (Point Of Sale) client for online
 * ERP, eCommerce, and CRM systems. Released under the GNU General Public
 * License. Absolutely no warranty. Use at your own risk.</p>
 *
 * <p>Copyright: Copyright (c) 2006 synPOS.com</p>
 *
 * <p>Website: www.synpos.com</p>
 *
 * @author H.Q.
 * @version 0.9.1
 */
public class MessageDialog extends JDialog {
    private String msg;
    private String title;
    private JFrame parent;
    public MessageDialog(JFrame parent, String title, String msg) {
        super(parent);
        this.title = title;
        this.msg = msg;
        this.parent = parent;

        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
//        ImageIcon image = new ImageIcon("images/button-check_green.png");
//        imageContent.setIcon(image);

//        JPanel lPanel = new JPanel();
        BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);

        textContent.setBorder(border1);
        textContent.setHorizontalAlignment(SwingConstants.CENTER);
        textContent.setText(msg);

//        setLayout(layout);

        this.setDefaultCloseOperation(javax.swing.WindowConstants.
                DISPOSE_ON_CLOSE);
//        setSize(new Dimension(400, 100));
        setResizable(true);
        setModal(true);
        setTitle(title);

        imageContent.setAlignmentX(Component.CENTER_ALIGNMENT);
        textContent.setAlignmentX(Component.CENTER_ALIGNMENT);

//        getContentPane().add(imageContent, BorderLayout.CENTER);

        getContentPane().add(imageContent);
//        imageContent.setVisible(false);
        getContentPane().add(textContent);

        getContentPane().setLayout(layout);

//        getContentPane().add(textContent, java.awt.BorderLayout.CENTER);

        pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension pnlSize = getPreferredSize();
        setLocation((screenSize.width - pnlSize.width) / 2,
                    (screenSize.height - pnlSize.height) / 2);
    }

    void setIcon(String imagePath){
        imageContent.setIcon(new ImageIcon(imagePath));
        invalidate();
        pack();
    }

    JLabel textContent = new JLabel();

//    BorderLayout borderLayout1 = new BorderLayout();
    JLabel imageContent = new JLabel(new ImageIcon("images/hand-phone-nfc.png"));
    Border border1 = BorderFactory.createEmptyBorder(20, 20, 20, 20);
}
