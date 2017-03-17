using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12基本数据类型
{
    class Program
    {
        static void Main(string[] args)
        {
            char a = 'a';
            var b = char.GetUnicodeCategory(a);
            Console.WriteLine(b);
            Console.WriteLine(char.GetNumericValue('4'));

            Console.WriteLine(System.Globalization.CultureInfo.CurrentCulture);

            EcanConvertToCh aa = new EcanConvertToCh();
            var bb = aa.convertCh("孙小双");
            Console.WriteLine(bb);
            Console.Read();
        }
    }
}
