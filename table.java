

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


      
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Component;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class table {

   private JFrame frame;
   private JTable table1;

   public table() {
      initialize();
   }

   public void initialize() {
      frame = new JFrame();

      /* table */
      String[] columnType = { "Card Number", "Content", "Amount", "Price", "Date" };
      String[][] data = new String[][] { { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
            { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
            { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
            { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
            { "", "", "", "", "" }, { "", "", "", "", "" } };

      int count = 0;
      String inputFile = "Account_Book.txt";
      try {
         Scanner inputStream = new Scanner(new File(inputFile));
         String line;
         while (inputStream.hasNextLine()) {
            line = inputStream.nextLine();
            String[] ary = line.split(",");
            String Card_Number = ary[0];
            String Content = ary[1];
            String Amount = ary[2];
            String Price = ary[3];
            String Date = ary[4];

            data[count][0] = Card_Number;
            data[count][1] = Content;
            data[count][2] = Amount;
            data[count][3] = Price;
            data[count][4] = Date;
            count++;
         }
         inputStream.close();
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      frame.getContentPane().setLayout(null);

      JTable table = new JTable(data, columnType);
      JScrollPane scrollpane = new JScrollPane(table);
      scrollpane.setBounds(0, 70, 996, 428);
      frame.getContentPane().add(scrollpane);
      
      JButton goBackBtn = new JButton("Back");
      goBackBtn.setBounds(0, 10, 168, 50);
      frame.getContentPane().add(goBackBtn);
		goBackBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				//new MainMenu();
			}

		});
		
      frame.getContentPane().add(goBackBtn);
      frame.pack();
      frame.setVisible(true);

      frame.setBounds(100, 100, 1000, 630);
      frame.setTitle("Account Book");
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setPreferredSize(new Dimension(1000, 630));
      frame.setSize(1000, 630);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               table window = new table();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });

   }
}