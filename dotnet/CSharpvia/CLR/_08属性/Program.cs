using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08属性
{
    class Program
    {
        static void Main(string[] args)
        {
            //
            dynamic dic = new System.Dynamic.ExpandoObject();
            dic.Name = "孙小双";
            dic.Age = 28;
            dic.Code = "sunxsh";
            Console.WriteLine("打印动态类型结果...");
            foreach (KeyValuePair<string, object> item in dic)
            {
                Console.WriteLine(item.Key + "-" + item.Value);
            }
            //
            var tuple = Tuple.Create("孙小双", 28, "sunxsh");
            Console.WriteLine("打印Tuple类型结果...");
            Console.WriteLine(tuple.Item1);
            Console.WriteLine(tuple.Item2);
            Console.WriteLine(tuple.Item3);
            Console.ReadKey();
        }
    }
}
