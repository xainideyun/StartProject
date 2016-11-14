using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02
{
    class Program
    {
        public const Student s = null;
        static void Main(string[] args)
        {
            //{
            //    byte b = unchecked((byte)'擦');
            //    Console.WriteLine(string.Concat(new List<string>() { "34","323","defe" }));
            //    Console.WriteLine(b);
            //    Console.ReadKey();

            //BinaryWriter bw = new BinaryWriter(new FileStream("3.jpg", FileMode.OpenOrCreate));
            //var fs = new FileStream("1.jpg", FileMode.Open);
            //var buffer = new byte[1024 * 1024];
            //int read = 0;
            //while ((read = fs.Read(buffer,0,buffer.Length)) > 0)
            //{
            //    bw.Write(buffer, 0, read);
            //}
            //bw.Close();
            //fs.Close();

            Console.WriteLine("打印值：" + _03.Test1.MaxEntriesInList);
            Console.ReadKey();
            
        }
    }


    sealed class Student
    {
        public string Name { get; set; }
        public override bool Equals(object obj)
        {
            return base.Equals(obj);
        }
    }


}
