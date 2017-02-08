using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace _06Practise
{
    class Program
    {
        static void Main(string[] args)
        {

            var a = DiyTuple.MinMax(222, 3);

            byte[] buffer = new byte[129 / 8];


            MyDic<string> bbb = new MyDic<string>() { { "dd", "ww" } };
            var ddd = Newtonsoft.Json.JsonConvert.SerializeObject(bbb);

            var data = new Tuple<string, int, string, KeyValuePair<string, int>>("孙小双", 28, "2071714117", new KeyValuePair<string, int>("语文", 78));

            var result = JsonConvert.SerializeObject(data);


            var d = new Tuple<string, int, string, string, string, string, string, Tuple<string, int, string, int>>("孙小双", 28, "2071714117", "sunxsh", "男", "篮球、足球", "我不愿让你一个人", new Tuple<string, int, string, int>("语文", 89, "数学", 130));
            var s = JsonConvert.SerializeObject(d);
            Console.WriteLine(s);
            
            

            Console.WriteLine(Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments));
            Console.ReadKey();
        }
        
    }

    class MyDic<TValue> : Dictionary<string, TValue>
    {
        public string Name { get; set; }
    }

    public delegate TResult Abc<in T, out TResult>(T g);


}
