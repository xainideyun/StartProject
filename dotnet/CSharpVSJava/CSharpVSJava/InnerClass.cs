using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpVSJava
{
    public class InnerClass
    {
        private int num = 19;
        class Inner
        {
            void Show()
            {
                Console.WriteLine("我的数字是：");
            }
        }
    }
}
