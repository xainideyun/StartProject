using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using WCFInvoke;
using System.ServiceModel;
using WebPractice2.App_Code;

namespace WebPractice2
{
    public partial class Test1 : System.Web.UI.Page
    {

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btn_Click(object sender, EventArgs e)
        {
            Response.Write(WCFService.ClientService.GetServiceName());
        }
        protected void btn2_Click(object sender, EventArgs e)
        {
            var person = WCFService.ClientService.GetBaseData(2);
            Response.Write("姓名：" + person.Name + "，年龄：" + person.Age);
        }
    }
}