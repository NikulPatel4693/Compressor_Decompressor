/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import COMP_DECOMP.Compressor;
import COMP_DECOMP.Decompressor;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class AppFrame extends JFrame implements ActionListener{
    JButton compress;
    JButton decompress;
    
    AppFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Compressor_Decompressor");
        this.setLayout(null);
        
        
        compress = new JButton("Select file to Compress");
        compress.setBounds(100, 200, 200, 50);
        compress.addActionListener(this);
        
        
        decompress = new JButton("Select file to Decompress");
        decompress.setBounds(450, 200, 200, 50);
        decompress.addActionListener(this);
        
        add(compress);
        add(decompress);
        setSize(800, 500);
        this.getContentPane().setBackground(Color.YELLOW);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compress){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
            
        }
        
        if(e.getSource()==decompress){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
            
        }
    }
}
