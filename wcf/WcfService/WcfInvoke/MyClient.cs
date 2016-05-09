using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.ServiceModel.Channels;
using System.Text;
using System.Threading.Tasks;
using WcfServiceLib;

namespace WcfInvoke
{
    public class MyClient : ClientBase<IUser>, IUser
    {
        public MyClient(Binding binding, EndpointAddress edpAddr) : base(binding, edpAddr)
        {

        }

        public string GetName()
        {
            return base.Channel.GetName();
        }
    }
}
