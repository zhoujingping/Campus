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
    
    public partial class NewNotice : Form
    {
        string id;
        public NewNotice(string number )
        {
            id = number;
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            ManagerNotice m_notice = new ManagerNotice(id);
            this.Hide();
            m_notice.Show();
            m_notice.Left = this.Left;
            m_notice.Top = this.Top;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string massage = richTextBox1.Text;
            /*
             * 公告添加到数据库
            */
            if (richTextBox1.Text == "")
            {
                MessageBox.Show("输入不能为空！", "提示");
                return;
            }
            else if (richTextBox1.Text != "")
            {
                string connectionString = "Data Source= . ;Initial Catalog=campus; Integrated Security=true";
                SqlConnection SqlCon = new SqlConnection(connectionString);
                SqlCon.Open();
                SqlCommand cmd = new SqlCommand("insert into msg (details) values('" + richTextBox1.Text + "')", SqlCon);
                cmd.ExecuteNonQuery();
                SqlCon.Close();
                MessageBox.Show("公告发布成功！");
                ManagerNotice m_notice = new ManagerNotice(id);
                this.Hide();
                m_notice.Show();
                m_notice.Left = this.Left;
                m_notice.Top = this.Top;
            }

        }
    }
}