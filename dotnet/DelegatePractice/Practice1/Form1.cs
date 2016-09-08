using System;
using System.Drawing;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;
using System.Windows.Forms;

namespace Practice1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            txtContent.SelectionColor = Color.Red;
        }

        private void txtRead_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.Filter = "文本文件(*.txt)|*.txt";
            if (ofd.ShowDialog() == DialogResult.OK)
            {
                using (FileStream fs = new FileStream(ofd.FileName,FileMode.Open, FileAccess.Read))
                {
                    byte[] buffer = new byte[1024 * 1024];
                    while (fs.Read(buffer, 0, buffer.Length) > 0)
                    {
                        txtContent.Text += Encoding.Default.GetString(buffer);
                    }
                }
            }
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            SaveFileDialog ofd = new SaveFileDialog();
            ofd.Filter = "文本文件(*.txt)|*.txt";
            if (ofd.ShowDialog() == DialogResult.OK)
            {
                using (FileStream fs = new FileStream(ofd.FileName,FileMode.Create, FileAccess.Write))
                {
                    byte[] buffer = Encoding.Default.GetBytes(txtContent.Text);
                    fs.Write(buffer, 0, buffer.Length);
                }
            }
        }

        private MatchCollection mc;
        private string _key;
        private int _index;
        private void btnSearch_Click(object sender, EventArgs e)
        {
            Form2 f2 = new Form2();
            f2.Show();
            f2.SearchKey += (a, b) => 
            {
                if (_key != b)
                {
                    _key = b;
                    mc = Regex.Matches(txtContent.Text, b);
                    if (mc.Count == 0)
                    {
                        MessageBox.Show("未找到指定文本...");
                        return;
                    }
                    _index = 0;
                }
                if (mc.Count == 0) return;
                txtContent.Focus();
                txtContent.SelectionStart = mc[_index].Index;
                txtContent.SelectionLength = b.Length;
                if (++_index == mc.Count) _index = 0;
            };
        }
        
    }
}
