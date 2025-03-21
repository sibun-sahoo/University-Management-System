package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Add_Student extends JFrame implements ActionListener {

    JTextField textName , textFname , textAddress , textPhone , textEmail , textM10 , textM12 , textAadhar;
    JLabel empText;
    JComboBox comboCourse, comboDept;
    JButton submit , cancel ;


    Random ran = new Random();
    long f4 = Math.abs( (ran.nextLong() % 9000L) + 1000L );

    JDateChooser cdob;
    Add_Student() {


        getContentPane().setBackground(new Color(128,176,255));

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif" , Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        textName = new JTextField();
        textName.setBounds(200,150,170,30);
        add(textName);


        JLabel fname = new JLabel("Father Name");
        fname.setFont(new Font("serif",Font.BOLD,20));
        fname.setBounds(500,150,200,30);
        add(fname);

        textFname = new JTextField();
        textFname.setBounds(700,150,170,30);
        add(textFname);


        JLabel empID = new JLabel("Employee ID");
        empID.setFont(new Font("serif",Font.BOLD,20));
        empID.setBounds(50,200,200,30);
        add(empID);

        empText = new JLabel("LITU9O"+f4);
        empText.setBounds(200,200,170,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);


        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(500,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(700,200,170,30);
        add(cdob);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200,250,170,30);
        textAddress.setFont(new Font("serif",Font.BOLD,20));
        add(textAddress);


        JLabel phone = new JLabel("Phone");
        phone.setBounds(500,250,200,30);
        phone.setFont(new Font("serif", Font.BOLD,20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(700,250,170,30);
        textPhone.setFont(new Font("serif", Font.BOLD,20));
        add(textPhone);

        JLabel email = new JLabel("Email");
        email.setFont(new Font("serif" , Font.BOLD,20));
        email.setBounds(50,300,200,30);
        add(email);

        textEmail = new JTextField();
        textEmail.setFont(new Font("serif" , Font.BOLD,20));
        textEmail.setBounds(200,300,170,30);
        add(textEmail);

        JLabel m10 = new JLabel("Class x (%)");
        m10.setFont(new Font("serif", Font.BOLD,20));
        m10.setBounds(500,300,200,30);
        add(m10);

        textM10 = new JTextField();
        textM10.setFont(new Font("serif" , Font.BOLD,20));
        textM10.setBounds(700,300,170,30);
        add(textM10);

        JLabel m12 = new JLabel("Class xii (%)");
        m12.setFont(new Font("serif", Font.BOLD,20));
        m12.setBounds(50,350,200,30);
        add(m12);

        textM12 = new JTextField();
        textM12.setFont(new Font("serif" , Font.BOLD,20));
        textM12.setBounds(200,350,170,30);
        add(textM12);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setFont(new Font("serif" , Font.BOLD,20));
        aadhar.setBounds(500,350,200, 30);
        add(aadhar);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("serif", Font.BOLD, 20));
        textAadhar.setBounds(700,350,170,30);
        add(textAadhar);

        JLabel qualification = new JLabel("Course");
        qualification.setFont(new Font("serif", Font.BOLD,20));
        qualification.setBounds(50,400,200,30);
        add(qualification);

        String course[] = {"BA" , "BCOM" , "BSC" , "BTECH" , "MA" , "MCA" , "MCOM", "MSC" , "MTECH"};
        comboCourse = new JComboBox(course);
//        comboCourse.setFont(new Font("serif" , Font.BOLD,10));
        comboCourse.setBackground(Color.WHITE);
        comboCourse.setBounds(200,400,170,30);
        add(comboCourse);

        JLabel department = new JLabel("Branch");
        department.setFont(new Font("serif", Font.BOLD,20));
        department.setBounds(500,400,200,30);
        add(department);

        String dept[] = {"Computer Science ", "Elctronics","Civil","IT"};
        comboDept = new JComboBox(dept);
//        comboCourse.setFont(new Font(" serif" , Font.BOLD,10));
        comboDept.setBackground(Color.WHITE);
        comboDept.setBounds(700,400,170,30);
        add(comboDept);


        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(550,550,120,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);



        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);

    }


    private void clearFieldsAndRefresh() {
        textName.setText("");
        textFname.setText("");
        ((JTextField) cdob.getDateEditor().getUiComponent()).setText("");
        textAddress.setText("");
        textPhone.setText("");
        textEmail.setText("");
        textM10.setText("");
        textM12.setText("");
        textAadhar.setText("");
        comboCourse.setSelectedIndex(0); // Reset course selection
        comboDept.setSelectedIndex(0);   // Reset department selection

        // Regenerate a new Student ID
        long newEmpId = Math.abs((ran.nextLong() % 9000L) + 1000L);
        empText.setText("LITU9S" + newEmpId);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submit ) {
            String name = textName.getText();
            String fname = textFname.getText();
            String empid = empText.getText();
            String dob = ((JTextField)cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String x = textM10.getText();
            String xii = textM12.getText();
            String aadhar = textAadhar.getText();
            String course = (String)comboCourse.getSelectedItem();
            String  branch = (String)comboDept.getSelectedItem();

            String query2 = "insert into student values ('"+name+"','"+fname+"' , '"+empid+"' , '"+dob+"' , '"+address+"' , '"+phone+"' , '"+email+"' , '"+x+"' , '"+xii+"' , '"+aadhar+"' , '"+course+"' , '"+branch+"'  )" ;


            try{
                if(x.equals("") || xii.equals("") || aadhar.equals("") || phone.equals("") || name.equals("")) {
                    JOptionPane.showMessageDialog(null,"Fill all the detils");
                }
                else {
                    DatabaseConnection conn2 = new DatabaseConnection();
                    conn2.st.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
//                    setVisible(false);

                    clearFieldsAndRefresh();
                }
            } catch (Exception E) {
                E.printStackTrace();
            }


        } else if(e.getSource() == cancel){
//            new StudentDetails();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Add_Student();
    }

}
