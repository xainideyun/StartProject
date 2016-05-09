using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.ServiceModel.Description;
using System.Text;
using System.Threading.Tasks;
using WcfServiceLib;

namespace WcfConsole
{
    // 把Endpoint中的ABC，基地址，Behaviors等直接写在代码里，不依赖配置文件
    class Program
    {
        static void Main(string[] args)
        {
            Uri baseAddress = new Uri("http://localhost:9999/User");                    // 创建宿主的基地址
            using (ServiceHost host = new ServiceHost(typeof(User), baseAddress))
            {
                host.AddServiceEndpoint(typeof(IUser), new WSHttpBinding(), "");        // 向宿主中添加终结点
                ServiceMetadataBehavior smb = new ServiceMetadataBehavior();            // 将HttpGetEnabled数据设置为true
                smb.HttpGetEnabled = true;
                host.Description.Behaviors.Add(smb);                                    // 将行为添加到Behaviors中
                host.Open();                                                            // 打开宿主
                Console.WriteLine("开始监听9999端口");
                Console.Read();
                host.Close();
            }
        }
    }
}
