using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02打开默认浏览器
{
    class Program
    {
        static void Main(string[] args)
        {
            Process.Start("http://www.baidu.com");
            Console.Read();
        }
    }
}
