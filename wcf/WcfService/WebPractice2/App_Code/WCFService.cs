using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Web;
using WCFInvoke;

namespace WebPractice2.App_Code
{
    public class WCFService
    {
        private static ServiceClient _WCFService;
        public static ServiceClient ClientService
        {
            get
            {
                if (_WCFService == null)
                {
                    _WCFService = new ServiceClient(new WSHttpBinding(SecurityMode.None), new EndpointAddress("http://192.168.196.132:9998"));
                }
                return _WCFService;
            }
        }
    }
}