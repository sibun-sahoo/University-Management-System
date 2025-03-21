package university.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

    public class StudentFeeForm extends JFrame implements ActionListener {
        Choice CrollNumber;
        JComboBox courseBox, departmentBox, semesterBox;

        JLabel totalAmount;
        JButton pay, amount, back;
        StudentFeeForm(){

            getContentPane().setBackground(new Color(210,252,251));

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fee.png"));
            Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel img = new JLabel(i3);
            img.setBounds(400,50,500,300);
            add(img);

            JLabel roolNumber = new JLabel("Select Roll Number");
            roolNumber.setBounds(40,60,150,20);
            roolNumber.setFont(new Font("Tahoma", Font.BOLD,12));
            add(roolNumber);

            CrollNumber = new Choice();
            CrollNumber.setBounds(200,60,150,20);
            add(CrollNumber);

            try{
                DatabaseConnection c = new DatabaseConnection();
                ResultSet rs = c.st.executeQuery("select * from student");
                while (rs.next()){
                    CrollNumber.add(rs.getString("rollno"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            JLabel name = new JLabel("Name");
            name.setBounds(40,100,150,20);
            add(name);

            JLabel textName = new JLabel();
            textName.setBounds(200,100,150,20);
            add(textName);

            JLabel fname = new JLabel("Father Name");
            fname.setBounds(40,140,150,20);
            add(fname);

            JLabel textfName = new JLabel();
            textfName.setBounds(200,140,150,20);
            add(textfName);

            try {
              DatabaseConnection c = new DatabaseConnection();
                String query = "select * from student where rollno='"+CrollNumber.getSelectedItem()+"'";
                ResultSet rs = c.st.executeQuery(query);
                while(rs.next()) {
                    textName.setText(rs.getString("name"));
                    textfName.setText(rs.getString("fname"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            CrollNumber.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent ie) {
                    try {
                        DatabaseConnection c = new DatabaseConnection() ;
                        String query = "select * from student where rollno='"+CrollNumber.getSelectedItem()+"'";
                        ResultSet rs = c.st.executeQuery(query);
                        while(rs.next()) {
                            textName.setText(rs.getString("name"));
                            textfName.setText(rs.getString("fname"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            JLabel Qualification = new JLabel("Course");
            Qualification.setBounds(40,180,150,20);
            //Qualification.setFont(new Font("Tahoma",Font.BOLD,16));
            add(Qualification);

            String course[] = {"BTech","BBA","BCA","BSC","MSC","MBA","MCA","MCom","MA","BA"};
            courseBox = new JComboBox(course);
            courseBox.setBounds(200,180,150,20);
            courseBox.setBackground(Color.WHITE);
            add(courseBox);

            JLabel Department = new JLabel("Branch");
            Department.setBounds(40,220,150,20);
            // Department.setFont(new Font("serif",Font.BOLD,16));
            add(Department);

            String department[] = {"Computer Science","Electronics","Mechanical","Civil","IT"};
            departmentBox = new JComboBox(department);
            departmentBox.setBounds(200,220,150,20);
            departmentBox.setBackground(Color.WHITE);
            add(departmentBox);

            JLabel textsemester = new JLabel("Semester");
            textsemester.setBounds(40,260,150,20);
            add(textsemester);

            String semester[] = {"semester1", "semester2", "semester3","semester4","semester5", "semester6", "semester7","semester8"};
            semesterBox = new JComboBox(semester);
            semesterBox.setBounds(200,260,150,20);
            add(semesterBox);

            JLabel total = new JLabel("Total Payable");
            total.setBounds(40,300,150,20);
            add(total);

            totalAmount = new JLabel();
            totalAmount.setBounds(200,300,150,20);
            add(totalAmount);

            amount = new JButton("Amount");
           amount.setBounds(30,380,100,25);
            amount.addActionListener(this);
            add(amount);

            pay = new JButton("Pay");
            pay.setBounds(150,380,100,25);
            pay.addActionListener(this);
            add(pay);

            back = new JButton("Back");
            back.setBounds(270,380,100,25);
            back.addActionListener(this);
            add(back);




            setSize(900,500);
            setLocation(300,100);
            setLayout(null);
            setUndecorated(true);
            setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == amount){
                String course = (String) courseBox.getSelectedItem();
                String semester = (String) semesterBox.getSelectedItem();
                try {
                    DatabaseConnection c = new DatabaseConnection();
                    ResultSet rs = c.st.executeQuery("select * from fee where course = '"+course+"'");
                    while(rs.next()) {
                        totalAmount.setText(rs.getString(semester));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            } else if ( e.getSource() == pay) {
                String rollno = CrollNumber.getSelectedItem();
                String course = (String) courseBox.getSelectedItem();
                String semester = (String) semesterBox.getSelectedItem();
                String branch = (String) departmentBox.getSelectedItem();
                String total = totalAmount.getText();

                try {
                    DatabaseConnection c = new DatabaseConnection();
                    String Q = "insert into feecollege values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                    c.st.executeUpdate(Q);
                    JOptionPane.showMessageDialog(null , "Fee Submitted successfully");
                }catch (Exception E){
                    E.printStackTrace();
                }
            }else {
                setVisible(false);
            }
        }

        public static void main(String[] args) {
            new StudentFeeForm();
        }
    }

