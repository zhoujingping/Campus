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
    public partial class DeleteUser : Form
    {
        string id;
        public DeleteUser(string number)
        {
            id = number;
            InitializeComponent();
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void DeleteUser_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Manager manager = new Manager(id);
            this.Hide();
            manager.Show();
            manager.Left = this.Left;
            manager.Top = this.Top;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string connString = "Data Source= . ;Initial Catalog=campus; Integrated Security=true";// 创建 Connection 对象
            SqlConnection connection = new SqlConnection(connString);// 打开数据库连接
            connection.Open();

            string sno = "";
            string dl = richTextBox1.Text;
            int length = dl.Length;
            for (int i = 0; i < length; i++)
            {
                char c = dl[i];
                if (c == ';')
                {
                    string sql = "delete from mate where sno='" + sno + "'";
                    SqlCommand cmd = new SqlCommand(sql, connection);  //用于执行SQL语句
                    cmd.ExecuteNonQuery();
                    sno = "";
                }
                else
                {
                    sno += c;
                }
            }
        }
    }
}
