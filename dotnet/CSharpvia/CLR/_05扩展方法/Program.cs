using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _05扩展方法
{
    class Program
    {
        static void Main(string[] args)
        {
            Action<object> action = a => Console.WriteLine(a.GetType());
            action.ActionExtend<FieldAccessException>(null);

            var bbb = Regex.Match("[sunxsh]", "\\[(\\w+)\\]");
            Console.WriteLine(bbb.Groups[1].Value);
            Test3 t = new Test3();          // 分部方法
            t.Name = "孙小双";
            t.Name = "万星辉";
            t.Name = "李娟娟";
            t.Name = "李怡然";
            Console.WriteLine(t.Name + "...." + t.Count);

            Console.WriteLine(".....................................");
            MyHandler s = (a, b, c) =>      // 默认参数
            {
                c = new Test3();
                return new Test3();
            };
            s();
            Console.WriteLine(Test3.T3.Name);

            Console.ReadKey();
        }
        
    }
}
