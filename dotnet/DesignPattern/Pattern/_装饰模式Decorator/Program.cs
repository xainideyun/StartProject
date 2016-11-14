using _装饰模式Decorator.App_Code;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace _装饰模式Decorator
{
    class Program
    {
        static void Main(string[] args)
        {
            Person p = new Person("孙小双");
            var b = new TShit(p);
            var c = new Chenshan(b);
            var d = new Labaku(c);
            d.Operation();
            
            Console.Read();

        }
    }
}
