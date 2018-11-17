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
using Excel = Microsoft.Office.Interop.Excel;

namespace classmate_book
{
    public partial class User : Form
    {
        string id;
        public User(string number)
        {
            id = number;
            InitializeComponent();

            string connString = "Data Source= . ;Initial Catalog=campus; Integrated Security=true";
            // 创建 Connection 对象
            SqlConnection connection = new SqlConnection(connString);
            // 打开数据库连接
            connection.Open();
            string sql1 = "select name,sno,tel,addr,email,wx_no,qq_no,descript,class_name from mate,c where c.class_id=mate.class_id";
            SqlDataAdapter da1 = new SqlDataAdapter(sql1, connection);
            DataSet ds1 = new DataSet();
            da1.Fill(ds1);
            dataGridView1.DataSource = ds1.Tables[0];
            connection.Close();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Login log = new Login();
            this.Hide();
            log.Show();
            log.Left = this.Left;
            log.Top = this.Top;
        }

        private void button1_Click(object sender, EventArgs e)
        {
        }

        private void user_Load(object sender, EventArgs e)
        {

        }


        private void 查看公告ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            UserNotice uno = new UserNotice(id);
            this.Hide();
            uno.Show();
            uno.Left = this.Left;
            uno.Top = this.Top;
        }

        private void 个人信息ToolStripMenuItem_Click(object sender, EventArgs e)
        {

            ChangeMessage usrm = new ChangeMessage(id);
            this.Hide();
            usrm.Show();
            usrm.Left = this.Left;
            usrm.Top = this.Top;
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            string connString = "Data Source= . ;Initial Catalog=campus; Integrated Security=true";
            // 创建 Connection 对象
            SqlConnection connection = new SqlConnection(connString);
            // 打开数据库连接
            connection.Open();

            string s = textBox1.Text;
            if (s != "")
            {
                string sql1 = "select name,sno,tel,addr,email,wx_no,qq_no,descript,class_name from mate,c where sno=" + s + " and c.class_id=mate.class_id";
                SqlDataAdapter da1 = new SqlDataAdapter(sql1, connection);
                DataSet ds1 = new DataSet();
                if (ds1 != null)
                {
                    da1.Fill(ds1);
                    dataGridView1.DataSource = ds1.Tables[0];
                }
            }
            else
            {
                string sql1 = "select name,sno,tel,addr,email,wx_no,qq_no,descript,class_name from mate,c where c.class_id=mate.class_id";
                SqlCommand cmd = new SqlCommand(sql1, connection);  //用于执行SQL语句
                cmd.ExecuteNonQuery();
            }
            connection.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            string connString = "Data Source= . ;Initial Catalog=campus; Integrated Security=true";// 创建 Connection 对象
            SqlConnection connection = new SqlConnection(connString);// 打开数据库连接
            connection.Open();
            string command = "select name,sno,tel,addr,email,wx_no,qq_no,descript,class_name from mate,c where c.class_id=mate.class_id";
            SqlCommand sql = new SqlCommand(command, connection);

            DataTable dataset = new DataTable();
            SqlDataAdapter adapter = new SqlDataAdapter(sql);
            adapter.Fill(dataset);

            connection.Close();

            DataSetToExcel(dataset, "校友录.xls");
        }

        public static void DataSetToExcel(DataTable dataTable, string SaveFile)
        {
            Excel.Application excel;
            Excel._Workbook workBook;
            Excel._Worksheet workSheet;
            object misValue = System.Reflection.Missing.Value;
            excel = new Excel.Application();
            workBook = excel.Workbooks.Add(misValue);
            workSheet = (Excel._Worksheet)workBook.ActiveSheet;
            int rowIndex = 1;
            int colIndex = 0;
            //取得标题
            foreach (DataColumn col in dataTable.Columns)
            {
                colIndex++;
                excel.Cells[1, colIndex] = col.ColumnName;
            }
            //取得表格中的数据
            foreach (DataRow row in dataTable.Rows)
            {
                rowIndex++;
                colIndex = 0;
                foreach (DataColumn col in dataTable.Columns)
                {
                    colIndex++;
                    excel.Cells[rowIndex, colIndex] = row[col.ColumnName].ToString().Trim();
                    //设置表格内容居中对齐
                    workSheet.Range[excel.Cells[rowIndex, colIndex],
                      excel.Cells[rowIndex, colIndex]].HorizontalAlignment = Excel.XlVAlign.xlVAlignCenter;
                }
            }
            excel.Visible = false;
            workBook.SaveAs(SaveFile, Excel.XlFileFormat.xlWorkbookNormal, misValue,
                misValue, misValue, misValue, Excel.XlSaveAsAccessMode.xlExclusive,
                misValue, misValue, misValue, misValue, misValue);
            dataTable = null;
            workBook.Close(true, misValue, misValue);
            excel.Quit();
            releaseObject(workSheet);
            releaseObject(workBook);
            releaseObject(excel);
        }

        private static void releaseObject(object obj)
        {
            try
            {
                System.Runtime.InteropServices.Marshal.ReleaseComObject(obj);
                obj = null;
            }
            catch
            {
                obj = null;
            }
            finally
            {
                GC.Collect();
            }
        }
    }
}
