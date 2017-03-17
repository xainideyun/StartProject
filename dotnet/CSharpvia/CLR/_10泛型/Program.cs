using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10泛型
{
    class Program
    {
        static void Main(string[] args)
        {
            // Array
            var dts = new[] { DateTime.Now, new DateTime(2012, 3, 4), new DateTime(2019, 6, 8) };
            Array.Sort(dts);
            foreach (var item in dts)
            {
                Console.WriteLine(item);
            }
            

            // 开放、封闭类型
            var type = typeof(Dictionary<,>);
            
            Console.ReadKey();
        }
    }
}
