using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading.Tasks;

namespace _03类的序列化与反序列化
{
    class Program
    {
        static void Main(string[] args)
        {
            /* 序列化
             
            Person p = new Person();
            p.Name = "孙小双";
            p.Age = 28;
            BinaryFormatter bf = new BinaryFormatter();

            using (Stream file = new FileStream("myFile.sunxsh", FileMode.Create, FileAccess.Write))
            {
                bf.Serialize(file, p);
            }
            */

            /* 反序列化
             
            */
            BinaryFormatter bf = new BinaryFormatter();
            using (Stream s = new FileStream("myFile.sunxsh",FileMode.Open, FileAccess.Read))
            {
                var p = bf.Deserialize(s) as Person;
                Console.WriteLine(p.Name);
                Console.WriteLine(p.Age);
            }
            Console.Read();
        }
    }
}
