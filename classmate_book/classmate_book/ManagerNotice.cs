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
    public partial class ManagerNotice : Form
    {
        string id;
        public ManagerNotice(string number)
        {
            id = number;
            InitializeComponent();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            NewNotice notice = new NewNotice(id);
            this.Hide();
            notice.Show();
            notice.Left = this.Left;
            notice.Top = this.Top;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Manager notice = new Manager(id);
            this.Hide();
            notice.Show();
            notice.Left = this.Left;
            notice.Top = this.Top;
        }

        private void ManagerNotice_Load(object sender, EventArgs e)
        {
            string connectionString = "Data Source= . ;Initial Catalog=campus; Integrated Security=true";
            SqlConnection SqlCon = new SqlConnection(connectionString);
            SqlCon.Open();
            string sql = "Select details from msg";
            SqlDataAdapter da = new SqlDataAdapter(sql, SqlCon);
            DataSet ds = new DataSet();
            da.Fill(ds);
            richTextBox1.Text = ds.Tables[0].Rows[0][0].ToString();
            SqlCon.Close();
        }
    }
}
