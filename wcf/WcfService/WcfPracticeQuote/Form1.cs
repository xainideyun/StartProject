using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WcfInvoke;

namespace WcfPracticeQuote
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnGet_Click(object sender, EventArgs e)
        {
            //WcfQuote.UserClient uc = new WcfQuote.UserClient();
            //lblText.Text = uc.GetName();
            //lblText.Text+= 
        }

        private void btnGet2_Click(object sender, EventArgs e)
        {
            MyClient service = new MyClient(new WSHttpBinding(SecurityMode.None),new EndpointAddress("http://localhost:9999"));
            lblText2.Text = service.GetName();
            service.GetEmail();
        }
    }
}
