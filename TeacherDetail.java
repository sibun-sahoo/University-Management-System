package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherDetail extends JFrame implements ActionListener {

    Choice choice;
    JTable table;
    JButton print , search , update , add , cancel ;


    TeacherDetail() {

        getContentPane().setBackground(new Color(192 , 164 , 252));

        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(30,20,150,20);
        add(heading);

        choice = new Choice();
        choice.setBounds(180 , 20, 150,20);
        add(choice);

        try {

            DatabaseConnection conn = new DatabaseConnection();
            ResultSet resultSet = conn.st.executeQuery("select * from faculty");
            while (resultSet.next()) {
                choice.add(resultSet.getString("empid"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        table = new JTable();
        try {

            DatabaseConnection conn = new DatabaseConnection();
            ResultSet resultSet = conn.st.executeQuery("select * from faculty");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch(Exception e) {
            e.printStackTrace();
        }

        JScrollPane js = new JScrollPane(table);
        js.setBounds(30,100,1100,600);
        add(js);


        search = new JButton("Search");
        search.setBounds(30 , 70 , 80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(130 , 70 , 80,20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(230 , 70 , 80,20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(330 , 70 , 80,20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(430 , 70 , 80,20);
        cancel.addActionListener(this);
        add(cancel);



        setLayout(null);
        setSize(1200,800);
        setLocation(200 , 80);
        setUndecorated(true);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == search) {
            String q = "select * from faculty where empid = '"+choice.getSelectedItem()+"' ";
            try {
                DatabaseConnection conn2 = new DatabaseConnection();
                ResultSet resultSet2  = conn2.st.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet2));
            } catch(Exception E) {
                E.printStackTrace();
            }


        } else if(e.getSource() == print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if(e.getSource() == add) {
            setVisible(false);
            new Add_Faculty();

        } else if (e.getSource() == update) {
            setVisible(false);
            new UpdateTeacher();

        } else {
            setVisible(false);
        }


    }

    public static void main(String[] args) {
        new TeacherDetail();
    }
}
