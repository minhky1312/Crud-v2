package pack;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Crud extends JFrame {

    static DefaultTableModel model = new DefaultTableModel();
    static List<City> city = new ArrayList<City>();

    static String DB_URL = "jdbc:mysql://127.0.0.1:3306/crud";
    static String USER_NAME = "root";
    static String PASSWORD = "";

    public static void main(String[] args) {

        //List<City> city = new ArrayList<City>();

            Crud crud = new Crud();
            crud.setVisible(true);

        try{
            Connection myConn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement myStmt = myConn.createStatement();
            String sql = "select * from crudd";

            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String sname = rs.getNString("sname");
                String namee = rs.getNString("namee");
                String area = rs.getNString("area");
                String flag = rs.getNString("flag");

                City ct = new City(id,sname,namee,area,flag);
                city.add(ct);
                addrow(ct);
            }


      } catch (
    SQLException e) {
        System.out.println("connect failure!");
        e.printStackTrace();
    }

    }

    public Crud()
    {
        setBounds(300, 100, 1000, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();

        SpringLayout sl_contentPane = new SpringLayout();
        panel1.setLayout(sl_contentPane);

        JLabel lblog = new JLabel("Tỉnh/Thành phố");
        lblog.setFont(new Font("Serif",Font.CENTER_BASELINE,12));
        sl_contentPane.putConstraint(SpringLayout.EAST, lblog, 110, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.NORTH, lblog, 10, SpringLayout.WEST, panel1);
        panel1.add(lblog);

        JLabel lbid = new JLabel("Id");
        lblog.setFont(new Font("Serif",Font.CENTER_BASELINE,15));
        sl_contentPane.putConstraint(SpringLayout.SOUTH, lbid, 610, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, lbid, 110, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.NORTH, lbid, 10, SpringLayout.WEST, panel1);
        panel1.add(lbid);

        JLabel lbsname = new JLabel("Tên tóm tắt");
        lblog.setFont(new Font("Serif",Font.CENTER_BASELINE,15));
        sl_contentPane.putConstraint(SpringLayout.SOUTH, lbsname, 610, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, lbsname, 380, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.NORTH, lbsname, 10, SpringLayout.WEST, panel1);
        panel1.add(lbsname);


        JLabel lbarea = new JLabel("Khu vực");
        lblog.setFont(new Font("Serif",Font.CENTER_BASELINE,15));
        sl_contentPane.putConstraint(SpringLayout.SOUTH, lbarea, 810, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, lbarea, 110, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.NORTH, lbarea, 10, SpringLayout.WEST, panel1);
        panel1.add(lbarea);

        JLabel lbname = new JLabel("Tên");
        lblog.setFont(new Font("Serif",Font.CENTER_BASELINE,15));
        sl_contentPane.putConstraint(SpringLayout.SOUTH, lbname, 810, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, lbname, 380, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.NORTH, lbname, 10, SpringLayout.WEST, panel1);
        panel1.add(lbname);

        JTextField tfname = new JTextField();
        JScrollPane scrollPane2 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane2, 390, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane2, -90, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane2, 395, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane2, -420, SpringLayout.EAST, panel1);;

        panel1.add(scrollPane2);
        scrollPane2.setViewportView(tfname);


        JTextField tfsname = new JTextField();
        JScrollPane scrollPane5 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane5, 300, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane5, -180, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane5, 395, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane5, -420, SpringLayout.EAST, panel1);;

        panel1.add(scrollPane5);
        scrollPane5.setViewportView(tfsname);

        JTextField tfarea = new JTextField();
        JScrollPane scrollPane6 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane6, 390, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane6, -90, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane6, 125, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane6, -720, SpringLayout.EAST, panel1);;

        panel1.add(scrollPane6);
        scrollPane6.setViewportView(tfarea);


        JTextField tfflag = new JTextField();
        JScrollPane scrollPane7 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane7, 300, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane7, -180, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane7, 125, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane7, -720, SpringLayout.EAST, panel1);;

        panel1.add(scrollPane7);
        scrollPane7.setViewportView(tfflag);


        for (City ct : city) {
           addrow(ct);
           JOptionPane.showMessageDialog(null,ct.flag);
        }

        JTable crudtable = new JTable(model);

        model.addColumn("Mã tỉnh");
        model.addColumn("Tên viết tắt");
        model.addColumn("Tên");
        model.addColumn("Khu vực");
        model.addColumn("Trạng thái");

        Setboundtable(crudtable);



        String column[]= {"Mã tỉnh","Tên viết tắt","Tên","Khu vực","Trạng thái","Thao tác"};


        JScrollPane scrollPane4 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane4, 50, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane4, -300, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane4, 30, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane4, -170, SpringLayout.EAST, panel1);;
        panel1.add(scrollPane4);
        scrollPane4.setViewportView(crudtable);

        JButton delete = new JButton("Xóa");
        delete.setBackground(Color.pink);
        delete.setForeground(Color.WHITE);
        JScrollPane scrollPane3 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane3, 50, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane3, -420, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane3, 830, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane3, -50, SpringLayout.EAST, panel1);;
        scrollPane3.setViewportView(delete);
        panel1.add(scrollPane3);

        JButton fix = new JButton("Sửa");
        fix.setBackground(Color.pink);
        fix.setForeground(Color.WHITE);
        JScrollPane scrollPane1 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane1, 110, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane1, -360, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane1, 830, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane1, -50, SpringLayout.EAST, panel1);;
        scrollPane1.setViewportView(fix);
        panel1.add(scrollPane1);

        JButton ok = new JButton("Ok");
        ok.setBackground(Color.pink);
        ok.setForeground(Color.WHITE);
        JScrollPane scrollPane8 = new JScrollPane();
        sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane8, 170, SpringLayout.NORTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane8, -300, SpringLayout.SOUTH, panel1);
        sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane8, 830, SpringLayout.WEST, panel1);
        sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane8, -50, SpringLayout.EAST, panel1);;

        scrollPane8.setViewportView(ok);
        panel1.add(scrollPane8);

        delete.setVisible(false);
        fix.setVisible(false);
        ok.setVisible(false);
        ListSelectionModel slmodel = crudtable.getSelectionModel();
        slmodel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(! slmodel.isSelectionEmpty())
                {
                    int id;
                    delete.setVisible(true);
                    fix.setVisible(true);

                  //  JOptionPane.showMessageDialog(null,"a");
                   // model.addRow(new Object[] {id});
                }
            }
        });



        this.add(panel1);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRow = crudtable.getSelectedRows();
                deleterow(crudtable.getModel().getValueAt(selectedRow[0], 0).toString());
                model.removeRow(selectedRow[0]);
                tfarea.setText("");
                tfflag.setText("");
                tfname.setText("");
                tfsname.setText("");
                delete.setVisible(false);
                fix.setVisible(false);
                ok.setVisible(false);
            }
        });

        fix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRow = crudtable.getSelectedRows();
                tfflag.setText(crudtable.getModel().getValueAt(selectedRow[0], 4).toString());
                tfsname.setText(crudtable.getModel().getValueAt(selectedRow[0], 1).toString());
                tfname.setText(crudtable.getModel().getValueAt(selectedRow[0], 2).toString());
                tfarea.setText(crudtable.getModel().getValueAt(selectedRow[0], 3).toString());
                ok.setVisible(true);
            }
        });

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRow = crudtable.getSelectedRows();


                updaterow(crudtable.getModel().getValueAt(selectedRow[0],0).toString(),tfsname.getText(),tfname.getText(),tfarea.getText(),tfflag.getText());
                crudtable.setValueAt(tfsname.getText(),selectedRow[0],1);
                crudtable.setValueAt(tfname.getText(),selectedRow[0],2);
                crudtable.setValueAt(tfarea.getText(),selectedRow[0],3);
                crudtable.setValueAt(tfflag.getText(),selectedRow[0],4);
                tfarea.setText("");
                tfflag.setText("");
                tfname.setText("");
                tfsname.setText("");
                delete.setVisible(false);
                fix.setVisible(false);
                ok.setVisible(false);
            }
        });

    }

    public void Setboundtable(JTable tb)
    {
        tb.setRowHeight(35);
        TableColumn column = null;
        for (int i = 0;i <5;i++)
        {
            column = tb.getColumnModel().getColumn(i);
            if(i==2)
            {
                column.setPreferredWidth(100);
            }
            else
            {
                column.setPreferredWidth(50);
            }
        }
    }

    static  void addrow(City c)
    {
        model.addRow(new Object[] {c.id,c.sname,c.name,c.area,c.flag});

    }

    public void deleterow(String key) {
        try {
            Connection myConn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement myStmt = myConn.createStatement();

            String sql1 = "DELETE FROM crudd WHERE id = "+key ;
            myStmt.executeUpdate(sql1);
        } catch (
                SQLException e) {
            System.out.println("connect failure!");
            e.printStackTrace();
        }
    }
    public void updaterow(String key,String sname,String name,String area,String flag)
    {
        try {
            Connection myConn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement myStmt = myConn.createStatement();

            String sql1 = "UPDATE crudd " +
                          "SET sname = '"+sname+ "', "
                              +"namee = '"+name+ "', "
                              +"area = '"+area+ "', "
                              +"flag = '"+flag+ "' "
                              +"WHERE id = "+key;

            myStmt.executeUpdate(sql1);
        } catch (
                SQLException e) {
            System.out.println("connect failure!");
            e.printStackTrace();
        }
    }
}
