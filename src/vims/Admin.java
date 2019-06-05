/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vims;

import java.awt.AlphaComposite;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Biju Raj
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                setExtendedState(MAXIMIZED_BOTH);
/////////////////////////////////////////////////////////////////!

            }
        });
        
        setDateAndTime();
        layerRemoveAll(main);
        layerRemoveAll(main2);
        layerAdd(main,main2);
        layerAdd(main2,sbar);
        layerAdd(main2,home);
        layerAdd(main,main1);
        addEmployeeToTheEmployeeShown();
                
        //jScrollPane6.setOpaque(true);
        
        jLabel61.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel62.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel63.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel113.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        
        
    }
    
    String cUserId;
    
    
    
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
    
    
     String filename;
    //byte[] person_image;
    byte[] outputimg;
     int y_fol_lonh=10;
    
    
    
    
        void selectImgOfEmployee(JLabel img) throws Exception
    {
        // TODO add your handling code here:
       

        try {
 //JFileChooser chooser =  new javax.swing.JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
       // path.setText(filename);
            File inputFile = new File(filename);
            BufferedImage inputImage = ImageIO.read(inputFile);
            
              if(!((inputImage.getWidth()>= img.getWidth())&&( inputImage.getHeight()>= img.getHeight())))
            {  
                JOptionPane.showMessageDialog(this, new String("not a valid image "));
                return;
            } 
            
BufferedImage outputImage = resizeImage(inputImage, inputImage.getWidth(), inputImage.getHeight(), img.getWidth(), img.getHeight());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String j = String.valueOf(inputImage.getType());
            ImageIO.write(outputImage, "jpg", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            outputimg = imageInByte;
            baos.close();
            ImageIcon format = null;
            format = new ImageIcon(imageInByte);
            img.setIcon(format);

        } catch (Exception e) {
        }
        
 

//        inserIntoMysql();
    }
        
        
            public static BufferedImage resizeImage(final Image image, int width, int height, int targetw, int targeth) {

        /////////////////////////////////////
//    if (width > height)targetw = 112;
//    else targetw = 50;
        do {
            if (width > targetw) {
                width /= 2;
                if (width < targetw) {
                    width = targetw;
                }
            }

            if (height > targeth) {
                height /= 2;
                if (height < targeth) {
                    height = targeth;
                }
            }
        } while (width != targetw || height != targeth);
        /////////////////////////////////

        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();

        return bufferedImage;
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
        try
        {
            chooser = new javax.swing.JFileChooser();
            dialog = new javax.swing.JDialog();
            jLayeredPane7 = new javax.swing.JLayeredPane();
            ok1 = new javax.swing.JButton();
            cancel = new javax.swing.JButton();
            msg = new javax.swing.JLabel();
            jLabel97 = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            jDesktopPane1 = new javax.swing.JDesktopPane();
            main = new javax.swing.JLayeredPane();
            main2 = new javax.swing.JLayeredPane();
            log = new javax.swing.JLayeredPane();
            jLabel108 = new javax.swing.JLabel();
            jLabel109 = new javax.swing.JLabel();
            change = new javax.swing.JLayeredPane();
            jLabel110 = new javax.swing.JLabel();
            jLabel111 = new javax.swing.JLabel();
            jLabel112 = new javax.swing.JLabel();
            cnewpass = new javax.swing.JPasswordField();
            newpass = new javax.swing.JPasswordField();
            cpass = new javax.swing.JPasswordField();
            jButton1 = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();
            qwe = new javax.swing.JLabel();
            sbar = new javax.swing.JLayeredPane();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel64 = new javax.swing.JLabel();
            jLabel103 = new javax.swing.JLabel();
            jLabel104 = new javax.swing.JLabel();
            page = new javax.swing.JLayeredPane();
            staff = new javax.swing.JLayeredPane();
            staffOp = new javax.swing.JLayeredPane();
            jLabel6 = new javax.swing.JLabel();
            jLabel8 = new javax.swing.JLabel();
            jLabel7 = new javax.swing.JLabel();
            staffAdd = new javax.swing.JLayeredPane();
            jLabel9 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            empid = new javax.swing.JTextField();
            jLabel11 = new javax.swing.JLabel();
            jLabel12 = new javax.swing.JLabel();
            fname = new javax.swing.JTextField();
            jLabel13 = new javax.swing.JLabel();
            lname = new javax.swing.JTextField();
            jLabel14 = new javax.swing.JLabel();
            dob1 = new com.toedter.calendar.JDateChooser();
            jLabel15 = new javax.swing.JLabel();
            male = new javax.swing.JRadioButton();
            female = new javax.swing.JRadioButton();
            jLabel16 = new javax.swing.JLabel();
            jScrollPane2 = new javax.swing.JScrollPane();
            padd = new javax.swing.JTextArea();
            jLabel17 = new javax.swing.JLabel();
            jScrollPane3 = new javax.swing.JScrollPane();
            cadd = new javax.swing.JTextArea();
            jLabel18 = new javax.swing.JLabel();
            jCheckBox1 = new javax.swing.JCheckBox();
            desig = new javax.swing.JTextField();
            qual = new javax.swing.JComboBox<>();
            exp = new javax.swing.JTextField();
            jLabel20 = new javax.swing.JLabel();
            eid = new javax.swing.JTextField();
            jLabel21 = new javax.swing.JLabel();
            jLabel22 = new javax.swing.JLabel();
            mphn = new javax.swing.JTextField();
            lphn = new javax.swing.JTextField();
            jLabel23 = new javax.swing.JLabel();
            jLabel24 = new javax.swing.JLabel();
            accno = new javax.swing.JTextField();
            jLabel25 = new javax.swing.JLabel();
            sal = new javax.swing.JTextField();
            jDesktopPane2 = new javax.swing.JDesktopPane();
            img1 = new javax.swing.JLabel();
            jLabel26 = new javax.swing.JLabel();
            jLabel29 = new javax.swing.JLabel();
            jLabel58 = new javax.swing.JLabel();
            jLabel59 = new javax.swing.JLabel();
            jLabel66 = new javax.swing.JLabel();
            sdate1 = new com.toedter.calendar.JDateChooser();
            ca = new javax.swing.JCheckBox();
            pageBack1 = new javax.swing.JLayeredPane();
            jLabel27 = new javax.swing.JLabel();
            staffView = new javax.swing.JLayeredPane();
            jLabel92 = new javax.swing.JLabel();
            jLabel93 = new javax.swing.JLabel();
            jLayeredPane5 = new javax.swing.JLayeredPane();
            img3 = new javax.swing.JLabel();
            empid3 = new javax.swing.JLabel();
            desig3 = new javax.swing.JLabel();
            fname3 = new javax.swing.JLabel();
            lname3 = new javax.swing.JLabel();
            label55 = new javax.swing.JLabel();
            dob3 = new javax.swing.JLabel();
            label56 = new javax.swing.JLabel();
            sex3 = new javax.swing.JLabel();
            label57 = new javax.swing.JLabel();
            qual3 = new javax.swing.JLabel();
            label58 = new javax.swing.JLabel();
            exp3 = new javax.swing.JLabel();
            label59 = new javax.swing.JLabel();
            sdate3 = new javax.swing.JLabel();
            mphn3 = new javax.swing.JLabel();
            label60 = new javax.swing.JLabel();
            label61 = new javax.swing.JLabel();
            sal3 = new javax.swing.JLabel();
            acc3 = new javax.swing.JLabel();
            label62 = new javax.swing.JLabel();
            label63 = new javax.swing.JLabel();
            eid3 = new javax.swing.JLabel();
            label64 = new javax.swing.JLabel();
            lphn3 = new javax.swing.JLabel();
            cadd3 = new javax.swing.JTextArea();
            padd3 = new javax.swing.JTextArea();
            label65 = new javax.swing.JLabel();
            label66 = new javax.swing.JLabel();
            jLabel40 = new javax.swing.JLabel();
            jLabel91 = new javax.swing.JLabel();
            staffUpdate = new javax.swing.JLayeredPane();
            jLabel30 = new javax.swing.JLabel();
            jLabel31 = new javax.swing.JLabel();
            empid2 = new javax.swing.JTextField();
            jLabel32 = new javax.swing.JLabel();
            jLabel33 = new javax.swing.JLabel();
            fname2 = new javax.swing.JTextField();
            jLabel34 = new javax.swing.JLabel();
            lname2 = new javax.swing.JTextField();
            jLabel35 = new javax.swing.JLabel();
            dob2 = new com.toedter.calendar.JDateChooser();
            jLabel36 = new javax.swing.JLabel();
            male1 = new javax.swing.JRadioButton();
            female2 = new javax.swing.JRadioButton();
            jLabel37 = new javax.swing.JLabel();
            jScrollPane4 = new javax.swing.JScrollPane();
            padd2 = new javax.swing.JTextArea();
            jLabel38 = new javax.swing.JLabel();
            jScrollPane5 = new javax.swing.JScrollPane();
            cadd2 = new javax.swing.JTextArea();
            jLabel39 = new javax.swing.JLabel();
            jCheckBox2 = new javax.swing.JCheckBox();
            desig2 = new javax.swing.JTextField();
            qual2 = new javax.swing.JComboBox<>();
            exp2 = new javax.swing.JTextField();
            jLabel41 = new javax.swing.JLabel();
            eid2 = new javax.swing.JTextField();
            jLabel42 = new javax.swing.JLabel();
            jLabel43 = new javax.swing.JLabel();
            mphn2 = new javax.swing.JTextField();
            lphn2 = new javax.swing.JTextField();
            jLabel44 = new javax.swing.JLabel();
            jLabel45 = new javax.swing.JLabel();
            acc2 = new javax.swing.JTextField();
            jLabel46 = new javax.swing.JLabel();
            sal2 = new javax.swing.JTextField();
            jDesktopPane3 = new javax.swing.JDesktopPane();
            img2 = new javax.swing.JLabel();
            jLabel47 = new javax.swing.JLabel();
            jLabel48 = new javax.swing.JLabel();
            sdate2 = new com.toedter.calendar.JDateChooser();
            jLabel84 = new javax.swing.JLabel();
            ca1 = new javax.swing.JCheckBox();
            jLabel85 = new javax.swing.JLabel();
            jLabel86 = new javax.swing.JLabel();
            pageBack2 = new javax.swing.JLayeredPane();
            jLabel49 = new javax.swing.JLabel();
            updateOp = new javax.swing.JLayeredPane();
            jLabel50 = new javax.swing.JLabel();
            jLabel51 = new javax.swing.JLabel();
            jLayeredPane1 = new javax.swing.JLayeredPane();
            jTextField22 = new javax.swing.JTextField();
            jLabel53 = new javax.swing.JLabel();
            jLabel87 = new javax.swing.JLabel();
            pageBack3 = new javax.swing.JLayeredPane();
            jLabel52 = new javax.swing.JLabel();
            viewOp = new javax.swing.JLayeredPane();
            jLabel54 = new javax.swing.JLabel();
            jLabel55 = new javax.swing.JLabel();
            jTextField24 = new javax.swing.JTextField();
            jLabel19 = new javax.swing.JLabel();
            jLabel56 = new javax.swing.JLabel();
            total = new javax.swing.JLabel();
            jScrollPane8 = new javax.swing.JScrollPane();
            jTable1 = new javax.swing.JTable();
            pageBack4 = new javax.swing.JLayeredPane();
            jLabel57 = new javax.swing.JLabel();
            premium = new javax.swing.JLayeredPane();
            premiumOp = new javax.swing.JLayeredPane();
            jLabel68 = new javax.swing.JLabel();
            jLabel69 = new javax.swing.JLabel();
            prmView = new javax.swing.JLayeredPane();
            jLabel72 = new javax.swing.JLabel();
            jLabel73 = new javax.swing.JLabel();
            jScrollPane7 = new javax.swing.JScrollPane();
            tb1 = new javax.swing.JTable();
            jScrollPane12 = new javax.swing.JScrollPane();
            tb5 = new javax.swing.JTable();
            jScrollPane13 = new javax.swing.JScrollPane();
            tb2 = new javax.swing.JTable();
            jScrollPane14 = new javax.swing.JScrollPane();
            tb3 = new javax.swing.JTable();
            jScrollPane15 = new javax.swing.JScrollPane();
            tb4 = new javax.swing.JTable();
            jLabel74 = new javax.swing.JLabel();
            jLabel95 = new javax.swing.JLabel();
            jLabel96 = new javax.swing.JLabel();
            jLabel98 = new javax.swing.JLabel();
            jLabel100 = new javax.swing.JLabel();
            jLabel99 = new javax.swing.JLabel();
            jLabel101 = new javax.swing.JLabel();
            jLabel102 = new javax.swing.JLabel();
            prmUpdate = new javax.swing.JLayeredPane();
            jLabel70 = new javax.swing.JLabel();
            jLabel71 = new javax.swing.JLabel();
            jLabel76 = new javax.swing.JLabel();
            tv = new javax.swing.JComboBox<>();
            jLabel77 = new javax.swing.JLabel();
            cc = new javax.swing.JComboBox<>();
            av = new javax.swing.JComboBox<>();
            jLabel78 = new javax.swing.JLabel();
            jLabel79 = new javax.swing.JLabel();
            dp = new javax.swing.JTextField();
            tp = new javax.swing.JTextField();
            jLabel80 = new javax.swing.JLabel();
            pa = new javax.swing.JTextField();
            jLabel81 = new javax.swing.JLabel();
            wc = new javax.swing.JTextField();
            jLabel82 = new javax.swing.JLabel();
            od = new javax.swing.JTextField();
            jLabel83 = new javax.swing.JLabel();
            jLabel88 = new javax.swing.JLabel();
            jLabel89 = new javax.swing.JLabel();
            jLabel90 = new javax.swing.JLabel();
            pass = new javax.swing.JTextField();
            pageBack7 = new javax.swing.JLayeredPane();
            jLabel75 = new javax.swing.JLabel();
            pageBack5 = new javax.swing.JLayeredPane();
            jLabel67 = new javax.swing.JLabel();
            pageBack = new javax.swing.JLayeredPane();
            jLabel5 = new javax.swing.JLabel();
            policy = new javax.swing.JLayeredPane();
            policyOP = new javax.swing.JLayeredPane();
            jLabel105 = new javax.swing.JLabel();
            jLabel106 = new javax.swing.JLabel();
            jLabel107 = new javax.swing.JLabel();
            active = new javax.swing.JLayeredPane();
            jScrollPane9 = new javax.swing.JScrollPane();
            active1 = new javax.swing.JTable();
            expired = new javax.swing.JLayeredPane();
            jScrollPane10 = new javax.swing.JScrollPane();
            expired1 = new javax.swing.JTable();
            tExpired = new javax.swing.JLayeredPane();
            jScrollPane11 = new javax.swing.JScrollPane();
            tExpired1 = new javax.swing.JTable();
            exbar = new javax.swing.JLayeredPane();
            jLabel94 = new javax.swing.JLabel();
            srch = new javax.swing.JTextField();
            jScrollPane6 = new javax.swing.JScrollPane();
            ms = new javax.swing.JLayeredPane();
            jLayeredPane4 = new javax.swing.JLayeredPane();
            jLabel28 = new javax.swing.JLabel();
            home = new javax.swing.JLayeredPane();
            jLabel61 = new javax.swing.JLabel();
            jLabel62 = new javax.swing.JLabel();
            jLabel63 = new javax.swing.JLabel();
            jLabel113 = new javax.swing.JLabel();
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

            chooser.setCurrentDirectory(new java.io.File("C:\\Users\\Indrajith Chandran\\Desktop\\busss"));
            chooser.setFileFilter(imageFilter);
            chooser.setOpaque(true);
        }catch(Exception d){}

        dialog.getContentPane().setLayout(new javax.swing.OverlayLayout(dialog.getContentPane()));

        ok1.setContentAreaFilled(false);
        ok1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok1ActionPerformed(evt);
            }
        });
        jLayeredPane7.add(ok1);
        ok1.setBounds(130, 110, 80, 30);

        cancel.setContentAreaFilled(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jLayeredPane7.add(cancel);
        cancel.setBounds(240, 110, 70, 30);

        msg.setBackground(new java.awt.Color(255, 255, 255));
        msg.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        msg.setForeground(new java.awt.Color(255, 255, 255));
        msg.setText("Are tou sure yo want to add Staff Details");
        jLayeredPane7.add(msg);
        msg.setBounds(110, 40, 230, 40);

        dialog.getContentPane().add(jLayeredPane7);

        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/NtBack.png"))); // NOI18N
        dialog.getContentPane().add(jLabel97);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1360, 700));

        jDesktopPane1.setMaximumSize(new java.awt.Dimension(1600, 900));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1360, 700));
        jDesktopPane1.setLayout(new javax.swing.OverlayLayout(jDesktopPane1));

        log.setBackground(new java.awt.Color(255, 0, 255));
        log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logMouseExited(evt);
            }
        });

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/chg1.png"))); // NOI18N
        jLabel108.setPreferredSize(new java.awt.Dimension(153, 38));
        jLabel108.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel108MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel108MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel108MouseExited(evt);
            }
        });

        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/logout1.png"))); // NOI18N
        jLabel109.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel109MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel109MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel109MouseExited(evt);
            }
        });

        log.setLayer(jLabel108, javax.swing.JLayeredPane.DEFAULT_LAYER);
        log.setLayer(jLabel109, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout logLayout = new javax.swing.GroupLayout(log);
        log.setLayout(logLayout);
        logLayout.setHorizontalGroup(
            logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
            .addGroup(logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logLayout.createSequentialGroup()
                    .addComponent(jLabel108, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logLayout.createSequentialGroup()
                    .addComponent(jLabel109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        logLayout.setVerticalGroup(
            logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
            .addGroup(logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(logLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(54, Short.MAX_VALUE)))
            .addGroup(logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logLayout.createSequentialGroup()
                    .addContainerGap(50, Short.MAX_VALUE)
                    .addComponent(jLabel109)
                    .addGap(19, 19, 19)))
        );

        change.setBackground(new java.awt.Color(204, 204, 204));
        change.setOpaque(true);

        jLabel110.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel110.setText("Current Password");

        jLabel111.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel111.setText("New Password");

        jLabel112.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel112.setText("Confirm New Password");

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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        change.setLayer(jLabel110, javax.swing.JLayeredPane.DEFAULT_LAYER);
        change.setLayer(jLabel111, javax.swing.JLayeredPane.DEFAULT_LAYER);
        change.setLayer(jLabel112, javax.swing.JLayeredPane.DEFAULT_LAYER);
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
                .addContainerGap(165, Short.MAX_VALUE)
                .addComponent(newpass, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(51, Short.MAX_VALUE)
                    .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(259, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(changeLayout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(258, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(changeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(259, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(165, Short.MAX_VALUE)
                    .addComponent(cnewpass, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(82, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(165, Short.MAX_VALUE)
                    .addComponent(cpass, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(83, 83, 83)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(181, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(156, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(272, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(65, 65, 65)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(18, Short.MAX_VALUE)
                    .addComponent(qwe, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19)))
        );
        changeLayout.setVerticalGroup(
            changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(newpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(58, Short.MAX_VALUE)
                    .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(186, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(changeLayout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(151, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(changeLayout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(121, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(125, Short.MAX_VALUE)
                    .addComponent(cnewpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(125, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(changeLayout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(cpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(190, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(198, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addContainerGap(49, Short.MAX_VALUE)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(199, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addGap(48, 48, 48)))
            .addGroup(changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeLayout.createSequentialGroup()
                    .addContainerGap(160, Short.MAX_VALUE)
                    .addComponent(qwe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(83, Short.MAX_VALUE)))
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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/staff1.png"))); // NOI18N
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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/premium1.png"))); // NOI18N
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

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png"))); // NOI18N
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

        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy1.png"))); // NOI18N
        jLabel103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel103MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel103MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel103MouseExited(evt);
            }
        });

        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg1.png"))); // NOI18N
        jLabel104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel104MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel104MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel104MouseExited(evt);
            }
        });

        sbar.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sbar.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sbar.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sbar.setLayer(jLabel64, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sbar.setLayer(jLabel103, javax.swing.JLayeredPane.DEFAULT_LAYER);
        sbar.setLayer(jLabel104, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
                .addGroup(sbarLayout.createSequentialGroup()
                    .addComponent(jLabel64)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sbarLayout.createSequentialGroup()
                    .addComponent(jLabel103)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sbarLayout.createSequentialGroup()
                    .addComponent(jLabel104)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        sbarLayout.setVerticalGroup(
            sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sbarLayout.createSequentialGroup()
                    .addContainerGap(63, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(219, Short.MAX_VALUE)))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sbarLayout.createSequentialGroup()
                    .addContainerGap(119, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(167, Short.MAX_VALUE)))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sbarLayout.createSequentialGroup()
                    .addGap(223, 223, 223)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(66, Short.MAX_VALUE)))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sbarLayout.createSequentialGroup()
                    .addContainerGap(171, Short.MAX_VALUE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(116, 116, 116)))
            .addGroup(sbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sbarLayout.createSequentialGroup()
                    .addContainerGap(277, Short.MAX_VALUE)
                    .addComponent(jLabel104)
                    .addGap(20, 20, 20)))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add2.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view1.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update1.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        staffOp.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        staffOp.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        staffOp.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout staffOpLayout = new javax.swing.GroupLayout(staffOp);
        staffOp.setLayout(staffOpLayout);
        staffOpLayout.setHorizontalGroup(
            staffOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(staffOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(staffOpLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(staffOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(staffOpLayout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(staffOpLayout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addComponent(jLabel7)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        staffOpLayout.setVerticalGroup(
            staffOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(staffOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(staffOpLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(staffOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        staff.add(staffOp);
        staffOp.setBounds(540, 0, 200, 40);

        staffAdd.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Add New");
        staffAdd.add(jLabel9);
        jLabel9.setBounds(28, 0, 100, 40);

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Current Address");
        staffAdd.add(jLabel10);
        jLabel10.setBounds(280, 90, 100, 27);

        empid.setEditable(false);
        empid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffAdd.add(empid);
        empid.setBounds(40, 120, 170, 18);

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Designation");
        staffAdd.add(jLabel11);
        jLabel11.setBounds(40, 140, 80, 27);

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("First Name");
        staffAdd.add(jLabel12);
        jLabel12.setBounds(40, 190, 70, 27);

        fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffAdd.add(fname);
        fname.setBounds(40, 220, 170, 18);

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Last Name");
        staffAdd.add(jLabel13);
        jLabel13.setBounds(40, 240, 70, 27);

        lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffAdd.add(lname);
        lname.setBounds(40, 270, 170, 18);

        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Sex");
        staffAdd.add(jLabel14);
        jLabel14.setBounds(40, 340, 90, 27);

        dob1.setOpaque(false);
        staffAdd.add(dob1);
        dob1.setBounds(40, 320, 170, 20);

        jLabel15.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Permenant Address");
        staffAdd.add(jLabel15);
        jLabel15.setBounds(40, 390, 120, 27);

        buttonGroup1.add(male);
        male.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        male.setText("Male");
        male.setOpaque(false);
        staffAdd.add(male);
        male.setBounds(50, 370, 60, 23);

        buttonGroup1.add(female);
        female.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        female.setText("Female");
        female.setOpaque(false);
        staffAdd.add(female);
        female.setBounds(130, 370, 70, 23);

        jLabel16.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Date Of Birth");
        staffAdd.add(jLabel16);
        jLabel16.setBounds(40, 290, 90, 27);

        padd.setColumns(20);
        padd.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        padd.setRows(5);
        jScrollPane2.setViewportView(padd);

        staffAdd.add(jScrollPane2);
        jScrollPane2.setBounds(40, 420, 170, 76);
        jScrollPane2.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane2.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Qualification");
        staffAdd.add(jLabel17);
        jLabel17.setBounds(280, 250, 80, 27);

        cadd.setColumns(20);
        cadd.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        cadd.setRows(5);
        jScrollPane3.setViewportView(cadd);

        staffAdd.add(jScrollPane3);
        jScrollPane3.setBounds(280, 146, 166, 100);
        jScrollPane3.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane3.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        jLabel18.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Employee ID");
        staffAdd.add(jLabel18);
        jLabel18.setBounds(40, 90, 80, 27);

        jCheckBox1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jCheckBox1.setText("same as permenant");
        jCheckBox1.setOpaque(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        staffAdd.add(jCheckBox1);
        jCheckBox1.setBounds(280, 115, 150, 30);

        desig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffAdd.add(desig);
        desig.setBounds(40, 170, 170, 18);

        qual.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        qual.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SSLC", "+2", "Degree", "PG" }));
        staffAdd.add(qual);
        qual.setBounds(280, 280, 170, 19);

        exp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffAdd.add(exp);
        exp.setBounds(280, 390, 170, 20);

        jLabel20.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Experirnce");
        staffAdd.add(jLabel20);
        jLabel20.setBounds(280, 360, 80, 30);

        eid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffAdd.add(eid);
        eid.setBounds(540, 298, 170, 20);

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Email ID");
        staffAdd.add(jLabel21);
        jLabel21.setBounds(540, 267, 80, 30);

        jLabel22.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Phone no");
        staffAdd.add(jLabel22);
        jLabel22.setBounds(280, 410, 80, 30);

        mphn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        mphn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mphnKeyTyped(evt);
            }
        });
        staffAdd.add(mphn);
        mphn.setBounds(280, 440, 170, 20);

        lphn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        lphn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lphnKeyTyped(evt);
            }
        });
        staffAdd.add(lphn);
        lphn.setBounds(280, 490, 170, 20);

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Telephone");
        staffAdd.add(jLabel23);
        jLabel23.setBounds(280, 460, 80, 30);

        jLabel24.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Account No");
        staffAdd.add(jLabel24);
        jLabel24.setBounds(540, 320, 80, 30);

        accno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffAdd.add(accno);
        accno.setBounds(540, 350, 170, 20);

        jLabel25.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Salary");
        staffAdd.add(jLabel25);
        jLabel25.setBounds(540, 370, 80, 30);

        sal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffAdd.add(sal);
        sal.setBounds(540, 400, 170, 20);

        jDesktopPane2.add(img1);
        img1.setBounds(0, 1, 120, 120);

        staffAdd.add(jDesktopPane2);
        jDesktopPane2.setBounds(590, 110, 120, 120);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/upld.png"))); // NOI18N
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        staffAdd.add(jLabel26);
        jLabel26.setBounds(590, 230, 120, 34);

        jLabel29.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("Staff");
        staffAdd.add(jLabel29);
        jLabel29.setBounds(90, 0, 160, 40);

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
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
        staffAdd.add(jLabel58);
        jLabel58.setBounds(530, 480, 120, 30);

        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        jLabel59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emptyFields(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel59MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel59MouseExited(evt);
            }
        });
        staffAdd.add(jLabel59);
        jLabel59.setBounds(670, 480, 120, 30);

        jLabel66.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel66.setText("Start Date");
        staffAdd.add(jLabel66);
        jLabel66.setBounds(280, 310, 70, 30);

        sdate1.setOpaque(false);
        staffAdd.add(sdate1);
        sdate1.setBounds(280, 340, 170, 20);

        ca.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        ca.setText("Create a Saff Account");
        ca.setOpaque(false);
        staffAdd.add(ca);
        ca.setBounds(540, 430, 260, 40);

        pageBack1.setLayout(new javax.swing.OverlayLayout(pageBack1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pgback.png"))); // NOI18N
        pageBack1.add(jLabel27);

        staffAdd.add(pageBack1);
        pageBack1.setBounds(0, 0, 819, 553);

        staff.add(staffAdd);
        staffAdd.setBounds(0, 0, 820, 550);

        jLabel92.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("View Staff");

        jLabel93.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 0, 0));
        jLabel93.setText("Details");

        jLayeredPane5.setBackground(new java.awt.Color(51, 51, 51));

        img3.setBackground(new java.awt.Color(255, 255, 255));
        img3.setForeground(new java.awt.Color(204, 0, 102));
        img3.setOpaque(true);
        jLayeredPane5.add(img3);
        img3.setBounds(61, 90, 120, 130);

        empid3.setBackground(new java.awt.Color(255, 255, 255));
        empid3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        empid3.setOpaque(true);
        jLayeredPane5.add(empid3);
        empid3.setBounds(221, 89, 180, 20);

        desig3.setBackground(new java.awt.Color(255, 255, 255));
        desig3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        desig3.setOpaque(true);
        jLayeredPane5.add(desig3);
        desig3.setBounds(221, 129, 180, 20);

        fname3.setBackground(new java.awt.Color(255, 255, 255));
        fname3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        fname3.setOpaque(true);
        jLayeredPane5.add(fname3);
        fname3.setBounds(221, 169, 180, 20);

        lname3.setBackground(new java.awt.Color(255, 255, 255));
        lname3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        lname3.setOpaque(true);
        jLayeredPane5.add(lname3);
        lname3.setBounds(221, 209, 180, 20);

        label55.setBackground(new java.awt.Color(255, 255, 255));
        label55.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        label55.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label55.setText("Date of Birth  :");
        jLayeredPane5.add(label55);
        label55.setBounds(131, 289, 100, 20);

        dob3.setBackground(new java.awt.Color(255, 255, 255));
        dob3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        dob3.setOpaque(true);
        jLayeredPane5.add(dob3);
        dob3.setBounds(241, 289, 140, 20);

        label56.setBackground(new java.awt.Color(255, 255, 255));
        label56.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        label56.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label56.setText("Sex  :");
        jLayeredPane5.add(label56);
        label56.setBounds(131, 329, 100, 20);

        sex3.setBackground(new java.awt.Color(255, 255, 255));
        sex3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        sex3.setOpaque(true);
        jLayeredPane5.add(sex3);
        sex3.setBounds(241, 329, 140, 20);

        label57.setBackground(new java.awt.Color(255, 255, 255));
        label57.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        label57.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label57.setText("Qualification  :");
        jLayeredPane5.add(label57);
        label57.setBounds(131, 369, 100, 20);

        qual3.setBackground(new java.awt.Color(255, 255, 255));
        qual3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        qual3.setOpaque(true);
        jLayeredPane5.add(qual3);
        qual3.setBounds(241, 369, 140, 20);

        label58.setBackground(new java.awt.Color(255, 255, 255));
        label58.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        label58.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label58.setText("Experience  :");
        jLayeredPane5.add(label58);
        label58.setBounds(131, 409, 100, 20);

        exp3.setBackground(new java.awt.Color(255, 255, 255));
        exp3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        exp3.setOpaque(true);
        jLayeredPane5.add(exp3);
        exp3.setBounds(241, 409, 140, 20);

        label59.setBackground(new java.awt.Color(255, 255, 255));
        label59.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        label59.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label59.setText("Start Date  :");
        jLayeredPane5.add(label59);
        label59.setBounds(131, 449, 100, 20);

        sdate3.setBackground(new java.awt.Color(255, 255, 255));
        sdate3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        sdate3.setOpaque(true);
        jLayeredPane5.add(sdate3);
        sdate3.setBounds(241, 449, 140, 20);

        mphn3.setBackground(new java.awt.Color(255, 255, 255));
        mphn3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        mphn3.setOpaque(true);
        jLayeredPane5.add(mphn3);
        mphn3.setBounds(241, 489, 140, 20);

        label60.setBackground(new java.awt.Color(255, 255, 255));
        label60.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        label60.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label60.setText("Phone no  :");
        jLayeredPane5.add(label60);
        label60.setBounds(131, 489, 100, 20);

        label61.setBackground(new java.awt.Color(255, 255, 255));
        label61.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        label61.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label61.setText("Salary  :");
        jLayeredPane5.add(label61);
        label61.setBounds(441, 489, 100, 20);

        sal3.setBackground(new java.awt.Color(255, 255, 255));
        sal3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        sal3.setOpaque(true);
        jLayeredPane5.add(sal3);
        sal3.setBounds(551, 489, 160, 20);

        acc3.setBackground(new java.awt.Color(255, 255, 255));
        acc3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        acc3.setOpaque(true);
        jLayeredPane5.add(acc3);
        acc3.setBounds(551, 449, 160, 20);

        label62.setBackground(new java.awt.Color(255, 255, 255));
        label62.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        label62.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label62.setText("Account No  :");
        jLayeredPane5.add(label62);
        label62.setBounds(441, 449, 100, 20);

        label63.setBackground(new java.awt.Color(255, 255, 255));
        label63.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        label63.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label63.setText("Email Id  :");
        jLayeredPane5.add(label63);
        label63.setBounds(441, 409, 100, 20);

        eid3.setBackground(new java.awt.Color(255, 255, 255));
        eid3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        eid3.setOpaque(true);
        jLayeredPane5.add(eid3);
        eid3.setBounds(551, 409, 160, 20);

        label64.setBackground(new java.awt.Color(255, 255, 255));
        label64.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        label64.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label64.setText("Permenant Address  :");
        jLayeredPane5.add(label64);
        label64.setBounds(431, 169, 110, 20);

        lphn3.setBackground(new java.awt.Color(255, 255, 255));
        lphn3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        lphn3.setOpaque(true);
        jLayeredPane5.add(lphn3);
        lphn3.setBounds(551, 369, 160, 20);

        cadd3.setEditable(false);
        cadd3.setColumns(20);
        cadd3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        cadd3.setRows(5);
        cadd3.setOpaque(false);
        jLayeredPane5.add(cadd3);
        cadd3.setBounds(550, 270, 160, 80);

        padd3.setEditable(false);
        padd3.setColumns(20);
        padd3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        padd3.setRows(5);
        padd3.setOpaque(false);
        jLayeredPane5.add(padd3);
        padd3.setBounds(550, 170, 160, 90);

        label65.setBackground(new java.awt.Color(255, 255, 255));
        label65.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        label65.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label65.setText("Telephone No  :");
        jLayeredPane5.add(label65);
        label65.setBounds(441, 369, 100, 20);

        label66.setBackground(new java.awt.Color(255, 255, 255));
        label66.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        label66.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label66.setText("Current Address  :");
        jLayeredPane5.add(label66);
        label66.setBounds(431, 279, 110, 20);

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel40MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel40MouseExited(evt);
            }
        });
        jLayeredPane5.add(jLabel40);
        jLabel40.setBounds(480, 90, 120, 30);

        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        jLabel91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel91MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel91MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel91MouseExited(evt);
            }
        });
        jLayeredPane5.add(jLabel91);
        jLabel91.setBounds(620, 90, 120, 30);

        staffView.setLayer(jLabel92, javax.swing.JLayeredPane.DEFAULT_LAYER);
        staffView.setLayer(jLabel93, javax.swing.JLayeredPane.DEFAULT_LAYER);
        staffView.setLayer(jLayeredPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout staffViewLayout = new javax.swing.GroupLayout(staffView);
        staffView.setLayout(staffViewLayout);
        staffViewLayout.setHorizontalGroup(
            staffViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
            .addGroup(staffViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(staffViewLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(731, Short.MAX_VALUE)))
            .addGroup(staffViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffViewLayout.createSequentialGroup()
                    .addContainerGap(80, Short.MAX_VALUE)
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(658, 658, 658)))
            .addGroup(staffViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane5))
        );
        staffViewLayout.setVerticalGroup(
            staffViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(staffViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(staffViewLayout.createSequentialGroup()
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 512, Short.MAX_VALUE)))
            .addGroup(staffViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(staffViewLayout.createSequentialGroup()
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 510, Short.MAX_VALUE)))
            .addGroup(staffViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane5))
        );

        staff.add(staffView);
        staffView.setBounds(0, 0, 820, 550);

        staffUpdate.setBackground(new java.awt.Color(204, 204, 204));

        jLabel30.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Update Staff");
        staffUpdate.add(jLabel30);
        jLabel30.setBounds(28, 0, 70, 40);

        jLabel31.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Current Address");
        staffUpdate.add(jLabel31);
        jLabel31.setBounds(280, 90, 100, 27);

        empid2.setEditable(false);
        empid2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffUpdate.add(empid2);
        empid2.setBounds(40, 120, 170, 18);

        jLabel32.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Designation");
        staffUpdate.add(jLabel32);
        jLabel32.setBounds(40, 140, 80, 27);

        jLabel33.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("First Name");
        staffUpdate.add(jLabel33);
        jLabel33.setBounds(40, 190, 70, 27);

        fname2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffUpdate.add(fname2);
        fname2.setBounds(40, 220, 170, 18);

        jLabel34.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Last Name");
        staffUpdate.add(jLabel34);
        jLabel34.setBounds(40, 240, 70, 27);

        lname2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffUpdate.add(lname2);
        lname2.setBounds(40, 270, 170, 18);

        jLabel35.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Sex");
        staffUpdate.add(jLabel35);
        jLabel35.setBounds(40, 340, 90, 27);
        staffUpdate.add(dob2);
        dob2.setBounds(40, 320, 170, 20);

        jLabel36.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Permenant Address");
        staffUpdate.add(jLabel36);
        jLabel36.setBounds(40, 390, 120, 27);

        buttonGroup1.add(male1);
        male1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        male1.setText("Male");
        male1.setOpaque(false);
        staffUpdate.add(male1);
        male1.setBounds(50, 370, 60, 23);

        buttonGroup1.add(female2);
        female2.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        female2.setText("Female");
        female2.setOpaque(false);
        staffUpdate.add(female2);
        female2.setBounds(130, 370, 70, 23);

        jLabel37.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("Date Of Birth");
        staffUpdate.add(jLabel37);
        jLabel37.setBounds(40, 290, 90, 27);

        padd2.setColumns(20);
        padd2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        padd2.setRows(5);
        jScrollPane4.setViewportView(padd2);

        staffUpdate.add(jScrollPane4);
        jScrollPane4.setBounds(40, 420, 170, 76);
        jScrollPane4.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane4.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        jLabel38.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("Qualification");
        staffUpdate.add(jLabel38);
        jLabel38.setBounds(280, 250, 80, 27);

        cadd2.setColumns(20);
        cadd2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        cadd2.setRows(5);
        jScrollPane5.setViewportView(cadd2);

        staffUpdate.add(jScrollPane5);
        jScrollPane5.setBounds(280, 146, 166, 100);
        jScrollPane5.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane5.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        jLabel39.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("Employee ID");
        staffUpdate.add(jLabel39);
        jLabel39.setBounds(40, 90, 80, 27);

        jCheckBox2.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jCheckBox2.setText("same as permenant");
        jCheckBox2.setOpaque(false);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        staffUpdate.add(jCheckBox2);
        jCheckBox2.setBounds(280, 115, 150, 30);

        desig2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffUpdate.add(desig2);
        desig2.setBounds(40, 170, 170, 18);

        qual2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SSLC", "+2", "Degree", "PG" }));
        staffUpdate.add(qual2);
        qual2.setBounds(280, 280, 170, 20);

        exp2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffUpdate.add(exp2);
        exp2.setBounds(280, 390, 170, 18);

        jLabel41.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel41.setText("Experirnce");
        staffUpdate.add(jLabel41);
        jLabel41.setBounds(280, 360, 80, 30);

        eid2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffUpdate.add(eid2);
        eid2.setBounds(540, 308, 170, 20);

        jLabel42.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel42.setText("Email ID");
        staffUpdate.add(jLabel42);
        jLabel42.setBounds(540, 280, 80, 30);

        jLabel43.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel43.setText("Phone no");
        staffUpdate.add(jLabel43);
        jLabel43.setBounds(280, 410, 80, 30);

        mphn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        mphn2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mphn2KeyTyped(evt);
            }
        });
        staffUpdate.add(mphn2);
        mphn2.setBounds(280, 438, 170, 20);

        lphn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        lphn2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lphn2KeyTyped(evt);
            }
        });
        staffUpdate.add(lphn2);
        lphn2.setBounds(280, 486, 170, 20);

        jLabel44.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel44.setText("Telephone");
        staffUpdate.add(jLabel44);
        jLabel44.setBounds(280, 457, 80, 30);

        jLabel45.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel45.setText("Account No");
        staffUpdate.add(jLabel45);
        jLabel45.setBounds(540, 324, 80, 30);

        acc2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffUpdate.add(acc2);
        acc2.setBounds(540, 352, 170, 20);

        jLabel46.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel46.setText("Salary");
        staffUpdate.add(jLabel46);
        jLabel46.setBounds(540, 374, 80, 30);

        sal2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        staffUpdate.add(sal2);
        sal2.setBounds(540, 402, 170, 20);

        jDesktopPane3.add(img2);
        img2.setBounds(0, 1, 120, 120);

        staffUpdate.add(jDesktopPane3);
        jDesktopPane3.setBounds(590, 110, 120, 120);

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/upld.png"))); // NOI18N
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });
        staffUpdate.add(jLabel47);
        jLabel47.setBounds(590, 230, 120, 34);

        jLabel48.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 0, 0));
        jLabel48.setText("Details");
        staffUpdate.add(jLabel48);
        jLabel48.setBounds(100, 0, 80, 40);

        sdate2.setOpaque(false);
        staffUpdate.add(sdate2);
        sdate2.setBounds(280, 340, 170, 20);

        jLabel84.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel84.setText("Start Date");
        staffUpdate.add(jLabel84);
        jLabel84.setBounds(280, 310, 70, 20);

        ca1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        ca1.setText("Create a Saff Account");
        ca1.setOpaque(false);
        staffUpdate.add(ca1);
        ca1.setBounds(540, 430, 180, 30);

        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        jLabel85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel85MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel85MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel85MouseExited(evt);
            }
        });
        staffUpdate.add(jLabel85);
        jLabel85.setBounds(510, 480, 120, 30);

        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        jLabel86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel86MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel86MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel86MouseExited(evt);
            }
        });
        staffUpdate.add(jLabel86);
        jLabel86.setBounds(650, 480, 120, 30);

        pageBack2.setLayout(new javax.swing.OverlayLayout(pageBack2));

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pgback.png"))); // NOI18N
        pageBack2.add(jLabel49);

        staffUpdate.add(pageBack2);
        pageBack2.setBounds(0, 0, 819, 553);

        staff.add(staffUpdate);
        staffUpdate.setBounds(0, 0, 820, 550);

        jLabel50.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 0, 0));
        jLabel50.setText("Details");
        updateOp.add(jLabel50);
        jLabel50.setBounds(100, 0, 60, 40);

        jLabel51.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Update Staff");
        updateOp.add(jLabel51);
        jLabel51.setBounds(28, 0, 90, 40);

        jLayeredPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLayeredPane1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        updateOp.add(jLayeredPane1);
        jLayeredPane1.setBounds(550, 250, 40, 50);

        jTextField22.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jTextField22.setBorder(null);
        jTextField22.setOpaque(false);
        jTextField22.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField22FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField22FocusLost(evt);
            }
        });
        updateOp.add(jTextField22);
        jTextField22.setBounds(250, 260, 240, 30);

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/up1.png"))); // NOI18N
        updateOp.add(jLabel53);
        jLabel53.setBounds(220, 210, 390, 120);

        jLabel87.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel87.setText("Enter Employee Id");
        updateOp.add(jLabel87);
        jLabel87.setBounds(240, 210, 150, 30);

        pageBack3.setLayout(new javax.swing.OverlayLayout(pageBack3));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pgback.png"))); // NOI18N
        pageBack3.add(jLabel52);

        updateOp.add(pageBack3);
        pageBack3.setBounds(0, 0, 819, 553);

        staff.add(updateOp);
        updateOp.setBounds(0, 0, 820, 550);

        jLabel54.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 0, 0));
        jLabel54.setText("Details");
        viewOp.add(jLabel54);
        jLabel54.setBounds(100, 0, 110, 40);

        jLabel55.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("View Staff");
        viewOp.add(jLabel55);
        jLabel55.setBounds(38, 0, 80, 40);

        jTextField24.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jTextField24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });
        viewOp.add(jTextField24);
        jTextField24.setBounds(130, 60, 250, 20);

        jLabel19.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel19.setText("Enter Employee Id");
        viewOp.add(jLabel19);
        jLabel19.setBounds(20, 60, 100, 30);

        jLabel56.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel56.setText("Total no of Employees :");
        viewOp.add(jLabel56);
        jLabel56.setBounds(450, 60, 120, 30);

        total.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        viewOp.add(total);
        total.setBounds(580, 60, 130, 30);

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Emp Id", "First Name", "Last Name", "DOB", "sex", "Designation", "permenant Addsress", "Start Date", "phone No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTable1);

        viewOp.add(jScrollPane8);
        jScrollPane8.setBounds(10, 140, 800, 380);
        jScrollPane8.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane8.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        pageBack4.setLayout(new javax.swing.OverlayLayout(pageBack4));

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pgback.png"))); // NOI18N
        pageBack4.add(jLabel57);

        viewOp.add(pageBack4);
        pageBack4.setBounds(0, 0, 819, 553);

        staff.add(viewOp);
        viewOp.setBounds(0, 0, 820, 550);

        page.add(staff);
        staff.setBounds(0, 0, 820, 550);

        premium.setBackground(new java.awt.Color(0, 0, 0));
        premium.setForeground(new java.awt.Color(0, 0, 0));

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view2.png"))); // NOI18N
        jLabel68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel68MouseClicked(evt);
            }
        });

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update1.png"))); // NOI18N
        jLabel69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel69MouseClicked(evt);
            }
        });

        premiumOp.setLayer(jLabel68, javax.swing.JLayeredPane.DEFAULT_LAYER);
        premiumOp.setLayer(jLabel69, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout premiumOpLayout = new javax.swing.GroupLayout(premiumOp);
        premiumOp.setLayout(premiumOpLayout);
        premiumOpLayout.setHorizontalGroup(
            premiumOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
            .addGroup(premiumOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(premiumOpLayout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jLabel68)
                    .addContainerGap(146, Short.MAX_VALUE)))
            .addGroup(premiumOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, premiumOpLayout.createSequentialGroup()
                    .addContainerGap(113, Short.MAX_VALUE)
                    .addComponent(jLabel69)
                    .addContainerGap(78, Short.MAX_VALUE)))
        );
        premiumOpLayout.setVerticalGroup(
            premiumOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(premiumOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(premiumOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        premium.add(premiumOp);
        premiumOp.setBounds(560, 0, 260, 40);

        jLabel72.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("View Premium");
        prmView.add(jLabel72);
        jLabel72.setBounds(25, 0, 75, 39);

        jLabel73.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 0, 0));
        jLabel73.setText("Chart");
        prmView.add(jLabel73);
        jLabel73.setBounds(109, 0, 64, 38);

        tb1.setBackground(new java.awt.Color(204, 204, 204));
        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cubic Capacity", "Third party Premium", "Personal Accident", "Passenger Cover", "Work Compensation", "upto 5", "5 - 10", "above 10"
            }
        ));
        tb1.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tb1);

        prmView.add(jScrollPane7);
        jScrollPane7.setBounds(114, 53, 688, 80);

        tb5.setBackground(new java.awt.Color(204, 204, 204));
        tb5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No of Passengers", "Third party Premium", "Personal Accident", "Passenger Cover", "Work Compensation", "upto 5", "5 - 10", "above 10"
            }
        ));
        jScrollPane12.setViewportView(tb5);

        prmView.add(jScrollPane12);
        jScrollPane12.setBounds(114, 445, 688, 100);

        tb2.setBackground(new java.awt.Color(204, 204, 204));
        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cubic Capacity", "Third party Premium", "Personal Accident", "Passenger Cover", "Work Compensation", "upto 5", "5 - 10", "above 10"
            }
        ));
        tb2.setOpaque(false);
        jScrollPane13.setViewportView(tb2);

        prmView.add(jScrollPane13);
        jScrollPane13.setBounds(114, 137, 688, 90);

        tb3.setBackground(new java.awt.Color(204, 204, 204));
        tb3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cubic Capacity", "Third party Premium", "Personal Accident", "Passenger Cover", "Work Compensation", "upto 5", "5 - 10", "above 10"
            }
        ));
        jScrollPane14.setViewportView(tb3);

        prmView.add(jScrollPane14);
        jScrollPane14.setBounds(114, 233, 688, 110);

        tb4.setBackground(new java.awt.Color(204, 204, 204));
        tb4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cubic Capacity", "Third party Premium", "Personal Accident", "Passenger Cover", "Work Compensation", "upto 5", "5 - 10", "above 10"
            }
        ));
        jScrollPane15.setViewportView(tb4);

        prmView.add(jScrollPane15);
        jScrollPane15.setBounds(114, 352, 688, 80);

        jLabel74.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel74.setText("Private Cars");
        prmView.add(jLabel74);
        jLabel74.setBounds(0, 58, 91, 20);

        jLabel95.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel95.setText("Two Wheelers");
        prmView.add(jLabel95);
        jLabel95.setBounds(0, 136, 91, 30);

        jLabel96.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel96.setText("Goods Carrying");
        prmView.add(jLabel96);
        jLabel96.setBounds(10, 239, 81, 10);

        jLabel98.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel98.setText("Vhcls for Hire");
        prmView.add(jLabel98);
        jLabel98.setBounds(10, 362, 81, 10);

        jLabel100.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel100.setText("Vehicles");
        prmView.add(jLabel100);
        jLabel100.setBounds(20, 249, 66, 20);

        jLabel99.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel99.setText("(upto 6 pass)");
        prmView.add(jLabel99);
        jLabel99.setBounds(20, 377, 71, 10);

        jLabel101.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel101.setText("Vhcls for Hire");
        prmView.add(jLabel101);
        jLabel101.setBounds(10, 422, 81, 30);

        jLabel102.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel102.setText("(upto 6 pass)");
        prmView.add(jLabel102);
        jLabel102.setBounds(20, 437, 71, 30);

        premium.add(prmView);
        prmView.setBounds(0, 0, 820, 550);

        jLabel70.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Update Premium");
        prmUpdate.add(jLabel70);
        jLabel70.setBounds(28, 0, 83, 41);

        jLabel71.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 0, 51));
        jLabel71.setText("Chart");
        prmUpdate.add(jLabel71);
        jLabel71.setBounds(116, 0, 60, 39);

        jLabel76.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel76.setText("Type of Vehicle");
        prmUpdate.add(jLabel76);
        jLabel76.setBounds(38, 92, 110, 24);

        tv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Private Cars", "Two Wheelers", "Goods Carrying Vehicles", "Vhcls for Hire(upto 6 Pass)", "Vhcls for Hire(above 6 Pass)", "3 WHR PASS carriying" }));
        tv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        tv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvActionPerformed(evt);
                avActionPerformed(evt);
            }
        });
        prmUpdate.add(tv);
        tv.setBounds(45, 119, 180, 22);

        jLabel77.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel77.setText("Cubic Capacity");
        prmUpdate.add(jLabel77);
        jLabel77.setBounds(38, 152, 110, 20);

        cc.setSelectedItem(-1);
        cc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        cc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avActionPerformed(evt);
            }
        });
        prmUpdate.add(cc);
        cc.setBounds(45, 179, 180, 22);

        av.setSelectedItem(-1);
        av.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        av.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avActionPerformed(evt);
            }
        });
        prmUpdate.add(av);
        av.setBounds(45, 239, 180, 22);

        jLabel78.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Age of Vehicle");
        prmUpdate.add(jLabel78);
        jLabel78.setBounds(38, 212, 110, 20);

        jLabel79.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText("Depreciation Percentage");
        prmUpdate.add(jLabel79);
        jLabel79.setBounds(38, 272, 140, 20);

        dp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        prmUpdate.add(dp);
        dp.setBounds(40, 300, 190, 20);

        tp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        prmUpdate.add(tp);
        tp.setBounds(40, 370, 190, 20);

        jLabel80.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("Third party premium");
        prmUpdate.add(jLabel80);
        jLabel80.setBounds(38, 342, 140, 20);

        pa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        prmUpdate.add(pa);
        pa.setBounds(320, 120, 190, 20);

        jLabel81.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("Personal Accident cover");
        prmUpdate.add(jLabel81);
        jLabel81.setBounds(318, 92, 140, 20);

        wc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        prmUpdate.add(wc);
        wc.setBounds(320, 260, 190, 20);

        jLabel82.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel82.setText("Work Compensation");
        prmUpdate.add(jLabel82);
        jLabel82.setBounds(318, 232, 140, 20);

        od.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        prmUpdate.add(od);
        od.setBounds(320, 340, 190, 20);

        jLabel83.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel83.setText("Own damage premium %");
        prmUpdate.add(jLabel83);
        jLabel83.setBounds(318, 302, 160, 30);

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        jLabel88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel88MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel88MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel88MouseExited(evt);
            }
        });
        prmUpdate.add(jLabel88);
        jLabel88.setBounds(610, 210, 120, 30);

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        jLabel89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel89MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel89MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel89MouseExited(evt);
            }
        });
        prmUpdate.add(jLabel89);
        jLabel89.setBounds(610, 270, 120, 30);

        jLabel90.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel90.setText("Passenger Compensation cover");
        prmUpdate.add(jLabel90);
        jLabel90.setBounds(318, 162, 190, 20);

        pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        prmUpdate.add(pass);
        pass.setBounds(320, 190, 190, 20);

        pageBack7.setLayout(new javax.swing.OverlayLayout(pageBack7));

        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pgback.png"))); // NOI18N
        pageBack7.add(jLabel75);

        prmUpdate.add(pageBack7);
        pageBack7.setBounds(0, 0, 819, 553);

        premium.add(prmUpdate);
        prmUpdate.setBounds(0, 0, 820, 550);

        pageBack5.setLayout(new javax.swing.OverlayLayout(pageBack5));

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pgback.png"))); // NOI18N
        pageBack5.add(jLabel67);

        premium.add(pageBack5);
        pageBack5.setBounds(0, 0, 819, 553);

        page.add(premium);
        premium.setBounds(0, 0, 820, 550);

        pageBack.setLayout(new javax.swing.OverlayLayout(pageBack));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pgback.png"))); // NOI18N
        pageBack.add(jLabel5);

        page.add(pageBack);
        pageBack.setBounds(0, 0, 819, 553);

        jLabel105.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 0, 0));
        jLabel105.setText("Active Policies");
        jLabel105.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel105MouseClicked(evt);
            }
        });
        policyOP.add(jLabel105);
        jLabel105.setBounds(0, 0, 100, 30);

        jLabel106.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel106.setText("Expired Policies");
        jLabel106.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel106MouseClicked(evt);
            }
        });
        policyOP.add(jLabel106);
        jLabel106.setBounds(110, 0, 100, 30);

        jLabel107.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel107.setText("Policies Expiring this month");
        jLabel107.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel107MouseClicked(evt);
            }
        });
        policyOP.add(jLabel107);
        jLabel107.setBounds(220, 0, 180, 30);

        policy.add(policyOP);
        policyOP.setBounds(390, 70, 400, 30);

        active1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Policy No", "Customer Id", "Policy Type", "Insured Name", "Vehicle Reg No", "Start Date", "End Date", "Policy Amount"
            }
        ));
        jScrollPane9.setViewportView(active1);

        active.setLayer(jScrollPane9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout activeLayout = new javax.swing.GroupLayout(active);
        active.setLayout(activeLayout);
        activeLayout.setHorizontalGroup(
            activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
            .addGroup(activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, activeLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        activeLayout.setVerticalGroup(
            activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
            .addGroup(activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, activeLayout.createSequentialGroup()
                    .addContainerGap(44, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE)))
        );

        jScrollPane7.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane7.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        policy.add(active);
        active.setBounds(0, 100, 820, 430);

        expired1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Policy No", "Customer Id", "Policy Type", "Insured Name", "Vehicle Reg No", "Start Date", "End Date", "Policy Amount"
            }
        ));
        jScrollPane10.setViewportView(expired1);

        expired.setLayer(jScrollPane10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout expiredLayout = new javax.swing.GroupLayout(expired);
        expired.setLayout(expiredLayout);
        expiredLayout.setHorizontalGroup(
            expiredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
            .addGroup(expiredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expiredLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        expiredLayout.setVerticalGroup(
            expiredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
            .addGroup(expiredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expiredLayout.createSequentialGroup()
                    .addContainerGap(44, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE)))
        );

        jScrollPane7.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane7.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        policy.add(expired);
        expired.setBounds(0, 100, 820, 430);

        tExpired1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Policy No", "Customer Id", "Policy Type", "Insured Name", "Vehicle Reg No", "Start Date", "End Date", "Policy Amount"
            }
        ));
        jScrollPane11.setViewportView(tExpired1);

        tExpired.setLayer(jScrollPane11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout tExpiredLayout = new javax.swing.GroupLayout(tExpired);
        tExpired.setLayout(tExpiredLayout);
        tExpiredLayout.setHorizontalGroup(
            tExpiredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
            .addGroup(tExpiredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tExpiredLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        tExpiredLayout.setVerticalGroup(
            tExpiredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
            .addGroup(tExpiredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tExpiredLayout.createSequentialGroup()
                    .addContainerGap(44, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE)))
        );

        jScrollPane7.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane7.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        policy.add(tExpired);
        tExpired.setBounds(0, 100, 820, 430);

        page.add(policy);
        policy.setBounds(0, 0, 820, 530);

        exbar.setPreferredSize(new java.awt.Dimension(160, 557));

        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/srch.png"))); // NOI18N
        jLabel94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel94MouseClicked(evt);
            }
        });
        exbar.add(jLabel94);
        jLabel94.setBounds(119, 54, 32, 21);

        srch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        srch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                srchFocusLost(evt);
            }
        });
        srch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srchActionPerformed(evt);
            }
        });
        srch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                srchKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                srchKeyTyped(evt);
            }
        });
        exbar.add(srch);
        srch.setBounds(19, 57, 112, 18);

        jScrollPane6.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane6.setBorder(null);

        ms.setBackground(new java.awt.Color(204, 204, 204));
        ms.setOpaque(true);

        javax.swing.GroupLayout msLayout = new javax.swing.GroupLayout(ms);
        ms.setLayout(msLayout);
        msLayout.setHorizontalGroup(
            msLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );
        msLayout.setVerticalGroup(
            msLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(ms);

        exbar.add(jScrollPane6);
        jScrollPane6.setBounds(0, 91, 158, 480);
        jScrollPane6.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane6.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        jLayeredPane4.setLayout(new javax.swing.OverlayLayout(jLayeredPane4));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pgBack2.png"))); // NOI18N
        jLayeredPane4.add(jLabel28);

        exbar.add(jLayeredPane4);
        jLayeredPane4.setBounds(0, 0, 162, 557);

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sma.png"))); // NOI18N
        jLabel61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pms.png"))); // NOI18N
        jLabel62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abs.png"))); // NOI18N
        jLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel64MouseClicked(evt);
            }
        });

        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/PMGNT.png"))); // NOI18N
        jLabel113.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel103MouseClicked(evt);
            }
        });

        home.setLayer(jLabel61, javax.swing.JLayeredPane.DEFAULT_LAYER);
        home.setLayer(jLabel62, javax.swing.JLayeredPane.DEFAULT_LAYER);
        home.setLayer(jLabel63, javax.swing.JLayeredPane.DEFAULT_LAYER);
        home.setLayer(jLabel113, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel61)
                .addContainerGap(509, Short.MAX_VALUE))
            .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                    .addContainerGap(517, Short.MAX_VALUE)
                    .addComponent(jLabel62)
                    .addGap(18, 18, 18)))
            .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homeLayout.createSequentialGroup()
                    .addGap(518, 518, 518)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
            .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                    .addContainerGap(24, Short.MAX_VALUE)
                    .addComponent(jLabel113)
                    .addContainerGap(511, Short.MAX_VALUE)))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel61)
                .addContainerGap(354, Short.MAX_VALUE))
            .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homeLayout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addComponent(jLabel62)
                    .addContainerGap(352, Short.MAX_VALUE)))
            .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                    .addContainerGap(212, Short.MAX_VALUE)
                    .addComponent(jLabel63)
                    .addContainerGap(213, Short.MAX_VALUE)))
            .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                    .addContainerGap(212, Short.MAX_VALUE)
                    .addComponent(jLabel113)
                    .addContainerGap(213, Short.MAX_VALUE)))
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
            .addGap(0, 961, Short.MAX_VALUE)
            .addGroup(aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                    .addContainerGap(62, Short.MAX_VALUE)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(722, Short.MAX_VALUE)))
            .addGroup(aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                    .addContainerGap(56, Short.MAX_VALUE)
                    .addComponent(ffffabout, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE)))
        );
        aboutLayout.setVerticalGroup(
            aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(468, Short.MAX_VALUE)))
            .addGroup(aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                    .addContainerGap(96, Short.MAX_VALUE)
                    .addComponent(ffffabout, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );

        main2.setLayer(log, javax.swing.JLayeredPane.DEFAULT_LAYER);
        main2.setLayer(change, javax.swing.JLayeredPane.DEFAULT_LAYER);
        main2.setLayer(sbar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        main2.setLayer(page, javax.swing.JLayeredPane.DEFAULT_LAYER);
        main2.setLayer(exbar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        main2.setLayer(home, javax.swing.JLayeredPane.DEFAULT_LAYER);
        main2.setLayer(about, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout main2Layout = new javax.swing.GroupLayout(main2);
        main2.setLayout(main2Layout);
        main2Layout.setHorizontalGroup(
            main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main2Layout.createSequentialGroup()
                .addComponent(sbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1186, Short.MAX_VALUE))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(282, Short.MAX_VALUE)
                    .addComponent(page, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(329, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(1110, Short.MAX_VALUE)
                    .addComponent(exbar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(162, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(269, Short.MAX_VALUE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(144, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(main2Layout.createSequentialGroup()
                    .addGap(244, 244, 244)
                    .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1023, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(main2Layout.createSequentialGroup()
                    .addGap(511, 511, 511)
                    .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(510, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(305, Short.MAX_VALUE)
                    .addComponent(about, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(164, Short.MAX_VALUE)))
        );
        main2Layout.setVerticalGroup(
            main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main2Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(sbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(112, Short.MAX_VALUE)
                    .addComponent(page, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(140, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(111, Short.MAX_VALUE)
                    .addComponent(exbar, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(142, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(119, Short.MAX_VALUE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(74, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(main2Layout.createSequentialGroup()
                    .addGap(455, 455, 455)
                    .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(236, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(main2Layout.createSequentialGroup()
                    .addGap(244, 244, 244)
                    .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(290, Short.MAX_VALUE)))
            .addGroup(main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main2Layout.createSequentialGroup()
                    .addContainerGap(126, Short.MAX_VALUE)
                    .addComponent(about, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(126, Short.MAX_VALUE)))
        );

        bgrnd.setLayout(new javax.swing.OverlayLayout(bgrnd));

        dspDate.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        dspDate.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane3.add(dspDate);
        dspDate.setBounds(1010, 70, 110, 20);

        dspTime.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        dspTime.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane3.add(dspTime);
        dspTime.setBounds(1160, 70, 100, 20);

        label.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        label.setForeground(new java.awt.Color(51, 51, 51));
        jLayeredPane3.add(label);
        label.setBounds(360, 60, 160, 40);

        jLabel65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jLayeredPane3.add(jLabel65);
        jLabel65.setBounds(360, 60, 70, 40);

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/brrr.png"))); // NOI18N
        jLayeredPane3.add(jLabel60);
        jLabel60.setBounds(279, 60, 990, 40);

        bgrnd.add(jLayeredPane3);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bgrng1.jpg"))); // NOI18N
        bgrnd.add(jLabel1);

        main1.setLayer(bgrnd, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout main1Layout = new javax.swing.GroupLayout(main1);
        main1.setLayout(main1Layout);
        main1Layout.setHorizontalGroup(
            main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2556, Short.MAX_VALUE)
            .addGroup(main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bgrnd))
        );
        main1Layout.setVerticalGroup(
            main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bgrnd, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
        );

        main.setLayer(main2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        main.setLayer(main1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2556, Short.MAX_VALUE)
            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(main2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(main1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 802, Short.MAX_VALUE)
            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(main2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(main1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jDesktopPane1.add(main);

        jScrollPane1.setViewportView(jDesktopPane1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Boolean homeClicked=true,staffClicked=false,premiumClicked=false,aboutClicked=false,policyClicked=false,loginClicked=false;
    public void bClicked(String click)
    {
    if(click=="home")
    {
      homeClicked=true;
      staffClicked=false;
      premiumClicked=false;
      aboutClicked=false;
      policyClicked=false;
      loginClicked=false;
      jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home3.png")));
      jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/staff1.png")));
      jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/premium1.png")));
      jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
      jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy1.png")));
      jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg1.png")));
    }
    if(click=="staff")
    {
      homeClicked=false;
      staffClicked=true;
      premiumClicked=false;
      aboutClicked=false;
      policyClicked=false;
      loginClicked=false;
      jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/staff3.png")));
      jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home1.png")));
      jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/premium1.png")));
      jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
      jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy1.png")));
      jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg1.png")));
    }
    if(click=="premium")
    {
      homeClicked=false;
      staffClicked=false;
      premiumClicked=true;
      aboutClicked=false;
      policyClicked=false;
      loginClicked=false;
      jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/premium3.png")));
      jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/staff1.png")));
      jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home1.png")));
      jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
      jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy1.png")));
      jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg1.png")));
    }
    if(click=="about")
    {
        aboutClicked=true;
        homeClicked=false;
      staffClicked=false;
      premiumClicked=false;
      policyClicked=false;
      loginClicked=false;
      jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/premium1.png")));
      jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/staff1.png")));
      jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home1.png")));
      jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts3.png")));
      jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy1.png")));
      jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg1.png")));
    }
    if(click=="policy")
    {
        aboutClicked=false;
        homeClicked=false;
      staffClicked=false;
      premiumClicked=false;
      policyClicked=true;
      loginClicked=false;
      jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/premium1.png")));
      jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/staff1.png")));
      jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home1.png")));
      jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
      jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy3.png")));
      jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg1.png")));
    }
    if(click=="login")
    {
        aboutClicked=false;
        homeClicked=false;
      staffClicked=false;
      premiumClicked=false;
      policyClicked=false;
      loginClicked=true;
      jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/premium1.png")));
      jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/staff1.png")));
      jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home1.png")));
      jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
      jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy1.png")));
      jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg3.png")));
    }
    }
    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        if(homeClicked==false)
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home2.png")));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        if(homeClicked==false)
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home1.png")));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
//        homeClicked=true;
//        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home3.png")));
        bClicked("home");
        label.setText("");
        layerRemoveAll(main2);
        layerAdd(main2,sbar);
        layerAdd(main2,home);
        
       
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
        if(staffClicked==false)
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/staff2.png")));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        if(staffClicked==false)
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/staff1.png")));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        
        bClicked("staff");
        label.setText("Staff");
        layerRemoveAll(page);
        layerRemoveAll(main2);
        layerAdd(main2,sbar);
        layerAdd(main2,page);
        layerAdd(main2,exbar);
        
        //page.remove(pageBack);
        
        layerRemoveAll(staff);
        
        layerAdd(page,staff);
        layerAdd(staff,staffOp);
        layerAdd(staff,staffAdd);
        
        //dialog.setAlwaysOnTop(true);
        //dialog.show(true);
        
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add2.png")));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view1.png")));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update1.png")));
        
        setRandom(empid);
        
//        int p=jScrollPane6.getRootPane().getX();
//         int p1=exbar.getX();
//            System.err.println(p+"------"+p1);
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        if(premiumClicked==false)
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/premium2.png")));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        if(premiumClicked==false)
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/premium1.png")));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
         bClicked("premium");
         label.setText("Premium");
         layerRemoveAll(page);
          layerRemoveAll(main2);
          layerAdd(main2,sbar);
        layerAdd(main2,page);
        layerAdd(main2,exbar);
        layerAdd(page,premium);
        layerRemoveAll(premium);
        layerAdd(premium,prmView);
        layerAdd(premium,premiumOp);
        layerAdd(premium,pageBack5);
        tv.setSelectedIndex(-1);
        prView();
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        //label.setText("Staff > Add");
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add2.png")));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view1.png")));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update1.png")));
        layerRemoveAll(staff);
        layerAdd(staff,staffOp);
        layerAdd(staff,staffAdd);
        outputimg=null;
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        //label.setText("Staff > Update");
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update2.png")));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view1.png")));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add1.png")));
        
        layerRemoveAll(staff);
        layerAdd(staff,staffOp);
        layerAdd(staff,updateOp);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        //label.setText("Staff > View");
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view2.png")));
         jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add1.png")));
          jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update1.png")));
          
          layerRemoveAll(staff);
        layerAdd(staff,staffOp);
        layerAdd(staff,viewOp);
        getStaff();
    }//GEN-LAST:event_jLabel8MouseClicked

    
    void getStaff()
    {
        int count=0;
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] { {}},
    new String [] {"Emp Id", "First Name", "Last Name", "DOB", "sex", "Designation", "permenant Addsress", "Start Date", "phone No"}));
       try
       {
        String query,query2;
        Database db=new Database();
            db.jdbcConnect();
            query  ="Select * from employee";
             System.out.println(query);
//            db.stmt=conn.createStatement();
//            db.rs=db.stmt.executeQuery("we");
            db.p=db.conn.prepareStatement(query);
            db.rs=db.p.executeQuery(query);
            while(db.rs.next())
            {
                count++;
                   //Object[] row={"dsfd","sd","ssd","sds","dsd","ssdf","fdf","fdf","dfed"};
                     Object[] row={db.rs.getString("Employee_Id"),db.rs.getString("First_Name"),db.rs.getString("Last_Name"),String.valueOf(db.rs.getDate("DOB")),db.rs.getString("sex"),db.rs.getString("Designation"),db.rs.getString("P_Address"),String.valueOf(db.rs.getDate("Start_Date")),db.rs.getString("M_Phone_No")};
                    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                    model.addRow(row);
                
            }
            db.p.close();
            db.rs.close();
            db.conn.close();
            total.setText(String.valueOf(count));
            
        }
        catch(Exception e)
        {
            System.err.println("staff print erroor");
            System.out.println(e);
        }
        
        
        
        
        
        
    }
    
    
    
    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
            try {
           selectImgOfEmployee(img1); 
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        // TODO add your handling code here:
            try {
           selectImgOfEmployee(img2); 
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel47MouseClicked

    private void jLayeredPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLayeredPane1MouseClicked
        // TODO add your handling code here:
        updateClicked(jTextField22.getText());
  
    }//GEN-LAST:event_jLayeredPane1MouseClicked

    private void jLabel64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel64MouseClicked
        // TODO add your handling code here:
        bClicked("about");
        label.setText("About Us");
          layerRemoveAll(main2);
        layerAdd(main2,sbar);
        layerAdd(main2,about);
        setAbout();
    }//GEN-LAST:event_jLabel64MouseClicked

    private void jLabel64MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel64MouseEntered
        // TODO add your handling code here:
        
        if(aboutClicked==false)
             jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts2.png")));
    }//GEN-LAST:event_jLabel64MouseEntered

    private void jLabel64MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel64MouseExited
        // TODO add your handling code here:
         if(aboutClicked==false)
             jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abts1.png")));
    }//GEN-LAST:event_jLabel64MouseExited

    private void jLabel58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseClicked
        // TODO add your handling code here:
        
        submittButton();
        y_fol_lonh=10;
         addEmployeeToTheEmployeeShown();
       // qual.addItem("we");
        //System.out.print("dfdgdxsdg");
        
    }//GEN-LAST:event_jLabel58MouseClicked

    private void emptyFields(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emptyFields
        // TODO add your handling code here:
        emptyFields();
        setRandom(empid);
    }//GEN-LAST:event_emptyFields

    private void jLabel69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel69MouseClicked
        // TODO add your handling code here:
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update2.png")));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view1.png")));
       layerRemoveAll(premium);
        layerAdd(premium,premiumOp);
        layerAdd(premium,prmUpdate);
      
        
       /// layerAdd(premium,pageBack5);
    }//GEN-LAST:event_jLabel69MouseClicked

    private void jLabel68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel68MouseClicked
        // TODO add your handling code here:
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update1.png")));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view2.png")));
        //layerRemoveAll(premium);
      
       
        layerRemoveAll(premium);
        layerAdd(premium,prmView);
        layerAdd(premium,premiumOp);
        layerAdd(premium,pageBack5);
        
       // Private Cars, Two Wheelers, Goods Carrying Vehicles, Vhcls for Hire(upto 6 Pass), Vhcls for Hire(above 6 Pass), 3 WHR PASS carriying
       // layerAdd(premium,pageBack5);
    }//GEN-LAST:event_jLabel68MouseClicked

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
         
        if(tv.getSelectedItem()=="Private Cars"||tv.getSelectedItem()=="Two Wheelers"||tv.getSelectedItem()=="Goods Carrying Vehicles")
        {
            av.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "upto 5","5-10","above 10" }));
        }
        if(tv.getSelectedItem()=="Vhcls for Hire(upto 6 Pass)"||tv.getSelectedItem()=="Vhcls for Hire(above 6 Pass)"||tv.getSelectedItem()=="3 WHR PASS carriying")
        {
            av.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "upto 5","5-10","above 10" }));
        }
    }//GEN-LAST:event_tvActionPerformed

    private void avActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avActionPerformed
        // TODO add your handling code here:
        String type=(String) tv.getSelectedItem();
        String c=(String) cc.getSelectedItem();
         String age=(String) av.getSelectedItem();
         if(tv.getSelectedItem()!=null&&cc.getSelectedItem()!=null&&av.getSelectedItem()!=null)
         {
         try
         {
            Database db=new Database();
            String query=""; 
            db.jdbcConnect();
            query="Select * from tarif where cc='"+c+"' and tv='"+type+"'";
             System.out.println(query);
//            db.stmt=conn.createStatement();
//            db.rs=db.stmt.executeQuery("we");
            db.p=db.conn.prepareStatement(query);
            db.rs=db.p.executeQuery(query);
             System.err.println("nooo Excptnnnn");
             while(db.rs.next())
             {
               // dp.setText(db.rs.getString(""));
                tp.setText(db.rs.getString("tp"));
                pa.setText(db.rs.getString("pa"));
                wc.setText(db.rs.getString("wc"));
                pass.setText(db.rs.getString("pass"));
                od.setText(db.rs.getString(age));
             }
             db.p.close();
             db.rs.close();
             db.conn.close();
            
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         }
        //System.err.println(type);
    }//GEN-LAST:event_avActionPerformed

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

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
         if(jCheckBox2.isSelected()==true)
        {
        cadd2.setText(padd2.getText());
        }
        if(jCheckBox2.isSelected()==false)
        {
        cadd2.setText("");
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jTextField22FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField22FocusGained
        // TODO add your handling code here:
       
        if(false)
        {
             System.out.println(jTextField22.getText());
        jTextField22.setText("");
        }
    }//GEN-LAST:event_jTextField22FocusGained

    private void jTextField22FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField22FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22FocusLost

    private void jLabel86MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel86MouseClicked
        // TODO add your handling code here:
        layerRemoveAll(staff);
         layerAdd(staff,staffOp);
        layerAdd(staff,updateOp);
        jTextField22.setText("");
    }//GEN-LAST:event_jLabel86MouseClicked

    private void jLabel85MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel85MouseClicked
        // TODO add your handling code here:
       submittButton2();
//        //ms.
//        ms.removeAll();
//        ms.repaint();
//        ms.revalidate();
//        ms.setSize(228,668);
            y_fol_lonh=10;
         //ms.setPreferredSize(new java.awt.Dimension(228,668));
         addEmployeeToTheEmployeeShown();
    }//GEN-LAST:event_jLabel85MouseClicked

    private void srchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchActionPerformed
        // TODO add your handling code here:
         y_fol_lonh=10;
        scrch();
    }//GEN-LAST:event_srchActionPerformed

    private void srchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srchKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_srchKeyPressed

    private void srchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srchKeyTyped
        // TODO add your handling code here:
       y_fol_lonh=10;
        scrch();
    }//GEN-LAST:event_srchKeyTyped

    private void srchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_srchFocusLost
        // TODO add your handling code here:
//        y_fol_lonh=10;
//        srch.setText("");
//        addEmployeeToTheEmployeeShown();
    }//GEN-LAST:event_srchFocusLost

    private void jLabel94MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel94MouseClicked
        // TODO add your handling code here:
        y_fol_lonh=10;
        scrch();
    }//GEN-LAST:event_jLabel94MouseClicked

    private void jLabel91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseClicked
        // TODO add your handling code here:
        
        int temp=JOptionPane.showConfirmDialog(this,"Are you sure you want to delete employee details");
        if(temp==0)
        {
        empDelete(empid3.getText());
        bClicked("staff");
        label.setText("Staff");
        layerRemoveAll(page);
        layerRemoveAll(main2);
        layerAdd(main2,sbar);
        layerAdd(main2,page);
        layerAdd(main2,exbar);
        
        //page.remove(pageBack);
        
        layerRemoveAll(staff);
        
        layerAdd(page,staff);
        layerAdd(staff,staffOp);
        layerAdd(staff,staffAdd);
        
        setRandom(empid);
        y_fol_lonh=10;
        addEmployeeToTheEmployeeShown();
        }
    }//GEN-LAST:event_jLabel91MouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        // TODO add your handling code here:
         updateClicked(empid3.getText());
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel89MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel89MouseClicked
        // TODO add your handling code here:
        premium.remove(prmUpdate);
        premium.revalidate();
        premium.repaint();
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update1.png")));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view2.png")));
        layerAdd(premium,prmView);
        layerAdd(premium,pageBack5);
        //layerRemoveAll(premium);
        tv.setSelectedIndex(-1);
    }//GEN-LAST:event_jLabel89MouseClicked

    private void jLabel88MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel88MouseClicked
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this,"Are you sure you want to update")==0)
        {
        String query;
        try
        {
            Database db=new Database();
            db.jdbcConnect();
            query  ="Update tarif set tp="+tp.getText()+",pa="+pa.getText()+",pass="+pass.getText()+",wc="+wc.getText()+",`"+(String) av.getSelectedItem()+"`="+od.getText()+" where cc='"+(String) cc.getSelectedItem()+"' and tv='"+(String) tv.getSelectedItem()+"'";
             System.out.println(query);
//            db.stmt=conn.createStatement();
//            db.rs=db.stmt.executeQuery("we");
            db.p=db.conn.prepareStatement(query);
            int r=db.p.executeUpdate(query);
            JOptionPane.showMessageDialog(this,"premium chart updated sucessfully");
//            if(r>=1)
//            {
//                
//            }
//            System.out.println(r);
            db.p.close();
            db.conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Delete exception");
        }
        }
    }//GEN-LAST:event_jLabel88MouseClicked

    private void ok1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok1ActionPerformed
        // TODO add your handling code here:
       // checker=true;
        //o.setVisible(true);
    }//GEN-LAST:event_ok1ActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        //checker=false;
        //o.setVisible(false);
    }//GEN-LAST:event_cancelActionPerformed

    private void jLabel58MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseEntered
        // TODO add your handling code here:
        jLabel58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel58MouseEntered

    private void jLabel58MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseExited
        // TODO add your handling code here:
        jLabel58.setBorder(null);
    }//GEN-LAST:event_jLabel58MouseExited

    private void jLabel59MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseEntered
        // TODO add your handling code here:
        jLabel59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel59MouseEntered

    private void jLabel59MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseExited
        // TODO add your handling code here:
        jLabel59.setBorder(null);
    }//GEN-LAST:event_jLabel59MouseExited

    private void jLabel85MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel85MouseEntered
        // TODO add your handling code here:
        jLabel85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel85MouseEntered

    private void jLabel85MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel85MouseExited
        // TODO add your handling code here:
        jLabel85.setBorder(null);
    }//GEN-LAST:event_jLabel85MouseExited

    private void jLabel86MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel86MouseEntered
        // TODO add your handling code here:
        jLabel86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel86MouseEntered

    private void jLabel86MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel86MouseExited
        // TODO add your handling code here:
        jLabel86.setBorder(null);
    }//GEN-LAST:event_jLabel86MouseExited

    private void jLabel40MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseEntered
        // TODO add your handling code here:
        jLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel40MouseEntered

    private void jLabel40MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseExited
        // TODO add your handling code here:
        jLabel40.setBorder(null);
    }//GEN-LAST:event_jLabel40MouseExited

    private void jLabel91MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseEntered
        // TODO add your handling code here:
        jLabel91.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel91MouseEntered

    private void jLabel91MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseExited
        // TODO add your handling code here:
         jLabel91.setBorder(null);
    }//GEN-LAST:event_jLabel91MouseExited

    private void jLabel88MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel88MouseEntered
        // TODO add your handling code here:
         jLabel88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel88MouseEntered

    private void jLabel88MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel88MouseExited
        // TODO add your handling code here:
        jLabel88.setBorder(null);
    }//GEN-LAST:event_jLabel88MouseExited

    private void jLabel89MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel89MouseEntered
        // TODO add your handling code here:
        jLabel89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
    }//GEN-LAST:event_jLabel89MouseEntered

    private void jLabel89MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel89MouseExited
        // TODO add your handling code here:
        jLabel89.setBorder(null);
    }//GEN-LAST:event_jLabel89MouseExited

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
        viewClicked(jTextField24.getText());
    }//GEN-LAST:event_jTextField24ActionPerformed

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

    private void mphn2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mphn2KeyTyped
        // TODO add your handling code here:
        char enter=evt.getKeyChar();
        if(!(Character.isDigit(enter)))
            evt.consume();
    }//GEN-LAST:event_mphn2KeyTyped

    private void lphn2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lphn2KeyTyped
        // TODO add your handling code here:
        char enter=evt.getKeyChar();
        if(!(Character.isDigit(enter)))
            evt.consume();
    }//GEN-LAST:event_lphn2KeyTyped

    private void jLabel103MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel103MouseClicked
        // TODO add your handling code here:
        bClicked("policy");
        label.setText("Policy");
        layerRemoveAll(main2);
        layerAdd(main2,sbar);
        layerAdd(main2,exbar);
        layerAdd(main2,page);
        layerRemoveAll(page);
        layerAdd(page,policy);
        
        
        jLabel105.setForeground(new java.awt.Color(255, 0, 0));
        jLabel106.setForeground(new java.awt.Color(0, 0, 0));
        jLabel107.setForeground(new java.awt.Color(0, 0, 0));
        layerRemoveAll(policy);
        layerAdd(policy,policyOP);
        layerAdd(policy,active);
        layerAdd(policy,pageBack);
        custDisp2();
    }//GEN-LAST:event_jLabel103MouseClicked

    
     void custDisp2()
    {
        
        expired1.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {},new String [] {"Policy No", "Customer Id", "Policy Type", "Insured Name", "Vehicle Reg No", "Start Date", "End Date", "Policy Amount"}));
        
        tExpired1.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {},new String [] {"Policy No", "Customer Id", "Policy Type", "Insured Name", "Vehicle Reg No", "Start Date", "End Date", "Policy Amount"}));
        
        active1.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {},new String [] {"Policy No", "Customer Id", "Policy Type", "Insured Name", "Vehicle Reg No", "Start Date", "End Date", "Policy Amount"}));
        
        System.err.println("");
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
                if(db.rs.getString("status").equals("expired")||db.rs.getString("status").equals("Expired"))
                {
                Object[] row={db.rs.getString("policy_no"),db.rs.getString("cust_id"),db.rs.getString("insurance_type"),db.rs.getString("fname")+" "+db.rs.getString("lname"),db.rs.getString("vehicle_reg_no"),db.rs.getString("start_date"),db.rs.getString("end_date"),db.rs.getString("insurance_amount")};
                    DefaultTableModel model1=(DefaultTableModel)expired1.getModel();
                    model1.addRow(row);
                    //total.setText(db.rs.getString("policy_no"));
                }
                if(db.rs.getString("status").equals("active")||db.rs.getString("status").equals("Active"))
                {
                Object[] row={db.rs.getString("policy_no"),db.rs.getString("cust_id"),db.rs.getString("insurance_type"),db.rs.getString("fname")+" "+db.rs.getString("lname"),db.rs.getString("vehicle_reg_no"),db.rs.getString("start_date"),db.rs.getString("end_date"),db.rs.getString("insurance_amount")};
                    DefaultTableModel model2=(DefaultTableModel)active1.getModel();
                    model2.addRow(row);
                    //total.setText(db.rs.getString("policy_no"));
                } 
                 
                 if(sdf1.format(Calendar.getInstance().getTime()).equals(sdf1.format(db.rs.getDate("end_date")))&&(db.rs.getString("status").equals("active")||db.rs.getString("status").equals("Active")))
                 {
                     Object[] row={db.rs.getString("policy_no"),db.rs.getString("cust_id"),db.rs.getString("insurance_type"),db.rs.getString("fname")+" "+db.rs.getString("lname"),db.rs.getString("vehicle_reg_no"),db.rs.getString("start_date"),db.rs.getString("end_date"),db.rs.getString("insurance_amount")};
                    DefaultTableModel model3=(DefaultTableModel)tExpired1.getModel();
                    model3.addRow(row);
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
    
    
    
    
    
    
    private void jLabel103MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel103MouseEntered
        // TODO add your handling code here:
        if(policyClicked==false)
            jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy2.png")));
    }//GEN-LAST:event_jLabel103MouseEntered

    private void jLabel103MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel103MouseExited
        // TODO add your handling code here:
        if(policyClicked==false)
            jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/policy1.png")));
    }//GEN-LAST:event_jLabel103MouseExited

    private void jLabel104MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel104MouseClicked
        // TODO add your handling code here:
        bClicked("login");
        layerRemoveAll(main2);
        layerAdd(main2,log);
        layerAdd(main2,sbar);
        //layerAdd(main2,pageBack);
    }//GEN-LAST:event_jLabel104MouseClicked

    private void jLabel104MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel104MouseEntered
        // TODO add your handling code here:
        if(loginClicked==false)
            jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg2.png")));
    }//GEN-LAST:event_jLabel104MouseEntered

    private void jLabel104MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel104MouseExited
        // TODO add your handling code here:
        if(loginClicked==false)
            jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/lg1.png")));
    }//GEN-LAST:event_jLabel104MouseExited

    private void jLabel106MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel106MouseClicked
        // TODO add your handling code here:
        jLabel105.setForeground(new java.awt.Color(0, 0, 0));
        jLabel106.setForeground(new java.awt.Color(255, 0, 0));
        jLabel107.setForeground(new java.awt.Color(0, 0, 0));
        layerRemoveAll(policy);
        layerAdd(policy,policyOP);
        layerAdd(policy,expired);
        layerAdd(policy,pageBack);
        custDisp2();
    }//GEN-LAST:event_jLabel106MouseClicked

    private void jLabel105MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel105MouseClicked
        // TODO add your handling code here:
        jLabel105.setForeground(new java.awt.Color(255, 0, 0));
        jLabel106.setForeground(new java.awt.Color(0, 0, 0));
        jLabel107.setForeground(new java.awt.Color(0, 0, 0));
        layerRemoveAll(policy);
        layerAdd(policy,policyOP);
        layerAdd(policy,active);
        layerAdd(policy,pageBack);
        custDisp2();
    }//GEN-LAST:event_jLabel105MouseClicked

    private void jLabel107MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel107MouseClicked
        // TODO add your handling code here:
        jLabel105.setForeground(new java.awt.Color(0, 0, 0));
        jLabel106.setForeground(new java.awt.Color(0, 0, 0));
        jLabel107.setForeground(new java.awt.Color(255, 0, 0));
        layerRemoveAll(policy);
        layerAdd(policy,policyOP);
        layerAdd(policy,tExpired);
        layerAdd(policy,pageBack);
        custDisp2();
    }//GEN-LAST:event_jLabel107MouseClicked

    private void jLabel108MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel108MouseClicked
        // TODO add your handling code here:
        layerRemoveAll(main2);
        layerAdd(main2,sbar);
        main2.add(change,3);
        main2.repaint();
        main2.revalidate();
        main2.remove(log);
        main2.repaint();
        main2.revalidate();
    }//GEN-LAST:event_jLabel108MouseClicked

    private void jLabel108MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel108MouseEntered
        // TODO add your handling code here:
        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/chg2.png")));
    }//GEN-LAST:event_jLabel108MouseEntered

    private void jLabel108MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel108MouseExited
        // TODO add your handling code here:
        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/chg1.png")));
    }//GEN-LAST:event_jLabel108MouseExited

    private void jLabel109MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel109MouseClicked
        // TODO add your handling code here:
        login l=new login();
        l.show();
        this.dispose();
    }//GEN-LAST:event_jLabel109MouseClicked

    private void jLabel109MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel109MouseEntered
        // TODO add your handling code here:
        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/logout2.png")));
    }//GEN-LAST:event_jLabel109MouseEntered

    private void jLabel109MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel109MouseExited
        // TODO add your handling code here:
        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/logout1.png")));
    }//GEN-LAST:event_jLabel109MouseExited

    private void logMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logMouseExited
        // TODO add your handling code here:
        main2.remove(log);
        main2.repaint();
        main2.revalidate();
        // page.setVisible(true);
    }//GEN-LAST:event_logMouseExited

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
            query="Select * from login_admin where Employee_Id='"+cUserId+"'";
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
                        query="update login_admin set Password='"+newpass.getText()+"' where Employee_Id='"+cUserId+"'";
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


void scrch()
{
            ms.removeAll();
            ms.repaint();
            ms.revalidate();
           Database mysqlitem = new Database();
           mysqlitem.jdbcConnect();
String query = "select * from employee where Employee_Id like '"+srch.getText()+"%' or First_Name like '"+srch.getText()+"%' ORDER BY `First_Name` ASC ";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.conn.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);

          
           while( mysqlitem.rs.next()){ 
               try {
                   
               
              //if(mysqlitem.rs.getString("satus").equals("employee"))
          addInTheScrollPaneInMain(mysqlitem.rs.getString("Employee_Id"),mysqlitem.rs.getString("Last_Name"),mysqlitem.rs.getString("First_Name"),""+mysqlitem.rs.getLong("M_Phone_No"),mysqlitem.rs.getBytes("Photo"));
 } catch (Exception e) {
               }
             }
System.out.println("success");
                  mysqlitem.rs.close();
               mysqlitem.p.close();
            mysqlitem.conn.close();
        }
        catch(Exception e1){
            System.out.println("zxError"+e1);
             
           
        }

       ms.repaint();
        ms.revalidate();
}











////////////////////////////////////////////
  /////////////////////////////////////////////////////updateFieldCheck()/////////////////////////////////  
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
                eid=db.rs.getString("Employee_Id");
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
    
    
    ////////////////////////////////////////////
  /////////////////////////////////////////////////////updateFieldCheck()/////////////////////////////////  
    
    void viewClicked(String s)
    {
        if(updateFieldCheck("Employee_Id","employee",s))
         {
            
              bClicked("staff");
        label.setText("Staff");
        layerRemoveAll(page);
        layerRemoveAll(main2);
        layerAdd(main2,sbar);
        layerAdd(main2,page);
        layerAdd(main2,exbar);
        
        //page.remove(pageBack);
        
        layerRemoveAll(staff);
        
        layerAdd(page,staff);
        layerAdd(staff,staffOp);
        layerAdd(staff,staffAdd);
             
             
             
        layerRemoveAll(staff);
         layerAdd(staff,staffOp);
         
        layerAdd(staff,staffView);
        layerAdd(staff,pageBack);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add1.png")));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view2.png")));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update1.png")));
        
                String query;
                 try
                 {
                     //jTextField22
                     Database db=new Database();
                     db.jdbcConnect();
                     query  ="select * from employee where Employee_Id='"+s+"'";
                     db.p=db.conn.prepareStatement(query);
                     db.rs=db.p.executeQuery(query);
                     while(db.rs.next())
                     {
                        empid3.setText(db.rs.getString("Employee_Id"));
                        desig3.setText(db.rs.getString("Designation"));
                        fname3.setText(db.rs.getString("First_name"));
                        lname3.setText(db.rs.getString("Last_name"));
                            if(db.rs.getString("sex").equals("M"))
                            { 
                                sex3.setText("Male"); 
                            }
                            else
                            {
                                 sex3.setText("Female");
                             }
                            
                         padd3.setText(db.rs.getString("P_Address"));
                        cadd3.setText(db.rs.getString("C_Address"));
                        qual3.setText(db.rs.getString("Qualification"));
                        exp3.setText(db.rs.getString("Experience")); 
                        eid3.setText(db.rs.getString("Email_Id")); 
                        mphn3.setText(db.rs.getString("M_Phone_No"));
                        lphn3.setText(db.rs.getString("L_Phone_No"));
                        acc3.setText(db.rs.getString("Acc_No"));
                        sal3.setText(db.rs.getString("Salary"));
                        byte[] imageInByte =db.rs.getBytes("Photo");
                        outputimg=imageInByte;
                        ImageIcon format = null;
                        format = new ImageIcon(imageInByte);
                         img3.setIcon(format);
                        dob3.setText(db.rs.getString("DOB"));
                        sdate3.setText(db.rs.getString("Start_Date"));
                     }
                       
                       
//                        String query2="Select Employee_Id from login_staff";
//                        db.p=db.conn.prepareStatement(query2);
//                        ResultSet r=db.p.executeQuery(query2);
//                        while(r.next())
//                        {
//                            
//                            if(r.getString("Employee_Id").equals(empid2.getText()))
//                            {
//                                System.err.println("dfdfdfdfdfd");
//                                ca1.setSelected(true);
//                            }
//                        
//                        }
                        
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
             JOptionPane.showMessageDialog(this,"invalid employee id");
         }
         
    }
    
    
    
    void updateClicked(String value)
    {
               if(updateFieldCheck("Employee_Id","employee",value))
         {
             
              bClicked("staff");
        label.setText("Staff");
        layerRemoveAll(page);
        layerRemoveAll(main2);
        layerAdd(main2,sbar);
        layerAdd(main2,page);
        layerAdd(main2,exbar);
        
        //page.remove(pageBack);
        
        layerRemoveAll(staff);
        
        layerAdd(page,staff);
        layerAdd(staff,staffOp);
        layerAdd(staff,staffAdd);
             
             
             
        layerRemoveAll(staff);
         layerAdd(staff,staffOp);
        layerAdd(staff,staffUpdate);
         jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add1.png")));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view1.png")));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update2.png")));
        
                String query;
                 try
                 {
                     //jTextField22
                     Database db=new Database();
                     db.jdbcConnect();
                     query  ="select * from employee where Employee_Id='"+value+"'";
                     db.p=db.conn.prepareStatement(query);
                     db.rs=db.p.executeQuery(query);
                     while(db.rs.next())
                     {
                        empid2.setText(db.rs.getString("Employee_Id"));
                        desig2.setText(db.rs.getString("Designation"));
                        fname2.setText(db.rs.getString("First_name"));
                        lname2.setText(db.rs.getString("Last_name"));
                            if(db.rs.getString("sex").equals("M"))
                            { 
                                male1.setSelected(true); 
                            }
                            else
                            {
                                 female2.setSelected(true);
                             }
                            
                         padd2.setText(db.rs.getString("P_Address"));
                        cadd2.setText(db.rs.getString("C_Address"));
                        qual2.setSelectedItem(db.rs.getString("Qualification"));
                        exp2.setText(db.rs.getString("Experience")); 
                        eid2.setText(db.rs.getString("Email_Id")); 
                        mphn2.setText(db.rs.getString("M_Phone_No"));
                        lphn2.setText(db.rs.getString("L_Phone_No"));
                        acc2.setText(db.rs.getString("Acc_No"));
                        sal2.setText(db.rs.getString("Salary"));
                        byte[] imageInByte =db.rs.getBytes("Photo");
                        outputimg=imageInByte;
                        ImageIcon format = null;
                        format = new ImageIcon(imageInByte);
                         img2.setIcon(format);
                        dob2.setDate(db.rs.getDate("DOB"));
                        sdate2.setDate(db.rs.getDate("Start_Date"));
                     }
                       
                       
                        String query2="Select Employee_Id from login_staff";
                        db.p=db.conn.prepareStatement(query2);
                        ResultSet r=db.p.executeQuery(query2);
                        while(r.next())
                        {
                            
                            if(r.getString("Employee_Id").equals(empid2.getText()))
                            {
                                System.err.println("dfdfdfdfdfd");
                                ca1.setSelected(true);
                            }
                        
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
             JOptionPane.showMessageDialog(this,"invalid employee id");
         }
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    void submittButton()
    {
        ErrorNotification en=new ErrorNotification();
        String dob="";
        String sdate="";
        String sex="";
        String enddate="";
        int excptn=1;
        
        try
        {
            dob=sdf.format(dob1.getDate());
            sdate=sdf.format(sdate1.getDate());
            
            Calendar fdob= Calendar.getInstance();
             fdob.setTime(dob1.getDate());
            fdob.add(Calendar.YEAR,56);
            
            enddate=sdf.format(fdob.getTime());
            //JOptionPane.showMessageDialog(this,enddate);
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
            JTextField[] a={empid,desig,fname,lname,exp,mphn,lphn,eid,accno};
           // a[0]=empid;a[1]=desig;
     
//            if(empid.getText().length()==0||desig.getText().length()==0||
//              fname.getText().length()==0||lname.getText().length()==0||dob.length()==0||sex.length()==0||
//              padd.getText().length()==0||cadd.getText().length()==0||sdate.length()==0||exp.getText().length()==0||
//              mphn.getText().length()==0||lphn.getText().length()==0||eid.getText().length()==0||accno.getText().length()==0||
//              sal.getText().length()==0)
//                {            
//                    for(int i=0;i<13;i++)
//                    {
//                        if(a[i].getText().length()==0)
//                        {
//                            en.setErrorForTextField("Field cannot be empty",a[i],this,page,3000,0);
//                        }
//                    }
//                             return;
//                }
             
            // void setErrorForTextField(String message, JTextField field, JFrame frame, int time)
             // System.out.println(page.getX());
              if(empid.getText().length()>10)
             {
                 en.setErrorForTextField("invalid empoyee id",empid,this,page,3000,0); 
                  return;
             }
             if(fname.getText().length()>15||fname.getText().length()<2)
             {
                 en.setErrorForTextField("invalid value",fname,this,page,3000,0);   
                  return;
             }
             if(lname.getText().length()>15||lname.getText().length()<2)
             {
                 en.setErrorForTextField("invalid value",lname,this,page,3000,0);
                  return;
             }
              if(fdob.getTime().before(dob1.getDate()))
                {
                    en.setErrorForTextField("invalid date of birth",lname,this,page,3000,45);
                        return;
                 }
              
               if(Integer.parseInt(exp.getText())>30)
              {
                  en.setErrorForTextField("Experience is too long",exp,this,page,3000,0);
                   return;
              }
            
             if(mphn.getText().length()>10||mphn.getText().length()<10)
             {
                 en.setErrorForTextField("invalid phone no",mphn,this,page,3000,0);
                  return;
             }
             if(lphn.getText().length()>10||lphn.getText().length()<7)
             {
                 en.setErrorForTextField("invalid phone no",lphn,this,page,3000,0); 
                  return;
             }

             String eMailVa
                        = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                String eMaiL = eid.getText();
             if(!eMaiL.matches(eMailVa))
             {
                  en.setErrorForTextField("invalid email id",eid,this,page,3000,0);
                   return;
             }
             if(Integer.parseInt(sal.getText())<1000||sal.getText().length()>7)
             {
                 if(Integer.parseInt(sal.getText())<1000)
                 {
                 en.setErrorForTextField("salary is too low",sal,this,page,3000,0);
                 return;
                 }
                 if(sal.getText().length()>7)
                 {
                 en.setErrorForTextField("salary is too long",sal,this,page,3000,0);
                 return;
                 }
                  
             }
             
              if(accno.getText().length()>12||accno.getText().length()<5)
              {
                  en.setErrorForTextField("invalid account numder",accno,this,page,3000,0);
                   return;
              }
              
              
               
        }    
        catch(NullPointerException q)
        {
            //JOptionPane.showMessageDialog(this,"Please fill all the fields");
            if(dob1.getDate()==null)
            {
                 en.setErrorForTextField("invalid date of birth",lname,this,page,3000,45);
                 return;
            }
            if(sdate1.getDate()==null)
            {
                 en.setErrorForTextField("invalid Start date",exp,this,page,3000,-55);
                 return;
            }
            System.err.println(q);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        String query="";
        try
        {
            Database db=new Database();
            db.jdbcConnect();
            query  = "INSERT INTO employee"
                + " VALUES('" + empid.getText() + "','" + desig.getText() + "','" + fname.getText() + "','" +lname.getText()
                + "','" +dob+"','"+sex+"','"+padd.getText() + "','" +cadd.getText() + "','" +qual.getSelectedItem().toString()
                    +"','" +sdate+"','"+exp.getText() + "'," +mphn.getText() + "," +lphn.getText() + ",'" +eid.getText() + "'," 
                    +accno.getText() + "," +sal.getText() + ",?)";
            
            System.out.println(query);
            db.p=db.conn.prepareStatement(query);
            db.p.setBytes(1, outputimg);

            int rs = db.p.executeUpdate();
            
            JOptionPane.showMessageDialog(this, new String("successfully added"));
            excptn=0;
            
            db.p.close();
            db.conn.close();
            
            //db.close();
            
        
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, new String("Error occured"));
            excptn=1;
        }
        if(ca.isSelected()==true)
        {
            if(excptn==0)
            {
                try{
                Database db=new Database();
                db.jdbcConnect();
                query  = "INSERT INTO login_staff values('"+empid.getText() + "','employee')";
                 System.out.println(query);
                db.p=db.conn.prepareStatement(query);

                int rs = db.p.executeUpdate();

                JOptionPane.showMessageDialog(this, new String("successfully added user login"));
               // excptn=0;

                db.p.close();
                db.conn.close();

                }
                catch(Exception e)
                {

                System.out.println("user login not created");
                }
            }
        }
        if(excptn==0)
        {
        emptyFields();
        setRandom(empid);
        }
        
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void submittButton2()
    {
        ErrorNotification en=new ErrorNotification();
        String dob="";
        String sdate="";
        String sex="";
        String enddate="";
        int excptn=1;
        
        try
        {
            dob=sdf.format(dob2.getDate());
            sdate=sdf.format(sdate2.getDate());
            
            Calendar fdob= Calendar.getInstance();
             fdob.setTime(dob2.getDate());
            fdob.add(Calendar.YEAR,56);
            enddate=sdf.format(fdob.getTime());
            fdob=Calendar.getInstance();
            fdob.add(Calendar.YEAR,-18); 
            
            if(male1.isSelected()==true)
            {
                sex="M";
            }
            if(female2.isSelected()==true)
            {
                sex="F";
            }
            
//            if(empid.getText().length()==0||desig.getText().length()==0||
//               fname.getText().length()==0||lname.getText().length()==0||dob.length()==0||sex.length()==0||
//               padd.getText().length()==0||cadd.getText().length()==0||sdate.length()==0||exp.getText().length()==0||
//               mphn.getText().length()==0||lphn.getText().length()==0||eid.getText().length()==0||accno.getText().length()==0||
//               sal.getText().length()==0)
//                {
//                        JOptionPane.showMessageDialog(this,"Please fill all the fields");
//                        return;
//                }
             
            // void setErrorForTextField(String message, JTextField field, JFrame frame, int time)
             // System.out.println(page.getX());
              if(empid2.getText().length()>10)
             {
                 en.setErrorForTextField("invalid empoyee id",empid2,this,page,3000,0); 
                  return;
             }
             if(fname2.getText().length()>15||fname2.getText().length()<=2)
             {
                 en.setErrorForTextField("invalid value",fname2,this,page,3000,0);   
                  return;
             }
             if(lname2.getText().length()>15||lname2.getText().length()<=2)
             {
                 en.setErrorForTextField("invalid value",lname2,this,page,3000,0);
                  return;
             }
              if(fdob.getTime().before(dob2.getDate()))
                {
                    en.setErrorForTextField("invalid date of birth",lname2,this,page,3000,45);
                        return;
                 }
              
               if(Integer.parseInt(exp2.getText())>30)
              {
                  en.setErrorForTextField("Experience is too long",exp2,this,page,3000,0);
                   return;
              }
            
              if(mphn2.getText().length()>10||mphn2.getText().length()<10)
             {
                 en.setErrorForTextField("invalid phone no",mphn2,this,page,3000,0);
                  return;
             }
             if(lphn2.getText().length()>10||lphn2.getText().length()<7)
             {
                 en.setErrorForTextField("invalid phone no",lphn2,this,page,3000,0); 
                  return;
             }
             
             String eMailVa
                        = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                String eMaiL = eid2.getText();
             if(!eMaiL.matches(eMailVa))
             {
                  en.setErrorForTextField("invalid email id",eid2,this,page,3000,0);
                   return;
             }
             if(Integer.parseInt(sal2.getText())<1000||sal2.getText().length()>7)
             {
                 if(Integer.parseInt(sal.getText())<1000)
                 en.setErrorForTextField("salary is too low",sal2,this,page,3000,0);
                 if(sal.getText().length()>7)
                 en.setErrorForTextField("salary is too long",sal2,this,page,3000,0);
                  return;
             }
             
              if(acc2.getText().length()>12||acc2.getText().length()<5)
              {
                  en.setErrorForTextField("invalid account numder",acc2,this,page,3000,0);
                   return;
              }
              
              
               
        }    
        catch(NullPointerException q)
        {
            //JOptionPane.showMessageDialog(this,"Please fill all the fields");
            if(dob2.getDate()==null)
            {
                 en.setErrorForTextField("invalid date of birth",lname2,this,page,3000,45);
                 return;
            }
            if(sdate2.getDate()==null)
            {
                 en.setErrorForTextField("invalid Start date",exp2,this,page,3000,-55);
                 return;
            }
            System.err.println(q);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        String query="";
        try
        {
            Database db=new Database();
            db.jdbcConnect();
//            query  = "INSERT INTO employee"
//                + " VALUES('" + empid.getText() + "','" + desig.getText() + "','" + fname.getText() + "','" +lname.getText()
//                + "','" +dob+"','"+sex+"','"+padd.getText() + "','" +cadd.getText() + "','" +qual.getSelectedItem().toString()
//                    +"','" +sdate+"','"+exp.getText() + "'," +mphn.getText() + "," +lphn.getText() + ",'" +eid.getText() + "'," 
//                    +accno.getText() + "," +sal.getText() + ",?)";
            
             query="update employee set Designation='"+desig2.getText()+"',First_Name='"+fname2.getText()+"',Last_name='"+lname2.getText()+"',DOB='"+dob+"',sex='"
                     +sex+"',P_Address='"+padd2.getText()+"',C_Address='"+cadd2.getText()+"',Qualification='"+qual2.getSelectedItem().toString()+"',Start_Date='"
                     +sdate+"',Experience='"+exp2.getText()+"',M_Phone_no="+mphn2.getText()+",L_Phone_no="+lphn2.getText()+",Email_Id='"+eid2.getText()+"',Acc_No='"
                     +acc2.getText()+"',Salary="+sal2.getText()+",Photo=? where Employee_Id='"+empid2.getText()+"'";
            System.out.println(query);
            db.p=db.conn.prepareStatement(query);
            db.p.setBytes(1, outputimg);

            int rs = db.p.executeUpdate();
            
            JOptionPane.showMessageDialog(this, new String("Employee Details Updated"));
            excptn=0;
            
            db.p.close();
            db.conn.close();
           
            //db.close();
            
        
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, new String("Error occured"));
            excptn=1;
        }
        if(excptn==0)
        {
            if(ca1.isSelected()==true)
            {
                try{
                Database db=new Database();
                db.jdbcConnect();
                query  = "INSERT INTO login_staff values('"+empid2.getText() + "','employee')";
                 System.out.println(query);
                db.p=db.conn.prepareStatement(query);

                int rs = db.p.executeUpdate();

                JOptionPane.showMessageDialog(this, new String("successfully added user login"));
               // excptn=0;

                db.p.close();
                db.conn.close();

                }
                catch(Exception e)
                {

                System.out.println("user login not created");
                }
            }
             if(ca1.isSelected()==false)
             {
                if(updateFieldCheck("Employee_Id","login_staff",empid2.getText()))
                    {
                        try
                        {
                            Database db=new Database();
                            db.jdbcConnect();
                            query  = "delete from login_staff where Employee_Id='"+empid2.getText()+"'";
                             System.out.println(query);
                            db.p=db.conn.prepareStatement(query);

                            int rs = db.p.executeUpdate();

                           // JOptionPane.showMessageDialog(this, new String("successfully added user login"));
                           // excptn=0;

                            db.p.close();
                            db.conn.close();
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                            System.out.println("delete err");
                        }
                    }
            }
        
        }
        if(excptn==0)
        {
         emptyFields2();
          layerRemoveAll(staff);
         layerAdd(staff,staffOp);
        layerAdd(staff,updateOp);
        jTextField22.setText("");
        }
    }
  ////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////
    
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
            value="EMP "+String.valueOf(q);
            System.out.println(value);
        }while(randomCheck(value));
        field.setText(value);
    }
    
    Boolean randomCheck(String data)
    {
        if(updateFieldCheck("Employee_ID","employee",data))
        {
        return true;
        }
       return false;
    }
    
    void emptyFields()
    {
//         + " VALUES('" + empid.getText() + "','" + desig.getText() + "','" + fname.getText() + "','" +lname.getText()
//                + "','" +dob+"','"+sex+"','"+padd.getText() + "','" +cadd.getText() + "','" +qual.getSelectedItem().toString()
//                    +"','" +sdate+"','"+exp.getText() + "'," +mphn.getText() + "," +lphn.getText() + ",'" +eid.getText() + "'," 
//                    +accno.getText() + "," +sal.getText() + ",?)";
        
//        dob1.setDate(null);
//        sdateq.setDate(null);
        
        empid.setText("");
        desig.setText("");
        fname.setText("");
        lname.setText("");
        dob1.setDate(null);
        padd.setText("");
        male.setSelected(false);
        female.setSelected(false);
        cadd.setText("");
        sdate1.setDate(null);
        exp.setText("");
        mphn.setText("");
        lphn.setText("");
        eid.setText("");
        accno.setText("");
        sal.setText("");
         img1.setIcon(null);
         qual.setSelectedItem("SSLC");
    }
    
    void emptyFields2()
    {
//         + " VALUES('" + empid.getText() + "','" + desig.getText() + "','" + fname.getText() + "','" +lname.getText()
//                + "','" +dob+"','"+sex+"','"+padd.getText() + "','" +cadd.getText() + "','" +qual.getSelectedItem().toString()
//                    +"','" +sdate+"','"+exp.getText() + "'," +mphn.getText() + "," +lphn.getText() + ",'" +eid.getText() + "'," 
//                    +accno.getText() + "," +sal.getText() + ",?)";
        
//        dob1.setDate(null);
//        sdateq.setDate(null);
        
        empid2.setText("");
        desig2.setText("");
        fname2.setText("");
        lname2.setText("");
        dob2.setDate(null);
        padd2.setText("");
        male1.setSelected(false);
        female2.setSelected(false);
        cadd2.setText("");
        sdate2.setDate(null);
        exp2.setText("");
        mphn2.setText("");
        lphn2.setText("");
        eid2.setText("");
        acc2.setText("");
        sal2.setText("");
         img2.setIcon(null);
         qual2.setSelectedItem("SSLC");
         System.err.println("worksssss");
    }
    
    
    
    
     void setBoundsForLong_ete_be()
    {
        
        ms.removeAll();
        ms.repaint();
        ms.revalidate();

ms.setMinimumSize(new java.awt.Dimension(228, 668));
//y_fol_lonh=10;
jScrollPane6.setViewportView(ms);

        int d=668;
        try {
                    d = countResult("select count(*) from employee ");
        } catch (Exception e) {
        }
        
         ms.setPreferredSize(new java.awt.Dimension(228,668+(d*160)));
         
    }
       void addEmployeeToTheEmployeeShown()
    {
        
    
       setBoundsForLong_ete_be();
        
       
           Database mysqlitem = new Database();
           mysqlitem.jdbcConnect();
String query = "SELECT * FROM employee order by First_Name ASC";// WHERE empid= '"++"' AND status='employee'";
 System.out.println(query);
 try{
     
            mysqlitem.p=mysqlitem.conn.prepareStatement(query);
           mysqlitem.rs=mysqlitem.p.executeQuery(query);

          
           while( mysqlitem.rs.next()){ 
               try {
                   
               
              //if(mysqlitem.rs.getString("satus").equals("employee"))
          addInTheScrollPaneInMain(mysqlitem.rs.getString("Employee_Id"),mysqlitem.rs.getString("Last_Name"),mysqlitem.rs.getString("First_Name"),""+mysqlitem.rs.getLong("M_Phone_No"),mysqlitem.rs.getBytes("Photo"));
 } catch (Exception e) {
               }
             }
System.out.println("success");
                  mysqlitem.rs.close();
               mysqlitem.p.close();
            mysqlitem.conn.close();
        }
        catch(Exception e1){
            System.out.println("zxError"+e1);
             
           
        }

       ms.repaint();
        ms.revalidate();
        
//jScrollPane2.add(main_k);//login
        
        
    }
    
       void mouse1Enterd(java.awt.event.MouseEvent evt,JButton o)
       {
//          layerRemoveAll(main2);
//          popup.setLocation(exbar.getX()+o.getX()-410,exbar.getY()+o.getY());
//          layerAdd(main2,popup);
//          layerAdd(main2,page);
//          layerAdd(main2,sbar);
//          layerAdd(main2,exbar);
           viewClicked(o.getText());
        System.err.println(o.getText());
       }
//    
       void mouse2Enterd(java.awt.event.MouseEvent evt,JButton o)
       {
           updateClicked(o.getText());
        System.err.println(o.getText());
       }
       
           void addInTheScrollPaneInMain(String empid,String lname,String fname,String mno,byte[]imagedata) throws IOException
    {
        try {
            
        
//         JLabel jLabe554 = new javax.swing.JLabel();
// jLabe554.setText(empid);
   JButton o;
    o = new JButton(empid);
    
//   o.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//               // SearchActionPerformed(evt);
////              o.mouseEnter(evt, WIDTH, WIDTH);
////              mo
//               
//            }
//        }); 
   o.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        mouse1Enterd(evt,o);
    }
   });
   
   JButton v;
    v = new JButton("view");
    
    v.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        mouse1Enterd(evt,o);
    }
   });
    
    JButton u;
    u = new JButton("update");
    
    u.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        mouse2Enterd(evt,o);
    }
   });
   
 JLabel jLabe555 = new javax.swing.JLabel();
 jLabe555.setText(fname);
 
 
JLabel jLabe556 = new javax.swing.JLabel();
 jLabe556.setText(lname);
 

 
  //=;
 
JLabel jLabe557 = new javax.swing.JLabel();
 jLabe557.setText(""+mno);
 
 
 
 JLayeredPane k;
        k = new javax.swing.JLayeredPane();
k.setBackground(new java.awt.Color(255, 255, 255));
//k.setForeground(new java.awt.Color(51,51,51));
k.setOpaque(true);
ms.add(k);
k.setBounds(10, y_fol_lonh, 200, 150);
     y_fol_lonh= y_fol_lonh+150+10;
 k.setLayout(null);
k.add(o);
o.setFont(new java.awt.Font("Tw Cen MT", 1, 12));
o.setBounds(20, 3, 100, 14);
o.setForeground(new java.awt.Color(255, 0, 0));
o.setBackground(new java.awt.Color(204, 204, 204));
//o.setOpaque(true);
o.setOpaque(false);
o.setContentAreaFilled(false);
o.setBorderPainted(true);       
//o.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
o.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
o.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

k.add(v);
v.setFont(new java.awt.Font("Tw Cen MT", 1, 12));
v.setBounds(80, 105, 40, 14);
v.setForeground(new java.awt.Color(0,102,255));
v.setBackground(new java.awt.Color(204, 204, 204));
//v.setOpaque(true);
v.setOpaque(false);
v.setContentAreaFilled(false);
v.setBorderPainted(true);       
v.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
v.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
v.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));


k.add(u);
u.setFont(new java.awt.Font("Tw Cen MT", 1, 12));
u.setBounds(80, 125, 40, 14);
u.setForeground(new java.awt.Color(0,102,255));
u.setBackground(new java.awt.Color(204, 204, 204));
//o.setOpaque(true);
u.setOpaque(false);
u.setContentAreaFilled(false);
u.setBorderPainted(true);       
u.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
u.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
u.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));


jLabe555.setFont(new java.awt.Font("Tw Cen MT", 1, 12));
k.add(jLabe555);
jLabe555.setBounds(10, 100, 150, 14);


jLabe556.setFont(new java.awt.Font("Tw Cen MT", 1, 12));
k.add(jLabe556);
jLabe556.setBounds(10, 113, 150, 14);


jLabe557.setFont(new java.awt.Font("Tw Cen MT", 1, 12));
k.add(jLabe557);
jLabe557.setBounds(10, 130, 150, 14);

///////


JLabel im = new javax.swing.JLabel();
k.add(im);
im.setBounds(30, 20, 65, 75);
                       ImageIcon format=null; 
           InputStream in = new ByteArrayInputStream(imagedata);
BufferedImage bImageFromConvert = ImageIO.read(in);
  BufferedImage outputImage = resizeImage(bImageFromConvert,bImageFromConvert.getWidth(),bImageFromConvert.getHeight(),im.getWidth(),im.getHeight())    ;             
ByteArrayOutputStream baos = new ByteArrayOutputStream();
String j=String.valueOf(bImageFromConvert.getType());
ImageIO.write( outputImage,"jpg", baos );
baos.flush();
byte[] imageInByte = baos.toByteArray();
//outputimg=imageInByte;
baos.close();

             format=new ImageIcon(imageInByte);
                    im.setIcon(format);  
                    
                    
         } catch (Exception e) {
        }           
                    
        
    }
           
           
           int countResult(String table) throws Exception {
                
        int u=0;
        Database mysqlitem = new Database();
        mysqlitem.jdbcConnect();
        String query = (String)table;
        System.out.println(query);
        try {

            mysqlitem.p = mysqlitem.conn.prepareStatement(query);
            mysqlitem.rs = mysqlitem.p.executeQuery(query);

            while (mysqlitem.rs.next()) {
               u=mysqlitem.rs.getInt(1);
            }
  System.out.println("success in mmmmmmmmmmmmmmmmmmmmmmmmmmmm uo");
            mysqlitem.rs.close();
            mysqlitem.p.close();
            mysqlitem.conn.close();
        } catch (Exception e) {
        }
        return (u);
    }
    
    void empDelete(String s)
    {
        String query,query2;
        try
        {
            Database db=new Database();
            db.jdbcConnect();
            query  ="DELETE FROM employee WHERE Employee_Id='"+s+"'";
            query2="DELETE FROM login_staff WHERE Employee_Id='"+s+"'";
             System.out.println(query);
//            db.stmt=conn.createStatement();
//            db.rs=db.stmt.executeQuery("we");
            db.p=db.conn.prepareStatement(query);
            int r=db.p.executeUpdate(query);
            db.p.close();
            db.conn.close();
            
            db.p=db.conn.prepareStatement(query2);
            int r1=db.p.executeUpdate(query2);
            db.p.close();
            db.conn.close();
            
            if(r>=1&&r1>=1)
            {
                JOptionPane.showMessageDialog(this,"Employee details deleted sucessfully");
            }
            System.out.println(r);
            db.p.close();
            db.conn.close();
        }
        catch(Exception e)
        {
            System.out.println("Delete exception");
        }
    }
    
    void prView()
    {
        //String s="ad";
        
        String query,query2;
        try
        {
            //tb1.setModel(null);
            tb1.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},
                new String [] {"Cubic Capacity", "Third party Premium", "Personal Accident","Passenger Cover", "Work Compensation", "upto 5", "5 - 10", "above 10"}));
            tb2.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},
                new String [] {"Cubic Capacity", "Third party Premium", "Personal Accident","Passenger Cover", "Work Compensation", "upto 5", "5 - 10", "above 10"}));
            tb3.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},
                new String [] {"Cubic Capacity", "Third party Premium", "Personal Accident","Passenger Cover", "Work Compensation", "upto 5", "5 - 10", "above 10"}));
            tb4.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},
                new String [] {"Cubic Capacity", "Third party Premium", "Personal Accident","Passenger Cover", "Work Compensation", "upto 5", "5 - 10", "above 10"}));
            tb5.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},
                new String [] {"Cubic Capacity", "Third party Premium", "Personal Accident","Passenger Cover", "Work Compensation", "upto 5", "5 - 10", "above 10"}));
            
           
            
            Database db=new Database();
            db.jdbcConnect();
            query  ="Select * from tarif";
             System.out.println(query);
//            db.stmt=conn.createStatement();
//            db.rs=db.stmt.executeQuery("we");
            db.p=db.conn.prepareStatement(query);
            db.rs=db.p.executeQuery(query);
            while(db.rs.next())
            {
                if(db.rs.getString("tv").equals("Private Cars"))
                {
                    Object[] row={db.rs.getString("cc"),db.rs.getString("tp"),db.rs.getString("pa"),db.rs.getString("pass"),db.rs.getString("wc"),db.rs.getString("upto 5"),db.rs.getString("5-10"),db.rs.getString("above 10")};
                    DefaultTableModel model=(DefaultTableModel)tb1.getModel();
                    model.addRow(row);
                }
                if(db.rs.getString("tv").equals("Two Wheelers"))
                {
                    Object[] row={db.rs.getString("cc"),db.rs.getString("tp"),db.rs.getString("pa"),db.rs.getString("pass"),db.rs.getString("wc"),db.rs.getString("upto 5"),db.rs.getString("5-10"),db.rs.getString("above 10")};
                    DefaultTableModel model=(DefaultTableModel)tb2.getModel();
                    model.addRow(row);
                }
                if(db.rs.getString("tv").equals("Goods Carrying Vehicles"))
                {
                    Object[] row={db.rs.getString("cc"),db.rs.getString("tp"),db.rs.getString("pa"),db.rs.getString("pass"),db.rs.getString("wc"),db.rs.getString("upto 5"),db.rs.getString("5-10"),db.rs.getString("above 10")};
                    DefaultTableModel model=(DefaultTableModel)tb3.getModel();
                    model.addRow(row);
                }
                    
                if(db.rs.getString("tv").equals("Vhcls for Hire(upto 6 Pass)"))
                {
                    Object[] row={db.rs.getString("cc"),db.rs.getString("tp"),db.rs.getString("pa"),db.rs.getString("pass"),db.rs.getString("wc"),db.rs.getString("upto 5"),db.rs.getString("5-10"),db.rs.getString("above 10")};
                    DefaultTableModel model=(DefaultTableModel)tb4.getModel();
                    model.addRow(row);
                }
                if(db.rs.getString("tv").equals("Vhcls for Hire(above 6 Pass)"))
                {
                    Object[] row={db.rs.getString("cc"),db.rs.getString("tp"),db.rs.getString("pa"),db.rs.getString("pass"),db.rs.getString("wc"),db.rs.getString("upto 5"),db.rs.getString("5-10"),db.rs.getString("above 10")};
                    DefaultTableModel model=(DefaultTableModel)tb5.getModel();
                    model.addRow(row);
                }
                
            }
            db.p.close();
            db.conn.close();
            
        }
        catch(Exception e)
        {
        
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
                //System.err.println(info.getClassName()+"-------"+info.getName());
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    //System.err.println(info.getClassName()+"-------"+info.getName());
                    break;
                    //javax.swing.UIManager.
                }
            }
            
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

           
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }
 FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane about;
    private javax.swing.JTextField acc2;
    private javax.swing.JLabel acc3;
    private javax.swing.JTextField accno;
    private javax.swing.JLayeredPane active;
    private javax.swing.JTable active1;
    private javax.swing.JComboBox<String> av;
    private javax.swing.JLayeredPane bgrnd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox ca;
    private javax.swing.JCheckBox ca1;
    private javax.swing.JTextArea cadd;
    private javax.swing.JTextArea cadd2;
    private javax.swing.JTextArea cadd3;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox<String> cc;
    private javax.swing.JLayeredPane change;
    private javax.swing.JFileChooser chooser;
    private javax.swing.JPasswordField cnewpass;
    private javax.swing.JPasswordField cpass;
    private javax.swing.JTextField desig;
    private javax.swing.JTextField desig2;
    private javax.swing.JLabel desig3;
    private javax.swing.JDialog dialog;
    private com.toedter.calendar.JDateChooser dob1;
    private com.toedter.calendar.JDateChooser dob2;
    private javax.swing.JLabel dob3;
    private javax.swing.JTextField dp;
    private javax.swing.JLabel dspDate;
    private javax.swing.JLabel dspTime;
    private javax.swing.JTextField eid;
    private javax.swing.JTextField eid2;
    private javax.swing.JLabel eid3;
    private javax.swing.JTextField empid;
    private javax.swing.JTextField empid2;
    private javax.swing.JLabel empid3;
    private javax.swing.JLayeredPane exbar;
    private javax.swing.JTextField exp;
    private javax.swing.JTextField exp2;
    private javax.swing.JLabel exp3;
    private javax.swing.JLayeredPane expired;
    private javax.swing.JTable expired1;
    private javax.swing.JRadioButton female;
    private javax.swing.JRadioButton female2;
    private javax.swing.JTextArea ffffabout;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField fname2;
    private javax.swing.JLabel fname3;
    private javax.swing.JLayeredPane home;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label55;
    private javax.swing.JLabel label56;
    private javax.swing.JLabel label57;
    private javax.swing.JLabel label58;
    private javax.swing.JLabel label59;
    private javax.swing.JLabel label60;
    private javax.swing.JLabel label61;
    private javax.swing.JLabel label62;
    private javax.swing.JLabel label63;
    private javax.swing.JLabel label64;
    private javax.swing.JLabel label65;
    private javax.swing.JLabel label66;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField lname2;
    private javax.swing.JLabel lname3;
    private javax.swing.JLayeredPane log;
    private javax.swing.JTextField lphn;
    private javax.swing.JTextField lphn2;
    private javax.swing.JLabel lphn3;
    private javax.swing.JLayeredPane main;
    private javax.swing.JLayeredPane main1;
    private javax.swing.JLayeredPane main2;
    private javax.swing.JRadioButton male;
    private javax.swing.JRadioButton male1;
    private javax.swing.JTextField mphn;
    private javax.swing.JTextField mphn2;
    private javax.swing.JLabel mphn3;
    private javax.swing.JLayeredPane ms;
    private javax.swing.JLabel msg;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JTextField od;
    private javax.swing.JButton ok1;
    private javax.swing.JTextField pa;
    private javax.swing.JTextArea padd;
    private javax.swing.JTextArea padd2;
    private javax.swing.JTextArea padd3;
    private javax.swing.JLayeredPane page;
    private javax.swing.JLayeredPane pageBack;
    private javax.swing.JLayeredPane pageBack1;
    private javax.swing.JLayeredPane pageBack2;
    private javax.swing.JLayeredPane pageBack3;
    private javax.swing.JLayeredPane pageBack4;
    private javax.swing.JLayeredPane pageBack5;
    private javax.swing.JLayeredPane pageBack7;
    private javax.swing.JTextField pass;
    private javax.swing.JLayeredPane policy;
    private javax.swing.JLayeredPane policyOP;
    private javax.swing.JLayeredPane premium;
    private javax.swing.JLayeredPane premiumOp;
    private javax.swing.JLayeredPane prmUpdate;
    private javax.swing.JLayeredPane prmView;
    private javax.swing.JComboBox<String> qual;
    private javax.swing.JComboBox<String> qual2;
    private javax.swing.JLabel qual3;
    private javax.swing.JLabel qwe;
    private javax.swing.JTextField sal;
    private javax.swing.JTextField sal2;
    private javax.swing.JLabel sal3;
    private javax.swing.JLayeredPane sbar;
    private com.toedter.calendar.JDateChooser sdate1;
    private com.toedter.calendar.JDateChooser sdate2;
    private javax.swing.JLabel sdate3;
    private javax.swing.JLabel sex3;
    private javax.swing.JTextField srch;
    private javax.swing.JLayeredPane staff;
    private javax.swing.JLayeredPane staffAdd;
    private javax.swing.JLayeredPane staffOp;
    private javax.swing.JLayeredPane staffUpdate;
    private javax.swing.JLayeredPane staffView;
    private javax.swing.JLayeredPane tExpired;
    private javax.swing.JTable tExpired1;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tb3;
    private javax.swing.JTable tb4;
    private javax.swing.JTable tb5;
    private javax.swing.JLabel total;
    private javax.swing.JTextField tp;
    private javax.swing.JComboBox<String> tv;
    private javax.swing.JLayeredPane updateOp;
    private javax.swing.JLayeredPane viewOp;
    private javax.swing.JTextField wc;
    // End of variables declaration//GEN-END:variables
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM");

}

