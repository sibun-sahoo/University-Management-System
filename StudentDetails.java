package university.management.system;

import com.mysql.cj.exceptions.DataReadException;
import com.mysql.cj.xdevapi.Table;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentDetails extends JFrame implements ActionListener {

    Choice choice;
    JTable table;
    JButton print , search , update , add , cancel ;

    StudentDetails() {
        getContentPane().setBackground(new Color(210 , 252 , 218));

        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(30,20,150,20);
        add(heading);

        choice = new Choice();
        choice.setBounds(180 , 20, 150,20);
        add(choice);

        try {

            DatabaseConnection conn = new DatabaseConnection();
            ResultSet resultSet = conn.st.executeQuery("select * from student");
            while (resultSet.next()) {
                choice.add(resultSet.getString("rollno"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        table = new JTable();
        try {

            DatabaseConnection conn = new DatabaseConnection();
            ResultSet resultSet = conn.st.executeQuery("select * from student");
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
        setUndecorated(true);
        setSize(1200,800);
        setLocation(200 , 80);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == search) {
            String q = "select * from student where rollno = '"+choice.getSelectedItem()+"' ";
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
            new Add_Student();

        } else if (e.getSource() == update) {
            setVisible(false);
            new UpdateStudent();
        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new StudentDetails();
    }

}
