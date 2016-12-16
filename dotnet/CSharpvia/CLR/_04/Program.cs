using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04
{
    class Program
    {
        static void Main(string[] args)
        {
            Test t1 = new Test { Age = 29 };
            Test t2 = new Test { Age = 44 };
            Console.WriteLine((t1 + t2).Age);
            Console.WriteLine("-----------------------------");
            int b = t2;
            Console.WriteLine(b);
            Console.ReadKey();
        }
    }
}
