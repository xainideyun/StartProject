using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.XPath;

namespace _05XPath使用
{
    class Program
    {
        static void Main(string[] args)
        {
            string name = "孙小双";
            int age = 28;

            Console.WriteLine(nameof(File));

            var a = default(Student);
            a.Name = "孙小双";
            Console.WriteLine(a.Name);
            Console.Read();
        }
    }

    struct Student
    {
        public string Name { get; set; }
        public Student(string name)
        {
            this.Name = name;
        }
    }

}
