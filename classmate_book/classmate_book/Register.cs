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
    public partial class Register : Form
    {
        public Register()
        {
            InitializeComponent();
        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox3.Text == "" || textBox5.Text == "" || textBox6.Text == "")
            {
                MessageBox.Show("输入不能为空！", "提示");
                textBox5.Text = "";
                textBox6.Text = "";
                return;
            }

            else if (textBox5.TextLength < 6 || textBox5.TextLength > 16)
            {
                MessageBox.Show("密码不符合标准！", "提示");
                return;
            }
            else if (textBox5.Text != textBox6.Text)
            {
                MessageBox.Show("二次密码不一致，请重新输入！", "提示");
                textBox5.Text = "";
                textBox6.Text = "";
                return;
            }
            else if (textBox5.Text == textBox6.Text)
            {
                //执行sql向数据库插入新的注册信息。
                string connectionString = "Data Source= . ;Initial Catalog=campus; Integrated Security=true";
                SqlConnection SqlCon = new SqlConnection(connectionString);
                SqlCon.Open();
                SqlCommand cmd = new SqlCommand("insert into stu (sno,password,rank) values('" + textBox3.Text + "','" + textBox5.Text + "','1')", SqlCon);
                cmd.ExecuteNonQuery();
                SqlCon.Close();
                //注册成功
                MessageBox.Show("注册成功φ(*￣0￣)′");
                User us = new User(textBox3.Text);
                this.Hide();
                us.Show();
                us.Left = this.Left;
                us.Top = this.Top;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Login log = new Login();
            this.Hide();
            log.Show();
            log.Left = this.Left;
            log.Top = this.Top;
        }




    }
}