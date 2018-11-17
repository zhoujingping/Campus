using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Data.SqlClient;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace classmate_book
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {
            
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {
            this.textBox2.PasswordChar = '*';
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string userid = this.textBox1.Text;
            string password = this.textBox2.Text;
            if (userid.Equals("") || password.Equals(""))
            {
                MessageBox.Show("用户名或密码不能为空哦");
            }
            else//用户名密码非空
            {
                string connectionString = "Data Source= . ;Initial Catalog=campus; Integrated Security=true";
                SqlConnection SqlCon = new SqlConnection(connectionString);
                try
                {
                    SqlCon.Open();
                    string sql = "Select * from stu where sno='" + userid + "' and password='" + password + "'";
                    SqlCommand cmd = new SqlCommand(sql, SqlCon);
                    SqlDataReader read = cmd.ExecuteReader();     //cmd.CommandType = CommandType.Text;
                    if (read.Read())
                    {
                        MessageBox.Show("登录成功", "提示");
                        int rank = Convert.ToInt32(read["rank"]);
                        if (rank == 1)
                        {
                            User us = new User(userid);
                            this.Hide();
                            us.Show();
                            us.Left = this.Left;
                            us.Top = this.Top;
                        }
                        else if (rank == 2)
                        {
                            Manager mana = new Manager(userid);
                            this.Hide();
                            mana.Show();
                            mana.Left = this.Left;
                            mana.Top = this.Top;
                        }
                    }
                    else
                    {
                        MessageBox.Show("用户名或密码错误", "提示");
                        return;
                    }
                }
                catch (Exception) //当try中有错误则执行catch中的代码,否则不执行

                {

                    Console.WriteLine("网络异常!");

                }
                finally //无论如何都会执行finally中的代码
                {
                    if (SqlCon != null) //判断con不为空
                    {
                        SqlCon.Close();
                    }
                }
            }
        }


        private void button2_Click(object sender, EventArgs e)
        {
            Register reg = new Register();
            this.Hide();
            reg.Show();
            reg.Left = this.Left;//form2的位置位于form1的左边，与form1并列
            reg.Top = this.Top;//form2的上边缘与form1齐平

        }
    }

}


