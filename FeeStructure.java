package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

    public class FeeStructure extends JFrame implements ActionListener {
        FeeStructure(){
            getContentPane().setBackground(Color.WHITE);

            JLabel heading = new JLabel("Fee Structure");
            heading.setBounds(400,10,400,30);
            heading.setFont(new Font("Tahoma", Font.BOLD, 30));
            add(heading);

            JTable table = new JTable();

            try {
             DatabaseConnection c = new DatabaseConnection();
                ResultSet resultSet = c.st.executeQuery("select * from fee");
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch (Exception e){
                e.printStackTrace();
            }

            JScrollPane js = new JScrollPane(table);
            js.setBounds(0,60,1000,700);
            add(js);



            setSize(1000, 700);
            setLocation(250,50);
            setLayout(null);
            setUndecorated(true);
            setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }

        public static void main(String[] args) {
            new FeeStructure();
        }
    }

