//Patient Information Form:
import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;
//SAVE Button:

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
  try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","avs");
Statement stmt=con.createStatement();
ResultSet rs=null;
int id=Integer.parseInt(jtf.getText());
String name =jtf1.getText();
int age=Integer.parseInt(jtf2.getText());
String address =jtf3.getText();
String admn =jtf4.getText();
String status =t9.getText();
String gen=null;
if (jrb2.isSelected())
gen="M";
if (jrb1.isSelected())
{
gen="F";
}
String proomno=jtf5.getText();
int dno=Integer.parseInt(jtf6.getText());
int phno=Integer.parseInt(jtf7.getText());
String stsql="insert into patient values("+id+",'"+name+"','"+gen+"',"+age+",'"+address+"','"+admn+"',"+dno+",'"+proomno+"','"+status+"',"+phno+")";
int rowsEffect=stmt.executeUpdate(stsql);
JOptionPane.showMessageDialog(this,"Record added");
}
catch(Exception e){
JOptionPane.showMessageDialog(this,e.getMessage());
}
}
/****BACK TO MAIN MENU Button:****/

   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new mai().setVisible(true);
         this.dispose();
}     


 
//Doctor Information Form:
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.*;
import javax.swing.JOptionPane;

//SAVE Button:
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","avs");
            Statement stmt=(Statement) con.createStatement();
            ResultSet rs=null;
int doc_no=Integer.parseInt(t1.getText());
 String name =t2.getText();
String speciality =t3.getText();
String stsql="insert into doctor values("+doc_no+",'"+name+"','"+speciality+"')";
           int rowsEffect=stmt.executeUpdate(stsql);
   JOptionPane.showMessageDialog(this,"Record added");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }                  

     
//BACK TO MAIN MENU Button:

   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new mai().setVisible(true);
         this.dispose();
}     


 
//Room Information Form:
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.*;
import javax.swing.JOptionPane;

//SAVE Button:
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
      try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","avs");
            Statement stmt=(Statement) con.createStatement();
            ResultSet rs=null;
            String roomtype=null;
if(gen.isSelected()){
    roomtype="general";
}
            if(pri.isSelected())
            {
                roomtype="private";
            }
            if(ot.isSelected())
            {
                roomtype="operation theatre";
}
            if(ic.isSelected())
            {
                roomtype="ICCU";
            }
   int noofbeds=Integer.parseInt(t2.getText());
             int charges=Integer.parseInt(t3.getText());
String roomno =t1.getText();
String stsql="insert into room values('"+roomno+"','"+roomtype+"',"+noofbeds+","+charges+")";
           int rowsEffect=stmt.executeUpdate(stsql);         JOptionPane.showMessageDialog(this,"Record added");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage())   }
    }                                    
//CLEAR  Button:

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        t1.setText("");
        t2.setText(null);
        t3.setText(null);

//BACK TO MAIN MENU Button:

   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new mai().setVisible(true);
         this.dispose();
}     



 
//Bed Information Form:
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

//SAVE Button:
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","avs");
            Statement stmt=(Statement) con.createStatement();
            ResultSet rs=null;
int bed_no=Integer.parseInt(t1.getText());
 String room_no =t2.getText();
            String status =t3.getText();
   int charges=Integer.parseInt(t4.getText());
String stsql="insert into bed values("+bed_no+",'"+room_no+"','"+status+"',"+charges+")";
           int rowsEffect=stmt.executeUpdate(stsql);
     JOptionPane.showMessageDialog(this,"Record added");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }                                        

//CLEAR Button:

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        t1.setText(null);
        t2.setText(null);
        t3.setText(null);
        t4.setText(null);
    }                     
 

//BACK TO MAIN MENU Button:

   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new mai().setVisible(true);
         this.dispose();
}     

 
//Discharge:

//Discharge Information Form:

//DISCHARGE Button:
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
try { Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","avs");
            Statement stmt=(Statement) con.createStatement();
            ResultSet rs=null;
            int r=Integer.parseInt(t6.getText());
     String stsql="select * from bed where status='available' && room_no="+(r)+" ";
     stmt=  (Statement) con.createStatement();
    rs=stmt.executeQuery(stsql);
    while(rs.next()){
    int charges =rs.getInt("charges");
    String status=rs.getString("status");
  t10.setText(""+charges);  
  t0.setText(status);
    }
}
catch (Exception e){
}
         }                           

//LOAD Button:

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         try{
             DefaultListModel model=(DefaultListModel)l1.getModel();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","avs");
            Statement stmt=(Statement) con.createStatement();
           
  ResultSet rs=null;
String stsql="select * from patient where status='available'";
    rs=stmt.executeQuery(stsql);
   while (rs.next()){
        int a=rs.getInt(1);
      String b=rs.getString(2);
          model.addElement(a+"-"+b);
   }
l1.setModel(model);
rs.close();
stmt.close();
con.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }                                        


//CLEAR  Button:
  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         t1.setText(null);
         t2.setText(null);
         t3.setText(null);
         t4.setText(null);
         t5.setText(null);
         t6.setText(null);
         t8.setText(null);
    }                    

//BACK TO MAIN MENU Button:
 
  private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
             new mai().setVisible(true);
              this.dispose();
}                               
 
//Report:
Patients List:
import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//DISPLAY Button:
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
try{
             Class.forName("com.mysql.jdbc.Driver");
             DefaultTableModel t=(DefaultTableModel)t1.getModel();
  Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","avs");
Statement st=con.createStatement();
String query="select * from patient";
ResultSet r=st.executeQuery(query);
while(r.next())
{
int a=r.getInt("p_id");
String b=r.getString(2);
String c=r.getString(3);
int d=r.getInt(4);
String f=r.getString(5);
String g=r.getString(6);
int h=r.getInt(7);
String i=r.getString(8);
String j=r.getString(9);
int k=r.getInt(10);
t.addRow(new Object[]{a,b,c,d,f,g,h,i,j,k});
}
t1.setModel(t);
r.close();
st.close();
con.close();
        }
      catch(Exception e){
JOptionPane.showMessageDialog(null,"Error in connection");
 }
    }                             

//BACK TO MAIN MENU Button:

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         new mai().setVisible(true);
         this.dispose();

//Doctors List:
private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {                                       
       try{
             Class.forName("com.mysql.jdbc.Driver");
             DefaultTableModel t=(DefaultTableModel)t1.getModel();
  Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","avs");
Statement st=(Statement) con.createStatement();
String query="select * from doctor";
ResultSet r=st.executeQuery(query);
while(r.next())
{
int a=r.getInt(1);
String b=r.getString(2);
String c=r.getString(3);
t.addRow(new Object[]{a,b,c});
}
t1.setModel(t);
r.close();
st.close();
con.close();
        }
        catch(Exception e){
JOptionPane.showMessageDialog(null,"Error in connection");
    }
    }                                      
//BACK TO MAIN MENU Button:
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new mai().setVisible(true);
        this.dispose();
}                         
//Room List & Bed List:
private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {                                       
          try{
             Class.forName("com.mysql.jdbc.Driver");
             DefaultTableModel t=(DefaultTableModel)t1.getModel();
  Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","avs");
Statement st=(Statement) con.createStatement();
String query="select * from room";
ResultSet r=st.executeQuery(query);
while(r.next())
{
 String a=r.getString(1);
 String b=r.getString(2);
int c=r.getInt(3);
int d=r.getInt(4);
t.addRow(new Object[]{a,b,c,d});
}
t1.setModel(t);
r.close();
st.close();
con.close();
        }
        catch(Exception e){
JOptionPane.showMessageDialog(null,"Error in connection");
    }
   try{
             Class.forName("com.mysql.jdbc.Driver");
             DefaultTableModel t=(DefaultTableModel)t2.getModel();
  Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","avs");
Statement st=(Statement) con.createStatement();
String query="select * from bed";
ResultSet r=st.executeQuery(query);
while(r.next())
{
    int a=r.getInt(1);
int b=r.getInt(2);
 String c=r.getString(3);


int d=r.getInt(4);
t.addRow(new Object[ ]{a,b,c,d});
}
t2.setModel(t);
r.close();
st.close();
con.close();
        }
        catch(Exception e){
JOptionPane.showMessageDialog(null,"Error in connection");
    }
    }                 
	
//BACK TO MAIN MENU Button:
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new mai().setVisible(true);
         this.dispose();
