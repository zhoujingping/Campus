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
            if(userid.Equals("")||password.Equals(""))
            {
                MessageBox.Show("用户名或密码不能为空哦");
            }
            else//用户名密码非空
            {
                string connectionString = "Data Source=(LocalDB)/MSSQLLocalDB;AttachDbFilename=C:/Users/b8440/Desktop/Campus-master/Classmate-book/classmate_book/classmate_book/campus.mdf;Integrated Security=True;Connect Timeout=30";
                SqlConnection SqlCon = new SqlConnection(connectionString);
                SqlCon.Open();
                string sql = "Select * from users where user_id='" + userid + "' and password='" + password + "'";
                SqlCommand cmd = new SqlCommand(sql, SqlCon);
                cmd.CommandType = CommandType.Text;
                SqlDataReader sdr;
                sdr = cmd.ExecuteReader();
                if (sdr.Read())         //从结果中找到
                {
                    MessageBox.Show("登录成功", "提示");
                    this.Close();
                    
                }
                else
                {
                    MessageBox.Show("用户名或密码错误", "提示");
                    return;
                }
            }
            }
        }

    }

   
