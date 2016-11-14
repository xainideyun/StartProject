using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace _04类对象序列化为xml与反序列化xml为类对象
{
    class Program
    {
        static void Main(string[] args)
        {
            /* 序列化
                 
            Person p = new Person();
            p.Hobby.Add("篮球");
            p.Hobby.Add("足球");
            p.Hobby.Add("电子竞技");
            p.Hobby.Add("游泳");
            p.Hobby.Add("下棋");
            XmlSerializer xs = new XmlSerializer(typeof(Person));
            using (Stream s = new FileStream("MyXML.xml", FileMode.Create, FileAccess.Write))
            {
                xs.Serialize(s, p);
            }
            */
            /* 反序列化
                 
            */
            using (Stream s = new FileStream("MyXML.xml", FileMode.Open, FileAccess.Read))
            {
                XmlSerializer xs = new XmlSerializer(typeof(Person));
                var p = xs.Deserialize(s) as Person;
                Console.WriteLine(p.Name);
                Console.WriteLine(p.Age);
                Console.WriteLine(p.Code);
                Console.WriteLine(p.School);
                Console.WriteLine(p.Hobby[0]);
            }
            

            Console.Read();

        }




    }
}
