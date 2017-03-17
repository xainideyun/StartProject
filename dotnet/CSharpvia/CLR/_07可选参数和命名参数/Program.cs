using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace _07可选参数和命名参数
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = default(DateTime);

            var x = "你好吗";
            var y = "你在吗";

            WriteLine($@"x:{x},y:{y}");

            var ccc = new DateTime(2015, 3, 6);
            Console.WriteLine((DateTime.Now - ccc).Days / 365);

            WriteLine(a);

            Console.WriteLine(M1(1, 2, 4, 5, 6));

            Console.WriteLine(M1(a: 2, b: 4, e: new[] { 2, 3, 4, 5 }));
            
            ReadKey();
        }

        public static int M1(int a, int b, int c = 2, int d = 5, params int[] e)
        {
            var total = a + b + c + d;
            if (e != null)
                total += e.Sum(x => x);
            return total;
        }
    }
}
