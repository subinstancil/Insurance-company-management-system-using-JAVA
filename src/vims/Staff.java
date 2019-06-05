/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vims;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
///
import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.Desktop;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import static vims.Utils.getAllComponents;

/**
 *
 * @author subin stancil
 */
public class Staff extends javax.swing.JFrame {

    /**
     * Creates new form Staff
     */
    
    
    public Staff() {
        initComponents();
        
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) 
            { setExtendedState(MAXIMIZED_BOTH);}
        });
        this.setLocationRelativeTo(null);
       // int i=JOptionPane.showConfirmDialog(this,"are you sure");
        System.err.println(cUserId);
        setDateAndTime();
        layerRemoveAll(main);
        layerRemoveAll(main2);
        layerAdd(main,main2);
        layerAdd(main2,sbar);
        layerAdd(main2,home);
        layerAdd(main,main1);
        Calendar fdob= Calendar.getInstance();
        dop.setMaxSelectableDate(fdob.getTime());
        jYearChooser1.setMaximum(Calendar.getInstance().getWeekYear());
        year.setMaximum(Calendar.getInstance().getWeekYear());
    }
//    public Staff(String s)
//    {
//       cUserId=s; 
//    }
    String cUserId;
    int custFrom=0;
    
        public void layerRemoveAll(JLayeredPane l1)
    {
               
        l1.removeAll();
        l1.repaint();
        l1.revalidate();
        
     
    }
    
    public void layerAdd(JLayeredPane l1,JLayeredPane l2)
    {
        
        
        l1.add(l2);
        l1.repaint();
        l1.revalidate();
        
    }
    
    
    
        public void setDateAndTime()
    {
        System.out.println("success 11111 1");
        Thread d=new Thread()
        {  
            public void run()
            { System.out.println("success 22222");
                for(;;)
                {
                                    ////////////////////////////////////////////////
                                                        //date                      ////
                       DateFormat dateFormat=new SimpleDateFormat("dd - MM - YYYY");    ////
                      Calendar cal=Calendar.getInstance();                          ////

                      dspDate.setText(dateFormat.format(cal.getTime()));           ////
                                           /////////
                                                        //time                      ////
                      DateFormat timeFormat = new SimpleDateFormat("hh : mm : ss  aa");     ////
                      Calendar clo = Calendar.getInstance();                        ////
                     dspTime.setText(timeFormat.format(clo.getTime()));            ////
              //        btime.setText(timeFormat.format(clo.getTime()));   /////////////////////
                                         ////////////////////////////////////////////////  
                                                
                             try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }                               
                                                
                }
                    

        
            }
        };
//        System.out.print(xx);
//        if(xx==0)
             d.start();
//        else
//            d.stop();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        main = new javax.swing.JLayeredPane();
        main2 = new javax.swing.JLayeredPane();
        log = new javax.swing.JLayeredPane();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        change = new javax.swing.JLayeredPane();
        jLabel75 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        cnewpass = new javax.swing.JPasswordField();
        newpass = new javax.swing.JPasswordField();
        cpass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        qwe = new javax.swing.JLabel();
        home = new javax.swing.JLayeredPane();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        sbar = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        page = new javax.swing.JLayeredPane();
        custOp = new javax.swing.JLayeredPane();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        vehicle = new javax.swing.JLayeredPane();
        jLabel31 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        regno = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        egno = new javax.swing.JTextField();
        tv2 = new javax.swing.JComboBox<>();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        cc2 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        chno = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        dop = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        year = new com.toedter.calendar.JYearChooser();
        color = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        make = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        tfuel = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        model = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        tp2 = new javax.swing.JComboBox<>();
        jLabel89 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        pback2 = new javax.swing.JLayeredPane();
        jLabel8 = new javax.swing.JLabel();
        customer = new javax.swing.JLayeredPane();
        jLabel30 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        custid = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        padd = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cadd = new javax.swing.JTextArea();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        dob1 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        occu = new javax.swing.JTextField();
        nat = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        mphn = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lphn = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        eid = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        fxno = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        panno = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        pback1 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        pcalc = new javax.swing.JLayeredPane();
        jLabel9 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tv = new javax.swing.JComboBox<>();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        cc = new javax.swing.JComboBox<>();
        jLabel78 = new javax.swing.JLabel();
        pr = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        tp = new javax.swing.JComboBox<>();
        jLabel80 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        tv1 = new javax.swing.JLabel();
        cc1 = new javax.swing.JLabel();
        av1 = new javax.swing.JLabel();
        tp1 = new javax.swing.JLabel();
        ep1 = new javax.swing.JLabel();
        pr1 = new javax.swing.JLabel();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        pback = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        veiw = new javax.swing.JLayeredPane();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        pno = new javax.swing.JLabel();
        ga = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        prof = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        rgno = new javax.swing.JLabel();
        rgdate = new javax.swing.JLabel();
        egnno = new javax.swing.JLabel();
        chano = new javax.swing.JLabel();
        make1 = new javax.swing.JLabel();
        model1 = new javax.swing.JLabel();
        ym = new javax.swing.JLabel();
        cubic = new javax.swing.JLabel();
        net = new javax.swing.JLabel();
        stax = new javax.swing.JLabel();
        tpre = new javax.swing.JLabel();
        isdate = new javax.swing.JLabel();
        iedate = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        pback3 = new javax.swing.JLayeredPane();
        jLabel66 = new javax.swing.JLabel();
        policyOp = new javax.swing.JLayeredPane();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        custUpdate = new javax.swing.JLayeredPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        custTable = new javax.swing.JTable();
        jLabel69 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        policy = new javax.swing.JLayeredPane();
        jLabel94 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        expired = new javax.swing.JTable();
        jLabel95 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        active = new javax.swing.JTable();
        policyRenew = new javax.swing.JLayeredPane();
        jLabel96 = new javax.swing.JLabel();
        policyNo = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        custid3 = new javax.swing.JTextField();
        custName = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        custAdress = new javax.swing.JTextField();
        occupation = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        start = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        end = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        vreg = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        custView = new javax.swing.JLayeredPane();
        jLabel113 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        mdl = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        namel = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        dob = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        paddress = new javax.swing.JTextArea();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        mailid = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        phnt = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        phnm = new javax.swing.JTextField();
        namef = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        cid = new javax.swing.JTextField();
        vregno = new javax.swing.JTextField();
        rdate = new javax.swing.JTextField();
        vtype = new javax.swing.JTextField();
        vcc = new javax.swing.JTextField();
        engno = new javax.swing.JTextField();
        chasisno = new javax.swing.JTextField();
        mke = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        about = new javax.swing.JLayeredPane();
        jLabel114 = new javax.swing.JLabel();
        ffffabout = new javax.swing.JTextArea();
        main1 = new javax.swing.JLayeredPane();
        bgrnd = new javax.swing.JLayeredPane();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        dspDate = new javax.swing.JLabel();
        dspTime = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jScrollPane1.setMinimumSize(new java.awt.Dimension(300, 300));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1360, 700));

        jDesktopPane1.setMaximumSize(new java.awt.Dimension(1360, 700));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1360, 700));
        jDesktopPane1.setLayout(new javax.swing.OverlayLayout(jDesktopPane1));

        log.setBackground(new java.awt.Color(255, 0, 255));
        log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logMouseExited(evt);
            }
        });

        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/chg1.png"))); // NOI18N
        jLabel73.setPreferredSize(new java.awt.Dimension(153, 38));
        jLabel73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel73MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel73MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel73MouseExited(evt);
            }
        });

        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/logout1.png"))); // NOI18N
        jLabel74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel74MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel74MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel74MouseExited(evt);
            }
        });

        log.setLayer(jLabel73, javax.swing.JLayeredPane.DEFAULT_LAYER);
        log.setLayer(jLabel74, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout logLayout = new javax.swing.GroupLayout(log);
        log.setLayout(logLayout);
        logLayout.setHorizontalGroup(
            logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
            .addGroup(logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(logLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
            .addGroup(logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(logLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        logLayout.setVerticalGroup(
            logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
            .addGroup(logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(logLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE)))
            .addGroup(logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logLayout.createSequentialGroup()
                    .addContainerGap(48, Short.MAX_VALUE)
                    .addComponent(jLabel74)
                    .addGap(19, 19, 19)))
        );

        change.setBackground(new java.awt.Color(204, 204, 204));
        change.setOpaque(true);

        jLabel75.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel75.setText("Current Password");

        jLabel90.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel90.setText("New Password");

        jLabel91.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel91.setText("Confirm New Password");

        cnewpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        newpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        cpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jButton1.setText("Ok");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        qwe.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        qwe.setForeground(new java.awt.Color(255, 0, 0));
        qwe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        change.setLayer(jLabel75, javax.swing.JLayeredPane.DEFAULT_LAYER);
        change.setLayer(jLabel90, javax.swing.JLayeredPane.DEFAULT_LAYER);
        change.setLayer(jLabel91, javax.swing.JLayeredPane.DEFAULT_LAYER);
        change.setLayer(cnewpass, javax.swing.JLayeredPane.DEFAULT_LAYER);
        change.setLayer(newpass, javax.swing.JLayeredPane.DEFAULT_LAYER);
        change.setLayer(cpass, javax.swing.JLayeredPane.DEFAULT_LAYER);
        change.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        change.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        change.setLayer(qwe, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout changeLayout = new javax.swing.GroupLayout(change);
        change.setLayout(changeLayout);
        changeLayout.setHorizontalGroup(
            changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addComponent(newpass, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(52, Short.MAX_VALUE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(260, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(changeLayout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(260, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(changeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(261, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(166, Short.MAX_VALUE)
                    .addComponent(cnewpass, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(83, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(167, Short.MAX_VALUE)
                    .addComponent(cpass, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(83, 83, 83)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(182, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(157, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(274, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(65, 65, 65)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(20, Short.MAX_VALUE)
                    .addComponent(qwe, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19)))
        );
        changeLayout.setVerticalGroup(
            changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(newpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(57, Short.MAX_VALUE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(185, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(changeLayout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(149, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(changeLayout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(119, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(124, Short.MAX_VALUE)
                    .addComponent(cnewpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(124, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(changeLayout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(cpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(188, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(197, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addContainerGap(48, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(197, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addGap(48, 48, 48)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(159, Short.MAX_VALUE)
                    .addComponent(qwe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(82, Short.MAX_VALUE)))
        );

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/CUST.png"))); // NOI18N
        jLabel108.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/PRM.png"))); // NOI18N
        jLabel109.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/POLICY.png"))); // NOI18N
        jLabel110.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel71MouseClicked(evt);
            }
        });

        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/ABTS.png"))); // NOI18N
        jLabel111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel112MouseClicked(evt);
            }
        });

        home.setLayer(jLabel108, javax.swing.JLayeredPane.DEFAULT_LAYER);
        home.setLayer(jLabel109, javax.swing.JLayeredPane.DEFAULT_LAYER);
        home.setLayer(jLabel110, javax.swing.JLayeredPane.DEFAULT_LAYER);
        home.setLayer(jLabel111, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 981, Short.MAX_VALUE)
            .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel108)
                    .addContainerGap(489, Short.MAX_VALUE)))
            .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                    .addGap(0, 503, Short.MAX_VALUE)
                    .addComponent(jLabel109)))
            .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel110)
                    .addContainerGap(493, Short.MAX_VALUE)))
            .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                    .addGap(0, 499, Short.MAX_VALUE)
                    .addComponent(jLabel111)))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
            .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                    .addContainerGap(109, Short.MAX_VALUE)
                    .addComponent(jLabel108)
                    .addContainerGap(315, Short.MAX_VALUE)))
            .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                    .addContainerGap(106, Short.MAX_VALUE)
                    .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(309, 309, 309)))
            .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                    .addContainerGap(249, Short.MAX_VALUE)
                    .addComponent(jLabel110)
                    .addGap(174, 174, 174)))
            .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                    .addContainerGap(247, Short.MAX_VALUE)
                    .addComponent(jLabel111)
                    .addGap(176, 176, 176)))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home3.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/pCalc1.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/cust1.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy1.png"))); // NOI18N
        jLabel71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel71MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel71MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel71MouseExited(evt);
            }
        });

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg1.png"))); // NOI18N
        jLabel72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel72MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel72MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel72MouseExited(evt);
            }
        });

        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png"))); // NOI18N
        jLabel112.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel112MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel112MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel112MouseExited(evt);
            }
        });

        sbar.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sbar.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sbar.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sbar.setLayer(jLabel71, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sbar.setLayer(jLabel72, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sbar.setLayer(jLabel112, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout sbarLayout = new javax.swing.GroupLayout(sbar);
        sbar.setLayout(sbarLayout);
        sbarLayout.setHorizontalGroup(
            sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2)
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sbarLayout.createSequentialGroup()
                    .addComponent(jLabel3)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sbarLayout.createSequentialGroup()
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sbarLayout.createSequentialGroup()
                    .addComponent(jLabel112)
                    .addGap(0, 20, Short.MAX_VALUE)))
        );
        sbarLayout.setVerticalGroup(
            sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sbarLayout.createSequentialGroup()
                    .addContainerGap(70, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addContainerGap(232, Short.MAX_VALUE)))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sbarLayout.createSequentialGroup()
                    .addContainerGap(122, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addContainerGap(180, Short.MAX_VALUE)))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sbarLayout.createSequentialGroup()
                    .addContainerGap(172, Short.MAX_VALUE)
                    .addComponent(jLabel71)
                    .addContainerGap(130, Short.MAX_VALUE)))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sbarLayout.createSequentialGroup()
                    .addContainerGap(219, Short.MAX_VALUE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(71, Short.MAX_VALUE)))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sbarLayout.createSequentialGroup()
                    .addGap(278, 278, 278)
                    .addComponent(jLabel112)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add2.png"))); // NOI18N
        jLabel67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel67MouseClicked(evt);
            }
        });
        custOp.add(jLabel67);
        jLabel67.setBounds(94, -10, 70, 60);

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view1.png"))); // NOI18N
        jLabel68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel68MouseClicked(evt);
            }
        });
        custOp.add(jLabel68);
        jLabel68.setBounds(164, -10, 70, 60);

        vehicle.setBackground(new java.awt.Color(51, 255, 255));
        vehicle.setOpaque(true);

        jLabel31.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText("Vehicle Details");
        vehicle.add(jLabel31);
        jLabel31.setBounds(70, 0, 180, 40);

        jLabel20.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Add");
        vehicle.add(jLabel20);
        jLabel20.setBounds(38, 0, 30, 40);

        jLabel26.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Vehicles Regn. No.");
        vehicle.add(jLabel26);
        jLabel26.setBounds(130, 87, 130, 30);

        regno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        vehicle.add(regno);
        regno.setBounds(130, 118, 160, 20);

        jLabel27.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Engine No");
        vehicle.add(jLabel27);
        jLabel27.setBounds(130, 387, 100, 30);

        egno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        vehicle.add(egno);
        egno.setBounds(130, 418, 170, 20);

        tv2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Private Cars", "Two Wheelers", "Goods Carrying Vehicles", "Vhcls for Hire(upto 6 Pass)", "Vhcls for Hire(above 6 Pass)", "3 WHR PASS carriying" }));
        tv2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        tv2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tv2ActionPerformed(evt);
                tv2avActionPerformed(evt);
            }
        });
        vehicle.add(tv2);
        tv2.setBounds(125, 179, 170, 20);

        jLabel87.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel87.setText("Type of Vehicle");
        vehicle.add(jLabel87);
        jLabel87.setBounds(128, 152, 120, 20);

        jLabel88.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel88.setText("Cubic Capacity");
        vehicle.add(jLabel88);
        jLabel88.setBounds(128, 212, 90, 20);

        cc2.setSelectedItem(-1);
        cc2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        cc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cc2avActionPerformed(evt);
            }
        });
        vehicle.add(cc2);
        cc2.setBounds(125, 239, 170, 20);

        jLabel28.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Chassis No");
        vehicle.add(jLabel28);
        jLabel28.setBounds(130, 437, 100, 30);

        chno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        vehicle.add(chno);
        chno.setBounds(130, 468, 170, 20);

        jLabel32.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Registration Date");
        vehicle.add(jLabel32);
        jLabel32.setBounds(410, 87, 140, 30);

        dop.setMaxSelectableDate(new java.util.Date(253370748696000L));
        dop.setMinSelectableDate(new java.util.Date(-62135785704000L));
        dop.setOpaque(false);
        vehicle.add(dop);
        dop.setBounds(410, 120, 180, 20);

        jLabel33.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Year of Manufacture");
        vehicle.add(jLabel33);
        jLabel33.setBounds(410, 157, 140, 30);
        vehicle.add(year);
        year.setBounds(410, 190, 180, 20);

        color.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        vehicle.add(color);
        color.setBounds(410, 248, 180, 20);

        jLabel34.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Colour of Vehicle");
        vehicle.add(jLabel34);
        jLabel34.setBounds(410, 217, 110, 30);

        jLabel35.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Make");
        vehicle.add(jLabel35);
        jLabel35.setBounds(410, 267, 110, 30);

        make.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        vehicle.add(make);
        make.setBounds(410, 298, 180, 20);

        jLabel36.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Type of Fuel");
        vehicle.add(jLabel36);
        jLabel36.setBounds(410, 373, 110, 30);

        tfuel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        vehicle.add(tfuel);
        tfuel.setBounds(410, 408, 180, 20);

        jLabel37.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("Model");
        vehicle.add(jLabel37);
        jLabel37.setBounds(410, 323, 110, 30);

        model.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        vehicle.add(model);
        model.setBounds(410, 358, 180, 20);

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        jLabel61.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel61MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel61MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel61MouseExited(evt);
            }
        });
        vehicle.add(jLabel61);
        jLabel61.setBounds(740, 200, 120, 30);

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        jLabel62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel62emptyFields(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel62MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel62MouseExited(evt);
            }
        });
        vehicle.add(jLabel62);
        jLabel62.setBounds(740, 270, 120, 30);

        tp2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Liability Only", "Package Policy" }));
        tp2.setSelectedItem(-1);
        tp2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        tp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tp2ActionPerformed(evt);
            }
        });
        vehicle.add(tp2);
        tp2.setBounds(125, 299, 170, 20);

        jLabel89.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel89.setText("Type of Policy");
        vehicle.add(jLabel89);
        jLabel89.setBounds(128, 272, 80, 20);

        price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        vehicle.add(price);
        price.setBounds(130, 368, 170, 20);

        jLabel38.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("Ex showroom price");
        vehicle.add(jLabel38);
        jLabel38.setBounds(130, 337, 110, 30);

        pback2.setLayout(new javax.swing.OverlayLayout(pback2));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/pbgrng.png"))); // NOI18N
        pback2.add(jLabel8);

        vehicle.add(pback2);
        pback2.setBounds(0, 0, 987, 554);

        customer.setBackground(new java.awt.Color(0, 204, 204));

        jLabel30.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setText("Customer");
        customer.add(jLabel30);
        jLabel30.setBounds(70, 0, 180, 40);

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Add");
        customer.add(jLabel10);
        jLabel10.setBounds(38, 0, 30, 40);

        jLabel18.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Cust Id");
        customer.add(jLabel18);
        jLabel18.setBounds(130, 90, 80, 27);

        custid.setEditable(false);
        custid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        customer.add(custid);
        custid.setBounds(130, 120, 170, 18);

        padd.setColumns(20);
        padd.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        padd.setRows(5);
        jScrollPane2.setViewportView(padd);

        customer.add(jScrollPane2);
        jScrollPane2.setBounds(370, 116, 170, 100);
        jScrollPane2.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane2.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        jLabel15.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Permenant Address");
        customer.add(jLabel15);
        jLabel15.setBounds(370, 87, 120, 30);

        cadd.setColumns(20);
        cadd.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        cadd.setRows(5);
        jScrollPane3.setViewportView(cadd);

        customer.add(jScrollPane3);
        jScrollPane3.setBounds(370, 276, 170, 100);
        jScrollPane3.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane3.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        jCheckBox1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jCheckBox1.setText("same as permenant");
        jCheckBox1.setOpaque(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        customer.add(jCheckBox1);
        jCheckBox1.setBounds(370, 245, 150, 30);

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Current Address");
        customer.add(jLabel11);
        jLabel11.setBounds(370, 220, 100, 30);

        buttonGroup1.add(male);
        male.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        male.setText("Male");
        male.setOpaque(false);
        customer.add(male);
        male.setBounds(140, 323, 60, 30);

        buttonGroup1.add(female);
        female.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        female.setText("Female");
        female.setOpaque(false);
        customer.add(female);
        female.setBounds(220, 323, 70, 30);

        dob1.setOpaque(false);
        customer.add(dob1);
        dob1.setBounds(130, 270, 170, 30);

        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Sex");
        customer.add(jLabel14);
        jLabel14.setBounds(130, 297, 90, 30);

        jLabel16.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Date Of Birth");
        customer.add(jLabel16);
        jLabel16.setBounds(130, 247, 90, 20);

        lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        customer.add(lname);
        lname.setBounds(130, 218, 170, 20);

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Last Name");
        customer.add(jLabel13);
        jLabel13.setBounds(130, 197, 70, 20);

        fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        customer.add(fname);
        fname.setBounds(130, 168, 170, 20);

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("First Name");
        customer.add(jLabel12);
        jLabel12.setBounds(130, 147, 70, 20);

        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Occupation");
        customer.add(jLabel17);
        jLabel17.setBounds(130, 367, 70, 20);

        occu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        customer.add(occu);
        occu.setBounds(130, 388, 170, 20);

        nat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        customer.add(nat);
        nat.setBounds(130, 438, 170, 20);

        jLabel19.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Nationality");
        customer.add(jLabel19);
        jLabel19.setBounds(130, 417, 70, 20);

        mphn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        mphn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mphnKeyTyped(evt);
            }
        });
        customer.add(mphn);
        mphn.setBounds(370, 430, 170, 20);

        jLabel22.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Phone no");
        customer.add(jLabel22);
        jLabel22.setBounds(370, 400, 80, 30);

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Telephone");
        customer.add(jLabel23);
        jLabel23.setBounds(630, 90, 80, 30);

        lphn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        lphn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lphnKeyTyped(evt);
            }
        });
        customer.add(lphn);
        lphn.setBounds(630, 120, 170, 20);

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Email ID");
        customer.add(jLabel21);
        jLabel21.setBounds(630, 147, 80, 30);

        eid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        customer.add(eid);
        eid.setBounds(630, 178, 170, 20);

        jLabel24.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Fax No");
        customer.add(jLabel24);
        jLabel24.setBounds(630, 210, 80, 30);

        fxno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        fxno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fxnoKeyTyped(evt);
            }
        });
        customer.add(fxno);
        fxno.setBounds(630, 240, 170, 20);

        jLabel25.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Pan No");
        customer.add(jLabel25);
        jLabel25.setBounds(630, 267, 80, 30);

        panno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        panno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pannoKeyTyped(evt);
            }
        });
        customer.add(panno);
        panno.setBounds(630, 298, 170, 20);

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/nxt.png"))); // NOI18N
        jLabel58.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel58MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel58MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel58MouseExited(evt);
            }
        });
        customer.add(jLabel58);
        jLabel58.setBounds(650, 390, 120, 34);

        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        jLabel59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel59emptyFields(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel59MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel59MouseExited(evt);
            }
        });
        customer.add(jLabel59);
        jLabel59.setBounds(790, 390, 120, 34);

        pback1.setLayout(new javax.swing.OverlayLayout(pback1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/pbgrng.png"))); // NOI18N
        pback1.add(jLabel6);

        customer.add(pback1);
        pback1.setBounds(0, 0, 987, 554);

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Premium");
        pcalc.add(jLabel9);
        jLabel9.setBounds(28, 0, 100, 40);

        jLabel29.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("Calculator");
        pcalc.add(jLabel29);
        jLabel29.setBounds(90, 0, 160, 40);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pcalc.add(jSeparator1);
        jSeparator1.setBounds(484, 41, 12, 502);

        tv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Private Cars", "Two Wheelers", "Goods Carrying Vehicles", "Vhcls for Hire(upto 6 Pass)", "Vhcls for Hire(above 6 Pass)", "3 WHR PASS carriying" }));
        tv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        tv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvActionPerformed(evt);
                tvavActionPerformed(evt);
            }
        });
        pcalc.add(tv);
        tv.setBounds(135, 119, 200, 20);

        jLabel76.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel76.setText("Type of Vehicle");
        pcalc.add(jLabel76);
        jLabel76.setBounds(58, 92, 140, 24);

        jLabel77.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel77.setText("Cubic Capacity");
        pcalc.add(jLabel77);
        jLabel77.setBounds(58, 152, 140, 20);

        cc.setSelectedItem(-1);
        cc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        cc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccavActionPerformed(evt);
            }
        });
        pcalc.add(cc);
        cc.setBounds(135, 179, 200, 20);

        jLabel78.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Year of Manufacture");
        pcalc.add(jLabel78);
        jLabel78.setBounds(58, 212, 140, 20);

        pr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        pr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prKeyTyped(evt);
            }
        });
        pcalc.add(pr);
        pr.setBounds(140, 370, 190, 20);

        jLabel79.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText("Ex Showroom Price of Vehicle");
        pcalc.add(jLabel79);
        jLabel79.setBounds(58, 332, 170, 30);

        tp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Liability Only", "Package Policy" }));
        tp.setSelectedItem(-1);
        tp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        tp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpActionPerformed(evt);
            }
        });
        pcalc.add(tp);
        tp.setBounds(135, 299, 200, 20);

        jLabel80.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("Type of Policy");
        pcalc.add(jLabel80);
        jLabel80.setBounds(58, 272, 140, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/nxt.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        pcalc.add(jLabel7);
        jLabel7.setBounds(170, 466, 120, 34);

        jLabel81.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel81.setText("Type of Vehicle  :");
        pcalc.add(jLabel81);
        jLabel81.setBounds(618, 112, 110, 20);

        jLabel82.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel82.setText("Cubic Capacity  :");
        pcalc.add(jLabel82);
        jLabel82.setBounds(618, 162, 110, 30);

        jLabel83.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel83.setText("Age of Vehicle  :");
        pcalc.add(jLabel83);
        jLabel83.setBounds(618, 212, 110, 40);

        jLabel84.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel84.setText("Type of Policy  :");
        pcalc.add(jLabel84);
        jLabel84.setBounds(618, 272, 110, 30);

        jLabel85.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel85.setText("Ex showroom price  :");
        pcalc.add(jLabel85);
        jLabel85.setBounds(598, 332, 130, 30);

        jLabel86.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel86.setText("Premium in Rupees  :");
        pcalc.add(jLabel86);
        jLabel86.setBounds(588, 382, 150, 40);

        tv1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        tv1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pcalc.add(tv1);
        tv1.setBounds(738, 112, 210, 20);

        cc1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        cc1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pcalc.add(cc1);
        cc1.setBounds(738, 162, 220, 30);

        av1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        av1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pcalc.add(av1);
        av1.setBounds(738, 212, 220, 40);

        tp1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        tp1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pcalc.add(tp1);
        tp1.setBounds(738, 272, 220, 30);

        ep1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        ep1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pcalc.add(ep1);
        ep1.setBounds(738, 332, 220, 30);

        pr1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        pr1.setForeground(new java.awt.Color(255, 0, 0));
        pr1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pcalc.add(pr1);
        pr1.setBounds(748, 382, 200, 40);
        pcalc.add(jYearChooser1);
        jYearChooser1.setBounds(140, 240, 190, 20);

        pback.setLayout(new javax.swing.OverlayLayout(pback));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/pbgrng.png"))); // NOI18N
        pback.add(jLabel5);

        jLabel39.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("Policy Number  :");
        veiw.add(jLabel39);
        jLabel39.setBounds(55, 62, 130, 24);

        jLabel40.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Geographical Area  :");
        veiw.add(jLabel40);
        jLabel40.setBounds(29, 91, 160, 25);

        jLabel41.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel41.setText("Insured Name  :");
        veiw.add(jLabel41);
        jLabel41.setBounds(30, 120, 160, 27);

        jLabel42.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("Profession  :");
        veiw.add(jLabel42);
        jLabel42.setBounds(40, 150, 150, 26);

        jLabel43.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Insured Address  :");
        veiw.add(jLabel43);
        jLabel43.setBounds(40, 180, 150, 25);

        jLabel44.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("Insurance Start Date  :");
        veiw.add(jLabel44);
        jLabel44.setBounds(414, 72, 130, 24);

        jLabel45.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("Insurance Expiry Date  :");
        veiw.add(jLabel45);
        jLabel45.setBounds(416, 102, 130, 24);

        jLabel46.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 0, 0));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Vehicle Details");
        veiw.add(jLabel46);
        jLabel46.setBounds(70, 248, 100, 37);

        jLabel47.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("Registartion Number  :");
        veiw.add(jLabel47);
        jLabel47.setBounds(45, 302, 130, 23);

        jLabel48.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel48.setText("Registartion Date  :");
        veiw.add(jLabel48);
        jLabel48.setBounds(45, 329, 130, 33);

        jLabel49.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel49.setText("Engine Number  :");
        veiw.add(jLabel49);
        jLabel49.setBounds(57, 363, 120, 30);

        jLabel50.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel50.setText("Chassis Number  :");
        veiw.add(jLabel50);
        jLabel50.setBounds(67, 393, 110, 30);

        jLabel51.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel51.setText("Make  :");
        veiw.add(jLabel51);
        jLabel51.setBounds(78, 422, 100, 40);

        jLabel52.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel52.setText("Model  :");
        veiw.add(jLabel52);
        jLabel52.setBounds(88, 455, 90, 40);

        jLabel53.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel53.setText("Year of Manufacture  :");
        veiw.add(jLabel53);
        jLabel53.setBounds(316, 301, 120, 28);

        jLabel54.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel54.setText("Cubic Capacity  :");
        veiw.add(jLabel54);
        jLabel54.setBounds(334, 332, 100, 25);

        jLabel55.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel55.setText("Net Premium  :");
        veiw.add(jLabel55);
        jLabel55.setBounds(602, 357, 120, 30);

        jLabel56.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel56.setText("Service tax (12%)  :");
        veiw.add(jLabel56);
        jLabel56.setBounds(602, 383, 120, 40);

        jLabel57.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel57.setText("Total Premium  :");
        veiw.add(jLabel57);
        jLabel57.setBounds(602, 423, 120, 30);

        pno.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        pno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pno.setText("qqqq");
        veiw.add(pno);
        pno.setBounds(205, 62, 200, 24);

        ga.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        ga.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ga.setText("qqq");
        veiw.add(ga);
        ga.setBounds(209, 91, 170, 25);

        name.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        name.setText("Insured Name  :");
        veiw.add(name);
        name.setBounds(210, 120, 210, 27);

        prof.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        prof.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        prof.setText("Profession  :");
        veiw.add(prof);
        prof.setBounds(210, 150, 180, 26);

        address.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        address.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        address.setText("Insured Address  :");
        veiw.add(address);
        address.setBounds(210, 180, 460, 25);

        rgno.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        rgno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rgno.setText("Registartion Number  :");
        veiw.add(rgno);
        rgno.setBounds(185, 302, 170, 23);

        rgdate.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        rgdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rgdate.setText("Registartion Date  :");
        veiw.add(rgdate);
        rgdate.setBounds(185, 329, 170, 33);

        egnno.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        egnno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        egnno.setText("Engine Number  :");
        veiw.add(egnno);
        egnno.setBounds(187, 363, 140, 30);

        chano.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        chano.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chano.setText("Chassis Number  :");
        veiw.add(chano);
        chano.setBounds(187, 393, 140, 30);

        make1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        make1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        make1.setText("Make  :");
        veiw.add(make1);
        make1.setBounds(187, 422, 140, 40);

        model1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        model1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        model1.setText("Model  :");
        veiw.add(model1);
        model1.setBounds(187, 455, 140, 40);

        ym.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        ym.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ym.setText("Year of Manufacture  :");
        veiw.add(ym);
        ym.setBounds(448, 301, 150, 28);

        cubic.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        cubic.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cubic.setText("Cubic Capacity  :");
        veiw.add(cubic);
        cubic.setBounds(449, 332, 150, 25);

        net.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        net.setForeground(new java.awt.Color(255, 0, 51));
        net.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        net.setText("Net Premium  :");
        veiw.add(net);
        net.setBounds(732, 357, 160, 30);

        stax.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        stax.setForeground(new java.awt.Color(255, 0, 0));
        stax.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        stax.setText("Service tax (12%)  :");
        veiw.add(stax);
        stax.setBounds(732, 383, 160, 40);

        tpre.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        tpre.setForeground(new java.awt.Color(255, 0, 0));
        tpre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tpre.setText("Total Premium  :");
        veiw.add(tpre);
        tpre.setBounds(732, 423, 160, 30);

        isdate.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        isdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        isdate.setText("Insurance Start Date  :");
        veiw.add(isdate);
        isdate.setBounds(555, 72, 130, 24);

        iedate.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        iedate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        iedate.setText("Insurance Expiry Date  :");
        veiw.add(iedate);
        iedate.setBounds(556, 102, 140, 24);

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/print.png"))); // NOI18N
        jLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel63MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel63MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel63MouseExited(evt);
            }
        });
        veiw.add(jLabel63);
        jLabel63.setBounds(660, 200, 120, 30);

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        jLabel64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel64MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel64MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel64MouseExited(evt);
            }
        });
        veiw.add(jLabel64);
        jLabel64.setBounds(800, 200, 120, 30);
        veiw.add(jSeparator2);
        jSeparator2.setBounds(20, 228, 560, 20);

        pback3.setLayout(new javax.swing.OverlayLayout(pback3));

        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/pbgrng.png"))); // NOI18N
        pback3.add(jLabel66);

        veiw.add(pback3);
        pback3.setBounds(0, 0, 987, 554);

        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view2.png"))); // NOI18N
        jLabel92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel92MouseClicked(evt);
            }
        });
        policyOp.add(jLabel92);
        jLabel92.setBounds(94, -10, 70, 60);

        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/renew1.png"))); // NOI18N
        jLabel93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel93MouseClicked(evt);
            }
        });
        policyOp.add(jLabel93);
        jLabel93.setBounds(164, -10, 70, 60);

        custTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "customer id", "Policy No", "Policy Type", "Start Date", "End Date", "Insured name", "Vehicle Resistartion No", "Policy Status"
            }
        ));
        jScrollPane4.setViewportView(custTable);

        custUpdate.add(jScrollPane4);
        jScrollPane4.setBounds(20, 152, 940, 350);
        jScrollPane4.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane4.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        jLabel69.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel69.setText("Enter Cust Id  :");
        custUpdate.add(jLabel69);
        jLabel69.setBounds(80, 90, 80, 20);

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        custUpdate.add(jTextField1);
        jTextField1.setBounds(160, 90, 150, 20);

        jLabel70.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel70.setText("Total No of Customers  :");
        custUpdate.add(jLabel70);
        jLabel70.setBounds(560, 90, 120, 20);

        total.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        total.setText("Total No of Customers  :");
        custUpdate.add(total);
        total.setBounds(690, 90, 150, 20);

        jLabel94.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel94.setText("Active Policies");
        policy.add(jLabel94);
        jLabel94.setBounds(428, 78, 190, 40);

        expired.setBackground(new java.awt.Color(204, 204, 204));
        expired.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Policy No", "Customer Id", "Policy Type", "Insured Name", "Vehicle Reg No", "Start Date", "End Date", "Policy Amount"
            }
        ));
        jScrollPane5.setViewportView(expired);

        policy.add(jScrollPane5);
        jScrollPane5.setBounds(20, 360, 940, 160);
        jScrollPane5.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane5.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        jLabel95.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel95.setText("Expired Policies");
        policy.add(jLabel95);
        jLabel95.setBounds(428, 308, 100, 30);

        active.setBackground(new java.awt.Color(204, 204, 204));
        active.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Policy No", "Customer Id", "Policy Type", "Insured Name", "Vehicle Reg No", "Start Date", "End Date", "Policy Amount"
            }
        ));
        jScrollPane7.setViewportView(active);

        policy.add(jScrollPane7);
        jScrollPane7.setBounds(22, 132, 940, 160);
        jScrollPane7.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane7.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        jLabel96.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel96.setText("Enter Policy No  :");
        policyRenew.add(jLabel96);
        jLabel96.setBounds(108, 158, 90, 30);

        policyNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        policyNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                policyNoActionPerformed(evt);
            }
        });
        policyRenew.add(policyNo);
        policyNo.setBounds(210, 160, 170, 20);

        jLabel97.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel97.setText("Customer Id  :");
        policyRenew.add(jLabel97);
        jLabel97.setBounds(98, 208, 100, 20);

        custid3.setEditable(false);
        custid3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        policyRenew.add(custid3);
        custid3.setBounds(210, 210, 170, 20);

        custName.setEditable(false);
        custName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        policyRenew.add(custName);
        custName.setBounds(210, 250, 170, 20);

        jLabel98.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel98.setText("Customer Name  :");
        policyRenew.add(jLabel98);
        jLabel98.setBounds(98, 248, 100, 20);

        jLabel99.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel99.setText("Customer Address  :");
        policyRenew.add(jLabel99);
        jLabel99.setBounds(98, 298, 100, 20);

        custAdress.setEditable(false);
        custAdress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        policyRenew.add(custAdress);
        custAdress.setBounds(210, 300, 280, 20);

        occupation.setEditable(false);
        occupation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        policyRenew.add(occupation);
        occupation.setBounds(210, 340, 170, 20);

        jLabel100.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel100.setText("Occupation  :");
        policyRenew.add(jLabel100);
        jLabel100.setBounds(98, 338, 100, 20);

        jLabel101.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel101.setText("Phone No  :");
        policyRenew.add(jLabel101);
        jLabel101.setBounds(98, 378, 100, 20);

        phone.setEditable(false);
        phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        policyRenew.add(phone);
        phone.setBounds(210, 380, 170, 20);

        jLabel102.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel102.setText("Type of Policy  : ");
        policyRenew.add(jLabel102);
        jLabel102.setBounds(478, 158, 90, 30);

        start.setEditable(false);
        start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        policyRenew.add(start);
        start.setBounds(580, 210, 170, 20);

        jLabel103.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel103.setText("Start Date  :");
        policyRenew.add(jLabel103);
        jLabel103.setBounds(468, 208, 100, 20);

        end.setEditable(false);
        end.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        policyRenew.add(end);
        end.setBounds(580, 250, 170, 20);

        jLabel104.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel104.setText("End Date  :");
        policyRenew.add(jLabel104);
        jLabel104.setBounds(468, 248, 100, 20);

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Liability Only", "Package Policy" }));
        policyRenew.add(type);
        type.setBounds(580, 160, 170, 20);

        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/renew.png"))); // NOI18N
        jLabel105.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel105MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel105MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel105MouseExited(evt);
            }
        });
        policyRenew.add(jLabel105);
        jLabel105.setBounds(540, 340, 120, 30);

        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        jLabel106.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel106MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel106MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel106MouseExited(evt);
            }
        });
        policyRenew.add(jLabel106);
        jLabel106.setBounds(690, 340, 120, 30);

        vreg.setEditable(false);
        vreg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        policyRenew.add(vreg);
        vreg.setBounds(210, 420, 170, 20);

        jLabel107.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel107.setText("Vehicle Reg No  :");
        policyRenew.add(jLabel107);
        jLabel107.setBounds(98, 418, 100, 20);

        jLabel113.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel113.setText("Cust Id");
        custView.add(jLabel113);
        jLabel113.setBounds(90, 120, 80, 20);

        jLabel115.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel115.setText("First Name");
        custView.add(jLabel115);
        jLabel115.setBounds(90, 160, 80, 20);

        mdl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        custView.add(mdl);
        mdl.setBounds(640, 400, 170, 20);

        jLabel116.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel116.setText("Last Name");
        custView.add(jLabel116);
        jLabel116.setBounds(110, 200, 60, 20);

        namel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        custView.add(namel);
        namel.setBounds(190, 200, 170, 20);

        jLabel117.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel117.setText("Date Of Birth");
        custView.add(jLabel117);
        jLabel117.setBounds(80, 240, 90, 20);

        dob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        custView.add(dob);
        dob.setBounds(190, 240, 170, 20);

        paddress.setColumns(20);
        paddress.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        paddress.setRows(5);
        paddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jScrollPane6.setViewportView(paddress);

        custView.add(jScrollPane6);
        jScrollPane6.setBounds(190, 400, 170, 100);
        jScrollPane2.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane2.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        jLabel120.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel120.setText("Permenant Address");
        custView.add(jLabel120);
        jLabel120.setBounds(70, 390, 120, 30);

        jLabel121.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel121.setText("Phone no");
        custView.add(jLabel121);
        jLabel121.setBounds(130, 280, 80, 30);

        mailid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        mailid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mailidKeyTyped(evt);
            }
        });
        custView.add(mailid);
        mailid.setBounds(190, 360, 170, 20);

        jLabel122.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel122.setText("Telephone");
        custView.add(jLabel122);
        jLabel122.setBounds(120, 320, 80, 20);

        phnt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        phnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phntActionPerformed(evt);
            }
        });
        phnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phntKeyTyped(evt);
            }
        });
        custView.add(phnt);
        phnt.setBounds(190, 320, 170, 20);

        jLabel123.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel123.setText("Vehicle Details");
        custView.add(jLabel123);
        jLabel123.setBounds(590, 80, 160, 20);

        phnm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        custView.add(phnm);
        phnm.setBounds(190, 280, 170, 20);

        namef.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        custView.add(namef);
        namef.setBounds(190, 160, 170, 20);

        jLabel124.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel124.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel124.setText("Email ID");
        custView.add(jLabel124);
        jLabel124.setBounds(120, 360, 80, 20);

        jLabel125.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel125.setText("Customer Details");
        custView.add(jLabel125);
        jLabel125.setBounds(150, 70, 160, 20);

        jLabel118.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel118.setText("Type of Vehicle");
        custView.add(jLabel118);
        jLabel118.setBounds(550, 200, 120, 20);

        jLabel119.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel119.setText("Vehicles Regn. No.");
        custView.add(jLabel119);
        jLabel119.setBounds(530, 120, 130, 20);

        jLabel126.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel126.setText("Cubic Capacity");
        custView.add(jLabel126);
        jLabel126.setBounds(550, 240, 90, 20);

        jLabel127.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel127.setText("Engine No");
        custView.add(jLabel127);
        jLabel127.setBounds(570, 280, 100, 20);

        jLabel128.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel128.setText("Chassis No");
        custView.add(jLabel128);
        jLabel128.setBounds(560, 320, 100, 20);

        jLabel129.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel129.setText("Make");
        custView.add(jLabel129);
        jLabel129.setBounds(590, 360, 110, 20);

        jLabel130.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel130.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel130.setText("Model");
        custView.add(jLabel130);
        jLabel130.setBounds(590, 400, 110, 20);

        jLabel131.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel131.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel131.setText("Registration Date");
        custView.add(jLabel131);
        jLabel131.setBounds(540, 160, 140, 20);

        cid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        custView.add(cid);
        cid.setBounds(190, 120, 170, 20);

        vregno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        custView.add(vregno);
        vregno.setBounds(640, 120, 170, 20);

        rdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        custView.add(rdate);
        rdate.setBounds(640, 160, 170, 20);

        vtype.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        custView.add(vtype);
        vtype.setBounds(640, 200, 170, 20);

        vcc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        custView.add(vcc);
        vcc.setBounds(640, 240, 170, 20);

        engno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        custView.add(engno);
        engno.setBounds(640, 280, 170, 20);

        chasisno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        custView.add(chasisno);
        chasisno.setBounds(640, 320, 170, 20);

        mke.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        custView.add(mke);
        mke.setBounds(640, 360, 170, 20);

        jLabel132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        jLabel132.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel132emptyFields(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel132MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel132MouseExited(evt);
            }
        });
        custView.add(jLabel132);
        jLabel132.setBounds(660, 460, 120, 34);

        page.setLayer(custOp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        page.setLayer(vehicle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        page.setLayer(customer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        page.setLayer(pcalc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        page.setLayer(pback, javax.swing.JLayeredPane.DEFAULT_LAYER);
        page.setLayer(veiw, javax.swing.JLayeredPane.DEFAULT_LAYER);
        page.setLayer(policyOp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        page.setLayer(custUpdate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        page.setLayer(policy, javax.swing.JLayeredPane.DEFAULT_LAYER);
        page.setLayer(policyRenew, javax.swing.JLayeredPane.DEFAULT_LAYER);
        page.setLayer(custView, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pageLayout = new javax.swing.GroupLayout(page);
        page.setLayout(pageLayout);
        pageLayout.setHorizontalGroup(
            pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pback))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(pcalc)
                    .addContainerGap()))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(customer)
                    .addContainerGap()))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(vehicle)
                    .addContainerGap()))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(veiw)
                    .addContainerGap()))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pageLayout.createSequentialGroup()
                    .addContainerGap(583, Short.MAX_VALUE)
                    .addComponent(custOp, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(custUpdate)
                    .addContainerGap()))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(policy)
                    .addContainerGap()))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pageLayout.createSequentialGroup()
                    .addContainerGap(579, Short.MAX_VALUE)
                    .addComponent(policyOp, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(policyRenew)
                    .addContainerGap()))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(custView)
                    .addContainerGap()))
        );
        pageLayout.setVerticalGroup(
            pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pback))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(pcalc)
                    .addContainerGap()))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(customer)
                    .addContainerGap()))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(vehicle)
                    .addContainerGap()))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(veiw)
                    .addContainerGap()))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(custOp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 513, Short.MAX_VALUE)))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(custUpdate)
                    .addContainerGap()))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(policy)
                    .addContainerGap()))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(policyOp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 512, Short.MAX_VALUE)))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(policyRenew)
                    .addContainerGap()))
            .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pageLayout.createSequentialGroup()
                    .addComponent(custView)
                    .addContainerGap()))
        );

        jLabel114.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel114.setText("About US");

        ffffabout.setColumns(20);
        ffffabout.setLineWrap(true);
        ffffabout.setRows(5);
        ffffabout.setText(" write someting here about this applicatin");
        ffffabout.setWrapStyleWord(true);
        ffffabout.setOpaque(false);
        ffffabout.setRequestFocusEnabled(false);

        about.setLayer(jLabel114, javax.swing.JLayeredPane.DEFAULT_LAYER);
        about.setLayer(ffffabout, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout aboutLayout = new javax.swing.GroupLayout(about);
        about.setLayout(aboutLayout);
        aboutLayout.setHorizontalGroup(
            aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 974, Short.MAX_VALUE)
            .addGroup(aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                    .addContainerGap(69, Short.MAX_VALUE)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(728, Short.MAX_VALUE)))
            .addGroup(aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                    .addContainerGap(62, Short.MAX_VALUE)
                    .addComponent(ffffabout, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(59, Short.MAX_VALUE)))
        );
        aboutLayout.setVerticalGroup(
            aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
            .addGroup(aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                    .addContainerGap(29, Short.MAX_VALUE)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(463, Short.MAX_VALUE)))
            .addGroup(aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                    .addContainerGap(91, Short.MAX_VALUE)
                    .addComponent(ffffabout, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );

        main2.setLayer(log, javax.swing.JLayeredPane.DEFAULT_LAYER);
        main2.setLayer(change, javax.swing.JLayeredPane.DEFAULT_LAYER);
        main2.setLayer(home, javax.swing.JLayeredPane.DEFAULT_LAYER);
        main2.setLayer(sbar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        main2.setLayer(page, javax.swing.JLayeredPane.DEFAULT_LAYER);
        main2.setLayer(about, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout main2Layout = new javax.swing.GroupLayout(main2);
        main2.setLayout(main2Layout);
        main2Layout.setHorizontalGroup(
            main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1360, Short.MAX_VALUE)
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(main2Layout.createSequentialGroup()
                    .addComponent(sbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1096, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(297, Short.MAX_VALUE)
                    .addComponent(page, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(84, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(296, Short.MAX_VALUE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(83, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(236, Short.MAX_VALUE)
                    .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(945, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(544, Short.MAX_VALUE)
                    .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(405, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(main2Layout.createSequentialGroup()
                    .addGap(299, 299, 299)
                    .addComponent(about, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(87, Short.MAX_VALUE)))
        );
        main2Layout.setVerticalGroup(
            main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(main2Layout.createSequentialGroup()
                    .addGap(186, 186, 186)
                    .addComponent(sbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(170, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(112, Short.MAX_VALUE)
                    .addComponent(page, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(44, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(112, Short.MAX_VALUE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(396, Short.MAX_VALUE)
                    .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(195, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(227, Short.MAX_VALUE)
                    .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(207, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(main2Layout.createSequentialGroup()
                    .addGap(113, 113, 113)
                    .addComponent(about, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(46, Short.MAX_VALUE)))
        );

        main1.setPreferredSize(new java.awt.Dimension(1360, 700));

        bgrnd.setLayout(new javax.swing.OverlayLayout(bgrnd));

        dspDate.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        dspDate.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane3.add(dspDate);
        dspDate.setBounds(1030, 70, 120, 20);

        dspTime.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        dspTime.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane3.add(dspTime);
        dspTime.setBounds(1170, 70, 100, 20);

        label.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        label.setForeground(new java.awt.Color(51, 51, 51));
        jLayeredPane3.add(label);
        label.setBounds(390, 60, 190, 40);

        jLabel65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel65jLabel2MouseClicked(evt);
            }
        });
        jLayeredPane3.add(jLabel65);
        jLabel65.setBounds(310, 60, 60, 40);

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/brrr.png"))); // NOI18N
        jLayeredPane3.add(jLabel60);
        jLabel60.setBounds(299, 60, 980, 40);

        bgrnd.add(jLayeredPane3);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bgrng1.jpg"))); // NOI18N
        bgrnd.add(jLabel1);

        main1.setLayer(bgrnd, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout main1Layout = new javax.swing.GroupLayout(main1);
        main1.setLayout(main1Layout);
        main1Layout.setHorizontalGroup(
            main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1360, Short.MAX_VALUE)
            .addGroup(main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bgrnd, javax.swing.GroupLayout.DEFAULT_SIZE, 2566, Short.MAX_VALUE))
        );
        main1Layout.setVerticalGroup(
            main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bgrnd, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE))
        );

        main.setLayer(main2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        main.setLayer(main1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1360, Short.MAX_VALUE)
            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainLayout.createSequentialGroup()
                    .addComponent(main1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(main2))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainLayout.createSequentialGroup()
                    .addComponent(main1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(main2))
        );

        jDesktopPane1.add(main);

        jScrollPane1.setViewportView(jDesktopPane1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Boolean homeClicked=true,pcalcClicked=false,custClicked=false,policyClicked=false,loginClicked=false,aboutClicked=false;
    public void bClicked(String click)
    {
    if(click=="home")
    {
      homeClicked=true;
      pcalcClicked=false;
      custClicked=false;
      policyClicked=false;
      loginClicked=false;
      aboutClicked=false;
      jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/home3.png")));
      jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/pCalc1.png")));
      jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/cust1.png")));
      jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy1.png")));
      jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg1.png")));
      jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
      //jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
    }
    if(click=="pcalc")
    {
      homeClicked=false;
      pcalcClicked=true;
      custClicked=false;
      policyClicked=false;
      loginClicked=false;
      aboutClicked=false;
      jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/pCalc3.png")));
      jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/home1.png")));
      jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/cust1.png")));
      jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy1.png")));
      jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg1.png")));
      jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
      //jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
    }
    if(click=="cust")
    {
      homeClicked=false;
      pcalcClicked=false;
     custClicked=true;
      policyClicked=false;
      loginClicked=false;
      aboutClicked=false;
      jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/cust3.png")));
      jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/pCalc1.png")));
      jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/home1.png")));
      jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy1.png")));
      jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg1.png")));
      jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
      //jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
    }
    if(click=="policy")
    {
      homeClicked=false;
      pcalcClicked=false;
     custClicked=false;
      policyClicked=true;
      loginClicked=false;
      aboutClicked=false;
      jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/cust1.png")));
      jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/pCalc1.png")));
      jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/home1.png")));
      jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy3.png")));
      jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg1.png")));
      jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
      //jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
    }
     if(click=="login")
    {
      homeClicked=false;
      pcalcClicked=false;
     custClicked=false;
      policyClicked=false;
      loginClicked=true;
      aboutClicked=false;
      jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/cust1.png")));
      jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/pCalc1.png")));
      jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/home1.png")));
      jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy1.png")));
      jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg3.png")));
      jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
      //jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));"about"
    }
     if(click=="about")
    {
      homeClicked=false;
      pcalcClicked=false;
     custClicked=false;
      policyClicked=false;
      loginClicked=false;
      aboutClicked=true;
      jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/cust1.png")));
      jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/pCalc1.png")));
      jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/home1.png")));
      jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy1.png")));
      jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg1.png")));
      jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts3.png")));
      //jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
    }
    
    }
    
    
    private void jLabel65jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel65jLabel2MouseClicked
        // TODO add your handling code here:
        //        homeClicked=true;
        //        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home3.png")));
//        bClicked("home");
//        label.setText("");
//        layerRemoveAll(main2);
//        layerAdd(main2,sbar);
//        layerAdd(main2,home);

    }//GEN-LAST:event_jLabel65jLabel2MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        //        homeClicked=true;
        //        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home3.png")));
       bClicked("home");
        label.setText("");
        layerRemoveAll(main2);
        layerAdd(main2,sbar);
        layerAdd(main2,home);
        System.err.println(cUserId);
        page.setVisible(true);

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        if(homeClicked==false)
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/home2.png")));
       
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        if(homeClicked==false)
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/home1.png")));
    }//GEN-LAST:event_jLabel2MouseExited

    private void tvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvActionPerformed
        // TODO add your handling code here:
        if(tv.getSelectedItem()=="Private Cars")
        {
            cc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "upto 1000","1000-1500","above 1500" }));

        }
        if(tv.getSelectedItem()=="Two Wheelers")
        {
            cc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "upto 75","75-150","150-350","above 350" }));

        }
        if(tv.getSelectedItem()=="Goods Carrying Vehicles")
        {
            cc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "upto 7500","7500-12000","12000-20000","20000-40000","above 40000" }));

        }
        if(tv.getSelectedItem()=="Vhcls for Hire(upto 6 Pass)")
        {
            cc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "upto 1000","1000-1500","above 1500" }));

        }
        if(tv.getSelectedItem()=="Vhcls for Hire(above 6 Pass)")
        {
            cc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "upto 18","19-36","36-60","above 60" }));

        }
        if(tv.getSelectedItem()=="3 WHR PASS carriying")
        {
            cc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "not needed" }));

        }
        
        //av.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "upto 5","5-10","above 10" }));

//        if(tv.getSelectedItem()=="Private Cars"||tv.getSelectedItem()=="Two Wheelers"||tv.getSelectedItem()=="Goods Carrying Vehicles")
//        {
//            av.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "upto 5","5-10","above 10" }));
//        }
//        if(tv.getSelectedItem()=="Vhcls for Hire(upto 6 Pass)"||tv.getSelectedItem()=="Vhcls for Hire(above 6 Pass)"||tv.getSelectedItem()=="3 WHR PASS carriying")
//        {
//            av.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "upto 5","5-10","above 10" }));
//        }
    }//GEN-LAST:event_tvActionPerformed

    private void tvavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvavActionPerformed
       
    }//GEN-LAST:event_tvavActionPerformed

    private void ccavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccavActionPerformed
        // TODO add your handling code here:
        
        //System.err.println(type);
    }//GEN-LAST:event_ccavActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        bClicked("pcalc");
        label.setText("Premium Calculator");
        layerRemoveAll(page);
        layerRemoveAll(main2);
        layerAdd(main2,sbar);
        layerAdd(main2,page);
      
        
        //layerRemoveAll(pcalc);
        
        layerAdd(page,pcalc);
        layerAdd(page,pback);
        page.setVisible(true);
        
//        try {
            //        layerAdd(staff,staffOp);
//        layerAdd(staff,staffAdd);
//printCust();
//        } catch (IOException ex) {
//            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
        if(pcalcClicked==false)
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/pCalc2.png")));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        if(pcalcClicked==false)
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/pCalc1.png")));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        bClicked("cust");
        label.setText("Customer");
        layerRemoveAll(page);
        layerRemoveAll(main2);
        layerAdd(main2,sbar);
        layerAdd(main2,page);
      
        
        //layerRemoveAll(pcalc);
        layerAdd(page,custOp);
        layerAdd(page,customer);
        layerAdd(page,pback);
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add2.png")));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view1.png")));
        setRandom(custid);
        page.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        if(custClicked==false)
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/cust2.png")));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        if(custClicked==false)
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/cust1.png")));
    }//GEN-LAST:event_jLabel4MouseExited

    private void tpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        nxtClicked();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        // TODO add your handling code here:
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        // TODO add your handling code here:
        jLabel7.setBorder(null);
    }//GEN-LAST:event_jLabel7MouseExited

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected()==true)
        {
            cadd.setText(padd.getText());
        }
        if(jCheckBox1.isSelected()==false)
        {
            cadd.setText("");
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    Boolean fieldCheck()
    {
        Boolean check=false;
         ErrorNotification en=new ErrorNotification();
        String dob="";
        String sdate="";
        String sex="";
        String enddate="";
        int excptn=1;
        
        try
        {
            dob=sdf.format(dob1.getDate());
            Calendar fdob= Calendar.getInstance();
            fdob=Calendar.getInstance();
            fdob.add(Calendar.YEAR,-18); 
            
            if(male.isSelected()==true)
            {
                sex="M";
            }
            if(female.isSelected()==true)
            {
                sex="F";
            }
        
             if(custid.getText().length()>10)
             {
                 en.setErrorForTextField("invalid empoyee id",custid,this,page,3000,0); 
                  return check;
             }
             if(fname.getText().length()>15||fname.getText().length()<=2)
             {
                 en.setErrorForTextField("invalid value",fname,this,page,3000,0);   
                  return check;
             }
             if(lname.getText().length()>15||lname.getText().length()<2)
             {
                 en.setErrorForTextField("invalid value",lname,this,page,3000,0);
                  return check;
             }
              if(fdob.getTime().before(dob1.getDate()))
                {
                    en.setErrorForTextField("invalid date of birth",lname,this,page,3000,50);
                        return check;
                 }
              
              
              String eMailVa
                        = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                String eMaiL = eid.getText();
             if(!eMaiL.matches(eMailVa))
             {
                  en.setErrorForTextField("invalid email id",eid,this,page,3000,0);
                   return check;
             }
              
              
              
               if(mphn.getText().length()>10||mphn.getText().length()<10)
             {
                 en.setErrorForTextField("invalid phone no",mphn,this,page,3000,0);
                  return check;
             }
             if(lphn.getText().length()>10||lphn.getText().length()<7)
             {
                 en.setErrorForTextField("invalid phone no",lphn,this,page,3000,0); 
                  return check;
             }
             if(occu.getText().length()>30||occu.getText().length()<=4)
             {
                 en.setErrorForTextField("invalid value",occu,this,page,3000,0);
                  return check;
             }
             if(nat.getText().length()>20||nat.getText().length()<=3)
             {
                 en.setErrorForTextField("invalid value",nat,this,page,3000,0);
                  return check;
             }
             
            if(fxno.getText().length()>15||fxno.getText().length()<=4)
             {
                 en.setErrorForTextField("invalid value",fxno,this,page,3000,0);
                  return check;
             } 
             if(panno.getText().length()>15||panno.getText().length()<=2)
             {
                 en.setErrorForTextField("invalid value",panno,this,page,3000,0);
                  return check;
             }
        
        }
        catch(NullPointerException np)
        {
            System.out.println(np);
            if(dob1.getDate()==null)
            {
                 en.setErrorForTextField("invalid date of birth",lname,this,page,3000,40);
                 return check;
            }
        }
      check=true;
             return check;
    }
    
    private void jLabel58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseClicked
        // TODO add your handling code here:
       
        if(fieldCheck())
        {
            layerRemoveAll(page);
            layerAdd(page,custOp);
            layerAdd(page,vehicle);
            layerAdd(page,pback);
        }
        //submittButton();
       // y_fol_lonh=10;
       // addEmployeeToTheEmployeeShown();
        // qual.addItem("we");
        //System.out.print("dfdgdxsdg");

    }//GEN-LAST:event_jLabel58MouseClicked

    private void jLabel58MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseEntered
        // TODO add your handling code here:
        jLabel58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel58MouseEntered

    private void jLabel58MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseExited
        // TODO add your handling code here:
        jLabel58.setBorder(null);
    }//GEN-LAST:event_jLabel58MouseExited

    private void jLabel59emptyFields(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59emptyFields
        // TODO add your handling code here:
        //emptyFields();
        clearAll();
        setRandom(custid);
    }//GEN-LAST:event_jLabel59emptyFields

    private void jLabel59MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseEntered
        // TODO add your handling code here:
        jLabel59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel59MouseEntered

    private void jLabel59MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseExited
        // TODO add your handling code here:
        jLabel59.setBorder(null);
    }//GEN-LAST:event_jLabel59MouseExited

    private void tv2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tv2ActionPerformed
        // TODO add your handling code here:
        if(tv2.getSelectedItem()=="Private Cars")
        {
            cc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "upto 1000","1000-1500","above 1500" }));

        }
        if(tv2.getSelectedItem()=="Two Wheelers")
        {
            cc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "upto 75","75-150","150-350","above 350" }));

        }
        if(tv2.getSelectedItem()=="Goods Carrying Vehicles")
        {
            cc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "upto 7500","7500-12000","12000-20000","20000-40000","above 40000" }));

        }
        if(tv2.getSelectedItem()=="Vhcls for Hire(upto 6 Pass)")
        {
            cc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "below 1000","1000-1500","above 1500" }));

        }
        if(tv2.getSelectedItem()=="Vhcls for Hire(above 6 Pass)")
        {
            cc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "upto 18","19-36","36-60","above 60" }));

        }
        if(tv2.getSelectedItem()=="3 WHR PASS carriying")
        {
            cc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "not needed" }));

        }
        
        
    }//GEN-LAST:event_tv2ActionPerformed

    private void tv2avActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tv2avActionPerformed
        // TODO add your handling code here:

        //System.err.println(type);
    }//GEN-LAST:event_tv2avActionPerformed

    private void cc2avActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cc2avActionPerformed
        // TODO add your handling code here:
        //System.err.println(type);
    }//GEN-LAST:event_cc2avActionPerformed

    
    Boolean feildCheck2()
    {
        ErrorNotification en=new ErrorNotification();
        Boolean checker=false;
//            String date;
//            date=sdf.format(dop.getDate());
//            Calendar fdob= Calendar.getInstance();
//            fdob=Calendar.getInstance();
//            fdob.add(Calendar.YEAR,-18); 
       
        try
        {
            if(regno.getText().length()<10||regno.getText().length()>15)
            {
                en.setErrorForTextField("invalid Registration No",regno,this,page,3000,0); 
                  return checker;
            }
             if(egno.getText().length()<10||egno.getText().length()>20)
            {
                en.setErrorForTextField("invalid Engine no",egno,this,page,3000,0); 
                  return checker;
            }
             if(chno.getText().length()<10||chno.getText().length()>20)
            {
                en.setErrorForTextField("invalid Chassis no",chno,this,page,3000,0); 
                  return checker;
            }
              if(color.getText().length()<3||color.getText().length()>10)
            {
                en.setErrorForTextField("invalid value",color,this,page,3000,0); 
                  return checker;
            }
                if(make.getText().length()<3||make.getText().length()>20)
            {
                en.setErrorForTextField("invalid value",make,this,page,3000,0); 
                  return checker;
            }
              if(model.getText().length()<3||model.getText().length()>20)
            {
                en.setErrorForTextField("invalid value",model,this,page,3000,0); 
                  return checker;
            }   
                if(tfuel.getText().length()<4||tfuel.getText().length()>11)
            {
                en.setErrorForTextField("invalid value",tfuel,this,page,3000,0); 
                  return checker;
            }
        }
        catch(NullPointerException np)
        {
            System.out.println(np);
            if(dop.getDate()==null)
            {
                 en.setErrorForTextField("invalid date of birth",color,this,page,3000,-50);
                 return checker;
            }
        }
        
        
        checker=true;
        return checker;
    }
    
    void clearAll()
    {
        java.util.List<Component> comps = getAllComponents(this) ;

        for (Component C : comps) {

          if ((C instanceof JTextField )|| C instanceof JTextArea){
                   // System.err.println("in--------- inside");

                    ((JTextComponent) C).setText(""); //abstract superclass
                     
                }

        }
    }
    
    
    
    private void jLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseClicked
        // TODO add your handling code here:
        
        if(feildCheck2())
        {
            
            if(JOptionPane.showConfirmDialog(this,"Add customer Deatils")==0)
            {
                int number=0;
                int age=year.getValue();
                 String query="";
                 String query2="";
                 String query3="";
                 String query4="";
                 String sdate="";
                 String edate="";
                 String t_no="";
                 String query6="";
                try
                {
                  
                    Calendar fdob= Calendar.getInstance();
                    //fdob.setTime(dob1.getDate());
                    sdate=sdf.format(fdob.getTime());
                    fdob.add(Calendar.YEAR,1);
                    edate=sdf.format(fdob.getTime());
                    
                    
                    String sex="M";
                    String date,date2;
                    date=sdf.format(dob1.getDate());
                    date2=sdf.format(dop.getDate());
                    if(male.isSelected()==true)
                        {
                            sex="M";
                        }
                        if(female.isSelected()==true)
                        {
                            sex="F";
                        }
                    
                    
                    
                    Database db=new Database();
                    db.jdbcConnect();
                    query  = "INSERT INTO customer"
                        + " VALUES('" + custid.getText() + "','" + fname.getText() + "','" +lname.getText()
                        +"','"+sex+"','"+occu.getText() + "','" +date + "','"+nat.getText()+ "','"+mphn.getText()+ "','"+lphn.getText()
                        + "','"+eid.getText()+ "','"+fxno.getText()+ "','"+panno.getText()+ "','"+cadd.getText()+ "','"+padd.getText()+"','"+cUserId+"')";

                    System.out.println(query);
                    db.p=db.conn.prepareStatement(query);
                    int rs = db.p.executeUpdate();
                    
                    query2="INSERT INTO vehicle"
                        + " VALUES('" + custid.getText() + "','"+regno.getText()+"','"+date2+"','"+(String) tv2.getSelectedItem()+"','"+(String) cc2.getSelectedItem()
                        +"',"+String.valueOf(age)+",'"+color.getText()+"','"+egno.getText()+"','"+chno.getText()+"','"+make.getText()+"','"
                        +model.getText()+"','"+tfuel.getText()+"',"+price.getText()+")"; 
                    
                    System.out.println(query2);
                    db.p=db.conn.prepareStatement(query2);
                    int rs2 = db.p.executeUpdate();
                    
                    query3="select count(*) from policy";
                    db.p=db.conn.prepareStatement(query3);
                    db.rs=db.p.executeQuery(query3);
                    
                    while(db.rs.next())
                    {
                        
                        number=db.rs.getInt("count(*)")+1;
                        //System.err.println(number);
                    }  
                    query6="Select * from tarif where cc='"+cc2.getSelectedItem()+"' and tv='"+tv2.getSelectedItem()+"'";
                    db.p=db.conn.prepareStatement(query6);
                    db.rs=db.p.executeQuery(query6);
                    
                    while(db.rs.next())
                    {
                        
                        t_no=db.rs.getString("tarif_id");
                        //System.err.println(number);
                    }
                    
                    
                    query4="INSERT INTO policy"
                        + " VALUES("+number+",'"+t_no+"','"+custid.getText() + "','" +regno.getText()+"','"+(String) tp2.getSelectedItem()
                        +"',"+policyCalc((String) cc2.getSelectedItem(),(String) tv2.getSelectedItem(),age,(String) tp2.getSelectedItem(),Integer.parseInt(price.getText()))
                        +",'"+sdate+"','"+edate+"','Active')"; 
                    System.out.println(query4);
                    db.p=db.conn.prepareStatement(query4);
                    int rs5 = db.p.executeUpdate();
                    
                    JOptionPane.showMessageDialog(this, new String("successfully added"));
                    //excptn=0;

                    db.p.close();
                    db.conn.close();

                    //db.close();
                    custFrom=1;
                    cView(custid.getText());
                    
                    layerRemoveAll(page);
                    layerAdd(page,custOp);
                    layerAdd(page,veiw);
                    layerAdd(page,pback);
                    clearAll();
                     setRandom(custid);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, new String("Error occured"));
                   // excptn=1;
                    
                }
            }
        }
        // qual.addItem("we");
        //System.out.print("dfdgdxsdg");

    }//GEN-LAST:event_jLabel61MouseClicked

    private void jLabel61MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseEntered
        // TODO add your handling code here:
        jLabel61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel61MouseEntered

    private void jLabel61MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseExited
        // TODO add your handling code here:
        jLabel61.setBorder(null);
    }//GEN-LAST:event_jLabel61MouseExited

    private void jLabel62emptyFields(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel62emptyFields
        // TODO add your handling code here:
                layerRemoveAll(page);
                layerAdd(page,custOp);
        layerAdd(page,customer);
        layerAdd(page,pback);
    }//GEN-LAST:event_jLabel62emptyFields

    private void jLabel62MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel62MouseEntered
        // TODO add your handling code here:
        jLabel62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel62MouseEntered

    private void jLabel62MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel62MouseExited
        // TODO add your handling code here:
        jLabel62.setBorder(null);
    }//GEN-LAST:event_jLabel62MouseExited

    private void tp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tp2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tp2ActionPerformed

    private void mphnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mphnKeyTyped
        // TODO add your handling code here:
        char enter=evt.getKeyChar();
        if(!(Character.isDigit(enter)))
            evt.consume();
    }//GEN-LAST:event_mphnKeyTyped

    private void lphnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lphnKeyTyped
        // TODO add your handling code here:
        char enter=evt.getKeyChar();
        if(!(Character.isDigit(enter)))
            evt.consume();
    }//GEN-LAST:event_lphnKeyTyped

    private void fxnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fxnoKeyTyped
        // TODO add your handling code here:
        char enter=evt.getKeyChar();
        if(!(Character.isDigit(enter)))
            evt.consume();
    }//GEN-LAST:event_fxnoKeyTyped

    private void pannoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pannoKeyTyped
        // TODO add your handling code here:
        char enter=evt.getKeyChar();
        if(!(Character.isDigit(enter)))
            evt.consume();
    }//GEN-LAST:event_pannoKeyTyped

    private void prKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prKeyTyped
        // TODO add your handling code here:
        char enter=evt.getKeyChar();
        if(!(Character.isDigit(enter)))
            evt.consume();
    }//GEN-LAST:event_prKeyTyped

    private void jLabel67MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel67MouseClicked
        // TODO add your handling code here:
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add2.png")));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view1.png")));
        layerRemoveAll(page);
        layerAdd(page,custOp);
        layerAdd(page,customer);
        layerAdd(page,pback);
    }//GEN-LAST:event_jLabel67MouseClicked

    private void jLabel68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel68MouseClicked
        // TODO add your handling code here:
          jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add1.png")));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view2.png")));
        layerRemoveAll(page);
        layerAdd(page,custOp);
        layerAdd(page,custUpdate);
        layerAdd(page,pback);
        custDisp();
    }//GEN-LAST:event_jLabel68MouseClicked

    private void jLabel71MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel71MouseEntered
        // TODO add your handling code here:
        if(policyClicked==false)
        {
            jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy2.png")));
        }
    }//GEN-LAST:event_jLabel71MouseEntered

    private void jLabel71MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel71MouseExited
        // TODO add your handling code here:
        if(policyClicked==false)
        {
            jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy1.png")));
        }
    }//GEN-LAST:event_jLabel71MouseExited

    private void jLabel72MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel72MouseEntered
        // TODO add your handling code here:
        if(loginClicked==false)
        {
            jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg2.png")));
        }
    }//GEN-LAST:event_jLabel72MouseEntered

    private void jLabel72MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel72MouseExited
        // TODO add your handling code here:
        if(loginClicked==false)
        {
            jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg1.png")));
        }
    }//GEN-LAST:event_jLabel72MouseExited

    private void jLabel71MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel71MouseClicked
        // TODO add your handling code here:
        bClicked("policy");
        label.setText("Policy");
        layerRemoveAll(page);
        layerRemoveAll(main2);
        layerAdd(main2,sbar);
        layerAdd(main2,page);
      
        
        //layerRemoveAll(pcalc);
        layerAdd(page,policyOp);
        layerAdd(page,policy);
        layerAdd(page,pback);
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view2.png")));
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/renew1.png")));
        custDisp2();
        page.setVisible(true);
    }//GEN-LAST:event_jLabel71MouseClicked

    private void jLabel72MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel72MouseClicked
        // TODO add your handling code here:
        bClicked("login");
        //layerAdd(main2, log);
        //log.setPosition(page,3);
        page.setVisible(false);
        main2.add(log);
        main2.repaint();
        main2.revalidate();
    }//GEN-LAST:event_jLabel72MouseClicked

    private void jLabel74MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseEntered
        // TODO add your handling code here:
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/logout2.png")));
    }//GEN-LAST:event_jLabel74MouseEntered

    private void jLabel74MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseExited
        // TODO add your handling code here:
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/logout1.png")));
    }//GEN-LAST:event_jLabel74MouseExited

    private void jLabel73MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel73MouseEntered
        // TODO add your handling code here:
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/chg2.png")));
    }//GEN-LAST:event_jLabel73MouseEntered

    private void jLabel73MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel73MouseExited
        // TODO add your handling code here:
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/chg1.png")));
    }//GEN-LAST:event_jLabel73MouseExited

    private void logMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logMouseExited
        // TODO add your handling code here:
        main2.remove(log);
         main2.repaint();
        main2.revalidate();
        // page.setVisible(true);
    }//GEN-LAST:event_logMouseExited

    private void jLabel74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseClicked
        // TODO add your handling code here:
        login l=new login();
        l.show();
        this.dispose();
    }//GEN-LAST:event_jLabel74MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        main2.remove(change);
        main2.repaint();
        main2.revalidate();
        
        bClicked("home");
        label.setText("");
         layerRemoveAll(main2);
        layerAdd(main2,sbar);
        layerAdd(main2,home);
        System.err.println(cUserId);
        page.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel73MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel73MouseClicked
        // TODO add your handling code here:
        layerRemoveAll(main2);
        layerAdd(main2,sbar);
        main2.add(change,3);
        main2.repaint();
        main2.revalidate();
        main2.remove(log);
         main2.repaint();
        main2.revalidate();
    }//GEN-LAST:event_jLabel73MouseClicked

    private void jLabel92MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel92MouseClicked
        // TODO add your handling code here:
        layerRemoveAll(page);
        layerAdd(page,policyOp);
        layerAdd(page,policy);
        layerAdd(page,pback);
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view2.png")));
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/renew1.png")));
        
        custDisp2();
    }//GEN-LAST:event_jLabel92MouseClicked

    private void jLabel93MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel93MouseClicked
        // TODO add your handling code here:
        layerRemoveAll(page);
        layerAdd(page,policyOp);
        layerAdd(page,policyRenew);
        layerAdd(page,pback);
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view1.png")));
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/renew2.png")));
        clearAll();
       // custDisp2();
    }//GEN-LAST:event_jLabel93MouseClicked

    private void jLabel105MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel105MouseEntered
        // TODO add your handling code here:
        jLabel105.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel105MouseEntered

    private void jLabel106MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel106MouseEntered
        // TODO add your handling code here:
        jLabel106.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel106MouseEntered

    private void jLabel105MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel105MouseExited
        // TODO add your handling code here:
        jLabel105.setBorder(null);
    }//GEN-LAST:event_jLabel105MouseExited

    private void jLabel106MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel106MouseExited
        // TODO add your handling code here:
        jLabel106.setBorder(null);
    }//GEN-LAST:event_jLabel106MouseExited

    private void policyNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_policyNoActionPerformed
        // TODO add your handling code here:
        jLabel96.setText("Policy No");
        renewPolicy(Integer.parseInt(policyNo.getText()));
    }//GEN-LAST:event_policyNoActionPerformed

    private void jLabel106MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel106MouseClicked
        // TODO add your handling code here:
        clearAll();
        jLabel96.setText("Enter Policy No");
    }//GEN-LAST:event_jLabel106MouseClicked

    private void jLabel105MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel105MouseClicked
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this,"Renew policy")==0)
        {
            if(policyCheck(policyNo))
            {
                float amount=(float) 0.0;
                String query;
                //Calendar cl=Calendar.getInstance();
                //int y=cl.getWeekYear();
                 try
                {
                    Database db=new Database();
                    db.jdbcConnect();
                    query="Select type,cc,year_manufacture,price from vehicle where cust_id='"+custid3.getText()+"'";
                     System.out.println(query);
                    db.p=db.conn.prepareStatement(query);
                    db.rs=db.p.executeQuery(query);
                    while(db.rs.next())
                    {
                        //int age=y-db.rs.getInt("year_manufacture");
                        //System.err.println(age);
                       amount=policyCalc(db.rs.getString("cc"),db.rs.getString("type"),db.rs.getInt("year_manufacture"),(String) type.getSelectedItem(),db.rs.getInt("price"));
                    }
                    db.rs.close();
                    db.p.close();
                    db.conn.close();
                }
                 catch(Exception e)
                 {
                     System.err.println(e);

                 }
                 try
                {
                    Database db=new Database();
                    db.jdbcConnect();
                    query="Update policy set start_date='"+start.getText()+"',end_date='"+end.getText()+"',insurance_type='"+(String) type.getSelectedItem()+"',insurance_amount="+amount+",status='Active' where policy_no="+policyNo.getText();
                     System.out.println(query);
                    db.p=db.conn.prepareStatement(query);
                    int rs=db.p.executeUpdate(query);

                   // db.rs.close();
                    db.p.close();
                    db.conn.close();

                }
                 catch(Exception e)
                 {
                     System.err.println(e);

                 }
                 custFrom=2;
                 cView(custid3.getText());
                         layerRemoveAll(page);
                         layerAdd(page,policyOp);
                         layerAdd(page,veiw);
                         layerAdd(page,pback);
                 clearAll();

            }
            else
            {
               JOptionPane.showMessageDialog(this,"Policy is not expired");
               clearAll();
            }
        }
    }//GEN-LAST:event_jLabel105MouseClicked
    Boolean policyCheck(JTextField x)
    {
        String query;
                //Calendar cl=Calendar.getInstance();
                //int y=cl.getWeekYear();
                 try
                {
                    Database db=new Database();
                    db.jdbcConnect();
                    query="Select status from policy where policy_no='"+x.getText()+"'";
                     System.out.println(query);
                    db.p=db.conn.prepareStatement(query);
                    db.rs=db.p.executeQuery(query);
                    while(db.rs.next())
                    {
                        if(db.rs.getString("status").equals("expired")||db.rs.getString("status").equals("Expired"))
                        {
                            return true;
                        }
                       
                    }
                    db.rs.close();
                    db.p.close();
                    db.conn.close();
                }
                 catch(Exception e)
                 {
                     System.err.println(e);

                 }
    
        return false;
    }
    private void jLabel64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel64MouseClicked
        // TODO add your handling code here:
        if(custFrom==1)
        {
            layerRemoveAll(page);
            layerAdd(page,custOp);
            layerAdd(page,customer);
            layerAdd(page,pback);
            jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add2.png")));
            jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update1.png")));
        }
        if(custFrom==2)
        {
            layerRemoveAll(page);
            layerAdd(page,policyOp);
            layerAdd(page,policy);
            layerAdd(page,pback);
            jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view2.png")));
            jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/renew1.png")));
        }
    }//GEN-LAST:event_jLabel64MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(cnewpass.getText().length()<=5||newpass.getText().length()<=5)
        {
            qwe.setText("Please enter a password with atleast 6 letters");
        }
        else
        {
        try
         {
            Database db=new Database();
            String query=""; 
            db.jdbcConnect();
            query="Select * from login_staff where Employee_Id='"+cUserId+"'";
             System.out.println(query);
//            db.stmt=conn.createStatement();
//            db.rs=db.stmt.executeQuery("we");
            db.p=db.conn.prepareStatement(query);
            db.rs=db.p.executeQuery(query);
             while(db.rs.next())
             {
                if(cpass.getText().equals(db.rs.getString("Password")))
                {
                    if(newpass.getText().equals(cnewpass.getText()))
                    {
                        query="update login_staff set Password='"+newpass.getText()+"' where Employee_Id='"+cUserId+"'";
                        System.out.println(query);
                        db.p=db.conn.prepareStatement(query);
                        int rs=db.p.executeUpdate(query);
                        JOptionPane.showMessageDialog(this,"Password changed sucessfully");
                        
                        bClicked("home");
                        label.setText("");
                        layerRemoveAll(main2);
                        layerAdd(main2,sbar);
                        layerAdd(main2,home);
                        System.err.println(cUserId);
                        page.setVisible(true);
                        
                    }
                    else
                    {
                        qwe.setText("The password you typed doesn't match");
                    }
                }
                else
                {
                    qwe.setText("Please re enter your current password");
                }
             }
             db.rs.close();
             db.p.close();
             db.conn.close();
         }
        catch(Exception e)
        {
            System.err.println(e);
        
        }
        
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseClicked
        try {
            // TODO add your handling code here:
            printCust();
        } catch (IOException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(custFrom==1)
        {
            layerRemoveAll(page);
            layerAdd(page,custOp);
            layerAdd(page,customer);
            layerAdd(page,pback);
            jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add2.png")));
            jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update1.png")));
        }
        if(custFrom==2)
        {
            layerRemoveAll(page);
            layerAdd(page,policyOp);
            layerAdd(page,policy);
            layerAdd(page,pback);
            jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view2.png")));
            jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/renew1.png")));
        }
    }//GEN-LAST:event_jLabel63MouseClicked

    private void jLabel63MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseEntered
        // TODO add your handling code here:
        jLabel63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel63MouseEntered

    private void jLabel63MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseExited
        // TODO add your handling code here:
        jLabel63.setBorder(null);
    }//GEN-LAST:event_jLabel63MouseExited

    private void jLabel64MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel64MouseEntered
        // TODO add your handling code here:
        jLabel64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel64MouseEntered

    private void jLabel64MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel64MouseExited
        // TODO add your handling code here:
        jLabel64.setBorder(null);
    }//GEN-LAST:event_jLabel64MouseExited

    private void jLabel112MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel112MouseClicked
        // TODO add your handling code here:
        bClicked("about");
        label.setText("About Us");
        layerRemoveAll(main2);
        layerAdd(main2,sbar);
        layerAdd(main2,about);
        setAbout();
    }//GEN-LAST:event_jLabel112MouseClicked

    private void jLabel112MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel112MouseEntered
        // TODO add your handling code here:

        if(aboutClicked==false)
        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts2.png")));
    }//GEN-LAST:event_jLabel112MouseEntered

    private void jLabel112MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel112MouseExited
        // TODO add your handling code here:
        if(aboutClicked==false)
        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
    }//GEN-LAST:event_jLabel112MouseExited

    private void mailidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mailidKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_mailidKeyTyped

    private void phntKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phntKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_phntKeyTyped

    private void jLabel132emptyFields(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel132emptyFields
        // TODO add your handling code here:
        layerRemoveAll(page);
            layerAdd(page,custOp);
            layerAdd(page,custUpdate);
            layerAdd(page,pback);
            jTextField1.setText(null);
    }//GEN-LAST:event_jLabel132emptyFields

    private void jLabel132MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel132MouseEntered
        // TODO add your handling code here:
        jLabel132.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel132MouseEntered

    private void jLabel132MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel132MouseExited
        // TODO add your handling code here:
        jLabel132.setBorder(null);
    }//GEN-LAST:event_jLabel132MouseExited

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        viewClicked(jTextField1.getText());
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void phntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phntActionPerformed

    
        void setRandom(JTextField field)
    {
        String value;
        Random r=new Random();
        int q;
        do
        {
            do
            {
                q=r.nextInt(100000);
            }while(q<10000);
            value="CUST "+String.valueOf(q);
            System.out.println(value);
        }while(randomCheck(value));
        field.setText(value);
    }
    
    Boolean randomCheck(String data)
    {
        if(updateFieldCheck("cust_id","customer",data))
        {
        return true;
        }
       return false;
    }
    
    
    
    
    
        Boolean updateFieldCheck(String field,String table,String Value)
    {
        String query="";
        String eid,name;
        Boolean check=false;
        try
        {
            Database db=new Database();
            db.jdbcConnect();
            query  ="Select "+field+" from "+table;
             System.out.println(query);
//            db.stmt=conn.createStatement();
//            db.rs=db.stmt.executeQuery("we");
            db.p=db.conn.prepareStatement(query);
            db.rs=db.p.executeQuery(query);
            while(db.rs.next())
            {
                eid=db.rs.getString("cust_id");
               // name=db.rs.getString("First_Name");
                 System.out.println("checkkkkkk");
                if(Value.equals(eid))
                {
                    System.out.println("trueeeeee");
                    return true;
                }
            }
            
            db.conn.close();
            db.rs.close();
            db.p.close();
        }
        catch(Exception e)
        {
            System.err.println("UP errrrrr");
            System.err.println(e);
        }
        
        return false;
    }
    
    
        
    void renewPolicy(int policy_no)
    {
        Boolean b=false;
        Calendar c=Calendar.getInstance();
        String sdate=sdf.format(c.getTime());
        c.add(Calendar.YEAR,1);
        String edate=sdf.format(c.getTime());
        String query;
         try
        {
            Database db=new Database();
            db.jdbcConnect();
            query="select p.policy_no,c.cust_id,c.fname,c.lname,c.address_v,v.vehicle_reg_no,c.occupation,c.mno,p.insurance_type from customer c,vehicle v,policy p where c.cust_id=p.cust_id and p.cust_id=v.cust_id and policy_no="+policy_no;
             System.out.println(query);
            db.p=db.conn.prepareStatement(query);
            db.rs=db.p.executeQuery(query);
            while(db.rs.next())
            {
                policyNo.setText(db.rs.getString("policy_no"));
                custid3.setText(db.rs.getString("cust_id"));
                custName.setText(db.rs.getString("fname")+" "+db.rs.getString("lname"));
                custAdress.setText(db.rs.getString("address_v"));
                occupation.setText(db.rs.getString("occupation"));
                phone.setText(db.rs.getString("mno"));
                vreg.setText(db.rs.getString("vehicle_reg_no"));
                type.setSelectedItem(db.rs.getString("insurance_type"));
                start.setText(sdate);
                end.setText(edate);
                b=true;
            }
            if(b==false)
            {
                JOptionPane.showMessageDialog(this,"Invalid policy no");
            }
            db.rs.close();
            db.p.close();
            db.conn.close();
        }
         catch(Exception e)
         {
             System.err.println(e);
         }
         
         
    }
        
        
    
    
    void nxtClicked()
    {
        //ComboBoxUI
        //tp.setUI(cbui);
        ErrorNotification en=new ErrorNotification();
        String type=(String) tv.getSelectedItem();
        String c=(String) cc.getSelectedItem();
         int age=jYearChooser1.getValue();
         Calendar cl=Calendar.getInstance();
        int y=cl.getWeekYear();
         if(age>y)
         {
             en.setErrorForTextField("Invalid Value",pr,this,page,3000,-140);   
                  return;
         }
         if(pr.getText().length()<5)
         {
             en.setErrorForTextField("Invalid Price",pr,this,page,3000,-5);   
                  return;
         }
         if(tv.getSelectedItem()!=null&&cc.getSelectedItem()!=null)
         {
         float p=policyCalc(c,type,age,(String)tp.getSelectedItem(),Integer.parseInt(pr.getText()));
          
         pr1.setText(String.valueOf(p)+" rupees");
         tv1.setText(type);
         cc1.setText(c);
         av1.setText(String.valueOf(y-age)+" yrs");
         tp1.setText((String)tp.getSelectedItem());
         ep1.setText(pr.getText());
         
         }
    }
    
    
    float policyCalc(String cc,String tv,int age,String policy,int p)
    {
        Calendar cl=Calendar.getInstance();
        int y=cl.getWeekYear();
        System.err.println("yyyyyy---"+y+"---yyyyyy");
        int dep=0;
        int temp=y-age;
        String qq;
        switch(temp)
        {
            case 0:qq="Select * from depriciation where av='1'";break;
            case 1:qq="Select * from depriciation where av='1'";break;
            case 2:qq="Select * from depriciation where av='2'";break;
            case 3:qq="Select * from depriciation where av='3'";break;
            case 4:qq="Select * from depriciation where av='4'";break;
            case 5:qq="Select * from depriciation where av='5'";break;
            default:qq="Select * from depriciation where av='5'";break;
        }
        
        try
         {
            Database db=new Database();
            String query=""; 
            db.jdbcConnect();
//            db.stmt=conn.createStatement();
//            db.rs=db.stmt.executeQuery("we");
            db.p=db.conn.prepareStatement(qq);
            db.rs=db.p.executeQuery(qq);
             System.err.println("nooo Excptnnnn");
             while(db.rs.next())
             {
                 dep=db.rs.getInt("percentage");
             }
             db.rs.close();
             db.conn.close();
             db.p.close();
             
         }
        catch(Exception e)
        {
            System.err.println(e);
        }
        
        
        //int y=;
        System.out.println("\n\n\n"+temp+"\n\n");
        float amount=0;
        try
         {
            Database db=new Database();
            String query=""; 
            db.jdbcConnect();
            query="Select * from tarif where cc='"+cc+"' and tv='"+tv+"'";
             System.out.println(query);
//            db.stmt=conn.createStatement();
//            db.rs=db.stmt.executeQuery("we");
            db.p=db.conn.prepareStatement(query);
            db.rs=db.p.executeQuery(query);
             System.err.println("nooo Excptnnnn");
             if(policy.equals("Liability Only"))
             {
             while(db.rs.next())
             {
                // pr1.setText(db.rs.getString("tp"));
                 amount=db.rs.getFloat("tp");
             }
             
             }
             if(policy.equals("Package Policy"))
             {
                 float price=Float.valueOf(p);
                 //if()
                 
                 float idv=price-((dep*price)/100);
                 System.err.println(idv);
                 float ag=0;
                        while(db.rs.next())
                        {
                            if(temp<=5)
                            {
                                ag=db.rs.getFloat("upto 5");
                            }
                            else if(temp<=10)
                            {
                                
                                ag=db.rs.getFloat("5-10");
                            }
                            else
                            {
                                ag=db.rs.getFloat("above 10");
                            }
                            float odp=(ag*idv)/100;
                            float pre=db.rs.getInt("pa")+db.rs.getInt("tp")+db.rs.getInt("wc")+db.rs.getInt("pass")+odp;
                            //pr1.setText(String.valueOf(pre));
                            amount=pre;
                        }
             }
             db.p.close();
             db.rs.close();
             db.conn.close();
            
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
        
        return amount;
    }
    
    void cView(String custid)
    {
        String query;
         try
        {
            Database db=new Database();
            db.jdbcConnect();
            query="select p.policy_no,p.start_date,p.end_date,p.insurance_amount,c.nationality,c.fname,c.occupation,c.address_v,v.vehicle_reg_no,v.reg_date,v.engine_no,v.chassis_no,v.make,v.model,v.year_manufacture,v.cc from customer c,vehicle v,policy p where c.cust_id='"+custid+"' and v.cust_id='"+custid+"' and p.cust_id='"+custid+"'";
             System.out.println(query);
            db.p=db.conn.prepareStatement(query);
            db.rs=db.p.executeQuery(query);
            while(db.rs.next())
            {
                pno.setText(db.rs.getString("policy_no"));
                ga.setText(db.rs.getString("nationality"));
                name.setText(db.rs.getString("fname"));
                prof.setText(db.rs.getString("occupation"));
                address.setText(db.rs.getString("address_v"));
                isdate.setText(db.rs.getString("Start_date"));
                iedate.setText(db.rs.getString("end_date"));
                rgno.setText(db.rs.getString("vehicle_reg_no"));
                rgdate.setText(db.rs.getString("reg_date"));
                egnno.setText(db.rs.getString("engine_no"));
                chano.setText(db.rs.getString("chassis_no"));
                make1.setText(db.rs.getString("make"));
               model1.setText(db.rs.getString("model"));
               ym.setText(db.rs.getString("year_manufacture"));
               cubic.setText(db.rs.getString("cc"));
               net.setText(db.rs.getString("insurance_amount"));
               float f=db.rs.getFloat("insurance_amount");
               float n=(12*f)/100;
               stax.setText(String.valueOf(n));
               tpre.setText(String.valueOf(n+f));
            }
            
            db.conn.close();
            db.rs.close();
            db.p.close();
        }
        catch(Exception e)
        {
            System.err.println("view eeerrrrrrrrrrr");
            System.err.println(e);
        }
    }
    
    
    void custDisp()
    {
        
        custTable.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {},new String [] {"customer id","Policy No", "Policy Type", "Start Date", "End Date", "Insured name", "Vehicle Resistartion No", "Policy Status"}));
        
        
        String query;
         try
        {
            Database db=new Database();
            db.jdbcConnect();
            query="select c.cust_id,p.policy_no,p.start_date,p.insurance_type,p.end_date,c.fname,v.vehicle_reg_no,p.status from customer c,vehicle v,policy p where v.cust_id=c.cust_id and p.cust_id=c.cust_id";
             System.out.println(query);
            db.p=db.conn.prepareStatement(query);
            db.rs=db.p.executeQuery(query);
            while(db.rs.next())
            {
                Object[] row={db.rs.getString("cust_id"),db.rs.getString("policy_no"),db.rs.getString("insurance_type"),db.rs.getString("start_date"),db.rs.getString("end_date"),db.rs.getString("fname"),db.rs.getString("vehicle_reg_no"),db.rs.getString("status")};
                    DefaultTableModel model=(DefaultTableModel)custTable.getModel();
                    model.addRow(row);
                    total.setText(db.rs.getString("policy_no"));
            }
            db.rs.close();
            db.p.close();
            db.conn.close();
        }
         catch(Exception e)
         {
             System.err.println(e+"\n custDisp Exception");
         }
    }
    
    void custDisp2()
    {
        
        expired.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {},new String [] {"Policy No", "Customer Id", "Policy Type", "Insured Name", "Vehicle Reg No", "Start Date", "End Date", "Policy Amount"}));
        
        active.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {},new String [] {"Policy No", "Customer Id", "Policy Type", "Insured Name", "Vehicle Reg No", "Start Date", "End Date", "Policy Amount"}));
        
        String query;
         try
        {
            Database db=new Database();
            db.jdbcConnect();
            query="select p.policy_no,p.start_date,p.insurance_type,p.end_date,c.fname,c.lname,v.vehicle_reg_no,p.status,p.insurance_amount,c.cust_id from customer c,vehicle v,policy p where v.cust_id=c.cust_id and p.cust_id=c.cust_id";
             System.out.println(query);
            db.p=db.conn.prepareStatement(query);
            db.rs=db.p.executeQuery(query);
            while(db.rs.next())
            {
                if(db.rs.getString("status").equals("active")||db.rs.getString("status").equals("Active"))
                {
                Object[] row={db.rs.getString("policy_no"),db.rs.getString("cust_id"),db.rs.getString("insurance_type"),db.rs.getString("fname")+" "+db.rs.getString("lname"),db.rs.getString("vehicle_reg_no"),db.rs.getString("start_date"),db.rs.getString("end_date"),db.rs.getString("insurance_amount")};
                    DefaultTableModel model=(DefaultTableModel)active.getModel();
                    model.addRow(row);
                    //total.setText(db.rs.getString("policy_no"));
                } 
                 if(db.rs.getString("status").equals("expired")||db.rs.getString("status").equals("Expired"))
                {
                Object[] row={db.rs.getString("policy_no"),db.rs.getString("cust_id"),db.rs.getString("insurance_type"),db.rs.getString("fname")+" "+db.rs.getString("lname"),db.rs.getString("vehicle_reg_no"),db.rs.getString("start_date"),db.rs.getString("end_date"),db.rs.getString("insurance_amount")};
                    DefaultTableModel model=(DefaultTableModel)expired.getModel();
                    model.addRow(row);
                    //total.setText(db.rs.getString("policy_no"));
                }
            }
            db.rs.close();
            db.p.close();
            db.conn.close();
        }
         catch(Exception e)
         {
             System.err.println(e+"\n custDisp Exception");
         }
    }
    //////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
      void printCust() throws IOException {
        
          
        String path = "user_details.pdf";
        
          try {
                JFrame parentFrame = new JFrame();
 
JFileChooser fileChooser = new JFileChooser();
        File file = new File("C:/user.pdf");
        fileChooser.setCurrentDirectory(file);
        
fileChooser.setDialogTitle("Specify a file to save");   
 
int userSelection = fileChooser.showSaveDialog(parentFrame);
 
if (userSelection == JFileChooser.APPROVE_OPTION) {
    File fileToSave = fileChooser.getSelectedFile();
    //path= fileToSave.getAbsolutePath();
    
    String ppath  = fileChooser.getSelectedFile().getParent();
    
    
    String fileNameWithOutExt = fileToSave.getName().replaceFirst("[.][^.]+$", "");
    
    System.out.println(ppath+"/"+fileNameWithOutExt+".pdf");
    path = ppath+"/"+fileNameWithOutExt+".pdf";
} else {
    return;
}
        
          } catch (Exception e) {
          }
        
     Document document = new Document();
      try
      {
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
         
        document.setMargins(2, 2, 2, 2);
         
         document.open();
         PdfContentByte canvas = writer.getDirectContent();
         
        
         CMYKColor magentaColor = new CMYKColor(1.f, 1.f, 1.f, 1.f);
        canvas.setColorStroke(magentaColor);
        //460,151
         canvas.setLineWidth(2);
        canvas.moveTo(2, 840-80);
        canvas.lineTo(592, 840 -80);
        
        canvas.setLineWidth(1);
        
        canvas.moveTo(35,480);
        canvas.lineTo(545,480);
        
        canvas.moveTo(35,480);
        canvas.lineTo(35,380);
        
        canvas.moveTo(35,380);
        canvas.lineTo(545,380);
        
        canvas.moveTo(545,480);
        canvas.lineTo(545,380);
        //130
        canvas.moveTo(127,480);
        canvas.lineTo(127,380);
        
        canvas.moveTo(272,480);
        canvas.lineTo(272,380);
        
        canvas.moveTo(212,480);
        canvas.lineTo(212,380);
        
        canvas.moveTo(377,480);
        canvas.lineTo(377,380);
        
        canvas.moveTo(487,480);
        canvas.lineTo(487,380);
      
        canvas.moveTo(35,450);
        canvas.lineTo(545,450);
        
        canvas.moveTo(35,415);
        canvas.lineTo(545,415);

       
        
        


       
 BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
    


  bf = BaseFont.createFont(BaseFont.TIMES_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

canvas.beginText();
canvas.moveText(10, 840 - 35);
canvas.setFontAndSize(bf, 25);
canvas.showText("VEHICLE INSURANCE MANAGEMENT SYSTEM");
canvas.endText();

bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

canvas.beginText();
canvas.moveText(490, 840 - 12);
canvas.setFontAndSize(bf, 12);
canvas.showText("Tel.:8943312403");
canvas.endText();




//pump management system


canvas.beginText();
canvas.moveText(150, 840 - 50);
canvas.setFontAndSize(bf, 13);
canvas.showText("");
canvas.endText();


canvas.beginText();
canvas.moveText(210, 840 - 65);
canvas.setFontAndSize(bf, 13);
canvas.showText("Pathanamthitta  691555");
canvas.endText();


//ImageIcon format = (ImageIcon)image_h2.getIcon();
//java.awt.Image awtImage = format.getImage();
//Image img = Image.getInstance(awtImage, null);
// 
//
// img.scaleToFit(120f, 120f);
//        img.setAbsolutePosition(420, 840 - 230 );
//        document.add(img);

canvas.beginText();
canvas.moveText(60, 840 - 160);
canvas.setFontAndSize(bf1, 12);
canvas.showText("Policy Number");
canvas.endText();

canvas.beginText();
canvas.moveText(160, 840 - 160);
canvas.setFontAndSize(bf, 12);
canvas.showText(":");
canvas.endText();

canvas.beginText();
canvas.moveText(170, 840 - 160);
canvas.setFontAndSize(bf, 12);
canvas.showText(pno.getText());
canvas.endText();
  
canvas.beginText();
canvas.moveText(310, 840 - 160);
canvas.setFontAndSize(bf1, 12);
canvas.showText("Customer Id");
canvas.endText();

canvas.beginText();
canvas.moveText(450, 840 - 160);
canvas.setFontAndSize(bf, 12);
canvas.showText(":");
canvas.endText();

canvas.beginText();
canvas.moveText(460, 840 - 160);
canvas.setFontAndSize(bf, 12);
canvas.showText(custid3.getText());
canvas.endText();

canvas.beginText();
canvas.moveText(60, 840 - 190);
canvas.setFontAndSize(bf1, 12);
canvas.showText("Insured Name");
canvas.endText();

canvas.beginText();
canvas.moveText(160, 840 - 190);
canvas.setFontAndSize(bf, 12);
canvas.showText(":");
canvas.endText();

canvas.beginText();
canvas.moveText(170, 840 - 190);
canvas.setFontAndSize(bf, 12);
canvas.showText(name.getText());
canvas.endText();

canvas.beginText();
canvas.moveText(310, 840 - 190);
canvas.setFontAndSize(bf1, 12);
canvas.showText("Insurance Start date");
canvas.endText();

canvas.beginText();
canvas.moveText(450, 840 - 190);
canvas.setFontAndSize(bf, 12);
canvas.showText(":");
canvas.endText();

canvas.beginText();
canvas.moveText(460, 840 - 190);
canvas.setFontAndSize(bf, 12);
canvas.showText(isdate.getText());
canvas.endText();

int hei = 840 - 220;

canvas.beginText();
canvas.moveText(60, hei);
canvas.setFontAndSize(bf1, 12);
canvas.showText("Profession");
canvas.endText();

canvas.beginText();
canvas.moveText(160, hei);
canvas.setFontAndSize(bf, 12);
canvas.showText(":");
canvas.endText();

canvas.beginText();
canvas.moveText(170, hei);
canvas.setFontAndSize(bf, 12);
canvas.showText(prof.getText());
canvas.endText();


canvas.beginText();
canvas.moveText(310, 840 - 220);
canvas.setFontAndSize(bf1, 12);
canvas.showText("Insurance End date");
canvas.endText();

canvas.beginText();
canvas.moveText(450, 840 - 220);
canvas.setFontAndSize(bf, 12);
canvas.showText(":");
canvas.endText();

canvas.beginText();
canvas.moveText(460, 840 - 220);
canvas.setFontAndSize(bf, 12);
canvas.showText(iedate.getText());
canvas.endText();

  
 hei = 840 - 250;

canvas.beginText();
canvas.moveText(60, hei);
canvas.setFontAndSize(bf1, 12);
canvas.showText("Insured address");
canvas.endText();

canvas.beginText();
canvas.moveText(170, hei);
canvas.setFontAndSize(bf, 12);
canvas.showText(":");
canvas.endText();

canvas.beginText();
canvas.moveText(180, hei);
canvas.setFontAndSize(bf, 12);
canvas.showText(address.getText());
canvas.endText();

int he12=-80;

 hei = 840 - 250 +he12;

canvas.beginText();
canvas.moveText(60, hei);
canvas.setFontAndSize(bf, 16);
canvas.showText("VEHICLE DETAILS");
canvas.endText();

 hei = 840 - 280 +he12+-20;

canvas.beginText();
canvas.moveText(50, hei);
canvas.setFontAndSize(bf1, 10);
canvas.showText("Registartion No");
canvas.endText();

//canvas.beginText();
//canvas.moveText(90, hei);
//canvas.setFontAndSize(bf, 10);
//canvas.showText(":");
//canvas.endText();

canvas.beginText();
canvas.moveText(130, hei);
canvas.setFontAndSize(bf, 10);
canvas.showText(rgno.getText());
canvas.endText();

canvas.beginText();
canvas.moveText(220, hei);
canvas.setFontAndSize(bf1, 10);
canvas.showText("Engine No");
canvas.endText();

//
//canvas.beginText();
//canvas.moveText(265, hei);
//canvas.setFontAndSize(bf, 10);
//canvas.showText(":");
//canvas.endText();

canvas.beginText();
canvas.moveText(275, hei);
canvas.setFontAndSize(bf, 10);
canvas.showText(egnno.getText());
canvas.endText();

canvas.beginText();
canvas.moveText(380, hei);
canvas.setFontAndSize(bf1, 10);
canvas.showText("Year of manufacture");
canvas.endText();

//canvas.beginText();
//canvas.moveText(480, hei);
//canvas.setFontAndSize(bf, 10);
//canvas.showText(":");
//canvas.endText();

canvas.beginText();
canvas.moveText(490, hei);
canvas.setFontAndSize(bf, 10);
canvas.showText(ym.getText());
canvas.endText();


hei = 840 - 340 +he12+-20;

canvas.beginText();
canvas.moveText(80, hei);
canvas.setFontAndSize(bf1, 10);
canvas.showText("Make");
canvas.endText();

//canvas.beginText();
//canvas.moveText(150, hei);
//canvas.setFontAndSize(bf, 10);
//canvas.showText(":");
//canvas.endText();

canvas.beginText();
canvas.moveText(130, hei);
canvas.setFontAndSize(bf, 10);
canvas.showText(make1.getText());
canvas.endText();

canvas.beginText();
canvas.moveText(235, hei);
canvas.setFontAndSize(bf1, 10);
canvas.showText("Model");
canvas.endText();

//canvas.beginText();
//canvas.moveText(285, hei);
//canvas.setFontAndSize(bf, 10);
//canvas.showText(":");
//canvas.endText();

canvas.beginText();
canvas.moveText(275, hei);
canvas.setFontAndSize(bf, 10);
canvas.showText(model1.getText());
canvas.endText();

hei = 840 - 310 +he12+-20;

canvas.beginText();
canvas.moveText(40, hei);
canvas.setFontAndSize(bf1, 10);
canvas.showText("Registartion Date");
canvas.endText();

//canvas.beginText();
//canvas.moveText(150, hei);
//canvas.setFontAndSize(bf, 10);
//canvas.showText(":");
//canvas.endText();

canvas.beginText();
canvas.moveText(130, hei);
canvas.setFontAndSize(bf, 10);
canvas.showText(rgdate.getText());
canvas.endText();

canvas.beginText();
canvas.moveText(215, hei);
canvas.setFontAndSize(bf1, 10);
canvas.showText("Chassis No");
canvas.endText();

//canvas.beginText();
//canvas.moveText(275, hei);
//canvas.setFontAndSize(bf, 10);
//canvas.showText(":");
//canvas.endText();

canvas.beginText();
canvas.moveText(275, hei);
canvas.setFontAndSize(bf, 10);
canvas.showText(chano.getText());
canvas.endText();


canvas.beginText();
canvas.moveText(380, hei);
canvas.setFontAndSize(bf1, 10);
canvas.showText("Cubic capacity");
canvas.endText();

//canvas.beginText();
//canvas.moveText(480, hei);
//canvas.setFontAndSize(bf, 10);
//canvas.showText(":");
//canvas.endText();

canvas.beginText();
canvas.moveText(490, hei);
canvas.setFontAndSize(bf, 10);
canvas.showText(cubic.getText());
canvas.endText();


hei = 840 - 630;
canvas.beginText();
canvas.moveText(290, hei);
canvas.setFontAndSize(bf1, 12);
canvas.showText("Net Premium");
canvas.endText();

//canvas.beginText();
//canvas.moveText(400, hei);
//canvas.setFontAndSize(bf, 12);
//canvas.showText(":");
//canvas.endText();

canvas.beginText();
canvas.moveText(410, hei);
canvas.setFontAndSize(bf, 12);
canvas.showText(net.getText());
canvas.endText();

hei = 840 - 660;
canvas.beginText();
canvas.moveText(290, hei);
canvas.setFontAndSize(bf1, 12);
canvas.showText("Service tax (12%)");
canvas.endText();

//canvas.beginText();
//canvas.moveText(400, hei);
//canvas.setFontAndSize(bf, 12);
//canvas.showText(":");
//canvas.endText();

canvas.beginText();
canvas.moveText(410, hei);
canvas.setFontAndSize(bf, 12);
canvas.showText(stax.getText());
canvas.endText();

hei = 840 - 690;
canvas.beginText();
canvas.moveText(290, hei);
canvas.setFontAndSize(bf1, 12);
canvas.showText("Total premium");
canvas.endText();

//canvas.beginText();
//canvas.moveText(400, hei);
//canvas.setFontAndSize(bf, 12);
//canvas.showText(":");
//canvas.endText();

canvas.beginText();
canvas.moveText(410, hei);
canvas.setFontAndSize(bf, 12);
canvas.showText(tpre.getText());
canvas.endText();


  ColumnText ct = new ColumnText(canvas);
        ct.setSimpleColumn(170, 840-820, 550, 190,  Element.ALIGN_BOTTOM, Element.ALIGN_LEFT);
        Font f = new Font();
        
        f = new Font(bf, 13);

        canvas.closePathStroke();
        
          try {
              
         writer.close();
         
         
         document.close();
         
         
          } catch (Exception e) {
          }

         if (Desktop.isDesktopSupported()) {
    try {
        File myFile = new File(path);
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
    }
}
      } catch (DocumentException e)
      {
         e.printStackTrace();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
        
    }
      void setAbout() { 
     String everything = "";
     

      try {
          
        

      BufferedReader br = new BufferedReader(new FileReader("about.settings"));
try {
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();

    while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
    }
     everything = sb.toString();
} finally {
    br.close();
}
      } catch (Exception e) {
      }

      
      System.err.println(" ne font is "+everything);
     
      
       try {
            
         ffffabout.setText(everything);
           
        // actionForSetThis(this, new javax.swing.plaf.FontUIResource(everything, Font.ITALIC, 12));
        } catch (Exception e) {
        }
  }
    

    
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
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane about;
    private javax.swing.JTable active;
    private javax.swing.JLabel address;
    private javax.swing.JLabel av1;
    private javax.swing.JLayeredPane bgrnd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea cadd;
    private javax.swing.JComboBox<String> cc;
    private javax.swing.JLabel cc1;
    private javax.swing.JComboBox<String> cc2;
    private javax.swing.JLayeredPane change;
    private javax.swing.JLabel chano;
    private javax.swing.JTextField chasisno;
    private javax.swing.JTextField chno;
    private javax.swing.JTextField cid;
    private javax.swing.JPasswordField cnewpass;
    private javax.swing.JTextField color;
    private javax.swing.JPasswordField cpass;
    private javax.swing.JLabel cubic;
    private javax.swing.JTextField custAdress;
    private javax.swing.JTextField custName;
    private javax.swing.JLayeredPane custOp;
    private javax.swing.JTable custTable;
    private javax.swing.JLayeredPane custUpdate;
    private javax.swing.JLayeredPane custView;
    private javax.swing.JTextField custid;
    private javax.swing.JTextField custid3;
    private javax.swing.JLayeredPane customer;
    private javax.swing.JTextField dob;
    private com.toedter.calendar.JDateChooser dob1;
    private com.toedter.calendar.JDateChooser dop;
    private javax.swing.JLabel dspDate;
    private javax.swing.JLabel dspTime;
    private javax.swing.JLabel egnno;
    private javax.swing.JTextField egno;
    private javax.swing.JTextField eid;
    private javax.swing.JTextField end;
    private javax.swing.JTextField engno;
    private javax.swing.JLabel ep1;
    private javax.swing.JTable expired;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextArea ffffabout;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField fxno;
    private javax.swing.JLabel ga;
    private javax.swing.JLayeredPane home;
    private javax.swing.JLabel iedate;
    private javax.swing.JLabel isdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel label;
    private javax.swing.JTextField lname;
    private javax.swing.JLayeredPane log;
    private javax.swing.JTextField lphn;
    private javax.swing.JTextField mailid;
    private javax.swing.JLayeredPane main;
    private javax.swing.JLayeredPane main1;
    private javax.swing.JLayeredPane main2;
    private javax.swing.JTextField make;
    private javax.swing.JLabel make1;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField mdl;
    private javax.swing.JTextField mke;
    private javax.swing.JTextField model;
    private javax.swing.JLabel model1;
    private javax.swing.JTextField mphn;
    private javax.swing.JLabel name;
    private javax.swing.JTextField namef;
    private javax.swing.JTextField namel;
    private javax.swing.JTextField nat;
    private javax.swing.JLabel net;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JTextField occu;
    private javax.swing.JTextField occupation;
    private javax.swing.JTextArea padd;
    private javax.swing.JTextArea paddress;
    private javax.swing.JLayeredPane page;
    private javax.swing.JTextField panno;
    private javax.swing.JLayeredPane pback;
    private javax.swing.JLayeredPane pback1;
    private javax.swing.JLayeredPane pback2;
    private javax.swing.JLayeredPane pback3;
    private javax.swing.JLayeredPane pcalc;
    private javax.swing.JTextField phnm;
    private javax.swing.JTextField phnt;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel pno;
    private javax.swing.JLayeredPane policy;
    private javax.swing.JTextField policyNo;
    private javax.swing.JLayeredPane policyOp;
    private javax.swing.JLayeredPane policyRenew;
    private javax.swing.JTextField pr;
    private javax.swing.JLabel pr1;
    private javax.swing.JTextField price;
    private javax.swing.JLabel prof;
    private javax.swing.JLabel qwe;
    private javax.swing.JTextField rdate;
    private javax.swing.JTextField regno;
    private javax.swing.JLabel rgdate;
    private javax.swing.JLabel rgno;
    private javax.swing.JLayeredPane sbar;
    private javax.swing.JTextField start;
    private javax.swing.JLabel stax;
    private javax.swing.JTextField tfuel;
    private javax.swing.JLabel total;
    private javax.swing.JComboBox<String> tp;
    private javax.swing.JLabel tp1;
    private javax.swing.JComboBox<String> tp2;
    private javax.swing.JLabel tpre;
    private javax.swing.JComboBox<String> tv;
    private javax.swing.JLabel tv1;
    private javax.swing.JComboBox<String> tv2;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JTextField vcc;
    private javax.swing.JLayeredPane vehicle;
    private javax.swing.JLayeredPane veiw;
    private javax.swing.JTextField vreg;
    private javax.swing.JTextField vregno;
    private javax.swing.JTextField vtype;
    private com.toedter.calendar.JYearChooser year;
    private javax.swing.JLabel ym;
    // End of variables declaration//GEN-END:variables
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 
 
 void viewClicked(String value)
    {
       if(viewFieldCheck("cust_id","customer",value))
         {
             
                layerRemoveAll(page);
            layerAdd(page,custOp);
            layerAdd(page,custView);
            layerAdd(page,pback);
        
                String query;
                 try
                 {
                     //jTextField22
                     Database db=new Database();
                     db.jdbcConnect();
                     query  ="select c.cust_id,c.fname,c.lname,c.dob,c.mno,c.lno,c.email_id,c.address_p,v.vehicle_reg_no,v.reg_date,v.type,v.cc,v.engine_no,v.chassis_no,v.make,v.model from customer c,vehicle v where v.cust_id='"+value+"' and c.cust_id='"+value+"'";
                     db.p=db.conn.prepareStatement(query);
                     db.rs=db.p.executeQuery(query);
                     while(db.rs.next())
                     {
                        cid.setText(db.rs.getString("cust_id"));
                        namef.setText(db.rs.getString("fname"));
                        namel.setText(db.rs.getString("lname"));
                        dob.setText(db.rs.getString("dob"));
                         phnm.setText(db.rs.getString("mno"));
                        phnt.setText(db.rs.getString("lno"));
                        mailid.setText(db.rs.getString("email_id"));
                        paddress.setText(db.rs.getString("address_p")); 
                       vregno.setText(db.rs.getString("vehicle_reg_no")); 
                        rdate.setText(db.rs.getString("reg_date"));
                        vtype.setText(db.rs.getString("type"));
                        vcc.setText(db.rs.getString("cc"));
                        engno.setText(db.rs.getString("engine_no"));
                        chasisno.setText(db.rs.getString("chassis_no"));
                        mke.setText(db.rs.getString("make"));
                        mdl.setText(db.rs.getString("model"));
                        
                     }
                      
                        db.conn.close();
                        db.rs.close();
                        db.p.close();
                 }
                 //
                 catch(Exception e)
                 {
                     System.err.println(e);
                 }
         }
         
         else
         {
             JOptionPane.showMessageDialog(this,"invalid customer id");
         }
    
    }
 
 Boolean viewFieldCheck(String field,String table,String Value)
    {
        String query="";
        String eid,name;
        Boolean check=false;
        try
        {
            Database db=new Database();
            db.jdbcConnect();
            query  ="Select "+field+" from "+table;
             System.out.println(query);
//            db.stmt=conn.createStatement();
//            db.rs=db.stmt.executeQuery("we");
            db.p=db.conn.prepareStatement(query);
            db.rs=db.p.executeQuery(query);
            while(db.rs.next())
            {
                eid=db.rs.getString("cust_id");
               // name=db.rs.getString("First_Name");
                 System.out.println("checkkkkkk");
                if(Value.equals(eid))
                {
                    System.out.println("trueeeeee");
                    return true;
                }
            }
            
            db.conn.close();
            db.rs.close();
            db.p.close();
        }
        catch(Exception e)
        {
            System.err.println("UP errrrrr");
            System.err.println(e);
        }
        
        return false;
    }
}
