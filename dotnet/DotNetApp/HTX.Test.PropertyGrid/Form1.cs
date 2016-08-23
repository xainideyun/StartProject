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

namespace HTX.Test.PropertyGrid
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            pgTable.SelectedObject = new SqlConnectionStringBuilder();
        }

        private void btnClick_Click(object sender, EventArgs e)
        {
            MessageBox.Show((pgTable.SelectedObject as SqlConnectionStringBuilder).ConnectionString);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            using (SqlConnection conn = new SqlConnection("Data Source=.;Initial Catalog=H3;User ID=sa;Password=sa"))
            {
                conn.Open();
                using (SqlCommand command = conn.CreateCommand())
                {
                    command.CommandText = "select * from T_Student where id=@id and name=@name";
                    command.Parameters.AddWithValue("id", "1");
                    command.Parameters.AddWithValue("name", "孙小双");
                    var a = command.ExecuteReader();
                    var dt = new DataTable();
                    dt.Load(a);
                }
            }

        }
    }
}
