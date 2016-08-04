using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestNinject
{
    class TestDemo1
    {
        static TestDemo1()
        {
            Console.WriteLine("静态构造函数");
        }
        public static void Show()
        {
            Console.WriteLine("输出...");
            
        }

    }


    abstract class Sunxsh
    {
        public static string Name { get; set; }
        public abstract void Show();
    }

    class Lijuanjuan : Sunxsh
    {
        public override void Show()
        {
            Console.WriteLine("my name is " + Name);
        }
    }


}




