using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestNinject
{
    public class ShowData : IShowData
    {
        public void Show()
        {
            Console.Write(this.GetType().FullName);
        }
    }
}
