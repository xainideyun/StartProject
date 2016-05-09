using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using WcfInvoke;
using WcfServiceLib;

namespace WcfPractice
{
    public partial class WcfFirst : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            MyClient service = new MyClient(new WSHttpBinding(SecurityMode.Message),new EndpointAddress("http://localhost:9999") );
            lblName.Text = service.GetName();
        }
    }
}