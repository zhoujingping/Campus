using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace classmate_book
{
    public partial class Welcome : Form
    {
        public Welcome()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Login log = new Login();
            log.Show();
            log.Left = this.Left;//form2的位置位于form1的左边，与form1并列
            log.Top = this.Top;//form2的上边缘与form1齐平
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Register reg = new Register();
            reg.Show();
            reg.Left = this.Left;
            reg.Top = this.Top;
        }
    }
}
