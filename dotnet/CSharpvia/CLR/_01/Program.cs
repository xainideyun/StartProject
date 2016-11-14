using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MyFile = System.IO.File;

namespace _01
{
    class Program
    {
        static void Main(string[] args)
        {
            School s = new School();
            s.Name = "函数式";


            Console.WriteLine(s.Name);
            Console.ReadKey();
        }
    }
    namespace _02
    {
        class MyClass
        {

        }
    }
}
