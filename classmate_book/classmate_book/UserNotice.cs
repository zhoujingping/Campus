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
    public partial class UserNotice : Form
    {
        string id;
        public UserNotice(string number)
        {
            id = number;
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            User user = new User(id);
            this.Hide();
            user.Show();
        }

        private void UserNotice_Load(object sender, EventArgs e)
        {
            string connectionString = "Data Source= . ;Initial Catalog=campus; Integrated Security=true";
            SqlConnection SqlCon = new SqlConnection(connectionString);
            SqlCon.Open();
            string sql = "select top 1 * from msg order by datatime desc";
            SqlCommand cmd = new SqlCommand(sql, SqlCon);
            SqlDataReader read = cmd.ExecuteReader();
            if (read.Read())
            {
                string message = read["details"].ToString();
                richTextBox1.Text = message;
            }
            cmd.ExecuteNonQuery();
            SqlCon.Close();


        }
    }
}
