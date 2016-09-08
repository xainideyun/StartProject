using System;
using System.Windows.Forms;

namespace Practice1
{
    public partial class Form2 : Form
    {
        public event Action<object, string> SearchKey;
        private string _key;
        public Form2()
        {
            InitializeComponent();
            
        }
        private void btnSearch_Click(object sender, EventArgs e)
        {
            SearchKey?.Invoke(this, txtKey.Text);
        }
    }
}
