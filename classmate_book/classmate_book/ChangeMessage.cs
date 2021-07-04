using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace classmate_book
{
    public partial class ChangeMessage : Form
    {
        string id;
        public ChangeMessage(string number)
        {
            id = number;
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == " ")//修改正确！！！！
            {
                string connString = "Data Source= . ;Initial Catalog=campus; Integrated Security=true";// 创建 Connection 对象
                SqlConnection connection = new SqlConnection(connString);// 打开数据库连接
                connection.Open();

                string sql = "select sno from mate where sno=" + id;
                SqlDataAdapter da = new SqlDataAdapter(sql, connection);
                DataSet ds = new DataSet();
                da.Fill(ds);
                if (ds.Tables[0].Rows[0].ToString() == "")
                {
                    string info = textBox1.Text + "," + textBox3.Text + "," + textBox4.Text + "," + textBox5.Text + "," + textBox6.Text + "," + textBox7.Text + "," + textBox8.Text;
                    sql = "insert into mate(name,tel,email,wx_no,qq_no,addr,descript,sno values(" + info + ")";
                    SqlCommand cmd = new SqlCommand(sql, connection);  //用于执行SQL语句
                    cmd.ExecuteNonQuery();
                }
                else
                {
                    sql = "update mate set name='" + textBox1.Text + "',tel='" + textBox3.Text + "',addr='" + textBox7.Text + "',email='" + textBox4.Text + "',wx_no='" + textBox5.Text + "',qq_no='" + textBox6.Text + "',descript='" + textBox8.Text + "' where sno='" + id + "'";
                    SqlCommand cmd = new SqlCommand(sql, connection);  //用于执行SQL语句
                    cmd.ExecuteNonQuery();
                }
                User us = new User(id);
                this.Hide();
                us.Show();
                us.Left = this.Left;
                us.Top = this.Top;
            }
            else
            {
                MessageBox.Show("输入有误！", "提示");

            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            User us = new User(id);
            this.Hide();
            us.Show();
            us.Left = this.Left;
            us.Top = this.Top;
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void ChangeMessage_Load(object sender, EventArgs e)
        {
            string connString = "Data Source= . ;Initial Catalog=campus; Integrated Security=true";// 创建 Connection 对象
            SqlConnection connection = new SqlConnection(connString);// 打开数据库连接
            connection.Open();
            //姓名
            string command = "select name from mate where sno='" + id + "'";
            SqlDataAdapter da = new SqlDataAdapter(command, connection);
            DataSet ds1 = new DataSet();
            da.Fill(ds1);
            textBox1.Text = ds1.Tables[0].Rows[0][0].ToString();
            //班级
            command = "select class_name from mate,c where sno='" + id + "' and mate.class_id=c.class_id;";
            da = new SqlDataAdapter(command, connection);
            DataSet ds2 = new DataSet();
            da.Fill(ds2);
            textBox2.Text = ds2.Tables[0].Rows[0][0].ToString();
            //电话
            command = "select tel from mate where sno='" + id + "'";
            da = new SqlDataAdapter(command, connection);
            DataSet ds3 = new DataSet();
            da.Fill(ds3);
            textBox3.Text = ds3.Tables[0].Rows[0][0].ToString();
            //邮件
            command = "select email from mate where sno='" + id + "'";
            da = new SqlDataAdapter(command, connection);
            DataSet ds4 = new DataSet();
            da.Fill(ds4);
            textBox4.Text = ds4.Tables[0].Rows[0][0].ToString();
            //微信
            command = "select wx_no from mate where sno='" + id + "'";
            da = new SqlDataAdapter(command, connection);
            DataSet ds5 = new DataSet();
            da.Fill(ds5);
            textBox5.Text = ds5.Tables[0].Rows[0][0].ToString();
            //QQ
            command = "select qq_no from mate where sno='" + id + "'";
            da = new SqlDataAdapter(command, connection);
            DataSet ds6 = new DataSet();
            da.Fill(ds6);
            textBox6.Text = ds6.Tables[0].Rows[0][0].ToString();
            //家庭地址
            command = "select addr from mate where sno='" + id + "'";
            da = new SqlDataAdapter(command, connection);
            DataSet ds7 = new DataSet();
            da.Fill(ds7);
            textBox7.Text = ds7.Tables[0].Rows[0][0].ToString();
            //个性签名
            command = "select descript from mate where sno='" + id + "'";
            da = new SqlDataAdapter(command, connection);
            DataSet ds8 = new DataSet();
            da.Fill(ds8);
            textBox8.Text = ds8.Tables[0].Rows[0][0].ToString();

            connection.Close();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label8_Click(object sender, EventArgs e)
        {

        }
    }
}
