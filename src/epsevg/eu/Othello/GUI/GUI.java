package epsevg.eu.Othello.GUI;

import epsevg.eu.Othello.Logic.Board;
import static epsevg.eu.Othello.GUI.GUI.resize;
import epsevg.eu.Othello.Base.Movement;
import epsevg.eu.Othello.Util.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.FileNotFoundException;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import javazoom.jl.decoder.JavaLayerException;
import static epsevg.eu.Othello.Constants.Constants.IMG;
import static epsevg.eu.Othello.Constants.Constants.LOGO;
import static epsevg.eu.Othello.Constants.Constants.MUS1;
import static epsevg.eu.Othello.Constants.Constants.MUS2;
import java.io.InputStream;


public class GUI extends JFrame {

    
    /* PRIVATES */
    private boolean acabat = false;
    private Thread pare = null;
    private Board b = null;
    private Vector<Movement> mov = null; 
    private Point s;
    private javazoom.jl.player.Player p;
    private InputStream FIS;
    private BufferedInputStream BIS;
    private boolean play = true;    
    private boolean go = false;
    private Thread music;
    
    
    
    /* CONSTRUCTOR */
    
    /**
     * 
     * Public constructor of the GUI (Graphical Interface)
     * @param t Main Thread from Othello
     * @throws IOException
     * @throws FileNotFoundException
     * @throws JavaLayerException 
     */
    public GUI(Thread t) throws IOException, FileNotFoundException, JavaLayerException {
        initComponents();        
        /* ESTABLIR PROPIETATS ELS JUGADORS */        
        Jugador1.setEditable(false);
        Jugador2.setEditable(false);
        
        /* ESTABLIR PROPIETATS DE LA GUI */
        playMusic();
        setAtributes();
        
        /* ESTABLIR PROPIETATS PI */        
        s = null;
        pare = t;
        
        /* INTERROMPRE MAIN THREAD (Construccio acabada)*/
        pare.interrupt();
    }
    
    /* METODES */
    
    /**
     * Private method which main goal is to set
     * the atributes of the GUI
     * @throws IOException 
     */
    private void setAtributes() throws IOException
    {
        this.setTitle("Othello - Reversi");        
        File file = null;
        try{
            file = new File(getClass().getClassLoader().getResource(LOGO).getFile());            
        }
        catch(Exception e){System.out.println(e+" | No s'ha pogut carregar la icona");}
        Image image = null;
        if (file != null)
            try{
                image = ImageIO.read(file);
            }
            catch(Exception e){ System.out.println("ERROR : " + e);}
        if (image != null) this.setIconImage(image);
        setPicture();
    }
    
    /**
     * Public method which main goal is to resize a photo
     * 
     * @param img Image to be resized
     * @param newW New Width
     * @param newH New Height
     * @return Image resized
     */
    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return dimg;
    }      

    /**
     * Event triggered by a mouse action.
     * @param evt Evt from the Event
     */
    private void ratoliPres(java.awt.event.MouseEvent evt) {                            
        /* OBTAIN MOUSE POSITION */
        int rata_x = evt.getX();
        int rata_y = evt.getY();
        double pan_x = jLayeredPane1.getSize().getWidth();
        double pan_y = jLayeredPane1.getSize().getHeight();
        int aux = (int) (rata_x / (pan_x / epsevg.eu.Othello.Constants.Constants.WIDTH ));
        int aux2 = (int) (rata_y / (pan_y / epsevg.eu.Othello.Constants.Constants.HEIGHT));
        s = new Point (aux2,aux);
        
        /* INTERRUPT Othello*/
        pare.interrupt();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        fill_73 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_03 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_23 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_33 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_43 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_53 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_63 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_74 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_64 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_54 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_44 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_34 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_24 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_14 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_04 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_72 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_62 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_52 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_42 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_32 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_22 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_12 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_02 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_75 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_65 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_55 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_45 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_35 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_25 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_15 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_05 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_76 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_66 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_56 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_46 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_36 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_26 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_16 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_06 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_71 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_61 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_51 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_41 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_31 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_21 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_01 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_57 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_47 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_37 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_27 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_07 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_17 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_67 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_77 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_70 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_60 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_50 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_40 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_30 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_20 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        fill_00 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 400), new java.awt.Dimension(0, 400), new java.awt.Dimension(32767, 400));
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Jugador1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Jugador2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TurnLabel = new javax.swing.JLabel();
        LabelColor = new javax.swing.JLabel();
        pj1 = new javax.swing.JLabel();
        pecesj1 = new javax.swing.JLabel();
        pj2 = new javax.swing.JLabel();
        pecesj2 = new javax.swing.JLabel();
        WLabel = new javax.swing.JLabel();
        BMusic = new javax.swing.JButton();
        GameFlow = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLayeredPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLayeredPane1ratoliPres(evt);
            }
        });

        fill_73.setBackground(new java.awt.Color(0, 153, 51));
        fill_73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_73.setOpaque(true);
        jLayeredPane1.add(fill_73);
        fill_73.setBounds(150, 0, 50, 50);

        fill_03.setBackground(new java.awt.Color(0, 153, 51));
        fill_03.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_03.setOpaque(true);
        jLayeredPane1.add(fill_03);
        fill_03.setBounds(150, 350, 50, 50);

        fill_13.setBackground(new java.awt.Color(0, 153, 51));
        fill_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_13.setOpaque(true);
        jLayeredPane1.add(fill_13);
        fill_13.setBounds(150, 300, 50, 50);

        fill_23.setBackground(new java.awt.Color(0, 153, 51));
        fill_23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_23.setOpaque(true);
        jLayeredPane1.add(fill_23);
        fill_23.setBounds(150, 250, 50, 50);

        fill_33.setBackground(new java.awt.Color(0, 153, 51));
        fill_33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_33.setOpaque(true);
        jLayeredPane1.add(fill_33);
        fill_33.setBounds(150, 200, 50, 50);

        fill_43.setBackground(new java.awt.Color(0, 153, 51));
        fill_43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_43.setOpaque(true);
        jLayeredPane1.add(fill_43);
        fill_43.setBounds(150, 150, 50, 50);

        fill_53.setBackground(new java.awt.Color(0, 153, 51));
        fill_53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_53.setOpaque(true);
        jLayeredPane1.add(fill_53);
        fill_53.setBounds(150, 100, 50, 50);

        fill_63.setBackground(new java.awt.Color(0, 153, 51));
        fill_63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_63.setOpaque(true);
        jLayeredPane1.add(fill_63);
        fill_63.setBounds(150, 50, 50, 50);

        fill_74.setBackground(new java.awt.Color(0, 153, 51));
        fill_74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_74.setOpaque(true);
        jLayeredPane1.add(fill_74);
        fill_74.setBounds(200, 0, 50, 50);

        fill_64.setBackground(new java.awt.Color(0, 153, 51));
        fill_64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_64.setOpaque(true);
        jLayeredPane1.add(fill_64);
        fill_64.setBounds(200, 50, 50, 50);

        fill_54.setBackground(new java.awt.Color(0, 153, 51));
        fill_54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_54.setOpaque(true);
        jLayeredPane1.add(fill_54);
        fill_54.setBounds(200, 100, 50, 50);

        fill_44.setBackground(new java.awt.Color(0, 153, 51));
        fill_44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_44.setOpaque(true);
        jLayeredPane1.add(fill_44);
        fill_44.setBounds(200, 150, 50, 50);

        fill_34.setBackground(new java.awt.Color(0, 153, 51));
        fill_34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_34.setOpaque(true);
        jLayeredPane1.add(fill_34);
        fill_34.setBounds(200, 200, 50, 50);

        fill_24.setBackground(new java.awt.Color(0, 153, 51));
        fill_24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_24.setOpaque(true);
        jLayeredPane1.add(fill_24);
        fill_24.setBounds(200, 250, 50, 50);

        fill_14.setBackground(new java.awt.Color(0, 153, 51));
        fill_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_14.setOpaque(true);
        jLayeredPane1.add(fill_14);
        fill_14.setBounds(200, 300, 50, 50);

        fill_04.setBackground(new java.awt.Color(0, 153, 51));
        fill_04.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_04.setOpaque(true);
        jLayeredPane1.add(fill_04);
        fill_04.setBounds(200, 350, 50, 50);

        fill_72.setBackground(new java.awt.Color(0, 153, 51));
        fill_72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_72.setOpaque(true);
        jLayeredPane1.add(fill_72);
        fill_72.setBounds(100, 0, 50, 50);

        fill_62.setBackground(new java.awt.Color(0, 153, 51));
        fill_62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_62.setOpaque(true);
        jLayeredPane1.add(fill_62);
        fill_62.setBounds(100, 50, 50, 50);

        fill_52.setBackground(new java.awt.Color(0, 153, 51));
        fill_52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_52.setOpaque(true);
        jLayeredPane1.add(fill_52);
        fill_52.setBounds(100, 100, 50, 50);

        fill_42.setBackground(new java.awt.Color(0, 153, 51));
        fill_42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_42.setOpaque(true);
        jLayeredPane1.add(fill_42);
        fill_42.setBounds(100, 150, 50, 50);

        fill_32.setBackground(new java.awt.Color(0, 153, 51));
        fill_32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_32.setOpaque(true);
        jLayeredPane1.add(fill_32);
        fill_32.setBounds(100, 200, 50, 50);

        fill_22.setBackground(new java.awt.Color(0, 153, 51));
        fill_22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_22.setOpaque(true);
        jLayeredPane1.add(fill_22);
        fill_22.setBounds(100, 250, 50, 50);

        fill_12.setBackground(new java.awt.Color(0, 153, 51));
        fill_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_12.setOpaque(true);
        jLayeredPane1.add(fill_12);
        fill_12.setBounds(100, 300, 50, 50);

        fill_02.setBackground(new java.awt.Color(0, 153, 51));
        fill_02.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_02.setOpaque(true);
        jLayeredPane1.add(fill_02);
        fill_02.setBounds(100, 350, 50, 50);

        fill_75.setBackground(new java.awt.Color(0, 153, 51));
        fill_75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_75.setOpaque(true);
        jLayeredPane1.add(fill_75);
        fill_75.setBounds(250, 0, 50, 50);

        fill_65.setBackground(new java.awt.Color(0, 153, 51));
        fill_65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_65.setOpaque(true);
        jLayeredPane1.add(fill_65);
        fill_65.setBounds(250, 50, 50, 50);

        fill_55.setBackground(new java.awt.Color(0, 153, 51));
        fill_55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_55.setOpaque(true);
        jLayeredPane1.add(fill_55);
        fill_55.setBounds(250, 100, 50, 50);

        fill_45.setBackground(new java.awt.Color(0, 153, 51));
        fill_45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_45.setOpaque(true);
        jLayeredPane1.add(fill_45);
        fill_45.setBounds(250, 150, 50, 50);

        fill_35.setBackground(new java.awt.Color(0, 153, 51));
        fill_35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_35.setOpaque(true);
        jLayeredPane1.add(fill_35);
        fill_35.setBounds(250, 200, 50, 50);

        fill_25.setBackground(new java.awt.Color(0, 153, 51));
        fill_25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_25.setOpaque(true);
        jLayeredPane1.add(fill_25);
        fill_25.setBounds(250, 250, 50, 50);

        fill_15.setBackground(new java.awt.Color(0, 153, 51));
        fill_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_15.setOpaque(true);
        jLayeredPane1.add(fill_15);
        fill_15.setBounds(250, 300, 50, 50);

        fill_05.setBackground(new java.awt.Color(0, 153, 51));
        fill_05.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_05.setOpaque(true);
        jLayeredPane1.add(fill_05);
        fill_05.setBounds(250, 350, 50, 50);

        fill_76.setBackground(new java.awt.Color(0, 153, 51));
        fill_76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_76.setOpaque(true);
        jLayeredPane1.add(fill_76);
        fill_76.setBounds(300, 0, 50, 50);

        fill_66.setBackground(new java.awt.Color(0, 153, 51));
        fill_66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_66.setOpaque(true);
        jLayeredPane1.add(fill_66);
        fill_66.setBounds(300, 50, 50, 50);

        fill_56.setBackground(new java.awt.Color(0, 153, 51));
        fill_56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_56.setOpaque(true);
        jLayeredPane1.add(fill_56);
        fill_56.setBounds(300, 100, 50, 50);

        fill_46.setBackground(new java.awt.Color(0, 153, 51));
        fill_46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_46.setOpaque(true);
        jLayeredPane1.add(fill_46);
        fill_46.setBounds(300, 150, 50, 50);

        fill_36.setBackground(new java.awt.Color(0, 153, 51));
        fill_36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_36.setOpaque(true);
        jLayeredPane1.add(fill_36);
        fill_36.setBounds(300, 200, 50, 50);

        fill_26.setBackground(new java.awt.Color(0, 153, 51));
        fill_26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_26.setOpaque(true);
        jLayeredPane1.add(fill_26);
        fill_26.setBounds(300, 250, 50, 50);

        fill_16.setBackground(new java.awt.Color(0, 153, 51));
        fill_16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_16.setOpaque(true);
        jLayeredPane1.add(fill_16);
        fill_16.setBounds(300, 300, 50, 50);

        fill_06.setBackground(new java.awt.Color(0, 153, 51));
        fill_06.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_06.setOpaque(true);
        jLayeredPane1.add(fill_06);
        fill_06.setBounds(300, 350, 50, 50);

        fill_71.setBackground(new java.awt.Color(0, 153, 51));
        fill_71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_71.setOpaque(true);
        jLayeredPane1.add(fill_71);
        fill_71.setBounds(50, 0, 50, 50);

        fill_61.setBackground(new java.awt.Color(0, 153, 51));
        fill_61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_61.setOpaque(true);
        jLayeredPane1.add(fill_61);
        fill_61.setBounds(50, 50, 50, 50);

        fill_51.setBackground(new java.awt.Color(0, 153, 51));
        fill_51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_51.setOpaque(true);
        jLayeredPane1.add(fill_51);
        fill_51.setBounds(50, 100, 50, 50);

        fill_41.setBackground(new java.awt.Color(0, 153, 51));
        fill_41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_41.setOpaque(true);
        jLayeredPane1.add(fill_41);
        fill_41.setBounds(50, 150, 50, 50);

        fill_31.setBackground(new java.awt.Color(0, 153, 51));
        fill_31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_31.setOpaque(true);
        jLayeredPane1.add(fill_31);
        fill_31.setBounds(50, 200, 50, 50);

        fill_21.setBackground(new java.awt.Color(0, 153, 51));
        fill_21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_21.setOpaque(true);
        jLayeredPane1.add(fill_21);
        fill_21.setBounds(50, 250, 50, 50);

        fill_11.setBackground(new java.awt.Color(0, 153, 51));
        fill_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_11.setOpaque(true);
        jLayeredPane1.add(fill_11);
        fill_11.setBounds(50, 300, 50, 50);

        fill_01.setBackground(new java.awt.Color(0, 153, 51));
        fill_01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_01.setOpaque(true);
        jLayeredPane1.add(fill_01);
        fill_01.setBounds(50, 350, 50, 50);

        fill_57.setBackground(new java.awt.Color(0, 153, 51));
        fill_57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_57.setOpaque(true);
        jLayeredPane1.add(fill_57);
        fill_57.setBounds(350, 100, 50, 50);

        fill_47.setBackground(new java.awt.Color(0, 153, 51));
        fill_47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_47.setOpaque(true);
        jLayeredPane1.add(fill_47);
        fill_47.setBounds(350, 150, 50, 50);

        fill_37.setBackground(new java.awt.Color(0, 153, 51));
        fill_37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_37.setOpaque(true);
        jLayeredPane1.add(fill_37);
        fill_37.setBounds(350, 200, 50, 50);

        fill_27.setBackground(new java.awt.Color(0, 153, 51));
        fill_27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_27.setOpaque(true);
        jLayeredPane1.add(fill_27);
        fill_27.setBounds(350, 250, 50, 50);

        fill_07.setBackground(new java.awt.Color(0, 153, 51));
        fill_07.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_07.setOpaque(true);
        jLayeredPane1.add(fill_07);
        fill_07.setBounds(350, 350, 50, 50);

        fill_17.setBackground(new java.awt.Color(0, 153, 51));
        fill_17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_17.setOpaque(true);
        jLayeredPane1.add(fill_17);
        fill_17.setBounds(350, 300, 50, 50);

        fill_67.setBackground(new java.awt.Color(0, 153, 51));
        fill_67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_67.setOpaque(true);
        jLayeredPane1.add(fill_67);
        fill_67.setBounds(350, 50, 50, 50);

        fill_77.setBackground(new java.awt.Color(0, 153, 51));
        fill_77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_77.setOpaque(true);
        jLayeredPane1.add(fill_77);
        fill_77.setBounds(350, 0, 50, 50);

        fill_70.setBackground(new java.awt.Color(0, 153, 51));
        fill_70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_70.setOpaque(true);
        jLayeredPane1.add(fill_70);
        fill_70.setBounds(0, 0, 50, 50);

        fill_60.setBackground(new java.awt.Color(0, 153, 51));
        fill_60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_60.setOpaque(true);
        jLayeredPane1.add(fill_60);
        fill_60.setBounds(0, 50, 50, 50);

        fill_50.setBackground(new java.awt.Color(0, 153, 51));
        fill_50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_50.setOpaque(true);
        jLayeredPane1.add(fill_50);
        fill_50.setBounds(0, 100, 50, 50);

        fill_40.setBackground(new java.awt.Color(0, 153, 51));
        fill_40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_40.setOpaque(true);
        jLayeredPane1.add(fill_40);
        fill_40.setBounds(0, 150, 50, 50);

        fill_30.setBackground(new java.awt.Color(0, 153, 51));
        fill_30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_30.setOpaque(true);
        jLayeredPane1.add(fill_30);
        fill_30.setBounds(0, 200, 50, 50);

        fill_20.setBackground(new java.awt.Color(0, 153, 51));
        fill_20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_20.setOpaque(true);
        jLayeredPane1.add(fill_20);
        fill_20.setBounds(0, 250, 50, 50);

        fill_10.setBackground(new java.awt.Color(0, 153, 51));
        fill_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_10.setOpaque(true);
        jLayeredPane1.add(fill_10);
        fill_10.setBounds(0, 300, 50, 50);

        fill_00.setBackground(new java.awt.Color(0, 153, 51));
        fill_00.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fill_00.setOpaque(true);
        jLayeredPane1.add(fill_00);
        fill_00.setBounds(0, 350, 50, 50);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("7");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("6");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("5");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("4");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setText("3");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("2");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("1");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setText("0");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setText("A");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel11.setText("B");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setText("C");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel13.setText("D");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel14.setText("E");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel15.setText("F");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel16.setText("G");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel17.setText("H");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(Jugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 18, 90, -1));

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 53, 56, -1));
        jPanel1.add(Jugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 86, 91, -1));

        jLabel18.setText("Turn :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        TurnLabel.setText("UNDEFINED");
        jPanel1.add(TurnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 148, -1, -1));

        LabelColor.setText("UNDEFINED");
        jPanel1.add(LabelColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 169, -1, -1));

        pj1.setText("Peces J1:");
        jPanel1.add(pj1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        pecesj1.setText("UF");
        jPanel1.add(pecesj1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        pj2.setText("Peces J2:");
        jPanel1.add(pj2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        pecesj2.setText("UF");
        jPanel1.add(pecesj2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));
        jPanel1.add(WLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 304, 78, 42));

        BMusic.setText("PAUSE");
        BMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMusicActionPerformed(evt);
            }
        });
        jPanel1.add(BMusic, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 80, -1));

        GameFlow.setEditable(false);
        GameFlow.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        GameFlow.setForeground(new java.awt.Color(255, 0, 0));
        GameFlow.setText("UNDEFINED - No Movements Made");
        GameFlow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GameFlowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel10)
                .addGap(34, 34, 34)
                .addComponent(jLabel11)
                .addGap(30, 30, 30)
                .addComponent(jLabel12)
                .addGap(34, 34, 34)
                .addComponent(jLabel13)
                .addGap(35, 35, 35)
                .addComponent(jLabel14)
                .addGap(30, 30, 30)
                .addComponent(jLabel15)
                .addGap(26, 26, 26)
                .addComponent(jLabel16)
                .addGap(26, 26, 26)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GameFlow, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GameFlow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Event triggered by a mouse action
     * @param evt Evt from the Event
     */
    private void jLayeredPane1ratoliPres(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLayeredPane1ratoliPres
        ratoliPres(evt);
    }//GEN-LAST:event_jLayeredPane1ratoliPres
    /**
     * Event triggered by a button action
     * @param evt Evt from the Event
     */
    private void BMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMusicActionPerformed
        try {
            resume_or_pause();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BMusicActionPerformed

    private void GameFlowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GameFlowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GameFlowActionPerformed
    
    /* SETTERS */
    
    /**
     * Public method its goal is to set turns into GUI
     * @param s Name of the player
     * @param t Color of the player
     */
    public void setTurn (String s, int t){TurnLabel.setText(s);    
        if (t == 1) LabelColor.setText("Negres");
        else if (t == -1) LabelColor.setText("Blanques");
    }
    /**
     * Public method its goal is to set whether is there
     * going to be a next game.
     * @param b If True: There's a next game
     * Else: There is not a next game
     */
    public void setRepeat(boolean b){go=b;}
    public void setWinner(String s){
        WLabel.setText("<html>Winner :<br/>"+s+"</html>");
        this.setRepeat(go);
    }
    
    /**
     * Public method its goal is to update the most
     * recent board
     * @param b The most recent board
     */
    public void updateBoard(Board b){this.b=b;}
    
    /**
     * Public method its goal is to update the most
     * recent movement
     * @param mov The most recent movement
     */
    public void updateMov (Vector<Movement> mov){this.mov = mov;}
    
    /**
     * Public method its goal is to set the most
     * recent number of pieces of each opponent.
     * @param j1 Number of pieces of the black player
     * @param j2 Number of pieces of the white player
     */
    public void setNumPieces(int j1, int j2){
        pecesj1.setText(Integer.toString(j1));
        pecesj2.setText(Integer.toString(j2));
    }
    
    /**
     * Private method its goal is to set a picture in front of
     * the GUI
     * @throws IOException 
     */
    private void setPicture() throws IOException
    {
        
        BufferedImage image = null;
        try{
           image = ImageIO.read(getClass().getResource (IMG));        
        }
        catch(Exception e){System.out.println(e);}               
        ImageIcon n = new ImageIcon(resize(image,jLabel19.getWidth(),jLabel19.getHeight()));        
        jLabel19.setIcon(n);
    }
    
    /**
     * Public method its aim is to set the players name into the GUI
     * @param p1 Players' one name
     * @param p2 Players' two name
     */
    public void setPlayers(String p1,String p2){Jugador1.setText(p1);
        Jugador2.setText(p2);
    }
    
    /**
     * Public method its goal is to set the most recent status of 
     * the game
     * @param s String containing the status 
     */
    public void setStatus(String s){pecesj1.setText(s);}
    
    /**
     * Public method its goal is to set the last movement ocurred
     * in the game
     * @param s String containing the movement
     */
    public void setFlow(String s){GameFlow.setText("Last Movement : "+s);}
    
    
    
    /* GETTERS */
    
    /**
     * Public method its goal is to get the most recent point
     * used by a Manual player
     * @return 
     */
    public Point getPoint(){return s;}
    
    /**
     * Public method which returns whether is there going to 
     * be a next match.
     * @return 
     */
    public boolean getRepeat(){return go;}
    
    
    /* MODIFIERS */
    
    /**
     * Public method its goal is to update PI before painting
     * the board into the GUI
     * @param b The most recent board
     * @param mov The most recent movement
     */
    public void pinta_tauler(Board b, Vector<Movement> mov)
    {   
        updateBoard(b);
        updateMov(mov);
        repaint();    
    }
    
    /**
     * Private method its goal is to play music while there is
     * a running game.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws JavaLayerException 
     */
    private void playMusic() throws FileNotFoundException, IOException, JavaLayerException{
        
        try{
            music = new Thread()
            {
                public void run()
                {
                    try{
                        while (play){
                            int n = ThreadLocalRandom.current().nextInt(0,2);
                            if (n == 1) FIS = epsevg.eu.Othello.Othello.class.getResourceAsStream(MUS1);
                            else FIS = epsevg.eu.Othello.Othello.class.getResourceAsStream(MUS2);
                            BIS = new BufferedInputStream(FIS);
                            p = new javazoom.jl.player.Player(BIS);
                            p.play();
                        }
                    }
                    catch(JavaLayerException e)
                    {
                        System.out.println("FITXER NO TROBAT MUSICA");
                    }
                }
            };
            music.start();
            
        }
        catch(Exception e){}
            
        
    }
    
    /**
     * Public method its goal is to reset all
     * labels
     */
    public void resetLabels()
    {   
        jLabel18.setVisible(true);
        TurnLabel.setVisible(true);
        pj1.setVisible(true);
        pecesj1.setVisible(true);
        pj2.setVisible(true);
        pecesj2.setVisible(true);
        LabelColor.setVisible(true);
        WLabel.setText("");
        GameFlow.setText("UNDEFINED - No Movements Made");
        WLabel.setVisible(false);
        
    }
    
    
    /**
     * Private method its goal is to play or resume
     * music flow.
     * @throws IOException
     * @throws FileNotFoundException
     * @throws JavaLayerException 
     */
    private void resume_or_pause() throws IOException, FileNotFoundException, JavaLayerException
    {
        if (play){
            p.close();
            BMusic.setText("PLAYM");
        }
        else{
            playMusic();
            BMusic.setText("PAUSE");
        }        
        play = !play;        
    }
    
    /**
     * Public method overrided that paints the GUI
     * @param g Graphics object
     */
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        int i;
        Point pt;
        for (i=0;i<b.getWhitePieces().size(); ++i){

            pt = b.getWhitePieces().get(i);

            g.setColor(Color.WHITE);
            g.drawOval(whichx(pt.getY()),whichy(pt.getX()),40,40);
            g.fillOval(whichx(pt.getY()),whichy(pt.getX()),40,40);

            if (i<b.getBlackPieces().size()){

                pt = b.getBlackPieces().get(i);

                g.setColor(Color.BLACK);
                g.drawOval(whichx(pt.getY()),whichy(pt.getX()),40,40);
                g.fillOval(whichx(pt.getY()),whichy(pt.getX()),40,40);
            }
        }

        while (i<b.getBlackPieces().size()){
            pt = b.getBlackPieces().get(i);

            g.setColor(Color.BLACK);
            g.drawOval(whichx(pt.getY()),whichy(pt.getX()),40,40);
            g.fillOval(whichx(pt.getY()),whichy(pt.getX()),40,40);

            ++i;
        }
       
        for (int k=0;k<mov.size();++k){
            Point p = mov.get(k).getPosition();
            g.setColor(Color.RED);
            g.drawOval(whichx(p.getY()),whichy(p.getX()),40,40);
            g.setColor(new Color (0,175,0));
            g.fillOval(whichx(p.getY()),whichy(p.getX()),40,40);  
        } 
        
    }
        
    /**
     * Private method its goal is to get an horizontal coordenate
     * from a column
     * @param col Col which we want to calculate from
     * @return Horizontal coordenate
     */
    private static int whichx(int col){
        return ((50*col+52));
    }
    /**
     * Private method its goal is to get a vertical coordenate
     * from a row
     * @param fil Row
     * @return Vertical coordenate
     */
    private static int whichy(int fil){
        return (50*fil+30+42);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BMusic;
    private javax.swing.JTextField GameFlow;
    private javax.swing.JTextField Jugador1;
    private javax.swing.JTextField Jugador2;
    private javax.swing.JLabel LabelColor;
    private javax.swing.JLabel TurnLabel;
    private javax.swing.JLabel WLabel;
    private javax.swing.Box.Filler fill_00;
    private javax.swing.Box.Filler fill_01;
    private javax.swing.Box.Filler fill_02;
    private javax.swing.Box.Filler fill_03;
    private javax.swing.Box.Filler fill_04;
    private javax.swing.Box.Filler fill_05;
    private javax.swing.Box.Filler fill_06;
    private javax.swing.Box.Filler fill_07;
    private javax.swing.Box.Filler fill_10;
    private javax.swing.Box.Filler fill_11;
    private javax.swing.Box.Filler fill_12;
    private javax.swing.Box.Filler fill_13;
    private javax.swing.Box.Filler fill_14;
    private javax.swing.Box.Filler fill_15;
    private javax.swing.Box.Filler fill_16;
    private javax.swing.Box.Filler fill_17;
    private javax.swing.Box.Filler fill_20;
    private javax.swing.Box.Filler fill_21;
    private javax.swing.Box.Filler fill_22;
    private javax.swing.Box.Filler fill_23;
    private javax.swing.Box.Filler fill_24;
    private javax.swing.Box.Filler fill_25;
    private javax.swing.Box.Filler fill_26;
    private javax.swing.Box.Filler fill_27;
    private javax.swing.Box.Filler fill_30;
    private javax.swing.Box.Filler fill_31;
    private javax.swing.Box.Filler fill_32;
    private javax.swing.Box.Filler fill_33;
    private javax.swing.Box.Filler fill_34;
    private javax.swing.Box.Filler fill_35;
    private javax.swing.Box.Filler fill_36;
    private javax.swing.Box.Filler fill_37;
    private javax.swing.Box.Filler fill_40;
    private javax.swing.Box.Filler fill_41;
    private javax.swing.Box.Filler fill_42;
    private javax.swing.Box.Filler fill_43;
    private javax.swing.Box.Filler fill_44;
    private javax.swing.Box.Filler fill_45;
    private javax.swing.Box.Filler fill_46;
    private javax.swing.Box.Filler fill_47;
    private javax.swing.Box.Filler fill_50;
    private javax.swing.Box.Filler fill_51;
    private javax.swing.Box.Filler fill_52;
    private javax.swing.Box.Filler fill_53;
    private javax.swing.Box.Filler fill_54;
    private javax.swing.Box.Filler fill_55;
    private javax.swing.Box.Filler fill_56;
    private javax.swing.Box.Filler fill_57;
    private javax.swing.Box.Filler fill_60;
    private javax.swing.Box.Filler fill_61;
    private javax.swing.Box.Filler fill_62;
    private javax.swing.Box.Filler fill_63;
    private javax.swing.Box.Filler fill_64;
    private javax.swing.Box.Filler fill_65;
    private javax.swing.Box.Filler fill_66;
    private javax.swing.Box.Filler fill_67;
    private javax.swing.Box.Filler fill_70;
    private javax.swing.Box.Filler fill_71;
    private javax.swing.Box.Filler fill_72;
    private javax.swing.Box.Filler fill_73;
    private javax.swing.Box.Filler fill_74;
    private javax.swing.Box.Filler fill_75;
    private javax.swing.Box.Filler fill_76;
    private javax.swing.Box.Filler fill_77;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pecesj1;
    private javax.swing.JLabel pecesj2;
    private javax.swing.JLabel pj1;
    private javax.swing.JLabel pj2;
    // End of variables declaration//GEN-END:variables
}
